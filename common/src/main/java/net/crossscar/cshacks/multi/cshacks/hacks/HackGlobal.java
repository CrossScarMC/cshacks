package net.crossscar.cshacks.multi.cshacks.hacks;

import java.util.ArrayList;

public class HackGlobal {
    public static ArrayList<Hack<?>> hacks = new ArrayList<>();

    public static void registerHack(Hack<?> hackInstance) {
        hacks.add(hackInstance);
    }
}
