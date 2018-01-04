package net.fexcraft.mod.fvtm.util.config;

import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GuiFactory implements IModGuiFactory {

	@Override
	public void initialize(Minecraft mcinst){
		//
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories(){
		return null;
	}
	
	public static class ConfigGui extends GuiConfig {

		public ConfigGui(GuiScreen parent){
			super(parent, getList(), FVTM.MODID, false, false, "FVTM Configuration");
			titleLine2 = Config.getConfig().getConfigFile().getAbsolutePath();
		}
		
		public static List<IConfigElement> getList(){
			List<IConfigElement> list = new ArrayList<IConfigElement>();
			Config.add(list);
			return list;
		}
		
	}

	@Override
	public boolean hasConfigGui(){
		return true;
	}

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen){
		return new ConfigGui(parentScreen);
	}
	
}