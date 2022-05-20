package fexlar.mod.tabs;

import fexlar.mod.init.BlockInit;
import fexlar.mod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class F25Tab extends CreativeTabs
{
    public F25Tab(String label)
    {
        super("f25keytab");
        this.setBackgroundImageName("f25keytab.png");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemInit.F25_KEY);
    }
}
