package net.fexcraft.mod.fvtm.sys.deco;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.DecorationData;
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
public class DecoInstance implements SysObj {

	public ConcurrentLinkedQueue<DecorationData> decorations = new ConcurrentLinkedQueue<>();
	public SystemRegion<DecoSystem, DecoInstance> region;
	private RenderCache cache;
	public QV3D vec;

	public DecoInstance(SystemRegion<DecoSystem, DecoInstance> reg){
		region = reg;
	}

	public DecoInstance(SystemRegion<DecoSystem, DecoInstance> reg, V3I pos){
		this(reg);
		vec = new QV3D(pos);
	}

	public DecoInstance(SystemRegion<DecoSystem, DecoInstance> reg, QV3D pos){
		this(reg);
		vec = pos;
	}

	public void read(TagCW com){
		decorations.clear();
		vec = new QV3D(com, "pos");
		TagLW list = com.getList("deco");
		for(TagCW c : list){
			try{
				decorations.add(FvtmResources.getDecorationData(c));
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
		for(DecorationData sd : decorations){
			list.add(sd.write(TagCW.create()));
		}
		com.set("deco", list);
		return com;
	}

	public void update(){
		//
	}

	public void delete(){
		TagCW com = TagCW.create();
		com.set("pos", vec.pos.toIntegerArray());
		com.set("dim", region.system.getWorldType().rec_key());
		Packets.sendToAllTrackingPos(Packet_TagListener.class, region.system.getServerWorld(), vec.pos, "deco_rem", com);
	}

	public void updateClient(){
		TagCW com = TagCW.create();
		com.set("pos", vec.pos.toIntegerArray());
		com.set("deco", write());
		com.set("dim", region.system.getWorldType().rec_key());
		Packets.sendToAllTrackingPos(Packet_TagListener.class, region.system.getServerWorld(), vec.pos, "deco_upd", com);
	}

	public RenderCache getRenderCache(){
		if(cache == null) cache = new RenderCacheI();
		return cache;
	}

}
