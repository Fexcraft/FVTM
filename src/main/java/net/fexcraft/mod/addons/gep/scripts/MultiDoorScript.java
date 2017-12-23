package net.fexcraft.mod.addons.gep.scripts;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
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
	public boolean isOn(Side side){
		return true;//on both sides
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
	public VehicleScript readFromNBT(NBTTagCompound compound, boolean isRemote){
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
		this.hood        = arr[0] == 0 ? false : true;
		this.trunk       = arr[1] == 0 ? false : true;
		this.front_left  = arr[2] == 0 ? false : true;
		this.front_right = arr[3] == 0 ? false : true;
		this.back_left   = arr[4] == 0 ? false : true;
		this.back_right  = arr[5] == 0 ? false : true;
	}

	@Override
	public void onCreated(Entity entity, VehicleData data){
		//
	}

	@Override
	public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player){
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
		hood = false; trunk = false;
		front_left = false; front_right = false;
		back_left = false; back_right = false;
	}
	
	@Override
	public void onKeyInput(int key, int seat, VehicleEntity ent){
		//
	}

	@Override
	public TreeMap<String, String> getSettingKeys(int seat){
		TreeMap<String, String> map = new TreeMap<String, String>();
		if(seat == 0){
			map.put("Hood/Front", "boolean");
			map.put("Trunk/Back", "boolean");
		}
		map.put("Door", "boolean");
		return map;
	}

	@Override
	public void onSettingsUpdate(VehicleEntity ent, int seat, String setting, Object value){
		if(setting.equals(setting_hood)){
			if(seat != 0){
				return;
			}
			hood = value == null ? !hood : (boolean)value;
			sendDoorPacket(ent.getEntity());
			Print.debugChat("O > Hood");
		}
		else if(setting.equals(setting_back)){
			if(seat != 0){
				return;
			}
			trunk = value == null ? !trunk : (boolean)value;
			sendDoorPacket(ent.getEntity());
			Print.debugChat("P > Back");
		}
		else if(setting.equals(setting_door)){
			switch(seat){
				case 0:{
					front_left = !front_left;
					break;
				}
				case 1:{
					front_right = !front_right;
					break;
				}
				case 2:{
					back_left = !back_left;
					break;
				}
				case 3:{
					back_right = !back_right;
					break;
				}
				default: break;
			}
			if(seat < 4){
				sendDoorPacket(ent.getEntity());
				Print.debugChat("L > Door");
			}
		}
	}

	@Override
	public Object getSettingValue(int seat, String setting){
		if(setting.equals(setting_hood)){
			return hood;
		}
		else if(setting.equals(setting_back)){
			return trunk;
		}
		else if(setting.equals(setting_door)){
			switch(seat){
				case 0:{
					return front_left;
				}
				case 1:{
					return front_right;
				}
				case 2:{
					return back_left;
				}
				case 3:{
					return back_right;
				}
				default: return null;
			}
		}
		return null;
	}
	
}