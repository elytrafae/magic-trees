package xyz.elytrafae.mc.magictrees;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.elytrafae.mc.magictrees.blocks.BlockCustomLeaf;
import xyz.elytrafae.mc.magictrees.blocks.BlockCustomLog;
import xyz.elytrafae.mc.magictrees.blocks.BlockCustomPlank;
import xyz.elytrafae.mc.magictrees.items.ItemBlockCustom;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class BlockLoader {

    public static ArrayList<String> woodTypes = new ArrayList<>() {
        {
            add("cherry_blossom");
        }
    };
    public static ArrayList<Block> blocks = new ArrayList<>();
    public static ArrayList<Item> items = new ArrayList<>();

    public static boolean createAllRan = false;

    public static void createAllWoodTypes() {
        if (BlockLoader.createAllRan) {
            return;
        }
        BlockLoader.createAllRan = true;
        for (int i=0; i < woodTypes.size(); i++) {
            createWoodType(woodTypes.get(i));
        }
    }

    public static void createWoodType(String name) {
        createLog(name);
        createLeaf(name);
        createPlank(name);
    }

    public static void createLog(String woodTypeName) {
        registerBlock(new BlockCustomLog(woodTypeName + "_log", MapColor.PINK));
    }

    public static void createLeaf(String woodTypeName) {
        registerBlock(new BlockCustomLeaf(woodTypeName + "_leaf", MapColor.PINK));
    }

    public static void createPlank(String woodTypeName) {
        registerBlock(new BlockCustomPlank(woodTypeName + "_plank", MapColor.PINK));
    }

    public static void registerBlock(Block block) {
        ItemBlock item = new ItemBlockCustom(block.getRegistryName(), block);
        blocks.add(block);
        items.add(item);
        if (block instanceof BlockCustomLeaf) {
            ((BlockCustomLeaf)block).setBlockItem(item);
        }
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        createAllWoodTypes();
        event.getRegistry().registerAll(items.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        createAllWoodTypes();
        event.getRegistry().registerAll(blocks.toArray(new Block[0]));
    }

}
