package net.fexcraft.mod.fvtm.gui.other;

import java.util.ArrayList;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.FvtmPlayerData;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class SpawnSystemContainer extends GenericContainer {
	
	protected GenericGui<SpawnSystemContainer> gui;

	public SpawnSystemContainer(EntityPlayer player, int x, int y, int z){
		super(player);
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(side.isServer()){
			switch(packet.getString("cargo")){
				case "init_data":{
					NBTTagCompound compound = new NBTTagCompound();
					compound.setString("cargo", "init_data");
					VehicleType type = VehicleType.values()[packet.getInteger("type")];
					ArrayList<String> found = EntitySystem.getValidFor(type);
					compound.setInteger("found", found.size());
					for(int i = 0; i < found.size(); i++){
						compound.setString("found" + i, found.get(i));
					}
					send(Side.CLIENT, compound);
					break;
				}
				case "spawn":{
					EntitySystem sys = EntitySystem.REGISTRY.get(packet.getString("system"));
					boolean demo = packet.getBoolean("demo"), save = packet.getBoolean("save");
					VehicleType type = VehicleType.values()[packet.getInteger("type")];
					ItemStack stack = player.getHeldItemMainhand();
					VehicleData data = stack.getCapability(Capabilities.VAPDATA, null).getVehicleData().copy();
					player.closeScreen();
					FvtmPlayerData pd = UniEntity.get(player).getApp(FvtmPlayerData.class);
					if(!demo && sys.canSpawn(pd.getPlayer(), pd.getActiveSpawnPoint(), data, StackWrapper.wrap(stack))){
						sys.spawn(pd.getPlayer(), pd.getActiveSpawnPoint(), data, StackWrapper.wrap(stack));
					}
					if(save){
						pd.setFavoriteSpawnSystemFor(type, sys.getId());
					}
					break;
				}
			}
		}
		else{
			switch(packet.getString("cargo")){
				case "init_data":{
					((SpawnSystemChooser)gui).init(packet);
					break;
				}
			}
		}
	}

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }

}
