package xyz.elytrafae.mc.magictrees.blocks;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.elytrafae.mc.magictrees.MagicTrees;

import javax.annotation.Nonnull;
import java.util.List;

public class BlockCustomLeaf extends BlockLeaves {

    private ItemBlock item;
    private MapColor color;

    public BlockCustomLeaf(String name, MapColor color) {
        super();
        //BlockNewLog
        setRegistryName(MagicTrees.MODID, name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, true));
        this.color = color;
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{CHECK_DECAY, DECAYABLE});
    }

    public MapColor getMapColor(IBlockState p_180659_1_, IBlockAccess p_180659_2_, BlockPos p_180659_3_) {
        return color;
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int i) {
        return BlockPlanks.EnumType.DARK_OAK;
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack itemStack, IBlockAccess iBlockAccess, BlockPos blockPos, int i) {
        return List.of(new ItemStack(item));
    }

    public void setBlockItem(ItemBlock item) {
        this.item = item;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(CHECK_DECAY) ? 1 : 0) + (state.getValue(DECAYABLE) ? 2 : 0);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.getDefaultState(); // This has both properties on!
        if (meta % 2 == 0) { // First bit is not set
            state = state.withProperty(CHECK_DECAY, false);
        }
        if ((meta & 2) == 0) {
            state = state.withProperty(DECAYABLE, false);
        }
        return state;
    }
}
