package fexlar.mod.util;

import fexlar.mod.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler
{
    public static SoundEvent F25_ACTIVATE;
    public static SoundEvent F25_PLACED;
    public static SoundEvent F25_RECORD;

    public static void registerSounds()
    {
        F25_ACTIVATE = registerSound("blocks.f25_activate");
        F25_PLACED = registerSound("blocks.f25_placed");
        F25_RECORD = registerSound("records.f25_record");
    }

    private static SoundEvent registerSound(String name)
    {
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }

}
