package net.fexcraft.mod.fvtm.sys.impl;

import java.util.ArrayList;
import java.util.function.Function;

import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.event.ConditionEvent;
import net.fexcraft.mod.fvtm.sys.condition.CondBuilderRoot;
import net.fexcraft.mod.fvtm.sys.condition.Condition;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.condition.Conditional;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import static net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry.COND_FALSE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class CondBuilder {

	public static Function<Condition, Conditional> run(){
		Function<Condition, Conditional> con = CondBuilderRoot.run();
		if(con != null) return con;
		return (cond) -> {
			switch(cond.type){
				case WORLDTIME:{
					int value = Integer.parseInt(cond.condi);
					switch(cond.mode){
						case EQUAL:{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() == value;
							};
						}
						case NEQUAL:{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() != value;
							};
						}
						case LEQUAL:{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() <= value;
							};
						}
						case GEQUAL:{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() >= value;
							};
						}
						case LESS:{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() < value;
							};
						}
						case GREATER:{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() > value;
							};
						}
					}
					break;
				}
				case CUSTOM:{
					ConditionEvent.ConditionalCreate event = new ConditionEvent.ConditionalCreate(cond);
					MinecraftForge.EVENT_BUS.post(event);
					return event.getConditional();
				}
			}
			return COND_FALSE;
		};
	};
}
