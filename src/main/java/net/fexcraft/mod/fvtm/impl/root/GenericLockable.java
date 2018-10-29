package net.fexcraft.mod.fvtm.impl.root;

import net.fexcraft.lib.mc.api.KeyItem;
import net.fexcraft.mod.fvtm.api.root.Lockable;
import net.minecraft.nbt.NBTTagCompound;

@SuppressWarnings("deprecation")
public class GenericLockable<T, B> extends GenericTextureable<T, B> implements Lockable {

    protected boolean locked;
    protected String lockcode;

    public GenericLockable(B base){
        super(base);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        compound.setBoolean("Locked", locked);
        compound.setString("LockCode", lockcode == null ? KeyItem.getNewKeyCode() : lockcode);
        return compound;
    }

    @Override
    public T readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        this.locked = compound.getBoolean("Locked");
        this.lockcode = compound.hasKey("LockCode") ? compound.getString("LockCode") : KeyItem.getNewKeyCode();
        return null;
    }

    @Override
    public boolean isLocked(){
        return locked;
    }

    @Override
    public boolean setLocked(Boolean lock){
        return lock == null ? (locked = !locked) : (locked = lock);
    }

    @Override
    public String getLockCode(){
        return lockcode;
    }

}
