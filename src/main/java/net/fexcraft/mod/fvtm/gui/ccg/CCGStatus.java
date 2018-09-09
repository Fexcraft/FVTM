package net.fexcraft.mod.fvtm.gui.ccg;

import net.fexcraft.mod.fvtm.blocks.ConstructorCenterEntity;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.GenericGuiContainer;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class CCGStatus extends GenericGui<CCGStatus.Container> {
	
	private int[] pos;
	private ConstructorControllerEntity tile;

	public CCGStatus(EntityPlayer player, World world, int x, int y, int z){
		super(new ResourceLocation("fvtm:textures/guis/ccg_status.png"), new Container(world, x, y, z), player);
		this.xSize = 128; this.ySize = 84; this.pos = new int[]{ x, y, z };
		tile = (ConstructorControllerEntity)world.getTileEntity(new BlockPos(x, y, z));
	}
	
	public static class Container extends GenericGuiContainer {
		
		private World world; int x, y, z;
		
		public Container(World world, int x, int y, int z){
			this.world = world; this.x = x; this.y = y; this.z = z;
		}

		@Override
		protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
			Print.debug(packet);
			if(side.isClient()) return;
			if(packet.hasKey("auto") && packet.getBoolean("auto")){
				ConstructorControllerEntity tile = (ConstructorControllerEntity)world.getTileEntity(new BlockPos(x, y, z));
                if(tile.center == null){
                    tile.scanAndConnect(player);
                }
                else Print.chat(player, "Constructor is already connected.");
			}
			else{
				int[] arr = packet.hasKey("centerpos") ? arr = packet.getIntArray("centerpos") : null;
				if(arr == null) return;
				ConstructorControllerEntity tile = (ConstructorControllerEntity)world.getTileEntity(new BlockPos(x, y, z));
				TileEntity center = world.getTileEntity(new BlockPos(arr[0], arr[1], arr[2]));
				if(center == null){
					Print.chat(player, "No tileentity at position.");
					return;
				}
				if(center instanceof ConstructorCenterEntity == false){
					Print.chat(player, "TileEntity at position is not a Constructor Center.");
					return;
				}
                ((ConstructorCenterEntity)center).link(tile.getPos());
                tile.center = center.getPos(); tile.sendUpdate("center");
                Print.chat(player, "&aConnected&7!");
			}
		}
		
	}

	@Override
	protected void init(){
		this.texts.put("status", new BasicText(guiLeft + 13, guiTop + 4, 112, null, "---"));
		this.fields.put("x", new GuiTextField(0, fontRenderer, 3 + guiLeft, 15 + guiTop, 122, 10));
		this.fields.put("y", new GuiTextField(1, fontRenderer, 3 + guiLeft, 27 + guiTop, 122, 10));
		this.fields.put("z", new GuiTextField(1, fontRenderer, 3 + guiLeft, 39 + guiTop, 122, 10));
		this.texts.put("refresh", new BasicText(guiLeft + 13, guiTop + 52, 112, null, "Set Center Position"));
		this.buttons.put("refresh", new BasicButton(null, guiLeft + 11, guiTop + 51, 11, 51, 114, 10, true));
		this.texts.put("auto", new BasicText(guiLeft + 13, guiTop + 68, 112, null, "Auto Connect"));
		this.buttons.put("auto", new BasicButton(null, guiLeft + 11, guiTop + 67, 11, 67, 114, 10, true));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		this.texts.get("status").string = "Connected: " + (tile.center != null);
		if(fields.get("x").getText().length() == 0){
			fields.get("x").setText(tile.center == null ? "0" : tile.center.getX() + "");
		}
		if(fields.get("y").getText().length() == 0){
			fields.get("y").setText(tile.center == null ? "0" : tile.center.getY() + "");
		}
		if(fields.get("z").getText().length() == 0){
			fields.get("z").setText(tile.center == null ? "0" : tile.center.getZ() + "");
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(key.equals("refresh")){
	        try{
		        NBTTagCompound compound = new NBTTagCompound();
		        compound.setIntArray("pos", pos);
		        compound.setIntArray("centerpos", new int[]{
		        	Integer.parseInt(fields.get("x").getText()),
		        	Integer.parseInt(fields.get("y").getText()),
		        	Integer.parseInt(fields.get("z").getText())
		        });
		        this.container.send(Side.SERVER, compound);
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
		}
		if(key.equals("auto")){
	        NBTTagCompound compound = new NBTTagCompound();
	        compound.setIntArray("pos", pos);
	        compound.setBoolean("auto", true);
	        this.container.send(Side.SERVER, compound);
		}
	}
	
}