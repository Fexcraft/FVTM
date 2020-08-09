package net.fexcraft.mod.fvtm.model.block;

import static net.fexcraft.mod.fvtm.block.UnlistedProperties.POSITION;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.mc.render.FCLBlockModel;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.block.RailEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.VecUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.property.IExtendedBlockState;

@fModel(registryname = "fvtm:models/block/dynamic_rail")
public class RailModel implements FCLBlockModel {
	
	//private static final ResourceLocation temp_tex = new ResourceLocation("minecraft:textures/blocks/anvil_base");

	public RailModel(){
		//TODO
	}

	@Override
	public Collection<ModelRendererTurbo> getPolygons(IBlockState state, EnumFacing side, Map<String, String> args, long rand){
		BlockPos pos = ((IExtendedBlockState)state).getValue(POSITION);
		RailEntity rail = (RailEntity)Minecraft.getMinecraft().world.getTileEntity(pos);
		if(rail == null){
			Print.log("No rail entity at " + pos.toString());
			return Collections.emptyList();
		}
		//Print.log(pos, rail);
		ArrayList<ModelRendererTurbo> list = new ArrayList<>();
		RailSystem sys = Minecraft.getMinecraft().world.getCapability(Capabilities.RAILSYSTEM, null);
		for(PathKey key : rail.getTracks()){
			Print.log("Applying path " + key.toString() + "!");
			Track track = sys.get().getTrack(key);
			if(track == null){
				Print.log("not found");
				continue;
			}
			list.add(generateBlockSegment(pos, track, track.gauge.getModel()));
		}
		return list;
	}
	
	private ModelRendererTurbo generateBlockSegment(BlockPos pos, Track track, RailGaugeModel model){
		ModelRendererTurbo turbo = new ModelRendererTurbo(null, 0, 0, 1, 1);
		float angle, passed = 0;
		Vec3f last, vec;
		ArrayList<Vec3f> path = new ArrayList<>();
		TexturedVertex vert0, vert1, vert2, vert3;
		TexturedPolygon poly0;
		//
		for(int p = 0; p < model.rails.length; p++){
			path.clear();
			vec = track.getVectorPosition0(0.001f, false);
			passed = 0;
			//
			angle = (float)Math.atan2(track.vecpath[0].zCoord - vec.zCoord, track.vecpath[0].xCoord - vec.xCoord);
			angle += Static.rad90;
			path.add(track.vecpath[0].add(VecUtil.rotByRad(angle, model.rails[p][0])));
			path.add(track.vecpath[0].add(VecUtil.rotByRad(angle, model.rails[p][1])));
			for(int v = 0; v < track.vecpath.length - 1; v++){
				last = track.vecpath[v];
				vec = track.vecpath[v + 1];
				angle = (float)Math.atan2(last.zCoord - vec.zCoord, last.xCoord - vec.xCoord);
				angle += Static.rad90;
				path.add(vec.add(VecUtil.rotByRad(angle, model.rails[p][0])));
				path.add(vec.add(VecUtil.rotByRad(angle, model.rails[p][1])));
			}
			for(int k = 0; k < track.vecpath.length - 1; k++){
				if(!range(path.get(k), track.getVectorPosition0(passed, false), pos)) continue;//TODO improved checks
				vert0 = new TexturedVertex(path.get(k * 2), 1, 1);
				vert1 = new TexturedVertex(path.get(k * 2 + 1), 0, 1);
				vert2 = new TexturedVertex(path.get((k + 1) * 2), 0, 0);
				vert3 = new TexturedVertex(path.get((k + 1) * 2 + 1), 1, 0);
				Vec3f veca = track.vecpath[0].subtract(pos.getX(), pos.getY(), pos.getZ());
				vert0.vector = vert0.vector.subtract(track.vecpath[0]).add(veca);
				vert1.vector = vert1.vector.subtract(track.vecpath[0]).add(veca);
				vert2.vector = vert2.vector.subtract(track.vecpath[0]).add(veca);
				vert3.vector = vert3.vector.subtract(track.vecpath[0]).add(veca);
				poly0 = new TexturedPolygon(new TexturedVertex[] { vert1, vert0, vert2, vert3 });
				turbo.copyTo(poly0.getVertices(), new TexturedPolygon[] { poly0/* .setColor(MIDDLE_GRAY) */ });
				passed += track.vecpath[k].distanceTo(track.vecpath[k + 1]);
			}
		}
		return turbo;
	}

	private boolean range(Vec3f vec, Vec3f vec2, BlockPos pos){
		int x = (int)vec.xCoord, y = (int)vec.yCoord, z = (int)vec.zCoord;
		if(x == pos.getX() && y == pos.getY() && z == pos.getZ()) return true;
		x = (int)vec2.xCoord; y = (int)vec2.yCoord; z = (int)vec2.zCoord;
		return x == pos.getX() && y == pos.getY() && z == pos.getZ();
	}

	@Override
	public boolean useDefaultCacheKey(){ return false; }

	@Override
	public String getCacheKey(IBlockState state, EnumFacing side, Map<String, String> customdata, long rand){
		return Long.toHexString(((IExtendedBlockState)state).getValue(POSITION).toLong());
	}
	
	/*@Override
	public Collection<ResourceLocation> getTextures(Map<String, String> customdata){
		return Collections.singleton(temp_tex);
	}*/
	
}