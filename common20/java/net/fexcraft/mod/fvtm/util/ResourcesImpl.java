package net.fexcraft.mod.fvtm.util;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fcl.util.ExternalTextures;
import net.fexcraft.mod.fvtm.*;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.VehicleLiftBlock;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.entity.RoadMarker;
import net.fexcraft.mod.fvtm.item.*;
import net.fexcraft.mod.fvtm.model.Transforms;
import net.fexcraft.mod.fvtm.model.program.ConditionalPrograms;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms20;
import net.fexcraft.mod.fvtm.render.Transforms120;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.impl.IWI;
import net.fexcraft.mod.uni.impl.IWR;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Supplier;

import static net.fexcraft.mod.fvtm.FvtmRegistry.BLOCKS;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ResourcesImpl extends FvtmResources {

	@Override
	public void searchASMPacks(){}

	@Override
	public boolean searchPacksInResourcePacks(){
		return true;
	}

	@Override
	public void loadPackTextures(){}

	@Override
	public void checkForCustomModel(AddonLocation loc, ContentType contype, Content<?> content){}

	@Override
	public void createContentBlocks(){
		BLOCKS.forEach(block -> {
			FVTM4.BLOCK_REGISTRY.get(block.getID().space()).register(block.getID().id(), () -> block.genBlock());
		});
	}

	@Override
	public void createContentItems(){
		FvtmRegistry.MATERIALS.forEach(mat -> mat.setItemWrapper(wrapwrapper(mat.getID(), () -> new MaterialItem(mat))));
		FvtmRegistry.CONSUMABLES.forEach(con -> con.setItemWrapper(wrapwrapper(con.getID(), () -> new ConsumableItem(con))));
		FvtmRegistry.PARTS.forEach(part -> part.setItemWrapper(wrapwrapper(part.getID(), () -> new PartItem(part))));
		FvtmRegistry.VEHICLES.forEach(veh -> veh.setItemWrapper(wrapwrapper(veh.getID(), () -> new VehicleItem(veh))));
		FvtmRegistry.BLOCKS.forEach(blk -> blk.setItemWrapper(wrapwrapper(blk.getID(), () -> {
			FvtmRegistry.CONTENT_BLOCKS.put(blk.getID(), blk.getBlock());
			return new net.fexcraft.mod.fvtm.item.BlockItem(blk);
		})));
		FvtmRegistry.DECORATIONS.forEach(veh -> veh.setItemWrapper(wrapwrapper(veh.getID(), () -> new DecorationItem(veh))));
		FvtmRegistry.RAILGAUGES.forEach(rg -> rg.setItemWrapper(wrapwrapper(rg.getID(), () -> new RailGaugeItem(rg))));
	}

	@Override
	public void registerRecipes(){
		//
	}

	private ItemWrapper wrapwrapper(IDL id, Supplier<Item> item){
		if(FvtmRegistry.CONTENT_ITEMS.containsKey(id)){
			return FvtmRegistry.CONTENT_ITEMS.get(id);
		}
		IWR iwr = new IWR(FVTM4.ITEM_REGISTRY.get(id.space()).register(id.id(), item));
		FvtmRegistry.CONTENT_ITEMS.put(id, iwr);
		FvtmRegistry.ITEMS.put(id.colon(), iwr);
		return iwr;
	}

	@Override
	public ItemWrapper getItemWrapper(String id){
		Item item = BuiltInRegistries.ITEM.get(new ResourceLocation(id));
		return item == null ? null : new IWI(item);
	}

	@Override
	public StackWrapper newStack0(ItemWrapper item){
		return StackWrapper.wrap(item);
	}

	@Override
	public StackWrapper newStack0(TagCW com){
		return StackWrapper.wrap(ItemStack.of(com.local()));
	}

	@Override
	public StackWrapper newStack0(Object item){
		return StackWrapper.wrap(new IWI((Item)item));
	}

	@Override
	public StackWrapper wrapStack0(Object stack){
		return StackWrapper.wrap(stack);
	}

	@Override
	public JsonMap getJsonC(String loc){
		return null;
	}

	@Override
	public void initModelPrograms(){
		Transforms.GET_TRANSFORM = (args -> {
			switch(args[0]){
				case "translation":
				case "translate":
				case "trans":
				case "tra":
				case "tr":
					return (Transforms.Transformer)new Transforms120.TF_Translate(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
				case "rotation":
				case "rotate":
				case "rot":
					return (Transforms.Transformer)new Transforms120.TF_Rotate(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]), Float.parseFloat(args[4]));
				case "scale":
					if(args.length < 3){
						float scale = Float.parseFloat(args[1]);
						return (Transforms.Transformer)new Transforms120.TF_Scale(scale, scale, scale);
					}
					return (Transforms.Transformer)new Transforms120.TF_Scale(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
				case "gl_rescale_normal":
				case "rescale_normal":
					return (Transforms.Transformer)Transforms120.TF_RESCALE_NORMAL;
			}
			return null;
		});
		DefaultPrograms20.init();
		ConditionalPrograms.init();
	}

	@Override
	public void initModels(){
		ArrayList<String> tt = new ArrayList<>();
		for(ItemDisplayContext value : ItemDisplayContext.values()) tt.add(value.name());
		TransformMap.TYPES = tt.toArray(new String[0]);
		super.initModels();
	}

	@Override
	public InputStream getAssetInputStream(IDL loc, boolean log){
		try{
			return Minecraft.getInstance().getResourceManager().getResource((ResourceLocation)loc).get().open();
		}
		catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isModPresent(String s){
		return false;
	}

	@Override
	public IDL getExternalTexture(String custom){
		return ExternalTextures.get("fvtm", custom);
	}

	@Override
	public void registerFvtmBlocks(){
		for(int idx = 0; idx < FvtmGetters.ASPHALT.length; idx++){
			int index = idx;
			FvtmGetters.ASPHALT[idx] = FVTM4.BLOCK_REGISTRY.get("fvtm").register("asphalt_" + idx, () -> new Asphalt(index));
		}
		FvtmGetters.LIFT_BLOCK = FVTM4.BLOCK_REGISTRY.get("fvtm").register("vehicle_lift", () -> new VehicleLiftBlock());
	}

	@Override
	public void registerFvtmItems(){
		FvtmGetters.ROAD_TOOL_ITEM = FVTM4.ITEM_REGISTRY.get("fvtm").register("road_tool", () -> new RoadToolItem());
		FvtmGetters.TOOLBOX0 = FVTM4.ITEM_REGISTRY.get("fvtm").register("toolbox_0", () -> new ToolboxItem(0));
		FvtmGetters.TOOLBOX1 = FVTM4.ITEM_REGISTRY.get("fvtm").register("toolbox_1", () -> new ToolboxItem(1));
		FvtmGetters.TOOLBOX2 = FVTM4.ITEM_REGISTRY.get("fvtm").register("toolbox_2", () -> new ToolboxItem(2));
		FvtmGetters.JUNCTION_TOOl = FVTM4.ITEM_REGISTRY.get("fvtm").register("junction_tool", () -> new JunctionTool());
		for(int idx = 0; idx < FvtmGetters.ASPHALT.length; idx++){
			int index = idx;
			FvtmGetters.ASPHALT_ITEM[idx] = FVTM4.ITEM_REGISTRY.get("fvtm").register("asphalt_" + idx, () -> new BlockItem(FvtmGetters.ASPHALT[index].get(), new Item.Properties()));
		}
		FvtmGetters.LIFT_BLOCK_ITEM = FVTM4.ITEM_REGISTRY.get("fvtm").register("vehicle_lift", () -> new BlockItem(FvtmGetters.LIFT_BLOCK.get(), new Item.Properties()));
	}

	@Override
	public double getMouseSensitivity(){
		return 0;
	}

	@Override
	public Object getBlockMaterial(String key, boolean allownull){
		return null;
	}

	@Override
	public void spawnRoadMarker(WorldW world, QV3D vector, UUID nid){
		RoadMarker marker = FvtmGetters.getNewRoadMarker(world.local());
		marker.queueid = nid;
		marker.position = vector;
		marker.setPos(vector.vec.x, vector.vec.y + 1, vector.vec.z);
		((Level)world.direct()).addFreshEntity(marker);
	}

	@Override
	public void spawnRailMarker(WorldW world, QV3D vector, UUID nid){
		RailMarker marker = FvtmGetters.getNewRailMarker(world.local());
		marker.queueid = nid;
		marker.position = vector;
		marker.setPos(vector.vec.x, vector.vec.y + 1, vector.vec.z);
		((Level)world.direct()).addFreshEntity(marker);
	}

}