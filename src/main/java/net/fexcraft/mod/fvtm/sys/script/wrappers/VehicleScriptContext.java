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
import net.fexcraft.mod.fvtm.util.script.FSVehicleScript;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleScriptContext extends WrapperElm {

	private HashMap<String, AttrWrapper> attrs = new HashMap<>();
	private FSVehicleScript wrapper;
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

	public VehicleScriptContext(VehicleData data, FSVehicleScript fscript){
		this.data = data;
		for(Attribute<?> attr : data.getAttributes().values()){
			AttrWrapper wrap = new AttrWrapper(attr, this);
			attrs.put(attr.id(), wrap);
			attrslist.value().add(wrap);
		}
		wrapper = fscript;
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
					if(elm instanceof RefElm) sendScriptValueUpdatePacket(block, elm);
				}
				return TRUE;
			}
			default: break;
		}
		return val;
	}

	private void sendScriptValueUpdatePacket(ScrBlock block, Elm elm){
		if(elm == null) return;
		RefElm ref = (RefElm)elm;
		elm = ref.getElm(block.getScript());
		if(elm == NULL) return;
		if(elm instanceof AttrWrapper){
			((AttrWrapper)elm).sync();
			return;
		}
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("ScriptElm", ref.string_val());
		if(elm.type().bool()){
			packet.setBoolean("value", elm.bool_val());
		}
		else if(elm.type().decimal()){
			packet.setFloat("value", elm.float_val());
		}
		else if(elm.type().integer()){
			packet.setInteger("value", elm.integer_val());
		}
		else if(elm.type().string()){
			packet.setString("value", elm.string_val());
		}
		else packet.setString("value", elm.string_val());
		wrapper.sendPacket(entity, packet, Side.CLIENT);
	}

	public void onElmUpdate(NBTTagCompound compound){
		Elm elm = wrapper.script().getElm(compound.getString("ScriptElm"), null);
		if(elm == null || elm == NULL) return;
		if(elm.type().bool()) elm.set(compound.getBoolean("value"));
		else if(elm.type().decimal()) elm.set(compound.getFloat("value"));
		else if(elm.type().integer()) elm.set(compound.getInteger("value"));
		else if(elm.type().string()) elm.set(compound.getString("value"));
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
