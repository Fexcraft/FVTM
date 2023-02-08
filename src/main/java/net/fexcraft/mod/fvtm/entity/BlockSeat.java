package net.fexcraft.mod.fvtm.entity;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.TrafficSignItem;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.TSEDITOR;

public class BlockSeat extends Entity {

    public BlockSeat(World world){
        super(world);
        stepHeight = 0;
        setSize(0.25f, 0.25f);
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
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int i, boolean t){
        //
    }

    @Override
    public boolean canBePushed(){
        return false;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        setDead();
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

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
    public void removePassenger(Entity passenger){
        super.removePassenger(passenger);
        setDead();
    }

    @Override
    public double getYOffset(){
        return 0;
    }

    @Override
    public double getMountedYOffset(){
        return 0;
    }

}
