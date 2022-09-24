package net.fexcraft.mod.fvtm.sys.script.wrappers;

import java.util.ArrayList;
import java.util.HashMap;

import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.script.ScrBlock;
import net.fexcraft.mod.fvtm.sys.script.elm.Elm;
import net.fexcraft.mod.fvtm.sys.script.elm.ListElm;
import net.fexcraft.mod.fvtm.sys.script.elm.RefElm;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleScriptContext extends WrapperElm {

	private HashMap<String, AttrWrapper> attrs = new HashMap<>();
	private GenericVehicle entity;
	private EntityPlayer player;
	protected VehicleData data;
	//
	private Seat seat;
	private Attribute toggl;
	private Object oldattrval;
	private NBTTagCompound packet;
	private Side side;
	//
	private AttrList attrslist = new AttrList();

	public VehicleScriptContext(VehicleData data){
		this.data = data;
		for(Attribute<?> attr : data.getAttributes().values()){
			AttrWrapper wrap = new AttrWrapper(attr, this);
			attrs.put(attr.id(), wrap);
			attrslist.value().add(wrap);
		}
	}

	public VehicleScriptContext update(Entity entity){
		this.entity = (GenericVehicle)entity;
		seat = null;
		player = null;
		toggl = null;
		oldattrval = null;
		packet = null;
		return this;
	}

	public VehicleScriptContext update(Seat seat, EntityPlayer player){
		this.seat = seat;
		this.player = player;
		toggl = null;
		oldattrval = null;
		packet = null;
		return this;
	}

	public VehicleScriptContext update(Entity entity, Attribute<?> attr, Object oldvalue, EntityPlayer player){
		this.entity = (GenericVehicle)entity;
		this.player = player;
		this.toggl = attr;
		this.oldattrval = oldvalue;
		seat = null;
		packet = null;
		return this;
	}

	public VehicleScriptContext update(NBTTagCompound compound, Side side){
		packet = compound;
		this.side = side;
		return this;
	}

	@Override
	public String string_val(){
		return "{vehicle-context}";
	}

	public Elm getAttribute(String id){
		if(attrs.containsKey(id)) return attrs.get(id);
		Attribute<?> attr = data.getAttribute(id);
		if(attr == null) return NULL;
		AttrWrapper wrap = new AttrWrapper(attr, this);
		attrs.put(id, wrap);
		attrslist.value().add(wrap);
		return attrs.get(id);
	}

	@Override
	public Elm get(ScrBlock block, String target){
		if(target.equals("attributes")){
			return attrslist;
		}
		if(target.equals("client")){
			return entity.world.isRemote ? TRUE : FALSE;
		}
		return NULL;
	}

	@Override
	public Elm exec(ScrBlock block, String act, ArrayList<Elm> args){
		Elm val = NULL;
		switch(act){
			case "sync":{
				for(Elm elm : args){
					if(elm instanceof AttrWrapper) ((AttrWrapper)elm).sync();
					else if(elm instanceof RefElm) sendScriptValueUpdatePacket(block, elm);
				}
				return TRUE;
			}
			default: break;
		}
		return val;
	}

	private void sendScriptValueUpdatePacket(ScrBlock block, Elm elm){
		if(elm == null) return;
		elm = ((RefElm)elm).getScriptElm(block);
		if(elm == NULL) return;
		//TODO
	}

	@Override
	public boolean overrides(){
		return true;
	}

	public GenericVehicle vehicle(){
		return entity;
	}
	
	public static class AttrList extends ListElm {

		public Elm exec(ScrBlock block, String act, ArrayList<Elm> args){
			Elm val = NULL;
			switch(act){
				case "sync":{
					for(Elm elm : this.value()){
						if(elm instanceof AttrWrapper == false) continue;
						((AttrWrapper)elm).sync();
					}
					return TRUE;
				}
				default: break;
			}
			return val;
		}
		
	}

}
