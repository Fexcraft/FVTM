package net.fexcraft.mod.fvtm.util.function;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class BogieFunction extends Function {
	
	private String inst_pos;

	public BogieFunction(JsonObject obj){
		super(obj);
	}

	@Override
	public Function read(NBTTagCompound compound){
		inst_pos = compound.hasKey("bogie_pos") ? compound.getString("bogie_pos") : null;
		return this;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(inst_pos != null) compound.setString("bogie_pos", inst_pos);
		return compound;
	}

	@Override
	public String getId(){
		return "fvtm:bogie";
	}

	public void setBogie(String cat){
		this.inst_pos = cat;
	}

	@Override
	public Function copy(){
		return new BogieFunction(null);
	}

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
    	//
    }

}
