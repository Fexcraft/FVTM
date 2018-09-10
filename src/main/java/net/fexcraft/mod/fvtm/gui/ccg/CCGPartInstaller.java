package net.fexcraft.mod.fvtm.gui.ccg;

import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.GenericGuiContainer;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class CCGPartInstaller extends GenericGui<CCGPartInstaller.Container> {
	
	private int[] pos;
	private int scroll = 0;

	public CCGPartInstaller(EntityPlayer player, World world, int x, int y, int z){
		super(new ResourceLocation("fvtm:textures/guis/ccg_installer.png"), new Container(world, x, y, z), player);
		this.xSize = 142; this.ySize = 128; this.pos = new int[]{ x, y, z };
	}

	@Override
	protected void init(){
		this.texts.put("title", new BasicText(guiLeft + 13, guiTop +  4, 124, null, "Install: x...xx...x"));
		//
		this.buttons.put("+", new BasicButton("+", guiLeft + 3, guiTop + 103, 3, 103, 8, 10, false));
		this.buttons.put("-", new BasicButton("-", guiLeft + 3, guiTop +  19, 3,  19, 8, 10, false));
		//
		for(int i = 0; i < 8; i++){
			this.texts.put("row" + i, new BasicText(guiLeft + 13, guiTop + 20 + (i * 12), 124, null, i + ""));
			this.buttons.put("row" + i, new BasicButton("row" + i, guiLeft + 11, guiTop + 19 + (i * 12), 11, 19, 128, 10, false));
		}
		//
		this.texts.put("custom", new BasicText(guiLeft + 13, guiTop + 116, 48, null, "Custom: "));
		this.buttons.put("custom", new BasicButton("custom", guiLeft + 11, guiTop + 115, 11, 115, 52, 10, false));
		this.fields.put("custom", new GuiTextField(0, fontRenderer, guiLeft + 63, guiTop + 115, 76, 10));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		boolean nell = container.tile.getPartData() == null;
		texts.get("title").string = nell ? "no part in constructor" : "Install: " + container.tile.getPartData().getPart().getName();
		for(int i = 0; i < 8; i++){
			int j = i + scroll;
			if(nell){
				buttons.get("-").enabled = buttons.get("+").enabled = false;
				buttons.get("row" + i).enabled = false; texts.get("row" + i).string = "";
				buttons.get("custom").enabled = false;
			}
			else{
				buttons.get("-").enabled = scroll > 0; buttons.get("+").enabled = scroll < container.tile.getPartData().getPart().getCategories().size();
				buttons.get("row" + i).enabled = !(j >= container.tile.getPartData().getPart().getCategories().size());
				texts.get("row" + i).string = j >= container.tile.getPartData().getPart().getCategories().size() ? "" : container.tile.getPartData().getPart().getCategories().get(j);
				buttons.get("custom").enabled = container.tile.getPartData().getPart().isAdjustable();
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
			case "+": scroll = ++scroll > (container.tile.getPartData() == null ? 0 : container.tile.getPartData().getPart().getCategories().size()) ? --scroll : scroll; break;
			case "-": scroll = --scroll < 0 ? 0 : scroll; break;
			//
			case "custom":{
				if(fields.get("custom").getText().length() == 0){
					Print.chat(player, "Missing category name.");
				}
				NBTTagCompound compound = new NBTTagCompound();
		        compound.setIntArray("pos", pos);
		        compound.setString("category", fields.get("custom").getText());
				compound.setBoolean("custom", true);
		        this.container.send(Side.SERVER, compound);
				break;
			}
		}
		if(key.startsWith("row")){
			String str = container.tile.getPartData().getPart().getCategories().get(Integer.parseInt(key.replace("row", "")) + scroll);
			NBTTagCompound compound = new NBTTagCompound(); compound.setIntArray("pos", pos); compound.setString("category", str);
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
			if(side.isClient() || !packet.hasKey("category") || tile.getPartData() == null || tile.getVehicleData() == null) return;
			String str = packet.getString("category");
			if(packet.hasKey("custom") && packet.getBoolean("custom") && !tile.getPartData().getPart().isAdjustable()){
				return;//TODO message
			}
            if(tile.getVehicleData().getPart(str) != null){
                Print.chat(player, "There is already a part installed in that category.");
                return;
            }
            if(tile.getPartData().getPart().installable(str, tile.getVehicleData(), player)){
                tile.getVehicleData().installPart(str, tile.getPartData());
                Print.chat(player, "Part processed. (" + tile.getPartData().getPart().getName() + ")");
                tile.setPartData(null); tile.sendUpdate(null);
            }
            else{
                return;
            }
		}
		
	}
	
    /*@Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(keyCode == 1) this.openGui(GuiHandler.CCG_Main, pos);
        super.keyTyped(typedChar, keyCode);
    }*/
	
}