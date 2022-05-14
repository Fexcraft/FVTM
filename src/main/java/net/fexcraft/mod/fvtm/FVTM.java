package net.fexcraft.mod.fvtm;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.fexcraft.mod.fvtm.test.RenderLast;
import net.fexcraft.mod.fvtm.test.TestBlock;
import net.fexcraft.mod.fvtm.test.TestTile;
import net.fexcraft.mod.fvtm.test.TestTileRenderer;
import net.fexcraft.mod.fvtm.util.Config;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod("fvtm")
public class FVTM {
	
	public static final String MODID = "fvtm";
	
    private static final Logger LOGGER = LogUtils.getLogger();
    
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);
    public static final RegistryObject<Block> TEST_BLK = BLOCKS.register("test", () -> new TestBlock());
    public static final RegistryObject<BlockEntityType<TestTile>> TEST_TILE = TILES.register("test", () -> BlockEntityType.Builder.of(TestTile::new, TEST_BLK.get()).build(null));

    public FVTM(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        MinecraftForge.EVENT_BUS.register(this);
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event){
    	Config.load();
    	MinecraftForge.EVENT_BUS.register(new RenderLast());
    }

    private void enqueueIMC(final InterModEnqueueEvent event){
        //InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event){
        //LOGGER.info("Got IMC {}", event.getIMCStream().map(m -> m.messageSupplier().get()).collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){
        //
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    	
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> event){
            // register blocks
        }
        
        @SubscribeEvent
        public static void onRenderRegistry(EntityRenderersEvent.RegisterRenderers event){
            event.registerBlockEntityRenderer(TEST_TILE.get(), new BlockEntityRendererProvider<TestTile>(){
				@Override
				public BlockEntityRenderer<TestTile> create(Context context){
					return new TestTileRenderer(context);
				}
            });
        }
        
    }
    
    public static Logger getLogger(){
    	return LOGGER;
    }
    
}
