package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.ui.UIKey;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.UUID;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EntityWIE extends EntityWI implements Passenger {

	public EntityWIE(Entity ent){
		super(ent);
	}

	@Override
	@Deprecated
	public void openUI(UIKey key, V3I pos){
		if(entity instanceof EntityPlayer == false) return;
		((EntityPlayer)entity).openGui(FVTM.getInstance(), key.id, world.local(), pos.x, pos.y, pos.z);
	}

	@Override
	public void openUI(String id, V3I pos){
		if(!id.startsWith("fvtm")){
			super.openUI(id, pos);
			return;
		}
		if(entity instanceof EntityPlayer == false) return;
		((EntityPlayer)entity).openGui(FVTM.getInstance(), UIKey.get(id), entity.world, pos.x, pos.y, pos.z);
	}

	@Override
	public SeatInstance getSeatOn(){
		if(entity.getRidingEntity() instanceof RootVehicle == false) return null;
		return ((RootVehicle)entity.getRidingEntity()).getSeatOf(entity);
	}

	@Override
	public void set(int veh, int seatid){
		//
	}

	@Override
	public int vehicle(){
		return 0;
	}

	@Override
	public int seat(){
		return 0;
	}

	@Override
	public V3D getEyeVec(){
		Vec3d vec = Minecraft.getMinecraft().getRenderViewEntity().getPositionEyes(Minecraft.getMinecraft().getRenderPartialTicks());
		return new V3D(vec.x, vec.y, vec.z);
	}

	@Override
	public V3D getLookVec(){
		Vec3d vec = Minecraft.getMinecraft().getRenderViewEntity().getLook(Minecraft.getMinecraft().getRenderPartialTicks());
		return new V3D(vec.x, vec.y, vec.z);
	}

	@Override
	public boolean isShiftDown(){
		return entity.isSneaking();
	}

}
