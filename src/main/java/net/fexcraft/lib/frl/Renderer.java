package net.fexcraft.lib.frl;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class Renderer {
	
	public static Renderer RENDERER = new DefaultRenderer();
	
	public static boolean TRIANGULATED_QUADS = true;
	
	//TODO
	public abstract void render();

}
