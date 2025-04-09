package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.fexcraft.mod.uni.IDL;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.TriState;

import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmRenderTypes {

	protected static final HashMap<IDL, RenderType> CUTOUTS = new HashMap<>();
	protected static final HashMap<IDL, RenderType> GLOWS = new HashMap<>();

	private static final Function<IDL, RenderType> CUTOUT = Util.memoize(idl -> {
		RenderType.CompositeState state = RenderType.CompositeState.builder()
			.setTextureState(new RenderStateShard.TextureStateShard(idl.local(), TriState.DEFAULT, false))
			.setLightmapState(RenderStateShard.LIGHTMAP)
			.setOverlayState(RenderStateShard.OVERLAY)
			.createCompositeState(false);
		return RenderType.create("fvtm:entity_cutout", 1536, true, false, RenderPipelines.ENTITY_CUTOUT, state);
	});
	private static final Function<IDL, RenderType> GLOW = Util.memoize(idl -> {
		RenderType.CompositeState state = RenderType.CompositeState.builder()
			.setTextureState(new RenderStateShard.TextureStateShard(idl.local(), TriState.DEFAULT, false))
			.setLightmapState(RenderStateShard.LIGHTMAP)
			.setOverlayState(RenderStateShard.OVERLAY)
			.createCompositeState(false);
		return RenderType.create("fvtm:glow", 1536, false, true, RenderPipelines.EYES, state);
	});

	public static void setCutout(IDL tex){
		RenderType type = CUTOUTS.get(tex);
		if(type != null){
			Renderer21.rentype = type;
			return;
		}
		type = CUTOUT.apply(tex);
		CUTOUTS.put(tex, type);
		Renderer21.rentype = type;
	}

	public static void setGlow(IDL tex){
		RenderType type = GLOWS.get(tex);
		if(type != null){
			Renderer21.rentype = type;
			return;
		}
		type = GLOW.apply(tex);
		GLOWS.put(tex, type);
		Renderer21.rentype = type;
	}

	public static void setLines(){
		Renderer21.rentype = RenderType.lines();
	}

	public static void setLineStrip(){
		Renderer21.rentype = RenderType.lineStrip();
	}

	public static void setDef(RenderType type){
		Renderer21.rentype = type;
	}

}
