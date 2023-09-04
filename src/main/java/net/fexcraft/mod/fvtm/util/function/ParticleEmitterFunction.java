package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.part.PartFunction.StaticFunction;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.condition.Conditional;
import net.fexcraft.mod.fvtm.sys.particle.Particle;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ParticleEmitterFunction extends StaticFunction {
	
	public ArrayList<EmitterData> emitters = new ArrayList<EmitterData>();

	public ParticleEmitterFunction(Part part, JsonObject obj){
		super(part, obj);
		if(obj == null) return;
		if(obj.has("emitters")){
			JsonArray array = obj.getAsJsonArray("emitters");
			for(JsonElement elm : array){
				emitters.add(new EmitterData(elm.getAsJsonObject()));
			}
		}
		else{
			emitters.add(new EmitterData(obj));
		}
	}
	
	@Override
	public String getId(){
		return "fvtm:particle_emitter";
	}

	@Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
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
		
		public EmitterData(JsonObject obj){
			Pos pos = obj.has("pos") ? Pos.fromJson(obj.get("pos"), true) : Pos.NULL;
			this.pos = new Pos(pos.x, -pos.y, -pos.z);
			particle = obj.has("particle") ? FvtmRegistry.PARTICLES.get(obj.get("particle").getAsString()) : null;
			frequency = obj.has("frequency") ? obj.get("frequency").getAsInt() : 0;
			condition = obj.has("condition") ? obj.get("condition").getAsString() : null;
			if(obj.has("direction")){
				JsonArray array = obj.get("direction").getAsJsonArray();
				dir = new V3D(array.get(0).getAsDouble(), array.get(1).getAsDouble(), array.get(2).getAsDouble());
			}
			else dir = null;
			speed = obj.has("speed") ? obj.get("speed").getAsFloat() : null;
		}
		
		public Conditional conditional;
		public final Particle particle;
		public final String condition;
		public final int frequency;
		public final Float speed;
		public final V3D dir;
		public final Pos pos;
		
		public Conditional getConditional(){
			if(condition == null) return null;
			if(conditional == null) conditional = ConditionRegistry.get(condition);
			return conditional;
		}
		
	}

}
