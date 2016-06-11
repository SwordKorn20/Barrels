package sk.swordkorn.barrels.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import sk.swordkorn.barrels.items.BarrelsItemBlock;

/**
 * Created by Sword_Korn on 5/14/2016.
 */
public class BarrelsBlocks {

    public static Block barrelBlock = new BarrelBlock("barrelBlock");
    public static Block barrel = new MetaBarrelBlock("barrel");

    public static void createBlocks() {
        GameRegistry.register(barrelBlock.setRegistryName("barrelBlock"));
        GameRegistry.register(barrel.setUnlocalizedName("barrel"));

        GameRegistry.register(new BarrelsItemBlock(barrelBlock).setRegistryName(barrelBlock.getRegistryName()));
        GameRegistry.register(new BarrelsItemBlock(barrel).setRegistryName(barrel.getRegistryName()));

    }
}
