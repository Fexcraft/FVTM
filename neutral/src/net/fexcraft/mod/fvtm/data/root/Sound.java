package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.uni.IDL;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Sound {

	public IDL soundid;
	public float pitch, volume;
	public boolean override;
	public Object event;
	
	public Sound(IDL idl, float vol, float pitch){
		this(idl, vol, pitch, true);
	}
	
	public Sound(IDL idl, float vol, float pitch_, boolean override_){
		soundid = idl;
		volume = vol;
		pitch = pitch_;
		override = override_;
	}

}
