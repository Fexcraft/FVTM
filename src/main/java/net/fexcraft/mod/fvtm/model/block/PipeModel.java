package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.mod.fvtm.blocks.PipeTileEntity;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;

public class PipeModel extends Model<PipeTileEntity> {
	
	public static final PipeModel INSTANCE = new PipeModel();
	
	private ModelRendererTurbo bottom, top, north, east, south, west, core;
	private ModelRendererTurbo bottom_, top_, north_, east_, south_, west_;
	private ModelRendererTurbo[] array;
	
	//cause people are skeptic about round things.
	private static final int segments = 16;//TODO add config option for this;
	private static final int tx = 16, ty = 16;
	private static final float sl = 1f, rd = 2.4f, lg = 1f;
	private final RGB blue;
	private final RGB red;

	public PipeModel(){
		blue = new RGB(RGB.BLUE);
		blue.alpha = 0.18f;
		red = new RGB(RGB.RED);
		red.alpha = 0.18f;
		//
		bottom = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 bottom.addCylinder(0, -8F, 0, 2, 8, segments, 1f, 1f, ModelRendererTurbo.MR_BOTTOM);
		  bottom.setRotationPoint(0, 0, 0);
		//
		top = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 top.addCylinder(0, -16F, 0, 2, 8, segments, 1f, 1f, ModelRendererTurbo.MR_TOP);
		  top.setRotationPoint(0, 0, 0);
		//
		north = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 north.flip = true;
		  north.addCylinder(0, -8F, 0, 2, 8, segments, 1f, 1f, ModelRendererTurbo.MR_FRONT);
		   north.setRotationPoint(0, 0, 0);
		    north.rotateAngleY = Static.rad180;
		//
		east = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 east.addCylinder(0, -8F, 0, 2, 8, segments, 1f, 1f, ModelRendererTurbo.MR_LEFT);
		  east.setRotationPoint(0, 0, 0);
		    east.rotateAngleY = Static.rad180;
		//
		south = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 south.flip = true;
		  south.addCylinder(0, -8F, 0, 2, 8, segments, 1f, 1f, ModelRendererTurbo.MR_FRONT);
		   south.setRotationPoint(0, 0, 0);
		//
		west = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 west.addCylinder(0, -8F, 0, 2, 8, segments, 1f, 1f, ModelRendererTurbo.MR_LEFT);
		  west.setRotationPoint(0, 0, 0);
		    //west.rotateAngleY = Static.rad180;
		//
		core = new ModelRendererTurbo(this, 0, 0, 32, 32);
		 core.addBox(0, -8, 0, 4, 4, 4);
		  core.setRotationPoint(-2, -2, -2);
		//
		bottom_ = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 bottom_.addCylinder(0, -1, 0, rd, lg, segments, sl, sl, ModelRendererTurbo.MR_BOTTOM);
		  bottom_.setRotationPoint(0, 0, 0);
		//
		top_ = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 top_.addCylinder(0, -16, 0, rd, lg, segments, sl, sl, ModelRendererTurbo.MR_BOTTOM);
		  top_.setRotationPoint(0, 0, 0);
		//
		north_ = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 north_.flip = true;
		  north_.addCylinder(0, -8F, -8F, rd, lg, segments, sl, sl, ModelRendererTurbo.MR_FRONT);
		   north_.setRotationPoint(0, 0, 0);
		//
		south_ = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 south_.flip = true;
		  south_.addCylinder(0, -8F, 7F, rd, lg, segments, sl, sl, ModelRendererTurbo.MR_FRONT);
		   south_.setRotationPoint(0, 0, 0);
		//
		east_ = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 east_.addCylinder(7F, -8F, 0, rd, lg, segments, sl, sl, ModelRendererTurbo.MR_LEFT);
		  east_.setRotationPoint(0, 0, 0);
		    east_.rotateAngleY = Static.rad180;
		//
		west_ = new ModelRendererTurbo(this, 0, 0, tx, ty);
		 west_.addCylinder(7F, -8F, 0, rd, lg, segments, sl, sl, ModelRendererTurbo.MR_LEFT);
		  west_.setRotationPoint(0, 0, 0);
		//
		array = new ModelRendererTurbo[]{ bottom, top, north, south, west, east, bottom_, top_, north_, south_, west_, east_ };
	}

	@Override
	public void render(){
		bottom.render();
		 top.render();
		  north.render();
		   east.render();
		    south.render();
		     west.render();
		      core.render();
	}

	@Override
	public void render(PipeTileEntity type, Entity entity){
		if(type.axis != null){
			switch(type.axis){
				case X:
					west.render();
					east.render();
					break;
				case Y:
					bottom.render();
					   top.render();
					break;
				case Z:
					north.render();
					south.render();
					break;
			}
		}
		else{
			core.render();
			for(int i = 0; i < 6; i++){
				if(type.conn[i]){
					array[i].render();
				}
			}
		}
		for(int i = 6; i < 12; i++){
			if(!type.conn[i - 6] || array[i] == null){
				continue;
			}
			if(!type.mode[i - 6]){ blue.glColorApply(); } else { red.glColorApply(); }
			array[i].render();
			RGB.glColorReset();
		}
	}

	@Override
	public void translateAll(float x, float y, float z){
		bottom.rotationPointX += x;
		bottom.rotationPointY += y;
		bottom.rotationPointZ += z;
	}

	@Override
	public void rotateAll(float x, float y, float z){
		bottom.rotateAngleX += x;
		bottom.rotateAngleY += y;
		bottom.rotateAngleZ += z;
	}
	
}