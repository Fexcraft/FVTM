package net.fexcraft.mod.fvtm.impl.block;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.model.block.BlockModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GenericBlock implements Block {

    private ResourceLocation registryname;
    private Addon addon;
    private Model<BlockData, BlockTileEntity> model;
    private List<ResourceLocation> textures;
    private String[] description;
    private String name;
    private RGB primary, secondary;
    private boolean functional;
    private Class<? extends BlockScript> clazz;
    private Map<String, Integer> tanks, inventories;
    private Map<BlockPos, BlockIOT> subblocks = new TreeMap<>();

    @SuppressWarnings("unchecked")
	public GenericBlock(JsonObject obj){
        this.registryname = DataUtil.getRegistryName(obj, "BLOCK");
        this.addon = DataUtil.getAddon(registryname, obj, "BLOCK");
        if(Static.side().isClient()){
            this.model = Resources.getModel(JsonUtil.getIfExists(obj, "ModelFile", "null"), BlockData.class, BlockTileEntity.class, BlockModel.class);
        }
        this.name = JsonUtil.getIfExists(obj, "FullName", this.getRegistryName().toString());
        this.textures = DataUtil.getTextures(obj, registryname, "BLOCK");;
        this.description = DataUtil.getDescription(obj);
        this.primary = DataUtil.getRGB(obj, "PrimaryColor");
        this.secondary = DataUtil.getRGB(obj, "SecondaryColor");
        this.functional = JsonUtil.getIfExists(obj, "Functional", false);
        if(obj.has("Script")){
        	try{
        		clazz = (Class<? extends BlockScript>)Class.forName(obj.get("Script").getAsString().replace(".class", ""));
        	}
        	catch(Exception e){
				e.printStackTrace();
			}
        }
		if(obj.has("Positions")){
			JsonArray array = obj.get("Positions").getAsJsonArray();
			if(array.size() == 0){
				subblocks.put(new BlockPos(0, 0, 0), GenericBlockIOT.EMPTY);
			}
			else{
				array.forEach(elm -> {
					try{
						JsonObject jsn = elm.getAsJsonObject();
						BlockPos pos = new BlockPos(jsn.get("x").getAsInt(), jsn.get("y").getAsInt(), jsn.get("z").getAsInt());
						subblocks.put(pos, GenericBlockIOT.fromJson(jsn));
					}
					catch(Exception e){
						e.printStackTrace();
						Static.stop();
					}
				});
			}
		}
		else{
			subblocks.put(new BlockPos(0, 0, 0), GenericBlockIOT.EMPTY);
		}
    	if(obj.has("Tanks") || obj.has("FluidTanks")){
    		tanks = new TreeMap<String, Integer>();
    		obj.get(obj.has("Tanks") ? "Tanks" : "FluidTanks").getAsJsonArray().forEach(elm -> {
    			tanks.put(elm.getAsJsonObject().get("name").getAsString(), elm.getAsJsonObject().get("capacity").getAsInt());
    		});
    	}
    	if(obj.has("Containers") || obj.has("Inventories")){
    		inventories = new TreeMap<String, Integer>();
    		obj.get(obj.has("Containers") ? "Containers" : "Inventories").getAsJsonArray().forEach(elm -> {
    			inventories.put(elm.getAsJsonObject().get("name").getAsString(), elm.getAsJsonObject().get("capacity").getAsInt());
    		});
    	}
        if(obj.has("Recipes")){
            try{
            	ItemStack stack = this.getItemStack(this.getDataClass().getConstructor(Block.class).newInstance(this));
            	CrafterBlockScriptBase.registerRecipes(obj.get("Recipes").getAsJsonArray(), stack, "FVTM - Blocks");
            }
            catch(Exception e){
                e.printStackTrace();
                Static.stop();
            }
        }
    }

    @Override
    public Block setRegistryName(ResourceLocation name){
        this.registryname = name;
        return this;
    }

    @Override
    public ResourceLocation getRegistryName(){
        return this.registryname;
    }

    @Override
    public Model<BlockData, BlockTileEntity> getModel(){
        return model;
    }

    @Override
    public Class<? extends BlockData> getDataClass(){
        return GenericBlockData.class;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String[] getDescription(){
        return description;
    }

    @Override
    public List<ResourceLocation> getTextures(){
        return textures;
    }

    @Override
    public Addon getAddon(){
        return addon;
    }

    @Override
    public ItemStack getItemStack(BlockData data){
        ItemStack stack = new ItemStack(GenericBlockItem.INSTANCE);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString(BlockItem.NBTKEY, this.getRegistryName().toString());
        if(data != null){
            data.writeToNBT(nbt);
        }
        stack.setTagCompound(nbt);
        return stack;
    }

    @Override
    public RGB getDefPrimaryColor(){
        return primary;
    }

    @Override
    public RGB getDefSecondaryolor(){
        return secondary;
    }

	@Override
	public boolean isFunctional(){
		return functional;
	}

	@Override
	public Class<? extends BlockScript> getScriptClass(){
		return clazz;
	}

	@Override
	public Map<String, Integer> getFluidTanks(){
		return tanks == null ? Collections.emptyMap() : tanks;
	}

	@Override
	public Map<String, Integer> getInventories(){
		return inventories == null ? Collections.emptyMap() : inventories;
	}

	@Override
	public Map<BlockPos, BlockIOT> getSubBlocks(){
		return subblocks;
	}

}
