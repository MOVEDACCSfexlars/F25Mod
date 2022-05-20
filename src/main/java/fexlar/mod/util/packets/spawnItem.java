package fexlar.mod.util.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class spawnItem implements IMessage {
    // A default constructor is always required
    public spawnItem(){}

    public int sPosX, sPosY, sPosZ;
    public ItemStack sItem;

    public spawnItem(ItemStack toSend, int posX, int posY, int posZ) {
        this.sItem = toSend;
        this.sPosX = posX;
        this.sPosY = posY;
        this.sPosZ = posZ;
    }


    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(sPosX);
        buf.writeInt(sPosY);
        buf.writeInt(sPosZ);
        ByteBufUtils.writeItemStack(buf, sItem);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        sPosX = buf.readInt();
        sPosY = buf.readInt();
        sPosZ = buf.readInt();
        sItem = ByteBufUtils.readItemStack(buf);
    }
}
