package net.fexcraft.mod.addons.gep.scripts;

import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockScript;
import net.fexcraft.mod.fvtm.impl.CrafterBlockScriptBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;

public class SmelteryScript extends CrafterBlockScriptBase {
	
	public boolean open;
	
	public SmelteryScript(){
		super();
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		compound = super.writeToNBT(compound);
		compound.setBoolean("Script_Open", open);
		return compound;
	}

	@Override
	public BlockScript readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		open = compound.getBoolean("Script_Open");
		return this;
	}

	@Override
	public void onPlace(TileEntity tile, BlockData data){
		//
	}

	@Override
	public void onBreak(TileEntity tile, BlockData data){
		//
	}

	@Override
	public ScriptSetting<?, ?>[] getSettings(int seat){
		return new ScriptSetting<?, ?>[]{
			new ScriptSetting<SmelteryScript, TileEntity>(this, "open", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, TileEntity tile, int i, Object... objs){
					open = i == 0 ? false : i == 1 ? true : open;
			        NBTTagCompound nbt = new NBTTagCompound();
			        nbt.setBoolean("smeltery_open", open);
			        holder.sendPacketToAllAround(tile, nbt);
				}
			}
		};
	}

	@Override
	public void onDataPacket(TileEntity tile, BlockData data, NBTTagCompound compound, Side side){
		super.onDataPacket(tile, data, compound, side);
		if(compound.hasKey("smeltery_open")){
			open = compound.getBoolean("smeltery_open");
		}
	}
	
	@Override
	public void onUpdate(TileEntity tile, BlockData data){
		if(tile.getWorld().isRemote){
			EnumParticleTypes type = open ? EnumParticleTypes.SMOKE_LARGE : EnumParticleTypes.SMOKE_NORMAL;
			float x = tile.getPos().getX() + 0.5f, y = tile.getPos().getY() + 4, z = tile.getPos().getZ() + 0.5f;
			if(!open){
				for(float f = -0.2f; f < 0.3f; f += 0.1f){
					for(float g = -0.2f; g < 0.3f; g += 0.1f){
						float h = tile.getWorld().rand.nextFloat(); h = h > 0.3 ? h / 10 : h;
						tile.getWorld().spawnParticle(type, x + f, y, z + g, 0.001D, h, 0.001D);
					}
				}
			}
			else{
				tile.getWorld().spawnParticle(type, x      , y, z      , 0.0D, 0.07D, 0.0D);
				tile.getWorld().spawnParticle(type, x + 0.1, y, z + 0.1, 0.0D, 0.11D, 0.0D);
				tile.getWorld().spawnParticle(type, x - 0.1, y, z + 0.1, 0.0D, 0.15D, 0.0D);
				tile.getWorld().spawnParticle(type, x - 0.1, y, z - 0.1, 0.0D, 0.08D, 0.0D);
				tile.getWorld().spawnParticle(type, x + 0.1, y, z - 0.1, 0.0D, 0.22D, 0.0D);
			}
			progress++;
			progress = progress > 100 ? 0 : progress;
		}
		//
	}

	@Override
	public Object getSettingsValue(String setting){
		return setting.equals("open") ? open + "" : "";
	}

	@Override
	protected void validateRecipes(){
		//
	}

	@Override
	public int getProgressPercentage(){
		return progress;
	}

	@Override
	public String getInputInventoryForGui(){
		return "inventory:smeltery_queue";
	}

	@Override
	public String getOutputInventoryForGui(){
		return "inventory:smeltery_out";
	}

	@Override
	public String getSettingHolderId(){
		return "generic:smeltery";
	}

	@Override
	public String[] getSubproducts(){
		return new String[]{ null, null, null };
	}
	
}