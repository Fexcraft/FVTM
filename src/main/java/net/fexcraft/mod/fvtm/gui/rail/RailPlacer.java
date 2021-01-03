package net.fexcraft.mod.fvtm.gui.rail;

import static net.fexcraft.lib.mc.utils.Formatter.PARAGRAPH_SIGN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.block.RailBlock;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
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
	private static ArrayList<Junction> junctions = new ArrayList<>();
	private static boolean noterrain = true;
	private static Orient orient;
	private static int cx, cz;
	private static Zoom zoom;
	private RailSys system;
	//
	private static int itemslot;
	private static Vec316f begin;
	private static ArrayList<Vec316f> points = new ArrayList<>();
	//
	private FieldButton fieldbutton;
	private OrientButton orientbutton;
	private ArrayList<String> ttip = new ArrayList<String>();
	
	public RailPlacer(EntityPlayer player, int x, int y, int z){
		super(texture, new RailPlacerContainer(player, x, y, z), player);
		zoom = y < 0 || y >= Zoom.values().length ? Zoom.NONE :  Zoom.values()[y];
		if(orient == null) orient = Orient.C;
		itemslot = x;
        cx = (player.getPosition().getX() >> 4) - zoom.co;
        cz = (player.getPosition().getZ() >> 4) - zoom.co;
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 256;
		this.ySize = 206;
		junctions.clear();
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
		int d = zoom.co * 2;
		for(int i = 0; i < d; i++){
			for(int j = 0; j < d; j++){
				junctions.addAll(system.getJunctionsInChunk(cx + i, cz + j));
			}
		}
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
		this.buttons.put("orient", orientbutton = new OrientButton(guiLeft, guiTop));
		this.buttons.put("field", fieldbutton = new FieldButton(guiLeft, guiTop));
		for(Junction junc : junctions){
			this.buttons.put("j" + junc.getVec316f().asIDString(), new JunctionButton(junc));
		}
		for(Vec316f point : points){
			this.buttons.put("p" + point.asIDString(), new PointButton(point));
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		if(!noterrain){
			for(int i = 0; i < zoom.gs; i++){
				for(int j = 0; j < zoom.gs; j++){
					GRID[i][j].glColorApply();
					this.drawTexturedModalRect(guiLeft + zoom.bo + (i * zoom.cs), guiTop + zoom.bo + (j * zoom.cs), 7, 7, zoom.cs, zoom.cs);
				}
			}
		}
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glLineWidth(4f);
		for(Junction junc : junctions){
			renderJunction(junc);
		}
		GL11.glLineWidth(1f);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	
	private void renderJunction(Junction junc){
		Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        Vec3f vec0, vec1; float flfl, glgl;
		for(int o = 0; o < junc.tracks.size(); o++){
			Track conn = junc.tracks.get(o);
			if(conn.isOppositeCopy()) continue;
	        flfl = conn.isOppositeCopy() ? 1 : 0;
	        glgl = conn.isOppositeCopy() ? 0 : 1;
			for(int j = 0; j < conn.vecpath.length - 1; j++){
				vec0 = conn.vecpath[j];
				vec1 = conn.vecpath[j + 1];
                bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
                bufferbuilder.pos((vec0.xCoord - (cx * 16)), (vec0.zCoord - (cz * 16)), zLevel).color(0f, glgl, flfl, 1F).endVertex();
                bufferbuilder.pos((vec1.xCoord - (cx * 16)), (vec1.zCoord - (cz * 16)), zLevel).color(0f, glgl, flfl, 1F).endVertex();
                tessellator.draw();
			}
		}
	}

	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
		ttip.clear();
		if(mouseX >= guiLeft + zoom.bo && mouseX < guiLeft + zoom.bo + zoom.ts && mouseY >= guiTop + zoom.bo && mouseY < guiTop + zoom.bo + zoom.ts){
			int x = (mouseX - guiLeft - zoom.bo) / zoom.cs, y = (mouseY - guiTop - zoom.bo) / zoom.cs;
			ttip.add(PARAGRAPH_SIGN + "7Pos: " + POSGRID[x][y].getX() + "x, " + POSGRID[x][y].getY() + "y, " + POSGRID[x][y].getZ() + "Z, ");
        	ttip.add(PARAGRAPH_SIGN + "7Block: " + STATEGRID[x][y].getBlock().getLocalizedName());
        	//Junction junc = system.getJunction(new Vec316f(POSGRID[x][y].up(), orient.x, 0, orient.z));
        	ArrayList<Junction> juncs = system.getJunctionsAt(POSGRID[x][y].up());
        	if(juncs.size() > 0){
        		if(juncs.size() == 1){
        			ttip.add(PARAGRAPH_SIGN + "9Junction: " + PARAGRAPH_SIGN + "b" + (juncs.get(0).tracks.isEmpty() ? "empty" : juncs.get(0).tracks.size() + " tracks"));
        		}
        		else{
        			ttip.add(PARAGRAPH_SIGN + "6Junctions " + juncs.size());
                	for(Junction junc : juncs){
                		ttip.add(PARAGRAPH_SIGN + "9J-" + Orient.get(junc.getVec316f()) +": " + PARAGRAPH_SIGN + "b" + (junc.tracks.isEmpty() ? "empty" : junc.tracks.size() + " tracks"));
                	}
        		}
        	}
        	else{
        		ttip.add(PARAGRAPH_SIGN + "9No Junction/s at this position.");
        	}
		}
		if(orientbutton.hovered){
			ttip.add(PARAGRAPH_SIGN + "6Selected J-orientation: " + orient.name());
		}
	    if(ttip.size() > 0) this.drawHoveringText(ttip, mouseX, mouseY, mc.fontRenderer);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("z-")){
			openGui(GuiHandler.RAILPLACER, new int[]{ 0, zoom.ordinal() - 1, 0 }, LISTENERID);
			return true;
		}
		else if(button.name.equals("z+")){
			openGui(GuiHandler.RAILPLACER, new int[]{ 0, zoom.ordinal() + 1, 0 }, LISTENERID);
			return true;
		}
		else if(button.name.equals("orient")){
			int i = orient.ordinal();
			if(i + 1 >= Orient.values().length - 1) orient = Orient.TL;
			else orient = Orient.values()[i + 1];
			return true;
		}
		else if(button.name.equals("field")){
			int x = (mouseX - guiLeft - zoom.bo) / zoom.cs, y = (mouseY - guiTop - zoom.bo) / zoom.cs;
			ttip.add(PARAGRAPH_SIGN + "7Pos: " + POSGRID[x][y].getX() + "x, " + POSGRID[x][y].getY() + "y, " + POSGRID[x][y].getZ() + "Z, ");
        	ttip.add(PARAGRAPH_SIGN + "7Block: " + STATEGRID[x][y].getBlock().getLocalizedName());
        	Vec316f pos = new Vec316f(POSGRID[x][y].up(), (byte)orient.x, (byte)0, (byte)orient.z);
        	Junction junc = system.getJunction(pos);
        	if(begin == null){
        		if(junc != null) begin = pos;
        	}
        	else if(junc != null){
        		//try placing track
        		buttons.entrySet().removeIf(entry -> entry.getKey().startsWith("p"));
        		points.clear();
        		begin = null;
        	}
        	else if(begin != null){
        		points.add(pos);
        		buttons.put("p" + pos.asIDString(), new PointButton(pos));
        	}
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
	
	public static enum Orient {
		
		TL( 0,  0),
		T ( 8,  0),
		TR(16,  0),
		L (16,  8),
		BL(16, 16),
		B ( 8, 16),
		BR( 0, 16),
		R ( 0,  8),
		C ( 8,  8),
		IR(-1, -1);//"irregular"
		
		int x, z;

		Orient(int x, int z){
			this.x = x;
			this.z = z;
		}

		public static String get(Vec316f vec){
			Orient o = null;
			if(vec.y == 0){
				for(Orient or : values()){
					if(or.x == vec.x && or.z == vec.z){
						o = or;
						break;
					}
				}
			}
			if(o == null || o == IR){
				return "IR|" + vec.x + "|" + vec.y + "|" + vec.z;
			}
			else return o.name();
		}
		
		
	}
	
	public static class JunctionButton extends BasicButton {
		
		public Junction junction;
		private boolean centered;

		public JunctionButton(Junction junc){
			super("j" + junc.getVec316f().asIDString(), 0, 0, 0, 0, zoom.cs, zoom.cs, true);
			junction = junc;
			x = junc.getVec316f().pos.getX() - (cx * 16);
			y = junc.getVec316f().pos.getZ() - (cz * 16);
			centered = junc.getVec316f().x == 8 && junc.getVec316f().z == 8;
			if(zoom.ordinal() == 1){
				x *= zoom.cs;
				y *= zoom.cs;
			}
			else if(zoom.ordinal() == 2){
				x *= zoom.cs;
				y *= zoom.cs;
			}
		}
		
		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			drawScaledCustomSizeModalRect(gui.getGuiLeft() + x + zoom.bo, gui.getGuiTop() + y + zoom.bo,
				begin != null && begin.equals(junction.getVec316f()) ? 0 : centered ? 36 : 12, 244, 12, 12, zoom.cs, zoom.cs, 256, 256);
		}
		
	}
	
	public static class PointButton extends BasicButton {
		
		public PointButton(Vec316f vec){
			super("p" + vec, 0, 0, 0, 0, zoom.cs, zoom.cs, true);
			x = vec.pos.getX() - (cx * 16);
			y = vec.pos.getZ() - (cz * 16);
			if(zoom.ordinal() == 1){
				x *= zoom.cs;
				y *= zoom.cs;
			}
			else if(zoom.ordinal() == 2){
				x *= zoom.cs;
				y *= zoom.cs;
			}
		}
		
		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			drawScaledCustomSizeModalRect(gui.getGuiLeft() + x + zoom.bo, gui.getGuiTop() + y + zoom.bo, 24, 244, 12, 12, zoom.cs, zoom.cs, 256, 256);
		}
		
	}
	
	public static class OrientButton extends BasicButton {

		public OrientButton(int l, int t){
			super("orient", 213 + l, 189 + t, 112, 248, 8, 8, true);
		}
		
		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			tx = 48 + (orient.ordinal() * 8);
			super.draw(gui, pticks, mouseX, mouseY);
		}
		
	}
	
	public static class FieldButton extends BasicButton {

		public FieldButton(int l, int t){
			super("field", 7 + l, 7 + t, 7, 7, 192, 192, true);
		}
		
		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			return;
		}
		
	}
	
}

