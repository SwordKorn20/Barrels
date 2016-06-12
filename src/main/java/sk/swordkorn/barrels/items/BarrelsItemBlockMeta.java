package sk.swordkorn.barrels.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import sk.swordkorn.barrels.blocks.BarrelsBlocks;
import sk.swordkorn.barrels.blocks.IMetaDataBlock;
import sk.swordkorn.barrels.blocks.MetaBarrelBlock;

import static net.minecraftforge.fml.common.registry.GameRegistry.register;

/**
 * Created by Sword_Korn on 5/14/2016.
 */
public class BarrelsItemBlockMeta extends ItemBlock {

    public BarrelsItemBlockMeta(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int dmg) {
        return dmg;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + stack.getItemDamage();
    }
}
