package sk.swordkorn.barrels.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sk.swordkorn.barrels.BarrelsMain;

/**
 * Created by Sword_Korn on 5/14/2016.
 */
public class BarrelBlock extends Block {

    public BarrelBlock(String unlocalisedName, Material mat, float hardness, float resistance) {
        super(mat);
        this.setUnlocalizedName(unlocalisedName);
        this.setCreativeTab(BarrelsMain.barrelsTab);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public BarrelBlock(String unlocalisedName, float hardness, float resistance) {
        this(unlocalisedName, Material.wood, hardness, resistance);
    }

    public BarrelBlock(String unlocalisedName) {
        this(unlocalisedName, 2.0f, 10.0f);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack stack, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(world.getBlockState(pos) == BarrelsBlocks.barrelBlock) {
            if (stack.getItem() == Items.dye.getContainerItem()) {
                world.notifyBlockOfStateChange(pos, BarrelsBlocks.barrel);
                return true;
            }
        }
        return false;
    }
}
