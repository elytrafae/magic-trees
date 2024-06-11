package xyz.elytrafae.mc.magictrees.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class ItemBlockCustom extends ItemBlock {

    public ItemBlockCustom(ResourceLocation resourceLoc, Block block) {
        super(block);
        setRegistryName(resourceLoc);
    }

}
