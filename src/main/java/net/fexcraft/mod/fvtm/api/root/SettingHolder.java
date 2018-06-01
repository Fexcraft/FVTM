package net.fexcraft.mod.fvtm.api.root;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public interface SettingHolder {
	
	public String getSettingHolderId();
	
    public @Nullable ScriptSetting<?>[] getSettings(int seat);
    
    public Object getSettingsValue(String setting);
    
    public static abstract class ScriptSetting<T extends SettingHolder> {
    	
    	protected T holder;
    	private String id;
    	private Type type;
    	
    	public ScriptSetting(T parent, String id, Type type){
    		this.id = id; this.holder = parent; this.type = type;
    	}
    	
    	public final String getId(){
    		return id;
    	}

		public Type getType(){
			return type;
		}
    	
    	public static enum Type {
    		INTEGER, BOOLEAN, STRING, BUTTON
    	}
    	
    	public abstract void onChange(EntityPlayer player, Entity entity, int i, @Nullable Object... objs);
    	
    	public final String getValue(){
    		return String.valueOf(holder.getSettingsValue(id));
    	}

		public T getHolder(){
			return holder;
		}
    	
    }
    
}