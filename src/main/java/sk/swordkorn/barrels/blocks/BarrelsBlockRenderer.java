package sk.swordkorn.barrels.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by Sword_Korn on 5/14/2016.
 */
public class BarrelsBlockRenderer {

    public static void registerBlockRenderer() {
        reg(BarrelsBlocks.barrelBlock, 0, "normal");
        for(int i = 0; i < MetaBarrelBlock.NUM_STATES; i++) {
            reg(BarrelsBlocks.barrel, i, "type");
        }
    }

    public static void preInit(Block block) {
        Item item = Item.getItemFromBlock(block);
        final ResourceLocation[] namesBarrelItem = new ResourceLocation[MetaBarrelBlock.NUM_STATES];
        for(int i = 0; i < MetaBarrelBlock.NUM_STATES; i++) {
            String var = item.getUnlocalizedName() + i;
            namesBarrelItem[i] = new ModelResourceLocation(item.getRegistryName().toString());
        }
        ModelBakery.registerItemVariants(item, namesBarrelItem);
    }

    public static void reg(Block block, int meta, String variant) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft()
                .getRenderItem()
                .getItemModelMesher()
                .register(item, meta, new ModelResourceLocation(item.getRegistryName(), variant));
    }
}
