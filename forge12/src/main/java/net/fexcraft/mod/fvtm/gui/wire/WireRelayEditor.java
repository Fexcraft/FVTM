package net.fexcraft.mod.fvtm.gui.wire;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.rail.RailPlacer;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireKey;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

public class WireRelayEditor extends GenericGui<WireRelayContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/wire_relay.png");
	private ArrayList<String> tooltip = new ArrayList<>();
	public static final float[][] WIRE_COLOR = new float[64][];
	public static final RGB[] WIRE_COLOR_RGB = new RGB[64];
	static {
		for(int i = 0; i < WIRE_COLOR.length; i++){
			WIRE_COLOR_RGB[i] = RGB.random();
			WIRE_COLOR[i] = WIRE_COLOR_RGB[i].toFloatArray();
		}
	}
	private static int GRIDSIZE = 32;
	private static RGB[][] GRID;
	private static BlockPos[][] POSGRID;
	private static IBlockState[][] STATEGRID;
	private int scroll;
	
	public WireRelayEditor(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new WireRelayContainer(player, world, x, y, z, false), player);
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 248;
		this.ySize = 187;
		GRID = null;
	}

	@Override
	protected void init(){
		texts.put("title", new BasicText(guiLeft + 9, guiTop + 9, 205, MapColor.SNOW.colorValue, container.relay.getKey()));
		buttons.put("help", new BasicButton("help", guiLeft + 216, guiTop + 7, 216, 7, 12, 12, true));
		buttons.put("copy", new BasicButton("copy", guiLeft + 229, guiTop + 7, 229, 7, 12, 12, true));
		for(int i = 0; i < 6; i++){
			int j =  + (i * 14);
			texts.put("wire" + i, new BasicText(guiLeft + 12, guiTop + 96 + j, 211, MapColor.SNOW.colorValue, ""));
			buttons.put("edit" + i, new BasicButton("edit" + i, guiLeft + 226, guiTop + 94 + j, 226, 94 + j, 7, 12, true));
			buttons.put("del" + i, new BasicButton("del" + i, guiLeft + 234, guiTop + 94 + j, 234, 94 + j, 7, 12, true));
			if(i < 4){
				texts.put("info" + i, new BasicText(guiLeft + 75, guiTop + 28 + (i * 14), 164, MapColor.SNOW.colorValue, ""));
			}
		}
		buttons.put("up", new BasicButton("up", guiLeft + 193, guiTop + 88, 193, 88, 15, 5, true));
		buttons.put("dw", new BasicButton("dw", guiLeft + 210, guiTop + 88, 210, 88, 15, 5, true));
		//
		texts.get("info0").string = "Block: " + container.tile.getPos().getX() + ", " + container.tile.getPos().getY() + ", " + container.tile.getPos().getZ();
		texts.get("info1").string = "Index: " + container.conns.indexOf(WireRelayContainer.SELRELAY) + " / " + WireRelayContainer.SELRELAY;
	}
	
	private void initGrid(){
		GRID = new RGB[GRIDSIZE][GRIDSIZE];
		POSGRID = new BlockPos[GRIDSIZE][GRIDSIZE];
		STATEGRID = new IBlockState[GRIDSIZE][GRIDSIZE];
		BlockPos junc = container.tile.getPos();
		int half = GRIDSIZE / 2;
		for(int i = -half; i < half; i++){
			for(int j = -half; j < half; j++){
				BlockPos pos = RailPlacer.getPos(player.world, i + junc.getX(), j + junc.getZ());
				IBlockState state = player.world.getBlockState(pos);
				POSGRID[i + half][j + half] = pos;
				STATEGRID[i + half][j + half] = state;
			}
		}
		int d;
		for(int i = 0; i < GRIDSIZE; i++){
			for(int j = 0; j < GRIDSIZE; j++){
				int m = 0;
				if(RailPlacer.isWater(STATEGRID[i][j].getBlock())){
					d = 0;
					for(int k = 0; k < 256; k++){
						if(RailPlacer.isWater(player.world.getBlockState(POSGRID[i][j].down(k)).getBlock())) d++;
						else break;
					}
					if(d > 5) m = d > 10 ? 0 : 1; else m = 2;
				}
				else{
					m = 1;
					if(player.world.getBlockState(POSGRID[i][j].add(0, 1, -1)).getMapColor(player.world, POSGRID[i][j]) != MapColor.AIR) m--;
					if(player.world.getBlockState(POSGRID[i][j].add(0, 0, -1)).getMapColor(player.world, POSGRID[i][j]) == MapColor.AIR) m++;
				}
				GRID[i][j] = new RGB(STATEGRID[i][j].getMapColor(player.world, POSGRID[i][j]).getMapColor(m));
			}
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(GRID == null) initGrid();
		for(int i = 0; i < 6; i++){
			int j = i + scroll;
			if(j >= container.relay.size()){
				texts.get("wire" + i).string = "";
			}
			else{
				texts.get("wire" + i).string = container.relay.wires.get(j).key.toString();
			}
		}
		texts.get("info2").string = "Wires: " + container.relay.size();
		texts.get("info3").string = "Section: " + "w. in p.";
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < 6; i++){
			int j = i + scroll;
			if(j < container.relay.size()){
				WIRE_COLOR_RGB[j].glColorApply();
				drawTexturedModalRect(guiLeft + 8, guiTop + 95 + (i * 14), 8, 95, 2, 10);
			}
		}
		RGB.glColorReset();
		for(int i = 0; i < GRIDSIZE; i++){
			for(int j = 0; j < GRIDSIZE; j++){
				GRID[i][j].glColorApply();
				drawTexturedModalRect(guiLeft + 7 + i * 2, guiTop + 21 + j * 2, 7, 21, 2, 2);
			}
		}
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glLineWidth(4f);
		for(int i = 0; i < container.relay.size(); i++){
			renderWire(container.relay.wires.get(i), WIRE_COLOR[i], container.relay.getHolder().pos);
		}
		GL11.glLineWidth(1f);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	
	private void renderWire(Wire wire, float[] color,  BlockPos junc){
		Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
		V3D vec0, vec1;
        if(wire.vecpath.length == 2){
        	vec0 = wire.vecpath[00];
        	vec1 = vec0.distance(wire.vecpath[1], 15);
			bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos((vec0.x - junc.getX() + 16) * 2 + guiLeft + 7, (vec0.z - junc.getZ() + 16) * 2 + guiTop + 21, zLevel + 1).color(color[0], color[1], color[2], 1F).endVertex();
			bufferbuilder.pos((vec1.x - junc.getX() + 16) * 2 + guiLeft + 7, (vec1.z - junc.getZ() + 16) * 2 + guiTop + 21, zLevel + 1).color(color[0], color[1], color[2], 1F).endVertex();
			tessellator.draw();
        	return;
        }
        double x0, x1, z0, z1;
		for(int j = 0; j < wire.vecpath.length - 1; j++){
			vec0 = wire.vecpath[j];
			vec1 = wire.vecpath[j + 1];
			x0 = vec0.x - junc.getX();
			z0 = vec0.z - junc.getZ();
			if(x0 < -16 || z0 < -16 || x0 > 16 || z0 > 16) continue;
			x1 = vec1.x - junc.getX();
			z1 = vec1.z - junc.getZ();
			if(x1 < -16 || z1 < -16 || x1 > 16 || z1 > 16) continue;
			bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos((x0 + 16) * 2 + guiLeft + 7, (z0 + 16) * 2 + guiTop + 21, zLevel + 1).color(color[0], color[1], color[2], 1F).endVertex();
			bufferbuilder.pos((x1 + 16) * 2 + guiLeft + 7, (z1 + 16) * 2 + guiTop + 21, zLevel + 1).color(color[0], color[1], color[2], 1F).endVertex();
			tessellator.draw();
		}
	}
	
	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
		tooltip.clear();
		for(int i = 0; i < 6; i++){
			if(buttons.get("edit" + i).hovered) tooltip.add(Formatter.format("&eEdit this wire's appearance and function."));
			if(buttons.get("del" + i).hovered) tooltip.add(Formatter.format("&eRemove wire from relay."));
		}
		if(tooltip.size() > 0) drawHoveringText(tooltip, mouseX, mouseY);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("copy")){
			texts.get("title").string = "Position Copied to clipboard!";
			StringSelection selection = new StringSelection(WireKey.str(container.relay.getHolder().pos) + ":" + container.relay.getKey());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
			return true;
		}
		else if(button.name.equals("help")){
			GuiScreen parent = this;
			this.mc.displayGuiScreen(new GuiConfirmOpenLink(this, "https://fexcraft.net/wiki/mod/fvtm/wire_relay", 31102009, true){
                @Override
                public void drawScreen(int mouseX, int mouseY, float partialTicks){
                    parent.drawScreen(-1, -1, partialTicks);
                    super.drawScreen(mouseX, mouseY, partialTicks);
                }
            });
			return true;
		}
		else if(button.name.equals("up")){
			scroll--;
			if(scroll < 0) scroll = 0;
			return true;
		}
		else if(button.name.equals("dw")){
			scroll++;
			return true;
		}
		int i = -1;
		try{
			i = Integer.parseInt(button.name.replace("del", "").replace("edit", ""));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(button.name.startsWith("edit")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "edit_wire");
			WireRelayContainer.WIRE = i + scroll;
			this.container.send(Side.SERVER, compound);
			return true;
		}
		else if(button.name.startsWith("del")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "del_wire");
			compound.setInteger("index", i + scroll);
			compound.setLong("holder", container.relay.getHolder().pos.toLong());
			compound.setString("relay", WireRelayContainer.SELRELAY);
			this.container.send(Side.SERVER, compound);
			return true;
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		scroll += am > 0 ? 1 : -1;
		if(scroll < 0) scroll = 0;
	}
	
}

