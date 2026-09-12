package net.fexcraft.mod.fvtm.model.loaders;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.lib.frl.gen.Generator.Values.*;
import static net.fexcraft.mod.fvtm.FvtmLogger.LOGGER;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.fexcraft.lib.common.math.V3F;
import net.fexcraft.lib.frl.DefaultRenderer;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.gen.Generator;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.FvtmResources.InputStreamWithFallback;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelLoader;

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
	public boolean load(String loc, ModelData confdata, DefaultModel model) throws Exception {
		InputStreamWithFallback iswf = FvtmResources.getAssetInputStreamWithFallback(loc);
		//
        String line = null;
        Scanner scanner = new Scanner(iswf.stream());
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
            		model.name = line.split(" ")[2].substring(5);
            		continue;
            	}
            	if(line.startsWith("int textureX")){
            		model.tex_width = parseI(line.split(" ")[3]);
            		continue;
            	}
            	if(line.startsWith("int textureY")){
            		model.tex_height = parseI(line.split(" ")[3]);
            		continue;
            	}
            	Matcher matcher = groupdef.matcher(line);
            	if(matcher.matches()){
            		model.groups.add(new ModelGroup(matcher.group(1)));
            		continue;
            	}
            	matcher = creator.matcher(line);
            	if(matcher.matches()){
					model.addToCreators(matcher.group(1));
            		continue;
            	}
            	matcher = declaration.matcher(line);
            	if(matcher.matches()){
            		TemporaryPolygon poly = new TemporaryPolygon();
            		poly.group = matcher.group(1);
            		poly.index = parseI(matcher.group(2));
            		poly.hedron.texU = parseI(matcher.group(3));
            		poly.hedron.texV = parseI(matcher.group(4));
            		poly.hedron.name = matcher.group(5).replace(" // ", "");
            		polis.add(poly);
            		continue;
            	}
            	matcher = box.matcher(line);
            	if(matcher.matches()){
            		boolean shapebox = line.contains("ShapeBox");
            		TemporaryPolygon poly = get(matcher.group(1), matcher.group(2), polis);
            		String[] array = matcher.group(3).split(", ");
					Generator gen = new Generator(poly.hedron, Generator.Type.CUBOID);
					gen.set(TEXTURE_WIDTH, model.tex_width);
					gen.set(TEXTURE_HEIGHT, model.tex_height);
					gen.set(SCALE, sixteenth);
					gen.set(OFF_X, parseF(array[0]));
					gen.set(OFF_Y, parseF(array[1]));
					gen.set(OFF_Z, parseF(array[2]));
					gen.set(WIDTH, parseF(array[3]));
					gen.set(HEIGHT, parseF(array[4]));
					gen.set(DEPTH, parseF(array[5]));
            		if(shapebox){
						ArrayList<V3F> corners = new ArrayList<>();
            			corners.add(newV3F(array[7], array[8], array[9]));
            			corners.add(newV3F(array[10], array[11], array[12]));
            			corners.add(newV3F(array[13], array[14], array[15]));
            			corners.add(newV3F(array[16], array[17], array[18]));
            			corners.add(newV3F(array[19], array[20], array[21]));
            			corners.add(newV3F(array[22], array[23], array[24]));
            			corners.add(newV3F(array[25], array[26], array[27]));
            			corners.add(newV3F(array[28], array[29], array[30]));
            		}
            		model.groups.get(poly.group).add(gen.make());
					for(Polygon p : poly.hedron.polygons) DefaultRenderer.genNorm(p);
					poly.hedron.posX *= sixteenth;
					poly.hedron.posY *= sixteenth;
					poly.hedron.posZ *= sixteenth;
            		continue;
            	}
            	matcher = rotpoint.matcher(line);
            	if(matcher.matches()){
            		TemporaryPolygon poly = get(matcher.group(1), matcher.group(2), polis);
            		String[] array = matcher.group(3).split(", ");
            		poly.hedron.rotX = parseF(array[0]);
            		poly.hedron.rotY = parseF(array[1]);
            		poly.hedron.rotZ = parseF(array[2]);
            		continue;
            	}
            	matcher = pospoint.matcher(line);
            	if(matcher.matches()){
            		TemporaryPolygon poly = get(matcher.group(1), matcher.group(2), polis);
            		String[] array = matcher.group(3).split(", ");
            		poly.hedron.posX = parseF(array[0]);
            		poly.hedron.posY = parseF(array[1]);
            		poly.hedron.posZ = parseF(array[2]);
            		continue;
            	}
            	matcher = rotangle.matcher(line);
            	if(matcher.matches()){
            		TemporaryPolygon poly = get(matcher.group(1), matcher.group(2), polis);
            		String axis = matcher.group(3).toLowerCase();
            		float value = parseF(matcher.group(4));
            		switch(axis){
            			case "x":{
            				poly.hedron.rotX = (float)Math.toDegrees(value);
            				break;
            			}
            			case "y":{
            				poly.hedron.rotY = (float)Math.toDegrees(value);
            				break;
            			}
            			case "z":{
            				poly.hedron.rotZ = (float)Math.toDegrees(value);
            				break;
            			}
            		}
            		continue;
            	}
        	}
        	catch(Exception e){
        		LOGGER.log("Failed to load SMP TB Model.");
            	LOGGER.log("Parsing error at line [" + linenumber + "]: " + line);
            	continue;
        	}
        }
    	scanner.close();
    	//
		iswf.close();
		return true;
	}
	
	private V3F newV3F(String string1, String string2, String string3){
		return new V3F(parseF(string1), parseF(string2), parseF(string3));
	}

	public static final class TemporaryPolygon {

		public Polyhedron hedron = new Polyhedron();
		public String group;
		public int index;
		
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
