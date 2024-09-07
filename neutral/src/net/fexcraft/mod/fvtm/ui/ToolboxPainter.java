package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ToolboxPainter extends UserInterface {

	private ArrayList<String> channels = new ArrayList<>();
	public String selchan;
	public RGB current = new RGB();
	private File cachedcolors = null;

	public ToolboxPainter(JsonMap map, ContainerInterface con) throws Exception {
		super(map, con);
	}

	@Override
	public void init(){
		channels.addAll((Collection<? extends String>)container.get("channel_keys"));
		selchan = channels.get(0);
		setupSpectrum();
		setupShadePalette();
		updateColors();
		cachedcolors = new File(FvtmRegistry.CONFIG_DIR, "/fvtm/custom_palette.fvtm");
		if(!cachedcolors.exists()) cachedcolors.getParentFile().mkdirs();
		loadColorCache();
	}

	private void setupSpectrum(){
		UIButton spec = buttons.get("pal_hor");
		for(int i = 0; i < spec.palette[0].length; i++){
			float c = i * (1f / spec.palette[0].length);
			int r, g, b;
			if(c >= 0 && c <= (1 / 6.f)){
				r = 255;
				g = (int)(1530 * c);
				b = 0;
			}
			else if(c > (1 / 6.f) && c <= (1 / 3.f)){
				r = (int)(255 - (1530 * (c - 1 / 6f)));
				g = 255;
				b = 0;
			}
			else if(c > (1 / 3.f) && c <= (1 / 2.f)){
				r = 0;
				g = 255;
				b = (int)(1530 * (c - 1 / 3f));
			}
			else if(c > (1 / 2f) && c <= (2 / 3f)){
				r = 0;
				g = (int)(255 - ((c - 0.5f) * 1530));
				b = 255;
			}
			else if(c > (2 / 3f) && c <= (5 / 6f)){
				r = (int)((c - (2 / 3f)) * 1530);
				g = 0;
				b = 255;
			}
			else if(c > (5 / 6f) && c <= 1){
				r = 255;
				g = 0;
				b = (int)(255 - ((c - (5 / 6f)) * 1530));
			}
			else{
				r = 127;
				g = 127;
				b = 127;
			}
			spec.palette[0][i] = new RGB(r, g, b);
		}
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		switch(id){
			case "prev":{
				int idx = channels.indexOf(selchan);
				if(idx == 0) selchan = channels.get(channels.size() - 1);
				else selchan = channels.get(idx - 1);
				current.packed = ((RGB)container.get("color", selchan)).packed;
				updateColors();
				break;
			}
			case "next":{
				int idx = channels.indexOf(selchan);
				if(idx + 1 >= channels.size()) selchan = channels.get(0);
				else selchan = channels.get(idx + 1);
				current.packed = ((RGB)container.get("color", selchan)).packed;
				updateColors();
				break;
			}
			case "pal_hor":
			case "pal_save": {
				int idx = (x - button.x) / button.palsize[0];
				if(idx < 0) idx = 0;
				if(idx >= button.palette[0].length) idx = button.palette[0].length - 1;
				RGB rgb = button.palette[0][idx];
				current.packed = rgb.packed;
				updateColors();
				break;
			}
			case "pal_shade":{
				int ix = (x - button.x) / button.palsize[0];
				int iy = (y - button.y) / button.palsize[1];
				if(ix < 0) ix = 0;
				if(ix >= button.palette[0].length) ix = button.palette[0].length - 1;
				if(iy < 0) iy = 0;
				if(iy >= button.palette.length) iy = button.palette.length - 1;
				RGB rgb = button.palette[iy][ix];
				current.packed = rgb.packed;
				updateColors(mb == 0);
				break;
			}
			case "hex":{
				try{
					int i = Integer.parseInt(fields.get("hex").text().replace("#", ""), 16);
					current.packed = i;
					updateColors();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case "rgb":{
				try{
					String[] split = fields.get("rgb").text().split(",");
					int[] arr = new int[]{ 255, 255, 255 };
					for(int i = 0; i < split.length; i++){
						arr[i] = Integer.parseInt(split[i].trim());
						if(arr[i] < 0) arr[i] = 0;
						if(arr[i] > 255) arr[i] = 255;
					}
					current = new RGB(arr[0], arr[1], arr[2]);
					updateColors();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case "select":{
				TagCW com = TagCW.create();
				com.set("task", "apply");
				com.set("channel", selchan);
				com.set("color", current.packed);
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "colorpicker":{
				try{
					new Thread(){
						@Override
						public void run(){
							Color color = JColorChooser.showDialog(null, "select color", new Color(current.packed));
							current.packed = new RGB(color.getRGB()).packed;
							updateColors();
						}
					}.start();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case "save":{
				saveColorCache();
				break;
			}
			case "help":{
				container.get("open_wiki");
				break;
			}
			default:{
				break;
			}
		}
		return false;
	}

	private void updateColors(){
		updateColors(true);
	}

	private void updateColors(boolean shade){
		buttons.get("selected").ecolor.packed = current.packed;
		texts.get("channel").value(selchan);
		fields.get("hex").text(Integer.toHexString(current.packed));
		byte[] arr = current.toByteArray();
		fields.get("rgb").text((arr[0] + 128) + ", " + (arr[1] + 128) + ", " + (arr[2] + 128));
		if(shade) setupShadePalette();
	}

	private void setupShadePalette(){
		UIButton shade = buttons.get("pal_shade");
		byte[] arr = current.toByteArray();
		int[] err = new int[] { arr[0] + 128, arr[1] + 128, arr[2] + 128 };
		for(int x = 0; x < shade.palette.length; x++){
			for(int z = 0; z < shade.palette[x].length; z++){
				int y = z * shade.palette.length + x;
				float e = (1f / (shade.palette.length * shade.palette[x].length) * y);
				float f = (1f / shade.palette.length) * x;
				float h = (255 / shade.palette.length) * z;
				int r = (int)Math.abs((e * err[0]) + ((1 - f) * h));
				int g = (int)Math.abs((e * err[1]) + ((1 - f) * h));
				int l = (int)Math.abs((e * err[2]) + ((1 - f) * h));
				shade.palette[x][z] = new RGB(r, g, l);
			}
		}
	}

	private void loadColorCache(){
		try{
			if(!cachedcolors.exists()) return;
			FileInputStream stream = new FileInputStream(cachedcolors);
			UIButton button = buttons.get("pal_save");
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

	private void saveColorCache(){
		try{
			UIButton button = buttons.get("pal_save");
			for(int i = button.palette[0].length - 2; i >= 0; i--){
				button.palette[0][i + 1].packed = button.palette[0][i].packed;
			}
			button.palette[0][0].packed = current.packed;
			FileOutputStream stream = new FileOutputStream(cachedcolors);
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
