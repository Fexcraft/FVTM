package net.fexcraft.mod.fme.gui;

import net.fexcraft.mod.fvtm.gui.GenericPlaceholderContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        if(ID >= 0){
            return new GenericPlaceholderContainer();
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        if(ID >= 0){
            return new GuiEditor(ID, player, world, x, y, z);
        }
        return null;
    }

}
