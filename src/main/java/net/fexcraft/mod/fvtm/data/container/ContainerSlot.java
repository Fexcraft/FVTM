package net.fexcraft.mod.fvtm.data.container;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** @author Ferdinand Calo' (FEX___96) */
public class ContainerSlot {

	private ContainerData[] containers;
	public ContainerType onlytype;
	public String rotpoint;
	public Vec3d position;
	public float rotation;
	public byte length;
	public String id;

	/** Constructor only for loading from NBT. */
	public ContainerSlot(){}

	/** Constructor to create new ContainerSlots. */
	public ContainerSlot(String id, byte length, Vec3d pos, float rotation, @Nullable ContainerType lock, String rotpoint){
		this.containers = new ContainerData[this.length = length];
		onlytype = lock;
		this.id = id;
		this.position = pos;
		this.rotation = rotation;
		this.rotpoint = rotpoint;
	}

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		if(onlytype != null) compound.setString("Type", onlytype.name());
		compound.setByte("Length", length);
		compound.setString("Name", id);
		compound.setDouble("PositionX", position.x);
		compound.setDouble("PositionY", position.y);
		compound.setDouble("PositionZ", position.z);
		compound.setFloat("RotationY", rotation);
		if(rotpoint != null) compound.setString("SwivelPoint", rotpoint);
		for(byte i = 0; i < containers.length; i++){
			if(containers[i] == null) continue;
			compound.setTag("Slot" + i, containers[i].write(new NBTTagCompound()));
		}
		return compound;
	}

	public ContainerSlot read(NBTTagCompound compound){
		if(!compound.hasKey("Length")){
			try{
				throw new Exception("Container slot could not be loaded, compound is missing length data.");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		id = compound.getString("Name");
		onlytype = null;
		if(compound.hasKey("Type")) onlytype = ContainerType.valueOf(compound.getString("Type"));
		position = new Vec3d(compound.getDouble("PositionX"), compound.getDouble("PositionY"), compound.getDouble("PositionZ"));
		rotation = compound.getFloat("RotationY");
		rotpoint = compound.hasKey("SwivelPoint") ? compound.getString("SwivelPoint") : null;
		containers = new ContainerData[length = compound.getByte("Length")];
		for(byte i = 0; i < containers.length; i++){
			if(!compound.hasKey("Slot" + i)) continue;
			containers[i] = Resources.getContainerData(compound.getCompoundTag("Slot" + i));
		}
		renderoffset = null;
		return this;
	}

	public void clear(){
		containers = new ContainerData[length];
	}

	@Override
	public String toString(){
		return "ContainerSlot[" + id + ", " + length + ", " + rotation + "];";
	}

	/** True if filled, false otherwise. */
	public boolean[] getFillStateArray(){
		boolean[] bools = new boolean[length];
		for(int i = 0; i < containers.length; i++){
			if(containers[i] != null){
				int l = containers[i].getContainerType().length();
				if(l > 1){
					for(int j = 0; j < l; j++){
						if(j + i > bools.length) break;
						bools[j + i] = true;
					}
				}
				else{
					bools[i] = true;
				}
			}
		}
		return bools;
	}

	public ContainerData[] getContainers(){
		return containers;
	}

	public void setContainer(int index, ContainerData con){
		containers[index] = con;
		renderoffset = null;
	}

	private float[] renderoffset;

	@SideOnly(Side.CLIENT)
	public void render(Entity entity){
		if(renderoffset == null) loadRenderOffset();
		org.lwjgl.opengl.GL11.glRotatef(180f, 0f, 1f, 0f);
		org.lwjgl.opengl.GL11.glTranslated(position.x, position.y, position.z);
		org.lwjgl.opengl.GL11.glRotatef(180f, 0f, 0f, 1f);
		org.lwjgl.opengl.GL11.glRotatef(rotation, 0, 1, 0);
		if(rotpoint != null && entity != null){
			VehicleEntity ent = (VehicleEntity)entity;
			PartData data = ent.getVehicleData().getPart(id);
    		net.fexcraft.mod.fvtm.model.PartModel.translateAndRotatePartOnSwivelPoint(ent.getVehicleData(), data, net.minecraft.client.Minecraft.getMinecraft().getRenderPartialTicks());
		}
		for(int i = 0; i < containers.length; i++){
			if(containers[i] != null){
				// Print.debug("Rendering Slot Sub " + i);
				if(renderoffset[i] != 0f) org.lwjgl.opengl.GL11.glTranslatef(renderoffset[i], 0, 0);
				net.fexcraft.lib.tmt.ModelBase.bindTexture(containers[i].getTexture());
				containers[i].getType().getModel().render(containers[i], null, entity, entity.getCapability(Capabilities.RENDERCACHE, null), i);
				if(renderoffset[i] != 0f) org.lwjgl.opengl.GL11.glTranslatef(-renderoffset[i], 0, 0);
			}
		}
		if(rotpoint != null) org.lwjgl.opengl.GL11.glPopMatrix();
		org.lwjgl.opengl.GL11.glTranslated(-position.x, -position.y, -position.z);
	}

	private void loadRenderOffset(){
		renderoffset = new float[length];
		for(int i = 0; i < containers.length; i++){
			if(containers[i] == null) continue;
			renderoffset[i] = i + (containers[i].getContainerType().length() / 2f) - (length / 2f);
		}
	}

}
