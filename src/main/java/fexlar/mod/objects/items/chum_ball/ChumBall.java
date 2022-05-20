package fexlar.mod.objects.items.chum_ball;

import fexlar.mod.Main;
import fexlar.mod.init.ItemInit;
import fexlar.mod.util.SoundsHandler;
import fexlar.mod.util.interfaces.IHasModel;
import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChumBall extends Item implements IHasModel
{
    public ChumBall(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.F25KEYTAB);

        this.maxStackSize = 1;

        ItemInit.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.BLOCK_NOTE_BASEDRUM, SoundCategory.PLAYERS, 0.5F, 1F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            throwableChum Throwable = new throwableChum(worldIn, playerIn);
            Throwable.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(Throwable);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    public class throwableChum extends EntityThrowable
    {

        public throwableChum(World worldIn)
        {
            super(worldIn);
        }

        public throwableChum(World worldIn, EntityLivingBase throwerIn)
        {
            super(worldIn, throwerIn);
        }

        public throwableChum(World worldIn, double x, double y, double z)
        {
            super(worldIn, x, y, z);
        }

        @SideOnly(Side.CLIENT)
        public void handleStatusUpdate(byte id)
        {
            if (id == 3)
            {
                for (int i = 0; i < 8; ++i)
                {
                    this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
                }
            }
        }

        @Override
        protected void onImpact(RayTraceResult result) {
            if (result.entityHit != null)
            {
                result.entityHit.onKillCommand();
                result.entityHit.getEntityWorld().playSound(null, result.entityHit.getPosition(),SoundsHandler.F25_ACTIVATE, SoundCategory.PLAYERS, 1F, 1F);
            }

            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }

}
