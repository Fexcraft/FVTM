package net.fexcraft.mod.fvtm.gui;

import java.io.IOException;
import java.text.DecimalFormat;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.sys.legacy.KeyPress;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.util.handler.KeyHandler;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

public class GuiVehicleController extends GuiScreen {

    private SeatEntity seat;

    public GuiVehicleController(SeatEntity entity){
        super(); this.seat = entity;
    }

    @Override
    public void initGui(){
        /*if(mc.gameSettings.thirdPersonView == 1){ mc.setRenderViewEntity(seat.vehicle.getCamera() == null ? mc.player : seat.vehicle.getCamera()); }*/
    }

    @Override
    public void onGuiClosed(){
        mc.mouseHelper.ungrabMouseCursor();
        mc.setRenderViewEntity(mc.player);
    }

    @Override
    public void handleMouseInput(){
        EntityPlayer player = (EntityPlayer) seat.getControllingPassenger();
        if(player != mc.player){ mc.displayGuiScreen(null); return; }
        int wheel = Mouse.getDWheel();
        if(wheel != 0){ player.inventory.changeCurrentItem(wheel); }
        //
        if(Mouse.isButtonDown(0)){ seat.onKeyPress(KeyPress.MOUSE_MAIN, player); }
        if(Mouse.isButtonDown(1)){ seat.onKeyPress(KeyPress.MOUSE_RIGHT, player); }
    }

    @Override
    protected void keyTyped(char c, int i){
        switch(i){
            case 1: {
                mc.displayGuiScreen(null);
                mc.displayInGameMenu();
                return;
            }
            case 59: {
                mc.gameSettings.hideGUI = !mc.gameSettings.hideGUI;
                return;
            }
            case 61: {
                mc.gameSettings.showDebugInfo = !mc.gameSettings.showDebugInfo;
                return;
            }
            case 63: {
                mc.gameSettings.thirdPersonView = (mc.gameSettings.thirdPersonView + 1) % 3;
                if(mc.gameSettings.thirdPersonView == 1){
                    mc.setRenderViewEntity(mc.player);
                }
                else{
                    mc.setRenderViewEntity(mc.player);
                }
                return;
            }
            case 66: {
                mc.gameSettings.smoothCamera = !mc.gameSettings.smoothCamera;
                return;
            }
            default:
                break;
        }
        if(i == mc.gameSettings.keyBindInventory.getKeyCode()){
            mc.displayGuiScreen(new GuiInventory(mc.player));
        }
        if(i == mc.gameSettings.keyBindDrop.getKeyCode()){
            mc.player.getHeldItem(EnumHand.MAIN_HAND);
        }
        if(i == mc.gameSettings.keyBindChat.getKeyCode()){
            mc.displayGuiScreen(new GuiChat());
        }
        if(i == mc.gameSettings.keyBindCommand.getKeyCode()){
            mc.displayGuiScreen(new GuiChat("/"));
        }
    }

    @Override
    public void updateScreen(){
        /*if(mc.gameSettings.thirdPersonView == 1){
			mc.setRenderViewEntity(seat.vehicle.getCamera() == null ? mc.player : seat.vehicle.getCamera());
		} else mc.setRenderViewEntity(mc.player);*/
    }

    private int s = 0;

    @Override
    public void handleInput(){
        EntityPlayer player = (EntityPlayer) seat.getControllingPassenger();
        if(player != mc.player){
            mc.displayGuiScreen(null);
            return;
        }
        if(!Mouse.isGrabbed()){
            mc.mouseHelper.grabMouseCursor();
        }
        handleMouseInput();
        seat.onMouseMoved(Mouse.getDX(), Mouse.getDY());
        for(; Keyboard.next();){
            try{
                handleKeyboardInput();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        if(seat != null && seat.getControllingPassenger() instanceof EntityPlayer){
            if(isKeyDown(mc.gameSettings.keyBindForward.getKeyCode())){
                seat.onKeyPress(KeyPress.ACCELERATE, player);
            }
            if(isKeyDown(mc.gameSettings.keyBindBack.getKeyCode())){
                seat.onKeyPress(KeyPress.DECELERATE, player);
            }
            if(isKeyDown(mc.gameSettings.keyBindLeft.getKeyCode())){
                seat.onKeyPress(KeyPress.TURN_LEFT, player);
            }
            if(isKeyDown(mc.gameSettings.keyBindRight.getKeyCode())){
                seat.onKeyPress(KeyPress.TURN_RIGHT, player);
            }
            if(isKeyDown(mc.gameSettings.keyBindJump.getKeyCode())){
                seat.onKeyPress(KeyPress.BRAKE, player);
            }
            if(isKeyDown(KeyHandler.engineToggle.getKeyCode())){
                seat.onKeyPress(KeyPress.ENGINE, player);
            }
            if(isKeyDown(mc.gameSettings.keyBindSneak.getKeyCode())){
                seat.onKeyPress(KeyPress.DISMOUNT, player);
            }
            if(isKeyDown(KeyHandler.openInventory.getKeyCode())){
                seat.onKeyPress(KeyPress.INVENTORY, player);
            }
            if(isKeyDown(KeyHandler.doorToggle.getKeyCode())){
                seat.onKeyPress(KeyPress.DOORS, player);
            }
            if(isKeyDown(KeyHandler.scriptsGUI.getKeyCode())){
                seat.onKeyPress(KeyPress.SCRIPTS, player);
            }
            if(isKeyDown(KeyHandler.lightsToggle.getKeyCode())){
                seat.onKeyPress(KeyPress.LIGHTS, player);
            }
            if(isKeyDown(KeyHandler.trailerToggle.getKeyCode())){
                seat.onKeyPress(KeyPress.COUPLER_REAR, player);
            }
            if(isKeyDown(KeyHandler.wagonToggle.getKeyCode())){
            	seat.onKeyPress(KeyPress.COUPLER_FRONT, player);
            }
            if(s > 0){ s--; } if(s == 0){ seat.onKeyPress(null, player); s = 4;/*//5//20//10//4*/ }
        }
        else{
            mc.displayGuiScreen(null);
        }
    }

    public boolean isKeyDown(int keycode){
        return keycode < 0 ? Mouse.isButtonDown(keycode + 100) : keycode > 255 ? /* invalid code - PASS */ false : Keyboard.isKeyDown(keycode);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        LandVehicle ent = seat.getVehicle(); if(ent == null){ return; }
        if(!ent.getVehicleData().hasPart("engine")){
            mc.fontRenderer.drawString("No Engine installed.", 7, 7, 0xffffff);
            return;
        }
        mc.fontRenderer.drawString(Formatter.format("Speed: " + calculateSpeed(ent.getEntity())), 7, 7, 0xffffff);
        mc.fontRenderer.drawString(Formatter.format("Throttle: " + throttleColour(ent.throttle) + pc(ent.throttle) + "%"), 7, 21, 0xffffff);
        //mc.fontRenderer.drawString(Formatter.format("Fuel: " + fuelColour(ent.getVehicleData()) + format(ent.getVehicleData().getFuelTankContent()) + "&f/&b" + ent.getVehicleData().getFuelTankSize()), 7, 35, 0xffffff);
    }

    /*private String fuelColour(VehicleData data){
        double d = data.getFuelTankContent() / data.getFuelTankSize();
        //return d < 0.3 ? "&e" : d < 0.1 ? "&c" : "&a";
        return d < 0.3 ? d < 0.1 ? "&c" : "&e" : "&a";
    }*/

    private String throttleColour(double throttle){
        if(throttle > 0.7){
            return throttle > 0.9 ? "&c" : "&e";
        }
        if(throttle < -0.7){
            return throttle < -0.9 ? "&c" : "&e";
        }
        return "&f";
    }

    private String pc(double f){
        return format(f * 100);
    }

    private static final DecimalFormat df = new DecimalFormat("##.##");
    //static { df.setRoundingMode(RoundingMode.DOWN); }

    public static String format(double d){
        return df.format(d);
    }

    public static final float calculateSpeed(Entity ent){
        double dX = ent.posX - ent.prevPosX, dY = ent.posY - ent.prevPosY, dZ = ent.posZ - ent.prevPosZ;
        float speed = (float) Math.sqrt(dX * dX + dY * dY + dZ * dZ) * 1000F / 16F;
        return speed = (int) (speed * 10F) / 10F;
    }

    @Override
    public boolean doesGuiPauseGame(){
        return false;
    }

}
