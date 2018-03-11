package net.fexcraft.mod.fvtm.blocks;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class ConstructorControllerEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {
	
	public VehicleData vehicledata;
	public PartData partdata;
	public double liftstate;
	public byte lift;
	public BlockPos center;
	//
	private byte lc;
	
	@Override
	public void update(){
		if(lift != 0){
			if(lc == Time.getSecond()){
				return;
			}
			lc = (byte)Time.getSecond();
			this.liftstate += -(lift * 0.01);
			if(liftstate <= 0){
				liftstate = 0;
				lift = 0;
				return;
			}
			if(liftstate >= 4.5f){
				liftstate = 4.5f;
				lift = 0;
				return;
			}
			this.sendUpdate("lift");
		}
		return;
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.getUpdateTag());
	}
	
	@Override
	public NBTTagCompound getUpdateTag(){
		NBTTagCompound compound = super.writeToNBT(new NBTTagCompound());
		if(this.vehicledata != null){
			compound = this.vehicledata.writeToNBT(compound);
		}
		compound.setDouble("LiftState", liftstate);
		compound.setByte("Lift", lift);
		return compound;
	}
	
	public void sendUpdate(String string){
		NBTTagCompound compound = null;
		if(string != null){
			compound = new NBTTagCompound();
			switch(string){
				case "lift":{
					compound.setDouble("liftstate", liftstate);
					compound.setByte("lift", lift);
					break;
				}
				case "center":{
					compound.setBoolean("center_con", center != null);
					if(center != null){
						compound.setLong("center", center.toLong());
					}
					break;
				}
				case "vehicle":
				case "vehicledata":{
					if(vehicledata != null){
						vehicledata.writeToNBT(compound);
					}
					break;
				}
				case "part":
				case "partdata":{
					if(partdata != null){
						partdata.writeToNBT(compound);
					}
					break;
				}
				case "rgb":
				case "color":{
					compound.setInteger("primary_rgb", vehicledata.getPrimaryColor().getColorInt());
					compound.setInteger("secondary_rgb", vehicledata.getSecondaryColor().getColorInt());
					break;
				}
			}
		}
		else{
			compound = getUpdateTag();
			compound.setBoolean("default", true);
		}
		ApiUtil.sendTileEntityUpdatePacket(world, pos, compound);
	}
	
	@Override
	public void processClientPacket(PacketTileEntityUpdate pkt){
		if(pkt.nbt.hasKey("default") && pkt.nbt.getBoolean("default")){
			this.readFromNBT(pkt.nbt);
		}
		else{
			NBTTagCompound com = pkt.nbt;
			lift = com.hasKey("lift") ? com.getByte("lift") : lift;
			liftstate = com.hasKey("liftstate") ? com.getDouble("liftstate") : liftstate;
			VehicleData data = Resources.getVehicleData(com, world.isRemote);
			if(data != null){
				vehicledata = data;
			}
			PartData pdata = Resources.getPartData(com);
			if(pdata != null){
				partdata = pdata;
			}
			if(com.hasKey("center_con")){
				center = com.getBoolean("center_con") ? BlockPos.fromLong(com.getLong("center")) : null;
			}
			if(com.hasKey("primary_rgb")){
				vehicledata.getPrimaryColor().packed = com.getInteger("primary_rgb");
			}
			if(com.hasKey("secondary_rgb")){
				vehicledata.getSecondaryColor().packed = com.getInteger("secondary_rgb");
			}
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		if(this.vehicledata != null){
			compound = vehicledata.writeToNBT(compound);
		}
		compound.setDouble("LiftState", liftstate);
		if(center != null){
			compound.setLong("Center", center.toLong());
		}
		if(partdata != null){
			compound = this.partdata.writeToNBT(compound);
		}
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		this.vehicledata = Resources.getVehicleData(compound, world.isRemote);
		this.liftstate = compound.getFloat("LiftState");
		this.center = compound.hasKey("Center") ? BlockPos.fromLong(compound.getLong("Center")) : null;
		this.partdata = Resources.getPartData(compound);
	}
	
	public void scanAndConnect(EntityPlayer player){
		ArrayList<ConstructorCenterEntity> list = new ArrayList<ConstructorCenterEntity>();
		int x = pos.getX() - 8;
		int y = pos.getY();
		int z = pos.getZ() - 8;
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 16; j++){
				TileEntity tile = world.getTileEntity(new BlockPos(x + i, y, z + j));
				if(tile != null && tile instanceof ConstructorCenterEntity){
					list.add((ConstructorCenterEntity)tile);
				}
				tile = world.getTileEntity(new BlockPos(x + i, y - 1, z + j));
				if(tile != null && tile instanceof ConstructorCenterEntity){
					list.add((ConstructorCenterEntity)tile);
				}
				tile = world.getTileEntity(new BlockPos(x + i, y + 1, z + j));
				if(tile != null && tile instanceof ConstructorCenterEntity){
					list.add((ConstructorCenterEntity)tile);
				}
			}
		}
		for(ConstructorCenterEntity entity : list){
			if(entity.getConstructor() == null || world.getTileEntity(entity.getConstructor()) == null){
				entity.link(new BlockPos(this.pos));
				Print.chat(player, "&aConnected&7!");
				this.center = new BlockPos(entity.getPos());
				this.sendUpdate("center");
				return;
			}
		}
		Print.chat(player, "&7No &aFree &7Center Block found!");
	}
	
	public void setData(VehicleItem item, ItemStack stack){
		this.vehicledata = item.getVehicle(stack);
	}
	
	public VehicleData getVehicleData(){
		return this.vehicledata;
	}

	public void setPartData(PartData data){
		if(this.partdata != null && data != null){
			ItemStack stack = this.partdata.getPart().getItemStack(partdata);
			EntityItem entity = new EntityItem(world, this.pos.getX() + 0.5, this.pos.getY() + 1.5f, this.pos.getZ() + 0.5, stack);
			world.spawnEntity(entity);
			this.partdata = null;
		}
		this.partdata = data;
	}
	
	public void recycleVehicle(){
		ArrayList<EntityItem> list = new ArrayList<EntityItem>();
		ArrayList<String> slist = new ArrayList<String>();
		vehicledata.getParts().forEach((as, data) -> {
			if(!vehicledata.getVehicle().getPreinstalledParts().values().contains(data.getPart().getRegistryName())){
				EntityItem item = new EntityItem(world);
				item.setItem(data.getPart().getItemStack(data));
				item.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
				list.add(item);
				slist.add(as);
			}
		});
		for(String string : slist){
			vehicledata.getParts().remove(string);
		}
		//
		EntityItem item = new EntityItem(world);
		item.setItem(vehicledata.getVehicle().getItemStack(vehicledata));
		item.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
		list.add(item);
		//
		list.forEach((entity) -> {
			world.spawnEntity(entity);
		});
		this.vehicledata = null;
		this.sendUpdate(null);
	}
	
	public void addLift(int i){
		this.lift += i;
		if(this.lift > 10){
			this.lift = 10;
		}
		if(this.lift < -10){
			this.lift = -10;
		}
		this.sendUpdate("lift");
	}

	public void onButtonPress(ConstructorButton button, EntityPlayer player, String[] args){
		if(button.ID == 0){
			ItemStack stack = vehicledata.getVehicle().getItemStack(vehicledata);
			EntityItem item = new EntityItem(world);
			item.setItem(stack);
			item.setPosition(this.pos.getX() + 0.5f, this.pos.getY(), this.pos.getZ() + 0.5f);
			world.spawnEntity(item);
			this.vehicledata = null;
			this.liftstate = 0;
			this.lift = 0;
			this.sendUpdate(null);
			return;
		}
		else if(button.ID == 1){
			//TODO open "spawn as" screen
			return;
		}
		return;
	}
	
	/*public static class Server extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable, ConstructorEntity {
		
		private VehicleData vehicledata;
		private PartData partdata;
		private byte lift = 0, selection = 0, scroll = 0;
		private int lc = -1;
		private double liftstate = 0;
		private byte brush = 1;
		private BlockPos center;
		private String window = "main";//Don't save/sync this! Should reset on every world load.
		private int sel;
		
		public void setData(VehicleItem item, ItemStack stack){
			this.updateVehicleData(item.getVehicle(stack));
			this.updateScreenId(null);
		}
		
		@Override
		public VehicleData getVehicleData(){
			return this.vehicledata;
		}

		public void setPartData(PartData data){
			if(this.partdata != null && data != null){
				ItemStack stack = this.partdata.getPart().getItemStack(partdata);
				EntityItem entity = new EntityItem(world, this.pos.getX() + 0.5, this.pos.getY() + 1.5f, this.pos.getZ() + 0.5, stack);
				world.spawnEntity(entity);
				this.partdata = null;
			}
			this.partdata = data;
			//this.updateLandVehicle(null);
			if(this.window.equals("part_add_new")){
				this.updateScreenId("part_view_cache");
			}
		}

		@Override
		public PartData getPartData(){
			return this.partdata;
		}
		
		public BlockPos getCenterPos(){
			return center;
		}

		@Override
		public void setCenterPos(BlockPos pos){
			this.center = pos;
		}
		
		public byte getLift(){
			return lift;
		}

		public void addLift(int i){
			this.lift += i;
			if(this.lift > 10){
				this.lift = 10;
			}
			if(this.lift < -10){
				this.lift = -10;
			}
			this.updateLift();
		}

		@Override
		public void update(){
			if(lift != 0){
				if(lc == Time.getSecond()){
					return;
				}
				lc = Time.getSecond();
				this.liftstate += -(lift * 0.01);
				if(liftstate <= 0){
					liftstate = 0;
					lift = 0;
					this.updateLift();
					return;
				}
				if(liftstate >= 4.5f){
					liftstate = 4.5f;
					lift = 0;
					this.updateLift();
					return;
				}
				this.updateLiftState();
			}
			return;
		}
		
		@Override
		public void processServerPacket(PacketTileEntityUpdate pkt){
			//
		}
		
		@Override
		public SPacketUpdateTileEntity getUpdatePacket(){
			return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.getUpdateTag());
		}
		
		@Override
		public NBTTagCompound getUpdateTag(){
			NBTTagCompound compound = super.writeToNBT(new NBTTagCompound());
			if(this.vehicledata != null){
				compound = this.vehicledata.writeToNBT(compound);
			}
			compound.setDouble("LiftState", liftstate);
			compound.setByte("Lift", lift);
			compound = getWindowUpdate(compound);
			compound.setByte("Selection", selection);
			return compound;
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound compound){
			super.writeToNBT(compound);
			if(this.vehicledata != null){
				compound = vehicledata.writeToNBT(compound);
			}
			compound.setDouble("LiftState", liftstate);
			//compound.setByte("Selection", selection);
			//compound.setByte("Scroll", scroll);
			if(center != null){
				compound.setLong("Center", center.toLong());
			}
			if(partdata != null){
				compound = this.partdata.writeToNBT(compound);
			}
			return compound;
		}
		
		@Override
		public void readFromNBT(NBTTagCompound compound){
			super.readFromNBT(compound);
			this.vehicledata = Resources.getVehicleData(compound, false);
			this.liftstate = compound.getFloat("LiftState");
			//this.selection = compound.getByte("Selection");
			//this.scroll = compound.getByte("Scroll");
			if(compound.hasKey("Center")){
				this.center = BlockPos.fromLong(compound.getLong("Center"));
			}
			this.partdata = Resources.getPartData(compound);
		}

		public void onButtonPress(ConstructorButton button, EntityPlayer player, String[] args){
			if(button.isHome()){
				this.updateScreenId("main");
			}
			else if(button.ID < 2){
				if(button.ID < 0){
					return;
				}
				else if(button.ID == 0){
					ItemStack stack = vehicledata.getVehicle().getItemStack(vehicledata);
					EntityItem item = new EntityItem(world);
					item.setItem(stack);
					item.setPosition(this.pos.getX() + 0.5f, this.pos.getY(), this.pos.getZ() + 0.5f);
					world.spawnEntity(item);
					this.vehicledata = null;
					this.updateVehicleData(null);
					this.updateScreenId("main");
					return;
				}
				else{
					this.updateScreenId("spawn_as");
					return;
				}
			}
			ConstructorScreen scr = ConstructorScreen.getScreen(window);
			if(!(scr == null)){
				scr.onButtonPress(this, button, player, args);
			}
			else{
				if(button.isReturn()){
					this.updateScreenId("main");
				}
				//this.updateScreenId("main");
			}
			return;
		}

		@Override
		public void openInputGui(EntityPlayer player){
			this.updateScreenId(window, false);
			Print.chat(player, "&c&oOpening input GUI...");
			player.openGui(FVTM.getInstance(), GuiHandler.CONSTRUCTOR_INPUT, world, this.pos.getX(), this.pos.getY(), this.pos.getZ());
		}

		public void scanAndConnect(EntityPlayer player){
			ArrayList<ConstructorCenterEntity> list = new ArrayList<ConstructorCenterEntity>();
			int x = pos.getX() - 8;
			int y = pos.getY();
			int z = pos.getZ() - 8;
			for(int i = 0; i < 16; i++){
				for(int j = 0; j < 16; j++){
					TileEntity tile = world.getTileEntity(new BlockPos(x + i, y, z + j));
					if(tile != null && tile instanceof ConstructorCenterEntity){
						list.add((ConstructorCenterEntity)tile);
					}
					tile = world.getTileEntity(new BlockPos(x + i, y - 1, z + j));
					if(tile != null && tile instanceof ConstructorCenterEntity){
						list.add((ConstructorCenterEntity)tile);
					}
					tile = world.getTileEntity(new BlockPos(x + i, y + 1, z + j));
					if(tile != null && tile instanceof ConstructorCenterEntity){
						list.add((ConstructorCenterEntity)tile);
					}
				}
			}
			for(ConstructorCenterEntity entity : list){
				if(entity.getConstructor() == null || world.getTileEntity(entity.getConstructor()) == null){
					entity.link(new BlockPos(this.pos));
					Print.chat(player, "&aConnected&7!");
					this.center = new BlockPos(entity.getPos());
					return;
				}
			}
			Print.chat(player, "&7No &aFree &7Center Block found!");
		}

		private final NBTTagCompound getWindowUpdate(NBTTagCompound compound){
			ConstructorScreen scr = ConstructorScreen.getScreen(window);
			if(!(scr == null)){
				scr.getScreenUpdate(this, compound);
				return compound;
			}
			return compound;
		}
		
		private void updateLiftState(){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_liftstate");
			compound.setDouble("LiftState", liftstate);
			ApiUtil.sendTileEntityUpdatePacket(this, compound, 256);
		}
		
		private void updateLift(){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_lift");
			compound.setByte("Lift", lift);
			ApiUtil.sendTileEntityUpdatePacket(this, compound, 256);
		}

		@Override
		public void updateVehicleData(VehicleData data){
			if(data != null){
				this.vehicledata = data;
			}
			//this.writeToNBT(this.getTileData());
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("task", "update_vehicledata");
			ApiUtil.sendTileEntityUpdatePacket(this, vehicledata == null ? nbt : vehicledata.writeToNBT(nbt), 256);
		}

		@Override
		public void setVehicleData(VehicleData data){
			this.vehicledata = data;
		}

		public int getSelection(){
			return selection;
		}

		public void setSelection(int i){
			selection = (byte)(i > 7 ? 7 : i < -1 ? -1 : i);
		}
		
		@Override
		public void updateSelection(int i, boolean b){
			if(i == -10){ this.selection = -1; }
			else{
				if(b){
					if(selection == 0 && i == -1){
						scroll -= 1;
						if(scroll < 0){
							scroll = 0;
						}
						this.updateScreenId(null, false);
					}
					else if(selection == 7 && i == 1){
						scroll++;
						this.updateScreenId(null, false);
					}
				}
				//
				this.selection += i;
				if(selection < -1){ selection = -1; }
				if(selection > 7){ selection = 7; }
				if(b && selection < 0) { selection = 0; }
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_selection");
			compound.setByte("Selection", selection);
			ApiUtil.sendTileEntityUpdatePacket(this, compound, 256);
		}
		
		@Override
		public String getScreenId(){
			return window;
		}
		
		@Override
		public void updateScreenId(String string, boolean selres){
			if(string != null){
				window = string;
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("task", "update_screen");
			compound.setString("window", window);
			ApiUtil.sendTileEntityUpdatePacket(this, this.getWindowUpdate(compound), 256);
			if(selres){
				this.updateSelection(-10);
			}
		}

		@Override
		public void recycleVehicle(){
			ArrayList<EntityItem> list = new ArrayList<EntityItem>();
			ArrayList<String> slist = new ArrayList<String>();
			vehicledata.getParts().forEach((as, data) -> {
				if(!vehicledata.getVehicle().getPreinstalledParts().values().contains(data.getPart().getRegistryName())){
					EntityItem item = new EntityItem(world);
					item.setItem(data.getPart().getItemStack(data));
					item.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
					list.add(item);
					slist.add(as);
				}
			});
			for(String string : slist){
				vehicledata.getParts().remove(string);
			}
			//
			EntityItem item = new EntityItem(world);
			item.setItem(vehicledata.getVehicle().getItemStack(vehicledata));
			item.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
			list.add(item);
			//
			list.forEach((entity) -> {
				world.spawnEntity(entity);
			});
			this.vehicledata = null;
			this.updateVehicleData(null);
			this.updateScreenId("main");
		}

		@Override
		public byte getBrush(){
			return brush;
		}

		@Override
		public void setBrush(byte b){
			brush = b;
			brush = brush < 0 ? 0 : brush;
		}

		@Override
		public void updateColour(String str, RGB rgb){
			if(str == null && vehicledata != null){
				{
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setString("task", "update_colour");
					nbt.setString("type", "primary");
					nbt = vehicledata.getPrimaryColor().writeToNBT(nbt, null);
					ApiUtil.sendTileEntityUpdatePacket(this, nbt, 256);
				}
				{
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setString("task", "update_colour");
					nbt.setString("type", "secondary");
					nbt = vehicledata.getSecondaryColor().writeToNBT(nbt, null);
					ApiUtil.sendTileEntityUpdatePacket(this, nbt, 256);
				}
				return;
			}
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("task", "update_colour");
			nbt.setString("type", str);
			nbt = rgb.writeToNBT(nbt, null);
			ApiUtil.sendTileEntityUpdatePacket(this, nbt, 256);
		}

		@Override
		public int getSelPart(){
			return sel;
		}

		@Override
		public void setSelPart(int i){
			sel = 1;
		}

		@Override
		public int getScroll(){
			return scroll;
		}

		@Override
		public void setScroll(int i){
			scroll = 1;
		}
		
	}
	
	public static class Client extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>{
		
		public VehicleData vehicledata;
		public double liftstate = 0;
		public String[] text = new String[8];
		public String window;
		public byte selection = -1, lift = 0;
		@SuppressWarnings("unused")
		private BlockPos center;
		
		@Override
		public void processClientPacket(PacketTileEntityUpdate pkt){
			if(!pkt.nbt.hasKey("task")){
				return;
			}
			window = pkt.nbt.hasKey("window") ? pkt.nbt.getString("window") : "null";
			switch(pkt.nbt.getString("task")){
				case "update_vehicledata":{
					this.vehicledata = Resources.getVehicleData(pkt.nbt, world.isRemote);
					if(this.vehicledata == null){
						Print.debug("NO VEHICLE NBT KEY FOUND, RESETTING!");
					}
					break;
				}
				case "update_screen":{
					this.parseScreen(pkt.nbt);
					break;
				}
				case "update_liftstate":{
					this.liftstate = pkt.nbt.getDouble("LiftState");
					break;
				}
				case "update_lift":{
					this.lift = pkt.nbt.getByte("Lift");
					break;
				}
				case "update_selection":{
					this.selection = pkt.nbt.getByte("Selection");
					break;
				}
				case "crash_menu_request":{
					Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, pkt.nbt.getString("Message"));
					Static.halt();
					break;
				}
				case "update_colour":{
					RGB rgb = pkt.nbt.getString("type").equals("primary") ? this.vehicledata.getPrimaryColor() : this.vehicledata.getSecondaryColor();
					rgb.readFromNBT(pkt.nbt, null);
					break;
				}
			}
			Print.debug(pkt.nbt);
		}
		
		@Override
		public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
			this.readFromNBT(pkt.getNbtCompound());
	    }
		
		@Override
		public void readFromNBT(NBTTagCompound compound){
			super.readFromNBT(compound);
			this.vehicledata = Resources.getVehicleData(compound, world.isRemote);
			this.liftstate = compound.getFloat("LiftState");
			this.lift = compound.getByte("Lift");
			this.parseScreen(compound);
			this.selection = compound.getByte("Selection");
			if(compound.hasKey("Center")){
				this.center = BlockPos.fromLong(compound.getLong("Center"));
			}
		}
		
		private void parseScreen(NBTTagCompound compound){
			for(int i =0; i < text.length; i++){
				text[i] = compound.getString("Text" + i);
			}
		}
		
		@SideOnly(Side.CLIENT)
	    public double getMaxRenderDistanceSquared(){
	        return 512D;
	    }
		
	}*/	
	
}