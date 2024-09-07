package net.fexcraft.mod.fvtm.data.impl;

import java.util.Collection;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.registry.CreativeTab;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.fvtm.util.CTab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AddonTab extends CreativeTab implements CTab {

	private NonNullList<ItemStack> list;
	private String defitem;
	private int icon, sec;
	private Addon addon;

	@Deprecated
	public AddonTab(Addon addon, String string, String icon){
		super(addon.getID().id() + (string.equals(DEFAULT) ? "" : "." + string));
		this.defitem = icon;
		this.addon = addon;
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
		if(list == null){
			list = NonNullList.create();
			this.displayAllRelevantItems(list);
		}
		if(sec != Time.getSecond()){
			sec = Time.getSecond();
			this.icon++;
			if(icon >= list.size()){
				icon = 0;
			}
		}
		return icon >= list.size() ? ItemStack.EMPTY : list.get(icon);
	}

	public static final AddonTab getTab(IDL addonid){
		return (AddonTab)TABS.get(addonid);
	}

	public static Collection<CTab> getTabs(){
		return TABS.values();
	}

}
