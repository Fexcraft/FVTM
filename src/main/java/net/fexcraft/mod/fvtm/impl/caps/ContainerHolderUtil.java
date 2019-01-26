package net.fexcraft.mod.fvtm.impl.caps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.packet.IPacketListener;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerHolderEntity;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.capability.ContainerHolder;
import net.fexcraft.mod.fvtm.api.capability.FVTMCaps;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerHolderUtil implements ICapabilitySerializable<NBTBase> {

	public static final String REGNAM = "fvtm:containerholder";
	private Implementation instance;
	
	public ContainerHolderUtil(Entity entity){
		instance = (Implementation)new Implementation().setEntity(entity);
		if(instance.conholder != null){
			instance.conholder.setupCapability(instance);
		}
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability != null && capability == FVTMCaps.CONTAINER;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		return capability != null && capability == FVTMCaps.CONTAINER ? FVTMCaps.CONTAINER.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT(){
		return FVTMCaps.CONTAINER.getStorage().writeNBT(FVTMCaps.CONTAINER, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt){
		FVTMCaps.CONTAINER.getStorage().readNBT(FVTMCaps.CONTAINER, instance, null, nbt);
	}
	
	public static class Storage implements IStorage<ContainerHolder> {

		@Override
		public NBTBase writeNBT(Capability<ContainerHolder> capability, ContainerHolder instance, EnumFacing side){
			return ((Implementation)instance).writeToNBT(false, side);
		}

		@Override
		public void readNBT(Capability<ContainerHolder> capability, ContainerHolder instance, EnumFacing side, NBTBase nbt){
			((Implementation)instance).readFromNBT(false, side, (NBTTagCompound)nbt);
		}
		
	}
	
	public static class Callable implements java.util.concurrent.Callable<ContainerHolder> {

		@Override
		public ContainerHolder call() throws Exception {
			return new Implementation();
		}
		
	}
	
	public static class Implementation implements ContainerHolder {
		
		private ContainerHolderEntity conholder;
		private ContainerSlot singular;
		private TreeMap<String, ContainerSlot> map;
		private Entity entity;
		private boolean singlecon;
		
		public Implementation(){
			this.singlecon = true;
		}

		@Override
		public ContainerData getContainer(String id){
			if(singlecon) return singular.getContainerData(id);
			ContainerSlot slot = getContainerSlot(id);
			return slot == null ? null : slot.getContainerData(id);
		}

		@Override
		public ContainerType getContainerType(String id){
			if(singlecon) return singular.size;
			ContainerSlot slot = getContainerSlot(id);
			return slot == null ? null : slot.getContainerType(id);
		}

		@Override
		public Collection<String> getContainerIDs(ContainerType oftype){
			if(!singlecon && oftype == null)return map.keySet();
			ArrayList<String> list = new ArrayList<>();
			if(singlecon){
				singular.addIDsToList(list, oftype);
			}
			else{
				for(ContainerSlot slot : map.values()){
					slot.addIDsToList(list, oftype);
				}
			} return list;
		}

		@Override
		public Map<String, AxisAlignedBB> getContainerAABBs(ContainerType oftype){
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public AxisAlignedBB getContainerAABB(String id){
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean setContainer(String id, ContainerData data){
			ContainerSlot slot = getContainerSlot(id); return slot == null ? false : slot.setContainerData(id, data);
		}

		@SuppressWarnings("unlikely-arg-type")
		public ContainerSlot getContainerSlot(String id){
			if(singlecon) return singular;
			for(ContainerSlot slot : map.values()){
				if(slot.equals(id)) return slot;
			} return null;
		}

		@Override
		public ContainerHolder setEntity(Entity entity){
			this.entity = entity; if(entity instanceof ContainerHolderEntity){ conholder = (ContainerHolderEntity)entity; } return this;
		}

		@Override
		public Entity getEntity(){
			return entity;
		}
		
		@Override
		public boolean hasOnlyOneContainer(){
			return this.singlecon;
		}

		@Override
		public void setOnlyOneContainer(boolean value){
			if(map != null && !map.isEmpty()) map.clear();
			if(!value && map == null){ map = new TreeMap<>(); singular = null; }
			if(value && map != null){ map = null; } this.singlecon = value;
		}

		@Override
		public void addContainerSlot(String id, Vec3d relpos, ContainerType deftype, float rotangle, ContainerType... supported){
			//Print.debug(id, relpos, deftype, rotangle, supported);
			if(map == null) singlecon = true;
			if(singlecon){
				singular = new ContainerSlot(this, id, new float[]{ (float)relpos.x, (float)relpos.y, (float)relpos.z }, rotangle, deftype, supported);
			}
			else{
				if(id == null) id = "containerslot" + map.size();//:thinking:
				map.put(id, new ContainerSlot(this, id, new float[]{ (float)relpos.x, (float)relpos.y, (float)relpos.z }, rotangle, deftype, supported));
			}
			//Print.debug(singular, map, singlecon);
			//Static.stop();
		}

		@SideOnly(Side.CLIENT) @Override
		public void render(){
			if(singlecon){ if(singular != null) singular.render(); }
			else{
				for(ContainerSlot slot : map.values()){
					if(slot != null) slot.render();
				}
			}
		}

		@Override
		public void sync(boolean tellserver){
			if(entity == null || entity.world == null) return;
			if(entity.world.isRemote){
				if(!tellserver) return;
				NBTTagCompound compound = getBasicPacket("request_sync", false);
				PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
				Print.debug("sending sync request packet to server");
				//inform server that a resync is requested
				return;
			}
			NBTTagCompound compound = getBasicPacket("sync", true);
			PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(compound), Resources.getTargetPoint(entity));
			Print.debug("sending sync packet to clients");
			//send update packet to client/s
		}

		private NBTTagCompound getBasicPacket(String task, boolean appenddata){
			NBTTagCompound compound = appenddata ? this.writeToNBT(true, null) : new NBTTagCompound();
			compound.setInteger("dimension", entity.dimension);
			compound.setInteger("entity", entity.getEntityId());
			compound.setString("target_listener", REGNAM.toString());
			compound.setString("task", task);
			return compound;
		}

		public NBTTagCompound writeToNBT(boolean syncpacket, EnumFacing side){
			NBTTagCompound compound = new NBTTagCompound();
			if(!singlecon){
				StringBuffer buffer = new StringBuffer();
				int i = 0, siz = map.keySet().size() - 1;
				for(String str : map.keySet()){
					buffer.append(str); if(i != siz) buffer.append(","); i++;
				}
				compound.setString("slot-ids", buffer.toString());
			}
			else{
				compound.setBoolean("singular", true);
				compound.setString("slot-ids", singular.id);
			}
			NBTTagList list = new NBTTagList();
			if(singlecon){ list.appendTag(singular.toNBT(syncpacket)); }
			else{ for(ContainerSlot slot : map.values()) list.appendTag(slot.toNBT(syncpacket)); }
			compound.setTag("slots", list);
			Print.debug(compound);
			return compound;
		}

		public void readFromNBT(boolean syncpacket, EnumFacing side, NBTTagCompound compound){
			Print.debug(compound);
			if(compound == null || compound.getKeySet().isEmpty()) return;
			this.setOnlyOneContainer(compound.hasKey("singular") && compound.getBoolean("singular"));
			String[] cons = compound.getString("slot-ids").split(",");
			NBTTagList list = (NBTTagList)compound.getTag("slots");
			for(NBTBase base : list){
				NBTTagCompound com = (NBTTagCompound)base;
				String id = com.getString("id");
				if(singlecon){
					if(!id.equals(cons[0])) continue;
					singular = new ContainerSlot(this).fromNBT(syncpacket, com); break;
				}
				boolean found = false; for(String str : cons){ if(str.equals(id)){ found = true; break; } } if(!found) continue;
				map.put(id, new ContainerSlot(this).fromNBT(syncpacket, com));
			}
		}
		
	}
	
	public static class ContainerSlot {
		
		public ContainerType size, curr;
		public ContainerType[] supported;
		public ContainerData[] data;
		//
		private String id;
		private float[] relpos = new float[3];
		private float rotangle;
		//
		public Implementation impl;
		private static String div = ",";
		
		public final String ID(){
			return id;
		}
		
		public ContainerSlot(Implementation impl, String id, float[] relpos, float rotangle, ContainerType size, ContainerType... accepted){
			this.size = this.curr = size; this.id = id; this.impl = impl; ArrayList<ContainerType> types = new ArrayList<ContainerType>();
			for(ContainerType type : accepted){
				if(type.length() >= size.length()) continue;
				if((size.length() / type.length()) % 1 != 0) continue;
				types.add(type);
			} this.supported = types.toArray(new ContainerType[0]);
			this.relpos = relpos; this.rotangle = rotangle;
			data = new ContainerData[]{ null };
			if(this.id == null) this.id = "singular";
			//temporary for testing
			/*try {
				Container con = Resources.CONTAINERS.getValue(new net.minecraft.util.ResourceLocation("hcp:medium"));
				data[0] = con.getDataClass().getConstructor(Container.class).newInstance(con);
			}
			catch(Throwable thr){ thr.printStackTrace(); Static.stop(); }*/
		}
		
		/** Only to be used with the READ method! */
		public ContainerSlot(Implementation impl){ this.impl = impl; }

		public NBTTagCompound toNBT(boolean syncpacket){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("id", id);
			if(syncpacket){
				compound.setFloat("relpos_x", relpos[0]);
				compound.setFloat("relpos_y", relpos[1]);
				compound.setFloat("relpos_z", relpos[2]);
				compound.setString("size", size.name());
				if(supported != null && supported.length > 0){
					StringBuffer buffer = new StringBuffer();
					for(int i = 0; i < supported.length; i++){
						buffer.append(supported[i]); if(i != supported.length - 1) buffer.append(",");
					}
					compound.setString("supported", buffer.toString());
				}
				compound.setFloat("rotangle", rotangle);
			}
			compound.setString("current", curr.name());
			compound.setInteger("segments", this.getNewArrayLength(size, curr));
			NBTTagList list = new NBTTagList();
			for(int i = 0; i < data.length; i++){
				if(data[i] == null) continue;
				NBTTagCompound com = new NBTTagCompound();
				com.setString("id", id + div + i);
				data[i].writeToNBT(com); list.appendTag(com);
			}
			compound.setTag("data", list);
			return compound;
		}

		public ContainerSlot fromNBT(boolean syncpacket, NBTTagCompound compound){
			if(!compound.getString("id").equals(id) && !syncpacket) return null;
			if(syncpacket){
				id = compound.getString("id");
				relpos[0] = compound.getFloat("relpos_x");
				relpos[1] = compound.getFloat("relpos_y");
				relpos[2] = compound.getFloat("relpos_z");
				size = ContainerType.valueOf(compound.getString("size"));
				if(compound.hasKey("supported")){
					String[] supp = compound.getString("supported").split(",");
					supported = new ContainerType[supp.length];
					for(int i = 0; i < supp.length; i++){
						supported[i] = ContainerType.valueOf(supp[i]);
					}
				}
				rotangle = compound.getFloat("rotangle");
			}
			NBTTagList list = (NBTTagList)compound.getTag("data");
			data = new ContainerData[compound.getInteger("segments")];
			for(int i = 0; i < data.length; i++){
				NBTTagCompound com = null;
				for(NBTBase base : list){
					com = (NBTTagCompound)base;
					if(!com.getString("id").equals(id + div + i)){
						com = null; continue;
					}
				} if(com == null) continue;
				data[i] = Resources.getContainerData(com);
			}
			Print.debug(compound);
			Print.debug(data[0]);
			return this;
		}

		public void addIDsToList(ArrayList<String> list, ContainerType oftype){
			if(oftype == size){ list.add(id); }
			else if(oftype == curr){
				for(int i = 0; i < data.length; i++){ list.add(id + div + i); }
			}
			else{
				boolean contains = false;
				for(ContainerType supp : supported){
					if(supp == oftype){ contains = true; break; }
				}
				if(contains && isEmpty()){
					int length = getNewArrayLength(size, oftype);
					for(int i = 0; i < length; i++){ list.add(id + div + i); }
				}
				else return;
			}
		}

		private int getNewArrayLength(ContainerType size, ContainerType oftype){
			switch(size){
				case LARGE:{
					switch(oftype){
						case LARGE: return 1;
						case MEDIUM: return 2;
						case SMALL: return 4;
						case XSMALL: return 6;
						case TINY: return 12;
					} break;
				}
				case MEDIUM:{
					switch(oftype){
						case LARGE: return 0;
						case MEDIUM: return 1;
						case SMALL: return 2;
						case XSMALL: return 3;
						case TINY: return 6;
					} break;
				}
				case SMALL:{
					switch(oftype){
						case LARGE: return 0;
						case MEDIUM: return 0;
						case SMALL: return 1;
						case XSMALL: return 0;
						case TINY: return 3;
					} break;
				}
				case XSMALL:{
					switch(oftype){
						case LARGE: return 0;
						case MEDIUM: return 0;
						case SMALL: return 0;
						case XSMALL: return 1;
						case TINY: return 2;
					} break;
				}
				case TINY:{
					switch(oftype){
						case LARGE: return 0;
						case MEDIUM: return 0;
						case SMALL: return 0;
						case XSMALL: return 0;
						case TINY: return 1;
					} break;
				}
			} return 1;
		}

		private boolean isEmpty(){
			for(ContainerData condata : data){
				if(condata != null) return false;
			}
			return true;
		}

		@Override
		public boolean equals(Object other){
			if(other instanceof String) return ((String)other).equals(this.id.split(div)[0]);
			if(other instanceof ContainerSlot == false) return false;
			return ((ContainerSlot)other).id.split(div)[0].equals(this.id.split(div)[0]);
		}

		public boolean setContainerData(String id, ContainerData condata){
			if(condata.getContainer().getType() != size){
				int in = this.getsubid(id);
				if(condata.getContainer().getType() == curr){
					data[in] = condata; this.impl.sync(false); return true;
				}
				else{
					int newargsiz = this.getNewArrayLength(size, condata.getContainer().getType());
					if(newargsiz == 0) return false;
					if(newargsiz == 1 && data.length == 1){
						curr = condata.getContainer().getType();
						data[0] = condata; this.impl.sync(false); return true;
					}
					else{
						curr = condata.getContainer().getType();
						data = new ContainerData[newargsiz];
						data[newargsiz] = condata; this.impl.sync(false);
						return true;
					}
				}
			}
			else{
				data = new ContainerData[]{ condata }; this.impl.sync(false); return true;
			}
		}

		public ContainerData getContainerData(String id){
			if(data.length == 1) return data[0]; int in = this.getsubid(id);
			return in < 0 ? null : in >= data.length ? null : data[in];
		}

		public ContainerType getContainerType(String id){
			return data.length == 1 ? size : curr;
		}
		
		private int getsubid(String id){
			String[] split = id.split(div);
			return split.length == 1 ? 0 : Integer.parseInt(split[1]);
		}

		@SideOnly(Side.CLIENT)
		public void render(){
	        GL11.glPushMatrix();
            GL11.glRotatef(180f, 0f, 0f, 1f);
	        GL11.glRotatef(this.rotangle, 0, 1, 0);
	        GL11.glTranslatef(relpos[0], relpos[1], relpos[2]);
	        for(int i = 0; i < data.length; i++){
	        	if(data[i] != null){
	        		ModelBase.bindTexture(data[i].getTexture());
	        		data[i].getContainer().getModel().render(data[i], null, null, -23);
	        	}
	        }
	        GL11.glPopMatrix();
		}
		
	}
	
	public static class Client implements IPacketListener<PacketNBTTagCompound> {

		@Override public String getId(){ return REGNAM; }

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("task")) return;
			Print.console(packet.nbt);
			//int dim = packet.nbt.getInteger("dimension");
			int ent = packet.nbt.getInteger("entity");
			World world = net.minecraft.client.Minecraft.getMinecraft().world;
			Entity entity = world.getEntityByID(ent);
			if(entity == null){
				Print.debug("Entity for NBT-CONTAINER-PACKET could not be found, ID: " + ent); return;
			}
			Implementation impl = (Implementation)entity.getCapability(FVTMCaps.CONTAINER, EnumFacing.UP);
			switch(packet.nbt.getString("task")){
				case "sync":{
					impl.readFromNBT(true, EnumFacing.UP, packet.nbt); break;
				}
			}
			return;
		}
		
	}
	
	public static class Server implements IPacketListener<PacketNBTTagCompound> {

		@Override public String getId(){ return REGNAM; }

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("task")) return;
			int dim = packet.nbt.getInteger("dimension");
			int ent = packet.nbt.getInteger("entity");
			World world = Static.getServer().getWorld(dim);
			EntityPlayerMP player = (EntityPlayerMP)objs[0];
			if(world == null){
				Print.debug("World/Dimension for NBT-CONTAINER-PACKET could not be found, ID: " + dim); return;
			}
			Entity entity = world.getEntityByID(ent);
			if(entity == null){
				Print.debug("Entity for NBT-CONTAINER-PACKET could not be found, ID: " + ent); return;
			}
			Implementation impl = (Implementation)entity.getCapability(FVTMCaps.CONTAINER, EnumFacing.UP);
			switch(packet.nbt.getString("task")){
				case "request_sync":{
					PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(impl.getBasicPacket("sync", true)), player);
					break;
				}
			}
			return;
		}
		
	}

}
