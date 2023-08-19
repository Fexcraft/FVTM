package net.fexcraft.mod.fvtm.util.script;

import java.util.ArrayList;

import net.fexcraft.lib.script.ScrBlock;
import net.fexcraft.lib.script.ScrElm;
import net.fexcraft.lib.script.elm.ListElm;
import net.fexcraft.lib.script.elm.RefElm;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleScriptContext implements ScrElm {

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
	private AttrList attrslist = new AttrList(this);

	public VehicleScriptContext(VehicleData data, FSVehicleScript fscript){
		this.data = data;
		//TODO for(Attribute<?> attr : data.getAttributes().values()) attrslist.value().add(attr);
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
	public String scr_str(){
		return "{vehicle-context}";
	}

	@Override
	public ScrElm scr_get(ScrBlock block, String target){
		if(target.equals("attributes")){
			return attrslist;
		}
		if(target.equals("client")){
			return entity.world.isRemote ? TRUE : FALSE;
		}
		return NULL;
	}

	@Override
	public ScrElm scr_exec(ScrBlock block, String act, ArrayList<ScrElm> args){
		ScrElm val = NULL;
		switch(act){
			case "sync":{
				for(ScrElm elm : args){
					if(elm instanceof RefElm) sendScriptValueUpdatePacket(block, elm);
				}
				return TRUE;
			}
			default: break;
		}
		return val;
	}

	private void sendScriptValueUpdatePacket(ScrBlock block, ScrElm elm){
		if(elm == null) return;
		RefElm ref = (RefElm)elm;
		elm = ref.getElm(block.getScript());
		if(elm == NULL) return;
		if(elm instanceof Attribute){
			vehicle().sendAttributeUpdate((Attribute<?>)elm);
			return;
		}
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("ScriptElm", ref.scr_str());
		if(elm.scr_type().bool()){
			packet.setBoolean("value", elm.scr_bln());
		}
		else if(elm.scr_type().decimal()){
			packet.setFloat("value", elm.scr_flt());
		}
		else if(elm.scr_type().integer()){
			packet.setInteger("value", elm.scr_int());
		}
		else if(elm.scr_type().string()){
			packet.setString("value", elm.scr_str());
		}
		else packet.setString("value", elm.scr_str());
		wrapper.sendPacket(entity, packet, Side.CLIENT);
	}

	public void onElmUpdate(NBTTagCompound compound){
		ScrElm elm = wrapper.script().getElm(compound.getString("ScriptElm"), null);
		if(elm == null || elm == NULL) return;
		if(elm.scr_type().bool()) elm.scr_set(compound.getBoolean("value"));
		else if(elm.scr_type().decimal()) elm.scr_set(compound.getFloat("value"));
		else if(elm.scr_type().integer()) elm.scr_set(compound.getInteger("value"));
		else if(elm.scr_type().string()) elm.scr_set(compound.getString("value"));
	}

	@Override
	public boolean overrides(){
		return true;
	}

	public GenericVehicle vehicle(){
		return entity;
	}
	
	public static class AttrList extends ListElm {

		private VehicleScriptContext context;

		public AttrList(VehicleScriptContext context){
			this.context = context;
		}

		public ScrElm exec(ScrBlock block, String act, ArrayList<ScrElm> args){
			ScrElm val = NULL;
			switch(act){
				case "sync":{
					for(ScrElm elm : this.value()){
						if(elm instanceof Attribute == false) continue;
						context.vehicle().sendAttributeUpdate((Attribute)elm);
					}
					return TRUE;
				}
				default: break;
			}
			return val;
		}
		
	}

}
