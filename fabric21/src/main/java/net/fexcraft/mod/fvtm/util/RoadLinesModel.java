package net.fexcraft.mod.fvtm.util;

import net.fabricmc.fabric.impl.client.indigo.renderer.mesh.EncodingFormat;
import net.fabricmc.fabric.impl.client.indigo.renderer.mesh.MutableQuadViewImpl;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_LINES;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_MARKER4;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_PATTERN;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockModelPart;
import net.minecraft.client.renderer.block.model.BlockStateModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelDebugName;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;
import static net.fexcraft.mod.fvtm.model.block.BakedQuadData.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadLinesModel {

	public static class UnbakedLines implements BlockStateModel.UnbakedRoot {

		private ResourceLocation texmodel;

		public UnbakedLines(Block blk){
			texmodel = ResourceLocation.parse(blk.getID().space() + ":block/" + blk.getID().path());
		}

		@Override
		public BlockStateModel bake(BlockState state, ModelBaker baker){
			return new BakedLines(this, state, baker);
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

	public static class BakedLines implements BlockStateModel {

		private static ModelDebugName MDN = new ModelDebugName() {
			@Override
			public String debugName(){
				return "MDN";
			}
		};
		private TextureAtlasSprite sprite;
		private TextureAtlasSprite particle;
		private LineModelPart part;
		private BlockState state;

		public BakedLines(UnbakedLines root, BlockState blkst, ModelBaker baker){
			state = blkst;
			var model = baker.getModel(root.texmodel);
			sprite = baker.sprites().get(model.getTopTextureSlots().getMaterial("texture"), MDN);
			particle = baker.sprites().get(model.getTopTextureSlots().getMaterial("particle"), MDN);
			part = new LineModelPart(this);
		}

		@Override
		public void collectParts(RandomSource randomSource, List<BlockModelPart> list){
			list.add(part);
		}

		@Override
		public TextureAtlasSprite particleIcon(){
			return particle;
		}

	}

	public static class LineModelPart implements BlockModelPart {

		private static MutableQuad view = new MutableQuad();
		private BakedLines root;

		public LineModelPart(BakedLines lines){
			root = lines;
		}

		@Override
		public List<BakedQuad> getQuads(@Nullable Direction direction){
			int hei = root.state == null ? 0 : root.state.getValue(PROP_HEIGHT);
			boolean hl = root.state.getBlock() instanceof G_ROAD_LINES;
			double[][] uv = uv_full;
			if(hl){
				int lines = root.state.getValue(PROP_LINE_TYPE);
				int rot = root.state.getValue(PROP_LINE_ROT);
				uv = switch(lines){
					case 0 -> uv_ls2[rot];
					case 1 -> uv_lc2[rot];
					case 2 -> uv_l3[rot];
					case 3 -> uv_lf;
					default -> uv;
				};
			}
			else if(root.state.getBlock() instanceof G_ROAD_MARKER4){
				Direction dir = root.state.getValue(FACING);
				for(int i = 0; i < dir.get2DDataValue(); i++) uv = rotateL(uv);
			}
			else if(root.state.getBlock() instanceof G_ROAD_PATTERN){
				G_ROAD_PATTERN blk = (G_ROAD_PATTERN)root.state.getBlock();
				int x = root.state.getValue(blk.prop_x);
				int z = root.state.getValue(blk.prop_z);
				float us = 16f / blk.texx;
				float vs = 16f / blk.texz;
				uv = new double[][]{
					{ us * x + us,  vs * z },
					{ us * x,  vs * z },
					{ us * x,  vs * z + vs },
					{ us * x + us,  vs * z + vs }
				};
				Direction dir = root.state.getValue(FACING);
				uv = rotateU(uv);
				for(int i = 0; i < dir.get2DDataValue(); i++) uv = rotateL(uv);
			}
			List<BakedQuad> quads = new ArrayList<>();
			for(int i = 0; i < 4; i++){
				view.pos(i, new Vector3f((float)quad[i][0], (float)quad[i][1] - hei * sixteenth, (float)quad[i][2]));
				view.uv(i, new Vector2f(root.sprite.getU((float)uv[i][0] * sixteenth), root.sprite.getV((float)uv[i][1] * sixteenth)));
				view.color(i, 0xffffffff);
			}
			quads.add(view.toBakedQuad(root.sprite));
			view.clear();
			return quads;
		}

		@Override
		public boolean useAmbientOcclusion(){
			return false;
		}

		@Override
		public TextureAtlasSprite particleIcon(){
			return root.particle;
		}

	}

	public static class MutableQuad extends MutableQuadViewImpl {

		public MutableQuad(){
			data = new int[EncodingFormat.TOTAL_STRIDE];
		}

		@Override
		protected void emitDirectly(){
			//
		}

	}

}
