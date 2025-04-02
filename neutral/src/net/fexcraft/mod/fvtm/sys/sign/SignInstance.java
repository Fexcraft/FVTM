package net.fexcraft.mod.fvtm.sys.sign;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.model.RenderCacheI;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.SysObj;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignInstance implements SysObj {

	public ConcurrentLinkedQueue<SignData> components = new ConcurrentLinkedQueue<>();
	private RenderCache cache;
	public SystemRegion<SignSystem, SignInstance> region;
	public float yaw;
	public QV3D vec;

	public SignInstance(SystemRegion<SignSystem, SignInstance> reg){
		region = reg;
	}

	public SignInstance(SystemRegion<SignSystem, SignInstance> reg, V3I pos){
		this(reg);
		vec = new QV3D(pos);
	}

	public SignInstance(SystemRegion<SignSystem, SignInstance> reg, QV3D pos){
		this(reg);
		vec = pos;
	}

	public void read(TagCW com){
		components.clear();
		vec = new QV3D(com, "pos");
		yaw = com.getFloat("yaw");
		TagLW list = com.getList("comp");
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
		com.set("yaw", yaw);
		TagLW list = TagLW.create();
		for(SignData sd : components){
			list.add(sd.write(TagCW.create()));
		}
		com.set("comp", list);
		return com;
	}

	public void update(){
		//
	}

	public void delete(){
		//
	}

	public void updateClient(){
		TagCW com = TagCW.create();
		com.set("pos", vec.pos.toLW());
		com.set("sign", write());
		Packets.sendToAllTrackingPos(Packet_TagListener.class, region.system.getWorld(), vec.pos, "sign_upd", com);
	}

	public RenderCache getRenderCache(){
		if(cache == null) cache = new RenderCacheI();
		return cache;
	}

}
