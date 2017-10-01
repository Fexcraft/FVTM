package net.fexcraft.mod.addons.fvp.scripts;

import org.lwjgl.input.Keyboard;

import com.flansmod.common.RotatedAxes;
import com.flansmod.common.vector.Vector3f;
import com.flansmod.fvtm.LandVehicle;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class T1SnowPlowScript implements VehicleScript {
	
	public boolean on = false, reg = false;
	
	public T1SnowPlowScript(){
		if(!reg && Static.side().isClient()){
			net.minecraftforge.fml.client.registry.ClientRegistry.registerKeyBinding(ClientReg.keybind);
			reg = true;
		}
	}

	@Override
	public ResourceLocation getId(){
		return new ResourceLocation("fvp:t1snowplowscript");
	}

	@Override
	public boolean isOn(Side side){
		return true;//is on both sides active
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		compound.setBoolean(this.getId().toString() + "_On", on);
		return compound;
	}

	@Override
	public VehicleScript readFromNBT(NBTTagCompound compound, boolean isRemote) {
		if(compound.hasKey(this.getId().toString() + "_On")){
			on = compound.getBoolean(this.getId().toString() + "_On");
		}
		return this;
	}

	@Override
	public void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side) {
		if(side.isServer()){
			this.sendPacketToAllAround(entity, compound);
		}
		if(compound.hasKey("On")){
			on = compound.getBoolean("On");
		}
	}

	@Override
	public void onCreated(Entity entity, VehicleData data){
		return;
	}

	@Override
	public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player){
		return false;
	}

	@Override
	public void onUpdate(Entity entity, VehicleData data){
		com.flansmod.fvtm.LandVehicle vehicle = (LandVehicle) entity;
		if(!vehicle.world.isRemote){
			if(on){
				Vector3f[] pos = new Vector3f[6];
				pos[0] = calculate(vehicle,  2);
				pos[1] = calculate(vehicle,  1);
				pos[2] = calculate(vehicle,  0);
				pos[3] = calculate(vehicle, -1);
				pos[4] = calculate(vehicle, -2);
				pos[5] = calculate(vehicle,  3);
				IBlockState[] states = new IBlockState[6];
				int j = 0;
				for(int i = 0; i < 6; i++){
					BlockPos poss = new BlockPos(pos[i].toVec3());
					states[i] = vehicle.world.getBlockState(poss);
					if(i < 5){
						if(states[i].getMaterial() == Material.SNOW){
							vehicle.world.setBlockState(new BlockPos(poss), Blocks.AIR.getDefaultState(), 2);
							j++;
						}
						else if(states[i].getMaterial().isReplaceable() || states[i].getMaterial() == Material.CACTUS || states[i].getMaterial() == Material.CIRCUITS){
							vehicle.world.setBlockState(new BlockPos(poss), Blocks.AIR.getDefaultState(), 2);
						}
					}
					if(i == 5 && j > 0 && states[i].getMaterial().isReplaceable()){
						vehicle.world.setBlockState(poss, Blocks.SNOW_LAYER.getDefaultState().withProperty(BlockSnow.LAYERS, j), 2);
					}
				}
			}
			else{
				//
			}
		}
	}
	
	private static final Vector3f calculate(com.flansmod.fvtm.LandVehicle vehicle, int i){
		Pos pos = new Pos(70, 4, i * 16);
		Vector3f loc = new Vector3f(pos.to16FloatX(), pos.to16FloatY(), pos.to16FloatZ());
		RotatedAxes yaw = new RotatedAxes(vehicle.seats[0].looking.getYaw(), 0F, 0F);
		Vector3f rotatedOffset = yaw.findLocalVectorGlobally(vehicle.seats[0].seatInfo.rotatedOffset);
		Vector3f.add(loc, new Vector3f(rotatedOffset.x, 0F, rotatedOffset.z), loc);
		Vector3f rel = vehicle.axes.findLocalVectorGlobally(loc);
		return new Vector3f(vehicle.posX + rel.x, vehicle.posY + rel.y, vehicle.posZ + rel.z);
	}

	@Override
	public void onRemove(Entity entity, VehicleData data){
		//
	}
	
	@Override
	public void onKeyInput(int key){
		//Print.debug(key);
		if(Keyboard.isKeyDown(ClientReg.keybind.getKeyCode()) && VehicleScript.getClientSeatId() == 0){
			on = !on;
			Print.debugChat("Snow Plow " + (on ? "enabled" : "disabled") + ".");
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setBoolean("On", on);
			this.sendPacketToServer(VehicleScript.getVehicle(), nbt);
		}
	}
	
	@SideOnly(Side.CLIENT)
	private static class ClientReg{
		private static net.minecraft.client.settings.KeyBinding keybind = new net.minecraft.client.settings.KeyBinding("T1 Snow Plow", Keyboard.KEY_F, "Fex`s Vehicle Pack");
	}
	
}