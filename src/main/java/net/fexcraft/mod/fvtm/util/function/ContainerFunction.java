package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import com.google.gson.JsonObject;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.container.ContainerType;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.minecraft.nbt.NBTTagCompound;

@SuppressWarnings("unused")
public class ContainerFunction extends Function {
	
	private ArrayList<ContainerData> list = new ArrayList<>();
	private ContainerType def, current;
	private boolean onetype;
	private int length;

	/** Static Copy in Part. */
	public ContainerFunction(JsonObject obj){
		super(obj); if(obj == null) return;
	}

	/** Functional Copy in PartData. */
	public ContainerFunction(ContainerFunction root){
		super(null); current = def = root.def; list.clear();
		onetype = root.onetype; length = (int)current.length();
		
	}

	@Override
	public Function read(NBTTagCompound compound){
		//
		return this;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		//
		return compound;
	}

	@Override
	public String getId(){
		return "fvtm:inventory";
	}

	@Override
	public Function copy(){
		return new ContainerFunction(this);
	}

}
