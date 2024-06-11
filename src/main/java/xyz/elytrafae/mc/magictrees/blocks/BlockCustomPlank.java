package xyz.elytrafae.mc.magictrees.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import xyz.elytrafae.mc.magictrees.MagicTrees;

public class BlockCustomPlank extends Block {

    public BlockCustomPlank(String name, MapColor color) {
        super(Material.WOOD, color);
        setRegistryName(MagicTrees.MODID, name);
    }


}
