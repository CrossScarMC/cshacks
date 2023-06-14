package net.crossscar.cshacks.multi.cshacks.gui;

import net.crossscar.cshacks.multi.cshacks.hacks.Hack;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.HashMap;

public class GuiGlobal {
    public static int margin = 5;
    public static int buttonOffset = 85;

    private static final ArrayList<Component> categories = new ArrayList<>();

    public static HashMap<Hack<?>, Component> categoryHackMap = new HashMap<>();

    public static HashMap<Component, Integer> categoryButtonOffsets = new HashMap<>();

    public static void registerCategory(Component category) {
        categories.add(category);
    }
    public static boolean categoryRegistered(Component category) {
        return categories.contains(category);
    }

    public static ArrayList<Component> getCategories() {
        return categories;
    }

    public static void registerCategoryModMapping(Component category, Hack<?> hackInstance) {
        categoryHackMap.put(hackInstance, category);
    }
}
