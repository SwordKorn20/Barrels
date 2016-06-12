package sk.swordkorn.barrels.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sk.swordkorn.barrels.BarrelsMain;

import java.util.List;

/**
 * Created by Sword_Korn on 5/16/2016.
 */
public class MetaBarrelBlock extends Block {
    public static final int NUM_STATES = 2;
    public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, NUM_STATES - 1);

    public MetaBarrelBlock(String unlocalisedName, Material mat, float hardness, float resistance) {
        super(mat);
        this.setUnlocalizedName(unlocalisedName);
        this.setCreativeTab(BarrelsMain.barrelsTab);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, player, stack);
        world.setBlockState(pos, this.getStateFromMeta(stack.getMetadata()));
    }

    public MetaBarrelBlock(String unlocalisedName, float hardness, float resistance) {
        this(unlocalisedName, Material.wood, hardness, resistance);
    }

    public MetaBarrelBlock() {
        this("barrel", 2.0f, 10.0f);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {TYPE});
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, meta % NUM_STATES);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE).intValue();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return this.getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for(int i = 0; i < NUM_STATES; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
