package net.fexcraft.mod.addons.gep.scripts;

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

public class MultiDoorScript implements Vehicle.VehicleScript {

    public boolean hood, trunk, front_left, front_right, back_left, back_right;
    public static final String setting_hood = "Hood/Front";
    public static final String setting_back = "Trunk/Back";
    public static final String setting_door = "Door";

    public MultiDoorScript(){}

    @Override
    public ResourceLocation getId(){
        return new ResourceLocation("generic:multidoor");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        compound.setBoolean("MultiDoor-Hood", hood);
        compound.setBoolean("MultiDoor-Trunk", trunk);
        compound.setBoolean("MultiDoor-FrontLeft", front_left);
        compound.setBoolean("MultiDoor-FrontRight", front_right);
        compound.setBoolean("MultiDoor-BackLeft", back_left);
        compound.setBoolean("MultiDoor-BackRight", back_right);
        return compound;
    }

    @Override
    public VehicleScript readFromNBT(NBTTagCompound compound){
        this.hood = compound.getBoolean("MultiDoor-Hood");
        this.trunk = compound.getBoolean("MultiDoor-Trunk");
        this.front_left = compound.getBoolean("MultiDoor-FrontLeft");
        this.front_right = compound.getBoolean("MultiDoor-FrontRight");
        this.back_left = compound.getBoolean("MultiDoor-BackLeft");
        this.back_right = compound.getBoolean("MultiDoor-BackRight");
        return this;
    }

    @Override
    public void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side){
        if(!compound.hasKey("MultiDoor")){
            return;
        }
        if(side.isServer()){
            this.sendPacketToAllAround(entity, compound);
        }
        byte[] arr = compound.getByteArray("MultiDoor");
        this.hood = arr[0] == 0 ? false : true;
        this.trunk = arr[1] == 0 ? false : true;
        this.front_left = arr[2] == 0 ? false : true;
        this.front_right = arr[3] == 0 ? false : true;
        this.back_left = arr[4] == 0 ? false : true;
        this.back_right = arr[5] == 0 ? false : true;
    }

    @Override
    public void onCreated(Entity entity, VehicleData data){
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

    private void sendDoorPacket(Entity entity){
        byte[] arr = new byte[6];
        arr[0] = (byte)(hood ? 1 : 0);
        arr[1] = (byte)(trunk ? 1 : 0);
        arr[2] = (byte)(front_left ? 1 : 0);
        arr[3] = (byte)(front_right ? 1 : 0);
        arr[4] = (byte)(back_left ? 1 : 0);
        arr[5] = (byte)(back_right ? 1 : 0);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setByteArray("MultiDoor", arr);
        this.sendPacketToServer(entity, nbt);
    }

    @Override
    public void onRemove(Entity entity, VehicleData data){
        hood = false;
        trunk = false;
        front_left = false;
        front_right = false;
        back_left = false;
        back_right = false;
    }

    @Override
    public void onKeyInput(int key, int seat, VehicleEntity ent){
        //
    }

	@Override
	public ScriptSetting<?>[] getSettings(int seat){
		if(seat >= 4 || seat < 0){ return null; }
		ScriptSetting<?>[] settings = new ScriptSetting<?>[seat == 0 ? 3 : 1];
		switch(seat){
			case 0:{
				settings[0] = new ScriptSetting<MultiDoorScript>(this, "hood", ScriptSetting.Type.BOOLEAN){
					@Override
					public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
			            hood = i == 0 ? false : i == 1 ? true : hood;
			            sendDoorPacket(entity);
					}
				};
				settings[1] = new ScriptSetting<MultiDoorScript>(this, "trunk", ScriptSetting.Type.BOOLEAN){
					@Override
					public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
			            trunk = i == 0 ? false : i == 1 ? true : trunk;
			            sendDoorPacket(entity);
					}
				};
				settings[2] = new ScriptSetting<MultiDoorScript>(this, "front_left", ScriptSetting.Type.BOOLEAN){
					@Override
					public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
						front_left = i == 0 ? false : i == 1 ? true : front_left;
			            sendDoorPacket(entity);
					}
				};
				break;
			}
			case 1:{
				settings[0] = new ScriptSetting<MultiDoorScript>(this, "front_right", ScriptSetting.Type.BOOLEAN){
					@Override
					public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
						front_right = i == 0 ? false : i == 1 ? true : front_right;
			            sendDoorPacket(entity);
					}
				};
				break;
			}
			case 2:{
				settings[0] = new ScriptSetting<MultiDoorScript>(this, "back_left", ScriptSetting.Type.BOOLEAN){
					@Override
					public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
						back_left = i == 0 ? false : i == 1 ? true : back_left;
			            sendDoorPacket(entity);
					}
				};
				break;
			}
			case 3:{
				settings[0] = new ScriptSetting<MultiDoorScript>(this, "back_right", ScriptSetting.Type.BOOLEAN){
					@Override
					public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
						back_right = i == 0 ? false : i == 1 ? true : back_right;
			            sendDoorPacket(entity);
					}
				};
				break;
			}
		}
		return settings;
	}

	@Override
	public Object getSettingsValue(String setting){
		switch(setting){
			case "hood":{ return hood; }
			case "trunk":{ return trunk; }
			case "front_left":{ return front_left; }
			case "front_right":{ return front_right; }
			case "back_left":{ return back_left; }
			case "back_right":{ return back_right; }
		}
		return "null";
	}

}
