package net.fexcraft.mod.fvtm.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.fexcraft.lib.common.math.AxisRotator;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.mod.fcl.util.Axis3DL;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.Transforms;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.fvtm.model.content.BlockModel.BakedTransformData;
import net.fexcraft.mod.fvtm.model.program.BakedPrograms;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.geometry.IGeometryBakingContext;
import net.minecraftforge.client.model.geometry.IGeometryLoader;
import net.minecraftforge.client.model.geometry.IUnbakedGeometry;
import net.minecraftforge.client.model.pipeline.QuadBakingVertexConsumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BakedModelLoader implements IGeometryLoader<BakedModelLoader.UnbakedGeo> {

	@Override
	public UnbakedGeo read(JsonObject json, JsonDeserializationContext context) throws JsonParseException {
		return new UnbakedGeo();
	}

	public static class UnbakedGeo implements IUnbakedGeometry<UnbakedGeo> {

		@Override
		public BakedModel bake(IGeometryBakingContext context, ModelBaker baker, Function<Material, TextureAtlasSprite> function, ModelState state, ItemOverrides overrides, ResourceLocation resloc){
			return new BakedGeo(function, resloc);
		}

	}

	public static class BakedGeo implements BakedModel {

		private static BakedPrograms.ColorSetter colorprog = null;
		private HashMap<IDL, TextureAtlasSprite> textures = new HashMap<>();
		private Block block;
		private BlockModel model;
		private TextureAtlasSprite sprite;
		private TextureAtlasSprite particle;

		public BakedGeo(Function<Material, TextureAtlasSprite> function, ResourceLocation rl){
			try{
				block = FvtmRegistry.BLOCKS.get(rl.toString().replace(":block/", ":"));
				model = (BlockModel)block.getModel();
				rl = ResourceLocation.tryParse(block.getDefaultTextures().get(0).colon().replace(".png", "").replace("textures/", ""));
				sprite = function.apply(new Material(TextureAtlas.LOCATION_BLOCKS, rl));
				particle = sprite;
				for(IDL dt : block.getDefaultTextures()){
					rl = ResourceLocation.tryParse(dt.colon().replace(".png", "").replace("textures/", ""));
					textures.put(dt, function.apply(new Material(TextureAtlas.LOCATION_BLOCKS, rl)));
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
		public List<BakedQuad> getQuads(BlockState state, Direction direction, RandomSource random){
			List<BakedQuad> quads = new ArrayList<>();
			BakedTransformData bk = new BakedTransformData();
			try{
				ArrayList<ModelGroup> groups = getPolygons(model, StateWrapper.of(state));
				BakedModelLoader.convertTransforms(model, bk, state);
				TextureAtlasSprite texs = null;
				for(ModelGroup group : groups){
					colorprog = group.getProgram("fvtm:set_color");
					if(model.grouptexname){
						texs = getTex(group.name);
					}
					if(model.tg != null){
						if(model.tg.containsKey(group.name)) texs = getTex(model.tg.get(group.name));
						if(state != null){
							TextureAtlasSprite nsprite;
							String str = null;
							for(Property<?> prop : state.getProperties()){
								str = prop.getName() + "=" + state.getValue(prop) + "," + group.name;
								if(!model.tg.containsKey(str)) continue;
								nsprite = getTex(model.tg.get(str));
								if(nsprite != null){
									texs = nsprite;
									break;
								}
							}
						}
					}
					if(texs == null) texs = this.sprite;
					for(Polyhedron poly : group){
						bk.rot_poly.setAngles(-poly.rotY, -poly.rotZ, -poly.rotX);
						for(Polygon poli : poly.polygons){
							boolean tri = poli.vertices.length == 3;
							Vec3f vec0 = new Vec3f(poli.vertices[1].vector.sub(poli.vertices[0].vector));
							Vec3f vec1 = new Vec3f(poli.vertices[1].vector.sub(poli.vertices[2].vector));
							Vec3f vec2 = vec1.cross(vec0).normalize();
							vec2 = bk.rot_poly.getRelativeVector(vec2);
							if(model.defrot) vec2 = bk.rot_meta.getRelativeVector(vec2);
							if(bk.rot_tf != null) for(AxisRotator rot : bk.rot_tf) vec2 = rot.getRelativeVector(vec2);
							QuadBakingVertexConsumer.Buffered baker = new QuadBakingVertexConsumer.Buffered();
							baker.setDirection(Direction.NORTH);
							baker.setSprite(texs);
							addVertex(baker, poly, poli.vertices[0], vec2, texs, bk, colorprog);
							addVertex(baker, poly, poli.vertices[1], vec2, texs, bk, colorprog);
							addVertex(baker, poly, poli.vertices[2], vec2, texs, bk, colorprog);
							if(tri) addVertex(baker, poly, poli.vertices[2], vec2, texs, bk, colorprog);
							else addVertex(baker, poly, poli.vertices[3], vec2, texs, bk, colorprog);
							quads.add(baker.getQuad());
						}
					}
				}
				BakedModelLoader.reset(model, StateWrapper.of(state));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return quads;
		}

		private void addVertex(QuadBakingVertexConsumer.Buffered builder, Polyhedron poly, Vertex vert, Vec3f norm, TextureAtlasSprite sprite, BakedTransformData bk, BakedPrograms.ColorSetter colorprog){
			Vec3f vec = vert.vector.add(poly.posX, poly.posY, poly.posZ);
			if(model.defrot) vec = bk.rot_meta.getRelativeVector(vec);
			if(bk.rot_tf != null) for(AxisRotator rot : bk.rot_tf) vec = rot.getRelativeVector(vec);
			builder.vertex(
				vec.x * bk.scale.x + bk.translate.x + 0.5f,
				vec.y * bk.scale.y + bk.translate.y,
				vec.z * bk.scale.z + bk.translate.z + 0.5f
			);
			builder.normal(norm.x, norm.y, norm.z);
			if(colorprog == null){
				builder.color(1f, 1f, 1f, 1f);
			}
			else{
				builder.color(colorprog.color[0], colorprog.color[1], colorprog.color[2], colorprog.color[3]);
			}
			builder.uv(sprite.getU(vert.u * 16), sprite.getV(vert.v * 16));
			builder.endVertex();
		}

		@Override
		public boolean useAmbientOcclusion(){
			return true;
		}

		@Override
		public boolean isGui3d(){
			return false;
		}

		@Override
		public boolean usesBlockLight(){
			return true;
		}

		@Override
		public boolean isCustomRenderer(){
			return false;
		}

		@Override
		public TextureAtlasSprite getParticleIcon(){
			return particle;
		}

		@Override
		public ItemOverrides getOverrides(){
			return ItemOverrides.EMPTY;
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
