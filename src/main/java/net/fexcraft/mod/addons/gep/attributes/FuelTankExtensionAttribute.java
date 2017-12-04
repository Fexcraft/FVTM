package net.fexcraft.mod.addons.gep.attributes;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class FuelTankExtensionAttribute implements Attribute {
	
	private static final ResourceLocation regname = new ResourceLocation("fuel_tank");
	private int tanksize;

	@Override
	public ResourceLocation getRegistryName(){
		return regname;
	}

	@Override
	public void load(JsonObject obj){
		this.tanksize = JsonUtil.getIfExists(obj, "Fuel-TankSize", 10).intValue();
	}

	@Override
	public String getName(){
		return "Fuel Tank Extension";
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
		tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
		tooltip.add(Formatter.format("&9Tank Size: &7" + tanksize));
	}

	public int getFuelTankSize(){
		return tanksize;
	}

	@Override
	public boolean hasDataClass(){
		return true;
	}

	@Override
	public Class<? extends AttributeData> getDataClass(){
		return FuelTankExtensionAttributeData.class;
	}
	
	public static class FuelTankExtensionAttributeData implements AttributeData {
		
		private double content;
		
		public FuelTankExtensionAttributeData(PartData data, Attribute attr){
			content = 0;//((FuelTankExtensionAttribute)attr).getFuelTankSize();
			//should actually be `0`, but let's keep this for testing till an appropiate system is in.
		}

		@Override
		public NBTTagCompound writeToNBT(PartData data, NBTTagCompound compound){
			compound.setDouble("FuelTankContent", content);
			return compound;
		}

		@Override
		public AttributeData readFromNBT(PartData data, NBTTagCompound compound){
			this.content = compound.hasKey("FuelTankContent") ? compound.getDouble("FuelTankContent") : content;
			return this;
		}

		public double getContent(){
			return content;
		}
		
		public double consume(double d, int tanksize){
			if(d < 0){
				d = -d;
				if(content + d <= tanksize){
					content += d;
				}
				else{
					content += d;
					return -(content - tanksize);
				}
			}
			else{
				content -= d;
				if(content < 0){
					double f = content;
					content = 0;
					return -(f);
				}
			}
			return 0;
		}

		public void setContent(double amount){
			content = amount;
		}
		
	}
	
}