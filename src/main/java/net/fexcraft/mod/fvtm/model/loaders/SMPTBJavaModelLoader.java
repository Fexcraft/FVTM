package net.fexcraft.mod.fvtm.model.loaders;

import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.tmt.BoxBuilder;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Model.ModelData;
import net.fexcraft.mod.fvtm.data.root.Model.ModelLoader;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.util.ResourceLocation;

/**
 * For loading uncompiled java models exported from SMP Toolbox v2.
 * Based on the importer in FMT.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class SMPTBJavaModelLoader implements ModelLoader {

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("java") || suffix.equals("smptb");
	}

	@Override
	public Object[] load(String name, ModelData confdata, Supplier<Model> supp_model) throws Exception {
		Object[] stream = Resources.getModelInputStreamWithFallback(new ResourceLocation(name));
		GenericModel model = (GenericModel)supp_model.get();
		//
        String line = null;
        Scanner scanner = new Scanner((InputStream)stream[0]);
        Pattern creator = Pattern.compile("\\/\\/ Model Creator: (.*)");
        Pattern groupdef = Pattern.compile("(.*) = new ModelRendererTurbo\\[\\d+\\];");
        Pattern declaration = Pattern.compile("(.*)\\[(\\d+)\\] = new ModelRendererTurbo\\(this, (\\d+), (\\d+), .*, .*\\);(.*)");
        Pattern box = Pattern.compile("(.*)\\[(\\d+)\\]\\.add.*Box\\((.*)\\);.*");
        Pattern rotpoint = Pattern.compile("(.*)\\[(\\d+)\\]\\.setRotationPoint\\((.*)\\);");
        Pattern pospoint = Pattern.compile("(.*)\\[(\\d+)\\]\\.setPosition\\((.*)\\);");
        String component = "rotateAngle";
        Pattern rotangle = Pattern.compile("(.*)\\[(\\d+)\\]\\." + component + "(.) = (\\d)+F;");
        ArrayList<TemporaryPolygon> polis = new ArrayList<>();
        int linenumber = 0;
        while(scanner.hasNext()){
        	try{
        		linenumber++;
            	line = scanner.nextLine().trim();
            	if(line.length() < 2) continue;
            	if(line.startsWith("public class")){
            		model.setName(line.split(" ")[2].substring(5));
            		continue;
            	}
            	if(line.startsWith("int textureX")){
            		model.textureX = parseI(line.split(" ")[3]);
            		continue;
            	}
            	if(line.startsWith("int textureY")){
            		model.textureY = parseI(line.split(" ")[3]);
            		continue;
            	}
            	Matcher matcher = groupdef.matcher(line);
            	if(matcher.matches()){
            		model.groups.add(new ModelGroup(matcher.group(1)));
            		continue;
            	}
            	matcher = creator.matcher(line);
            	if(matcher.matches()){
            		confdata.creators().add(matcher.group(1));
            		continue;
            	}
            	matcher = declaration.matcher(line);
            	if(matcher.matches()){
            		TemporaryPolygon poly = new TemporaryPolygon();
            		poly.group = matcher.group(1);
            		poly.index = parseI(matcher.group(2));
            		poly.mrt.texoffx = parseI(matcher.group(3));
            		poly.mrt.texoffy = parseI(matcher.group(4));
            		poly.mrt.boxName = matcher.group(5).replace(" // ", "");
            		poly.mrt.textureWidth = model.textureX;
            		poly.mrt.textureHeight = model.textureY;
            		polis.add(poly);
            		continue;
            	}
            	matcher = box.matcher(line);
            	if(matcher.matches()){
            		boolean shapebox = line.contains("ShapeBox");
            		TemporaryPolygon poly = get(matcher.group(1), matcher.group(2), polis);
            		String[] array = matcher.group(3).split(", ");
            		BoxBuilder builder = new BoxBuilder(poly.mrt);
            		builder.setOffset(parseF(array[0]), parseF(array[1]), parseF(array[2]));
            		builder.setSize(parseF(array[3]), parseF(array[4]), parseF(array[5]));
            		if(shapebox){
            			builder.setCorner(0, newVec3f(array[7], array[8], array[9]));
            			builder.setCorner(1, newVec3f(array[10], array[11], array[12]));
            			builder.setCorner(2, newVec3f(array[13], array[14], array[15]));
            			builder.setCorner(3, newVec3f(array[16], array[17], array[18]));
            			builder.setCorner(4, newVec3f(array[19], array[20], array[21]));
            			builder.setCorner(5, newVec3f(array[22], array[23], array[24]));
            			builder.setCorner(6, newVec3f(array[25], array[26], array[27]));
            			builder.setCorner(7, newVec3f(array[28], array[29], array[30]));
            		}
            		model.get(poly.group).add(builder.build());
            		continue;
            	}
            	matcher = rotpoint.matcher(line);
            	if(matcher.matches()){
            		TemporaryPolygon poly = get(matcher.group(1), matcher.group(2), polis);
            		String[] array = matcher.group(3).split(", ");
            		poly.mrt.rotationPointX = parseF(array[0]);
            		poly.mrt.rotationPointY = parseF(array[1]);
            		poly.mrt.rotationPointZ = parseF(array[2]);
            		continue;
            	}
            	matcher = pospoint.matcher(line);
            	if(matcher.matches()){
            		TemporaryPolygon poly = get(matcher.group(1), matcher.group(2), polis);
            		String[] array = matcher.group(3).split(", ");
            		poly.mrt.rotationPointX = parseF(array[0]);
            		poly.mrt.rotationPointY = parseF(array[1]);
            		poly.mrt.rotationPointZ = parseF(array[2]);
            		continue;
            	}
            	matcher = rotangle.matcher(line);
            	if(matcher.matches()){
            		TemporaryPolygon poly = get(matcher.group(1), matcher.group(2), polis);
            		String axis = matcher.group(3).toLowerCase();
            		float value = parseF(matcher.group(4));
            		switch(axis){
            			case "x":{
            				poly.mrt.rotationAngleX = (float)Math.toDegrees(value);
            				break;
            			}
            			case "y":{
            				poly.mrt.rotationAngleY = (float)Math.toDegrees(value);
            				break;
            			}
            			case "z":{
            				poly.mrt.rotationAngleZ = (float)Math.toDegrees(value);
            				break;
            			}
            		}
            		continue;
            	}
        	}
        	catch(Exception e){
        		Print.log("Failed to load SMP TB Model.");
            	Print.log("Parsing error at line [" + linenumber + "]: " + line);
            	continue;
        	}
        }
    	scanner.close();
    	//
		if(stream.length > 1) for(Closeable c : (Closeable[])stream[1]) c.close();
		return new Object[]{ model, confdata };
	}
	
	private Vec3f newVec3f(String string1, String string2, String string3){
		return new Vec3f(parseF(string1), parseF(string2), parseF(string3));
	}

	private static final class TemporaryPolygon {
		
		public String group;
		public int index;
		public ModelRendererTurbo mrt = new ModelRendererTurbo(null);
		
	}
	
	public static TemporaryPolygon get(String group, String index, ArrayList<TemporaryPolygon> polis){
		int idx = parseI(index);
		for(TemporaryPolygon poly : polis){
			if(poly.group.equals(group) && poly.index == idx){
				return poly;
			}
		}
		return null;
	}
	
	public static int parseI(String string){
		return Integer.parseInt(string.replace(";", ""));
	}

    public static float parseF(String s){
        return Float.parseFloat(s.replace("F", ""));
    }

}
