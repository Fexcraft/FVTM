package net.fexcraft.mod.fvtm.model;

import net.fexcraft.mod.fvtm.data.Cloth;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.TextureableItem;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.deco.DecoInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.StateWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ModelRenderData {

	public static ConcurrentHashMap<StateWrapper, StateRD> STATE_WRAPPERS = new ConcurrentHashMap<>();
	public RenderCache cache = new RenderCache(this);
	public boolean separaterender;
	public float partialticks;
	public int light;

	public ModelRenderData update(float ticks){
		separaterender = false;
		partialticks = ticks;
		light = 0;
		return this;
	}

	public ModelRenderData sep(){
		separaterender = true;
		return this;
	}

	public int light(){
		return light;
	}

	public ModelRenderData light(int i){
		light = i;
		return this;
	}

	public Colorable color(){
		return null;
	}

	public TextureUser texture(){
		return null;
	}

	public VehicleData vehicle(){
		return null;
	}

	public VehicleInstance vehent(){
		return null;
	}

	public PartData part(){
		return null;
	}

	public String part_category(){
		return null;
	}

	public BlockData block(){
		return null;
	}

	public FvtmBlockEntity block_entity(){
		return null;
	}

	public StateWrapper block_state(){
		return null;
	}

	public EntityW entity(){
		return null;
	}

	public ContainerData container(){
		return null;
	}

	public SignData sign(){
		return null;
	}

	public DecorationData decoration(){
		return null;
	}

	public Wire wire(){
		return null;
	}

	public List<String> cloth_groups(){
		return null;
	}

	public <T extends ModelRenderData> T as(){
		return (T)this;
	}

	public static ModelRenderData getStateRD(StateWrapper state){
		return STATE_WRAPPERS.computeIfAbsent(state, s -> new StateRD(s));
	}

	public static class VehicleRD extends ModelRenderData {

		public VehicleInstance vehent;
		public VehicleData vehicle;

		public VehicleRD(VehicleData data){
			vehicle = data;
		}

		public ModelRenderData update(VehicleInstance inst, float ticks){
			vehent = inst;
			return update(ticks);
		}

		@Override
		public Colorable color(){
			return vehicle;
		}

		@Override
		public TextureUser texture(){
			return vehicle;
		}

		@Override
		public VehicleData vehicle(){
			return vehicle;
		}

		@Override
		public VehicleInstance vehent(){
			return vehent;
		}

		@Override
		public EntityW entity(){
			return vehent == null ? null : vehent.entity;
		}
	}

	public static class PartRD extends ModelRenderData {

		public VehicleRD vehicle;
		public PartData part;
		public String category;

		public PartRD(PartData data){
			part = data;
		}

		public ModelRenderData update(VehicleRD veh, String key, float ticks){
			vehicle = veh;
			category = key;
			return update(ticks);
		}

		@Override
		public Colorable color(){
			return vehicle.vehicle;
		}

		@Override
		public TextureUser texture(){
			return part;
		}

		@Override
		public VehicleData vehicle(){
			return vehicle.vehicle;
		}

		@Override
		public VehicleInstance vehent(){
			return vehicle.vehent;
		}

		@Override
		public EntityW entity(){
			return vehicle == null || vehicle.vehent == null ? null : vehicle.vehent.entity;
		}

		@Override
		public PartData part(){
			return part;
		}

		@Override
		public String part_category(){
			return category;
		}
	}

	public static class BlockRD extends ModelRenderData {

		public StateWrapper blockstate;
		public FvtmBlockEntity entity;
		public BlockData block;

		public BlockRD(BlockData data){
			block = data;
		}

		public ModelRenderData update(FvtmBlockEntity tile, float ticks){
			entity = tile;
			return update(ticks);
		}

		public ModelRenderData update(StateWrapper wrapper){
			blockstate = wrapper;
			return this;
		}

		@Override
		public Colorable color(){
			return block;
		}

		@Override
		public TextureUser texture(){
			return block;
		}

		@Override
		public BlockData block(){
			return block;
		}

		@Override
		public FvtmBlockEntity block_entity(){
			return entity;
		}

		@Override
		public StateWrapper block_state(){
			return blockstate;
		}

	}

	public static class SignRD extends ModelRenderData {

		public SignInstance inst;
		public SignData sign;

		public SignRD(SignData data){
			sign = data;
		}

		public ModelRenderData update(SignInstance sign, float ticks){
			inst = sign;
			return update(ticks);
		}

		@Override
		public Colorable color(){
			return sign;
		}

		@Override
		public TextureUser texture(){
			return sign;
		}

		@Override
		public SignData sign(){
			return sign;
		}

	}

	public static class DecorationRD extends ModelRenderData {

		public DecoInstance inst;
		public DecorationData deco;

		public DecorationRD(DecorationData data){
			deco = data;
		}

		public ModelRenderData update(DecoInstance deco, float ticks){
			inst = deco;
			return update(ticks);
		}

		@Override
		public Colorable color(){
			return deco;
		}

		@Override
		public TextureUser texture(){
			return deco;
		}

		@Override
		public DecorationData decoration(){
			return deco;
		}

	}

	public static class ContainerRD extends ModelRenderData {

		public FvtmBlockEntity entity;
		public ContainerData container;

		public ContainerRD(ContainerData data){
			container = data;
		}

		public ModelRenderData update(FvtmBlockEntity tile, float ticks){
			entity = tile;
			return update(ticks);
		}

		@Override
		public Colorable color(){
			return container;
		}

		@Override
		public TextureUser texture(){
			return container;
		}

		@Override
		public ContainerData container(){
			return container;
		}

		@Override
		public FvtmBlockEntity block_entity(){
			return entity;
		}

	}

	public static class ClothRD extends ModelRenderData {

		public TextureableItem<Cloth> cloth_item;
		public ArrayList<String> cloth_groups;
		public EntityW entity;
		public Object item;

		public ClothRD(TextureableItem<Cloth> item){
			cloth_item = item;
		}

		public ModelRenderData update(ArrayList<String> groups, EntityW ent, float ticks){
			cloth_groups = groups;
			entity = ent;
			return update(ticks);
		}

		@Override
		public List<String> cloth_groups(){
			return cloth_groups;
		}

	}

	public static class StateRD extends ModelRenderData {

		private StateWrapper state;

		public StateRD(StateWrapper wrapper){
			state = wrapper;
		}

		@Override
		public StateWrapper block_state(){
			return state;
		}

	}

}
