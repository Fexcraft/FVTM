package net.fexcraft.mod.fmt.gui;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.adjgui.AdjustableGuiContainer;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	private static JsonObject obj = new JsonObject();
	static{
		JsonObject json = new JsonObject();
		json.addProperty("type", "textfield");
		json.addProperty("x", 3); json.addProperty("y", 12);
		json.addProperty("width", 148); json.addProperty("height", 12);
		obj.add("field_x", json);
		json = new JsonObject();
		json.addProperty("type", "textfield");
		json.addProperty("x", 3); json.addProperty("y", 26);
		json.addProperty("width", 148); json.addProperty("height", 12);
		obj.add("field_y", json);
		json = new JsonObject();
		json.addProperty("type", "textfield");
		json.addProperty("x", 3); json.addProperty("y", 40);
		json.addProperty("width", 148); json.addProperty("height", 12);
		obj.add("field_z", json);
	}

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        return new Container(false, obj, player, ID, world, x, y, z);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        try{
			return new AdjustableGuiContainer(Container.class, obj, RGB.fromDyeColor(EnumDyeColor.GRAY), false, player, 154, 66, ID, world, x, y, z);
		}
        catch(Exception e){
			e.printStackTrace();
		}
        return null;
    }

}
