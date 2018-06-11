package net.fexcraft.mod.fvtm.api;

import java.util.Map;
import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.api.root.Colorable.ColorHolder;
import net.fexcraft.mod.fvtm.api.root.Lockable;
import net.fexcraft.mod.fvtm.api.root.Saveloadable;
import net.fexcraft.mod.fvtm.api.root.SettingHolder;
import net.fexcraft.mod.fvtm.api.root.Textureable;
import net.fexcraft.mod.fvtm.api.root.Textureable.TextureHolder;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;
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
    public Model<BlockData, BlockTileEntity> getModel();

    public Class<? extends BlockData> getDataClass();
    
    public @Nullable Class<? extends BlockScript> getScriptClass();
    
    public Map<BlockPos, BlockIOT> getSubBlocks();
    
    public Map<String, Integer> getFluidTanks();
    
    public Map<String, Integer> getInventories();
    
	//<-- BLOCK IN/OUT Type-->//
    public static interface BlockIOT {
    	
    	public boolean hasGui(EnumFacing facing);
    	
    	public String getGuiType(EnumFacing facing);
    	
    	public boolean hasFluidTank(EnumFacing facing);
    	
    	public IFluidHandler getFluidTank(BlockData data, EnumFacing facing);
    	
    	public boolean hasInventory(EnumFacing facing);
    	
    	public IItemHandler getInventory(BlockData data, EnumFacing facing);
    	
    }

    //<-- BLOCK DATA -->//
    public static interface BlockData extends Colorable, Lockable, Saveloadable<BlockData>, Textureable {

        public Block getBlock();

        public @Nullable BlockScript getScript();

        public @Nullable <T extends BlockScript> T getScript(Class<T> clazz);
        
        public Map<String, IFluidHandler> getFluidTanks();
        
        public Map<String, IItemHandler> getInventories();
        
        public Map<String, NonNullList<ItemStack>> getItemStacks();

    }

    //<-- BLOCK TILE -->//
    public static interface BlockTileEntity {

        public TileEntity getTileEntity();
        
        public IBlockState getBlockState();
        
        public BlockData getBlockData();
        
        public long getLongPos();

    }

    //<-- BLOCK ITEM -->//
    public static interface BlockItem {

        public static final String NBTKEY = "FVTM:Block";
        public static final String OLDNBTKEY = "FVTM:Crafter";

        public BlockData getBlock(ItemStack stack);

    }

    public static interface BlockScript extends Saveloadable<BlockScript>, SettingHolder {

        public default void onDataPacket(TileEntity tile, BlockData data, NBTTagCompound compound, Side side){}

        public default void onPlace(TileEntity tile, BlockData data){}

        public default void onBreak(TileEntity tile, BlockData data){}

        public default boolean onInteract(TileEntity tile, BlockData data, EntityPlayer player, EnumHand hand){ return false; }

        public void onUpdate(TileEntity tile, BlockData data);
        
        @SideOnly(Side.CLIENT)
        public default void onGuiRender(TileEntity tile, EntityPlayer player, GuiContainer container){}

        public default void sendPacketToClient(TileEntity tile, EntityPlayer player, NBTTagCompound nbt){
            nbt.setBoolean("ScriptPacket", true);
            PacketHandler.getInstance().sendTo(new PacketTileEntityUpdate(tile.getWorld().provider.getDimension(), tile.getPos(), nbt), (EntityPlayerMP)player);
        }

        public default void sendPacketToAll(TileEntity tile, NBTTagCompound nbt){
            nbt.setBoolean("ScriptPacket", true);
            PacketHandler.getInstance().sendToAll(new PacketTileEntityUpdate(tile.getWorld().provider.getDimension(), tile.getPos(), nbt));
        }

        public default void sendPacketToAllAround(TileEntity tile, NBTTagCompound nbt){
            nbt.setBoolean("ScriptPacket", true);
            int dim = tile.getWorld().provider.getDimension();
            BlockPos pos = tile.getPos();
            PacketHandler.getInstance().sendToAllAround(new PacketTileEntityUpdate(dim, tile.getPos(), nbt), new TargetPoint(dim, pos.getX(), pos.getY(), pos.getZ(), 256));
        }

        public default void sendPacketToServer(TileEntity tile, NBTTagCompound nbt){
            nbt.setBoolean("ScriptPacket", true);
            PacketHandler.getInstance().sendToServer(new PacketTileEntityUpdate(tile.getWorld().provider.getDimension(), tile.getPos(), nbt));
        }

    }

}
