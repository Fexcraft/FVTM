package net.fexcraft.mod.addons.zmp.models.part;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.Entity;

public class ModelCargoShipCargo extends PartModel<VehicleData> {

    private static final ArrayList<Pos> offsets = new ArrayList<Pos>();
    private static final TreeMap<String, Pos> positions = new TreeMap<String, Pos>();

    public ModelCargoShipCargo(){
        this.creators.add("01e4af9b-2a30-471e-addf-f6338ffce04b");
        try{
            if(offsets.size() == 0){
                for(int j = 0; j < 20; j++){
                    int i = j * 51;
                    offsets.add(new Pos(-437 + i, -129 + 48, 48));
                    offsets.add(new Pos(-437 + i, -129 + 48, -48));
                    offsets.add(new Pos(-437 + i, -177 + 48, 48));
                    offsets.add(new Pos(-437 + i, -177 + 48, -48));
                }
                offsets.add(new Pos(-677, -82, 0));
                offsets.add(new Pos(-728, -82, 0));
                offsets.add(new Pos(598, -81, 0));
                offsets.add(new Pos(648, -81, 0));
                //
                offsets.add(new Pos(-677, -130, 0));
                offsets.add(new Pos(598, -129, 0));
                offsets.add(new Pos(648, -129, 0));
            }
            if(positions.size() == 0){
                for(int i = 0; i < 87; i++){
                    positions.put("container_" + (i < 10 ? "0" : "") + i, offsets.get(i));
                }
            }
            /*Print.debug(offsets);
			positions.forEach((k, v) ->{
				Print.debug(k + " | " + v);
			});
			Static.stop();*/
        }
        catch(Exception e){
            e.printStackTrace();
            Static.stop();
        }
    }

    @Override
    public void render(VehicleData data, String usedAS){
        positions.get(usedAS).translate();
        super.def_renderContainer(data, usedAS);
        positions.get(usedAS).translateR();
    }

    @Override
    public void render(VehicleData data, String usedAS, Entity vehicle){
        positions.get(usedAS).translate();
        super.def_renderContainer(data, usedAS, vehicle);
        positions.get(usedAS).translateR();
    }

}
