package net.fexcraft.mod.addons.gep;

import java.io.File;

import net.fexcraft.mod.addons.gep.attributes.*;
import net.fexcraft.mod.addons.gep.fuels.*;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.impl.HybridAddon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GeneralEssentials extends HybridAddon {

    public GeneralEssentials(File file){
        super(file);
    }
    
    public void onPreInit(FMLPreInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void regFuels(Register<Fuel> event){
        event.getRegistry().registerAll(
        	new Gasoline(),
        	new Diesel()
        );
    }

    @SubscribeEvent
    public void regAttributes(Register<Attribute> event){
        event.getRegistry().registerAll(
        	new EngineAttribute(),
        	new FuelTankExtensionAttribute(),
        	new FMSeatAttribute(),
        	new InventoryAttribute(),
        	new ConnectorAttribute(),
        	new ContainerAttribute(),
        	new LightProviderAttribute(),
        	new FontRendererAttribute()
        );
    }

    @Override
    public boolean skipDefaultRegistryMethods(){
        return false;
    }

}
