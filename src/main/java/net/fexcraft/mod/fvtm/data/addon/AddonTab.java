package net.fexcraft.mod.fvtm.data.addon;

import java.util.Collection;
import java.util.TreeMap;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.registry.CreativeTab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AddonTab extends CreativeTab {
	
    private static TreeMap<ResourceLocation, AddonTab> TABS = new TreeMap<>();
    private NonNullList<ItemStack> list;
    private int icon, sec;
	private Addon addon;

	public AddonTab(Addon addon){
		super(addon.getName()); this.addon = addon; TABS.put(addon.getRegistryName(), this);
	}

    @Override
    public ItemStack createIcon(){
        return null;
    }

    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel(){
        return addon.getName();
    }

    public Addon getAddon(){
        return addon;
    }

    @Override
    public ItemStack getIcon(){
        if(list == null){ list = NonNullList.create(); this.displayAllRelevantItems(list); }
        if(sec != Time.getSecond()){
        	sec = Time.getSecond(); this.icon++; if(icon >= list.size()){ icon = 0; }
        } return icon >= list.size() ? ItemStack.EMPTY : list.get(icon);
    }
    
    public static final AddonTab getTab(ResourceLocation addonid){
    	return TABS.get(addonid);
    }

	public static Collection<AddonTab> getTabs(){
		return TABS.values();
	}

}
