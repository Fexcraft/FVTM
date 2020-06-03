package net.fexcraft.mod.fvtm.gui.block;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE;
import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE.TileEntity;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class GBlockCraftContainer extends GenericContainer {

	protected GenericGui<GBlockCraftContainer> gui;
	protected M_4ROT_TE.TileEntity tile;
	protected CraftBlockScript script;
	protected EntityPlayerMP mpp;
	public int page;
	public int crafttime;
	public String current;

	public GBlockCraftContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
		tile = (TileEntity)world.getTileEntity(new BlockPos(x, y, z));
		script = (CraftBlockScript)tile.getMultiBlockData().getScript();
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(side.isServer()){
			switch(packet.getString("cargo")){
				case "page":{
					page = packet.hasKey("page") ? packet.getInteger("page") : 0;
					//
					break;
				}
				case "reset_recipe":{
					script.resetRecipe();
					break;
				}
				case "open_chooser":{
					GenericContainer.openGui("fvtm", 953, new int[]{ tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ() }, player);
					break;
				}
				default: return;
			}
		}
		else{
			switch(packet.getString("cargo")){
				case "init":{
					page = packet.hasKey("page") ? packet.getInteger("page") : 0;
					break;
				}
				case "consumables":{
					current = packet.getString("current");
					script.setProcessed(packet.getInteger("processed"));
					script.setCooldown(packet.getInteger("cooldown"));
					for(String val : script.getConsumables()){
						if(packet.hasKey("c_" + val)){
							script.setConsumable(val, packet.getInteger("c_" + val));
						}
					}
					crafttime = packet.getInteger("crafttime");
				}
				default: return;
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return true;
	}

	@Override
	public void onContainerClosed(EntityPlayer player){
		super.onContainerClosed(player);
		tile.markDirty();
	}
	
	private byte passed = 0;

	@Override
	public void detectAndSendChanges(){
		passed++;
		if(passed < 10) return;
		passed = 0;
		NBTTagCompound compound = new NBTTagCompound();
		for(String val : script.getConsumables()){
			compound.setInteger("c_" + val, script.getConsumable(val));
		}
		compound.setString("current", script.getCurrentRecipe());
		compound.setInteger("cooldown", script.getCooldown());
		compound.setInteger("processed", script.getProcessed());
		compound.setInteger("crafttime", script.getProcessTime());
		compound.setString("cargo", "consumables");
		send(Side.CLIENT, compound);
	}

}
