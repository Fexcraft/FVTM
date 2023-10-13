package net.fexcraft.mod.fvtm.gui.construct;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConstructorContainer extends ContainerInterface {

	public ConstructorContainer(JsonMap map, EntityPlayer player, int x, int y, int z){
		super(map, WrapperHolder.getPlayer(player));
	}

	@Override
	public Object get(String key, Object... objs){
		//
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		String task = com.getString("task");
		switch(task){
			//
		}
	}

	@Override
	public void onClosed(){
		//
	}

}
