package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fcl.util.Renderer26;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.part.GetWheelPos;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.RenderOrder;
import net.fexcraft.mod.fvtm.render.FvtmRenderTypes;
import net.fexcraft.mod.fvtm.render.RenderUtil26;
import net.fexcraft.mod.fvtm.sys.uni.WheelTireData;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.network.chat.Component;

import java.util.HashMap;

import static net.fexcraft.mod.fcl.util.Renderer26.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DefaultPrograms26 extends DefaultPrograms {

	private static HashMap<String, Font> FONTS = new HashMap<>();

	public static void init(){
		DefaultPrograms.init();
		GLOW = new Program() {
			private RenderType old;
			@Override
			public String id(){
				return "fvtm:glow_internal";
			}
			@Override
			public void pre(ModelGroup list, ModelRenderData data){
				old = Renderer26.type;
				Renderer26.type = FvtmRenderTypes.getGlow(data.texture().getCurrentTexture());
			}
			@Override
			public void post(ModelGroup list, ModelRenderData data){
				Renderer26.type = old;
			}
			@Override
			public RenderOrder order(){
				return RenderOrder.BLENDED;
			}
		};
		ModelGroup.PROGRAMS.add(new Program() {
			public String id(){
				return "fvtm:rgb_primary";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				if(data.color() != null) Renderer26.setColor(data.color().getPrimaryColor());
			}

			public void post(ModelGroup list, ModelRenderData data){
				Renderer26.resetColor();
			}
		});
		ModelGroup.PROGRAMS.add(new Program() {
			public String id(){
				return "fvtm:rgb_secondary";
			}

			public void pre(ModelGroup list, ModelRenderData data){
				if(data.color() != null) Renderer26.setColor(data.color().getSecondaryColor());
			}

			public void post(ModelGroup list, ModelRenderData data){
				Renderer26.resetColor();
			}
		});
		ModelGroup.PROGRAMS.add(new RGBCustom(RGB.WHITE));
		ModelGroup.PROGRAMS.add(new RGBChannel("custom"));
		ModelGroup.PROGRAMS.add(new TextureBinder("minecraft:textures/blocks/stone.png"));
		ModelGroup.PROGRAMS.add(new SignText());
		LightBeam.LBR = new LightBeam.LBRender(){
			@Override
			public void pre(LightBeam beam, ModelGroup list, ModelRenderData data){
				Renderer26.type = FvtmRenderTypes.getLB(data.texture().getCurrentTexture());
				RENDERER.push();
				if(beam.swivel == null || beam.swivel.equals("vehicle")){
					RENDERER.translate(beam.pos);
				}
				else{
					SwivelPoint point = data.vehicle().getRotationPoint(beam.swivel);
					V3D pos = point.getRelativeVector(beam.pos);
					pose.translate((float)pos.x, (float)pos.y, (float)pos.z);
				}
				setColor(RGB.WHITE, 0.5f);
			}

			@Override
			public void post(LightBeam beam, ModelGroup list, ModelRenderData data){
				RENDERER.pop();
			}
		};
		ModelGroup.PROGRAMS.add(new TextRenderer());
	}

	public static class RGBCustom implements Program {

		private RGB color = RGB.WHITE;

		public RGBCustom(RGB rgb){
			color = rgb;
		}

		@Override
		public String id(){
			return "fvtm:rgb_custom";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			Renderer26.setColor(color);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			Renderer26.resetColor();
		}

		@Override
		public Program parse(String[] args){
			return new RGBCustom(new RGB(args[0]));
		}

	}

	public static class RGBChannel implements Program {

		private String channel;

		public RGBChannel(String colorchannel){
			this.channel = colorchannel;
		}

		@Override
		public String id(){
			return "fvtm:rgb_channel";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			Renderer26.setColor(data.color().getColorChannel(channel));
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			Renderer26.resetColor();
		}

		@Override
		public Program parse(String[] args){
			return new RGBChannel(args[0]);
		}

	}

	public static class TextureBinder implements Program {

		private IDL idl;
		private RenderType rentype;

		public TextureBinder(String rs){
			idl = IDLManager.getIDLCached(rs);
		}

		public TextureBinder(IDL rs){
			idl = rs;
		}

		@Override
		public String id(){
			return "fvtm:bind_texture";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			rentype = Renderer26.type;
			FvtmRenderTypes.getCutout(idl);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			Renderer26.type = rentype;
		}

		@Override
		public Program parse(String[] args){
			return new TextureBinder(args[0]);
		}

	}

	public static class SignText implements Program {

		private static HashMap<String, SignText> TEXTS = new HashMap<>();
		private Font font;
		private String key;

		public SignText(){}

		public SignText(String font){
			key = font;
		}

		@Override
		public String id(){ return "fvtm:sign_text"; }

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.sign() == null || data.sign().text == null || data.sign().text.length() == 0) return;
			RENDERER.push();
			RENDERER.scale(-0.025F, -0.025F, 0.025F);
			RENDERER.rotate(90, 0, 1, 0);
			if(font == null){
				font = getFont(key);
				if(font == null) return;
			}
			RenderUtil26.noco.submitText(stack, data.sign().centered ? -font.width(data.sign().text) / 2f : 0, 0, Component.literal(data.sign().text).getVisualOrderText(),
				false, Font.DisplayMode.SEE_THROUGH, light, data.sign().getColorChannel("text").packed - 16777216, 0, 0);
			Renderer26.resetColor();
			RENDERER.pop();
		}

		@Override
		public boolean post(){
			return false;
		}

		@Override
		public RenderOrder order(){
			return RenderOrder.BLENDED;
		}

		@Override
		public Program parse(String[] args){
			if(args.length > 0){
				String key = args[0];
				if(!TEXTS.containsKey(key)){
					TEXTS.put(key, new SignText(key));
				}
				return TEXTS.get(key);
			}
			return this;
		}

	}

	private static Font getFont(String key){
		/*if(key == null)*/ return Minecraft.getInstance().font;
		/*else{
			if(!FONTS.containsKey(key)){
				FONTS.put(key, new Font(res -> Minecraft.getInstance().fontManager.fontSets.getOrDefault(Identifier.tryParse(key), Minecraft.getInstance().fontManager.missingFontSet), true));
			}
			return FONTS.get(key);
		}*/
	}

	public static class TextRenderer extends TextRendererBase {

		protected Font font;

		@Override
		public TextRendererBase create(){
			return new TextRenderer();
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(attrid != null){
				attr = data.vehicle().getAttribute(attrid);
				if(attr == null) return;
				text = attr.asString();
			}
			if(text.isEmpty()) return;
			if(font == null){
				font = getFont(fontkey);
				if(font == null) return;
			}
			RENDERER.push();
			RENDERER.translate(pos);
			RENDERER.scale(-downscale, -downscale, -downscale);
			if(scale != 1f) RENDERER.scale(scale, scale, scale);
			RENDERER.rotate(-90, 0, 1, 0);
			if(rot.y != 0.0F) RENDERER.rotate(rot.y, 0, 1, 0);
			if(rot.z != 0.0F) RENDERER.rotate(rot.z, 0, 0, 1);
			if(rot.x != 0.0F) RENDERER.rotate(rot.x, 1, 0, 0);
			RenderUtil26.noco.submitText(stack, centered ? -font.width(text) * 0.5f : 0, 0, Component.literal(width > 0 ? font.plainSubstrByWidth(text, width) : text).getVisualOrderText(),
				false, glow ? Font.DisplayMode.SEE_THROUGH : Font.DisplayMode.NORMAL, light, data.sign().getColorChannel("text").packed - 16777216, 0, 0);
			RENDERER.pop();
		}

		@Override
		public RenderOrder order(){
			return RenderOrder.BLENDED;
		}
	}

}
