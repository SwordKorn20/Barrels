package sk.swordkorn.barrels.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sk.swordkorn.barrels.blocks.BarrelsBlockRenderer;

/**
 * Created by Sword_Korn on 5/14/2016.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        BarrelsBlockRenderer.preInit();
        BarrelsBlockRenderer.registerBlockRenderer();

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
