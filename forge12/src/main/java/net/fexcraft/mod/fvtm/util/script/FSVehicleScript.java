package net.fexcraft.mod.fvtm.util.script;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

import com.google.gson.JsonElement;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.script.ScrAction;
import net.fexcraft.lib.script.Script;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.event.EventHandler;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class FSVehicleScript extends VehicleScript {
	
	private Script script;
	private String id;
	private ResourceLocation resloc;
	//
	private ScrAction update, save, load, spawn, remove, keypress, attrtoggle, interact, onpacket;
	private boolean hasUpdate, hasSave, hasLoad;
	private boolean hasSpawn, hasRemove, hasKeyPress, hasAttrToggle, hasInteract, hasPacket;
	private VehicleScriptContext context;
	
	public FSVehicleScript(){}

	public void set(JsonElement elm){
		parseId(elm);
	}
	
	private void parseId(JsonElement elm){
		resloc = new ResourceLocation(elm.isJsonObject() ? elm.getAsJsonObject().get("script_location").getAsString() : elm.getAsString());
		id = resloc.getNamespace() + (resloc.getPath().contains("/") ? resloc.getPath().substring(resloc.getPath().lastIndexOf("/")) : resloc.getPath());
		if(id.endsWith(".script")) id = id.substring(0, id.length() - 7);
	}

	public VehicleScript init(VehicleData data, JsonElement elm){
		parseId(elm);
		Object[] obj = EventHandler.getInputStream(resloc);
		script = new Script((InputStream)obj[0], id);
		if(obj.length > 1){
			for(Closeable cl : (Closeable[])obj[1]){
				try{ cl.close(); } catch(IOException e){ e.printStackTrace(); }
			}
		}
		hasUpdate = (update = (ScrAction)script.blocks.get("update")) != null;
		hasSave = (save = (ScrAction)script.blocks.get("save")) != null;
		hasLoad = (load = (ScrAction)script.blocks.get("load")) != null;
		hasSpawn = (spawn = (ScrAction)script.blocks.get("spawn")) != null;
		hasRemove = (remove = (ScrAction)script.blocks.get("remove")) != null;
		hasKeyPress = (keypress = (ScrAction)script.blocks.get("keypress")) != null;
		hasAttrToggle = (attrtoggle = (ScrAction)script.blocks.get("attr_toggle")) != null;
		hasInteract = (interact = (ScrAction)script.blocks.get("interact")) != null;
		hasPacket = (onpacket = (ScrAction)script.blocks.get("data_packet")) != null;
		context = new VehicleScriptContext(data, this);
		Print.debug(script);
		return this;
	}

	@Override
	public String getId(){
		return id;
	}

	@Override
	public String getName(){
		return "VehicleFS(" + id + ")";
	}

	@Override
	public void onUpdate(Entity entity, VehicleData data){
		if(!hasUpdate) return;
		update.process(context.update(entity));
	}

	@Override
	public VehicleScript load(VehicleData data, TagCW compound){
		return this;
	}

	@Override
	public TagCW save(VehicleData data, TagCW compound){
		return null;
	}

	@Override
	public void onSpawn(Entity entity, VehicleData data){
		if(!hasSpawn) return;
		spawn.process(context.update(entity));
	}

	@Override
	public void onRemove(Entity entity, VehicleData data){
		if(!hasRemove) return;
		remove.process(context.update(entity));
	}

	@Override
	public boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player){
		if(!hasKeyPress) return false;
		return update.process(context.update(seat, player)).scr_bln();
	}

	@Override
	public void onAttributeToggle(Entity entity, Attribute<?> attr, Object oldvalue, EntityPlayer player){
		if(!hasAttrToggle) return;
		attrtoggle.process(context.update(entity, attr, oldvalue, player));
	}

	@Override
	public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player, EnumHand hand){
		if(!hasInteract) return false;
		return interact.process(context.update(entity)).scr_bln();
	}

	@Override
	public void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side){
		if(side.isClient() && compound.hasKey("ScriptElm")){
			context.onElmUpdate(compound);
		}
		if(!hasPacket) return;
		onpacket.process(context.update(entity).update(compound, side));
	}

	public Script script(){
		return script;
	}

}
