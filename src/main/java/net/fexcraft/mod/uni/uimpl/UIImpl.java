package net.fexcraft.mod.uni.uimpl;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UIImpl extends UserInterface {

	public UIImpl(JsonMap map) throws Exception {
		super(map, new CIImpl(map));
	}

	@Override
	public boolean processAction(UIButton button, String id, int x, int y, int b){
		return false;
	}

	@Override
	public void bindTexture(IDL texture){
		Minecraft.getMinecraft().renderEngine.bindTexture((ResourceLocation)texture);
	}

}
