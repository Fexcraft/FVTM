package net.fexcraft.mod.fvtm.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.addons.gep.models.containers.GenericContainerModel;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.model.container.ContainerModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericContainer implements Container {

    private ResourceLocation registryname;
    private ContainerType type;
    private Addon addon;
    private Fluid fluid;
    @SideOnly(Side.CLIENT)
    private ContainerModel<ContainerData> model;
    private List<ResourceLocation> textures;
    private String[] description;
    private String name;
    public String contenttype;
    private int inventory;
    private InventoryType invtype;
    private ArrayList<ItemStack> whitelist = new ArrayList<ItemStack>();
    private ArrayList<ItemStack> blacklist = new ArrayList<ItemStack>();
    private RGB primary, secondary;

    @SuppressWarnings("unchecked")
    public GenericContainer(JsonObject obj){
        this.registryname = DataUtil.getRegistryName(obj, "CONTAINER");
        this.addon = DataUtil.getAddon(registryname, obj, "CONTAINER");
        this.type = ContainerType.valueOf(obj.has("Type") ? obj.get("Type").getAsString().toUpperCase() : obj.has("ContainerType") ? obj.get("ContainerType").getAsString().toUpperCase() : Container.ContainerType.MEDIUM.name());
        if(Static.side().isClient()){
            this.model = Resources.getModel(JsonUtil.getIfExists(obj, "ModelFile", "null"), ContainerModel.class, GenericContainerModel.get());
        }
        this.name = JsonUtil.getIfExists(obj, "FullName", this.getRegistryName().toString());
        this.textures = DataUtil.getTextures(obj, registryname, "CONTAINER");;
        this.description = DataUtil.getDescription(obj);
        this.primary = DataUtil.getRGB(obj, "PrimaryColor");
        this.secondary = DataUtil.getRGB(obj, "SecondaryColor");
        this.inventory = JsonUtil.getIfExists(obj, "InventorySize", 4).intValue();
        this.invtype = InventoryType.fromString(JsonUtil.getIfExists(obj, "InventoryType", "item"));
        if(obj.has("FluidType")){
            fluid = FluidRegistry.getFluid(obj.get("FluidType").getAsString());
        }
        //
        if(obj.has("InventoryWhitelist")){
            obj.get("InventoryWhitelist").getAsJsonArray().forEach((elm) -> {
                JsonObject jsn = elm.getAsJsonObject();
                try{
                    whitelist.add(new ItemStack(Item.getByNameOrId(JsonUtil.getIfExists(jsn, "id", "minecraft:stone")), 1, JsonUtil.getIfExists(jsn, "meta", 0).intValue()));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            });
        }
        if(obj.has("InventoryBlacklist")){
            obj.get("InventoryBlacklist").getAsJsonArray().forEach((elm) -> {
                JsonObject jsn = elm.getAsJsonObject();
                try{
                    blacklist.add(new ItemStack(Item.getByNameOrId(JsonUtil.getIfExists(jsn, "id", "minecraft:stone")), 1, JsonUtil.getIfExists(jsn, "meta", 0).intValue()));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            });
        }
        if(obj.has("InventoryContentType")){
            contenttype = obj.get("InventoryContentType").getAsString();
        }
        //
    }

    @Override
    public Container setRegistryName(ResourceLocation name){
        this.registryname = name;
        return this;
    }

    @Override
    public ResourceLocation getRegistryName(){
        return this.registryname;
    }

    @Override
    public ContainerType getType(){
        return type;
    }

    @Override
    public ContainerModel<ContainerData> getModel(){
        return model;
    }

    @Override
    public Class<? extends ContainerData> getDataClass(){
        return GenericContainerData.class;
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
    public int getInventorySize(){
        return inventory;
    }

    @Override
    public InventoryType getInventoryType(){
        return invtype;
    }

    @Override
    public boolean isItemValid(ItemStack stack){
        //Print.debug("CHECKING");
        //Print.debug(stack.toString());
        if(contenttype != null){
            switch(contenttype){
                case "food": {
                    return stack.getItem() instanceof ItemFood;
                }
                case "wood":
                case "planks": {
                    if(stack.getItem() instanceof ItemBlock){
                        @SuppressWarnings("deprecation")
                        IBlockState block = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
                        return block.getMaterial() == Material.WOOD;
                    }
                    return false;
                }
                case "iron":
                case "anvil": {
                    if(stack.getItem() instanceof ItemBlock){
                        @SuppressWarnings("deprecation")
                        IBlockState block = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
                        return block.getMaterial() == Material.ANVIL || block.getMaterial() == Material.IRON;
                    }
                    return false;
                }
                case "plants": {
                    if(stack.getItem() instanceof ItemBlock){
                        @SuppressWarnings("deprecation")
                        IBlockState block = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
                        return block.getMaterial() == Material.CACTUS || block.getMaterial() == Material.CORAL || block.getMaterial() == Material.GRASS || block.getMaterial() == Material.LEAVES || block.getMaterial() == Material.PLANTS || block.getMaterial() == Material.SPONGE || block.getMaterial() == Material.VINE;
                    }
                    return false;
                }
                case "tools":
                case "swords":
                case "weapons":
                case "armor": {
                    return stack.getItem() instanceof ItemTool || stack.getItem() instanceof ItemSword || stack.getItem() instanceof ItemBow || stack.getItem() instanceof ItemArrow || stack.getItem() instanceof ItemArmor;
                }
                case "rocks":
                case "sand": {
                    if(stack.getItem() instanceof ItemBlock){
                        @SuppressWarnings("deprecation")
                        IBlockState block = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
                        return block.getMaterial() == Material.GROUND || block.getMaterial() == Material.ROCK || block.getMaterial() == Material.SAND || block.getMaterial() == Material.TNT;
                    }
                    return false;
                }
                default: {
                    return false;
                }
            }
        }
        for(ItemStack itemstack : blacklist){
            if(stack.getItem().getRegistryName().equals(itemstack.getItem().getRegistryName())){
                if(ItemStack.areItemStacksEqual(itemstack, stack)){
                    return false;
                }
            }
        }
        //
        if(!whitelist.isEmpty()){
            boolean found = false;
            for(ItemStack itemstack : whitelist){
                if(stack.getItem().getRegistryName().equals(itemstack.getItem().getRegistryName())){
                    if(ItemStack.areItemStacksEqual(itemstack, stack) /*itemstack.getMetadata() == 0 || stack.getItemDamage() == itemstack.getItemDamage()*/){
                        found = true;
                        break;
                    }
                }
            }
            Print.debug(found);
            return found;
        }
        return true;
    }

    @Override
    public Addon getAddon(){
        return addon;
    }

    @Override
    public ItemStack getItemStack(ContainerData data){
        ItemStack stack = new ItemStack(GenericContainerItem.INSTANCE);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString(ContainerItem.NBTKEY, this.getRegistryName().toString());
        if(data != null){
            data.writeToNBT(nbt);
        }
        stack.setTagCompound(nbt);
        return stack;
    }

    @Override
    public Fluid getFluidType(){
        return fluid;
    }

    @Override
    public RGB getDefPrimaryColor(){
        return primary;
    }

    @Override
    public RGB getDefSecondaryolor(){
        return secondary;
    }

}
