package net.fexcraft.mod.addons.fvp.scripts;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;

public class T1SnowPlowScript implements VehicleScript {
	
    public boolean on = false;

    public T1SnowPlowScript(){
    }

    @Override
    public ResourceLocation getId(){
        return new ResourceLocation("fvp:t1snowplowscript");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        compound.setBoolean(this.getId().toString() + "_On", on);
        return compound;
    }

    @Override
    public VehicleScript readFromNBT(NBTTagCompound compound){
        if(compound.hasKey(this.getId().toString() + "_On")){
            on = compound.getBoolean(this.getId().toString() + "_On");
        }
        return this;
    }

    @Override
    public void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side){
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
    public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player, EnumHand hand){
        return false;
    }

    @Override
    public void onUpdate(Entity entity, VehicleData data){
        VehicleEntity vehicle = (VehicleEntity) entity;
        if(!entity.world.isRemote){
            if(on){
                Vec3d[] pos = new Vec3d[6];
                pos[0] = calculate(vehicle, entity, 2);
                pos[1] = calculate(vehicle, entity, 1);
                pos[2] = calculate(vehicle, entity, 0);
                pos[3] = calculate(vehicle, entity, -1);
                pos[4] = calculate(vehicle, entity, -2);
                pos[5] = calculate(vehicle, entity, 3);
                IBlockState[] states = new IBlockState[6];
                int j = 0;
                for(int i = 0; i < 6; i++){
                    BlockPos poss = new BlockPos(new Vec3d(pos[i].x, pos[i].y, pos[i].z));
                    states[i] = entity.world.getBlockState(poss);
                    if(i < 5){
                        if(states[i].getMaterial() == Material.SNOW){
                            entity.world.setBlockState(new BlockPos(poss), Blocks.AIR.getDefaultState(), 2);
                            j++;
                        }
                        else if(states[i].getMaterial().isReplaceable() || states[i].getMaterial() == Material.CACTUS || states[i].getMaterial() == Material.CIRCUITS){
                            entity.world.setBlockState(new BlockPos(poss), Blocks.AIR.getDefaultState(), 2);
                        }
                    }
                    if(i == 5 && j > 0 && states[i].getMaterial().isReplaceable()){
                        entity.world.setBlockState(poss, Blocks.SNOW_LAYER.getDefaultState().withProperty(BlockSnow.LAYERS, j), 2);
                    }
                }
            }
            else{
                //
            }
        }
    }

    private static final Vec3d calculate(VehicleEntity vehicle, Entity ent, int i){
        Pos pos = new Pos(70, 4, i * 16);
        Vec3d rel = vehicle.getAxes().getRelativeVector(pos.to16Double());
        return new Vec3d(ent.posX + rel.x, ent.posY + rel.y, ent.posZ + rel.z);
    }

    @Override
    public void onRemove(Entity entity, VehicleData data){
        //
    }

    @Override
    public void onKeyInput(int key, int seat, VehicleEntity ent){
        //
    }

	@Override
	public ScriptSetting<?>[] getSettings(int seat){
		return seat == 0 ? new ScriptSetting<?>[]{
			new ScriptSetting<T1SnowPlowScript>(this, "snow_plow", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity entity, int i){
					on = i == 0 ? false : i == 1 ? true : on;
		            NBTTagCompound nbt = new NBTTagCompound();
		            nbt.setBoolean("On", on);
		            script.sendPacketToServer(entity, nbt);
				}
			}
		} : null;
	}

	@Override
	public Object getSettingsValue(String setting){
		return setting.equals("snow_plow") ? on : "null";
	}

}
