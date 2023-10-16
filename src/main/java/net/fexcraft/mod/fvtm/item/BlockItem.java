package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.registry.ItemBlock16;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.generated.PlainBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockItem extends ItemBlock16 implements DataCoreItem<BlockData> {//}, ItemTex<Block> {
	
	@SideOnly(Side.CLIENT)
	private CreativeTabs ctab;
	private Block type;

    public BlockItem(net.minecraft.block.Block block) throws Exception {
		super(block); type = ((PlainBase)block).type;
		this.setHasSubtypes(true);
		this.setMaxStackSize(type.getMaxStackSize());
		this.setRegistryName(block.getRegistryName());
		this.setTranslationKey(block.getTranslationKey());
		if(Static.side().isServer()) return;
		//TODO ctab = Resources.getCreativeTab(type);
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
    	if(type.isRailBlock()) tooltip.add(Formatter.format("&6&oRailway Block"));
    	//else if(type.isFunctional()) tooltip.add(Formatter.format("&b&oFunctional Block"));
    	//else if(type.isDecoration()) tooltip.add(Formatter.format("&e&oDecoration Block"));
    	VehicleAndPartDataCache cache = stack.getCapability(Capabilities.VAPDATA, null);
    	if(!cache.overridesLang(false)) tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s)));
        }
        if(type.getBlockType().isGenericRoad()){
        	tooltip.add(Formatter.format("&9Height: &7" + (stack.getMetadata() == 0 ? 16 : stack.getMetadata())));
        }
        else if(type.getBlockType().getMetaVariants() > 0){
        	tooltip.add(Formatter.format("&9Variant: &7" + stack.getMetadata()));
        }
        BlockData data = cache.getBlockData();
        if(data == null) return;
        if(!data.getType().hasPlainModel()) tooltip.add(Formatter.format("&9Texture: &7" + getTexTitle(data)));
        if(!data.getFunctions().isEmpty()){
            for(BlockFunction func : data.getFunctions()){
                func.addInformation(stack, world, data, tooltip, flag.isAdvanced());
            }
            tooltip.add(Formatter.format("&9- - - - - - &7-"));
        }
        if(type.getModel() == null) return;
        if(type.getModel().getCreators().size() > 0){
            tooltip.add(Formatter.format("&9Model by:"));
            for(String str : type.getModel().getCreators()){
            	tooltip.add(Formatter.format("&7- " + str));
            }
        }
    }

	private String getTexTitle(BlockData data){
		if(data.getSelectedTexture() >= 0){
			return "[" + data.getSelectedTexture() + "] " + data.getType().getDefaultTextures().get(data.getSelectedTexture()).name();
		} else return data.isTextureExternal() ? "external" : "internal";
	}

	@Override
	public BlockData getData(ItemStack stack){
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound()); return getData(stack.getTagCompound());
	}

	@Override
	public BlockData getData(NBTTagCompound compound){
		return new BlockData(type).read(compound);
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(type.shouldHideItem()) return;
    	if(tab == CreativeTabs.SEARCH || tab == ctab){
    		if(type.getBlockType().isGenericRoad()){
	    		items.add(new ItemStack(this, 1, 0)); items.add(new ItemStack(this, 1, 12));
	    		items.add(new ItemStack(this, 1, 8)); items.add(new ItemStack(this, 1, 4));
	    		items.add(new ItemStack(this, 1, 2)); items.add(new ItemStack(this, 1, 1));
    		}
    		else if(type.getBlockType().getMetaVariants() > 0){
    			for(int i = 0; i < type.getBlockType().getMetaVariants(); i++){
    	    		items.add(new ItemStack(this, 1, i));
    			}
    		}
    		else{
        		items.add(type.newItemStack());
    		}
    	}
    }
    
    @Override
    public CreativeTabs getCreativeTab(){
        return ctab;
    }
    
    @Override
    public int getItemBurnTime(ItemStack stack){
    	return type.getItemBurnTime() * stack.getCount();
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(type.getBlockType().isMultiBlock()) return EnumActionResult.PASS;
        return super.onItemUse(player, world, pos, hand, side, hitX, hitY, hitZ);
    }

	//@Override
	public Block getDataType(){
		return type;
	}

}
