package fexlar.mod.objects.blocks.fruitcrate;

import fexlar.mod.Main;
import fexlar.mod.init.BlockInit;
import fexlar.mod.init.ItemInit;
import fexlar.mod.util.interfaces.IHasModel;
import fexlar.mod.util.packets.spawnItem;
import fexlar.mod.util.packets.spawnItemSender;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FruitCrate extends Block implements IHasModel
{

    public FruitCrate(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.F25KEYTAB);

        this.setSoundType(SoundType.WOOD);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        worldIn.playSound(playerIn, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 0.5F, 1F);
        worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, pos.getX(), pos.getY(), pos.getZ(), 0.0D, 0.0D, 0.0D);

        List<ItemStack> fruits = new ArrayList<>();

            // This probably isn't the best way to do this but whatever
            fruits.add(new ItemStack(Items.APPLE));
            fruits.add(new ItemStack(Items.MELON));
            fruits.add(new ItemStack(ItemInit.FOOD_BANANA));
            fruits.add(new ItemStack(ItemInit.FOOD_KIWI));
            fruits.add(new ItemStack(ItemInit.FOOD_PEAR));
            fruits.add(new ItemStack(ItemInit.FOOD_LEMON));
            fruits.add(new ItemStack(ItemInit.FOOD_ORANGE));

        // Setting this too high will crash your game/server
        for (int x = 0; x < 2; x++)
        {
            for (int i = 0; i < fruits.size(); i++)
            {
                spawnItemSender.INSTANCE.sendToServer(new spawnItem(fruits.get(i), pos.getX(), pos.getY(), pos.getZ()));
                spawnItemSender.init();
            }
        }
        worldIn.setBlockToAir(new BlockPos(pos));
        // Throw in an extra something cause why not
//        spawnItemSender.INSTANCE.sendToServer(new spawnItem(new ItemStack(ItemInit.FOOD_FUDGE_STRIPES), pos.getX(), pos.getY(), pos.getZ()));

//        if(worldIn.isRemote)
//        {
//
//        }
//        else
//        {
//            for (int x = 0; x < 5; x++)
//            {
//                for (int i = 0; i < fruits.size(); i++)
//                {
//                    Random rand = new Random();
//                    float rx = rand.nextFloat() * 0.75F + 0.1F;
//                    float ry = rand.nextFloat() * 0.75F + 0.1F;
//                    float rz = rand.nextFloat() * 0.75F + 0.1F;
//
//                    worldIn.setBlockToAir(pos);
//                    EntityItem dropItem = new EntityItem(worldIn, pos.getX() + rx, pos.getY() + ry, pos.getZ() + rz, fruits.get(i).copy());
//                    float factor = 0.15F;
//                    dropItem.setVelocity(rand.nextGaussian() * factor,
//                            rand.nextGaussian() * factor + 0.45F,
//                            rand.nextGaussian() * factor);
//                    worldIn.spawnEntity(dropItem);
//                }
//                // Throw in an extra something cause why not
//                Random rand = new Random();
//                float rx = rand.nextFloat() * 0.75F + 0.1F;
//                float ry = rand.nextFloat() * 0.75F + 0.1F;
//                float rz = rand.nextFloat() * 0.75F + 0.1F;
//
//                worldIn.setBlockToAir(pos);
//                EntityItem dropItem = new EntityItem(worldIn, pos.getX() + rx, pos.getY() + ry, pos.getZ() + rz, new ItemStack(ItemInit.FOOD_FUDGE_STRIPES).copy());
//                float factor = 0.15F;
//                dropItem.setVelocity(rand.nextGaussian() * factor,
//                        rand.nextGaussian() * factor + 0.45F,
//                        rand.nextGaussian() * factor);
//                worldIn.spawnEntity(dropItem);
//                return true;
//        }
        return true;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
