package net.fexcraft.mod.fvtm.model;

import net.fexcraft.mod.fvtm.data.Cloth;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.TextureableItem;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.event.EventData;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 * Reusable object for rendering.
 */
public class ModelRenderData extends EventData {

	public Object blockstate;
	public float partialticks;
	//
	public ContainerData container;
	public BlockData block;
	public Colorable color;
	public TextureUser texture;
	public PartData part;
	public String part_category;
	public DecorationData decoration;
	public SignData sign;
	public SignInstance sign_inst;
	public TextureableItem<Cloth> cloth_item;
	public ArrayList<String> cloth_groups;
	public boolean separaterender;
	//
	public RenderCache cache;


	public ModelRenderData set(VehicleInstance ent, float ticks){
		return set(ent.data, ent, ticks);
	}
	public ModelRenderData set(VehicleData data, VehicleInstance ent, float ticks){
		entity = ent == null ? null : ent.entity;
		vehent = ent;
		vehicle = data;
		color = data;
		texture = data;
		part = null;
		part_category = null;
		separaterender = false;
		partialticks = ticks;
		return this;
	}

	public ModelRenderData set(VehicleInstance ent, PartData data, String key, float ticks){
		return set(ent.data, ent, data, key, ticks);
	}

	public ModelRenderData set(VehicleData data, VehicleInstance ent, PartData partdata, String key, float ticks){
		entity = ent == null ? null : ent.entity;
		vehent = ent;
		vehicle = data;
		color = data;
		texture = partdata;
		part = partdata;
		part_category = key;
		separaterender = false;
		partialticks = ticks;
		return this;
	}


	public ModelRenderData set(ContainerData data, Object tileent){
		container = data;
		tile = tileent;
		color = data;
		texture = data;
		return this;
	}


	public ModelRenderData set(BlockData data, Object tileent, Object state){
		entity = null;
		block = data;
		tile = tileent;
		color = data;
		texture = data;
		blockstate = state;
		separaterender = false;
		return this;
	}


	public ModelRenderData set(DecorationData data, EntityW ent){
		decoration = data;
		entity = ent;
		color = data;
		return this;
	}


	public ModelRenderData set(SignData data, SignInstance inst){
		sign = data;
		sign_inst = inst;
		color = data;
		return this;
	}


	public ModelRenderData set(TextureableItem<Cloth> item, ArrayList<String> list, EntityW ent){
		cloth_item = item;
		cloth_groups = list;
		entity = ent;
		return this;
	}

	public ModelRenderData rc(RenderCache renca){
		cache = renca;
		return this;
	}

	public ModelRenderData rcs(RenderCache renca){
		cache = renca;
		separaterender = true;
		return this;
	}

	public ModelRenderData sep(){
		separaterender = true;
		return this;
	}

	public ModelRenderData clear(){
		entity = null;
		vehicle = null;
		color = null;
		texture = null;
		part = null;
		part_category = null;
		cache = null;
		separaterender = false;
		return this;
	}

}
