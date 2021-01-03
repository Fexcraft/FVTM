package net.fexcraft.mod.fvtm.gui.rail;

import static net.fexcraft.lib.mc.utils.Formatter.PARAGRAPH_SIGN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.block.RailBlock;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RailPlacer extends GenericGui<RailPlacerContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/rail_main.png");
	private static RGB[][] GRID;
	private static BlockPos[][] POSGRID;
	private static IBlockState[][] STATEGRID;
	private boolean centered = true;
	private RailSys system;
	private Zoom zoom;
	
	public RailPlacer(EntityPlayer player, int x, int y, int z){
		super(texture, new RailPlacerContainer(player, x, y, z), player);
		zoom = y < 0 || y >= Zoom.values().length ? Zoom.NONE :  Zoom.values()[y];
        int cx = (player.getPosition().getX() >> 4) - zoom.co;
        int cz = (player.getPosition().getZ() >> 4) - zoom.co;
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 256;
		this.ySize = 206;
		GRID = new RGB[zoom.gs][zoom.gs];
		POSGRID = new BlockPos[zoom.gs][zoom.gs];
		STATEGRID = new IBlockState[zoom.gs][zoom.gs];
		for(int i = 0; i < zoom.gs; i++){
			for(int j = 0; j < zoom.gs; j++){
				BlockPos pos = getPos(player.world, i + (cx * 16), j + (cz * 16));
				IBlockState state = player.world.getBlockState(pos);
				GRID[i][j] = new RGB(state.getMapColor(player.world, pos).colorValue);
				POSGRID[i][j] = pos;
				STATEGRID[i][j] = state;
			}
		}
		system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
	}

	private static final BlockPos getPos(World world, int x, int z){
		for(int i = 255; i > 0; i--){
			BlockPos pos = new BlockPos(x, i, z);
			if(world.getBlockState(pos).getBlock() != Blocks.AIR && world.getBlockState(pos).getBlock() instanceof RailBlock == false){
				return pos;
			}
		}
		return new BlockPos(x, 0, z);
	}

	@Override
	protected void init(){
		this.buttons.put("zoom-", new BasicButton("z-", guiLeft + 223, guiTop + 7, 223, 7, 12, 12, zoom.ordinal() > 0));
		this.buttons.put("zoom+", new BasicButton("z+", guiLeft + 237, guiTop + 7, 237, 7, 12, 12, zoom.ordinal() < 2));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < zoom.gs; i++){
			for(int j = 0; j < zoom.gs; j++){
				GRID[i][j].glColorApply();
				this.drawTexturedModalRect(guiLeft + zoom.bo + (i * zoom.cs), guiTop + zoom.bo + (j * zoom.cs), 7, 7, zoom.cs, zoom.cs);
			}
		}
		if(mouseX >= guiLeft + zoom.bo && mouseX < guiLeft + zoom.bo + zoom.ts && mouseY >= guiTop + zoom.bo && mouseY < guiTop + zoom.bo + zoom.ts){
			int x = (mouseX - guiLeft - zoom.bo) / zoom.cs, y = (mouseY - guiTop - zoom.bo) / zoom.cs;
			ArrayList<String> arr = new ArrayList<String>();
        	arr.add(PARAGRAPH_SIGN + "7Pos: " + POSGRID[x][y].getX() + "x, " + POSGRID[x][y].getY() + "y, " + POSGRID[x][y].getZ() + "Z, ");
        	arr.add(PARAGRAPH_SIGN + "7Block: " + STATEGRID[x][y].getBlock().getLocalizedName());
        	Junction junc = system.getJunction(new Vec316f(POSGRID[x][y].up(), centered, false));
        	if(junc != null){
            	arr.add(PARAGRAPH_SIGN + "9Junction: " + PARAGRAPH_SIGN + "b" + (junc.tracks.isEmpty() ? "empty" : junc.tracks.size() + " tracks"));
        	}
        	else{
        		arr.add(PARAGRAPH_SIGN + "9No Junction at this position.");
        	}
		    this.drawHoveringText(arr, mouseX, mouseY, mc.fontRenderer);
		}
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("z-")){
			openGui(GuiHandler.RAILPLACER, new int[]{ 0, zoom.ordinal() - 1, 0 }, LISTENERID);
			return true;
		}
		if(button.name.equals("z+")){
			openGui(GuiHandler.RAILPLACER, new int[]{ 0, zoom.ordinal() + 1, 0 }, LISTENERID);
			return true;
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
	public static enum Zoom {
		
		NONE(1, 172, 172, 15, 5),
		ONE(2, 80, 160, 23, 2),
		TWO(4, 48, 192, 7, 1);
		
		public int cs, gs, ts, bo, co;
		
		Zoom(int cz, int gz, int tz, int to, int cx){
			cs = cz; gs = gz; ts = tz; bo = to; co = cx;
		}
		
	}
	
}

