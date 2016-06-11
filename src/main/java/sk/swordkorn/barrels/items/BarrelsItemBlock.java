package sk.swordkorn.barrels.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import sk.swordkorn.barrels.blocks.IMetaDataBlock;
import sk.swordkorn.barrels.blocks.MetaBarrelBlock;

/**
 * Created by Sword_Korn on 5/14/2016.
 */
public class BarrelsItemBlock extends ItemBlock {
    public BarrelsItemBlock(Block block) {
        super(block);
        if(block instanceof IMetaDataBlock) {
            setMaxDamage(2);
            setHasSubtypes(true);
        }else{
            setHasSubtypes(false);
        }
    }

    @Override
    public int getMetadata(int dmg) {
        return dmg;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        MetaBarrelBlock.EnumType type = MetaBarrelBlock.EnumType.byMetadata(stack.getMetadata());
        return super.getUnlocalizedName() + type.toString();
    }
}
