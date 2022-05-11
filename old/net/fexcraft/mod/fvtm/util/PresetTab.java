package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.registry.CreativeTab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PresetTab extends CreativeTab {

	public static final PresetTab INSTANCE = new PresetTab();
	private NonNullList<ItemStack> list, collection = NonNullList.create();
	public NonNullList<ItemStack> ITEMS;
	private int icon, sec;

	public PresetTab(){
		super("fvtm:presets");
	}

	@Override
	public ItemStack createIcon(){
		return null;
	}

	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel(){
		return "FVTM - (Vehicle) Presets";
	}

	@Override
	public ItemStack getIcon(){
		if(list == null){
			list = NonNullList.create();
			displayAllRelevantItems(list);
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

	public void add(ItemStack stack){
		collection.add(stack);
		if(ITEMS != null){
			ITEMS.add(stack);
			list = ITEMS;
		}
	}

	public NonNullList<ItemStack> get(){
		return collection;
	}

}