package net.fexcraft.mod.fvtm.util.script;

import com.google.gson.JsonObject;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.script.ScrAction;
import net.fexcraft.lib.script.Script;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.data.block.BlockScript;
import net.fexcraft.mod.fvtm.data.block.MB_Interact;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.event.EventHandler;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class FSBlockScript implements BlockScript {
	
	private Script script;
	private String id;
	private ResourceLocation resloc;
	//
	protected ScrAction update, save, load, interact, onpacket;
	protected boolean hasUpdate, hasSave, hasLoad, hasInteract, hasPacket;
	protected BlockScriptContext context;
	
	public FSBlockScript(){}
	
	public FSBlockScript(JsonObject obj){
		resloc = new ResourceLocation(obj.get("script_location").getAsString());
		id = resloc.getNamespace() + (resloc.getPath().contains("/") ? resloc.getPath().substring(resloc.getPath().lastIndexOf("/")) : resloc.getPath());
		if(id.endsWith(".script")) id = id.substring(0, id.length() - 7);
	}

	public BlockScript init(MultiBlockData data){
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
		hasInteract = (interact = (ScrAction)script.blocks.get("interact")) != null;
		hasPacket = (onpacket = (ScrAction)script.blocks.get("data_packet")) != null;
		context = new BlockScriptContext(data, this);
		Print.debug(script);
		return this;
	}

	@Override
	public void read(MultiBlockData data, TagCW tag){
		
	}

	@Override
	public TagCW write(MultiBlockData data, TagCW compound){
		
		return compound;
	}

	public void onUpdate(MultiblockTickableTE tile){
		if(!hasUpdate) return;
		update.process(context.update(tile));
	}

	public boolean onTrigger(MultiBlockData data, MB_Interact trigger, EntityPlayer player, EnumHand hand, BlockPos core, BlockPos pos, EnumFacing side, V3D hit){
		if(!hasInteract) return false;
		//TODO
		return true;
	}

	public void onUpdatePacket(TileEntity tile, NBTTagCompound compound){
		
	}

	public Script script(){
		return script;
	}

	public BlockScriptContext context(){
		return context;
	}

}
