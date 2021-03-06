package net.fexcraft.mod.fvtm.gui.road;

import static net.fexcraft.lib.mc.utils.Formatter.PARAGRAPH_SIGN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.ROADTOOLFILL;
import static net.fexcraft.mod.fvtm.util.Compat.isValidFlenix;

import java.util.ArrayList;
import java.util.Collections;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.RailBlock;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD;
import net.fexcraft.mod.fvtm.gui.ClientReceiver;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.sys.road.Road;
import net.fexcraft.mod.fvtm.util.Compat;
import net.fexcraft.mod.fvtm.util.Vec316f;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;

public class RoadPlacer extends GenericGui<RoadPlacerContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/road_gen.png");
	private static final RGB GRAY = new RGB(31, 31, 31), YELLOW = new RGB(255, 255, 0);
	private static RGB[][] GRID;
	private static byte[][] HEIGHTGRID;
	private static BlockPos[][] POSGRID;
	private static IBlockState[][] STATEGRID;
	private static boolean noterrain, noblocks;
	private static Orient orient;
	private static int cx, cz, mx, mz;
	private static Zoom zoom;
	//
	private static Road demoroad;
	private static Vec316f begin;
	private static Vec316f[][] preview;
	private static ArrayList<Vec316f> points = new ArrayList<>();
	//
	private OrientButton orientbutton;
	private ArrayList<String> ttip = new ArrayList<String>();
	private int[] size = new int[]{ 1, 0, 0, 0, 0};
	
	public RoadPlacer(EntityPlayer player, int x, int y, int z){
		super(texture, new RoadPlacerContainer(player, x, y, z), player);
		//if(!Perms.ROAD_PLACER_GUI.has(player)) player.closeScreen();
		zoom = y < 0 || y >= Zoom.values().length ? Zoom.NONE :  Zoom.values()[y];
		if(orient == null) orient = Orient.C;
		ItemStack stack = player.getHeldItemMainhand();
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		if(!stack.getTagCompound().hasKey("RoadLayers")){
			stack.getTagCompound().setIntArray("RoadLayers", size);
		}
		else size = stack.getTagCompound().getIntArray("RoadLayers");
		//
        cx = (player.getPosition().getX() >> 4) - zoom.co;
        cz = (player.getPosition().getZ() >> 4) - zoom.co;
        mx = cx * 16;
        mz = cz * 16;
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 256;
		this.ySize = 206;
		GRID = new RGB[zoom.gs][zoom.gs];
		POSGRID = new BlockPos[zoom.gs][zoom.gs];
		STATEGRID = new IBlockState[zoom.gs][zoom.gs];
		HEIGHTGRID = new byte[zoom.gs][zoom.gs];
		boolean flnx = Loader.isModLoaded("furenikusroads");
		for(int i = 0; i < zoom.gs; i++){
			for(int j = 0; j < zoom.gs; j++){
				BlockPos pos = getPos(player.world, i + (cx * 16), j + (cz * 16));
				IBlockState state = player.world.getBlockState(pos);
				POSGRID[i][j] = pos;
				STATEGRID[i][j] = state;
				HEIGHTGRID[i][j] = getHeight(state.getBoundingBox(player.world, pos));
			}
		}
		int d = zoom.co * 2 + 1;
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
				if(flnx && Compat.isValidFlenix(STATEGRID[i][j].getBlock())){
					GRID[i][j] = new RGB(MapColor.BLACK_STAINED_HARDENED_CLAY.colorValue);
				}
			}
		}
		preview = new Vec316f[zoom.gs][zoom.gs];
	}

	private byte getHeight(AxisAlignedBB box){
		if(box == null) return 0;
		return (byte)(box.maxY * 16);
	}

	private static final BlockPos getPos(World world, int x, int z){
		for(int i = 255; i > 0; i--){
			BlockPos pos = new BlockPos(x, i, z);
			IBlockState state = world.getBlockState(pos);
			if(state.getBlock() instanceof RailBlock) continue;
			if(isSolid(state, world, pos) || isWater(state.getBlock())){
				return pos;
			}
		}
		return new BlockPos(x, 0, z);
	}
	
	private static boolean isSolid(IBlockState state, World world, BlockPos pos){
		return isRoadBlock(state) || (state.isSideSolid(world, pos, EnumFacing.UP) && !state.getBlock().isReplaceable(world, pos));
	}

	private static boolean isRoadBlock(IBlockState state){
		if(state.getBlock() instanceof Asphalt || state.getBlock() instanceof G_ROAD) return true;
		if(isValidFlenix(state.getBlock().getRegistryName().getNamespace(), state.getBlock().getRegistryName().getPath())) return true;
		return false;
	}

	private static boolean isWater(Block block){
		return block instanceof BlockLiquid || block instanceof BlockFluidBase;
	}

	@Override
	protected void init(){
		this.buttons.put("zoom-", new BasicButton("z-", guiLeft + 223, guiTop + 7, 223, 7, 12, 12, zoom.ordinal() > 0));
		this.buttons.put("zoom+", new BasicButton("z+", guiLeft + 237, guiTop + 7, 237, 7, 12, 12, zoom.ordinal() < 2));
		this.buttons.put("orient", orientbutton = new OrientButton(guiLeft, guiTop));
		this.buttons.put("field", new FieldButton(guiLeft, guiTop));
		for(Vec316f point : points){
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
			if(i != 11) this.buttons.put("ad" + i, new B88("d" + i, guiLeft + 221, guiTop + 23 + (i * 12), 56, 240, 8, 8));
			if(i != 0) this.buttons.put("au" + i, new B88("u" + i, guiLeft + 230, guiTop + 23 + (i * 12), 64, 240, 8, 8));
			this.buttons.put("ar" + i, new B88("r" + i, guiLeft + 239, guiTop + 23 + (i * 12), 72, 240, 8, 8));
		}
		this.buttons.put("layers", new BasicButton("layers", guiLeft + 201, guiTop + 173, 201, 173, 48, 12, true));
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
					(preview[i][j] != null ? YELLOW : GRID[i][j]).glColorApply();
					this.drawTexturedModalRect(guiLeft + zoom.bo + (i * zoom.cs), guiTop + zoom.bo + (j * zoom.cs), 7, 7, zoom.cs, zoom.cs);
				}
			}
		}
		else if(demoroad != null){
			for(int i = 0; i < zoom.gs; i++){
				for(int j = 0; j < zoom.gs; j++){
					if(preview[i][j] == null) continue;
					GRAY.glColorApply();
					this.drawTexturedModalRect(guiLeft + zoom.bo + (i * zoom.cs), guiTop + zoom.bo + (j * zoom.cs), 7, 7, zoom.cs, zoom.cs);
				}
			}
		}
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glLineWidth(4f);
		if(demoroad != null) renderRoad(demoroad, false);
		GL11.glLineWidth(1f);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	
	private void renderRoad(Road conn, boolean junc){
		if(conn.isOppositeCopy()) return;
		Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        Vec3f vec0, vec1;
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
			Vec316f vec = points.get(i + 1);
			fontRenderer.drawString(vec.x + "-" + vec.y + "-" + vec.z, guiLeft + 201, guiTop + 24 + (i * 12), MapColor.BLACK.colorValue);
		}
		ttip.clear();
		if(mouseX >= guiLeft + zoom.bo && mouseX < guiLeft + zoom.bo + zoom.ts && mouseY >= guiTop + zoom.bo && mouseY < guiTop + zoom.bo + zoom.ts){
			int x = (mouseX - guiLeft - zoom.bo) / zoom.cs, y = (mouseY - guiTop - zoom.bo) / zoom.cs;
			ttip.add(PARAGRAPH_SIGN + "7Pos: " + POSGRID[x][y].getX() + "x, " + POSGRID[x][y].getY() + "y, " + POSGRID[x][y].getZ() + "z, ");
        	ttip.add(PARAGRAPH_SIGN + "7Block: " + STATEGRID[x][y].getBlock().getLocalizedName());
        	ttip.add(PARAGRAPH_SIGN + "7Height: " + HEIGHTGRID[x][y] + "mb");
        	if(preview[x][y] != null){
    			ttip.add(PARAGRAPH_SIGN + "6Approximate road block preview.");
            	ttip.add(PARAGRAPH_SIGN + "9Road Pos: " + preview[x][y].pos.getX() + "x, " + preview[x][y].pos.getY() + "y, " + preview[x][y].pos.getZ() + "z, ");
            	ttip.add(PARAGRAPH_SIGN + "9Steps: " + (preview[x][y].y == 0 ? "none / full height" : preview[x][y].y + "mb"));
    			ttip.add(PARAGRAPH_SIGN + "8Remember that roads do stack if a higher one is at that position!");
        	}
		}
		if(orientbutton.hovered){
			ttip.add(PARAGRAPH_SIGN + "6Selected orientation: " + orient.name());
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
			openGui(GuiHandler.ROADTOOL, new int[]{ 0, zoom.ordinal() - 1, 0 }, LISTENERID);
			return true;
		}
		else if(button.name.equals("z+")){
			openGui(GuiHandler.ROADTOOL, new int[]{ 0, zoom.ordinal() + 1, 0 }, LISTENERID);
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
        	Vec316f pos = new Vec316f(POSGRID[x][y], (byte)orient.x, (byte)(16 - HEIGHTGRID[x][y]), (byte)orient.z);
        	if(pos.y != 0) pos = new Vec316f(pos.pos.down(), pos.x, pos.y, pos.z);
        	if(mouseButton > 0){
        		//
        		return true;
        	}
        	if(begin == null){
    			begin = pos;
        		buttons.put("p" + pos.asIDString(), new PointButton(pos));
    			points.add(pos);
        	}
        	else if(begin != null){
        		if(points.size() < 12){
                	reroad(pos);
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
			if(begin == null || points.size() < 2) return true;
			ItemStack stack = player.getHeldItemMainhand();
			if(stack.getItem() instanceof RoadToolItem){
				NBTTagList list = new NBTTagList();
				for(Vec316f vec : points) list.appendTag(vec.write());
				NBTTagCompound compound = new NBTTagCompound();
				compound.setTag("points", list);
				compound.setBoolean("noblocks", noblocks);
				compound.setString("cargo", "place");
				container.send(Side.SERVER, compound);
				resetPoints();
			}
			else Print.chat(container.sender, "&cNo valid item in hand.");
    		return true;
		}
		else if(button.name.equals("reset")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "reset");
			container.send(Side.SERVER, compound);
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
			reroad(null);
		}
		else if(button.name.startsWith("u")){
			int i = Integer.parseInt(button.name.replace("u", "")) + 1;
			if(i - 1 < 0 || i >= points.size()) return true;
			Collections.swap(points, i, i - 1);
			reroad(null);
		}
		else if(button.name.startsWith("r")){
			int i = Integer.parseInt(button.name.replace("r", "")) + 1;
			if(i < 0 || i >= points.size()) return true;
			Vec316f vec = points.remove(i);
			buttons.remove("p" + vec.asIDString());
			reroad(null);
		}
		else if(button.name.equals("layers")){
			openGui(ROADTOOLFILL, null, LISTENERID);
			return true;
		}
		return false;
	}

	private void reroad(Vec316f pos){
		if(points.size() < 2 && pos == null){
			demoroad = null;
			clearPreview();
		}
		else if(pos == null){
			demoroad = new Road(null, points.toArray(new Vec316f[0]));
		}
		else{
			demoroad = new Road(null, points.toArray(new Vec316f[0]), pos);
		}
		if(demoroad != null){
			clearPreview();
			ArrayList<Vec316f> path = new ArrayList<>();
			int width = size[0];
			float angle, passed = 0, half = (width * 0.5f) - (width % 2 == 0 ? 0.5f : 0); Vec3f last, vec;
			vec = demoroad.getVectorPosition0(0.001f, false); passed = 0;
			angle = (float)Math.atan2(demoroad.vecpath[0].z - vec.z, demoroad.vecpath[0].x - vec.x);
			angle += Static.rad90;
			for(float fl = -half; fl <= half; fl += 0.25f){
				path.add(new Vec316f(demoroad.vecpath[0].add(RoadToolItem.grv(angle, new Vec3f(fl, 0, 0)))));
			}
			while(passed < demoroad.length){
				passed += 0.125f; last = vec;
				vec = demoroad.getVectorPosition0(passed, false);
				angle = (float)Math.atan2(last.z - vec.z, last.x - vec.x);
				angle += Static.rad90;
				for(float fl = -half; fl <= half; fl += 0.25f){
					path.add(new Vec316f(vec.add(RoadToolItem.grv(angle, new Vec3f(fl, 0, 0)))));
				}
			}
			for(Vec316f v : path){
				int x = v.pos.getX() - mx, y = v.pos.getZ() - mz;
				if(x < 0 || y < 0 || x >= zoom.gs || y >= zoom.gs) continue;
				preview[x][y] = v;
			}
		}
	}

	private void clearPreview(){
		for(int i = 0; i < preview.length; i++){
			for(int j = 0; j < preview.length; j++){
				preview[i][j] = null;
			}
		}
	}

	private void resetPoints(){
		buttons.entrySet().removeIf(entry -> entry.getKey().startsWith("p"));
		demoroad = null;
		clearPreview();
		points.clear();
		begin = null;
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
	
	public static class PointButton extends BasicButton {
		
		private Vec316f vec;
		
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
			this.vec = vec;
		}
		
		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			drawScaledCustomSizeModalRect(gui.getGuiLeft() + x + zoom.bo, gui.getGuiTop() + y + zoom.bo, isRed() ? 0 : 24, 244, 12, 12, zoom.cs, zoom.cs, 256, 256);
		}

		private boolean isRed(){
			if(begin != null && begin.equals(vec)) return true;
			if(points.size() > 1 && points.get(points.size() - 1).equals(vec)) return true;
			return false;
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

