package net.fexcraft.mod.fmt.gui;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fmt.FMT;
import net.fexcraft.mod.fmt.block.EditorTileEntity;
import net.fexcraft.mod.fmt.data.Polygon;
import net.fexcraft.mod.fmt.data.Polygon.PolygonType;
import net.fexcraft.mod.lib.adjgui.AdjustableGuiContainer;
import net.fexcraft.mod.lib.adjgui.CustomGuiElement;
import net.fexcraft.mod.lib.adjgui.SynchronizedContainer;
import net.fexcraft.mod.lib.adjgui.elements.AdjustableTextField;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Container extends SynchronizedContainer {
	
	private static final ResourceLocation loc = new ResourceLocation(FMT.MODID, "generic");
	private EditorTileEntity tile;
	private int mode;

	public Container(boolean bool, JsonObject json, EntityPlayer player, Object... objs){
		super(bool, json, player); mode = (int)objs[0];
		if(mode >= EditorTileEntity.modes.length){ mode = 0; }
		tile = (EditorTileEntity)player.world.getTileEntity(new BlockPos((int)objs[2], (int)objs[3], (int)objs[4]));
		for(int i = 0; i < 3; i++){
			char r = i == 0 ? 'x' : i == 1 ? 'y' : 'z';
			GuiTextField field = ((AdjustableTextField)this.elements.get("field_" + r)).getTextField();
			field.setText(tile.getModeValue(i, tile.getPolygon()).toString());
		}
	}

	@Override
	public ResourceLocation getId(){
		return loc;
	}

	@Override
	public void onDataPacket(EntityPlayer player, NBTTagCompound data, Side from){
		return;//switch(EditorTileEntity.modes[mode]){}
	}

	@Override
	public void onEvent(EntityPlayer player, NBTTagCompound data, String type, CustomGuiElement element){
		Print.debug(player, data, type, element);
		if(type.equals("button_click")){
			
		}
		else if(type.equals("textfield_click")){
			int i = element.getId().endsWith("_x") ? 0 : element.getId().endsWith("_z") ? 2 : 1;
			String str = data.getString("text");
			Polygon pol = tile.getPolygon();
			switch(EditorTileEntity.modes[mode]){
				case "move":{
					Float f = Float.parseFloat(str);
					switch(i){
						case 0: pol.rotationpoint.x = f; break; case 1: pol.rotationpoint.y = f; break; case 2: pol.rotationpoint.z = f; break;
					}
					break;
				}
				case "offset":{
					Float f = Float.parseFloat(str);
					switch(i){
						case 0: pol.offset.x = f; break; case 1: pol.offset.y = f; break; case 2: pol.offset.z = f; break;
					}
					break;
				}
				case "resize":{
					Float f = Float.parseFloat(str);
					switch(i){
						case 0: pol.width = f; break; case 1: pol.height = f; break; case 2: pol.depth = f; break;
					}
					break;
				}
				case "texture":{
					int f = Integer.parseInt(str);
					switch(i){
						case 0: pol.texturex = f; break; case 1: pol.texturey = f; break;
					}
					break;
				}
				case "rotation":{
					Float f = Float.parseFloat(str);
					switch(i){
						case 0: pol.rotationangle.x = f; break; case 1: pol.rotationangle.y = f; break; case 2: pol.rotationangle.z = f; break;
					}
					break;
				}
				case "type":{
					switch(i){
						case 0:{
							pol.type = PolygonType.fromString(str);
							break;
						}
						case 1:{
							pol.boxname = str;
							break;
						}
						case 2:{
							pol.scale = Float.parseFloat(str);
							break;
						}
					}
					break;
				}
				case "bools":{
					boolean bool = Boolean.parseBoolean(str);
					switch(i){
						case 0:{ pol.oldrot = bool; break; }
						case 1:{ pol.mirror = bool; break; }
						case 2:{ pol.flip = bool; break; }
					}
					break;
				}
				case "cylinder":{
					switch(i){
						case 0:{ pol.radius = Float.parseFloat(str); break; }
						case 1:{ pol.length = Float.parseFloat(str); break; }
						case 2:{ pol.segments = Integer.parseInt(str); break; }
					}
					break;
				}
				case "cylinder2":{
					switch(i){
						case 0:{ pol.direction = Integer.parseInt(str); break; }
						case 1:{ pol.topscale = Float.parseFloat(str); break; }
						case 2:{ pol.basescale = Float.parseFloat(str); break; }
					}
					pol.direction = pol.direction > 5 ? 5 : pol.direction < 0 ? 0 : pol.direction;
					break;
				}
			}
			if(EditorTileEntity.modes[mode].startsWith("shapebox_corner")){
				int j = Integer.parseInt(EditorTileEntity.modes[mode].replace("shapebox_corner_", ""));
				switch(i){
					case 0: { pol.corners[j].x = Float.parseFloat(str); break; }
					case 1: { pol.corners[j].y = Float.parseFloat(str); break; }
					case 2: { pol.corners[j].z = Float.parseFloat(str); break; }
				}
			}
			tile.sendUpdate("update_polygon", tile.group, tile.selected, pol.toJTMT());
		}
	}

	@SideOnly(Side.CLIENT )@Override
	public void drawGuiContainer(AdjustableGuiContainer gui, float pt, int mouseX, int mouseY){
		FontRenderer renderer = net.minecraft.client.Minecraft.getMinecraft().fontRenderer;
		renderer.drawString("Editor Modus: " + EditorTileEntity.modes[mode].replace("shapebox", "sb"), gui.getGuiLeft() + 3, gui.getGuiTop() + 3, MapColor.BLACK.colorValue);
		renderer.drawString("Polygon: " + (tile.getPolygon() == null ? "none" : tile.getPolygon().boxname == null ? "unnamed polygon" : tile.getPolygon().boxname), gui.getGuiLeft() + 3, gui.getGuiTop() + 56, MapColor.BLACK.colorValue);
	}
	
}