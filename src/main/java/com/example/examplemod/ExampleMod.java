package com.example.examplemod;

import com.example.examplemod.events.Events;
import edu.wpi.first.networktables.NetworkTableInstance;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "frccontrol";
    public static final String NAME = "Frc Control";
    public static final String VERSION = "1.0";

    private static Logger logger;
    public static NetworkTableInstance table;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        table = NetworkTableInstance.create();
        table.setServerTeam(2869);
        table.startServer();
        MinecraftForge.EVENT_BUS.register(new Events());
    }
}
