package xyz.elytrafae.mc.magictrees;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@Mod(
        modid = MagicTrees.MODID,
        name = MagicTrees.MOD_NAME,
        useMetadata = true,
        version = MagicTrees.VERSION
)
public class MagicTrees {

    public static final String MODID = "magic_trees";
    public static final String MOD_NAME = "Magic Trees";
    public static final String VERSION = "1.0.0";
	
	@Instance(MagicTrees.MODID)
	public static MagicTrees _instance;
    public MagicTrees() {}
        
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
    }
    
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }
    
    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @EventHandler
    public void onServerStarted(FMLServerStartedEvent event) {
    }

    @EventHandler
    public void onServerStopping(FMLServerStoppingEvent event) {
    }
}
