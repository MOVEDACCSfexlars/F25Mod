package fexlar.mod.util.packets;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import scala.Int;

import java.util.Random;

public class spawnItemHandler implements IMessageHandler<spawnItem, IMessage> {
    @Override
    public IMessage onMessage(spawnItem message, MessageContext ctx) {
        EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
        ItemStack item = message.sItem;
        int posX = message.sPosX;
        int posY = message.sPosY;
        int posZ = message.sPosZ;
                    Random rand = new Random();
                    float rx = rand.nextFloat() * 0.75F + 0.1F;
                    float ry = rand.nextFloat() * 0.75F + 0.1F;
                    float rz = rand.nextFloat() * 0.75F + 0.1F;

                    serverPlayer.world.setBlockToAir(new BlockPos(posX, posY, posZ));
                    EntityItem dropItem = new EntityItem(serverPlayer.world, posX + rx, posY + ry, posZ + rz, item.copy());
                    float factor = 0.15F;
//                    dropItem.setVelocity(rand.nextGaussian() * factor,
//                            rand.nextGaussian() * factor + 0.45F,
//                            rand.nextGaussian() * factor);
                    serverPlayer.world.spawnEntity(dropItem);
        return null;
    }
}
