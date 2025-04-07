package net.fexcraft.mod.fvtm.data.container;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.util.AnotherUtil;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/** @author Ferdinand Calo' (FEX___96) */
public class ContainerSlot {

	private ContainerData[] containers;
	public ContainerType onlytype;
	public String rotpoint;
	public V3D position;
	public float rotation;
	public byte length;
	public String id;

	/** Constructor only for loading from NBT. */
	public ContainerSlot(){}

	/** Constructor to create new ContainerSlots. */
	public ContainerSlot(String id, byte length, V3D pos, float rotation, @Nullable ContainerType lock, String rotpoint){
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
			compound.setTag("Slot" + i, containers[i].write(null).local());
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
		position = new V3D(compound.getDouble("PositionX"), compound.getDouble("PositionY"), compound.getDouble("PositionZ"));
		rotation = compound.getFloat("RotationY");
		rotpoint = compound.hasKey("SwivelPoint") ? compound.getString("SwivelPoint") : null;
		containers = new ContainerData[length = compound.getByte("Length")];
		for(byte i = 0; i < containers.length; i++){
			if(!compound.hasKey("Slot" + i)) continue;
			containers[i] = FvtmResources.getContainerData(compound.getCompoundTag("Slot" + i));
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
	public void render(Entity entity, double y, double p, double r){
		if(renderoffset == null) loadRenderOffset();
		org.lwjgl.opengl.GL11.glPushMatrix();
		if(entity instanceof VehicleEntity) y += 180;
		org.lwjgl.opengl.GL11.glRotated(y, 0, 1, 0);
		org.lwjgl.opengl.GL11.glRotated(p, 0, 0, 1);
		org.lwjgl.opengl.GL11.glRotated(r, 1, 0, 0);
		org.lwjgl.opengl.GL11.glTranslated(position.x, position.y, position.z);
		org.lwjgl.opengl.GL11.glRotated(180, 0, 0, 1);
		org.lwjgl.opengl.GL11.glRotatef(rotation, 0, 1, 0);
		if(rotpoint != null && entity != null){
			VehicleEntity ent = (VehicleEntity)entity;
			PartData data = ent.getVehicleData().getPart(id);
    		AnotherUtil.translateAndRotatePartOnSwivelPoint(ent.getVehicleData(), data, net.minecraft.client.Minecraft.getMinecraft().getRenderPartialTicks());
		}
		for(int i = 0; i < containers.length; i++){
			if(containers[i] != null){
				// Print.debug("Rendering Slot Sub " + i);
				if(renderoffset[i] != 0f) org.lwjgl.opengl.GL11.glTranslatef(renderoffset[i], 0, 0);
				TexUtil.bindTexture(containers[i].getTexture().getTexture());
				containers[i].getType().getModel().render(DefaultModel.RENDERDATA.set(containers[i], null).rc(entity.getCapability(Capabilities.RENDERCACHE, null)));
				if(renderoffset[i] != 0f) org.lwjgl.opengl.GL11.glTranslatef(-renderoffset[i], 0, 0);
			}
		}
		org.lwjgl.opengl.GL11.glPopMatrix();
	}

	@SideOnly(Side.CLIENT)
	public void renderDebug(Entity entity, double y, double p, double r, ContainerType type){
		if(type.length() > length) return;
		org.lwjgl.opengl.GL11.glPushMatrix();
		if(entity instanceof VehicleEntity) y += 180;
		org.lwjgl.opengl.GL11.glRotated(y, 0, 1, 0);
		org.lwjgl.opengl.GL11.glRotated(p, 0, 0, 1);
		org.lwjgl.opengl.GL11.glRotated(r, 1, 0, 0);
		org.lwjgl.opengl.GL11.glTranslated(position.x, position.y, position.z);
		org.lwjgl.opengl.GL11.glRotated(180, 0, 0, 1);
		org.lwjgl.opengl.GL11.glRotatef(rotation, 0, 1, 0);
		if(rotpoint != null && entity != null){
			VehicleEntity ent = (VehicleEntity)entity;
			PartData data = ent.getVehicleData().getPart(id);
    		AnotherUtil.translateAndRotatePartOnSwivelPoint(ent.getVehicleData(), data, net.minecraft.client.Minecraft.getMinecraft().getRenderPartialTicks());
		}
		boolean bool = false;
		for(int i = 0; i < length;){
			float off = i + (type.length() / 2f) - (length / 2f);
			org.lwjgl.opengl.GL11.glTranslatef(off, (bool ? .0625f : 0), 0);
			net.fexcraft.lib.common.math.RGB.glColorReset();
			net.fexcraft.mod.fvtm.model.DebugModels.CONTAINER[type.ordinal()].render();
			org.lwjgl.opengl.GL11.glTranslatef(-off, (bool ? -.0625f : 0), 0);
			i += type.length();
			bool = !bool;
		}
		net.fexcraft.lib.common.math.RGB.glColorReset();
		org.lwjgl.opengl.GL11.glPopMatrix();
	}

	private void loadRenderOffset(){
		renderoffset = new float[length];
		for(int i = 0; i < containers.length; i++){
			if(containers[i] == null) continue;
			renderoffset[i] = i + (containers[i].getContainerType().length() / 2f) - (length / 2f);
		}
	}

	/**
	 * @return last index
	 */
	public int reSort(){
		int index = 0;
		ContainerData[] newdat = new ContainerData[length];
		for(ContainerData data : getContainers()){
			if(data == null) continue;
			newdat[index] = data;
			index += data.getContainerType().length();
		}
		for(int i = 0; i < newdat.length; i++){
			setContainer(i, newdat[i]);
		}
		return index;
	}

}
