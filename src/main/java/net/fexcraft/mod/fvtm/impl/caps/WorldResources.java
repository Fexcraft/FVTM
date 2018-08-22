package net.fexcraft.mod.fvtm.impl.caps;

import java.util.Collection;
import java.util.Map;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Consumable;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerHolder;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.blocks.RailConnTile;
import net.fexcraft.mod.fvtm.entities.ContainerWrapper;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistry;

public class WorldResources implements net.fexcraft.mod.fvtm.api.Resources {
	
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
		if(world == null){ return null; }
		RailConnTile tile = (RailConnTile)world.getTileEntity(current_dest);
		return tile == null ? null : tile.getNext(current_dest, last_dest);
	}

	@Override
	public ContainerHolder getContainerAt(ICommandSender receiver, BlockPos position){
		ContainerHolder holder = null;
		if(world.getTileEntity(position) != null && world.getTileEntity(position) instanceof ContainerHolder){
			holder = (ContainerHolder)world.getTileEntity(position);
		}
		else{
			AxisAlignedBB aabb = new AxisAlignedBB(position);
			for(Entity e : world.loadedEntityList){
				if(holder != null) break;
				if(e instanceof ContainerHolder && e.getEntityBoundingBox().intersects(aabb)){
					holder = (ContainerHolder)e;
					break;
				}
				else if(e instanceof VehicleEntity){
					VehicleEntity ent = (VehicleEntity)e;
					if(ent.getContainers() == null || ent.getContainers().size() == 0){
						continue;
					}
					for(ContainerHolder conhol : ent.getContainers().values()){
						if(conhol instanceof ContainerWrapper){
							if(((ContainerWrapper)conhol).intersects(aabb)){
								holder = conhol;
							}
						}
						else if(conhol instanceof Entity){
							if(((Entity)conhol).getEntityBoundingBox().intersects(aabb)){
								holder = conhol; break;
							}
						}
					}
				}
				else continue;
			}
		}
		chat(receiver, "Container: " + holder.getContainerData() == null ? "none" : holder.getContainerData().getContainer().getName());
		return holder;
	}

	private void chat(ICommandSender sender, String string){
		if(sender != null && string != null){
			sender.sendMessage(new TextComponentString(Formatter.format(string)));
		}
	}
	
}