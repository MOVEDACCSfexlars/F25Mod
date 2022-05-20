package fexlar.mod.objects.blocks.f25_block;

import fexlar.mod.Main;
import fexlar.mod.init.BlockInit;
import fexlar.mod.init.ItemInit;
import fexlar.mod.util.SoundsHandler;
import fexlar.mod.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class F25BlockHarmless extends Block implements IHasModel
{

    public F25BlockHarmless(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.F25KEYTAB);

        this.setSoundType(SoundType.METAL);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        worldIn.playSound(null, pos, SoundsHandler.F25_PLACED, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (playerIn.isSneaking())
        {
//            Minecraft.getMinecraft().displayGuiScreen(new TestGui());
        }
        else
        {
            Random r = new Random();
            float random = 0.8f + r.nextFloat() * (1f - 0.8f);
            worldIn.createExplosion(playerIn, hitX, hitY, hitZ, 10, true);
            // playerIn.onKillCommand();
            playerIn.jump();
            worldIn.playSound(playerIn, pos, SoundsHandler.F25_ACTIVATE, SoundCategory.BLOCKS, 1.0F, random);
        }

        return true;
    }

    /* I still want to save this for another project lol */
//    @Override
//    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
//    {
//        //System.out.println("BLOCK ACTIVATED!");
//        entityIn.onKillCommand();
//        worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundsHandler.F25_ACTIVATE, SoundCategory.BLOCKS, 1.0F, 1.0F);
//    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
