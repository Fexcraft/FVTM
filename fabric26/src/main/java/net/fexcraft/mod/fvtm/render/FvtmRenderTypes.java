package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.uni.IDL;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.util.Util;

import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmRenderTypes {

	protected static final HashMap<IDL, RenderType> CUTOUTS = new HashMap<>();
	protected static final HashMap<IDL, RenderType> GLOWS = new HashMap<>();
	protected static final HashMap<IDL, RenderType> LBS = new HashMap<>();
	protected static RenderType WHITE;

	private static final Function<IDL, RenderType> CUTOUT = Util.memoize(idl -> {
		RenderSetup setup = RenderSetup.builder(RenderPipelines.ENTITY_CUTOUT_CULL).withTexture("Sampler0", idl.local())
			.useLightmap().useOverlay().affectsCrumbling().setOutline(RenderSetup.OutlineProperty.AFFECTS_OUTLINE).sortOnUpload().createRenderSetup();
		return RenderType.create("fvtm:entity_cutout", setup);
	});
	private static final Function<IDL, RenderType> GLOW = Util.memoize(idl -> {
		RenderSetup setup = RenderSetup.builder(RenderPipelines.EYES).withTexture("Sampler0", idl.local())
			.useLightmap().useOverlay().affectsCrumbling().setOutline(RenderSetup.OutlineProperty.AFFECTS_OUTLINE).sortOnUpload().createRenderSetup();
		return RenderType.create("fvtm:glow", setup);
	});
	private static final Function<IDL, RenderType> LIGHTBEAM = Util.memoize(idl -> {
		RenderSetup setup = RenderSetup.builder(RenderPipelines.BEACON_BEAM_TRANSLUCENT).withTexture("Sampler0", idl.local())
			.setOutline(RenderSetup.OutlineProperty.NONE).sortOnUpload().createRenderSetup();
		return RenderType.create("fvtm:lb", setup);
	});

	public static RenderType getCutout(IDL tex){
		RenderType type = CUTOUTS.get(tex);
		if(type != null){
			return type;
		}
		type = CUTOUT.apply(tex);
		CUTOUTS.put(tex, type);
		return type;
	}

	public static RenderType getGlow(IDL tex){
		RenderType type = GLOWS.get(tex);
		if(type != null){
			return type;
		}
		type = GLOW.apply(tex);
		GLOWS.put(tex, type);
		return type;
	}

	public static RenderType getLB(IDL tex){
		RenderType type = LBS.get(tex);
		if(type != null){
			return type;
		}
		type = LIGHTBEAM.apply(tex.local());
		LBS.put(tex, type);
		return type;
	}

	public static RenderType white(){
		if(WHITE == null) WHITE = getCutout(FvtmResources.WHITE_TEXTURE);
		return WHITE;
	}

}
