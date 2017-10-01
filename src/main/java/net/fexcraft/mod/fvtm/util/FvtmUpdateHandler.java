package net.fexcraft.mod.fvtm.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.lib.network.Network;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;

public class FvtmUpdateHandler {
	
	private static JsonArray msg;
	private static Side side;
	
	public static void load(){
		JsonObject obj = Network.getModData("fvtm");
		JsonObject jsn = null;
		if(obj != null && obj.has("notifications")){
			JsonArray array = obj.get("notifications").getAsJsonArray();
			for(JsonElement elm : array){
				if(elm.getAsJsonObject().has("version") && elm.getAsJsonObject().get("version").getAsString().equals(FVTM.VERSION)){
					jsn = elm.getAsJsonObject();
				}
			}
		}
		if(jsn != null){
			try{
				if(jsn.has("side")){
					switch(jsn.get("side").getAsString()){
						case "server":
							side = Side.SERVER;
							break;
						case "client":
							side = Side.CLIENT;
							break;
						case "both":
						case "all":
						default:
							side = null;
							break;
					}
				}
				else{
					side = null;
				}
				msg = jsn.get("lines").getAsJsonArray();
			}
			catch(Exception e){
				//
			}
		}
	}

	public static void register(){
		if(msg != null && (side == null ? true : side == Static.side())){
			MinecraftForge.EVENT_BUS.register(new FvtmUpdateHandler());
		}
	}
	
	@SubscribeEvent
	public void onJoin(PlayerLoggedInEvent event){
		for(JsonElement elm : msg){
			Print.chat(event.player, elm.getAsString());
		}
	}
	
}