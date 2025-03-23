package net.fexcraft.mod.fvtm.mixin;

import com.google.common.collect.ImmutableSet;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.packs.repository.RepositorySource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.LinkedHashSet;
import java.util.Set;

import static net.fexcraft.mod.fvtm.FVTM.fvtm_packs;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Mixin(PackRepository.class)
public class PackRepoMixin {

	@Shadow
	public Set<RepositorySource> sources;

	@Inject(at = @At("HEAD"), method = "discoverAvailable")
	private void discover(CallbackInfoReturnable info){
		FvtmLogger.log("Inserting FVTM Packs into Resourcepacks.");
		LinkedHashSet<RepositorySource> set = new LinkedHashSet<>(sources);
		for(RepositorySource pack : fvtm_packs){
			if(!set.contains(pack)) set.add(pack);
		}
		sources = ImmutableSet.copyOf(set);
	}

}