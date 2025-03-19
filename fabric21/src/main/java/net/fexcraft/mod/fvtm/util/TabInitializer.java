package net.fexcraft.mod.fvtm.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static net.fexcraft.mod.fvtm.FvtmRegistry.FUELS;
import static net.fexcraft.mod.fvtm.util.Resources21.TOOLBOX;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class TabInitializer implements CTab {

	public TabInitializer(Addon addon, String id, String icon){
		FvtmLogger.log("Registering CTab " + addon.getID().colon() + "-" + id);
		final String addonid = addon.getID().id();
		CreativeModeTab tab = FabricItemGroup.builder().icon(() -> {
			Optional<Holder.Reference<Item>> iitem = BuiltInRegistries.ITEM.get(ResourceLocation.parse(icon));
			if(iitem.isPresent()) return new ItemStack(iitem.get());
			if(Resources21.ITEMS.containsKey(addonid) && Resources21.ITEMS.get(addonid).entrySet().iterator().hasNext()){
				return new ItemStack(Resources21.ITEMS.get(addonid).entrySet().iterator().next().getValue());
			}
			else return TOOLBOX[0].getDefaultInstance();
		}).displayItems((par, out) -> {
			Item item;
			for(Map.Entry<String, ConcurrentHashMap<String, Item>> registry : Resources21.ITEMS.entrySet()){
				for(Map.Entry<String, Item> entry : registry.getValue().entrySet()){
					item = entry.getValue();
					if(item instanceof ContentItem<?> == false){
						if(registry.getKey().equals("fvtm") && addonid.equals("fvtm")) out.accept(item);
						continue;
					}
					Content con = ((ContentItem)item).getContent();
					if(con instanceof WithItem == false){
						if(registry.getKey().equals("fvtm") && addonid.equals("fvtm")) out.accept(item);
						continue;
					}
					String tabin = ((WithItem)con).getCreativeTab();
					if(tabin.contains(":")){
						String[] split = tabin.split(":");
						if(split[0].equals(registry.getKey()) && split[1].equals(id)){
							accept(out, item);
						}
					}
					else if(registry.getKey().equals(addonid) && tabin.equals(id)){
						accept(out, item);
					}
				}
			}
		}).title(Component.literal(addon.getName())).build();
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, addonid + "." + id, tab);
	}

	private void accept(CreativeModeTab.Output out, Item item){
		if(item instanceof MaterialItem && ((MaterialItem)item).getContent().isFuelContainer()){
			Material material = ((MaterialItem)item).getContent();
			for(Fuel fuel : FUELS){
				if(!material.isValidFuel(fuel)) continue;
				TagCW compound = TagCW.create();
				compound.set("StoredFuelType", fuel.getID().colon());
				compound.set("StoredFuelAmount", material.getFuelCapacity());
				StackWrapper stack = UniStack.getStack(item.getDefaultInstance());
				stack.updateTag(compound);
				out.accept((ItemStack)stack.direct());
			}
		}
		out.accept(item);
	}

}