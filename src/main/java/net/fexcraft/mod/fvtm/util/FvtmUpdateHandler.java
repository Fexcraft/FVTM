package net.fexcraft.mod.fvtm.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.network.Network;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;

public class FvtmUpdateHandler {

    /**
     * Updated from Mod's (update) JSON if changed.
     */
    public static String WIKIURL = "https://github.com/Fexcraft/FVTM/wiki";
    private static String newversion;
    private static JsonArray msg;
    private static Side side;

    public static void load(){
        JsonObject obj = Network.getModData("fvtm");
        JsonObject jsn = null;
        if(obj != null){
            if(obj.has("notifications")){
                JsonArray array = obj.get("notifications").getAsJsonArray();
                for(JsonElement elm : array){
                    if(elm.getAsJsonObject().has("version") && elm.getAsJsonObject().get("version").getAsString().equals(FVTM.VERSION)){
                        jsn = elm.getAsJsonObject();
                    }
                }
            }
            if(obj.has("versions")){
                JsonArray array = obj.get("versions").getAsJsonArray();
                for(JsonElement elm : array){
                    if(elm.getAsJsonObject().get("version").getAsString().equals(FCL.mcv)){
                        newversion = elm.getAsJsonObject().get("latest_version").getAsString();
                    }
                }
            }
            else if(obj.has("latest_version")){
                newversion = obj.get("latest_version").getAsString();
            }
            if(obj.has("wiki-url")){
                WIKIURL = obj.get("wiki-url").getAsString();
            }
        }
        else{
            //Static.stop();
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
        MinecraftForge.EVENT_BUS.register(new FvtmUpdateHandler());
    }

    @SubscribeEvent
    public void onJoin(PlayerLoggedInEvent event){
        if(side == Static.side()){
            for(JsonElement elm : msg){
                Print.chat(event.player, elm.getAsString());
            }
        }
        if(newversion != null && !newversion.equals(FVTM.VERSION)){
            Print.chat(event.player, "&0[&9FVTM&0]&7 === === &5=&6=&5=&7 === ===");
            Print.chat(event.player, "&7Mod update is available! &9(&a" + newversion + "&0 | &c" + FVTM.VERSION + "&9)");
            Print.debug(newversion + " || " + FVTM.VERSION);
        }
    }

}
