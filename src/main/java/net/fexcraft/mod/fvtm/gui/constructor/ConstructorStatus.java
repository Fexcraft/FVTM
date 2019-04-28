package net.fexcraft.mod.fvtm.gui.constructor;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.gui.ConstructorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ConstructorStatus extends ConstructorGui {

	public ConstructorStatus(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z); this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||Lift/Center Pos.", "", "", "", "Manual Connect", "Auto Connect", "", "Return."};
	}
	
	@Override
	public void init(){
		super.init(); this.menutitle.string = "Const. Status";
		cfields[1] = new NumberField(1, fontRenderer, 2, 20 + (1 * buttonheight), xSize - 4, 10, true);
		cfields[2] = new NumberField(2, fontRenderer, 2, 20 + (2 * buttonheight), xSize - 4, 10, true);
		cfields[3] = new NumberField(3, fontRenderer, 2, 20 + (3 * buttonheight), xSize - 4, 10, true);
		this.fields.put("field1", cfields[1]); this.fields.put("field2", cfields[2]); this.fields.put("field3", cfields[3]);
		for(TextField field : cfields) if(field != null) field.setText("0");
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("button7")) this.openGui(modid, 900, xyz);
		else if(button.name.equals("button4")){
			Print.log(cfields[1].getText() + ", " + cfields[2].getText() + ", " + cfields[3].getText());
		}
		else if(button.name.equals("button5")){
			
		}
		else return;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}

}
