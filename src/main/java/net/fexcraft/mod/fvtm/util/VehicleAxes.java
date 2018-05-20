package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.util.vector.Matrix4f;
import net.fexcraft.mod.fvtm.util.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;

public class VehicleAxes {

    public VehicleAxes(){
        matrix = new Matrix4f();
    }

    public VehicleAxes(Matrix4f mat){
        matrix = mat;
        convertMatrixToAngles();
    }

    public VehicleAxes(float yaw, float pitch, float roll){
        setAngles(yaw, pitch, roll);
    }

    /**
     * Degrees
     */
    //TODO clean up this whole degree/radian stuff;
    private double yaw, pitch, roll;
    private Matrix4f matrix;

    public Vec3d getRelativeVector(Vec3d vec){
        Matrix4f mat = new Matrix4f();
        mat.m00 = (float) vec.x;
        mat.m10 = (float) vec.y;
        mat.m20 = (float) vec.z;
        Matrix4f.rotate((float) (roll * 3.14159265F / 180D), new Vector3f(1, 0, 0), mat, mat);
        Matrix4f.rotate((float) (pitch * 3.14159265F / 180D), new Vector3f(0, 0F, 1), mat, mat);
        Matrix4f.rotate((float) (yaw * 3.14159265F / 180D), new Vector3f(0, 1F, 0), mat, mat);
        return new Vec3d(mat.m00, mat.m10, mat.m20);
    }

    public VehicleAxes getRelativeVector(VehicleAxes axes){
        Matrix4f mat = new Matrix4f();
        mat.load(axes.getMatrix());
        mat.rotate((float) (roll * 3.14159265F / 180F), new Vector3f(1F, 0F, 0F));
        mat.rotate((float) (pitch * 3.14159265F / 180F), new Vector3f(0F, 0F, 1F));
        mat.rotate((float) (yaw * 3.14159265F / 180F), new Vector3f(0F, 1F, 0F));
        return new VehicleAxes(mat);
    }

    public static final double toRad(double d){
        return d * Math.PI / 180d;
    }

    public NBTTagCompound write(Entity ent, NBTTagCompound compound){
        if(ent != null){
            compound.setDouble("x", ent.posX);
            compound.setDouble("y", ent.posY);
            compound.setDouble("z", ent.posZ);
        }
        compound.setDouble("yaw", yaw);
        compound.setDouble("pitch", pitch);
        compound.setDouble("roll", roll);
        return compound;
    }

    public static VehicleAxes read(Entity ent, NBTTagCompound nbt){
        VehicleAxes axes = new VehicleAxes();
        axes.yaw = nbt.getDouble("yaw");
        axes.pitch = nbt.getDouble("pitch");
        axes.roll = nbt.getDouble("roll");
        if(ent != null){
            ent.prevPosX = ent.posX;
            ent.prevPosY = ent.posY;
            ent.prevPosZ = ent.posZ;
            ent.posX = nbt.getDouble("x");
            ent.posY = nbt.getDouble("y");
            ent.posZ = nbt.getDouble("z");
        }
        return axes;
    }

    public float getYaw(){
        return (float) yaw;
    }

    public double getRadianYaw(){
        return yaw * 3.14159265F / 180F;
    }

    public float getPitch(){
        return (float) pitch;
    }

    public double getRadianPitch(){
        return pitch * 3.14159265F / 180F;
    }

    public float getRoll(){
        return (float) roll;
    }

    public double getRadianRoll(){
        return roll * 3.14159265F / 180F;
    }

    public void copy(VehicleAxes axes){
        this.yaw = axes.yaw;
        this.roll = axes.roll;
        this.pitch = axes.pitch;
    }

    public void rotateYawD(float deg){
        matrix.rotate(deg * 3.14159265F / 180F, getYAxis().normalise(null));
        convertMatrixToAngles();
    }

    public void rotateYawR(float rad){
        matrix.rotate(rad, getYAxis().normalise(null));
        convertMatrixToAngles();
    }

    public void rotatePitchD(float deg){
        matrix.rotate(deg * 3.14159265F / 180F, getZAxis().normalise(null));
        convertMatrixToAngles();
    }

    public void rotatePitchR(float rad){
        matrix.rotate(rad, getZAxis().normalise(null));
        convertMatrixToAngles();
    }

    public void rotateRollD(float deg){
        matrix.rotate(deg * 3.14159265F / 180F, getXAxis().normalise(null));
        convertMatrixToAngles();
    }

    public void rototeRollR(float rad){
        matrix.rotate(rad, getXAxis().normalise(null));
        convertMatrixToAngles();
    }

    public Vector3f getXAxis(){
        return new Vector3f(matrix.m00, matrix.m10, matrix.m20);
    }

    public Vector3f getYAxis(){
        return new Vector3f(matrix.m01, matrix.m11, matrix.m21);
    }

    public Vector3f getZAxis(){
        return new Vector3f(-matrix.m02, -matrix.m12, -matrix.m22);
    }

    public Matrix4f getMatrix(){
        return matrix;
    }

    private final void convertMatrixToAngles(){
        yaw = (float) Math.atan2(matrix.m20, matrix.m00) * 180F / 3.14159265F;
        pitch = (float) Math.atan2(-matrix.m10, Math.sqrt(matrix.m12 * matrix.m12 + matrix.m11 * matrix.m11)) * 180F / 3.14159265F;
        roll = (float) Math.atan2(matrix.m12, matrix.m11) * 180F / 3.14159265F;
    }

    private final void convertToMatrix(boolean rad){
        matrix = new Matrix4f();
        matrix.rotate((float) (rad ? roll : roll * 3.14159265F / 180F), new Vector3f(1F, 0F, 0F));
        matrix.rotate((float) (rad ? pitch : pitch * 3.14159265F / 180F), new Vector3f(0F, 0F, 1F));
        matrix.rotate((float) (rad ? yaw : yaw * 3.14159265F / 180F), new Vector3f(0F, 1F, 0F));
        convertMatrixToAngles();
    }

    @Override
    public VehicleAxes clone(){
        VehicleAxes axes = new VehicleAxes();
        axes.matrix.load(getMatrix());
        axes.convertMatrixToAngles();
        return axes;
    }

    public void setAngles(double yaw, double pitch, double roll){
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
        convertToMatrix(false);
    }

    public void setRotation(float yaw, float pitch, float roll){
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
        convertToMatrix(true);
    }

    public void setRotation(double yaw, double pitch, double roll){
        setRotation((float) yaw, (float) pitch, (float) roll);
    }

}
