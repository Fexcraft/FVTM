package net.fexcraft.mod.fvtm.impl;

import java.io.File;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Consumable;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.minecraft.util.SoundEvent;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;

public abstract class HybridAddon extends GenericAddon {
	
	public HybridAddon(File file){
		super(file);
		hybrid = true;
	}

	public void regFuels(Register<Fuel> event){}
	
	public abstract void regMaterials(RegistryEvent.Register<Material> event);

	public void regAttributes(RegistryEvent.Register<Attribute> event){}
	
	public abstract void regParts(RegistryEvent.Register<Part> event);
	
	public abstract void regVehicles(RegistryEvent.Register<Vehicle> event);
	
	public abstract void regContainers(Register<Container> event);

	public void regSounds(Register<SoundEvent> event){}
	
	/** Set `true` if you want to skip default JSON config search and parsing for this addon. */
	public abstract boolean skipDefaultRegistryMethods();

	public void regConsumables(Register<Consumable> event){}
	
}