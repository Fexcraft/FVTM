package net.fexcraft.mod.fmt.various;

import java.util.Collection;
import java.util.HashSet;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.fmt.block.EditorTileEntity;
import net.fexcraft.mod.fmt.capabilities.EPDCCU;
import net.fexcraft.mod.fmt.capabilities.EditorPlayerDataContainerCapability;
import net.fexcraft.mod.fmt.data.EditorInput;
import net.fexcraft.mod.fmt.data.Polygon;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class GenericClientEventHandler {
	
	private static Minecraft mc;
	private static EditorPlayerDataContainerCapability cap;
	private static Collection<Listener> listeners = new HashSet<>();
	static {
		listeners.add(new Listener(Keyboard.KEY_NUMPAD6, EditorInput.ADD_Y));
		listeners.add(new Listener(Keyboard.KEY_NUMPAD4, EditorInput.SUB_Y));
		//
		listeners.add(new Listener(Keyboard.KEY_NUMPAD9, EditorInput.ADD_X));
		listeners.add(new Listener(Keyboard.KEY_NUMPAD7, EditorInput.SUB_X));
		//
		listeners.add(new Listener(Keyboard.KEY_NUMPAD3, EditorInput.ADD_Z));
		listeners.add(new Listener(Keyboard.KEY_NUMPAD1, EditorInput.SUB_Z));
		//
		listeners.add(new Listener(Keyboard.KEY_UP, EditorInput.ARROW_UP));
		listeners.add(new Listener(Keyboard.KEY_DOWN, EditorInput.ARROW_DOWN));
		listeners.add(new Listener(Keyboard.KEY_LEFT, EditorInput.ARROW_LEFT));
		listeners.add(new Listener(Keyboard.KEY_RIGHT, EditorInput.ARROW_RIGHT));
		listeners.add(new Listener(Keyboard.KEY_NUMPAD8, EditorInput.ARROW_UP));
		listeners.add(new Listener(Keyboard.KEY_NUMPAD2, EditorInput.ARROW_DOWN));
		//
		listeners.add(new Listener(Keyboard.KEY_ADD, EditorInput.NEW));
		listeners.add(new Listener(Keyboard.KEY_MINUS, EditorInput.DEL));
		listeners.add(new Listener(Keyboard.KEY_DELETE, EditorInput.DEL));
	}
	private static boolean enabled;
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event){
		if(mc == null){ mc = Minecraft.getMinecraft(); }
		if((cap = mc.player.getCapability(EPDCCU.CAPABILITY, null)) == null || !cap.isEditorActive()){
			return;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RCONTROL)){
			Print.chat(mc.player, "&7Editor keybinds are now: " + ((enabled = !enabled) ? "&aenabled" : "&cdisabled") + "&8.");
		}
		if(enabled){
			listeners.forEach(lis -> {
				if(Keyboard.isKeyDown(lis.key)){
					cap.geEditorTileEntity().onKeyPress(lis.input, true);
				}
			});
		}
	}
	
	public static class Listener {
		
		private int key;
		private EditorInput input;
		
		private Listener(int key, EditorInput input){
			this.key = key; this.input = input;
		}
		
	}
	
	@SubscribeEvent
	public void displayLocationUpdate(RenderGameOverlayEvent event){
		if(event.getType() == ElementType.HOTBAR && enabled && cap.isEditorActive()){
			EditorTileEntity tile = cap.geEditorTileEntity();
			Polygon pol = tile.getPolygon();
			mc.fontRenderer.drawStringWithShadow("Group: " + tile.group + " / Selection: " + tile.selected, 4, 4, MapColor.SNOW.colorValue);
			mc.fontRenderer.drawStringWithShadow("Edit Mode: " + tile.mode, 4, 14, MapColor.SNOW.colorValue);
			if(pol == null){
				mc.fontRenderer.drawStringWithShadow("[NO POLYGON SELECTED]", 4, 24, MapColor.SNOW.colorValue);
			}
			else{
				mc.fontRenderer.drawStringWithShadow(tile.getModeLine(0, pol), 4, 24, MapColor.SNOW.colorValue);
				mc.fontRenderer.drawStringWithShadow(tile.getModeLine(1, pol), 4, 34, MapColor.SNOW.colorValue);
				mc.fontRenderer.drawStringWithShadow(tile.getModeLine(2, pol), 4, 44, MapColor.SNOW.colorValue);
			}
			mc.fontRenderer.drawStringWithShadow("Model: " + tile.modeldata.name + " // " + tile.getPos().getX() + ", " + tile.getPos().getY() + ", " + tile.getPos().getZ(), 4, pol == null ? 34 : 54, MapColor.SNOW.colorValue);
		}
		return;
	}
	
}