package net.fexcraft.mod.fvtm.data.addon;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
//TODO addon creative tab
public class AddonTab {}/*extends CreativeTab {
	
    private static TreeMap<ResourceLocation, AddonTab> TABS = new TreeMap<>();
    public static final String DEFAULT = "default";
    private NonNullList<ItemStack> list;
    private int icon, sec;
	private Addon addon;

	public AddonTab(Addon addon, String string){
		super(addon.getRegistryName().toString() + (string.equals(DEFAULT) ? "" : "." + string));
		TABS.put(new ResourceLocation(super.getTabLabel()), this);
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

}*/
