package net.fexcraft.mod.fvtm.impl;

import java.io.File;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Consumable;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.minecraft.util.SoundEvent;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class HybridAddon extends GenericAddon {

    public HybridAddon(File file){
        super(file);
        hybrid = true;
    }

    public void regFuels(Register<Fuel> event){ }

    public void regMaterials(RegistryEvent.Register<Material> event){ }

    public void regAttributes(RegistryEvent.Register<Attribute> event){ }

    public void regParts(RegistryEvent.Register<Part> event){ }

    public void regVehicles(RegistryEvent.Register<Vehicle> event){ }

    public void regContainers(Register<Container> event){ }

    public void regSounds(Register<SoundEvent> event){ }

    /**
     * Set `true` if you want to skip default JSON config search and parsing for
     * this addon.
     */
    public boolean skipDefaultRegistryMethods(){ return false; }

    public void regConsumables(Register<Consumable> event){ }

	public void regBlocks(Register<Block> event){ }
	
	public void onAttachCapabilities(AttachCapabilitiesEvent<PartData> event){}
	
	public void onPreInit(FMLPreInitializationEvent event){}

}
