package net.fexcraft.mod.fvtm.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_LINES;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_MARKER4;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_PATTERN;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.geometry.IGeometryBakingContext;
import net.minecraftforge.client.model.geometry.IGeometryLoader;
import net.minecraftforge.client.model.geometry.IUnbakedGeometry;
import net.minecraftforge.client.model.pipeline.QuadBakingVertexConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static net.fexcraft.lib.common.Static.*;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;
import static net.fexcraft.mod.fvtm.model.block.BakedQuadData.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadLinesModelLoader implements IGeometryLoader<RoadLinesModelLoader.UnbakedGeo> {

	@Override
	public UnbakedGeo read(JsonObject json, JsonDeserializationContext context) throws JsonParseException {
		return new UnbakedGeo();
	}

	public static class UnbakedGeo implements IUnbakedGeometry<UnbakedGeo> {

		@Override
		public BakedModel bake(IGeometryBakingContext context, ModelBaker baker, Function<Material, TextureAtlasSprite> function, ModelState state, ItemOverrides overrides, ResourceLocation resloc){
			return new BakedGeo(context, function);
		}

	}

	public static class BakedGeo implements BakedModel {

		private TextureAtlasSprite sprite;
		private TextureAtlasSprite particle;

		public BakedGeo(IGeometryBakingContext context, Function<Material, TextureAtlasSprite> function){
			sprite = function.apply(context.getMaterial("texture"));
			particle = function.apply(context.getMaterial("particle"));
		}

		@Override
		public List<BakedQuad> getQuads(BlockState state, Direction direction, RandomSource random){
			int hei = state == null ? 0 : state.getValue(PROP_HEIGHT);
			boolean hl = state.getBlock() instanceof G_ROAD_LINES;
			double[][] uv = uv_full;
			if(hl){
				int lines = state.getValue(PROP_LINE_TYPE);
				int rot = state.getValue(PROP_LINE_ROT);
				uv = switch(lines){
					case 0 -> uv_ls2[rot];
					case 1 -> uv_lc2[rot];
					case 2 -> uv_l3[rot];
					case 3 -> uv_lf;
					default -> uv;
				};
			}
			else if(state.getBlock() instanceof G_ROAD_MARKER4){
				Direction dir = state.getValue(FACING);
				for(int i = 0; i < dir.get2DDataValue(); i++) uv = rotateL(uv);
			}
			else if(state.getBlock() instanceof G_ROAD_PATTERN){
				G_ROAD_PATTERN blk = (G_ROAD_PATTERN)state.getBlock();
				int x = state.getValue(blk.prop_x);
				int z = state.getValue(blk.prop_z);
				float us = 16f / blk.texx;
				float vs = 16f / blk.texz;
				uv = new double[][]{
					{ us * x + us,  vs * z },
					{ us * x,  vs * z },
					{ us * x,  vs * z + vs },
					{ us * x + us,  vs * z + vs }
				};
				Direction dir = state.getValue(FACING);
				uv = rotateU(uv);
				for(int i = 0; i < dir.get2DDataValue(); i++) uv = rotateL(uv);
			}
			List<BakedQuad> quads = new ArrayList<>();
			QuadBakingVertexConsumer.Buffered baker = new QuadBakingVertexConsumer.Buffered();
			baker.setDirection(Direction.UP);
			baker.setSprite(sprite);
			addVertex(baker, quad[0], hei, uv[0][0], uv[0][1]);
			addVertex(baker, quad[1], hei, uv[1][0], uv[1][1]);
			addVertex(baker, quad[2], hei, uv[2][0], uv[2][1]);
			addVertex(baker, quad[3], hei, uv[3][0], uv[3][1]);
			quads.add(baker.getQuad());
			return quads;
		}

		private void addVertex(QuadBakingVertexConsumer.Buffered builder, double[] vec, int hei, double u, double v){
			builder.vertex(vec[0], vec[1] - hei * sixteenth, vec[2]);
			//builder.normal(1, 1, 1);
			builder.color(1f, 1f, 1f, 1f);
			builder.uv(sprite.getU(u), sprite.getV(v));
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

}
