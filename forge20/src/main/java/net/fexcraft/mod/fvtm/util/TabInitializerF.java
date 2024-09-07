package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.FVTM4;
import net.fexcraft.mod.fvtm.FvtmGetters;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

import static net.fexcraft.mod.fvtm.FVTM4.ITEM_REGISTRY;
import static net.fexcraft.mod.fvtm.FvtmRegistry.FUELS;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class TabInitializerF implements CTab {

	public TabInitializerF(Addon addon, String id, String icon){
		FvtmLogger.LOGGER.debug("Registering CTab " + addon.getID().colon() + "-" + id);
		final String addonid = addon.getID().id();
		FVTM4.CREATIVE_MODE_TABS.register(addonid + "." + id, () -> CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.SPAWN_EGGS).title(Component.literal(addon.getName())).displayItems((par, out) -> {
			Item item = null;
			for(Map.Entry<String, DeferredRegister<Item>> registry : ITEM_REGISTRY.entrySet()){
				for(RegistryObject<? extends Item> entry : registry.getValue().getEntries()){
					item = entry.get();
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
		}).icon(() -> {
			Item iitem = BuiltInRegistries.ITEM.get(new ResourceLocation(icon));
			if(iitem != null) return iitem.getDefaultInstance();
			if(ITEM_REGISTRY.containsKey(addonid) && ITEM_REGISTRY.get(addonid).getEntries().iterator().hasNext()){
				return ITEM_REGISTRY.get(addonid).getEntries().iterator().next().get().getDefaultInstance();
			}
			else return FvtmGetters.TOOLBOX0.get().getDefaultInstance();
		}).build());
	}

	private void accept(CreativeModeTab.Output out, Item item){
		if(item instanceof MaterialItem && ((MaterialItem)item).getContent().isFuelContainer()){
			Material material = ((MaterialItem)item).getContent();
			for(Fuel fuel : FUELS){
				if(!material.isValidFuel(fuel)) continue;
				CompoundTag compound = new CompoundTag();
				compound.putString("StoredFuelType", fuel.getID().colon());
				compound.putInt("StoredFuelAmount", material.getFuelCapacity());
				ItemStack stack = item.getDefaultInstance();
				stack.setTag(compound);
				out.accept(stack);
			}
		}
		out.accept(item);
	}

}