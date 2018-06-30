package net.fexcraft.mod.fmt.various;

import net.fexcraft.mod.fmt.capabilities.EPDCCU;
import net.fexcraft.mod.fmt.capabilities.EditorPlayerDataContainerCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GenericEventHandler {
	
	@SubscribeEvent
	public void onRepawn(PlayerEvent.Clone event){
		EditorPlayerDataContainerCapability cap = event.getEntityPlayer().getCapability(EPDCCU.CAPABILITY, null);
		EditorPlayerDataContainerCapability old = event.getOriginal().getCapability(EPDCCU.CAPABILITY, null);
		if(cap != null && old != null){
			cap.setEditorTileEntity(old.geEditorTileEntity());
		}
	}
	
	@SubscribeEvent
	public void onAttach(AttachCapabilitiesEvent<Entity> event){
		if(event.getObject() instanceof EntityPlayer){
			event.addCapability(EPDCCU.REGISTRY_NAME, new EPDCCU((EntityPlayer)event.getObject()));
		}
	}
	
}