package net.fexcraft.mod.fvtm.sys.tsign;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.model.TrafficSignModel;
import net.fexcraft.mod.fvtm.model.TrafficSignModel.CharModelData;
import net.fexcraft.mod.fvtm.model.TrafficSignModel.FontModelData;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TrafficSignData {
	
	public ArrayList<BaseData> backgrounds = new ArrayList<>();
	public ArrayList<ComponentData> components = new ArrayList<>();
	public ArrayList<FontData> fonts = new ArrayList<>();
	protected AxisAlignedBB boundingbox = Block.FULL_BLOCK_AABB;
    public float rotation, offset;
	private boolean linked;
	private BlockPos pos;

	public TrafficSignData(BlockPos pos){
		this.pos = pos;
	}

	public TrafficSignData(BlockPos pos, float rot, float off){
		this.pos = pos;
		rotation = rot;
		offset = off;
	}
	
	public TrafficSignData read(NBTTagCompound com){
		backgrounds.clear();
		components.clear();
		fonts.clear();
		if(com.hasKey("backgrounds")){
			NBTTagList list = (NBTTagList)com.getTag("backgrounds");
			for(NBTBase base : list){
				backgrounds.add(new BaseData((NBTTagCompound)base));
			}
		}
		if(com.hasKey("components")){
			NBTTagList list = (NBTTagList)com.getTag("components");
			for(NBTBase base : list){
				components.add(new ComponentData((NBTTagCompound)base));
			}
		}
		if(com.hasKey("fonts")){
			NBTTagList list = (NBTTagList)com.getTag("fonts");
			for(NBTBase base : list){
				fonts.add(new FontData((NBTTagCompound)base));
			}
		}
		rotation = com.getFloat("rotation");
		offset = com.getFloat("offset");
		linked = false;
		float largest = 0.5f;
		for(BaseData data : backgrounds){
			float abs = Math.abs(data.scale0);
			if(abs > largest) largest = data.scale0;
			abs = Math.abs(data.scale1);
			if(abs > largest) largest = data.scale1;
		}
		boundingbox = new AxisAlignedBB(-largest, -largest, -largest, largest, largest, largest).offset(pos);
		return this;
	}

	public NBTTagCompound write(){
		NBTTagCompound compound = new NBTTagCompound();
		NBTTagList list = new NBTTagList();
		for(BaseData data : backgrounds) list.appendTag(data.write());
		compound.setTag("backgrounds", list);
		list = new NBTTagList();
		for(ComponentData data : components) list.appendTag(data.write());
		compound.setTag("components", list);
		list = new NBTTagList();
		for(FontData data : fonts) list.appendTag(data.write());
		compound.setTag("fonts", list);
		compound.setFloat("rotation", rotation);
		compound.setFloat("offset", offset);
		return compound;
	}

	@SideOnly(Side.CLIENT)
	public void render(World world, boolean asent, float partialticks){
		if(!linked) linkModels();
		if(asent){
			GL11.glPushMatrix();
			GL11.glRotatef(rotation, 0, 1, 0);
			GL11.glTranslatef(0, 0, -offset - 0.00625f);
		}
        for(BaseData comp : backgrounds){
        	if(comp.model == null) continue;
    		GL11.glPushMatrix();
        	GL11.glTranslatef(comp.xoff * sixteenth, comp.yoff * sixteenth, comp.zoff * -0.00625f);
        	if(comp.rotation != 0) GL11.glRotatef(comp.rotation, 0, 0, 1);
        	//GL11.glScalef(comp.scale0, comp.scale1, 1);
        	comp.model.render(RENDERDATA.set(comp));
        	GL11.glPopMatrix();
        }
        for(ComponentData comp : components){
        	if(comp.model == null) continue;
    		GL11.glPushMatrix();
        	GL11.glTranslatef(comp.xoff * sixteenth, comp.yoff * sixteenth, comp.zoff * -0.00625f);
        	if(comp.rotation != 0) GL11.glRotatef(comp.rotation, 0, 0, 1);
        	GL11.glScalef(comp.scale0, comp.scale1, 1);
        	comp.model.render(RENDERDATA.set(comp));
        	GL11.glPopMatrix();
        }
        for(FontData comp : fonts){
        	if(comp.model == null) continue;
    		GL11.glPushMatrix();
        	GL11.glTranslatef(comp.xoff * sixteenth, comp.yoff * sixteenth, comp.zoff * -0.00625f);
        	if(comp.rotation != 0) GL11.glRotatef(comp.rotation, 0, 0, 1);
        	GL11.glScalef(comp.scale0, comp.scale1, 1);
        	comp.model.render(RENDERDATA.set(comp));
        	GL11.glPopMatrix();
        }
        if(asent) GL11.glPopMatrix();
	}
	
	public void linkModels(){
		for(CompDataRoot data : backgrounds) data.linkModel();
		for(CompDataRoot data : components) data.linkModel();
		for(CompDataRoot data : fonts) data.linkModel();
		linked = true;
	}

	public static enum ComponentType {
		
		BASE, COMPONENT, FONT
		
	}
	
	public static class CompDataRoot {
		
		@SideOnly(Side.CLIENT)
		public TrafficSignModel model;
		public final ComponentType type;
		public String comp;
		public RGB[] channels = new RGB[9];
		public int rotation, zoff;
		public float xoff, yoff;
		public float scale0 = 1, scale1 = 1;
		
		public CompDataRoot(String str, ComponentType type){
			this.type = type;
			comp = str;
			for(int i = 0; i < channels.length; i++) channels[i] = RGB.WHITE.copy();
			//channels[0].packed = RGB.GREEN.packed;
		}
		
		public CompDataRoot(NBTTagCompound com){
			this(com.getString("comp"), ComponentType.valueOf(com.getString("type")));
		}
		
		public CompDataRoot read(NBTTagCompound com){
			if(com == null) return this;
			if(com.hasKey("rot")) rotation = com.getInteger("rot");
			if(com.hasKey("zoff")) zoff = com.getInteger("zoff");
			if(com.hasKey("xoff")) xoff = com.getFloat("xoff");
			if(com.hasKey("yoff")) yoff = com.getFloat("yoff");
			if(com.hasKey("scale_x")) scale0 = com.getFloat("scale_x");
			if(com.hasKey("scale_y")) scale1 = com.getFloat("scale_y");
			for(int i = 0; i < channels.length; i++){
				if(com.hasKey("rgb" + i)) channels[i].packed = com.getInteger("rgb" + i);
			}
			return this;
		}

		public NBTTagCompound write(){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("comp", comp);
			compound.setString("type", type.name());
			if(rotation != 0) compound.setInteger("rot", rotation);
			if(zoff != 0) compound.setInteger("zoff", zoff);
			if(xoff != 0f) compound.setFloat("xoff", xoff);
			if(yoff != 0f) compound.setFloat("yoff", yoff);
			if(scale0 != 1f) compound.setFloat("scale_x", scale0);
			if(scale1 != 1f) compound.setFloat("scale_y", scale1);
			for(int i = 0; i < channels.length; i++){
				if(channels[i].packed != RGB.WHITE.packed) compound.setInteger("rgb" + i, channels[i].packed);
			}
			return compound;
		}

		@SideOnly(Side.CLIENT)
		public CompDataRoot linkModel(){
			switch(type){
				case BASE:
					model = TrafficSignLibrary.MODELS.get(TrafficSignLibrary.BACKGROUNDS.get(comp));
					break;
				case COMPONENT:
					model = TrafficSignLibrary.MODELS.get(TrafficSignLibrary.COMPONENTS.get(comp));
					break;
				case FONT:
					model = TrafficSignLibrary.MODELS.get(TrafficSignLibrary.FONTS.get(comp));
					break;
			}
			return this;
		}
		
	}
	
	public static class BaseData extends CompDataRoot {
		
		public boolean[] sides = new boolean[4];
		public boolean base = true;

		public BaseData(String str){
			super(str, ComponentType.BASE);
			for(int i = 0; i < sides.length; i++) sides[i] = true;
		}
		
		public BaseData(NBTTagCompound com){
			super(com);
			read(com);
		}

		@Override
		public CompDataRoot read(NBTTagCompound com){
			super.read(com);
			if(com.hasKey("border_top")) sides[0] = com.getBoolean("border_top");
			if(com.hasKey("border_left")) sides[1] = com.getBoolean("border_left");
			if(com.hasKey("border_right")) sides[2] = com.getBoolean("border_right");
			if(com.hasKey("border_bot")) sides[3] = com.getBoolean("border_bot");
			if(com.hasKey("base")) base = com.getBoolean("base");
			return this;
		}

		@Override
		public NBTTagCompound write(){
			NBTTagCompound compound = super.write();
			compound.setBoolean("border_top", sides[0]);
			compound.setBoolean("border_left", sides[1]);
			compound.setBoolean("border_right", sides[2]);
			compound.setBoolean("border_bot", sides[3]);
			compound.setBoolean("base", base);
			return compound;
		}
		
	}
	
	public static class ComponentData extends CompDataRoot {

		public ComponentData(String str){
			super(str, ComponentType.COMPONENT);
		}
		
		public ComponentData(NBTTagCompound com){
			super(com);
			read(com);
		}
		
	}
	
	public static class FontData extends CompDataRoot {

		public String text = "text";
		private ArrayList<FontOffset> chars = new ArrayList<>();
		private boolean centered;

		public FontData(String str){
			super(str, ComponentType.FONT);
		}
		
		public FontData(NBTTagCompound com){
			super(com);
			read(com);
		}

		public ArrayList<FontOffset> text(){
			return chars;
		}

		public void text(String str){
			chars = null;
			text = str;
		}

		public void init(FontModelData fontdata){
			chars = new ArrayList<>();
			if(text.startsWith("!")){
				centered = true;
				text = text.substring(1);
			}
			if(text.length() == 0) return;
			char[] textchars = text.toCharArray();
			char[] upperchars = text.toUpperCase().toCharArray();
			char[] lowerchars = text.toLowerCase().toCharArray();
			float passed = 0, last = 0;
			for(int i = 0; i < textchars.length; i++){
				if(textchars[i] == ' '){
					passed += fontdata.space_width + fontdata.letter_spacing;
					continue;
				}
				Object[] cher = findChar(fontdata.chars, textchars[i], lowerchars[i], upperchars[i]);
				if(cher == null){
					passed += fontdata.space_width + fontdata.letter_spacing;
					Print.log("Model for char '" + textchars[i] + "'/#" + Integer.toHexString(textchars[i]) + " not found!");
					continue;
				}
				chars.add(new FontOffset((char)cher[0], (CharModelData)cher[1], passed * Static.sixteenth));
				passed += last = ((CharModelData)cher[1]).width + fontdata.letter_spacing;
			}
			if(centered){
				passed = (passed - last) * 0.5f * Static.sixteenth;
				for(FontOffset offset : chars){
					offset.offset -= passed;
				}
			}
		}

		private static Object[] findChar(HashMap<Character, CharModelData> chars, char c, char l, char u){
			if(chars.containsKey(c)) return new Object[]{ c, chars.get(c) };
			if(chars.containsKey(l)) return new Object[]{ l, chars.get(l) };
			if(chars.containsKey(u)) return new Object[]{ u, chars.get(u) };
			return null;
		}
		
		@Override
		public CompDataRoot read(NBTTagCompound com){
			super.read(com);
			if(com.hasKey("text")) text(com.getString("text"));
			if(com.hasKey("centered")) centered = com.getBoolean("centered");
			return this;
		}

		@Override
		public NBTTagCompound write(){
			NBTTagCompound compound = super.write();
			if(text != null) compound.setString("text", text);
			if(centered) compound.setBoolean("centered", centered);
			return compound;
		}
		
	}
	
	public static class FontOffset {
		
		public char id;
		public float offset;
		public CharModelData data;
		
		public FontOffset(char c, CharModelData data, float passed){
			id = c;
			offset = passed;
			this.data = data;
		}
		
	}

	public CompDataRoot getCompData(ComponentType type, int index){
		if(type == null || index < 0) return null;
		switch(type){
			case BASE:
				if(index >= backgrounds.size()) return null;
				else return backgrounds.get(index);
			case COMPONENT:
				if(index >= components.size()) return null;
				else return components.get(index);
			case FONT:
				if(index >= fonts.size()) return null;
				else return fonts.get(index);
			default: return null;
		}
	}

	public boolean isEmpty(){
		return backgrounds.size() == 0 && components.size() == 0 && fonts.size() == 0;
	}

	public AxisAlignedBB getBB(){
		return boundingbox;
	}

}
