package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.model.RenderCacheI;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RenderCacheProvider implements ICapabilityProvider {

	public static final Capability<RenderCacheIF> CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
	private LazyOptional<RenderCacheIF> optional;
	private RenderCacheIF cache;

	public RenderCacheProvider(Entity entity){
		cache = new RenderCacheIF();
		optional = LazyOptional.of(() -> cache);
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction direction){
		return capability == CAPABILITY ? optional.cast() : LazyOptional.empty();
	}

	@AutoRegisterCapability
	public static class RenderCacheIF extends RenderCacheI {}

}
