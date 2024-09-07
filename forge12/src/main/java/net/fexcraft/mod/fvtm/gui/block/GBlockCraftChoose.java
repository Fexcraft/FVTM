package net.fexcraft.mod.fvtm.gui.block;

import java.util.ArrayList;
import java.util.Map.Entry;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript.InputWrapper;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript.OutputWrapper;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript.Recipe;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class GBlockCraftChoose extends GenericGui<GBlockCraftChooseContainer> {

	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/block_craftscript_choose_recipe.png");
	public Recipe[] recipes = new Recipe[16];
	private int hovered = -1;
	private ArrayList<String> hoverlines = new ArrayList<>();

	public GBlockCraftChoose(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new GBlockCraftChooseContainer(player, world, x, y, z), player);
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 256;
		this.ySize = 246;
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 7, guiTop + 6, 192, MapColor.SNOW.colorValue, "loading...."));
		texts.put("page", new BasicText(guiLeft + 203, guiTop + 6, 28, MapColor.SNOW.colorValue, "1/pg"));
		buttons.put("prev", new BasicButton("prev", guiLeft + 233, guiTop + 6, 233, 6, 8, 8, true));
		buttons.put("next", new BasicButton("next", guiLeft + 242, guiTop + 6, 242, 6, 8, 8, true));
		for(int i = 0; i < 16; i++){
			texts.put("t_" + i, new BasicText(guiLeft + 9, guiTop + 19 + (i * 14), 238, MapColor.SNOW.colorValue, "loading...").autoscale());
			buttons.put("b_" + i, new BasicButton("b_" + i, guiLeft + 7, guiTop + 17 + (i * 14), 7, 17 + (i * 14), 242, 12, true));
		}
		loadRecipes();
	}

	private void loadRecipes(){
		ArrayList<Recipe> recipes = CraftBlockScript.SORTED_REGISTRY.get(container.tile.getMultiBlockData().getType().getIDS());
		for(int i = 0; i < 16; i++){
			int j = i + 16 * container.page;
			if(recipes == null || j >= recipes.size()){
				texts.get("t_" + i).string = "";
				buttons.get("b_" + i).enabled = false;
				this.recipes[i] = null;
			}
			else{
				texts.get("t_" + i).string = recipes.get(j).id();
				buttons.get("b_" + i).enabled = true;
				this.recipes[i] = recipes.get(j);
			}
		}
		if(recipes == null){
			texts.get("t_0").string = "No recipes for block found.";
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(container.tile != null){
			texts.get("top").string = container.tile.getMultiBlockData().getType().getName();
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		int newhovered = -1;
		for(int i = 0; i < recipes.length; i++){
			if(buttons.get("b_" + i).hovered){
				newhovered = i;
				break;
			}
		}
		if(newhovered != hovered){
			hovered = newhovered;
			loadHoverlines();
		}
	}

	private void loadHoverlines(){
		hoverlines.clear();
		if(hovered < 0 || recipes[hovered] == null) return;
		Recipe recipe = recipes[hovered];
		for(InputWrapper wrapper : recipe.getInputs()){
			String name = wrapper.fluid == null ? wrapper.oreid == null ? wrapper.ingredient == null ? "ERROR;NULL" : "I; " + wrapper.ingredient.getMatchingStacks()[0].getDisplayName() : "O; " + wrapper.oreid : wrapper.fluid.getLocalizedName();
			hoverlines.add(Formatter.format("&4- %s&7x&c%s &7-> &c%s", wrapper.amount, name, CraftBlockScript.getInvId(container.tile.getMultiBlockData(), wrapper.getInputType().toInventory(), wrapper.inventory, "input")));
		}
		for(Entry<String, Integer> entry : recipe.getConsume().entrySet()){
			hoverlines.add(Formatter.format("&b- &3%s &7-> &3%s", entry.getValue(), entry.getKey()));
		}
		for(OutputWrapper wrapper : recipe.getOutput()){
			String name = wrapper.fluid == null ? wrapper.stack.getDisplayName() : wrapper.fluid.getLocalizedName();
			hoverlines.add(Formatter.format("&a+ %s&7x&2%s &7-> &a%s", wrapper.amount(), name, CraftBlockScript.getInvId(container.tile.getMultiBlockData(), wrapper.getInventoryType(), wrapper.inventory, "output")));
		}
	}
	
	@Override
    public void drawGuiContainerBackgroundLayer(float pticks, int mouseX, int mouseY){
		super.drawGuiContainerBackgroundLayer(pticks, mouseX, mouseY);
		if(hovered >= 0 && !hoverlines.isEmpty()){
			this.drawHoveringText(hoverlines, guiLeft + 7 + 64, guiTop + 17 + (hovered * 14));
			this.mc.getTextureManager().bindTexture(texloc);
		}
    }

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("prev")){
			updatePage(-1);
			return true;
		}
		if(button.name.equals("next")){
			updatePage(1);
			return true;
		}
		if(button.name.startsWith("b_")){
			int i = Integer.parseInt(button.name.substring(2));
			if(recipes[i] == null) return false;
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "choose");
			compound.setString("recipe", recipes[i].id());
			this.container.send(Side.SERVER, compound);
			return true;
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		updatePage(am > 0 ? 1 : -1);
	}

	private void updatePage(int i){
		container.page += i;
		if(container.page < 0) container.page = 0;
		texts.get("page").string = (container.page + 1) + "/pg";
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "page");
		compound.setInteger("page", container.page);
		this.container.send(Side.SERVER, compound);
		loadRecipes();
	}

}
