package net.fexcraft.mod.addon.gep.scripts;

import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.util.Axis3D;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;

public class GeneralSnowPlowScript extends VehicleScript {
	
	private ArrayList<Vec3d> plow = new ArrayList<>();
	private float width = 3, accuracy;
	private String attribute;
	private Pos pos, out;
	private boolean accumulate;
	private int cooldown;

	@Override
	public String getId(){
		return "general_snowplow";
	}

	@Override
	public String getName(){
		return "General Snowplow Script";
	}
	
	@Override
	public VehicleScript init(JsonElement elm){
		JsonObject obj = elm.getAsJsonObject();
		pos = Pos.fromJson(obj.get("pos"), true);
		width = JsonUtil.getIfExists(obj, "width", 3f).floatValue();
		attribute = obj.get("attribute").getAsString();
		accuracy = JsonUtil.getIfExists(obj, "accuracy", 1f).floatValue();
		for(float f = -(width / 2f) + accuracy / 2; f < width / 2; f += accuracy){
			plow.add(pos.to16Double().add(0, 0, f));
			plow.add(pos.to16Double().add(0, .5, f));
			plow.add(pos.to16Double().add(0, 1, f));
		}
		if(obj.has("out")){
			out = Pos.fromJson(obj.get("out"), true);
		}
		else{
			out = new Pos(pos.x, pos.y, pos.z + width / 2 + accuracy);
		}
		accumulate = JsonUtil.getIfExists(obj, "accumulate", true);
		return this;
	}

	@Override
	public void onUpdate(Entity entity, VehicleData data){
        if(entity.world.isRemote) return;
        VehicleEntity vehicle = (VehicleEntity) entity;
        if(!data.getAttributeBoolean(attribute, false)) return;
        if(((GenericVehicle)vehicle).speed < 3){
        	if(cooldown > 0){
        		cooldown--;
        		return;
        	}
        	cooldown = 10;
        }
        BlockPos bpos;
        int accumulated = 0;
    	IBlockState state = null;
        for(Vec3d vec : plow){
        	bpos = new BlockPos(calculate(vehicle.getRotPoint().getAxes(), entity, vec));
        	state = entity.world.getBlockState(bpos);
        	if(state.getBlock() == Blocks.AIR) continue; 
        	if(state.getMaterial() == Material.SNOW){
        		if(accumulate && state.getBlock() instanceof BlockSnow) accumulated += state.getBlock().getMetaFromState(state) + 1;
                entity.world.setBlockState(bpos, Blocks.AIR.getDefaultState(), 2);
        	}
        	else if(state.getMaterial().isReplaceable() || state.getMaterial() == Material.CACTUS || state.getMaterial() == Material.CIRCUITS){
        		entity.world.setBlockState(bpos, Blocks.AIR.getDefaultState(), 2);
        	}
        }
        if(accumulate && accumulated > 0){
        	bpos = new BlockPos(calculate(vehicle.getRotPoint().getAxes(), entity, out.to16Double()));
        	state = entity.world.getBlockState(bpos);
        	boolean snow = state.getBlock() instanceof BlockSnow;
        	if(snow) accumulated += state.getBlock().getMetaFromState(state);
        	if(snow || state.getMaterial().isReplaceable() || state.getMaterial() == Material.CACTUS || state.getMaterial() == Material.CIRCUITS){
                entity.world.setBlockState(bpos, Blocks.SNOW_LAYER.getDefaultState().withProperty(BlockSnow.LAYERS, accumulated > 8 ? 8 : accumulated), 2);
        	}
            if(accumulated > 8){
            	accumulated -= 8;
            	bpos = bpos.up();
            	if(state.getBlock() instanceof BlockSnow || state.getMaterial().isReplaceable()
            			|| state.getMaterial() == Material.CACTUS || state.getMaterial() == Material.CIRCUITS){
                    entity.world.setBlockState(bpos, Blocks.SNOW_LAYER.getDefaultState().withProperty(BlockSnow.LAYERS, accumulated > 8 ? 8 : accumulated), 2);
            	}
            }
        }
	}

    private Vec3d calculate(Axis3D axes, Entity ent, Vec3d vec){
        Vec3d rel = axes.getRelativeVector(vec);
        return new Vec3d(ent.posX + rel.x, ent.posY + rel.y, ent.posZ + rel.z);
    }

	@Override
	public VehicleScript read(VehicleData data, NBTTagCompound compound){
		return this;
	}

	@Override
	public NBTTagCompound write(VehicleData data, NBTTagCompound compound){
		return null;
	}

	@Override
	public void onSpawn(Entity entity, VehicleData data){
		//
	}

	@Override
	public void onRemove(Entity entity, VehicleData data){
		//
	}

	@Override
	public boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player){
		return false;
	}

	@Override
	public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player, EnumHand hand){
		return false;
	}

	@Override
	public void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side){
		//
	}

}
