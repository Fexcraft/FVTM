package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.uni.ui.UIButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ColorPaletteUtil {

	private static File palette_file;

	public static void load(UIButton button){
		palette_file = new File(FvtmRegistry.CONFIG_DIR, "/fvtm/custom_palette.fvtm");
		if(!palette_file.exists()) palette_file.getParentFile().mkdirs();
		try{
			if(!palette_file.exists()) return;
			FileInputStream stream = new FileInputStream(palette_file);
			int r = 0, i = 0;
			while(r >= 0 || i >= button.palette[0].length){
				byte[] bit = new byte[4];
				r = stream.read(bit);
				if(r < 0) break;
				button.palette[0][i++].packed = ByteBuffer.wrap(bit).getInt();
			}
			stream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void save(UIButton button, RGB current){
		try{
			for(int i = button.palette[0].length - 2; i >= 0; i--){
				button.palette[0][i + 1].packed = button.palette[0][i].packed;
			}
			button.palette[0][0].packed = current.packed;
			FileOutputStream stream = new FileOutputStream(palette_file);
			for(RGB color : button.palette[0]){
				stream.write(ByteBuffer.allocate(4).putInt(color.packed).array());
			}
			stream.flush();
			stream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
