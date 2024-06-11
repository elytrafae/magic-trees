package xyz.elytrafae.mc.magictrees.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.elytrafae.mc.magictrees.MagicTrees;

public class BlockCustomLog extends BlockLog {

    private final MapColor color;

    //private static final PropertyEnum<EnumAxis> AXIS = LOG_AXIS;

    public BlockCustomLog(String name, MapColor color) {
        super();
        //BlockNewLog;
        setRegistryName(MagicTrees.MODID, name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
        this.color = color;
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{LOG_AXIS});
    }

    public MapColor getMapColor(IBlockState p_180659_1_, IBlockAccess p_180659_2_, BlockPos p_180659_3_) {
        return color;
    }

    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.getDefaultState();
        switch (meta) {
            case 0:
                state = state.withProperty(LOG_AXIS, EnumAxis.Y);
                break;
            case 1:
                state = state.withProperty(LOG_AXIS, EnumAxis.X);
                break;
            case 2:
                state = state.withProperty(LOG_AXIS, EnumAxis.Z);
                break;
            default:
                state = state.withProperty(LOG_AXIS, EnumAxis.NONE);
        }

        return state;
    }

    public int getMetaFromState(IBlockState state) {
        int meta = 0;
        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS)) {
            case X:
                meta = 1;
                break;
            case Z:
                meta = 2;
                break;
            case NONE:
                meta = 3;
        }

        return meta;
    }

}
