package fexlar.mod;

import fexlar.mod.proxy.CommonProxy;
import fexlar.mod.tabs.F25Tab;
import fexlar.mod.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class Main 
{
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;

	public static final CreativeTabs F25KEYTAB = new F25Tab("f25keytab");
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) 
	{

	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event)
	{

	}

	@SubscribeEvent
	public void onMainMenu(EntityItemPickupEvent event)
	{
		System.out.println(event.getItem().getName());
	}


}
