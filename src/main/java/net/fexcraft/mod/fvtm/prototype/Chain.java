package net.fexcraft.mod.fvtm.prototype;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Chain {
	
	public ArrayList<GlobalEntity> entities = new ArrayList<>();
	public boolean reverse;
	public UUID chainid;
	
	public void update(){
		if(reverse){
			for(int i = entities.size() - 1; i >= 0; i--){
				entities.get(i).update();
			}
		}
		else{
			for(GlobalEntity entity : entities){
				entity.update();
			}
		}
	}
	
}