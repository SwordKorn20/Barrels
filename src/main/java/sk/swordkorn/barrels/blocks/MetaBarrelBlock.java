package sk.swordkorn.barrels.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockProperties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import sk.swordkorn.barrels.BarrelsMain;

import java.util.List;

/**
 * Created by Sword_Korn on 5/16/2016.
 */
public class MetaBarrelBlock extends Block {

    public MetaBarrelBlock(String unlocalisedName, Material mat, float hardness, float resistance) {
        super(mat);
        this.setRegistryName(unlocalisedName);
        this.setCreativeTab(BarrelsMain.barrelsTab);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.WHITE));
    }

    public MetaBarrelBlock(String unlocalisedName, float hardness, float resistance) {
        this(unlocalisedName, Material.wood, hardness, resistance);
    }

    public MetaBarrelBlock(String unlocalisedName) {
        this(unlocalisedName, 2.0f, 10.0f);
    }

    public static final PropertyEnum TYPE = PropertyEnum.create("type", MetaBarrelBlock.EnumType.class);

    public enum EnumType implements IStringSerializable {
        WHITE(0, "white"),
        BLACK(1, "black");

        private int ID;
        private String name;
        private static final EnumType[] META_LOOKUP = new EnumType[values().length];

        public static EnumType byMetadata(int ID) {
            if(ID < 0 || ID >= META_LOOKUP.length) {
                ID = 0;
            }
            return META_LOOKUP[ID];
        }

        @Override
        public String getName() {
            return this.name;
        }

        public int getID() {
            return this.ID;
        }

        @Override
        public String toString() {
            return getName();
        }

        public int getMetadata() {
            return this.ID;
        }

        private EnumType(int ID, String name) {
            this.ID = ID;
            this.name = name;
        }

        static
        {
            for(EnumType type : values()) {
                META_LOOKUP[type.getMetadata()] = type;
            }
        }

    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {TYPE});
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, meta == 0 ? EnumType.WHITE : EnumType.BLACK);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumType type = (EnumType) state.getValue(TYPE);
        return type.getID();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }
}
