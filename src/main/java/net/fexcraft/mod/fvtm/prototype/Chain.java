package net.fexcraft.mod.fvtm.prototype;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Chain extends ArrayList<GlobalEntity> {
	
	//public ArrayList<GlobalEntity> entities = new ArrayList<>();
	private WorldRailData world;
	public boolean reverse;
	public UUID chainid;
	
	public Chain(WorldRailData data){
		this.world = data;
	}
	
	public void update(){
		if(reverse){
			for(int i = size() - 1; i >= 0; i--){
				get(i).update(i, true);
			}
		}
		else{
			for(int i = 0; i < size(); i++){
				get(i).update(i, false);
			}
		}
	}

	public WorldRailData getWorld(){
		return world;
	}
	
}