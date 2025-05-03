package net.fexcraft.mod.fvtm.gui.block;

import static net.fexcraft.mod.fvtm.util.GuiHandler.MULTIBLOCK_CRAFT_CHOOSE;

import java.util.Map.Entry;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class GBlockCraftContainer extends GenericContainer {

	protected GenericGui<GBlockCraftContainer> gui;
	protected MultiblockTileEntity tile;
	protected CraftBlockScript script;
	protected MultiBlockData data;
	protected EntityPlayerMP mpp;
	public int page, crafted;
	public int crafttime;
	public String current;
	public String ntstatus;
	public boolean tickable;
	protected static String success = "Recipe Crafted.";

	public GBlockCraftContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
		tile = (MultiblockTileEntity)world.getTileEntity(new BlockPos(x, y, z));
		//TODO script = (CraftBlockScript)tile.getMultiBlockData().getScript();
		tickable = tile.getBlockData().getType().isTickable();
		data = tile.getMultiBlockData();
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
					player.openGui(FVTM.getInstance(), MULTIBLOCK_CRAFT_CHOOSE, player.world, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
					break;
				}
				case "craft_recipe":{
					if(craft > 0) break;
					NBTTagCompound compound = new NBTTagCompound();
					if(script.getSelected() == null){
						compound.setString("status", "No recipe selected.");
					}
					else{
						if(script.getSelected().canCraft(script, tile.getMultiBlockData(), false)){
							script.getSelected().craft(script, tile.getMultiBlockData());
							compound.setString("status", success);
						}
						else{
							compound.setString("status", "Recipe cannot be crafted.");
						}
					}
					compound.setString("cargo", "craft_status");
					send(Side.CLIENT, compound);
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
					if(!packet.getString("current").equals(current)){
						crafted = 0;
					}
					current = packet.getString("current");
					script.setProcessed(packet.getInteger("processed"));
					script.setCooldown(packet.getInteger("cooldown"));
					for(Entry<String, InvHandler> handler : data.getInventories().entrySet()){
						if(packet.hasKey("c_" + handler.getKey())){
							handler.getValue().setVarValue(packet.getInteger("c_" + handler.getKey()));
						}
					}
					crafttime = packet.getInteger("crafttime");
					break;
				}
				case "craft_status":{
					ntstatus = packet.getString("status");
					if(ntstatus.equals(success)) crafted++;
					break;
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
	
	private byte passed = 0, craft = 0;

	@Override
	public void detectAndSendChanges(){
		if(craft > 0) craft--;
		passed++;
		if(passed < 10) return;
		passed = 0;
		NBTTagCompound compound = new NBTTagCompound();
		for(Entry<String, InvHandler> entry : data.getInventories().entrySet()){
			if(!entry.getValue().type.isVariable() && !entry.getValue().type.isFluid()) continue;
			compound.setInteger("c_" + entry.getKey(), entry.getValue().getVarValue());
		}
		compound.setString("current", script.getCurrentRecipe());
		compound.setInteger("cooldown", script.getCooldown());
		compound.setInteger("processed", script.getProcessed());
		compound.setInteger("crafttime", script.getProcessTime());
		compound.setString("cargo", "consumables");
		send(Side.CLIENT, compound);
	}

}
