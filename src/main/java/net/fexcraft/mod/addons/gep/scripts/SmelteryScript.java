package net.fexcraft.mod.addons.gep.scripts;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockScript;
import net.fexcraft.mod.fvtm.impl.block.CrafterBlockScriptBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fml.relauncher.Side;

public class SmelteryScript extends CrafterBlockScriptBase {
	
	public boolean open;
	
	public SmelteryScript(){
		super();
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		compound = super.writeToNBT(compound);
		compound.setBoolean("Script_Open", open);
		return compound;
	}

	@Override
	public BlockScript readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		open = compound.getBoolean("Script_Open");
		return this;
	}

	@Override
	public void onPlace(TileEntity tile, BlockData data){
		//
	}

	@Override
	public void onBreak(TileEntity tile, BlockData data){
		//
	}

	@Override
	public ScriptSetting<?, ?>[] getSettings(int seat){
		return new ScriptSetting<?, ?>[]{
			new ScriptSetting<SmelteryScript, TileEntity>(this, "open", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, TileEntity tile, int i, Object... objs){
					open = i == 0 ? false : i == 1 ? true : open;
			        NBTTagCompound nbt = new NBTTagCompound();
			        nbt.setBoolean("smeltery_open", open);
			        holder.sendPacketToAllAround(tile, nbt);
				}
			}
		};
	}

	@Override
	public void onDataPacket(TileEntity tile, BlockData data, NBTTagCompound compound, Side side){
		super.onDataPacket(tile, data, compound, side);
		if(compound.hasKey("smeltery_open")){
			open = compound.getBoolean("smeltery_open");
		}
		else if(compound.hasKey("new_recipe")){
			current_recipe = Recipe.fromSave(compound.getCompoundTag("new_recipe"));
		}
		else if(compound.hasKey("recipe_done")){
			current_recipe = null;
		}
		//
		if(compound.hasKey("tank")){
			FluidStack stack = ((FluidTank)data.getFluidTanks().get("smeltery_tank")).getFluid();
			if(stack != null){
				stack.amount = compound.getInteger("tank");
			}
			else if(compound.getInteger("tank") > 0){
				((FluidTank)data.getFluidTanks().get("smeltery_tank")).fillInternal(new FluidStack(FluidRegistry.LAVA, compound.getInteger("tank")), true);
			}
		}
	}
	
	@Override
	public void onUpdate(TileEntity tile, BlockData data){
		if(tile.getWorld() == null){
			return;
		}
		if(tile.getWorld().isRemote){
			EnumParticleTypes type = open ? EnumParticleTypes.SMOKE_LARGE : EnumParticleTypes.SMOKE_NORMAL;
			float x = tile.getPos().getX() + 0.5f, y = tile.getPos().getY() + 4, z = tile.getPos().getZ() + 0.5f;
			if(!open){
				for(float f = -0.2f; f < 0.3f; f += 0.1f){
					for(float g = -0.2f; g < 0.3f; g += 0.1f){
						float h = tile.getWorld().rand.nextFloat(); h = h > 0.3 ? h / 10 : h;
						tile.getWorld().spawnParticle(type, x + f, y, z + g, 0.001D, h, 0.001D);
					}
				}
			}
			else{
				tile.getWorld().spawnParticle(type, x      , y, z      , 0.0D, 0.07D, 0.0D);
				tile.getWorld().spawnParticle(type, x + 0.1, y, z + 0.1, 0.0D, 0.11D, 0.0D);
				tile.getWorld().spawnParticle(type, x - 0.1, y, z + 0.1, 0.0D, 0.15D, 0.0D);
				tile.getWorld().spawnParticle(type, x - 0.1, y, z - 0.1, 0.0D, 0.08D, 0.0D);
				tile.getWorld().spawnParticle(type, x + 0.1, y, z - 0.1, 0.0D, 0.22D, 0.0D);
			}
			//
			if(current_recipe == null){
				progress = 0;
			}
			else{
				FluidTank tank = getTank(data);
				if(tank == null){
					progress = open ? 100 : 150;
				}
				if(tank.getFluidAmount() > 0){
					tank.drainInternal(1, true);
					progress = ++progress > (open ? 200 : 300) ? 0 : progress;
				}
				else{
					progress = --progress < 0 ? 0 : progress;
				}
			}
		}
		else{
			FluidTank tank = getTank(data);
			if(tank == null){ return; }
			if(current_recipe == null){
				Recipe recipe = findNextRecipe(data);
				if(recipe == null){
					//Print.debug("No Recipe found.");
					return;
				}
				else{
					Print.debug(recipe.output[0]);
					current_recipe = recipe;
					for(Object obj : current_recipe.ingredients){
						extract(data.getItemStacks().get("smeltery_queue"), (ItemStack)obj);
					}
					//
			        NBTTagCompound nbt = new NBTTagCompound();
			        nbt.setTag("new_recipe", current_recipe.save());
			        nbt.setInteger("tank", tank.getFluidAmount());
			        sendPacketToAllAround(tile, nbt);
				}
			}
			else{
				if(open ? progress >= 200 : progress >= 300){
					for(Object obj : current_recipe.output){
						if(obj instanceof ItemStack){
							insert(data.getItemStacks().get("smeltery_out"), (ItemStack)obj);
						}
						else{
							tank.fillInternal((FluidStack)obj, true);
						}
					}
					current_recipe = null;
					//
			        NBTTagCompound nbt = new NBTTagCompound();
			        nbt.setBoolean("recipe_done", true);
			        nbt.setInteger("tank", tank.getFluidAmount());
			        sendPacketToAllAround(tile, nbt);
			        progress = 0;
				}
				if(tank.getFluidAmount() > 0){
					progress++; tank.drainInternal(1, true);
				}
				else if(current_recipe.output[0] instanceof FluidStack ||
					(current_recipe.output.length > 1 && current_recipe.output[1] instanceof FluidStack) ||
					(current_recipe.output.length > 1 && current_recipe.output[2] instanceof FluidStack)){
					progress += 10;
				}
				else{
					progress--;
					if(progress < 0){
				        NBTTagCompound nbt = new NBTTagCompound();
				        nbt.setBoolean("recipe_done", true);
				        nbt.setInteger("tank", tank.getFluidAmount());
				        sendPacketToAllAround(tile, nbt);
					}
				}
			}
		}
	}

	private FluidTank getTank(BlockData data){
		return (FluidTank)data.getFluidTanks().get("smeltery_tank");
	}

	@Override
	public Object getSettingsValue(String setting){
		return setting.equals("open") ? open + "" : "";
	}

	@Override
	public int getProgressPercentage(){
		return open ? progress / 2 : progress / 3;
	}

	@Override
	public String getSettingHolderId(){
		return "generic:smeltery";
	}
	
	private ArrayList<String> list = new ArrayList<>();

	@Override
	public List<String> getStatus(BlockData data){
		if(list.isEmpty()){
			list.add("status");
			list.add("crafting");
			list.add("tank");
		}
		list.set(0, current_recipe == null ? "Status: Idle/Waiting" : "Status: Working/Processing");
		list.set(1, current_recipe == null ? " . . . " : "Smelting: " + ((ItemStack)current_recipe.output[0]).getDisplayName());
		list.set(2, "Lava Tank: " + ((FluidTank)data.getFluidTanks().get("smeltery_tank")).getFluidAmount() + "mB");
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
			if(recipe.ingredients.length > 3){
				list.remove(i); continue;
			}
			if(recipe.output.length > 3){
				list.remove(i); continue;
			}
			for(Object obj : recipe.ingredients){
				if(obj instanceof ItemStack == false){
					list.remove(i); continue;
				}
			}
			for(Object obj : recipe.output){
				if(obj instanceof FluidStack){
					if(((FluidStack)obj).getFluid() != FluidRegistry.LAVA){
						list.remove(i); Print.debug(obj); Static.stop(); continue; 
					}
				}
				else if(obj instanceof ItemStack == false){
					list.remove(i); Print.debug(obj); Static.stop(); continue;
				}
			}
		}
		checked = true;
	}

	@Override
	public Recipe findNextRecipe(BlockData data){
		NonNullList<ItemStack> list = data.getItemStacks().get("smeltery_queue");
		for(Recipe recipe : RECIPES.get(getSettingHolderId())){
			boolean missing = false;
			for(Object obj : recipe.ingredients){
				if(!containsItemStack(list, (ItemStack)obj)){
					missing = true; break;
				}
			}
			if(!missing){
				NonNullList<ItemStack> out = data.getItemStacks().get("smeltery_out");
				for(Object obj : recipe.output){
					if(obj instanceof FluidStack){
						FluidTank tank = (FluidTank)data.getFluidTanks().get("smeltery_tank");
						if(tank.getFluidAmount() + ((FluidStack)obj).amount > tank.getCapacity()){
							missing = true; break;
						}
					}
					else if(!canFit(out, (ItemStack)obj)){
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
	
}