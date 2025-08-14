package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.FvtmPlayer;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.util.QV3D;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class LongDisRailUtil {

	public static void add(FvtmPlayer player){
		V3I pos = player.entity.getV3I();
		player.longdis.add(pos);
		player.entity.send("fvtm.rail.long_distance.added", pos.x, pos.y, pos.z);
	}

	public static void clear(FvtmPlayer player){
		player.longdis.clear();
		player.entity.send("fvtm.rail.long_distance.cleared");
	}

	public static void seg(FvtmPlayer player, int val){
		player.segmentation = val;
		if(player.segmentation < 4) player.segmentation = 4;
		if(player.segmentation > 32) player.segmentation = 32;
		player.entity.send("fvtm.rail.long_distance.segments_set", player.segmentation);
	}

	public static void process(FvtmPlayer player){
		if(player.longdis.size() < 2) return;
		if(!player.entity.getHeldItem(true).isItemOf(ContentType.RAILGAUGE.item_type)){
			player.entity.send("fvtm.rail.long_distance.no_gauge");
			return;
		}
		RailGauge gauge = player.entity.getHeldItem(true).getContent(ContentType.RAILGAUGE.item_type);
		player.entity.send("fvtm.rail.long_distance.starting");
		RailSystem sys = player.getRailSystem();
		QV3D[] path = new QV3D[player.longdis.size()];
		for(int idx = 0; idx < player.longdis.size(); idx++){
			V3I pos = player.longdis.get(idx);
			Junction jun = sys.getJunction(pos);
			if(jun != null) path[idx] = jun.getPos();
			else path[idx] = new QV3D(pos.x + 0.5, pos.y, pos.z + 0.5);
		}
		Track track = new Track(null, path, gauge);
		if(track.length < 16){
			player.entity.send("fvtm.rail.long_distance.too_short");
			return;
		}
		float pass = 0;
		QV3D last = path[0], curr;
		Junction star = sys.getJunction(last.pos);
		if(star == null){
			sys.addJunction(last);
			star = sys.getJunction(last.pos);
		}
		if(star.full()){
			player.entity.send("fvtm.rail.long_distance.junction_full", star.posString());
			return;
		}
		int total = 0;
		double length = 0;
		double quarter = player.segmentation * 0.25;
		double triquar = player.segmentation * 0.75;
		Junction junc;
		while(pass < track.length){
			curr = new QV3D(track.getVectorPosition0(pass + player.segmentation, false));
			junc = sys.getJunction(curr.pos, true);
			if(junc == null){
				sys.addJunction(curr);
				junc = sys.getJunction(curr.pos);
			}
			if(junc.full()){
				player.entity.send("fvtm.rail.long_distance.junction_full", star.posString());
				return;
			}
			QV3D[] points = new QV3D[4];
			points[3] = last;
			points[2] = new QV3D(track.getVectorPosition0(pass + quarter, false));
			points[1] = new QV3D(track.getVectorPosition0(pass + triquar, false));
			points[0] = curr;
			Track ntr = new Track(junc, points, gauge);
			junc.addnew(ntr);
			star.addnew(ntr.createOppositeCopy());
			star = junc;
			last = curr;
			length += track.length;
			total++;
			pass += player.segmentation;
		}
		player.entity.send("fvtm.rail.long_distance.finished", total, length);
		clear(player);
	}

	public static void status(FvtmPlayer player){
		player.entity.send("[FVTM] === === ===");
		player.entity.send("fvtm.rail.long_distance.info");
		player.entity.send("fvtm.rail.long_distance.segments", player.segmentation);
		player.entity.send("fvtm.rail.long_distance.points");
		for(V3I key : player.longdis){
			player.entity.send("- " + key.x + ", " + key.y + ", " + key.z);
		}
	}

}
