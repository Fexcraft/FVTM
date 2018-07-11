package net.fexcraft.mod.fmt;

import net.fexcraft.mod.fmt.capabilities.EPDCCU;
import net.fexcraft.mod.fmt.capabilities.EditorPlayerDataContainerCapability;
import net.fexcraft.mod.fmt.capabilities.UselessEditorStorageUnit;
import net.fexcraft.mod.fmt.gui.GuiHandler;
import net.fexcraft.mod.fmt.various.GenericClientEventHandler;
import net.fexcraft.mod.fmt.various.GenericEventHandler;
import net.fexcraft.mod.fmt.various.GenericReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = FMT.MODID, name = "Fex's Modelling Tool", dependencies = "required-after:fcl", version = "1.0")
public class FMT {
	
	@Mod.Instance(FMT.MODID)
	public static FMT INSTANCE;
	public static final String MODID = "fmt";
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		RegistryUtil.newAutoRegistry(MODID);
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		CapabilityManager.INSTANCE.register(EditorPlayerDataContainerCapability.class, new UselessEditorStorageUnit(), new EPDCCU.Callable());
		MinecraftForge.EVENT_BUS.register(new GenericEventHandler());
		if(event.getSide().isClient()){
			MinecraftForge.EVENT_BUS.register(new GenericClientEventHandler());
		}
		if(event.getSide().isClient()){
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new GenericReceiver());
		}
	}
	
}