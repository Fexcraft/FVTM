package net.fexcraft.mod.fvtm.util;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.phys.Vec3;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Pos {

    public static final Pos NULL = new Pos(0, 0, 0);
	public final float x, y, z;
	public final float x16, y16, z16;

    public Pos(float x, float y, float z){
        this.x = x; this.y = y; this.z = z;
        x16 = x * Static.sixteenth;
        y16 = y * Static.sixteenth;
        z16 = z * Static.sixteenth;
    }

    public Pos(float[] pos){
    	this(pos.length >= 1 ? pos[0] : 0, pos.length >= 2 ? pos[1] : 0, pos.length >= 3 ? pos[2] : 0);
    }

    public Pos copy(){
        return new Pos(x, y, z);
    }

    public Pos clone(){
        return copy();
    }

    @Override
    public String toString(){
        return "[" + x + "," + y + "," + z + "]";
    }

    public float to16FloatX(){
        return x16;
    }

    public float to16FloatY(){
        return y16;
    }

    public float to16FloatZ(){
        return z16;
    }

	public com.google.gson.JsonElement toJson(boolean asarray){
		if(asarray){
			JsonArray array = new JsonArray();
			array.add(x); array.add(y); array.add(z);
			return array;
		}
		else{
	        JsonObject obj = new JsonObject();
	        obj.addProperty("x", x);
	        obj.addProperty("y", y);
	        obj.addProperty("z", z);
	        return obj;
		}
	}
	
	public static Pos fromJson(com.google.gson.JsonElement elm, boolean wasarray){
		float x, y, z;
		if(wasarray){
			JsonArray array = elm.getAsJsonArray();
			x = array.size() > 0 ? array.get(0).getAsFloat() : 0;
			y = array.size() > 1 ? array.get(1).getAsFloat() : 0;
			z = array.size() > 2 ? array.get(2).getAsFloat() : 0;
		}
		else{
			JsonObject obj = elm.getAsJsonObject();
			x = obj.has("x") ? obj.get("x").getAsFloat() : 0;
			y = obj.has("y") ? obj.get("y").getAsFloat() : 0;
			z = obj.has("z") ? obj.get("z").getAsFloat() : 0;
		}
		return new Pos(x, y, z);
	}
    
    private static String prefix(String prefix){
    	return prefix == null ? "" : prefix + "_";
    }

    public static Pos fromNBT(String prefix, CompoundTag compound){
    	prefix = prefix(prefix); return new Pos(compound.getFloat(prefix + "x"), compound.getFloat(prefix + "y"), compound.getFloat(prefix + "z"));
    }

    public CompoundTag toNBT(String prefix, CompoundTag compound){
    	prefix = prefix(prefix); if(compound == null){ compound = new CompoundTag(); }
        compound.putFloat(prefix + "x", x);
        compound.putFloat(prefix + "y", y);
        compound.putFloat(prefix + "z", z);
        return compound;
    }

    public void translate(){
        GL11.glTranslatef(x16, y16, z16);
    }

    public void translateR(){
        GL11.glTranslatef(-x16, -y16, -z16);
    }

    public Vec3 to16Double(){
        return new Vec3(x16, y16, z16);
    }

	public Vec3f to16Float(){
		return new Vec3f(x16, y16, z16);
	}

	public Pos add(Pos pos){
		return new Pos(x + pos.x, y + pos.y, z + pos.z);
	}

	public Pos sub(Pos pos){
		return new Pos(x - pos.x, y - pos.y, z - pos.z);
	}

}
