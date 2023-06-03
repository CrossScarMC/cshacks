package net.crossscar.cshacks.multi.cshacks.forge;

import dev.architectury.platform.forge.EventBuses;
import net.crossscar.cshacks.multi.cshacks.CsHacks;
import net.crossscar.cshacks.multi.cshacks.hacks.Hack;
import net.crossscar.cshacks.multi.cshacks.hacks.HackGlobal;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CsHacks.MOD_ID)
public class CsHacksForge {
    public CsHacksForge() {
        EventBuses.registerModEventBus(CsHacks.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);

        CsHacks.init();
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        for (Hack<?> hackInstance : HackGlobal.hacks) hackInstance.tick();
    }
}