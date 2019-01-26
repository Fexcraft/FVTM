package net.fexcraft.mod.fvtm.gui;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map.Entry;

import org.lwjgl.input.Mouse;

import net.fexcraft.mod.addons.gep.attributes.FuelTankExtensionAttribute.FuelTankExtensionAttributeData;
import net.fexcraft.mod.addons.gep.attributes.FuelTankExtensionAttribute;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.GenericGuiButton;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.api.Fuel.FuelItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.gui.veh.ContainerInventory;
import net.fexcraft.mod.fvtm.render.Renderer;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

@SuppressWarnings("deprecation")
public class VehicleInventoryGui {

    //x 0 = inv view
    //x 1 = pin view
    //x 2 = fuel view
    //x 3 = status view
    //x 4 = container view
    //x 5 = scripts view
    //x 6 = pfi view
    //y n = part id
    //z n = scroll
    private static final ResourceLocation maintex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory_main.png");
    private static final ResourceLocation invtex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory.png");
    private static final ResourceLocation fueltex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory_fuel.png");
    private static final ResourceLocation contex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory_container.png");
    //private static final ResourceLocation scrtex = new ResourceLocation("fvtm:textures/guis/vehicle_scripts.png");
    private static final ResourceLocation fluidtex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory_fluid.png");

    public static class Client extends GuiContainer {

        private VehicleEntity ent;
        private VehicleData data;
        private int x, y, z;
        private GenericGuiButton arrowUp, arrowDown, fuel, info;
        private GenericGuiButton[] parts;
        private int scroll;
        private static Server server;

        public Client(EntityPlayer player, World world, int x, int y, int z){
            super(server = new Server(player, world, x, y, z));
            this.x = x;
            this.y = y;
            this.z = z;
            ent = ((SeatEntity) player.getRidingEntity()).getVehicle();
            data = ((SeatEntity) player.getRidingEntity()).getVehicle().getVehicleData();
            switch(x){
                case 0: {
                    this.xSize = 168;
                    this.ySize = 153;
                    parts = new GenericGuiButton[9];
                    scroll = z;
                    break;
                }
                case 1: {
                    this.xSize = 226;
                    this.ySize = 195;
                    this.scroll = z;
                    break;
                }
                case 2:
                case 6: {
                    this.xSize = 210;
                    this.ySize = 126;
                    break;
                }
                case 3: {
                    //TODO
                    break;
                }
                case 4: {
                    this.xSize = 210;
                    this.ySize = 103;
                    break;
                }
                /*case 5: {
                    this.xSize = 168;
                    this.ySize = 153;
                    //
                    map = new TreeMap<String, VehicleScript>();
                    data.getScripts().forEach(vehscr -> vehscr.getSettingKeys(y).keySet().forEach(entry -> map.put(entry, vehscr)));
                    settings = new GenericGuiButton[18];
                    break;
                }*/
            }
        }

        @Override
        public void drawScreen(int mouseX, int mouseY, float partialTicks){
            this.drawDefaultBackground();
            super.drawScreen(mouseX, mouseY, partialTicks);
            this.renderHoveredToolTip(mouseX, mouseY);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
            int i = this.guiLeft, j = this.guiTop;
            switch(x){
                case 0: {
                    this.mc.getTextureManager().bindTexture(maintex);
                    this.drawTexturedModalRect(i, j, 0, 0, this.xSize + 12, this.ySize);
                    if(!Static.dev()){
                        this.fontRenderer.drawString(data.getVehicle().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
                    }
                    else{
                        this.fontRenderer.drawString(ent.getEntity().getEntityId() + " | " + data.getVehicle().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
                    }
                    break;
                }
                case 1: {
                    this.mc.getTextureManager().bindTexture(invtex);
                    this.drawTexturedModalRect(i, j, 0, 0, this.xSize + 16, this.ySize);
                    this.fontRenderer.drawString(data.getInventoryContainers().get(y).getPart().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
                    //
                    InventoryAttributeData invdata = data.getInventoryContainers().get(y).getAttributeData(InventoryAttributeData.class);
                    String curr = "&a" + ((z * 60) + 1) + "&c-&a" + ((z * 60 + 60) > invdata.getInventory().size() ? invdata.getInventory().size() : (z * 60 + 60));
                    this.fontRenderer.drawString(z + " (scr)", i + 171, j + 118, MapColor.SNOW.colorValue);
                    this.fontRenderer.drawString(Formatter.format(curr), i + 171, j + 146, MapColor.SNOW.colorValue);
                    this.fontRenderer.drawString(Formatter.format("&6" + invdata.getInventory().size() + " max"), i + 171, j + 160, MapColor.SNOW.colorValue);
                    break;
                }
                case 2: {
                    this.mc.getTextureManager().bindTexture(fueltex);
                    this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
                    int perducenti = (int) (data.getFuelTankContent() / data.getFuelTankSize() * 200);
                    this.drawTexturedModalRect(i + 6, j + 25, 0, 242, perducenti, 14);
                    //
                    String fipc = server.hasFuel() ? server.getFuelPercent() + "" : " - - ";//fuel item per cent
                    this.fontRenderer.drawString(data.getVehicle().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
                    this.fontRenderer.drawString(Formatter.format("&a" + (perducenti / 2) + "%"), i + 171, j + 91, MapColor.SNOW.colorValue);
                    this.fontRenderer.drawString(Formatter.format("&6" + fipc + "%"), i + 171, j + 77, MapColor.SNOW.colorValue);
                    this.fontRenderer.drawString(format(data.getFuelTankContent()) + " / " + data.getFuelTankSize(), i + 9, j + 28, MapColor.SNOW.colorValue);
                    break;
                }
                case 3: {
                    //TODO
                    break;
                }
                case 4: {
                    this.mc.getTextureManager().bindTexture(contex);
                    this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
                    this.fontRenderer.drawString(data.getContainerHolders().get(y).getPart().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
                    break;
                }
                /*case 5: {
                    this.mc.getTextureManager().bindTexture(scrtex);
                    this.drawTexturedModalRect(i, j, 0, 0, this.xSize + 12, this.ySize);
                    this.fontRenderer.drawString(data.getVehicle().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
                    List<VehicleScript> list = new ArrayList<VehicleScript>(data.getScripts());
                    TreeMap<String, VehicleScript> map = new TreeMap<String, VehicleScript>();
                    list.forEach(vehscr -> vehscr.getSettingKeys(y).keySet().forEach(entry -> map.put(entry, vehscr)));
                    for(int k = 0; k < 9; k++){
                        String str = (k + z) >= map.size() /*|| (k + z) < 0*//* ? null : (String) map.keySet().toArray()[k + z];
                        this.fontRenderer.drawString(str == null ? "" : str, i + 8, j + 22 + (k * 14), MapColor.BLACK_STAINED_HARDENED_CLAY.colorValue);
                        if(str == null){
                            this.fontRenderer.drawString(this.fontRenderer.trimStringToWidth("", 32), i + 120, j + 22 + (k * 14), MapColor.GREEN_STAINED_HARDENED_CLAY.colorValue);
                        }
                        else{
                            Object object = map.get(str).getSettingValue(y, str);
                            this.fontRenderer.drawString(this.fontRenderer.trimStringToWidth(object == null ? "null" : object.toString(), 32), i + 120, j + 22 + (k * 14), MapColor.GREEN_STAINED_HARDENED_CLAY.colorValue);
                        }
                    }
                    break;
                }*/
                case 6: {
                    this.mc.getTextureManager().bindTexture(fluidtex);
                    this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
                    InventoryAttributeData invattr = data.getInventoryContainers().get(y).getAttributeData(InventoryAttributeData.class);
                    int con = invattr.getFluidTank().getFluid() == null ? 0 : invattr.getFluidTank().getFluidAmount();
                    int perducenti = (int) (((float) con / invattr.getFluidTank().getCapacity()) * 200);
                    this.drawTexturedModalRect(i + 6, j + 25, 0, 242, perducenti, 14);
                    //
                    this.fontRenderer.drawString(data.getVehicle().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
                    this.fontRenderer.drawString(Formatter.format("&a" + server.getFluidItemAmount()), i + 171, j + 91, MapColor.SNOW.colorValue);
                    this.fontRenderer.drawString(Formatter.format("&6" + server.getFluidItemCapacity()), i + 171, j + 77, MapColor.SNOW.colorValue);
                    //this.fontRenderer.drawString((invattr.getFluidTank().getFluidAmount() / 1000) + " / " + (invattr.getFluidTank().getCapacity() / 1000), i + 9, j + 28, MapColor.SNOW.colorValue);
                    String fill = invattr.getFluidTank().getFluid() == null ? "empty" : invattr.getFluidTank().getFluid().getLocalizedName();
                    Renderer.drawTextOutlined(fontRenderer, con + "mB / " + invattr.getFluidTank().getCapacity() + "mB (" + fill + ")", i + 9, j + 28, MapColor.SNOW.colorValue);
                    break;
                }
            }
        }

        @Override
        public void handleMouseInput() throws IOException{
            super.handleMouseInput();
            try{
                int e = Mouse.getEventDWheel();
                if(e == 0){
                    return;
                }
                int both = data.getInventoryContainers().size() + data.getContainerHolders().size();
                int am = e > 0 ? -9 : 9;
                scroll += am;
                if(scroll < 0){
                    scroll = 0;
                }
                if(scroll + 9 > both){
                    scroll = both - 9;
                }
                arrowUp.enabled = scroll > 0;
                arrowDown.enabled = scroll + 9 < both;
                for(int i = 0; i < 9; i++){
                    int j = i + scroll, k = j - data.getInventoryContainers().size();
                    parts[i].displayString = j >= data.getInventoryContainers().size() ? (k >= data.getContainerHolders().size() ? "" : Formatter.format("&5" + j + "&e| &r" + data.getContainerHolders().get(k).getPart().getName())) : Formatter.format("&6" + j + "&e| &r" + data.getInventoryContainers().get(j).getPart().getName());
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        @Override
        protected void keyTyped(char typedChar, int keyCode) throws IOException {
            if(x == 4 && keyCode == 1){
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString("target_listener", "fvtm");
                nbt.setString("task", "open_gui");
                nbt.setInteger("gui", GuiHandler.VEHICLE_INVENTORY);
                nbt.setIntArray("args", new int[]{0, 0, z});
                PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
            }
            else{
                super.keyTyped(typedChar, keyCode);
            }
        }
        
        @Override
        protected void actionPerformed(GuiButton button){
            switch(x){
                case 0: {
                    switch(button.id){
                        case 0:
                        case 1: {
                            int both = data.getInventoryContainers().size() + data.getContainerHolders().size();
                            if(button.id == 0){
                                scroll--;
                                if(scroll < 0){
                                    scroll = 0;
                                }
                                //if(scroll - 1 >= 0){ scroll--; }
                            }
                            else{
                                scroll++;
                                if(scroll + 9 > both){
                                    scroll = both - 9;
                                }
                            }
                            arrowUp.enabled = scroll > 0;
                            arrowDown.enabled = scroll + 9 < both;
                            for(int i = 0; i < 9; i++){
                                int j = i + scroll, k = j - data.getInventoryContainers().size();
                                parts[i].displayString = j >= data.getInventoryContainers().size() ? (k >= data.getContainerHolders().size() ? "" : Formatter.format("&5" + j + "&e| &r" + data.getContainerHolders().get(k).getPart().getName())) : Formatter.format("&6" + j + "&e| &r" + data.getInventoryContainers().get(j).getPart().getName());
                            }
                            break;
                        }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10: {
                            y = (button.id - 2) + scroll;
                            NBTTagCompound nbt = new NBTTagCompound();
                            nbt.setString("target_listener", "fvtm");
                            nbt.setString("task", "open_gui");
                            nbt.setInteger("gui", GuiHandler.VEHICLE_INVENTORY);
                            if(y >= data.getInventoryContainers().size()){
                            	nbt.setInteger("gui", GuiHandler.VEH_INV_Container);
                                nbt.setIntArray("args", new int[]{ ent.getEntity().getEntityId(), y - data.getInventoryContainers().size(), 0 });
                            }
                            else{
                                InventoryAttribute attr = data.getInventoryContainers().get(y).getPart().getAttribute(InventoryAttribute.class);
                                nbt.setIntArray("args", new int[]{ attr.getType() == InventoryType.ITEM ? 1 : 6, y, scroll });
                            }
                            PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
                            break;
                        }
                        case 11:
                        case 12: {
                            NBTTagCompound nbt = new NBTTagCompound();
                            nbt.setString("target_listener", "fvtm");
                            nbt.setString("task", "open_gui");
                            nbt.setInteger("gui", GuiHandler.VEHICLE_INVENTORY);
                            nbt.setIntArray("args", new int[]{button.id - 9, 0, 0});
                            PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    switch(button.id){
                        case 0:
                        case 1: {
                            if(button.id == 0){
                                scroll--;
                                if(scroll < 0){
                                    scroll = 0;
                                }
                            }
                            else{
                                if((scroll + 1) * 60 <= data.getInventoryContainers().get(y).getAttributeData(InventoryAttribute.InventoryAttributeData.class).getInventory().size()){
                                    scroll++;
                                }
                            }
                            arrowUp.enabled = scroll > 0;
                            arrowDown.enabled = (scroll + 1) * 60 < data.getInventoryContainers().get(y).getAttributeData(InventoryAttribute.InventoryAttributeData.class).getInventory().size();
                            if(scroll != z){
                                NBTTagCompound nbt = new NBTTagCompound();
                                nbt.setString("target_listener", "fvtm");
                                nbt.setString("task", "open_gui");
                                nbt.setInteger("gui", GuiHandler.VEHICLE_INVENTORY);
                                nbt.setIntArray("args", new int[]{1, y, scroll});
                                PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
                            }
                            break;
                        }
                    }
                }
                case 2: {
                    //TODO
                    break;
                }
                case 3: {
                    //TODO
                    break;
                }
                case 4: {
                    //TODO
                    break;
                }
                /*case 5: {
                    if(button.id == 0 || button.id == 1){
                        scroll = button.id == 0 ? scroll - 1 : scroll + 1;
                        scroll = scroll < 0 ? 0 : scroll + 9 > map.size() ? map.size() - 9 : scroll;
                        arrowUp.enabled = scroll > 0;
                        arrowDown.enabled = scroll + 9 < map.size();
                    }
                    else{
                        int i = ((button.id - 2) - (button.id - 2 >= 9 ? 9 : 0)) + z;
                        Entry<String, VehicleScript> entry = (Entry<String, VehicleScript>) map.entrySet().toArray()[i];
                        String type = entry.getValue().getSettingKeys(y).get((String) map.keySet().toArray()[i]);
                        Object obj = map.get(entry.getKey()).getSettingValue(y, entry.getKey());
                        if(button.id >= 2 && button.id < 9 + 2){
                            switch(type){
                                case "boolean": {
                                    entry.getValue().onSettingsUpdate(ent, y, entry.getKey(), true);
                                    break;
                                }
                                case "integer": {
                                    int n = (int) obj;
                                    entry.getValue().onSettingsUpdate(ent, y, entry.getKey(), n + 1);
                                }
                            }
                        }
                        else if(button.id >= 9 + 2 && button.id < 18 + 2){
                            switch(type){
                                case "boolean": {
                                    entry.getValue().onSettingsUpdate(ent, y, entry.getKey(), false);
                                    break;
                                }
                                case "integer": {
                                    int n = (int) obj;
                                    entry.getValue().onSettingsUpdate(ent, y, entry.getKey(), n - 1);
                                }
                            }
                        }
                    }
                    //
                    NBTTagCompound nbt = new NBTTagCompound();
                    nbt.setString("target_listener", "fvtm");
                    nbt.setString("task", "open_gui");
                    nbt.setInteger("gui", GuiHandler.VEHICLE_INVENTORY);
                    nbt.setIntArray("args", new int[]{5, y, scroll});
                    PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
                }*/
            }
        }
        
        @Override
        public void initGui(){
            super.initGui();
            this.buttonList.clear();
            int i = this.guiLeft;
            int j = this.guiTop;
            switch(x){
                case 0: {
                    this.buttonList.add(arrowUp = new GenericGuiButton(0, 167 + i, 38 + j, 9, 12, ""));
                    arrowUp.setTexturePos(0, 192, 38);
                    arrowUp.setTexturePos(1, 183, 38);
                    arrowUp.setTexturePos(2, 210, 38);
                    arrowUp.setTexturePos(3, 201, 38);
                    arrowUp.setTexture(maintex);
                    arrowUp.enabled = scroll > 0;
                    this.buttonList.add(arrowDown = new GenericGuiButton(1, 167 + i, 56 + j, 9, 12, ""));
                    arrowDown.setTexturePos(0, 192, 56);
                    arrowDown.setTexturePos(1, 183, 56);
                    arrowDown.setTexturePos(2, 210, 56);
                    arrowDown.setTexturePos(3, 201, 56);
                    arrowDown.setTexture(maintex);
                    arrowDown.enabled = scroll + 9 < (data.getInventoryContainers().size() + data.getContainerHolders().size());
                    //
                    for(int k = 0; k < 9; k++){
                        int m = k + scroll;
                        int l = m - data.getInventoryContainers().size();
                        String name = m >= data.getInventoryContainers().size() ? (l >= data.getContainerHolders().size() ? "" : Formatter.format("&5" + l + "&e| &r" + data.getContainerHolders().get(l).getPart().getName())) : Formatter.format("&6" + m + "&e| &r" + data.getInventoryContainers().get(m).getPart().getName());
                        this.buttonList.add(parts[k] = new GenericGuiButton(k + 2, 5 + i, (19 + (k * 14)) + j, 158, 12, name));
                        parts[k].setTexture(maintex);
                        parts[k].setTexturePos(0, 0, 232);
                        parts[k].setTexturePos(1, 0, 244);
                        parts[k].setTexturePos(2, 0, 208);
                        parts[k].setTexturePos(3, 0, 220);
                        parts[k].enabled = !(parts[k].displayString == null || parts[k].displayString.equals(""));
                        parts[k].setTextPos(7 + i, (22 + (k * 14)) + j);
                    }
                    //
                    this.buttonList.add(fuel = new GenericGuiButton(11, 167 + i, 80 + j, 9, 12, ""));
                    this.buttonList.add(info = new GenericGuiButton(12, 167 + i, 98 + j, 9, 12, ""));
                    fuel.setTexturePos(0, 192, 80);
                    info.setTexturePos(0, 192, 98);
                    fuel.setTexturePos(1, 183, 80);
                    info.setTexturePos(1, 183, 98);
                    fuel.setTexturePos(2, 210, 80);
                    info.setTexturePos(2, 210, 98);
                    fuel.setTexturePos(3, 201, 80);
                    info.setTexturePos(3, 201, 98);
                    fuel.setTexture(maintex);
                    info.setTexture(maintex);
                    break;
                }
                case 1: {
                    this.buttonList.add(arrowUp = new GenericGuiButton(0, 225 + i, 127 + j, 12, 15, ""));
                    arrowUp.setTexturePos(0, 12, 211);
                    arrowUp.setTexturePos(1, 12, 196);
                    arrowUp.setTexturePos(2, 12, 226);
                    arrowUp.setTexturePos(3, 12, 241);
                    arrowUp.setTexture(invtex);
                    arrowUp.enabled = scroll > 0;
                    this.buttonList.add(arrowDown = new GenericGuiButton(1, 225 + i, 144 + j, 12, 15, ""));
                    arrowDown.setTexturePos(0, 0, 211);
                    arrowDown.setTexturePos(1, 0, 196);
                    arrowDown.setTexturePos(2, 0, 226);
                    arrowDown.setTexturePos(3, 0, 241);
                    arrowDown.setTexture(invtex);
                    arrowDown.enabled = (scroll + 1) * 60 < data.getInventoryContainers().get(y).getAttributeData(InventoryAttribute.InventoryAttributeData.class).getInventory().size();
                    break;
                }
                case 2: {
                    //TODO
                    break;
                }
                case 3: {
                    //TODO
                    break;
                }
                case 4: {
                    //TODO
                    break;
                }
                /*case 5: {
                    //
                    this.buttonList.add(arrowUp = new GenericGuiButton(0, 167 + i, 5 + j, 9, 12, ""));
                    arrowUp.setTexturePos(0, 220, 0);
                    arrowUp.setTexturePos(1, 229, 0);
                    arrowUp.setTexturePos(2, 238, 0);
                    arrowUp.setTexturePos(3, 247, 0);
                    arrowUp.setTexture(scrtex);
                    arrowUp.enabled = scroll > 0;
                    this.buttonList.add(arrowDown = new GenericGuiButton(1, 167 + i, 23 + j, 9, 12, ""));
                    arrowDown.setTexturePos(0, 220, 12);
                    arrowDown.setTexturePos(1, 229, 12);
                    arrowDown.setTexturePos(2, 238, 12);
                    arrowDown.setTexturePos(3, 247, 12);
                    arrowDown.setTexture(scrtex);
                    arrowDown.enabled = scroll + 9 < map.size();
                    //
                    for(int k = 0; k < 18; k++){
                        int l = (k >= 9 ? k - 9 : k) + z;
                        if(l >= map.size()){
                            continue;//break;
                        }
                        this.buttonList.add(settings[k] = new GenericGuiButton(k + 2, (k >= 9 ? 154 : 109) + i, 19 + j + (14 * (k >= 9 ? k - 9 : k)), 9, 12, ""));
                        settings[k].setTexturePos(0, 220, k >= 9 ? 12 : 0);
                        settings[k].setTexturePos(1, 229, k >= 9 ? 12 : 0);
                        settings[k].setTexturePos(2, 238, k >= 9 ? 12 : 0);
                        settings[k].setTexturePos(3, 247, k >= 9 ? 12 : 0);
                        settings[k].setTexture(scrtex);
                        Entry<String, VehicleScript> entry = (Entry<String, VehicleScript>) map.entrySet().toArray()[l];
                        String type = entry.getValue().getSettingKeys(y).get((String) map.keySet().toArray()[l]);
                        Object obj = map.get(entry.getKey()).getSettingValue(y, entry.getKey());
                        switch(type){
                            case "boolean": {
                                boolean b = (boolean)obj;
                                settings[k].enabled = k >= 9 ? b == true : b == false;
                                break;
                            }
                            case "integer": {
                                int n = (int)obj;
                                settings[k].enabled = k >= 9 ? n > -10000 : n < 10000;
                            }
                        }
                    }
                    //
                    break;
                }*/
            }
        }

        @SuppressWarnings("unused")
        private static void sendRefresh(int screen, int part, int scroll){

        }

        @Override
        public void onGuiClosed(){
            //TODO
        }

    }

    public static class Server extends Container {

        private EntityPlayer player;
        private int x, y/*, z*/;
        private TempPartInventory temp = null;
        private VehicleData data;
        //
        FuelInventory fuelinv;
        ContainerInventory coninv;
        FluidInventory fluidinv;
        InventoryAttributeData invattr;

        public Server(EntityPlayer player, World world, int x, int y, int z){
            this.player = player;
            this.x = x;
            this.y = y;
            /*this.z = z;*/
            data = ((SeatEntity)player.getRidingEntity()).getVehicle().getVehicleData();
            switch(x){
                case 0: {
                    //do nothing
                    break;
                }
                case 1: {
                    temp = new TempPartInventory(data.getInventoryContainers().get(y));
                    for(int row = 0; row < 5; row++){
                        for(int col = 0; col < 12; col++){
                            int index = (col + row * 12) + (z * 60);
                            if(index >= temp.getSizeInventory()){
                                break;
                            }
                            addSlotToContainer(new TempInventorySlot(temp, index, 6 + col * 18, 20 + row * 18, temp.getData(), null));
                        }
                    }
                    //
                    for(int row = 0; row < 3; row++){
                        for(int col = 0; col < 9; col++){
                            addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 6 + col * 18, 117 + row * 18));
                        }
                    }
                    for(int col = 0; col < 9; col++){
                        addSlotToContainer(new Slot(player.inventory, col, 6 + col * 18, 173));
                    }
                    break;
                }
                case 2: {
                    addSlotToContainer(new FuelInventory.FuelSlot(fuelinv = new FuelInventory(), 0, 179, 50, data));
                    //
                    for(int row = 0; row < 3; row++){
                        for(int col = 0; col < 9; col++){
                            addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 6 + col * 18, 48 + row * 18));
                        }
                    }
                    for(int col = 0; col < 9; col++){
                        addSlotToContainer(new Slot(player.inventory, col, 6 + col * 18, 104));
                    }
                    break;
                }
                case 3: {
                    //TODO
                    break;
                }
                case 4: {
                    //addSlotToContainer(new ContainerSlot(coninv = new ContainerInventory(data.getContainerHolders().get(y).getAttributeData(ContainerAttributeData.class)), 0, 179, 27));
                    //addSlotToContainer(new ContainerSlot(coninv, 1, 179, 59));
                    for(int row = 0; row < 3; row++){
                        for(int col = 0; col < 9; col++){
                            addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 6 + col * 18, 25 + row * 18));
                        }
                    }
                    for(int col = 0; col < 9; col++){
                        addSlotToContainer(new Slot(player.inventory, col, 6 + col * 18, 81));
                    }
                    break;
                }
                case 5: {
                    //TODO
                    break;
                }
                case 6: {
                    invattr = data.getInventoryContainers().get(y).getAttributeData(InventoryAttributeData.class);
                    addSlotToContainer(new FluidInventory.FluidSlot(fluidinv = new FluidInventory(), 0, 179, 50, data.getInventoryContainers().get(y)));
                    //
                    for(int row = 0; row < 3; row++){
                        for(int col = 0; col < 9; col++){
                            addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 6 + col * 18, 48 + row * 18));
                        }
                    }
                    for(int col = 0; col < 9; col++){
                        addSlotToContainer(new Slot(player.inventory, col, 6 + col * 18, 104));
                    }
                    break;
                }
            }
        }

        public String getFluidItemCapacity(){
            if(!fluidinv.getStackInSlot(0).isEmpty()){
                IFluidHandlerItem item = fluidinv.getStackInSlot(0).getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
                return item.getTankProperties()[0].getContents() == null ? "0" : "" + item.getTankProperties()[0].getCapacity();
            }
            return " - - - ";
        }

        public String getFluidItemAmount(){
            if(!fluidinv.getStackInSlot(0).isEmpty()){
                IFluidHandlerItem item = fluidinv.getStackInSlot(0).getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
                return item.getTankProperties()[0].getContents() == null ? "0" : "" + item.getTankProperties()[0].getContents().amount;
            }
            return " - - - ";
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int index){
            int slots = 0;
            switch(x){
                case 1: {
                    slots = 60;
                    break;
                }
                case 2: {
                    slots = 1;
                    break;
                }
                case 4: {
                    slots = 2;
                    break;
                }
                case 6: {
                    slots = 1;
                    break;
                }
            }
            ItemStack itemstack = ItemStack.EMPTY;
            Slot slot = this.inventorySlots.get(index);
            if(slot != null && slot.getHasStack()){
                ItemStack itemstack1 = slot.getStack();
                itemstack = itemstack1.copy();
                if(index < slots){
                    if(!this.mergeItemStack(itemstack1, slots, this.inventorySlots.size(), true)){
                        return ItemStack.EMPTY;
                    }
                }
                else if(!this.mergeItemStack(itemstack1, 0, slots, false)){
                    return ItemStack.EMPTY;
                }
                if(itemstack1.isEmpty()){
                    slot.putStack(ItemStack.EMPTY);
                }
                else{
                    slot.onSlotChanged();
                }
            }
            return itemstack;
        }

        public boolean hasFuel(){
            return fuelinv == null ? false : fuelinv.getStackInSlot(0).isEmpty() ? false : true;
        }

        public int getFuelPercent(){
            if(!hasFuel()){
                return 0;
            }
            ItemStack stack = fuelinv.getStackInSlot(0);
            FuelItem item = (FuelItem) stack.getItem();
            return (int) (item.getContent(stack) / item.maxCapacity(stack) * 100);
        }

        @Override
        public boolean canInteractWith(EntityPlayer player){
            return true;
        }

        @Override
        public void onContainerClosed(EntityPlayer player){
            super.onContainerClosed(player);
            if(fuelinv != null){
                fuelinv.closeInventory(player);
            }
            if(coninv != null){
                coninv.closeInventory(player);
            }
            if(fluidinv != null){
                fluidinv.closeInventory(player);
            }
        }

        private long date = -1;

        @Override
        public void detectAndSendChanges(){
            super.detectAndSendChanges();
            if((fuelinv != null && !fuelinv.isEmpty()) && date + 50 <= Time.getDate()){//1000
                date = Time.getDate();
                Print.debug("FUELINVTICK");
                ItemStack stack = fuelinv.getStackInSlot(0);
                FuelItem item = (FuelItem) stack.getItem();
                double con = 0.1;//2;//5//10
                //
                if(item.getContent(stack) > 0){
                    Print.debug("HASFUEL");
                    double d = item.getContent(stack) >= con ? con : item.getContent(stack);
                    if(data.getFuelTankContent() + d > data.getFuelTankSize()){
                        d = data.getFuelTankSize() - data.getFuelTankContent();
                        if(d > 0 && data.consumeFuel(-d)){
                            item.setContent(stack, item.getContent(stack) - d);
                        }
                    }
                    else{
                        if(data.consumeFuel(-d)){
                            item.setContent(stack, item.getContent(stack) - d);
                        }
                    }
                }
                if(!player.world.isRemote){
                    NBTTagCompound nbt = new NBTTagCompound();
                    nbt.setString("target_listener", "fvtm");
                    nbt.setString("cargo", "update_fuel_tanks");
                    NBTTagList list = new NBTTagList();
                    for(Entry<String, PartData> entry : data.getParts().entrySet()){
                        if(entry.getValue().getPart().getAttribute(FuelTankExtensionAttribute.class) == null){
                            continue;
                        }
                        NBTTagCompound compound = new NBTTagCompound();
                        compound.setString("part", entry.getKey());
                        compound.setDouble("amount", entry.getValue().getAttributeData(FuelTankExtensionAttributeData.class).getContent());
                        list.appendTag(compound);
                    }
                    nbt.setTag("parts", list);
                    PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(nbt), (EntityPlayerMP) player);
                }
            }
            //
            if((fluidinv != null && !fluidinv.isEmpty()) && date + 50 <= Time.getDate()){
                date = Time.getDate();
                ItemStack stack = fluidinv.getStackInSlot(0);
                boolean wasempty = invattr.getFluidTank().getFluid() == null;
                IFluidHandlerItem item = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
                if(fluidinv.isnew){
                    fluidinv.isnew = false;
                    fluidinv.lastaction = item.getTankProperties()[0].getContents() == null ? 1 : -1;
                }
                if(item.getTankProperties().length > 0){
                    if(fluidinv.lastaction == -1 && item.getTankProperties()[0].getContents() != null && item.getTankProperties()[0].getContents().amount > 0){
                        FluidActionResult result = FluidUtil.tryEmptyContainer(stack, invattr.getFluidTank(), 1000, player, true);
                        if(result.success){
                            fluidinv.setInventorySlotContents(0, result.getResult() == null ? ItemStack.EMPTY : result.getResult());
                        }
                    }
                    else if(fluidinv.lastaction == 1){
                        FluidActionResult result = FluidUtil.tryFillContainer(stack, invattr.getFluidTank(), 1000, player, true);
                        if(result.success){
                            fluidinv.setInventorySlotContents(0, result.getResult() == null ? ItemStack.EMPTY : result.getResult());
                        }
                    }
                    else{
                        //
                    }
                }
                if(!player.world.isRemote){
                    NBTTagCompound nbt = new NBTTagCompound();
                    nbt.setString("target_listener", "fvtm");
                    nbt.setString("cargo", "update_fluid_tank");
                    nbt.setBoolean("wasempty", wasempty);
                    nbt.setTag("state", invattr.getFluidTank().writeToNBT(new NBTTagCompound()));
                    nbt.setInteger("tank", y);
                    PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(nbt), (EntityPlayerMP) player);
                }
            }
            //
        }

    }

    private static final DecimalFormat df = new DecimalFormat("##.#");

    static{
        df.setRoundingMode(RoundingMode.DOWN);
    }

    public static String format(double d){
        return df.format(d);
    }

}