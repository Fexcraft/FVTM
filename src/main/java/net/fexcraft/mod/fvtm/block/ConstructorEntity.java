package net.fexcraft.mod.fvtm.block;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.PartData;
import net.fexcraft.mod.fvtm.data.VehicleData;
import net.fexcraft.mod.fvtm.gui.ConstructorContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorEntity extends TileEntity {
	
	private VehicleData vdata;
	private PartData pdata;
	
	public ConstructorEntity(){
		
	}

	public void processGUIPacket(Side side, NBTTagCompound packet, EntityPlayer player, ConstructorContainer container){
		switch(packet.getString("cargo")){
			case "constructor_connect":{
				boolean auto = packet.getBoolean("Auto");
				if(!auto){
					BlockPos pos = BlockPos.fromLong(packet.getLong("BlockPos"));
					TileEntity tile = world.getTileEntity(pos);
					if(tile == null){
						container.setTitleText("No TileEntity at selected position. [SERVER]", RGB.RED.packed); return;
					}
					if(tile instanceof ConstructorCenterEntity == false){
						container.setTitleText("Tile at position is of wrong type.", RGB.RED.packed); return;
					}
					ConstructorCenterEntity centerlift = (ConstructorCenterEntity)tile;
					if(centerlift.getLinkPos() != null){
						container.setTitleText("Tile at position has already connection data.", RGB.BLUE.packed); return;
					}
					else{
						centerlift.setLinkPos(pos, true);
						container.setTitleText("Tile connected.", RGB.BLACK.packed); return;
					}
				}
				else{
					boolean found = false; BlockPos searchpos; TileEntity searchtile; ConstructorCenterEntity centertile = null;
					for(int x = -8; x < 9; x++){ if(found) break;
						for(int z = -8; z < 9; z++){ if(found) break;
							for(int y = -1; y < 2; y++){ if(found) break;
								if(x == 0 && y == 0 && z == 0) continue; searchpos = pos.add(x, y, z);
								if((searchtile = world.getTileEntity(searchpos)) != null && searchtile instanceof ConstructorCenterEntity){
									if((centertile = (ConstructorCenterEntity)searchtile).getLinkPos() != null) continue;
									else{ found = true; break; }
								}
							}
						}
					}
					if(found && centertile != null){
						centertile.setLinkPos(pos, true);
						container.setTitleText("Tile connected.", RGB.BLACK.packed); return;
					}
					else{
						container.setTitleText("No suitable TileEntity found. " + (centertile == null ? "[tilenull]" : "[]"), RGB.RED.packed); return;
					}
				}
			}
			default: return;
		}
	}
	
	public VehicleData getVehicleData(){
		return vdata;
	}
	
	public PartData getPartData(){
		return pdata;
	}

}
