package fexlar.mod.init;

import fexlar.mod.objects.items.ItemBase;
import fexlar.mod.objects.items.ItemFoodBase;
import fexlar.mod.objects.items.chum_ball.ChumBall;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item F25_KEY = new ItemBase("f25_key");
    public static final Item F25_THROW = new ChumBall("f25_throw");

    // Food
    public static final Item FOOD_BANANA = new ItemFoodBase("food_banana", 4, 2.4F, false);
    public static final Item FOOD_KIWI = new ItemFoodBase("food_kiwi", 3, 2.4F, false);
    public static final Item FOOD_PEAR = new ItemFoodBase("food_pear", 4, 2.4F, false);
    public static final Item FOOD_ORANGE = new ItemFoodBase("food_orange", 3, 2.4F, false);
    public static final Item FOOD_LEMON = new ItemFoodBase("food_lemon", 2, 2.4F, false);
    public static final Item FOOD_FUDGE_STRIPES = new ItemFoodBase("food_fudge_stripes", 10, 5F, true);

}
