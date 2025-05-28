package net.fexcraft.mod.fvtm.sys.impl;

import java.util.function.Function;

import net.fexcraft.mod.fvtm.sys.condition.*;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import static net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry.COND_FALSE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class CondBuilder {

	public static Function<CondKey, Conditional> run(){
		Function<CondKey, Conditional> con = CondBuilderRoot.run();
		if(con != null) return con;
		return (key) -> {
			switch(key.type){
				case WORLDTIME:{
					switch(key.mode){
						case EQUAL:{
							return (cd, data) -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() == cd.value.integer_value();
							};
						}
						case NEQUAL:{
							return (cd, data) -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() != cd.value.integer_value();
							};
						}
						case LEQUAL:{
							return (cd, data) -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() <= cd.value.integer_value();
							};
						}
						case GEQUAL:{
							return (cd, data) -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() >= cd.value.integer_value();
							};
						}
						case LESS:{
							return (cd, data) -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() < cd.value.integer_value();
							};
						}
						case GREATER:{
							return (cd, data) -> {
								World world = data.entity == null ? data.tile == null ? null : ((TileEntity)data.tile).getWorld() : ((Entity)data.entity).world;
								return world == null ? false : world.getWorldTime() > cd.value.integer_value();
							};
						}
					}
					break;
				}
			}
			return COND_FALSE;
		};
	};
}
