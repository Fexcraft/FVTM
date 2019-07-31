package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.registry.CreativeTab;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.entity.RoadSignEntity;
import net.fexcraft.mod.fvtm.item.RoadSignItem;
import net.fexcraft.mod.fvtm.model.RoadSignModel;
import net.fexcraft.mod.fvtm.model.block.RS_Round;
import net.fexcraft.mod.fvtm.model.block.RS_TriangleDown;
import net.fexcraft.mod.fvtm.model.block.RS_TriangleUp;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadSign extends TypeCore<RoadSign> {
	
	protected String modeldata;
	protected Model<RoadSignEntity, RoadSign> model;
	protected ResourceLocation texture;
	
	public RoadSign(){}

	@Override
	public RoadSign setRegistryName(ResourceLocation name){
		this.registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Class<RoadSign> getRegistryType(){
		return RoadSign.class;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	@Override
	public RoadSign parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj); if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj); if(pack == null) return null;
		//
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.modeldata = JsonUtil.getIfExists(obj, "Model", "circle;layer:0");
		this.texture = DataUtil.getTextures(obj).get(0); return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.ROADSIGN;
	}
	
	@Override
	public Item getItem(){
		return RoadSignItem.INSTANCE;
	}

	public ResourceLocation getTexture(){
		return texture;
	}

	public Model<RoadSignEntity, RoadSign> getModel(){
		return model;
	}
	
	@Override
	public void loadModel(){
		String[] splits = modeldata.split(";");
		switch(splits[0]){
			case "circle": case "round": {
				model = new RS_Round(splits); return;
			}
			case "triangle_down": case "tri_down": {
				model = new RS_TriangleDown(splits); return;
			}
			case "triangle_up": case "tri_up": {
				model = new RS_TriangleUp(splits); return;
			}
			default: break;
		}
		this.model = Resources.getModel(modeldata, RoadSignModel.class);
	}

	public ItemStack newItemStack(){
		ItemStack stack = new ItemStack(getItem(), 1);
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("fvtm:roadsign", this.getRegistryName().toString());
		stack.setTagCompound(compound);
		return stack;
	}
	
	@SideOnly(Side.CLIENT)
	public static class RoadSignsTab extends CreativeTab {
		
		public static RoadSignsTab INSTANCE = new RoadSignsTab();
		private NonNullList<ItemStack> list;
	    private int icon, sec;

		public RoadSignsTab(){
			super("fvtm:road_signs");
		}

	    @Override
	    public ItemStack getTabIconItem(){
	        return null;
	    }

	    @SideOnly(Side.CLIENT)
	    public String getTranslatedTabLabel(){
	        return "FVTM - Road Signs";
	    }

	    @Override
	    public ItemStack getIconItemStack(){
	        if(list == null){ list = NonNullList.create(); this.displayAllRelevantItems(list); }
	        if(sec != Time.getSecond()){
	        	sec = Time.getSecond(); this.icon++; if(icon >= list.size()){ icon = 0; }
	        } return icon >= list.size() ? ItemStack.EMPTY : list.get(icon);
	    }

	}

}
