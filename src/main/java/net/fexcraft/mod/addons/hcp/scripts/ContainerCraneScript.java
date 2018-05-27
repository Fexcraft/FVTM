/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fexcraft.mod.addons.hcp.scripts;

import net.fexcraft.mod.addons.gep.attributes.FontRendererAttribute.FontData;
import net.fexcraft.mod.addons.gep.attributes.FontRendererAttribute.FontRendererAttributeData;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 * @author Ferdinand (FEX___96)
 */
public class ContainerCraneScript implements VehicleScript {
	
    private ContainerData data;
    private boolean xmove, ymove, zmove, stepwise;
    private int xdir, ydir, zdir, xsteptime, ysteptime, zsteptime;
	public int xpos, ypos, zpos;
	private int speed = 10;

    @Override
    public ResourceLocation getId(){
        return new ResourceLocation("hcp:container_crane");
    }

    @Override
    public void onDataPacket(Entity entity, Vehicle.VehicleData data, NBTTagCompound compound, Side side){
        this.readFromNBT(compound);
    }

    @Override
    public void onCreated(Entity entity, Vehicle.VehicleData data){
        
    }

    @Override
    public boolean onInteract(Entity entity, Vehicle.VehicleData data, EntityPlayer player, EnumHand hand){
    	if(player.getHeldItem(hand).getItem() instanceof PartItem){
    		PartData partdata = ((PartItem)player.getHeldItem(hand).getItem()).getPart(player.getHeldItem(hand));
    		if(partdata.getPart().getScripts().contains(ContainerCraneScript.class)){
    			player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_SCRIPTSGUI, entity.world, entity.getEntityId(), -1, 0);
    			return true;
    		}
    	}
        return false;
    }

    @Override
    public void onUpdate(Entity entity, Vehicle.VehicleData data){
    	VehicleEntity ent = (VehicleEntity)entity;
    	ent.setThrottle(0);
    	if(ent.getAxes().getRadianYaw() % 90 != 0){
			ent.getAxes().setRotation(Math.toRadians(round(ent.getAxes().getYaw())), ent.getAxes().getPitch(), ent.getAxes().getRoll());
    	}
    	boolean moved = false;
        if(xmove && xdir != 0){
        	if(stepwise && xsteptime > 0){
        		xsteptime--;
        	}
        	else{
        		xpos += xdir * speed;
            	if(xpos > 12000){ xpos = 12000; xmove = false; }
            	if(xpos < -12000){ xpos = -12000; xmove = false; }
            	moved = true;
            	if(xpos % 1000 == 0 && stepwise){
        			xsteptime = 40;
            	}
        	}
        }
        if(ymove && ydir != 0){
        	if(stepwise && ysteptime > 0){
        		ysteptime--;
        	}
        	else{
	        	ypos += ydir * speed;
	        	if(ypos > 0){ ypos = 0; ymove = false; }
	        	if(ypos < -6000){ ypos = -6000; ymove = false; }
	        	moved = true;
            	if(ypos % 1000 == 0 && stepwise){
        			ysteptime = 40;
            	}
        	}
        }
        if(zmove && zdir != 0){
        	if(stepwise && zsteptime > 0){
        		zsteptime--;
        	}
        	else{
	        	zpos += zdir * speed;
	        	if(zpos > 4000){ zpos = 4000; zmove = false; }
	        	if(zpos < -4000){ zpos = -4000; zmove = false; }
	        	moved = true;
            	if(zpos % 1000 == 0 && stepwise){
        			zsteptime = 40;
            	}
        	}
        }
        //
        FontRendererAttributeData attr = data.getPart("controller") == null ? null : data.getPart("controller").getAttributeData(FontRendererAttributeData.class);
        if(attr != null){
        	for(FontData font : attr.getLocations().values()){
        		switch(font.getId()){
	        		case "x_pos":{
	        			font.setString("x: " + xpos);
	        			break;
	        		}
					case "y_pos":{
	        			font.setString("y: " + ypos);		
						break;
					}
					case "z_pos":{
	        			font.setString("z: " + zpos);
						break;
					}
        		}
        	}
        }
        //TODO Y/Z
        //
        if(moved && !ent.getEntity().world.isRemote && ent.getEntity().ticksExisted % 10 == 0){
        	this.sendPacketToAllAround(entity, this.writeToNBT(null));
        }
    }

    private double round(double x){
		if(x > -360 && x <= -315){ return    0; }
		if(x > -315 && x <= -225){ return -270; }
		if(x > -225 && x <= -135){ return -180; }
		if(x > -135 && x <=  -45){ return  -90; }
		if(x >  -45 && x <=   45){ return    0; }
		if(x >   45 && x <=  135){ return   90; }
		if(x >  135 && x <=  225){ return  180; }
		if(x >  225 && x <=  315){ return  270; }
		if(x >  315 && x <=  360){ return    0; }
		return 0;
	}

	@Override
    public void onRemove(Entity entity, Vehicle.VehicleData data){
        data = null;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        if(compound != null && data != null){
            data.writeToNBT(compound);
        }
        compound = compound == null ? new NBTTagCompound() : compound;
        compound.setBoolean("xmove", xmove);
        compound.setBoolean("ymove", ymove);
        compound.setBoolean("zmove", zmove);
        compound.setInteger("xdir", xdir);
        compound.setInteger("ydir", ydir);
        compound.setInteger("zdir", zdir);
        compound.setInteger("xpos", xpos);
        compound.setInteger("ypos", ypos);
        compound.setInteger("zpos", zpos);
        compound.setInteger("speed", speed);
        compound.setBoolean("stepwise", stepwise);
        compound.setIntArray("steptime", new int[]{ xsteptime, ysteptime, zsteptime });
        return compound;
    }

    @Override
    public VehicleScript readFromNBT(NBTTagCompound compound){
        if(compound.hasKey(ContainerItem.NBTKEY)){
            data = Resources.getContainerData(compound);
        }
        if(compound.hasKey("reset_container") && compound.getBoolean("reset_container")){
        	data = null;
        }
        xmove = compound.getBoolean("xmove");
        ymove = compound.getBoolean("ymove");
        zmove = compound.getBoolean("zmove");
        xdir = compound.getInteger("xdir");
        ydir = compound.getInteger("ydir");
        zdir = compound.getInteger("zdir");
        xpos = compound.getInteger("xpos");
        ypos = compound.getInteger("ypos");
        zpos = compound.getInteger("zpos");
        speed = compound.getInteger("speed");
        stepwise = compound.getBoolean("stepwise");
        int[] steptime = compound.getIntArray("steptime");
        if(steptime != null && steptime.length >= 3){
        	xsteptime = steptime[0]; ysteptime = steptime[1]; zsteptime = steptime[2];
        }
        return this;
    }

	@Override
	public Object getSettingsValue(String setting){
		switch(setting){
			case "x-move": return xmove;
			case "y-move": return ymove;
			case "z-move": return zmove;
			case "x-direction": return xdir;
			case "y-direction": return ydir;
			case "z-direction": return zdir;
			case "trycatch": return "> > > >";
			case "release": return "< < < <";
			case "speed": return speed;
			case "stepwise": return stepwise;
		}
		return "";
	}

	@Override
	public ScriptSetting<?>[] getSettings(int seat){
		if(seat > 0){ return null; }
		return new ScriptSetting[]{
			new ScriptSetting<ContainerCraneScript>(this, "trycatch", ScriptSetting.Type.BUTTON){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					script.tryCatch(player);
					script.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript>(this, "release", ScriptSetting.Type.BUTTON){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					script.tryRelease(player);
					script.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript>(this, "x-move", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					script.xmove = i == 0 ? false : i == 1 ? true : script.xmove;
					script.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript>(this, "y-move", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					script.ymove = i == 0 ? false : i == 1 ? true : script.ymove;
					script.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript>(this, "z-move", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					script.zmove = i == 0 ? false : i == 1 ? true : script.zmove;
					script.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript>(this, "x-direction", ScriptSetting.Type.INTEGER){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					script.xdir += i;
					if(script.xdir > 1){ script.xdir = 1; }
					if(script.xdir < -1){ script.xdir = -1; }
					script.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript>(this, "y-direction", ScriptSetting.Type.INTEGER){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					script.ydir += i;
					if(script.ydir > 1){ script.ydir = 1; }
					if(script.ydir < -1){ script.ydir = -1; }
					script.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript>(this, "z-direction", ScriptSetting.Type.INTEGER){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					script.zdir += i;
					if(script.zdir > 1){ script.zdir = 1; }
					if(script.zdir < -1){ script.zdir = -1; }
					script.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript>(this, "speed", ScriptSetting.Type.INTEGER){
				@Override
				public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
					if(i > 0){
						switch(speed){
							case  0: speed = 10; break;
							case 10: speed = 20; break;
							case 20: speed = 50; break;
							default: speed = 50; break;
						}
					}
					else{
						switch(speed){
							case 10: speed =  0; break;
							case 20: speed = 10; break;
							case 50: speed = 20; break;
							default: speed =  0; break;
						}
					}
					script.updateClient(player, entity);
				}
			},
			new ScriptSetting<ContainerCraneScript>(this, "stepwise", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
					stepwise = i == 0 ? false : i == 1 ? true : stepwise;
					script.updateClient(player, entity);
				}
			}
		};
	}

	protected void updateClient(EntityPlayer player, Entity ent){
		this.sendPacketToClient(ent, player, this.writeToNBT(null));
	}

	protected void tryRelease(EntityPlayer player){
		xmove = ymove = zmove = false;
		Print.chat(player, "//TODO");
		return;
	}

	protected void tryCatch(EntityPlayer player){
		xmove = ymove = zmove = false;
		Print.chat(player, "//TODO");
		return;
	}
    
}
