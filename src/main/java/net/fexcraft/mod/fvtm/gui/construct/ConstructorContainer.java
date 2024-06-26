package net.fexcraft.mod.fvtm.gui.construct;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.block.ConstructorEntity;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConstructorContainer extends ContainerInterface {

	private ConstructorEntity tile;

	public ConstructorContainer(JsonMap map, EntityPlayer player, int x, int y, int z){
		super(map, UniEntity.get(player).entity, new V3I(x, y, z));
		tile = (ConstructorEntity)player.world.getTileEntity(new BlockPos(x, y, z));
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
			case "lift":{
				if(tile.noveh(player)) return;
				tile.liftstate += com.getInteger("lift") * 0.5f;
				if(tile.liftstate < -3) tile.liftstate = -3;
				if(tile.liftstate > 0) tile.liftstate = 0;
				tile.updateClient("lift");
				break;
			}
			case "veh_parts":{

				break;
			}
			case "veh_attrs":{

				break;
			}
			case "appear_tex":{

				break;
			}
			case "appear_color":{

				break;
			}
		}
	}

	@Override
	public void onClosed(){
		//
	}

}
