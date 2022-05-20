package fexlar.mod.init;

import fexlar.mod.objects.blocks.BlockBase;
import fexlar.mod.objects.blocks.f25_block.F25Block;
import fexlar.mod.objects.blocks.f25_block.F25BlockHarmless;
import fexlar.mod.objects.blocks.fruitcrate.FruitCrate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block F25_BLOCK = new F25Block("f25_block", Material.CLAY);
    public static final Block F25_BLOCK_HARMLESS = new F25BlockHarmless("f25_block_harmless", Material.CLAY);
    public static final Block FRUIT_CRATE = new FruitCrate("fruit_crate", Material.WOOD);
    public static final Block MISSINGBLOCK = new BlockBase("missing_block", Material.CLAY);
}
