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
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.capability.ContainerHolder;
import net.fexcraft.mod.fvtm.api.capability.FVTMCaps;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
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
			return ((Implementation)instance).writeToNBT(side);
		}

		@Override
		public void readNBT(Capability<ContainerHolder> capability, ContainerHolder instance, EnumFacing side, NBTBase nbt){
			try{ ((Implementation)instance).readFromNBT(side, (NBTTagCompound)nbt); instance.sync(false); }
			catch(Exception e){ e.printStackTrace(); }
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
		private boolean singlecon, setup;
		//
		private VehicleAxes tempaxe = new VehicleAxes();
		
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
			if(!singlecon && oftype == null) return map.keySet();
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
			TreeMap<String, AxisAlignedBB> axis = new TreeMap<>();
			AxisAlignedBB[] aabbs = null;
			if(this.singlecon && singular != null){
				aabbs = singular.getAABB(oftype);
				if(aabbs.length > 1){
					for(int i = 0; i < aabbs.length; i++){
						axis.put(singular.id + ContainerSlot.div + i, aabbs[i]);
					}
				}
				else if(aabbs.length == 1){
					axis.put(singular.id, aabbs[0]);
				} else return axis;
			}
			else if(map != null && !map.isEmpty()){
				for(Map.Entry<String, ContainerSlot> entry : map.entrySet()){
					aabbs = entry.getValue().getAABB(oftype);
					if(aabbs.length > 1){
						for(int i = 0; i < aabbs.length; i++){
							axis.put(entry.getKey() + ContainerSlot.div + i, aabbs[i]);
						}
					}
					else if(aabbs.length == 1){
						axis.put(entry.getKey(), aabbs[0]);
					} else continue;
				}
			}
			return axis;
		}

		@Override
		public AxisAlignedBB getContainerAABB(String id){
			ContainerSlot slot = this.getContainerSlot(id);
			return slot == null ? null : slot.getAABB(null)[0];
		}

		@Override
		public ActionResult<ContainerData> setContainer(String id, ContainerData data, ICommandSender sender){
			ContainerSlot slot = getContainerSlot(id);
			if(slot == null){
				if(sender != null) Print.chat(sender, "Container slot not found.");
				return new ActionResult<ContainerData>(EnumActionResult.PASS, data);
			}
			else return slot.setContainerData(sender, id, data);
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
			if(setup) return; this.singlecon = value;
			if(singlecon){
				if(map != null){
					if(!map.isEmpty() && singular == null){
						singular = map.values().toArray(new ContainerSlot[0])[0];
					} map.clear(); map = null;
				}
			}
			else{
				map = new TreeMap<>(); singular = null;
				if(singular != null){
					this.map.put(singular.id, singular);
				}
			}
		}

		@Override
		public void addContainerSlot(String id, Vec3d relpos, ContainerType deftype, float rotangle, ContainerType... supported){
			if(setup) return; if(map == null) singlecon = true;
			if(singlecon){
				if(singular != null) return;
				singular = new ContainerSlot(this, id, new float[]{ (float)relpos.x, (float)relpos.y, (float)relpos.z }, rotangle, deftype, supported);
			}
			else{
				if(id == null) id = "containerslot" + map.size();/*//:thinking:*/ if(map.containsKey(id)) return;
				map.put(id, new ContainerSlot(this, id, new float[]{ (float)relpos.x, (float)relpos.y, (float)relpos.z }, rotangle, deftype, supported));
			}
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
			NBTTagCompound compound = appenddata ? this.writeToNBT(null) : new NBTTagCompound();
			compound.setInteger("dimension", entity.dimension);
			compound.setInteger("entity", entity.getEntityId());
			compound.setString("target_listener", REGNAM.toString());
			compound.setString("task", task);
			return compound;
		}

		public NBTTagCompound writeToNBT(EnumFacing side){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setBoolean("setup", setup);
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
				compound.setString("slot-ids", singular == null ? ContainerSlot.def : singular.ID());
			}
			NBTTagList list = new NBTTagList();
			if(singlecon){ if(singular != null) list.appendTag(singular.toNBT()); }
			else{ for(ContainerSlot slot : map.values()) list.appendTag(slot.toNBT()); }
			compound.setTag("slots", list);
			return compound;
		}

		public void readFromNBT(EnumFacing side, NBTTagCompound compound){
			if(compound == null || compound.getKeySet().isEmpty()) return;
			this.setOnlyOneContainer(compound.hasKey("singular") && compound.getBoolean("singular"));
			this.setup = compound.getBoolean("setup");
			String[] cons = compound.getString("slot-ids").split(",");
			if(cons.length == 0){
				Print.debug("length 0 " + compound.getString("slot-ids"));
				cons = new String[]{ ContainerSlot.def };
			}
			NBTTagList list = (NBTTagList)compound.getTag("slots");
			for(NBTBase base : list){
				NBTTagCompound com = (NBTTagCompound)base;
				String id = com.getString("id");
				if(singlecon){
					if(!id.equals(cons[0])) continue;
					singular = new ContainerSlot(this).fromNBT(com); break;
				}
				boolean found = false; for(String str : cons){ if(str.equals(id)){ found = true; break; } } if(!found) continue;
				map.put(id, new ContainerSlot(this).fromNBT(com));
			}
		}

		@Override
		public void dropContents(){
			if(entity.world.isRemote) return;
			if(!singlecon) for(ContainerSlot slot : map.values()) slot.dropContents(); else if(singular != null) singular.dropContents();
		}

		@Override
		public void openGui(EntityPlayer player, String slot){
			if(slot == null){ if(singlecon) slot = singular.id; else return; }
			int y = -1, i = 0; Collection<String> coll = this.getContainerIDs(null);
			for(String str : coll){ if(str.equals(slot)){ y = i; break; } i++; }
			player.openGui(FVTM.getInstance(), GuiHandler.VEH_INV_Container, player.world, entity.getEntityId(), y, 0);
		}

		public void updateAxe(){
			if(conholder == null){
				tempaxe.setRotation(entity.getPitchYaw().y, entity.getPitchYaw().x, 0);
			}
			else{
				float[] relpos = conholder.getEntityRotationForContainer();
				tempaxe.setRotation(relpos[0], relpos[1], relpos[2]);
			}
		}

		@Override
		public boolean isSetup(){
			return setup;
		}

		@Override
		public boolean setSetup(boolean bool){
			return setup = bool;
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
		private static String div = ",", def = "singular";
		private float[] renderoffset;
		
		public final String ID(){
			return id;
		}
		
		public AxisAlignedBB[] getAABB(ContainerType type){
			impl.updateAxe(); if(type == size) return new AxisAlignedBB[]{ this.getRelPos(null) };
			AxisAlignedBB[] all = new AxisAlignedBB[this.getNewArrayLength(size, type)];
			float[] rel = this.loadRenderOffset(type);
			for(int i = 0; i < all.length; i++){
				all[i] = this.getRelPos(new Vec3d(relpos[0] + rel[i], relpos[1], relpos[2]));
			} return all;
		}

		private AxisAlignedBB getRelPos(Vec3d pos){
			Vec3d rel = impl.tempaxe.getRelativeVector(pos == null ? new Vec3d(relpos[0], relpos[1], relpos[2]) : pos);
			return new AxisAlignedBB(-0.2 + rel.x, rel.y, -0.2 + rel.z, 0.2 + rel.x, 0.6 + rel.y, 0.2 + rel.z);
		}

		public void dropContents(){
			for(ContainerData datt : data){
				if(datt == null) continue;
				ItemStack stack = datt.getContainer().getItemStack(datt);
				EntityItem item = new EntityItem(impl.entity.world);
				item.setPosition(impl.entity.posX, impl.entity.posY + 0.5, impl.entity.posZ);
				item.setItem(stack); impl.entity.world.spawnEntity(item);
			}
		}

		public ContainerSlot(Implementation impl, String id, float[] relpos, float rotangle, ContainerType size, ContainerType... accepted){
			this.size = this.curr = size; this.id = id; this.impl = impl; ArrayList<ContainerType> types = new ArrayList<ContainerType>();
			if(accepted != null){
				for(ContainerType type : accepted){
					if(type.length() >= size.length()) continue;
					if((size.length() / type.length()) % 1 != 0) continue;
					types.add(type);
				}
			} this.supported = types.toArray(new ContainerType[0]);
			this.relpos = relpos; this.rotangle = rotangle; data = new ContainerData[]{ null }; if(this.id == null) this.id = def;
		}
		
		/** Only to be used with the READ method! */
		public ContainerSlot(Implementation impl){ this.impl = impl; }

		public NBTTagCompound toNBT(){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("id", id);
			if(true){//syncpacket
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
				list.appendTag(data[i].writeToNBT(com));
			}
			compound.setTag("data", list);
			return compound;
		}

		public ContainerSlot fromNBT(NBTTagCompound compound){
			//if(!compound.getString("id").equals(id) && !syncpacket) return null;
			if(true){//syncpacket
				id = compound.getString("id");
				relpos[0] = compound.getFloat("relpos_x");
				relpos[1] = compound.getFloat("relpos_y");
				relpos[2] = compound.getFloat("relpos_z");
				Print.debug(compound.getString("size"));
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
			curr = ContainerType.valueOf(compound.getString("current"));
			NBTTagList list = (NBTTagList)compound.getTag("data");
			data = new ContainerData[compound.getInteger("segments")];
			for(int i = 0; i < data.length; i++){
				NBTTagCompound com = null;
				for(NBTBase base : list){
					if(((NBTTagCompound)base).getString("id").equals(id + div + i)){
						com = (NBTTagCompound)base; break;
					}
				} if(com == null) continue;
				data[i] = Resources.getContainerData(com);
			}
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
			} return true;
		}

		@Override
		public boolean equals(Object other){
			if(other instanceof String) return ((String)other).equals(this.id.split(div)[0]);
			if(other instanceof ContainerSlot == false) return false;
			return ((ContainerSlot)other).id.split(div)[0].equals(this.id.split(div)[0]);
		}

		public ActionResult<ContainerData> setContainerData(ICommandSender sender, String id, ContainerData condata){
			ContainerData oldata = null;
			if(condata.getContainer().getType() != size){
				int in = this.getsubid(id);
				if(in < 0){
					if(sender != null) Print.chat(sender, "Slot Array ID bellow zero.");
					return new ActionResult<ContainerData>(EnumActionResult.FAIL, condata);
				}
				if(condata.getContainer().getType() == curr){
					if(in >= data.length){
						if(sender != null) Print.chat(sender, "Slot Array ID out of bounds.");
						return new ActionResult<ContainerData>(EnumActionResult.FAIL, condata);
					}
					else{
						oldata = data[in]; data[in] = condata; this.impl.sync(false);
						if(sender != null) Print.chat(sender, "Container slot updated. [0]");
						return new ActionResult<ContainerData>(EnumActionResult.SUCCESS, oldata);
					}
				}
				else{
					if(!this.isEmpty()){
						if(sender != null) Print.chat(sender, "Cannot convert slots unless empty.");
						return new ActionResult<ContainerData>(EnumActionResult.FAIL, condata);
					}
					int newargsiz = this.getNewArrayLength(size, condata.getContainer().getType());
					if(newargsiz == 0){
						if(sender != null) Print.chat(sender, "Incompatible conversion mode.");
						return new ActionResult<ContainerData>(EnumActionResult.FAIL, condata);
					}
					if(newargsiz == 1 && data.length == 1){
						curr = condata.getContainer().getType();
						oldata = data[0]; data[0] = condata; this.impl.sync(false);
						if(sender != null) Print.chat(sender, "Container slot updated. [1]");
						return new ActionResult<ContainerData>(EnumActionResult.SUCCESS, oldata);
					}
					else{
						if(in >= newargsiz){
							if(sender != null) Print.chat(sender, "Slot Array ID out of NEW bounds.");
							return new ActionResult<ContainerData>(EnumActionResult.FAIL, condata);
						}
						else{
							for(ContainerData datt : data){ if(datt != null) oldata = datt; break; }
							//actually, I know it should be empty at this point.
							curr = condata.getContainer().getType();
							data = new ContainerData[newargsiz]; data[in] = condata; this.impl.sync(false);
							if(sender != null) Print.chat(sender, "Container slot updated. [2]");
							return new ActionResult<ContainerData>(EnumActionResult.SUCCESS, oldata);
						}
					}
				}
			}
			else{
				oldata = data[0]; data = new ContainerData[]{ condata }; this.impl.sync(false);
				if(sender != null) Print.chat(sender, "Container slot updated. [3]");
				return new ActionResult<ContainerData>(EnumActionResult.SUCCESS, oldata);
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
	        if(renderoffset == null) renderoffset = loadRenderOffset(null);
	        GL11.glPushMatrix();
	        GL11.glTranslatef(relpos[0], relpos[1], relpos[2]);
            GL11.glRotatef(180f, 0f, 0f, 1f);
	        GL11.glRotatef(this.rotangle, 0, 1, 0);
	        for(int i = 0; i < data.length; i++){
	        	if(data[i] != null){
		        	if(renderoffset[i] != 0f) GL11.glTranslatef(renderoffset[i], 0, 0);
	        		ModelBase.bindTexture(data[i].getTexture());
	        		data[i].getContainer().getModel().render(data[i], null, null, -23);
		        	if(renderoffset[i] != 0f) GL11.glTranslatef(-renderoffset[i], 0, 0);
	        	}
	        }
	        GL11.glPopMatrix();
		}

		private float[] loadRenderOffset(ContainerType type){
			if(type == null) type = curr;
			switch(size){
				case LARGE:{
					switch(type){
						case LARGE: break;
						case MEDIUM: return new float[]{ -3f, 3f };
						case SMALL: return new float[]{ -4.5f, -1.5f, 1.5f, 4.5f };
						case XSMALL: return new float[]{ -5f, -3f, -1f, 1f, 3f, 5f };
						case TINY: return new float[]{ -5.5f, -4.5f, -3.5f, -2.5f, -1.5f, -0.5f, 0.5f, 1.5f, 2.5f, 3.5f, 4.5f, 5.5f };
					} break;
				}
				case MEDIUM:{
					switch(type){
						case LARGE: case MEDIUM: break;
						case SMALL: return new float[]{ -1.5f, 1.5f };
						case XSMALL: return new float[]{ -2f, 0f, 2f };
						case TINY: return new float[]{ -2.5f, -1.5f, -0.5f, 0.5f, 1.5f, 2.5f };
					} break;
				}
				case SMALL:{
					switch(type){
						case LARGE: case MEDIUM: case SMALL: break; case XSMALL: break;
						case TINY: return new float[]{ -1f, 0f, 1f };
					} break;
				}
				case XSMALL:{
					switch(type){
						case LARGE: case MEDIUM: case SMALL: case XSMALL: break;
						case TINY: return new float[]{ -0.5f, 0.5f };
					} break;
				}
				case TINY:{ break; }
			} return new float[]{ 0 };
		}

		public boolean isValid(ContainerType type){
			if(size == type) return true;
			for(ContainerType supp : supported){
				if(supp == type) return true;
			} return false;
		}

		public void setType(ContainerType type){
			data = new ContainerData[this.getNewArrayLength(size, curr = type)];
			renderoffset = this.loadRenderOffset(null);
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
					impl.readFromNBT(EnumFacing.UP, packet.nbt); break;
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
