package net.fexcraft.mod.addons.gmp.scripts;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.mod.addons.gmp.impl.GenericDyePowderMaterial;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockScript;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Material.MaterialItem;
import net.fexcraft.mod.fvtm.impl.CrafterBlockScriptBase;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;

public class ColorExtractorScript extends CrafterBlockScriptBase {
	
	public ColorExtractorScript(){ super(); }
	
	public int state = 0;
	private int duration = 800;

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		compound = super.writeToNBT(compound);
		compound.setInteger("Script_InvState", state);
		return compound;
	}

	@Override
	public BlockScript readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		state = compound.getInteger("Script_InvState");
		return this;
	}
	
	@Override
	public void onDataPacket(TileEntity tile, BlockData data, NBTTagCompound compound, Side side){
		super.onDataPacket(tile, data, compound, side);
		if(compound.hasKey("new_recipe")){
			current_recipe = Recipe.fromSave(compound.getCompoundTag("new_recipe"));
		}
		else if(compound.hasKey("recipe_done")){
			current_recipe = null;
		}
		//
		if(compound.hasKey("state")){
			state = compound.getInteger("state");
		}
	}
	
	@Override
	public void onUpdate(TileEntity tile, BlockData data){
		if(tile.getWorld() == null){
			return;
		}
		if(tile.getWorld().isRemote){
			if(current_recipe == null){
				progress = 0;
			}
			else{
				progress = progress + 1;
				progress = progress > duration ? 0 : progress;
				//
				if(((ItemStack)current_recipe.output[0]).getItem() instanceof ItemBlock == false){
					return;
				}
				int i = Block.getStateId(((ItemBlock)((ItemStack)current_recipe.output[0]).getItem()).getBlock().getDefaultState());
				float x = tile.getPos().getX() + 0.5f, y = tile.getPos().getY() + 2.1f, z = tile.getPos().getZ() + 0.5f;
				for(float f = -0.2f; f < 0.3f; f += 0.1f){
					for(float g = -0.2f; g < 0.3f; g += 0.1f){
						float h = tile.getWorld().rand.nextFloat(); h = h > 0.3 ? h / 10 : h;
						tile.getWorld().spawnParticle(EnumParticleTypes.BLOCK_DUST, x + f, y, z + g, 0.001D, h, 0.001D, i);
					}
				}
                double d0 = (double)((float)tile.getPos().getX() + tile.getWorld().rand.nextFloat());
                double d1 = (double)tile.getPos().getY() - 0.05D + 1d;
                double d2 = (double)((float)tile.getPos().getZ() + tile.getWorld().rand.nextFloat());
                tile.getWorld().spawnParticle(EnumParticleTypes.FALLING_DUST, d0, d1, d2, 0.0D, 0.0D, 0.0D, i);
			}
		}
		else{
			if(current_recipe == null){
				Recipe recipe = findNextRecipe(data);
				if(recipe == null){
					//Print.debug("No Recipe found.");
					return;
				}
				else{
					current_recipe = recipe;
					for(Object obj : current_recipe.ingredients){
						extract(data.getItemStacks().get("crusher_in"), (ItemStack)obj);
					}
					//
			        NBTTagCompound nbt = new NBTTagCompound();
			        nbt.setTag("new_recipe", current_recipe.save());
			        nbt.setInteger("state", countOutput(data));
			        sendPacketToAllAround(tile, nbt);
				}
			}
			else{
				if(progress >= duration){
					for(Object obj : current_recipe.output){
						insert(data.getItemStacks().get("crusher_out"), (ItemStack)obj);
					}
					current_recipe = null;
					//
			        NBTTagCompound nbt = new NBTTagCompound();
			        nbt.setBoolean("recipe_done", true);
			        nbt.setInteger("state", countOutput(data));
			        sendPacketToAllAround(tile, nbt);
			        progress = 0;
				}
				progress = progress + 1;
			}
		}
	}

	private int countOutput(BlockData data){
		long i = data.getItemStacks().get("crusher_out").stream().filter(pre -> !pre.isEmpty()).count();
		return (int)(i / 8);
	}

	@Override
	public int getProgressPercentage(){
		return progress / 8;
	}

	@Override
	public String getSettingHolderId(){
		return "hcp:crusher";
	}
	
	private ArrayList<String> list = new ArrayList<>();

	@Override
	public List<String> getStatus(BlockData data){
		if(list.isEmpty()){
			list.add("status");
			list.add("crafting");
		}
		list.set(0, current_recipe == null ? "Status: Idle/Waiting" : "Status: Working/Extracting");
		list.set(1, current_recipe == null ? " . . . " : "Crushing: " + ((ItemStack)current_recipe.output[0]).getDisplayName());
		return list;
	}
	
	private static boolean checked = false;

	@Override
	protected void validateRecipes(List<Recipe> list){
		if(checked){ return; }
		if(list == null){
			RECIPES.put(getSettingHolderId(), new ArrayList<Recipe>());
			return;
		}
		Recipe recipe;
		for(int i = 0; i < list.size(); i++){
			recipe = list.get(i);
			if(recipe.ingredients.length > 4){
				list.remove(i); continue;
			}
			if(recipe.output.length > 4){
				list.remove(i); continue;
			}
			for(Object obj : recipe.ingredients){
				if(obj instanceof ItemStack == false){
					list.remove(i); continue;
				}
			}
			for(Object obj : recipe.output){
				if(obj instanceof ItemStack == false){
					list.remove(i); Print.debug(obj); Static.stop(); continue;
				}
			}
		}
		checked = true;
	}

	@Override
	public Recipe findNextRecipe(BlockData data){
		NonNullList<ItemStack> list = data.getItemStacks().get("extractor_in");
		for(Recipe recipe : RECIPES.get(getSettingHolderId())){
			boolean missing = false;
			for(Object obj : recipe.ingredients){
				if(!containsItemStack(list, (ItemStack)obj)){
					missing = true; break;
				}
			}
			if(!missing){
				NonNullList<ItemStack> out = data.getItemStacks().get("extractor_out");
				NonNullList<ItemStack> cout = data.getItemStacks().get("extractor_color_out");
				for(Object obj : recipe.output){
					ItemStack stack = (ItemStack)obj;
					if(stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getMaterial(stack) instanceof GenericDyePowderMaterial){
						if(!canFit(cout, stack)){
							missing = true; break;
						}
					}
					else if(!canFit(out, stack)){
						missing = true; break;
					}
				}
			}
			if(!missing){
				return recipe;
			}
		}
		return null;
	}

	@Override
	public ScriptSetting<?, ?>[] getSettings(int seat){
		return null;
	}

	@Override
	public Object getSettingsValue(String setting){
		return null;
	}
	
}