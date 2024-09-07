package net.fexcraft.mod.fvtm.function.part;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.part.PartFunction.StaticFunction;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.condition.Conditional;
import net.fexcraft.mod.fvtm.sys.particle.Particle;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ParticleEmitterFunction extends StaticFunction {
	
	public ArrayList<EmitterData> emitters = new ArrayList<EmitterData>();

	@Override
	public PartFunction init(Part part, FJson json){
		if(json == null) return this;
		if(json.isArray()){
			for(JsonValue<?> elm : json.asArray().value){
				emitters.add(new EmitterData(elm.asMap()));
			}
		}
		else emitters.add(new EmitterData(json.asMap()));
		return this;
	}
	
	@Override
	public String getId(){
		return "fvtm:particle_emitter";
	}

	@Override
    public void addInformation(StackWrapper stack, WorldW world, PartData data, List<String> tooltip, boolean ext){
        tooltip.add(Formatter.format("&6[&b#&6]&2 Particle Emitter"));
        if(emitters.size() == 1){
            tooltip.add(Formatter.format("&9Particle: &7" + emitters.get(0).particle.id));
            EmitterData e = emitters.get(0);
            tooltip.add(Formatter.format("&9Frequncy: &7" + (e.frequency == 0 ? e.particle.frequency : e.frequency) / 20f + "/tick"));
        }
        else{
            tooltip.add(Formatter.format("&9Emitters: &7" + emitters.size()));
        }
    }
	
	public static class EmitterData {
		
		public EmitterData(JsonMap map){
			pos = map.has("pos") ? ContentConfigUtil.getVector(map.getArray("pos")) : new V3D();
			particle = map.has("particle") ? FvtmRegistry.PARTICLES.get(map.get("particle").string_value()) : null;
			frequency = map.getInteger("frequency", 0);
			condition = map.getString("condition", null);
			if(map.has("direction")){
				dir = ContentConfigUtil.getVector(map.getArray("direction"));
			}
			else dir = null;
			speed = map.has("speed") ? map.get("speed").float_value() : null;
		}
		
		public Conditional conditional;
		public final Particle particle;
		public final String condition;
		public final int frequency;
		public final Float speed;
		public final V3D dir;
		public final V3D pos;
		
		public Conditional getConditional(){
			if(condition == null) return null;
			if(conditional == null) conditional = ConditionRegistry.get(condition);
			return conditional;
		}
		
	}

}
