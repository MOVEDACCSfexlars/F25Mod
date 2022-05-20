package fexlar.mod.util.packets;

import fexlar.mod.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class spawnItemSender {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);

    public static void init() {
        INSTANCE.registerMessage(spawnItemHandler.class, spawnItem.class, 0, Side.SERVER);
    }
}
