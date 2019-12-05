package com.example.examplemod.events;

import com.example.examplemod.ExampleMod;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.PersistentException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class Events {
    @SubscribeEvent
    public void onPlayerJoin(EntityJoinWorldEvent  event){
        if(event.getEntity() instanceof EntityPlayer) {
            event.getEntity().rotationYaw = 0.0f;
        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) {
        if(Minecraft.getMinecraft().isIntegratedServerRunning() ){
            try {
                ExampleMod.table.getEntry("yaw").setDouble(Minecraft.getMinecraft().player.rotationYaw);
                ExampleMod.table.getEntry("pitch").setDouble(Minecraft.getMinecraft().player.rotationPitch);
            }catch(Exception e){
                System.out.println("not in game yet");
            }
        }
    }
}
