package net.fexcraft.mod.fvtm.gui.rail;

import static net.fexcraft.lib.common.utils.Formatter.PARAGRAPH_SIGN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import java.util.ArrayList;
import java.util.Collections;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.gui.ClientReceiver;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

public class RailPlacer extends GenericGui<RailPlacerContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/rail_main.png");
	private static RGB[][] GRID;
	private static BlockPos[][] POSGRID;
	private static IBlockState[][] STATEGRID;
	private static ArrayList<Junction> junctions = new ArrayList<>();
	private static boolean noterrain, noblocks;
	private static Orient orient;
	private static int cx, cz;
	private static Zoom zoom;
	private RailSystem system;
	//
	private static int itemslot;
	private static Track demotrack;
	private static QV3D begin, end;
	private static ArrayList<QV3D> points = new ArrayList<>();
	//
	//private FieldButton fieldbutton;
	private OrientButton orientbutton;
	private ArrayList<String> ttip = new ArrayList<String>();
	
	public RailPlacer(EntityPlayer player, int x, int y, int z){
		super(texture, new RailPlacerContainer(player, x, y, z), player);
		//if(!Perms.RAIL_PLACER_GUI.has(player)) player.closeScreen();
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
				//GRID[i][j] = new Color(state.getMapColor(player.world, pos).colorValue);
				POSGRID[i][j] = pos;
				STATEGRID[i][j] = state;
			}
		}
		system = SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(player.world), RailSystem.class);
		int d = zoom.co * 2 + 1;
		for(int i = 0; i < d; i++){
			for(int j = 0; j < d; j++){
				junctions.addAll(system.getJunctionsInChunk(cx + i, cz + j));
			}
		}
		for(int i = 0; i < zoom.gs; i++){
			for(int j = 0; j < zoom.gs; j++){
				int m = 0;
				if(isWater(STATEGRID[i][j].getBlock())){
					d = 0;
					for(int k = 0; k < 256; k++){
						if(isWater(player.world.getBlockState(POSGRID[i][j].down(k)).getBlock())) d++;
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

	public static final BlockPos getPos(World world, int x, int z){
		for(int i = 255; i > 0; i--){
			BlockPos pos = new BlockPos(x, i, z);
			IBlockState state = world.getBlockState(pos);
			//if(state.getBlock() instanceof RailBlock) continue;
			if(isSolid(state, world, pos) || isWater(state.getBlock())){
				return pos;
			}
		}
		return new BlockPos(x, 0, z);
	}
	
	private static boolean isSolid(IBlockState state, World world, BlockPos pos){
		return state.isSideSolid(world, pos, EnumFacing.UP) && !state.getBlock().isReplaceable(world, pos);
	}

	public static boolean isWater(Block block){
		return block instanceof BlockLiquid || block instanceof BlockFluidBase;
	}

	@Override
	protected void init(){
		this.buttons.put("zoom-", new BasicButton("z-", guiLeft + 223, guiTop + 7, 223, 7, 12, 12, zoom.ordinal() > 0));
		this.buttons.put("zoom+", new BasicButton("z+", guiLeft + 237, guiTop + 7, 237, 7, 12, 12, zoom.ordinal() < 2));
		this.buttons.put("orient", orientbutton = new OrientButton(guiLeft, guiTop));
		this.buttons.put("field", /*fieldbutton =*/ new FieldButton(guiLeft, guiTop));
		for(Junction junc : junctions){
			this.buttons.put("j" + junc.getPos().asIDString(), new JunctionButton(junc));
		}
		for(QV3D point : points){
			this.buttons.put("p" + point.asIDString(), new PointButton(point));
		}
		this.buttons.put("terrain", new BasicButton("terrain", guiLeft + 202, guiTop + 188, 202, 188, 10, 10, true));
		this.buttons.put("confirm", new BasicButton("confirm", guiLeft + 237, guiTop + 187, 237, 187, 12, 12, true));
		this.buttons.put("reset", new BasicButton("reset", guiLeft + 224, guiTop + 187, 224, 187, 12, 12, true));
		this.buttons.put("noblock", new BasicButton("noblock", guiLeft + 201, guiTop + 7, 120, 244, 20, 12, true){
			@Override
			public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
				ty = noblocks ? 232 : 244;
				super.draw(gui, pticks, mouseX, mouseY);
			}
		});
		for(int i = 0; i < 12; i++){
			/*this.buttons.put("field" + i, new BasicButton("field" + i, guiLeft + 201, guiTop + 21 + (i * 12), 201, 21, 47, 12, true){
				@Override
				public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
					return;
				}
			});*/
			if(i != 11) this.buttons.put("ad" + i, new B88("d" + i, guiLeft + 221, guiTop + 23 + (i * 12), 56, 240, 8, 8));
			if(i != 0) this.buttons.put("au" + i, new B88("u" + i, guiLeft + 230, guiTop + 23 + (i * 12), 64, 240, 8, 8));
			this.buttons.put("ar" + i, new B88("r" + i, guiLeft + 239, guiTop + 23 + (i * 12), 72, 240, 8, 8));
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < 12; i++){
			//buttons.get("field" + i).visible = i < points.size();
			if(i != 11) buttons.get("ad" + i).visible = buttons.get("ad" + i).hovered(mouseX, mouseY);
			if(i != 0) buttons.get("au" + i).visible = buttons.get("au" + i).hovered(mouseX, mouseY);
			buttons.get("ar" + i).visible = buttons.get("ar" + i).hovered;
		}
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
		if(demotrack != null) renderTrack(demotrack, false);
		GL11.glLineWidth(1f);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	
	private void renderJunction(Junction junc){
		for(Track track : junc.tracks){
			renderTrack(track, true);
		}
	}
	
	private void renderTrack(Track conn, boolean junc){
		if(conn.isOppositeCopy()) return;
		Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
		V3D vec0, vec1;
        float flfl = junc ? 0 : 1, glgl = junc ? 1 : 0;
		for(int j = 0; j < conn.vecpath.length - 1; j++){
			vec0 = conn.vecpath[j];
			vec1 = conn.vecpath[j + 1];
			bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos((vec0.x - (cx * 16)) * zoom.cs + guiLeft + zoom.bo, (vec0.z - (cz * 16)) * zoom.cs + guiTop + zoom.bo, zLevel + 1).color(0f, glgl, flfl, 1F).endVertex();
			bufferbuilder.pos((vec1.x - (cx * 16)) * zoom.cs + guiLeft + zoom.bo, (vec1.z - (cz * 16)) * zoom.cs + guiTop + zoom.bo, zLevel + 1).color(0f, glgl, flfl, 1F).endVertex();
			tessellator.draw();
		}
	}

	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < 12; i++){
			if(i + 1 >= points.size()) break;
			QV3D vec = points.get(i + 1);
			fontRenderer.drawString(vec.x + "-" + vec.y + "-" + vec.z, guiLeft + 201, guiTop + 24 + (i * 12), MapColor.BLACK.colorValue);
		}
		ttip.clear();
		if(mouseX >= guiLeft + zoom.bo && mouseX < guiLeft + zoom.bo + zoom.ts && mouseY >= guiTop + zoom.bo && mouseY < guiTop + zoom.bo + zoom.ts){
			int x = (mouseX - guiLeft - zoom.bo) / zoom.cs, y = (mouseY - guiTop - zoom.bo) / zoom.cs;
			ttip.add(PARAGRAPH_SIGN + "7Pos: " + POSGRID[x][y].getX() + "x, " + POSGRID[x][y].getY() + "y, " + POSGRID[x][y].getZ() + "z, ");
        	ttip.add(PARAGRAPH_SIGN + "7Block: " + STATEGRID[x][y].getBlock().getLocalizedName());
        	//Junction junc = system.getJunction(new Vec316f(POSGRID[x][y].up(), orient.x, 0, orient.z));
			BlockPos pos = POSGRID[x][y].up();
        	ArrayList<Junction> juncs = system.getJunctionsAt(pos.getX(), pos.getY(), pos.getZ());
        	if(juncs.size() > 0){
        		if(juncs.size() == 1){
        			ttip.add(PARAGRAPH_SIGN + "9Junction: " + PARAGRAPH_SIGN + "b" + (juncs.get(0).tracks.isEmpty() ? "empty" : juncs.get(0).tracks.size() + " tracks"));
        		}
        		else{
        			ttip.add(PARAGRAPH_SIGN + "6Junctions " + juncs.size());
                	for(Junction junc : juncs){
                		ttip.add(PARAGRAPH_SIGN + "9J-" + Orient.get(junc.getPos()) +": " + PARAGRAPH_SIGN + "b" + (junc.tracks.isEmpty() ? "empty" : junc.tracks.size() + " tracks"));
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
	    //
	    if(ClientReceiver.LAST_MSG != null){
		    fontRenderer.drawStringWithShadow(ClientReceiver.LAST_MSG, guiLeft, guiTop - 10, MapColor.SNOW.colorValue);
	    }
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
			if(x < 0 || y < 0 || x >= zoom.gs || y >= zoom.gs) return true;
			BlockPos blp = POSGRID[x][y].up();
        	QV3D pos = QV3D.exact(blp.getX(), blp.getY(), blp.getZ(), (byte)orient.x, (byte)0, (byte)orient.z);
        	Junction junc = system.getJunction(pos.pos);
        	if(mouseButton > 0){
        		if(junc == null){
    				NBTTagCompound compound = new NBTTagCompound();
    				pos.write(TagCW.wrap(compound), "pos");
    				compound.setString("cargo", "set_junc");
    				container.send(Side.SERVER, compound);
        		}
        		else{
        			if(junc.tracks.size() > 0){
        				Print.chat(container.sender, "&bPlease remove all connected tracks first!");
        			}
        			else{
        				NBTTagCompound compound = new NBTTagCompound();
        				pos.write(TagCW.wrap(compound), "pos");
        				compound.setString("cargo", "del_junc");
        				container.send(Side.SERVER, compound);
        			}
        		}
        		return true;
        	}
        	if(end != null) return true;
        	if(begin == null){
        		if(junc != null){
        			begin = pos;
        			points.add(pos);
        		}
        	}
        	else if(junc != null){
            	retrack(end = pos);
            	points.add(pos);
        	}
        	else if(begin != null){
        		if(points.size() < 13){
                	retrack(pos);
	        		buttons.put("p" + pos.asIDString(), new PointButton(pos));
	        		points.add(pos);
        		}
        		else{
    				Print.chat(container.sender, "&eGUI track point limit reached.");
        		}
        	}
        	return true;
		}
		else if(button.name.equals("confirm")){
			if(begin == null || end == null || points.isEmpty()) return true;
			ItemStack stack = player.inventory.getStackInSlot(itemslot);
			if(stack.getItem() instanceof RailGaugeItem){
				NBTTagList list = new NBTTagList();
				for(int i = 0; i < points.size() - 1; i++){
					list.appendTag(points.get(i).write(null, null).local());
				}
				NBTTagCompound compound = new NBTTagCompound();
				compound.setTag("points", list);
				end.write(TagCW.wrap(compound), "pos");
				compound.setBoolean("noblocks", noblocks);
				compound.setString("cargo", "place");
				container.send(Side.SERVER, compound);
				resetPoints();
			}
			else Print.chat(container.sender, "&cNo valid item in hand.");
    		return true;
		}
		else if(button.name.equals("reset")){
			resetPoints();
    		return true;
		}
		else if(button.name.equals("terrain")){
			noterrain = !noterrain;
    		return true;
		}
		else if(button.name.equals("noblock")){
			noblocks = !noblocks;
    		return true;
		}
		else if(button.name.startsWith("d")){
			int i = Integer.parseInt(button.name.replace("d", "")) + 1;
			if(i < 0 || i + 1 >= points.size()) return true;
			Collections.swap(points, i, i + 1);
			retrack(null);
		}
		else if(button.name.startsWith("u")){
			int i = Integer.parseInt(button.name.replace("u", "")) + 1;
			if(i - 1 < 0 || i >= points.size()) return true;
			Collections.swap(points, i, i - 1);
			retrack(null);
		}
		else if(button.name.startsWith("r")){
			int i = Integer.parseInt(button.name.replace("r", "")) + 1;
			if(i < 0 || i >= points.size()) return true;
			QV3D vec = points.remove(i);
			buttons.remove("p" + vec.asIDString());
			retrack(null);
		}
		return false;
	}

	private void retrack(QV3D pos){
		if(points.size() < 2 && pos == null) demotrack = null;
		else if(pos != null) demotrack = new Track(null, points.toArray(new QV3D[0]), pos, null);
		else demotrack = new Track(null, points.toArray(new QV3D[0]), null);
	}

	private void resetPoints(){
		buttons.entrySet().removeIf(entry -> entry.getKey().startsWith("p"));
		begin = end = null;
		demotrack = null;
		points.clear();
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

		public static String get(QV3D vec){
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
			super("j" + junc.getPos().asIDString(), 0, 0, 0, 0, zoom.cs, zoom.cs, true);
			junction = junc;
			x = junc.getPos().pos.x - (cx * 16);
			y = junc.getPos().pos.z - (cz * 16);
			centered = junc.getPos().x == 8 && junc.getPos().z == 8;
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
			drawScaledCustomSizeModalRect(gui.getGuiLeft() + x + zoom.bo, gui.getGuiTop() + y + zoom.bo, isRed() ? 0 : centered ? 36 : 12, 244, 12, 12, zoom.cs, zoom.cs, 256, 256);
		}

		private boolean isRed(){
			if(begin != null && begin.equals(junction.getPos())) return true;
			if(end != null && end.equals(junction.getPos())) return true;
			return false;
		}
		
	}
	
	public static class PointButton extends BasicButton {
		
		public PointButton(QV3D vec){
			super("p" + vec, 0, 0, 0, 0, zoom.cs, zoom.cs, true);
			x = vec.pos.x - (cx * 16);
			y = vec.pos.z - (cz * 16);
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
	
	public static class B88 extends BasicButton {

		public B88(String string, int x, int y, int u, int v, int w, int h){
			super(string, x, y, u, v, w, h, true);
		}
		
		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
            gui.drawTexturedModalRect(x, y, tx, ty - (hovered ? 8 : 0), sizex, sizey);
		}
		
	}
	
}

