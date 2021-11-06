package net.fexcraft.mod.fvtm.util.function;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFunction;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.sys.condition.Condition.Conditional;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.particle.Particle;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ParticleEmitterFunction extends StaticFunction {

	private Conditional conditional;
	private Particle particle;
	private String condition;
	private int frequency;
	private Pos pos;

	public ParticleEmitterFunction(Part part, JsonObject obj){
		super(part, obj);
		if(obj == null) return;
		pos = obj.has("pos") ? Pos.fromJson(obj.get("pos"), true) : Pos.NULL;
		particle = obj.has("particle") ? Resources.PARTICLES.get(obj.get("particle").getAsString()) : null;
		frequency = obj.has("frequency") ? obj.get("frequency").getAsInt() : 20;
		condition = obj.has("condition") ? obj.get("condition").getAsString() : null;
	}
	
	@Override
	public String getId(){
		return "fvtm:particle_emitter";
	}

	@Override
	public Function copy(Part part){
		return new ParticleEmitterFunction(part, null).set(pos, particle);
	}

    private Function set(Pos pos2, Particle particle2){
		this.particle = particle2;
		this.pos = pos2;
		return this;
	}

	@Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&6[&b#&6]&2 Particle Emitter"));
        tooltip.add(Formatter.format("&9Particle: &7" + particle.id));
        tooltip.add(Formatter.format("&9Frequncy: &7" + frequency + "/tick"));
    }
	
	public Particle getParticle(){
		return particle;
	}
	
	public Pos getOffset(){
		return pos;
	}
	
	public int getFrequency(){
		return frequency;
	}
	
	public Conditional getConditional(){
		if(condition == null) return null;
		if(conditional == null) conditional = ConditionRegistry.get(condition);
		return conditional;
	}

}
