package net.fexcraft.mod.fvtm.gui.ccg;

import java.io.IOException;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.GenericGuiContainer;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class CCGPartManager extends GenericGui<CCGPartManager.Container> {
	
	private int[] pos;
	private int scroll = 0;

	public CCGPartManager(EntityPlayer player, World world, int x, int y, int z){
		super(new ResourceLocation("fvtm:textures/guis/ccg_manager.png"), new Container(world, x, y, z), player);
		this.xSize = 200; this.ySize = 176; this.pos = new int[]{ x, y, z };
	}

	@Override
	protected void init(){
		this.texts.put("title", new BasicText(guiLeft + 13, guiTop + 4, 182, null, "0"));
		//
		this.buttons.put("+", new BasicButton("+", guiLeft + 3, guiTop + 151, 3, 151, 8, 10, false));
		this.buttons.put("-", new BasicButton("-", guiLeft + 3, guiTop +  19, 3,  19, 8, 10, false));
		//
		for(int i = 0; i < 12; i++){
			this.texts.put("row" + i, new BasicText(guiLeft + 13, guiTop + 20 + (i * 12), 181, null, i + ""));
			this.buttons.put("edit" + i, new BasicButton("e" + i, guiLeft + 175, guiTop + 19 + (i * 12), 175, 19, 10, 10, false));
			this.buttons.put("rem" + i, new BasicButton("r" + i, guiLeft + 187, guiTop + 19 + (i * 12), 187, 19, 10, 10, false));
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(container.tile.getVehicleData() == null){
			texts.get("title").string = "no vehicle";
			buttons.get("+").enabled = false; buttons.get("-").enabled = false;
		}
		else{
			texts.get("title").string = container.tile.getVehicleData().getVehicle().getName();
			Part.PartData[] arr = container.tile.getVehicleData().getParts().values().toArray(new Part.PartData[]{});
			buttons.get("+").enabled = scroll < arr.length; buttons.get("-").enabled = scroll > 0;
			//
			for(int j = 0; j < 12; j ++){
				int k = scroll + j; texts.get("row" + j).string = k >= arr.length ? "" : arr[k].getPart().getName();
				buttons.get("edit" + j).enabled = k >= arr.length ? false : arr[k].getPart().isAdjustable();//TODO
				buttons.get("rem" + j).enabled = k >= arr.length ? false : arr[k].getPart().isRemovable();//TODO
			}
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		switch(key){
			case "+": scroll = ++scroll > (container.tile.getVehicleData() == null ? 0 : container.tile.getVehicleData().getParts().size()) ? --scroll : scroll; break;
			case "-": scroll = --scroll < 0 ? 0 : scroll; break;
		}
		if(key.startsWith("edit")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("part", container.tile.getVehicleData().getParts().keySet().toArray(new String[]{})[Integer.parseInt(key.replace("edit", "")) + scroll]);
			this.openGenericGui(GuiHandler.CCG_PartAdjuster, pos, compound);
		}
		else if(key.startsWith("rem")){
	        NBTTagCompound compound = new NBTTagCompound();
	        compound.setIntArray("pos", pos);
	        compound.setString("cargo", "remove");
	        compound.setString("part", container.tile.getVehicleData().getParts().keySet().toArray(new String[]{})[Integer.parseInt(key.replace("rem", "")) + scroll]);
	        this.container.send(Side.SERVER, compound);
		}
	}
	
	public static class Container extends GenericGuiContainer {
		
		private ConstructorControllerEntity tile;
		
		public Container(World world, int x, int y, int z){
			tile = (ConstructorControllerEntity)world.getTileEntity(new BlockPos(x, y, z));
		}

		@Override
		protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
			if(side.isClient() || !packet.hasKey("cargo")) return;
			switch(packet.getString("cargo")){
				case "remove":{
					String part = !packet.hasKey("part") ? null : packet.getString("part");
					if(part == null || tile.getVehicleData() == null) return;
					Part.PartData data = tile.getVehicleData().getPart(part);
                    if(data == null || !data.getPart().isRemovable()){
                        Print.chat(player, data == null ? "Part not found in Server Instance." : "Part is marked as non-remove on Server Instance!");
                        return;
                    }
                    data = tile.getVehicleData().getParts().remove(part);
                    if(data == null){ Print.chat(player, "Error, see log for location.");Static.exception(new Exception(), false); }
                    EntityItem item = new EntityItem(tile.getWorld());
                    item.setItem(data.getPart().getItemStack(data));
                    item.setPosition(tile.getPos().getX() + 0.5, tile.getPos().getY() + 1.5, tile.getPos().getZ() + 0.5);
                    tile.getWorld().spawnEntity(item);
                    tile.sendUpdate("vehicledata");
					break;
				}
			}
		}
		
	}
	
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(keyCode == 1) this.openGui(GuiHandler.CCG_Main, pos);
        super.keyTyped(typedChar, keyCode);
    }
	
}