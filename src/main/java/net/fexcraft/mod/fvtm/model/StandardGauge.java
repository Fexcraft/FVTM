package net.fexcraft.mod.fvtm.model;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.entity.JunctionSwitchEntity;
import net.fexcraft.mod.fvtm.sys.rail.Junction;

@fModel(registryname = "fvtm:models/gauges/standard")
public class StandardGauge extends RailGaugeModel {
	
	public StandardGauge(){
		super(); textureX = 128; textureY = 64;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		ties_distance = 0.5f;
		signal_offset = 2.0f;
		//
		addRailRect(Static.sixteenth, 15, 4, 2, 2, true);
		TurboList ties = new TurboList("ties"); this.groups.add(ties);
		ties.add(new ModelRendererTurbo(ties, 0, 0, textureX, textureY).addBox(-2, 0, -20, 4, 2, 40).setRotationAngle(0, 0, 0).setName("center_ties"));
		//
		simple_signal_base = new TurboList("simple_signal_base");
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 101, 0, textureX, textureY).addBox(0, 0, 0, 6, 12, 5)
			.setRotationPoint(-3, -62, -2.5f).setRotationAngle(0, 0, 0)
		);
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 92, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 50, 8, 0.75f, 0.75f, 4, null)
			.setRotationPoint(0, -50, 0).setRotationAngle(0, 0, 0)
		);
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 67, 9, textureX, textureY).addBox(0, 0, 0, 4, 1, 4)
			.setRotationPoint(-2, -1, -2).setRotationAngle(0, 0, 0)
		);
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 82, 0, textureX, textureY).addHollowCylinder(0, 0, 0, 2.125f, 2, 2, 16, 8, 1, 1, 1, null)
			.setRotationPoint(0, -53, -4).setRotationAngle(0, 0, -90)
		);
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 72, 0, textureX, textureY).addHollowCylinder(0, 0, 0, 2.125f, 2, 2, 16, 8, 1, 1, 1, null)
			.setRotationPoint(0, -59, -4).setRotationAngle(0, 0, -90)
		);
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 54, 15, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 0.9375f, 0.9375f, 1, null)
			.setRotationPoint(0, -59, -2.75f).setRotationAngle(0, 0, 0)
		);
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 63, 15, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 0.9375f, 0.9375f, 1, null)
			.setRotationPoint(0, -53, -2.75f).setRotationAngle(0, 0, 0)
		);
		this.groups.add(simple_signal_base);
		//
		simple_signal_stop = new TurboList("simple_signal_stop");
		simple_signal_stop.add(new ModelRendererTurbo(simple_signal_stop, 54, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 1, 1, 1, null)
			.setRotationPoint(0, -59, -3).setRotationAngle(0, 0, 0)
		);
		simple_signal_stop.addProgram(DefaultPrograms.ALWAYS_GLOW);
		this.groups.add(simple_signal_stop);
		//
		simple_signal_clear = new TurboList("simple_signal_clear");
		simple_signal_clear.add(new ModelRendererTurbo(simple_signal_clear, 63, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 1, 1, 1, null)
			.setRotationPoint(0, -53, -3).setRotationAngle(0, 0, 0)
		);
		simple_signal_clear.addProgram(DefaultPrograms.ALWAYS_GLOW);
		this.groups.add(simple_signal_clear);
		//
		switch_lever = new TurboList("switch_lever");
		switch_lever.add(new ModelRendererTurbo(switch_lever, 84, 9, textureX, textureY).addBox(-0.5f, -7, -0.5f, 1, 7, 1)
			.setRotationPoint(0, -2, 0).setRotationAngle(0, 0, 0)
		);
		this.groups.add(switch_lever);
		//
		switch_base = new TurboList("switch_base");
		switch_base.add(new ModelRendererTurbo(switch_base, 17, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 3, 6, 0, -2, 0, -1, -2, 0, -1, -2, 0, -1, -2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-6, -3, -3).setRotationAngle(0, 0, 0)
		);
		this.groups.add(switch_base);
		//
		switch_fork2 = new TurboList("switch_fork2");
		switch_fork2.add(new ModelRendererTurbo(switch_fork2, 50, 7, textureX, textureY).addBox(-2, -10.5f, -2, 4, 3, 4)
			.setRotationPoint(0, -1.5f, 0).setRotationAngle(0, 0, 0)
		);
		this.groups.add(switch_fork2);
		//
		switch_fork3 = new TurboList("switch_fork3");
		switch_fork3.add(new ModelRendererTurbo(switch_fork3, 0, 0, textureX, textureY).addCylinder(0, -1, 0, 4, 3, 6, 1, 1, 5, null)
			.setRotationPoint(0, -9, 0).setRotationAngle(0, -30, 0)
		);
		this.groups.add(switch_fork3);
	}
	
	private TurboList switch_lever, switch_base, switch_fork2, switch_fork3;

	@Override
	public void renderSwitch(JunctionSwitchEntity entity, Junction junction){
		switch(junction.type){
			case DOUBLE:{
				{
					GL11.glTranslatef(0, 0, -.25f);
					switch_base.get(0).render();
					if(junction.switch0){
						switch_lever.get(0).rotationAngleZ = 30;
						switch_fork2.get(0).setRotationAngle(-30, 90, 0);
					}
					else{
						switch_lever.get(0).rotationAngleZ = -30;
						switch_fork2.get(0).setRotationAngle(0, 0, -30);
					}
					switch_lever.get(0).render();
					switch_fork2.get(0).render();
					GL11.glTranslatef(0, 0, 0.5f);
					switch_base.get(0).render();
					if(junction.switch1){
						switch_lever.get(0).rotationAngleZ = 30;
						switch_fork2.get(0).setRotationAngle(-30, 90, 0);
					}
					else{
						switch_lever.get(0).rotationAngleZ = -30;
						switch_fork2.get(0).setRotationAngle(0, 0, -30);
					}
					switch_lever.get(0).render();
					switch_fork2.get(0).render();
				}
				break;
			}
			case FORK_2:{
				switch_base.get(0).render();
				if(junction.switch0){
					switch_lever.get(0).rotationAngleZ = 30;
					switch_fork2.get(0).setRotationAngle(-30, 90, 0);
				}
				else{
					switch_lever.get(0).rotationAngleZ = -30;
					switch_fork2.get(0).setRotationAngle(0, 0, -30);
				}
				switch_lever.get(0).render();
				switch_fork2.get(0).render();
				break;
			}
			case FORK_3:{
				switch_base.get(0).render();
				switch_lever.get(0).rotationAngleZ = 0;
				switch_lever.get(0).render();
				switch_fork3.get(0).rotationAngleY = junction.switch0 ? -90 : junction.switch1 ? 30 : -30;
				switch_fork3.get(0).render();
				break;
			}
			case CROSSING: case STRAIGHT: default: return;
		}
	}
	
}