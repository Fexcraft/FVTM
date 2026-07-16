package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.AxisRotator;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.mod.fcl.util.Axis3DL;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.block.generated.PlainBase;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.Transforms;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.fvtm.model.content.BlockModel.BakedTransformData;
import net.fexcraft.mod.fvtm.model.program.BakedPrograms;
import net.fexcraft.mod.fvtm.util.BakingPlugin.MutableQuad;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.fexcraft.mod.fvtm.util.BakingPlugin.MDN;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BakedBlockModel {

	public static class UnbakedModel implements BlockStateModel.UnbakedRoot {

		private Identifier texmodel;

		public UnbakedModel(Block blk){
			texmodel = Identifier.parse(blk.getID().space() + ":block/" + blk.getID().path());
		}

		@Override
		public BlockStateModel bake(BlockState state, ModelBaker baker){
			return new BakedModel(state, baker);
		}

		@Override
		public Object visualEqualityGroup(BlockState blockState){
			return this;
		}

		@Override
		public void resolveDependencies(Resolver resolver){
			resolver.markDependency(texmodel);
		}

	}

	public static class BakedModel implements BlockStateModel {

		private BlockModelPart part;
		private BlockState state;

		private BakedPrograms.ColorSetter colorprog = null;
		private BakedPrograms.UVLock uvlockprog = null;
		private int uvrot;
		private HashMap<IDL, TextureAtlasSprite> textures = new HashMap<>();
		private Block block;
		private BlockModel model;
		private TextureAtlasSprite sprite;
		private Material.Baked particle;

		public BakedModel(BlockState blkst, ModelBaker baker){
			state = blkst;
			part = new BlockModelPart(this);
			Identifier rl = null;
			try{
				block = ((PlainBase)state.getBlock()).type;
				model = (BlockModel)block.getModel();
				rl = Identifier.tryParse(block.getDefaultTextures().get(0).colon().replace(".png", "").replace("textures/", ""));
				var res = baker.materials().get(new Material(rl, false), MDN);
				sprite = (particle = res).sprite();
				for(IDL dt : block.getDefaultTextures()){
					rl = Identifier.tryParse(dt.colon().replace(".png", "").replace("textures/", ""));
					res = baker.materials().get(new Material(rl, false), MDN);
					textures.put(dt, res.sprite());
					if(dt.name().equals("particle")) particle = res;
				}
			}
			catch(Exception e){
				FvtmLogger.log("BAKING ERROR AT: " + rl);
				e.printStackTrace();
			}
		}

		private TextureAtlasSprite getTex(String s){
			IDL idl = null;
			for(IDL tex : block.getDefaultTextures()){
				if(idl.name().equals(s)) idl = tex;
			}
			return textures.get(idl);
		}

		@Override
		public void collectParts(RandomSource random, List<BlockStateModelPart> output){
			output.add(part);
		}

		@Override
		public Material.Baked particleMaterial(){
			return particle;
		}

		@Override
		public int materialFlags(){
			return 0;
		}

	}

	public static class BlockModelPart implements BlockStateModelPart {

		private BakedModel root;

		public BlockModelPart(BakedModel lines){
			root = lines;
		}

		@Override
		public List<BakedQuad> getQuads(@Nullable Direction direction){
			List<BakedQuad> quads = new ArrayList<>();
			BakedTransformData bk = new BakedTransformData();
			try{
				ArrayList<ModelGroup> groups = getPolygons(root.model, StateWrapper.of(root.state));
				convertTransforms(root.model, bk, root.state);
				root.uvrot = BlockTypeImpl.getUvRot(root.state);
				TextureAtlasSprite texs = null;
				for(ModelGroup group : groups){
					root.colorprog = group.getProgram("fvtm:set_color");
					root.uvlockprog = group.getProgram("fvtm:baked_uv_lock");
					if(root.model.grouptexname){
						texs = root.getTex(group.name);
					}
					if(root.model.tg != null){
						if(root.model.tg.containsKey(group.name)) texs = root.getTex(root.model.tg.get(group.name));
						if(root.state != null){
							TextureAtlasSprite nsprite;
							String str;
							for(Property<?> prop : root.state.getProperties()){
								str = prop.getName() + "=" + root.state.getValue(prop) + "," + group.name;
								if(!root.model.tg.containsKey(str)) continue;
								nsprite = root.getTex(root.model.tg.get(str));
								if(nsprite != null){
									texs = nsprite;
									break;
								}
							}
						}
					}
					if(texs == null) texs = root.sprite;
					for(Polyhedron poly : group){
						bk.rot_poly.setAngles(-poly.rotY, -poly.rotZ, -poly.rotX);
						for(Polygon poli : poly.polygons){
							boolean tri = poli.vertices.length == 3;
							Vec3f vec0 = new Vec3f(poli.vertices[1].vector.sub(poli.vertices[0].vector));
							Vec3f vec1 = new Vec3f(poli.vertices[1].vector.sub(poli.vertices[2].vector));
							Vec3f vec2 = vec1.cross(vec0).normalize();
							vec2 = bk.rot_poly.getRelativeVector(vec2);
							if(root.model.defrot) vec2 = bk.rot_meta.getRelativeVector(vec2);
							if(bk.rot_tf != null) for(AxisRotator rot : bk.rot_tf) vec2 = rot.getRelativeVector(vec2);
							MutableQuad quad = new MutableQuad();
							quad.clear();
							addVertex(quad, 0, poly, poli, 0, vec2, texs, bk, root.colorprog);
							addVertex(quad, 1, poly, poli, 1, vec2, texs, bk, root.colorprog);
							addVertex(quad, 2, poly, poli, 2, vec2, texs, bk, root.colorprog);
							if(tri) addVertex(quad, 3, poly, poli, 2, vec2, texs, bk, root.colorprog);
							else addVertex(quad, 3, poly, poli, 3, vec2, texs, bk, root.colorprog);
							quads.add(quad.toBakedQuad(texs));
						}
					}
				}
				reset(root.model, StateWrapper.of(root.state));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return quads;
		}

		private void addVertex(MutableQuad quad, int vi, Polyhedron poly, Polygon poli, int vx, Vec3f norm, TextureAtlasSprite sprite, BakedTransformData bk, BakedPrograms.ColorSetter colorprog){
			Vertex vert = poli.vertices[vx];
			Vec3f vec = bk.rot_poly.getRelativeVector(vert.vector).add(poly.posX, poly.posY, poly.posZ);
			if(root.model.defrot) vec = bk.rot_meta.getRelativeVector(vec);
			if(bk.rot_tf != null) for(AxisRotator rot : bk.rot_tf) vec = rot.getRelativeVector(vec);
			quad.pos(vi,
				vec.x * bk.scale.x + bk.translate.x + 0.5f,
				vec.y * bk.scale.y + bk.translate.y,
				vec.z * bk.scale.z + bk.translate.z + 0.5f
			);
			quad.normal(vi, norm.x, norm.y, norm.z);
			if(colorprog == null){
				quad.color(vi, 0xffffffff);
			}
			else{
				quad.color(vi, colorprog.int_color + 0xff000000);
			}
			if(root.uvlockprog != null){
				float u, v;
				vx += root.uvrot;
				if(vx < 0) vx += 4;
				if(vx > 3) vx -= 4;
				u = poli.vertices[vx].u;
				v = poli.vertices[vx].v;
				quad.uv(vi, sprite.getU(u), sprite.getV(v));
			}
			else{
				quad.uv(vi, sprite.getU(vert.u), sprite.getV(vert.v));
			}
		}

		@Override
		public boolean useAmbientOcclusion(){
			return false;
		}

		@Override
		public Material.Baked particleMaterial(){
			return root.particle;
		}

		@Override
		public @BakedQuad.MaterialFlags int materialFlags(){
			return 0;
		}

	}

	public static ArrayList<ModelGroup> getPolygons(BlockModel model, StateWrapper state){
		ArrayList<ModelGroup> list = new ArrayList<>();
		for(ModelGroup group : model.groups){
			if(group.has_pre_prog){
				for(Program program : group.getPrePrograms()) program.pre(group, DefaultModel.RENDERDATA.set(null, null, state));
			}
			if(!group.visible) continue;
			list.add(group);
		}
		return list;
	}

	public static void reset(BlockModel model, StateWrapper state){
		for(ModelGroup group : model.groups){
			if(group.has_pst_prog){
				for(Program program : group.getPstPrograms()) program.post(group, DefaultModel.RENDERDATA.set(null, null, state));
			}
		}
	}

	public static void convertTransforms(BlockModel model, BakedTransformData bk, BlockState state){
		bk.rot_poly = new Axis3DL();
		bk.rot_meta = new Axis3DL();
		if(state != null){
			bk.rot_meta.setAngles(-(float)BlockTypeImpl.getRot(state), 0, 0);
		}
		if(model.transforms.hasRotate()){
			ArrayList<Transforms.TF_Rotate> list = model.transforms.getBakedRotate();
			bk.rot_tf = new AxisRotator[list.size()];
			for(int i = 0; i < list.size(); i++){
				Transforms.TF_Rotate rot = list.get(i);
				bk.rot_tf[i] = AxisRotator.newDefInstance();
				bk.rot_tf[i].setAngles(rot.y * -rot.angle, rot.z * -rot.angle, rot.x * -rot.angle);
			}
		}
		if(model.transforms.hasTranslate()){
			bk.translate = model.transforms.getBakedTranslate();
		}
		else bk.translate = new Vec3f();
		if(model.transforms.hasScale()){
			bk.scale = model.transforms.getBakedScale();
		}
		else bk.scale = new Vec3f(1, 1, 1);
		//
		for(ArrayList<BlockModel> val : model.state_models.values()){
			for(BlockModel v : val) convertTransforms(v, bk, state);
		}
	}

}
