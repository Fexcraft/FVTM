/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fexcraft.mod.addons.hcp.scripts;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.blocks.ContainerBlock;
import net.fexcraft.mod.fvtm.blocks.ContainerTileEntity;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.impl.container.GenericContainerItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 * @author Ferdinand (FEX___96)
 */
public class ContainerLiftScript implements VehicleScript {
	
    private ContainerData data;
    private int expected;
    private float current, last;

    @Override
    public ResourceLocation getId(){
        return new ResourceLocation("hcp:container_lift");
    }

    @Override
    public void onDataPacket(Entity entity, Vehicle.VehicleData data, NBTTagCompound compound, Side side){
        this.readFromNBT(compound);
    }

    @Override
    public void onCreated(Entity entity, Vehicle.VehicleData data){
        //
    }

    @Override
    public boolean onInteract(Entity entity, Vehicle.VehicleData data, EntityPlayer player, EnumHand hand){
    	if(player.getHeldItem(hand).getItem() instanceof PartItem){
    		PartData partdata = ((PartItem)player.getHeldItem(hand).getItem()).getPart(player.getHeldItem(hand));
    		if(partdata.getPart().getScripts().contains(ContainerLiftScript.class)){
    			player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_SCRIPTSGUI, entity.world, entity.getEntityId(), -1, 0);
    			return true;
    		}
    	}
        return false;
    }
    

    @Override
    public void onUpdate(Entity entity, Vehicle.VehicleData data){
    	VehicleEntity ent = (VehicleEntity)entity;
    	//
    	if(current != expected){
        	if(current > expected){
        		current -= .05f; if(current < expected) current = expected;
        	}
        	if(current < expected){
        		current += .05f; if(current > expected) current = expected;
        	}
    	}
        //
        if(current != last && !ent.getEntity().world.isRemote && ent.getEntity().ticksExisted % 10 == 0){
        	this.sendPacketToAllAround(entity, this.writeToNBT(null)); last = current;
        }
    }

	@Override
    public void onRemove(Entity entity, Vehicle.VehicleData data){
        data = null;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        compound = compound == null ? new NBTTagCompound() : compound;
        if(data != null){
            data.writeToNBT(compound);
        }
        else{
        	compound.setBoolean("reset_container", true);
        }
        compound.setInteger("expected", expected);
        compound.setFloat("current", current);
        return compound;
    }

    @Override
    public VehicleScript readFromNBT(NBTTagCompound compound){
        if(compound.hasKey(ContainerItem.NBTKEY)){
            data = Resources.getContainerData(compound);
        }
        if(compound.hasKey("reset_container") && compound.getBoolean("reset_container")){
        	data = null;
        }
        expected = compound.getInteger("expected");
        current = compound.getFloat("current");
        return this;
    }

	@Override
	public Object getSettingsValue(String setting){
		switch(setting){
			case "expected": return expected;
			//case "current": return current;
			case "trycatch": return "<<<<";
			case "release": return ">>>>";
			case "align": return ">><<";
		}
		return "";
	}

	@Override
	public ScriptSetting<?, ?>[] getSettings(int seat){
		if(seat > 0){ return null; }
		return new ScriptSetting[]{
			new ScriptSetting<ContainerLiftScript, Entity>(this, "trycatch", ScriptSetting.Type.BUTTON){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.tryCatch(player, (VehicleEntity)ent);
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerLiftScript, Entity>(this, "release", ScriptSetting.Type.BUTTON){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.tryRelease(player, (VehicleEntity)ent);
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerLiftScript, Entity>(this, "align", ScriptSetting.Type.BUTTON){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.tryAlign(player, (VehicleEntity)ent);
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerLiftScript, Entity>(this, "expected", ScriptSetting.Type.INTEGER){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.expected += i;
					if(holder.expected > 6){ holder.expected = 6; }
					if(holder.expected < 0){ holder.expected = 0; }
					holder.updateClient(player, ent);
				}
			}
		};
	}

	protected void updateClient(EntityPlayer player, Entity ent){
		this.sendPacketToClient(ent, player, this.writeToNBT(null));
	}

	protected void tryAlign(EntityPlayer player, VehicleEntity ent){
		//TODO
	}

	private boolean aligned(){
		return true;//TODO
	}

	protected void tryRelease(EntityPlayer player, VehicleEntity ent){
		if(data == null){ Print.chat(player, "&7Not holding a Container."); return; }
		if(!aligned()){ Print.chat(player, "&2Please align the Vehicle first."); return; }
		if(current != expected){ Print.chat(player, "&aStill moving, please wait.");return;}
		Vec3d pos = ent.getEntity().getPositionVector().addVector(0, (-expected) - 3, 0);
		BlockPos blkpos = new BlockPos(pos);
		EnumFacing facing = EnumFacing.fromAngle(ent.getAxes().getYaw()/* + 90 */);
		// IBlockState state = ent.getEntity().world.getBlockState(blkpos);
		if(GenericContainerItem.isValidPostitionForContainer(ent.getEntity().world, player, blkpos, facing, data)){
			try{
				ItemStack stack = data.getContainer().getItemStack(data);
				stack.getTagCompound().setLong("PlacedPos", blkpos.toLong());
				ContainerBlock.getPositions(data, blkpos, facing).forEach(bp -> {
					IBlockState state = ContainerBlock.INSTANCE.getDefaultState();
					state.getBlock().onBlockPlacedBy(ent.getEntity().world, bp, state.withProperty(ContainerBlock.FACING, facing), player, stack);
				});
				this.data = null;
				Print.chat(player, "&9Container Placed.");
			}
			catch(Exception e){
				e.printStackTrace();
				Print.chat(player, "&cERROR: See Console/Log.");
			}
		}
		else{
			Print.chat(player, "&cInvalid position for a container.");
		}
		return;
	}

	protected void tryCatch(EntityPlayer player, VehicleEntity ent){
		if(data != null){ Print.chat(player, "&7Already holding a Container."); return; }
		if(!aligned()){ Print.chat(player, "&2Please align the Vehicle first."); return; }
		if(current != expected){ Print.chat(player, "&aStill moving, please wait.");return;}
		Vec3d pos = ent.getEntity().getPositionVector().addVector(0, (-expected) - 3, 0);
		BlockPos blkpos = new BlockPos(pos);
		IBlockState state = ent.getEntity().world.getBlockState(blkpos);
		if(state.getBlock() instanceof ContainerBlock){
			ContainerTileEntity te = (ContainerTileEntity)ent.getEntity().world.getTileEntity(blkpos);
			if(te.isCore()){
				this.data = te.getContainerData();
				te.notifyBreak(ent.getEntity().world, blkpos, state, false);
				Print.chat(player, "&7Container: &9" + data.getContainer().getName());
			}
			else{
				Print.chat(player, "&cNot the Container core. ");
				//Print.chat(player, blkpos.toString());
				//Print.chat(player, te.getPos().toString());
			}
		}
		else{
			Print.chat(player, "&cNo Container at position found.");
		}
		//ent.getEntity().world.setBlockState(blkpos, Blocks.ANVIL.getDefaultState(), 2);
		Print.debug(pos, blkpos);
		return;
	}

	public ContainerData getContainerData(){
		return data;
	}

	public float getCurrentOffset(){
		return current;
	}
    
}
