package net.fexcraft.mod.addons.fvp.scripts;

import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class T1_2Script implements Vehicle.VehicleScript {

    public boolean out = false;

    public T1_2Script(){
    }

    @Override
    public ResourceLocation getId(){
        return new ResourceLocation("fvp:t1-2type");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        compound.setBoolean("Out", out);
        return compound;
    }

    @Override
    public VehicleScript readFromNBT(NBTTagCompound compound){
        if(compound.hasKey("Out")){
            out = compound.getBoolean("Out");
        }
        return this;
    }

    @Override
    public void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side){
        if(side.isServer()){
            this.sendPacketToAllAround(entity, compound);
        }
        out = compound.getBoolean("Out");
    }

    @Override
    public void onCreated(Entity entity, VehicleData data){
        //
    }

    @Override
    public void onRemove(Entity entity, VehicleData data){
        //
    }

    @Override
    public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player, EnumHand hand){
        return false;
    }

    @Override
    public void onUpdate(Entity entity, VehicleData data){
        return;
    }

    @Override
    public void onKeyInput(int key, int seat, VehicleEntity ent){
        //
    }

	@Override
	public ScriptSetting<?>[] getSettings(int seat){
		return seat == 0 ? new ScriptSetting<?>[]{
			new ScriptSetting<T1_2Script>(this, "out", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					out = i == 0 ? false : i == 1 ? true : out;
		            NBTTagCompound nbt = new NBTTagCompound();
		            nbt.setBoolean("Out", out);
		            holder.sendPacketToServer(ent, nbt);
				}
			}
		} : null;
	}

	@Override
	public Object getSettingsValue(String setting){
		return setting.equals("out") ? out : "";
	}

}
