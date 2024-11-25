package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.ContentData;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.function.block.BoolBlockFunction;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockData extends ContentData<Block, BlockData> implements TextureUser, Colorable {

    protected Textureable texture;
    protected Map<String, RGB> channels = new LinkedHashMap<>();
    protected ArrayList<BlockFunction> functions = new ArrayList<>();
    protected ArrayList<BoolBlockFunction> boolfuns = new ArrayList<>();
    protected Object invfunc;

    public BlockData(Block block){
        super(block);
        texture = new Textureable(block);
        for(Map.Entry<String, RGB> entry : block.getDefaultColorChannels().entrySet()){
            channels.put(entry.getKey(), entry.getValue().copy());
        }
        for(BlockFunction func : type.getFunctions()){
            functions.add(func.copy(type));
        }
        for(BlockFunction func : functions){
            if(func instanceof BoolBlockFunction){
                boolfuns.add((BoolBlockFunction)func);
            }
            if(func.getClass().getName().contains("InventoryBlockFunction")){
                invfunc = func;
            }
        }
    }

    @Override
    public TagCW write(TagCW compound){
        if(compound == null) compound = TagCW.create();
        compound.set("Block", type.getIDS());
        texture.save(compound);
        for(String str : channels.keySet()){
            compound.set("RGB_" + str, channels.get(str).packed);
        }
        TagCW com = TagCW.create();
        for(BlockFunction func : functions) func.save(com);
        if(!com.empty()) compound.set("BlockFunction", com);
        return compound;
    }

    @Override
    public BlockData read(TagCW compound){
        if(compound == null) compound = TagCW.create();
        texture.load(compound);
        for(String str : channels.keySet()){
            if(compound.has("RGB_" + str)){
                channels.get(str).packed = compound.getInteger("RGB_" + str);
            }
        }
        if(compound.has("BlockFunction")){
            TagCW com = compound.getCompound("BlockFunction");
            for(BlockFunction func : functions) func.load(com);
        }
        return this;
    }

    @Override
    public BlockData parse(JsonMap obj){
        return null;
    }

    @Override
    public JsonMap toJson(){
        return new JsonMap();
    }

    @Override
    public RGB getColorChannel(String channel){
        return channels.get(channel);
    }

    @Override
    public void setColorChannel(String channel, RGB color){
        RGB rgb = channels.get(channel);
        if(rgb != null) rgb.packed = color.packed;
    }

    @Override
    public Map<String, RGB> getColorChannels(){
        return channels;
    }

    @Override
    public Textureable getTexture(){
        return texture;
    }

    @Override
    public Textureable.TextureHolder getTexHolder(){
        return type;
    }

    public boolean getFunctionBool(String key){
        for(BoolBlockFunction func : boolfuns){
            if(func.key().equals(key)) return func.val();
        }
        return false;
    }

    public BoolBlockFunction getFunctionBoolInst(String key){
        for(BoolBlockFunction func : boolfuns){
            if(func.key().equals(key)) return func;
        }
        return null;
    }

    public Object getFunctionInventory(){
        return invfunc;
    }

    public ArrayList<BlockFunction> getFunctions(){
        return functions;
    }

    public RelayData getRelayData(){
        return type.relaydata;
    }

	public BlockType getBlockType(){
        return type.blocktype;
	}

}
