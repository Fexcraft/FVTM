/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fexcraft.mod.addons.hcp.scripts;

import java.util.TreeMap;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 * @author Ferdinand (FEX___96)
 */
public class ContainerCraneScript implements VehicleScript {
    
    private static final TreeMap<String, String> settings = new TreeMap<>();
    static {
        settings.put("catch", "boolean");
        settings.put("release", "boolean");
        settings.put("h-move", "boolean");
        settings.put("h-direction", "integer");
        settings.put("v-move", "boolean");
        settings.put("v-direction", "integer");
    }
    private ContainerData data;
    private boolean trycatch, release, hmove, vmove;
    private int hdirection, vdirection;

    @Override
    public ResourceLocation getId(){
        return new ResourceLocation("hcp:container_crane");
    }

    @Override
    public void onDataPacket(Entity entity, Vehicle.VehicleData data, NBTTagCompound compound, Side side){
        
    }

    @Override
    public void onCreated(Entity entity, Vehicle.VehicleData data){
        
    }

    @Override
    public boolean onInteract(Entity entity, Vehicle.VehicleData data, EntityPlayer player){
        return false;
    }

    @Override
    public void onUpdate(Entity entity, Vehicle.VehicleData data){
        ((VehicleEntity)entity).setThrottle(0);
    }

    @Override
    public void onRemove(Entity entity, Vehicle.VehicleData data){
        data = null;
    }

    @Override
    public TreeMap<String, String> getSettingKeys(int seat){
        return settings;
    }

    @Override
    public void onSettingsUpdate(Vehicle.VehicleEntity ent, int seat, String setting, Object value){
        switch(setting){
            
        }
    }

    @Override
    public Object getSettingValue(int seat, String setting){
        switch(setting){
            case "catch": return trycatch;
            case "relase": return release;
            case "h-move": return hmove;
            case "v-move": return vmove;
            case "h-direction": return hdirection;
            case "v-direction": return vdirection;
        }
        return 0;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        if(data != null){
            data.writeToNBT(compound);
        }
        return compound;
    }

    @Override
    public VehicleScript readFromNBT(NBTTagCompound compound){
        if(compound.hasKey(ContainerItem.NBTKEY)){
            data = Resources.getContainerData(compound);
        }
        return this;
    }
    
}
