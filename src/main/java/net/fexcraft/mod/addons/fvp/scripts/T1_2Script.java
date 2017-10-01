package net.fexcraft.mod.addons.fvp.scripts;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class T1_2Script implements Vehicle.VehicleScript {

	@SideOnly(Side.CLIENT)
	public boolean out = false, reg = false;
	
	public T1_2Script(){
		if(!reg && Static.side().isClient()){
			net.minecraftforge.fml.client.registry.ClientRegistry.registerKeyBinding(ClientReg.keybind);
			reg = true;
		}
	}

	@Override
	public ResourceLocation getId(){
		return new ResourceLocation("fvp:t1-2type");
	}

	@Override
	public boolean isOn(Side side){
		return true;//works on both sides.
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setBoolean("Out", out);
		return compound;
	}

	@Override
	public VehicleScript readFromNBT(NBTTagCompound compound, boolean isRemote){
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
	public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player){
		return false;
	}

	@Override
	public void onUpdate(Entity entity, VehicleData data) {
		return;
	}
	
	@Override
	public void onKeyInput(int key){
		//Print.debug(key, keybind.getKeyCategory(), keybind.getKeyCode());
		if(Keyboard.isKeyDown(ClientReg.keybind.getKeyCode()) && VehicleScript.getClientSeatId() == 0){
			out = !out;
			Print.debugChat(out ? "Out" : "In");
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setBoolean("Out", out);
			this.sendPacketToServer(VehicleScript.getVehicle(), nbt);
		}
	}
	
	@SideOnly(Side.CLIENT)
	private static class ClientReg{
		private static net.minecraft.client.settings.KeyBinding keybind = new net.minecraft.client.settings.KeyBinding("T1 Type 2", Keyboard.KEY_L, "Fex`s Vehicle Pack");
	}
	
}