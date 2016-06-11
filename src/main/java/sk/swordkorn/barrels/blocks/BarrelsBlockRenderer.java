package sk.swordkorn.barrels.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Sword_Korn on 5/14/2016.
 */
public class BarrelsBlockRenderer {

    public static void registerBlockRenderer() {
        reg(BarrelsBlocks.barrelBlock, 0, "normal");
        reg(BarrelsBlocks.barrel, 0, "white");
        reg(BarrelsBlocks.barrel, 1, "black");
    }

    public static void preInit() {
        final String colours[] = { "white", "black" };
        ResourceLocation[] resLoc = new ResourceLocation[2];
        for(int i = 0; i < 2; i++)
            resLoc[i] = new ResourceLocation("barrels:barrel" + colours[i]);
        ModelBakery.registerItemVariants(Item.getItemFromBlock(BarrelsBlocks.barrel), resLoc);
    }

    public static void reg(Block block, int meta, String variant) {
        Item item = Item.getItemFromBlock(block);

        Minecraft.getMinecraft()
                .getRenderItem()
                .getItemModelMesher()
                .register(item, meta, new ModelResourceLocation(item.getRegistryName(), variant));
    }
}
