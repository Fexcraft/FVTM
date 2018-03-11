package net.fexcraft.mod.addons.gep;

import java.io.File;

import net.fexcraft.mod.addons.gep.attributes.*;
import net.fexcraft.mod.addons.gep.fuels.*;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.impl.HybridAddon;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent.Register;

public class GeneralEssentials extends HybridAddon {

	public GeneralEssentials(File file){
		super(file);
	}

	@Override
	public void regFuels(Register<Fuel> event){
		event.getRegistry().registerAll(
			new Gasoline(),
			new Diesel()
		);
	}

	@Override
	public void regMaterials(Register<Material> event){
		//
	}

	@Override
	public void regAttributes(Register<Attribute> event){
		event.getRegistry().registerAll(
			new EngineAttribute(),
			new FuelTankExtensionAttribute(),
			new FMSeatAttribute(),
			new InventoryAttribute(),
			new ConnectorAttribute(),
			new ContainerAttribute(),
			new LightProviderAttribute()
		);
	}

	@Override
	public void regParts(Register<Part> event){
		//
	}

	@Override
	public void regVehicles(Register<Vehicle> event){
		//
	}

	@Override
	public boolean skipDefaultRegistryMethods(){
		return false;
	}

	@Override
	public void regSounds(Register<SoundEvent> event){
		//
	}

	@Override
	public void regContainers(Register<Container> event){
		//
	}
	
}