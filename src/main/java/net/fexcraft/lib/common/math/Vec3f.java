package net.fexcraft.lib.common.math;

/**
 * @author Ferdinand
 * @info Based off various Vector classes.
 */
public class Vec3f {
	
    public float x;
    public float y;
    public float z;
    
    public Vec3f(){
    	x = y = z = 0;
    }

    public Vec3f(float x, float y, float z){
        this.x = x == -0.0f ? 0.0f : x;
        this.y = y == -0.0f ? 0.0f : y;
        this.z = z == -0.0f ? 0.0f : z;
    }
    
    public Vec3f(float v){
        this(v, v, v);
    }
    
    public Vec3f(double v){
        this((float)v);
    }

    public Vec3f(Vec3f vector){
        this(vector.x, vector.y, vector.z);
    }
    
    public Vec3f(double xVec, double yVec, double zVec) {
		this((float)xVec, (float)yVec, (float)zVec);
	}

    public Vec3f(String[] array, int index){
		x = array.length >= index ? Float.parseFloat(array[index++]) : 0;
		y = array.length >= index ? Float.parseFloat(array[index++]) : 0;
		z = array.length >= index ? Float.parseFloat(array[index]) : 0;
	}

	public Vec3f(float[] array, int index){
		x = array.length >= index ? array[index++] : 0;
		y = array.length >= index ? array[index++] : 0;
		z = array.length >= index ? array[index] : 0;
	}

	public Vec3f sub(Vec3f vec){
        return this.sub(vec.x, vec.y, vec.z);
    }

    public Vec3f sub(float x, float y, float z){
        return this.add(-x, -y, -z);
    }

    public Vec3f add(Vec3f vec){
        return this.add(vec.x, vec.y, vec.z);
    }
    
    public Vec3f add(float x, float y, float z){
        return new Vec3f(this.x + x, this.y + y, this.z + z);
    }

    public Vec3f scale(float scale){
        return new Vec3f(x * scale, y * scale, z * scale);
    }

    public Vec3f multiply(float scale){
        return new Vec3f(x * scale, y * scale, z * scale);
    }

	public Vec3f divide(float div){
		return div == 0f ? this : new Vec3f(x / div, y / div, z / div);
	}
    
    public float dis(Vec3f vec){
        float x = vec.x - this.x, y = vec.y - this.y, z = vec.z - this.z;
        return (float)Math.sqrt(x * x + y * y + z * z);
    }
    
    public float sqdis(Vec3f vec){
        float x = vec.x - this.x, y = vec.y - this.y, z = vec.z - this.z;
        return x * x + y * y + z * z;
    }

    public float sqdis(float x, float y, float z){
        float xx = x - this.x, yy = y - this.y, zz = z - this.z;
        return xx * xx + yy * yy + zz * zz;
    }

    public boolean equals(Object obj){
        if(this == obj) return true;
        else if(obj instanceof Vec3f){
            Vec3f vec = (Vec3f)obj;
            return Float.compare(vec.x, x) == 0 && Float.compare(vec.y, y) == 0 && Float.compare(vec.z, z) == 0;
        }
        else return false;
    }

    public int hashCode(){
        long l = Float.floatToIntBits(this.x);
        int i = (int)(l ^ l >>> 32);
        l = Float.floatToIntBits(this.y);
        i = 31 * i + (int)(l ^ l >>> 32);
        l = Float.floatToIntBits(this.z);
        i = 31 * i + (int)(l ^ l >>> 32);
        return i;
    }
	
	@Override
	public String toString(){
		return String.format("Vec3f[ %s, %s, %s ]", x, y, z);
	}

	public Vec3f middle(Vec3f target){
		return new Vec3f((x + target.x) * 0.5, (y + target.y) * 0.5, (z + target.z) * 0.5);
	}
	
	//based on fvtm rail entity stuff

	public Vec3f distance(Vec3f dest, float am){
		Vec3f vec = new Vec3f((x + dest.x) * 0.5, (y + dest.y) * 0.5, (z + dest.z) * 0.5);
    	vec = direction(vec.x - x, vec.y - y, vec.z - z);
		return new Vec3f(x + (vec.x * am), y + (vec.y * am), z + (vec.z * am));
	}
	
    public double length(){
        return Math.sqrt(x * x + y * y + z * z);
    }
    
    public static double length(float... arr){
        return Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1] + arr[2] * arr[2]);
    }
    
    public static double length(Vec3f vec){
        return Math.sqrt(vec.x * vec.x + vec.y * vec.y + vec.z * vec.z);
    }
    
    public static Vec3f direction(float... arr){
    	double l = length(arr[0], arr[1], arr[2]);
    	return new Vec3f(arr[0] / l, arr[1] / l, arr[2] / l);
    }
    
    public static Vec3f direction(Vec3f vec){
    	double l = length(vec.x, vec.y, vec.z);
    	return new Vec3f(vec.x / l, vec.y / l, vec.z / l);
    }

	public Vec3f cross(Vec3f other){
		return new Vec3f(y * other.z - z * other.y, other.x * z - other.z * x, x * other.y - y * other.x);
	}

	public float dot(Vec3f other){
		return x * other.x + y * other.y + z * other.z;
	}

	public Vec3f normalize(Vec3f dest){
		float len = (float)length();
		return dest == null ? new Vec3f(x / len, y / len, z / len) : dest.set(x / len, y / len, z / len);
	}

	public Vec3f normalize(){
		return normalize(null);
	}

	private Vec3f set(float x, float y, float z){
		this.x = x; this.y = y; this.z = z;
		return this;
	}

	public float[] toFloatArray(){
		return new float[]{ x, y, z };
	}

	public double[] toDoubleArray(){
		return new double[]{ x, y, z };
	}

	public void copy(Vec3f pos){
		this.x = pos.x; this.y = pos.y; this.z = pos.z;
	}

	public boolean isNull(){
		return x == 0f && y == 0f && z == 0f;
	}
    
}