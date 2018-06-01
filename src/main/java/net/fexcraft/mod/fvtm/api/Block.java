package net.fexcraft.mod.fvtm.api;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.api.root.Colorable.ColorHolder;
import net.fexcraft.mod.fvtm.api.root.Lockable;
import net.fexcraft.mod.fvtm.api.root.Saveloadable;
import net.fexcraft.mod.fvtm.api.root.SettingHolder;
import net.fexcraft.mod.fvtm.api.root.Textureable;
import net.fexcraft.mod.fvtm.api.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.model.block.BlockModel;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Block extends IForgeRegistryEntry<Block>, TextureHolder, ColorHolder {

    public Addon getAddon();

    public String getName();

    public String[] getDescription();

    @Override
    public default Class<Block> getRegistryType(){
        return Block.class;
    }

    public boolean isFunctional();

    public default boolean isDecorational(){
    	return !isFunctional();
    }

    public ItemStack getItemStack(@Nullable BlockData data);

    @SideOnly(Side.CLIENT)
    public BlockModel<BlockData> getModel();

    public Class<? extends BlockData> getDataClass();

    public ResourceLocation getDefaultKey();
    
    public @Nullable Class<? extends BlockScript<?>> getScript();

    //<-- BLOCK DATA -->//
    public static interface BlockData extends Colorable, Lockable, Saveloadable<BlockData>, Textureable {

        public Block getBlock();

        public @Nullable <T extends BlockScript<?>> T getScript();

    }

    //<-- BLOCK TILE -->//
    public static interface BlockTileEntity {

        public TileEntity getTileEntity();
        
        public IBlockState getBlockState();

    }

    //<-- BLOCK ITEM -->//
    public static interface BlockItem {

        public static final String NBTKEY = "FVTM:Block";
        public static final String OLDNBTKEY = "FVTM:Crafter";

        public BlockData getBlock(ItemStack stack);

    }

    public static interface BlockScript<T extends BlockTileEntity> extends Saveloadable<BlockScript<?>>, SettingHolder {

        public void onDataPacket(T tile, BlockData data, NBTTagCompound compound, Side side);

        public void onPlace(T tile, BlockData data);

        public void onBreak(T tile, BlockData data);

        public boolean onInteract(T tile, BlockData data, EntityPlayer player, EnumHand hand);

        public void onUpdate(T tile, BlockData data);
        
        @SideOnly(Side.CLIENT)
        public void onGuiRender(BlockTileEntity tile, EntityPlayer player, GuiContainer container);

        public default void sendPacketToClient(T tile, EntityPlayer player, NBTTagCompound nbt){
            nbt.setBoolean("ScriptPacket", true);
            PacketHandler.getInstance().sendTo(new PacketTileEntityUpdate(tile.getTileEntity().getWorld().provider.getDimension(), tile.getTileEntity().getPos(), nbt), (EntityPlayerMP)player);
        }

        public default void sendPacketToAll(T tile, NBTTagCompound nbt){
            nbt.setBoolean("ScriptPacket", true);
            PacketHandler.getInstance().sendToAll(new PacketTileEntityUpdate(tile.getTileEntity().getWorld().provider.getDimension(), tile.getTileEntity().getPos(), nbt));
        }

        public default void sendPacketToAllAround(T tile, NBTTagCompound nbt){
            nbt.setBoolean("ScriptPacket", true);
            int dim = tile.getTileEntity().getWorld().provider.getDimension();
            BlockPos pos = tile.getTileEntity().getPos();
            PacketHandler.getInstance().sendToAllAround(new PacketTileEntityUpdate(dim, tile.getTileEntity().getPos(), nbt), new TargetPoint(dim, pos.getX(), pos.getY(), pos.getZ(), 256));
        }

        public default void sendPacketToServer(Entity ent, NBTTagCompound nbt){
            nbt.setBoolean("ScriptPacket", true);
            PacketHandler.getInstance().sendToServer(new PacketEntityUpdate(ent, nbt));
        }

    }

}
