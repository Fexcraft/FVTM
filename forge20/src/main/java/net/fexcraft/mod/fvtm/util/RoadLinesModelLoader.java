package net.fexcraft.mod.fvtm.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_LINES;
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

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.lib.common.Static.thirtysecondth;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;

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

		private static double[][] quad = {
			{ 1, thirtysecondth, 0 },
			{ 0, thirtysecondth, 0 },
			{ 0, thirtysecondth, 1 },
			{ 1, thirtysecondth, 1 }
		};
		private static int[][] uv_full = {
			{ 16,  0 }, { 0,  0 }, { 0, 16 }, { 16, 16 }
		};
		private static int[][] uv_ls = {
			{ 8,  0 }, { 0,  0 }, { 0, 8 }, { 8, 8 }
		};
		private static int[][] uv_lc = {
			{ 16,  0 }, { 8,  0 }, { 8, 8 }, { 16, 8 }
		};
		private static int[][] uv_lt = {
			{ 8,  8 }, { 0,  8 }, { 0, 16 }, { 8, 16 }
		};
		private static int[][] uv_lf = {
			{ 16,  8 }, { 8,  8 }, { 8, 16 }, { 16, 16 }
		};
		private static int[][][] uv_ls2 = new int[2][][];
		private static int[][][] uv_lc2 = new int[4][][];
		private static int[][][] uv_l3 = new int[4][][];
		static{
			uv_ls2[0] = uv_ls;
			uv_ls2[1] = rotateR(uv_ls);
			uv_lc2[0] = uv_lc;
			uv_lc2[1] = rotateL(uv_lc);
			uv_lc2[2] = rotateU(uv_lc);
			uv_lc2[3] = rotateR(uv_lc);
			uv_l3[0] = uv_lt;
			uv_l3[1] = rotateL(uv_lt);
			uv_l3[2] = rotateU(uv_lt);
			uv_l3[3] = rotateR(uv_lt);
		}

		private static int[][] rotateR(int[][] ar){
			int[][] na = new int[ar.length][ar[0].length];
			na[0] = ar[3];
			na[1] = ar[0];
			na[2] = ar[1];
			na[3] = ar[2];
			return na;
		}

		private static int[][] rotateL(int[][] ar){
			int[][] na = new int[ar.length][ar[0].length];
			na[0] = ar[1];
			na[1] = ar[2];
			na[2] = ar[3];
			na[3] = ar[0];
			return na;
		}

		private static int[][] rotateU(int[][] ar){
			int[][] na = new int[ar.length][ar[0].length];
			na[0] = ar[2];
			na[1] = ar[3];
			na[2] = ar[0];
			na[3] = ar[1];
			return na;
		}

		@Override
		public List<BakedQuad> getQuads(BlockState state, Direction direction, RandomSource random){
			int hei = state == null ? 0 : state.getValue(PROP_HEIGHT);
			boolean hl = state.getBlock() instanceof G_ROAD_LINES;
			int[][] uv = uv_full;
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
