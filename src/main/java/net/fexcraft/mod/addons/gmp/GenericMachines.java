package net.fexcraft.mod.addons.gmp;

import java.io.File;

import net.fexcraft.mod.addons.gmp.impl.GenericDyePowderMaterial;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.impl.HybridAddon;
import net.minecraft.item.EnumDyeColor;
import net.minecraftforge.event.RegistryEvent.Register;

public class GenericMachines extends HybridAddon {

    public GenericMachines(File file){
        super(file);
    }

    @Override
    public void regMaterials(Register<Material> event){
        for(EnumDyeColor color : EnumDyeColor.values()){
        	event.getRegistry().register(new GenericDyePowderMaterial(color));
        }
    }

}
