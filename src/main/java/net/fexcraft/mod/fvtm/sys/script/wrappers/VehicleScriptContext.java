package net.fexcraft.mod.fvtm.sys.script.wrappers;

import java.util.HashMap;

import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.script.ScrBlock;
import net.fexcraft.mod.fvtm.sys.script.elm.Elm;
import net.fexcraft.mod.fvtm.sys.script.elm.ListElm;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleScriptContext extends WrapperElm {

	private HashMap<String, AttrWrapper> attrs = new HashMap<>();
	private GenericVehicle entity;
	private EntityPlayer player;
	private VehicleData data;
	//
	private Seat seat;
	private Attribute toggl;
	private Object oldattrval;
	private NBTTagCompound packet;
	private Side side;
	//
	private ListElm attrslist = new ListElm();

	public VehicleScriptContext(VehicleData data){
		this.data = data;
		for(Attribute<?> attr : data.getAttributes().values()){
			AttrWrapper wrap = new AttrWrapper(attr);
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
		AttrWrapper wrap = new AttrWrapper(attr);
		attrs.put(id, wrap);
		attrslist.value().add(wrap);
		return attrs.get(id);
	}

	@Override
	public Elm get(ScrBlock block, String target){
		if(target.equals("attributes")){
			return attrslist;
		}
		return NULL;
	}

	@Override
	public boolean overrides(){
		return true;
	}

}
