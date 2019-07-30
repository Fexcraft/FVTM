package net.fexcraft.mod.fvtm.entity;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.lang.BitList;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.StreetSignItem;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.block.StreetSignModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StreetSign extends Entity implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {
	
    private boolean locked = false;
    public static final ResourceLocation[] textures = new ResourceLocation[]{
    	new ResourceLocation("fvtm:textures/entity/street_sign_0.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_1.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_2.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_3.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_4.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_5.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_6.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_7.png")
    };
    //To Sync
    public EnumFacing facing;
    public String[] text = new String[]{ "", "", "", "" };
    public boolean[] sides = new boolean[]{ true, true, true, true };
    public boolean[] centered = new boolean[]{ true, true, true, true };
    public boolean[] panels = new boolean[]{ true, true, true, true };
    public Boolean[] arrows = new Boolean[]{ null, null, null, null, false, false };
    public byte texture = 0;
    //
    @SideOnly(Side.CLIENT)
	public TurboList cachedmodel = new TurboList("cache");

    public StreetSign(World world){
        super(world); stepHeight = 0; setSize(0.75f, 0.75f); locked = false;
    }

    public StreetSign(World world, EnumFacing facing){
        this(world); this.facing = facing;
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
        buffer.writeByte(facing.getIndex());
        buffer.writeBoolean(locked);
        buffer.writeByte(texture);
        //
        for(int i = 0; i < 4; i++){
        	buffer.writeBoolean(sides[i]);
        }
        for(int i = 0; i < 4; i++){
        	buffer.writeBoolean(panels[i]);
        }
        for(int i = 0; i < 4; i++){
        	buffer.writeBoolean(centered[i]);
        }
        for(int i = 0; i < 6; i++){
        	buffer.writeByte(arrows[i] == null ? -1 : arrows[i] ? 1 : 0);
        }
        for(int i = 0; i < 4; i++){
        	buffer.writeInt(text[i].length());
        	buffer.writeCharSequence(text[i], StandardCharsets.UTF_8);
        }
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	facing = EnumFacing.getFront(buffer.readByte());
    	locked = buffer.readBoolean();
    	texture = buffer.readByte();
    	//
        for(int i = 0; i < 4; i++){
        	sides[i] = buffer.readBoolean();
        }
        for(int i = 0; i < 4; i++){
        	panels[i] = buffer.readBoolean();
        }
        for(int i = 0; i < 4; i++){
        	centered[i] = buffer.readBoolean();
        }
        for(int i = 0; i < 6; i++){
        	byte bit = buffer.readByte();
        	arrows[i] = bit < 0 ? null : bit > 0;
        }
        for(int i = 0; i < 4; i++){
        	text[i] = buffer.readCharSequence(buffer.readInt(), StandardCharsets.UTF_8).toString();
        }
        //
        if(world.isRemote){
        	this.recollectModel();
        }
    }
	
    @Override
	public void processClientPacket(PacketEntityUpdate pkt){
		try{ this.read(pkt.nbt); } catch(Exception e){ e.printStackTrace(); }
	}

    public void read(NBTTagCompound compound){
        BitList list = new BitList(); list.set(compound.getInteger("bitlist"));
        for(int i = 0; i < 4; i++){
            sides[i] = list.get(i); panels[i] = list.get(i + 4);
            text[i] = compound.getString("text" + i);
            centered[i] = text[i].startsWith("!");
            if(centered[i] && text[i].startsWith("!")){
            	text[i] = text[i].substring(1, text[i].length());
            }
        }
        for(int i = 0; i < 6; i++){
        	byte bit = compound.getByte("arrow" + i);
        	arrows[i] = bit < 0 ? null : bit > 0;
        }
        texture = compound.getByte("texture");
        //
        if(world.isRemote){
        	recollectModel();
        }
	}

    @SideOnly(Side.CLIENT)
	private void recollectModel(){
		for(ModelRendererTurbo turbo : cachedmodel)
			if(turbo.displaylist() != null)
				GL11.glDeleteLists(turbo.displaylist(), 1);
		cachedmodel.clear();
		//
		Print.debug(StreetSignModel.INSTANCE.groups);
		//
		if(panels[0]){
			cachedmodel.addAll(copyGroup("row3"));
			if(sides[3]) cachedmodel.add(copyTurbo("right", 3));
			if(sides[1]) cachedmodel.add(copyTurbo("left", 3));
		}
		if(panels[1]){
			cachedmodel.addAll(copyGroup("row2"));
			if(sides[3]) cachedmodel.add(copyTurbo("right", 2));
			if(sides[1]) cachedmodel.add(copyTurbo("left", 2));
		}
		if(panels[2]){
			cachedmodel.addAll(copyGroup("row1"));
			if(sides[3]) cachedmodel.add(copyTurbo("right", 1));
			if(sides[1]) cachedmodel.add(copyTurbo("left", 1));
		}
		if(panels[3]){
			cachedmodel.addAll(copyGroup("row0"));
			if(sides[3]) cachedmodel.add(copyTurbo("right", 0));
			if(sides[1]) cachedmodel.add(copyTurbo("left", 0));
		}
		//
		if(sides[0] && sides[1]){
			ArrayList<ModelRendererTurbo> list = copyGroup("corner_bl");
			int j = panels[0] ? 0 : panels[1] ? 1 : panels[2] ? 2 : panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.rotationPointY -= (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sides[1] && sides[2]){
			ArrayList<ModelRendererTurbo> list = copyGroup("corner_tl");
			int j = panels[3] ? 0 : panels[2] ? 1 : panels[1] ? 2 : panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.rotationPointY += (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sides[2] && sides[3]){
			ArrayList<ModelRendererTurbo> list = copyGroup("corner_tr");
			int j = panels[3] ? 0 : panels[2] ? 1 : panels[1] ? 2 : panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.rotationPointY += (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sides[3] && sides[0]){
			ArrayList<ModelRendererTurbo> list = copyGroup("corner_br");
			int j = panels[0] ? 0 : panels[1] ? 1 : panels[2] ? 2 : panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.rotationPointY -= (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sides[0]){
			ModelRendererTurbo turbo = copyTurbo("top_bot", 0);
			int j = panels[0] ? 0 : panels[1] ? 1 : panels[2] ? 2 : panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.rotationPointY -= (j * 4);
				cachedmodel.add(turbo);
			}
		}
		if(sides[2]){
			ModelRendererTurbo turbo = copyTurbo("top_bot", 1);
			int j = panels[3] ? 0 : panels[2] ? 1 : panels[1] ? 2 : panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.rotationPointY += (j * 4);
				cachedmodel.add(turbo);
			}
		}
		if(arrows[0] != null){ cachedmodel.add(copyTurbo("arrow_" + (arrows[0] ? "right" : "left"), 0)); }
		if(arrows[1] != null){ cachedmodel.add(copyTurbo("arrow_" + (arrows[1] ? "right" : "left"), 3)); }
		if(arrows[2] != null){ cachedmodel.add(copyTurbo("arrow_" + (arrows[2] ? "right" : "left"), 2)); }
		if(arrows[3] != null){ cachedmodel.add(copyTurbo("arrow_" + (arrows[3] ? "right" : "left"), 1)); }
		if(arrows[4] != null && arrows[4]){
			ModelRendererTurbo turbo = copyTurbo("arrow_top_bot", 0);
			int j = panels[0] ? 0 : panels[1] ? 1 : panels[2] ? 2 : panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.rotationPointY -= (j * 4);
				cachedmodel.add(turbo);
			}
		}
		if(arrows[5] != null && arrows[5]){
			ModelRendererTurbo turbo = copyTurbo("arrow_top_bot", 1);
			int j = panels[3] ? 0 : panels[2] ? 1 : panels[1] ? 2 : panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.rotationPointY += (j * 4);
				cachedmodel.add(turbo);
			}
		}
		//
	}

    private ModelRendererTurbo copyTurbo(String string, int i){
    	ModelRendererTurbo turbo = StreetSignModel.INSTANCE.groups.get(string).get(i);
		ModelRendererTurbo turbo0 = new ModelRendererTurbo(null).copyTo(turbo.getVertices(), turbo.getFaces());
		return turbo0.setRotationPoint(turbo.rotationPointX, turbo.rotationPointY, turbo.rotationPointZ);
	}

	@SideOnly(Side.CLIENT)
	private ArrayList<ModelRendererTurbo> copyGroup(String string){
    	ArrayList<ModelRendererTurbo> list = new ArrayList<>();
    	for(ModelRendererTurbo turbo : StreetSignModel.INSTANCE.groups.get(string)){
    		ModelRendererTurbo turbo0 = new ModelRendererTurbo(null).copyTo(turbo.getVertices(), turbo.getFaces());
			list.add(turbo0.setRotationPoint(turbo.rotationPointX, turbo.rotationPointY, turbo.rotationPointZ));
		} return list;
	}

	@Override
    protected void readEntityFromNBT(NBTTagCompound compound){
    	facing = EnumFacing.getFront(compound.getByte("facing"));
        locked = compound.getBoolean("locked");
        texture = compound.getByte("texture");
        //
        BitList list = new BitList(); list.set(compound.getInteger("bitlist"));
        for(int i = 0; i < 4; i++){
            sides[i] = list.get(i); panels[i] = list.get(i + 4); centered[i] = list.get(i + 8);
            text[i] = compound.getString("text" + i);
        }
        for(int i = 0; i < 6; i++){
        	byte bit = compound.getByte("arrow" + i);
        	arrows[i] = bit < 0 ? null : bit > 0;
        }
        //
        if(world.isRemote){
        	this.recollectModel();
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	compound.setByte("facing", (byte)facing.getIndex());
    	compound.setBoolean("locked", locked);
    	compound.setByte("texture", texture);
    	//
    	BitList list = new BitList(sides); list.integrate(panels, 4); list.integrate(centered, 8);
    	compound.setInteger("bitlist", list.toInt());
    	for(int i = 0; i < 6; i++){
    		compound.setByte("arrow" + i, (byte)(arrows[i] == null ? -1 : arrows[i] ? 1 : 0));
    		if(i < 4) compound.setString("text" + i, text[i]);
    	}
    }
    
	@Override
	public void setDead(){
		super.setDead();
		if(world.isRemote){
			for(ModelRendererTurbo turbo : cachedmodel) if(turbo.displaylist() != null) GL11.glDeleteLists(turbo.displaylist(), 1);
		}
	}

    @Override
    public void fall(float k, float l){
        //
    }

    @Override
    protected void entityInit(){
        //
    }

    @Override
    public void onUpdate(){
    	//
    }

    @Override
    public void setPositionAndRotationDirect(double d, double d1, double d2, float f, float f1, int i, boolean b){
        //
    }

    @Override
    public boolean canBePushed(){
        return false;
    }

    @Override
    public boolean canBeCollidedWith(){
        return !isDead;
    }

    @Override
    public void applyEntityCollision(Entity entity){
        return;
    }
    
    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
        if(isDead || world.isRemote || hand == EnumHand.OFF_HAND){
            return false;
        }
        ItemStack stack = player.getHeldItem(hand);
        if(!stack.isEmpty() && stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getType().isVehicleKey()){
            /*if(this.isLocked()){
                this.unlock(world, player, stack, (KeyItem)stack.getItem());
            }
            else{
                this.lock(world, player, stack, (KeyItem)stack.getItem());
            }*/
            return true;
        }
        if(locked){
            Print.chat(player, "Sign is locked.");
            return true;
        }
        if(stack.isEmpty()){
        	GenericGui.openGui("fvtm", 700, new int[]{ this.getEntityId(), 0, 0 }); return true;
        }
        return false;
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i){
        if(world.isRemote || isDead){
            return true;
        }
        if(damagesource.damageType.equals("player")){
            if(locked){
                Print.chat(damagesource.getImmediateSource(), "Sign is locked.");
                return true;
            }
        	ItemStack stack = this.getPickedResult(null);
            entityDropItem(stack, 0.5F); this.setDead();
        }
        return true;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target){
        return new ItemStack(StreetSignItem.INSTANCE);
    }

}
