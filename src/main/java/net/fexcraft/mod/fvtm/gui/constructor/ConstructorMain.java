package net.fexcraft.mod.fvtm.gui.constructor;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_STATUS;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorMain extends ConstructorGui {

	public ConstructorMain(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		this.buttontext = new String[]{
			"gui.fvtm.constructor.main.status",
			"gui.fvtm.constructor.main.info",
			"gui.fvtm.constructor.main.lift",
			"",
			"gui.fvtm.constructor.main.part_cache",
			"gui.fvtm.constructor.main.part_manager",
			"gui.fvtm.constructor.main.part_installer",
			"",
			"gui.fvtm.constructor.main.texture",
			"gui.fvtm.constructor.main.color",
			"",
			"gui.fvtm.constructor.main.exit"};
	}
	
	@Override
	public void init(){
		this.buttons.put("icon_part", new IconButton("icon_part", 4, 0, false, ICON_REMOVE));
		this.buttons.put("icon_spawn", new IconButton("icon_spawn", 1, 1, false, ICON_EDIT0));
		this.buttons.put("icon_veh", new IconButton("icon_veh", 1, 0, false, ICON_CHECK));
		this.buttons.put("lift_up", new IconButton("icon_veh", 2, 1, false, ICON_UP));
		this.buttons.put("lift_dw", new IconButton("icon_veh", 2, 0, false, ICON_DOWN));
		super.init();
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(super.buttonClicked(mouseX, mouseY, mouseButton, key, button)) return true;
		if(button.name.equals("button11")){ player.closeScreen(); return true; }
		if(button.name.equals("button2")){
			if(buttons.get("lift_up").mousePressed(null, mouseX, mouseY)){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "lift");
				compound.setInteger("dir", -1); 
				this.titletext.update("Request sending to Server.", RGB_CYAN.packed);
				this.container.send(Side.SERVER, compound);
				return true;
			}
			if(buttons.get("lift_dw").mousePressed(null, mouseX, mouseY)){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "lift");
				compound.setInteger("dir", 1); 
				this.titletext.update("Request sending to Server.", RGB_CYAN.packed);
				this.container.send(Side.SERVER, compound);
				return true;
			}
			return true;
		}
		if(button.name.equals("button1")){
			if(buttons.get("icon_spawn").mousePressed(null, mouseX, mouseY)){
				this.titletext.update("Not available yet! Sorry!", null); return true;
			}
			if(buttons.get("icon_veh").mousePressed(null, mouseX, mouseY)){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "drop"); compound.setString("what", "any"); 
				this.titletext.update("Request sending to Server.", RGB_CYAN.packed);
				this.container.send(Side.SERVER, compound); return true;
			}
		}
		if(button.name.equals("button4") && buttons.get("icon_part").mousePressed(null, mouseX, mouseY)){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "drop"); compound.setString("what", "part"); 
			this.titletext.update("Request sending to Server.", RGB_CYAN.packed);
			this.container.send(Side.SERVER, compound); return true;
		}
		int gui = Integer.parseInt(button.name.replace("button", ""));
		if(gui == 8){
			if(container.getTileEntity().getVehicleData() == null
				&& container.getTileEntity().getContainerData() == null
				&& container.getTileEntity().getBlockData() == null){
				titletext.update("No Vehicle|Container|Block in Constructor.", null);
				return true;
			}
		}
		else if(gui == 9){
			if(container.getTileEntity().getVehicleData() == null
				&& container.getTileEntity().getContainerData() == null
				&& container.getTileEntity().getBlockData() == null){
				titletext.update("No Vehicle|Container|Block in Constructor.", null);
				return true;
			}
		}
		openGui(gui - (gui < 2 ? 0 : 1) + CONSTRUCTOR_STATUS, xyz, LISTENERID); return true;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}

}
