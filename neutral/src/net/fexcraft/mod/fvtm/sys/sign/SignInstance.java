package net.fexcraft.mod.fvtm.sys.sign;

import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignInstance {

	public ConcurrentLinkedQueue<SignData> components = new ConcurrentLinkedQueue<>();
	public SignRegion region;
	public QV3D vec;

	public SignInstance(SignRegion reg){
		region = reg;
	}

	public SignInstance(SignRegion reg, QV3D pos){
		this(reg);
		vec = pos;
	}

	public void read(TagCW com){
		vec = new QV3D(com, "pos");
		TagLW list = com.getList("components");
		for(TagCW c : list){
			try{
				components.add(FvtmResources.getSignData(c));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public TagCW write(){
		TagCW com = TagCW.create();
		vec.write(com, "pos");
		TagLW list = TagLW.create();
		for(SignData sd : components){
			list.add(sd.write(TagCW.create()));
		}
		return com;
	}

	public void update(){
		//
	}

	public void delete(){
		//
	}

}
