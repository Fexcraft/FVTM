package net.fexcraft.mod.fvtm.sys.eisen;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.render.RailRenderer.TurboArrayPositioned;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Gleis {
	
	public Vec316f start, ende;
	public GleisID id;
	public Vec3f[] pfad;
	private float länge;
	public Abschnitt abschnitt;
	public RailGauge spurtyp;
	//
	@SideOnly(Side.CLIENT)
	public TurboArrayPositioned railmodel;
	@SideOnly(Side.CLIENT)
	public TurboArrayPositioned restmodel;
	
	public Gleis(RailGauge typ, Abschnitt abschnitt, Vec316f... punkte){
		typ = spurtyp; start = punkte[0]; ende = punkte[punkte.length - 1];
		id = new GleisID(start, ende); this.abschnitt = abschnitt; pfad = new Vec3f[punkte.length];
		if(punkte.length == 2){
			pfad[0] = start.vector; pfad[1] = ende.vector; länge = pfad[0].distanceTo(pfad[1]);
		}
		else{
			for(int i = 0; i < punkte.length; i++){ pfad[i] = punkte[i].vector; }
			//
			Vec3f[] vek = GleisHelfer.pfadErstellen(pfad); pfad = new Vec3f[vek.length + 2];
			pfad[0] = new Vec3f(start.vector); for(int i = 0; i < vek.length; i++){ pfad[i + 1] = vek[i]; }
			pfad[punkte.length - 1] = new Vec3f(ende.vector);
			this.länge = GleisHelfer.längeBerechnen(pfad);
		}
	}
	
	public float getLänge(){
		return länge;
	}
	
	public NBTTagCompound toNBT(NBTTagCompound compound){
		id.write(compound == null ? compound = new NBTTagCompound() : compound);
		if(abschnitt != null) compound.setLong("section", abschnitt.id);
		compound.setString("gauge", (spurtyp == null ? InternalAddon.STANDARD_GAUGE : spurtyp.getRegistryName()).toString());
		compound.setTag("start", start.write());
		compound.setTag("end", ende.write());
		compound.setInteger("vectors", pfad.length);
		for(int i = 0; i < pfad.length; i++){
			compound.setTag("vector-" + i, DataUtil.writeVec3f(pfad[i]));
		}
		compound.setFloat("length", länge);
		return compound;
	}
	
	public Gleis read(NBTTagCompound compound, boolean fernwelt){
		this.id = new GleisID(compound);
		abschnitt = BahnSystem.getAbschnitt(compound.getLong("section"));
		if(compound.hasKey("gauge")){
			spurtyp = Resources.RAILGAUGES.getValue(new ResourceLocation(compound.getString("gauge")));
		}
		if(spurtyp == null){
			spurtyp = Resources.RAILGAUGES.getValue(InternalAddon.STANDARD_GAUGE);
		}
		this.start = new Vec316f(compound.getCompoundTag("start"));
		this.ende = new Vec316f(compound.getCompoundTag("end"));
		this.pfad = new Vec3f[compound.getInteger("vectors")];
		for(int i = 0; i < pfad.length; i++){
			pfad[i] = DataUtil.readVec3f(compound.getTag("vector-" + i));
		}
		this.länge = compound.hasKey("length") ? compound.getFloat("length") : GleisHelfer.längeBerechnen(pfad);
		if(fernwelt){
			railmodel = null; restmodel = null;
		} return this;
	}

}
