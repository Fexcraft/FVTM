package net.fexcraft.mod.fvtm.impl.caps;

import java.util.Collection;
import java.util.Map;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Consumable;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.api.capability.ContainerHolder;
import net.fexcraft.mod.fvtm.api.capability.FVTMCaps;
import net.fexcraft.mod.fvtm.api.root.ResultEntry;
import net.fexcraft.mod.fvtm.blocks.ContainerBlock;
import net.fexcraft.mod.fvtm.blocks.ContainerTileEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistry;

public class WorldResources implements net.fexcraft.mod.fvtm.api.capability.Resources {
	
	private World world;

	@Override
	public void setWorld(World world){
		this.world = world;
	}

	@Override
	public World getWorld(){
		return world;
	}

	@Override
	public VehicleData getVehicleDataFromNBT(NBTTagCompound compound){
		return Resources.getVehicleData(compound);
	}

	@Override
	public PartData getPartDataFromNBT(NBTTagCompound compound){
		return Resources.getPartData(compound);
	}

	@Override
	public PartData getPartDataFromResourceLocation(ResourceLocation resloc){
		return Resources.getPartData(resloc);
	}

	@Override
	public ContainerData getContainerDataFromNBT(NBTTagCompound compound){
		return Resources.getContainerData(compound);
	}

	@Override
	public BlockData getBlockDataFromNBT(NBTTagCompound compound){
		return Resources.getBlockData(compound);
	}

	@Override
	public Collection<Vehicle> getVehiclesByType(VehicleType type){
		return Resources.getVehiclesByType(type);
	}

	@Override
	public Collection<Vehicle> getVehiclesByAddon(Addon addon){
		return Resources.getVehiclesByAddon(addon);
	}
	
	@Override
	public IForgeRegistry<Addon> getAddons(){
		return Resources.ADDONS;
	}

	@Override
	public IForgeRegistry<Material> getMaterials(){
		return Resources.MATERIALS;
	}

	@Override
	public IForgeRegistry<Part> getParts(){
		return Resources.PARTS;
	}

	@Override
	public IForgeRegistry<Vehicle> getVehicles(){
		return Resources.VEHICLES;
	}

	@Override
	public IForgeRegistry<Container> getContainers(){
		return Resources.CONTAINERS;
	}

	@Override
	public IForgeRegistry<Block> getBlocks(){
		return Resources.BLOCKS;
	}

	@Override
	public IForgeRegistry<Consumable> getConsumables(){
		return Resources.CONSUMABLES;
	}

	@Override
	public IForgeRegistry<Attribute> getPartAttributes(){
		return Resources.PARTATTRIBUTES;
	}

	@Override
	public Map<String, Model<?, ?>> getModels(){
		return Resources.MODELS;
	}

	@Override
	public Map<String, JsonObject> getPresets(){
		return Resources.PRESETS;
	}

	@Override
	public BlockPos getNextRailCoordinate(BlockPos current_dest, BlockPos last_dest){
		/*if(world == null){ return null; } RailConnTile tile = (RailConnTile)world.getTileEntity(current_dest);
		return tile == null ? null : tile.getNext(current_dest, last_dest);*/
		return null;
	}

	@Override
	public ActionResult<ResultEntry<String, ContainerHolder>> getContainerSlotAt(ICommandSender sender, ContainerType oftype, Vec3d pos){
		AxisAlignedBB aabb = new AxisAlignedBB(pos.x - 0.5, pos.y - 0.5, pos.z - 0.5, pos.x + 0.5, pos.y + 0.5, pos.z + 0.5);
		for(Entity ent : world.loadedEntityList){
			if(ent.getCapability(FVTMCaps.CONTAINER, EnumFacing.DOWN) == null) continue;
			//if(ent.getPositionVector().distanceTo(pos) > 256) continue;
			ContainerHolder holder = ent.getCapability(FVTMCaps.CONTAINER, EnumFacing.DOWN);
			Map<String, AxisAlignedBB> aabbs = holder.getContainerAABBs(oftype); if(aabbs == null) continue;
			for(Map.Entry<String, AxisAlignedBB> entry : aabbs.entrySet()){
				if(entry.getValue().intersects(aabb)){
					return new ActionResult<ResultEntry<String, ContainerHolder>>(EnumActionResult.SUCCESS,
						new ResultEntry<String, ContainerHolder>(entry.getKey(), holder));
				}
			}
		}
		if(sender != null) Print.chat(sender, "No container found at position.");
		return new ActionResult<ResultEntry<String, ContainerHolder>>(EnumActionResult.PASS, null);
	}

	@Override
	public ActionResult<ContainerData> getContainerBlock(ICommandSender sender, BlockPos pos, Axis axis){
		if(axis == null || axis == Axis.Y){
			if(sender != null) Print.chat(sender, "Invalid axis data.");
			return new ActionResult<ContainerData>(EnumActionResult.PASS, null);
		}
		IBlockState block = world.getBlockState(pos);
		if(block == null || block.getBlock() == Blocks.AIR || block.getBlock() instanceof ContainerBlock == false){
			if(sender != null) Print.chat(sender, "No Container Block at position.");
			return new ActionResult<ContainerData>(EnumActionResult.FAIL, null);
		}
		if(block.getValue(ContainerBlock.FACING).getAxis() != axis){
			if(sender != null) Print.chat(sender, "Container's facing axis is different than requested.");
			return new ActionResult<ContainerData>(EnumActionResult.PASS, null);
		}
		ContainerTileEntity tile = (ContainerTileEntity)world.getTileEntity(pos);
		if(!tile.isCore()){
			if(sender != null){
				Print.chat(sender, "This is not the Container's Core."); BlockPos core = tile.getCorePos();
				Print.chat(sender, String.format("(%s, %s, %s) core: %s, %s, %s", pos.getX(), pos.getY(), pos.getZ(), core.getX(), core.getY(), core.getZ()));
			}
			return new ActionResult<ContainerData>(EnumActionResult.PASS, null);
		}
		return new ActionResult<ContainerData>(EnumActionResult.SUCCESS, tile.getContainerData());
	}
	
}