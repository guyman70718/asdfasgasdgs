package com.example.examplemod.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Events {


    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        System.out.println("tick");
    }
}
