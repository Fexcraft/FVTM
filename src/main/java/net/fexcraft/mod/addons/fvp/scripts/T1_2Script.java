package net.fexcraft.mod.addons.fvp.scripts;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class T1_2Script implements Vehicle.VehicleScript {

    private static final TreeMap<String, String> SETTINGS = new TreeMap<String, String>();

    static{
        SETTINGS.put("T1 Type2", "boolean");
    }
    public boolean out = false;

    public T1_2Script(){
    }

    @Override
    public ResourceLocation getId(){
        return new ResourceLocation("fvp:t1-2type");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        compound.setBoolean("Out", out);
        return compound;
    }

    @Override
    public VehicleScript readFromNBT(NBTTagCompound compound){
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
    public void onUpdate(Entity entity, VehicleData data){
        return;
    }

    @Override
    public void onKeyInput(int key, int seat, VehicleEntity ent){
        //
    }

    @Override
    public TreeMap<String, String> getSettingKeys(int seat){
        return seat == 0 ? SETTINGS : new TreeMap<String, String>();
    }

    @Override
    public void onSettingsUpdate(VehicleEntity ent, int seat, String setting, Object value){
        if(setting.equals(SETTINGS.keySet().toArray()[0]) && seat == 0){
            out = value == null ? !out : (boolean) value;
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setBoolean("Out", out);
            this.sendPacketToServer(ent.getEntity(), nbt);
        }
    }

    @Override
    public Object getSettingValue(int seat, String setting){
        if(setting.equals(SETTINGS.keySet().toArray()[0])){
            return out;
        }
        return null;
    }

}
