package sk.swordkorn.barrels.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import sk.swordkorn.barrels.BarrelsMain;
import sk.swordkorn.barrels.items.BarrelsItemBlock;
import sk.swordkorn.barrels.items.BarrelsItemBlockMeta;

/**
 * Created by Sword_Korn on 5/14/2016.
 */
public class BarrelsBlocks {

    public static Block barrelBlock = new BarrelBlock("barrelBlock");
    public static Block barrel = new MetaBarrelBlock();

    public static void createBlocks() {
        GameRegistry.register(barrelBlock.setRegistryName(BarrelsMain.MODID, "barrelBlock"));
        GameRegistry.register(barrel.setRegistryName(BarrelsMain.MODID, "barrel"));
    }

    public static void createItemBlocks() {
        GameRegistry.register(new BarrelsItemBlock(barrelBlock).setRegistryName(barrelBlock.getRegistryName().toString()));
        GameRegistry.register(new BarrelsItemBlockMeta(barrel).setRegistryName(barrel.getRegistryName().toString()));
    }
}
