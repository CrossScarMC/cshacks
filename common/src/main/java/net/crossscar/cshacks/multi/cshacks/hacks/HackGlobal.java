package net.crossscar.cshacks.multi.cshacks.hacks;

import java.util.HashMap;

public class HackGlobal {
    public static HashMap<String, Hack<?>> hacks = new HashMap<>();

    public static void registerHack(Hack<?> hackInstance) {
        hacks.put(hackInstance.getClass().getSimpleName(), hackInstance);
    }

    public static Hack<?> getHack(Class<?> c) {
        return hacks.get(c.getSimpleName());
    }
}
