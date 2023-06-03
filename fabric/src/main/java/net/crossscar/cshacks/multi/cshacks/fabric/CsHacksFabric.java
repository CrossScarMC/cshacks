package net.crossscar.cshacks.multi.cshacks.fabric;

import net.crossscar.cshacks.multi.cshacks.CsHacks;
import net.crossscar.cshacks.multi.cshacks.hacks.Hack;
import net.crossscar.cshacks.multi.cshacks.hacks.HackGlobal;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class CsHacksFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CsHacks.init();

        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            for (Hack<?> hackInstance : HackGlobal.hacks.values()) hackInstance.tick();
        });
    }
}