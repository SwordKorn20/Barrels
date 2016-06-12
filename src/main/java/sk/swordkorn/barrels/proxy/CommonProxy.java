package sk.swordkorn.barrels.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sk.swordkorn.barrels.blocks.BarrelsBlocks;

/**
 * Created by Sword_Korn on 5/14/2016.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        BarrelsBlocks.createBlocks();
    }

    public void init(FMLInitializationEvent e) {
        BarrelsBlocks.createItemBlocks();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
