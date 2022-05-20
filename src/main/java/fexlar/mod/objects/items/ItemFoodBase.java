package fexlar.mod.objects.items;

import fexlar.mod.Main;
import fexlar.mod.init.ItemInit;
import fexlar.mod.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemFoodBase extends ItemFood implements IHasModel
{

    public ItemFoodBase(String name, int foodAmount, float saturation, boolean isWolfFood, CreativeTabs creativeTab)
    {
        super(foodAmount, saturation, isWolfFood);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(creativeTab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
