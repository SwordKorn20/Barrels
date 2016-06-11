package sk.swordkorn.barrels;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sk.swordkorn.barrels.proxy.CommonProxy;

/**
 * Created by Sword_Korn on 5/14/2016.
 */

@Mod(modid = BarrelsMain.MODID, name = BarrelsMain.NAME, version = BarrelsMain.VERSION)
public class BarrelsMain {

    public static final String MODID = "barrels";
    public static final String NAME = "barrelsMod";
    public static final String VERSION = "1.0";

    @Mod.Instance
    public static BarrelsMain instance = new BarrelsMain();

    @SidedProxy(clientSide = "sk.swordkorn.barrels.proxy.ClientProxy", serverSide = "sk.swordkorn.barrels.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs barrelsTab = new CreativeTabs("barrelsTab") {
        @Override
        public Item getTabIconItem() {
            return Items.diamond;
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        this.proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        this.proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        this.proxy.postInit(e);
    }

}
