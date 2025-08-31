package net.fexcraft.mod.fvtm.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.lib.frl.gen.Generator_Cuboid;
import net.fexcraft.lib.frl.gen.ValueMap;
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
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.lib.common.Static.thirtysecondth;

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

		private static Polyhedron<?> hed = new Polyhedron<>();
		static{
			ValueMap map = new ValueMap();
			map.put("x", 0f);
			map.put("y", 0f);
			map.put("z", 0f);
			map.put("width", 16f);
			map.put("height", thirtysecondth);
			map.put("depth", 16f);
			map.put("texture_width", 1f);
			map.put("texture_height", 1f);
			map.put("scale", sixteenth);
			map.put("rem_poly", Arrays.asList(0, 1, 2, 4, 5));
			Generator_Cuboid.make(hed, map);
		}

		@Override
		public List<BakedQuad> getQuads(@Nullable BlockState blockState, @Nullable Direction direction, RandomSource randomSource){
			List<BakedQuad> quads = new ArrayList<>();
			for(Polygon poli : hed.polygons){
				Vec3f vec0 = new Vec3f(poli.vertices[1].vector.sub(poli.vertices[0].vector));
				Vec3f vec1 = new Vec3f(poli.vertices[1].vector.sub(poli.vertices[2].vector));
				Vec3f vec2 = vec1.cross(vec0).normalize();
				QuadBakingVertexConsumer.Buffered baker = new QuadBakingVertexConsumer.Buffered();
				baker.setDirection(Direction.getNearest(vec2.x, vec2.y, vec2.z));
				baker.setSprite(sprite);
				putVertexData(baker, poli.vertices[0], vec2);
				putVertexData(baker, poli.vertices[1], vec2);
				putVertexData(baker, poli.vertices[2], vec2);
				putVertexData(baker, poli.vertices[3], vec2);
				quads.add(baker.getQuad());
			}
			return quads;
		}

		private void putVertexData(QuadBakingVertexConsumer.Buffered builder, Vertex vertex, Vec3f nor){
			builder.vertex(vertex.vector.x, vertex.vector.y, vertex.vector.z);
			builder.normal(nor.x, nor.y, nor.z);
			builder.color(1f, 1f, 1f, 1f);
			builder.uv(sprite.getU(vertex.u), sprite.getV(vertex.v));
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
