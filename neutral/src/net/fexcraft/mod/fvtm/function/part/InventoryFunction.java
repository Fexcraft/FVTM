package net.fexcraft.mod.fvtm.function.part;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerInit;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;

public class InventoryFunction extends PartFunction {
	
	private InvHandler inventory;
    private ArrayList<StackWrapper> allowed = new ArrayList<>();
    private ArrayList<StackWrapper> disallowed = new ArrayList<>();
    private ArrayList<String> seats = new ArrayList<String>();

	/** Static Copy in Part. */
	public InventoryFunction(){}

	/** Functional Copy in PartData. */
	public InventoryFunction(InventoryFunction root){
		allowed = root.allowed;
		disallowed = root.disallowed;
		seats = root.seats;
		inventory = root.inventory.gen(1);
	}

	@Override
	public PartFunction init(Part part, FJson json){
		JsonMap map = json.asMap();
		inventory = new InvHandlerInit(InvType.parse(map.getString("type", "item")));
		inventory.setCapacity(map.getInteger("capacity", 0));
		inventory.setArg(map.getString("fluid", "minecraft:water"));
		//
		if(map.has("allowed")){
			map.get("allowed").asArray().value.forEach(val -> {
				try{
					JsonMap jsn = val.asMap();
					StackWrapper stack = FvtmResources.newStack(IDLManager.getIDL(jsn.getString("id", "minecraft:stone")));
					if(!stack.empty()){
						if(jsn.has("meta")) stack.damage(jsn.getInteger("meta", 0));
						allowed.add(stack);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		}
		if(map.has("disallowed")){
			map.get("disallowed").asArray().value.forEach(val -> {
				try{
					JsonMap jsn = val.asMap();
					StackWrapper stack = FvtmResources.newStack(IDLManager.getIDL(jsn.getString("id", "minecraft:stone")));
					if(!stack.empty()){
						if(jsn.has("meta")) stack.damage(jsn.getInteger("meta", 0));
						disallowed.add(stack);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		}
		if(map.has("seats")) seats = map.getArray("seats").toStringList();
		return this;
	}

	@Override
	public PartFunction load(TagCW compound){
		inventory.load(compound, "inventory");
		return this;
	}

	@Override
	public TagCW save(TagCW compound){
        inventory.save(compound, "inventory");
		return compound;
	}

	@Override
	public String getId(){
		return "fvtm:inventory";
	}

	@Override
	public PartFunction copy(Part part){
		return new InventoryFunction(this);
	}
    
    public ArrayList<String> getSeats(){
    	return seats;
    }
    
    public boolean isItemValid(StackWrapper stack){
        for(StackWrapper itemstack : disallowed){
            if(stack.getID().equals(itemstack.getID())){
                if(itemstack.damage() == 0 || stack.damage() == itemstack.damage()){
                    return false;
                }
            }
        }
        //
        if(!allowed.isEmpty()){
            boolean found = false;
            for(StackWrapper itemstack : allowed){
                if(stack.getID().equals(itemstack.getID())){
                    if(itemstack.damage() == 0 || stack.damage() == itemstack.damage()){
                        found = true;
                        break;
                    }
                }
            } return found;
        } return true;
    }
	@Override
	public void addInformation(StackWrapper stack, WorldW world, PartData data, List<String> tooltip, boolean ext){
		tooltip.add(Formatter.format("&9Inventory Size: &7" + inventory.capacity() + " " + inventory.type.unit_suffix));
		tooltip.add(Formatter.format("&9Inventory Type: &7" + inventory.type.name()));
		if(inventory.type.isFluid()){
			//UniFluidTank tank = inventory.getTank();
			//tooltip.add(Formatter.format("&9Inv. Content: &7" + (tank.amount() == 0 ? "empty" : tank.fluid_name())));
		}
	}

	public InvHandler inventory(){
		return inventory;
	}

}
