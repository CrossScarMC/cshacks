package net.crossscar.cshacks.multi.cshacks.hacks;

import net.crossscar.cshacks.multi.cshacks.gui.GuiGlobal;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import java.util.HashMap;
import java.util.Map;

public class Hack<T> {
    public T state;
    public Minecraft minecraft = Minecraft.getInstance();
    public Map<T, Component> stateMessages = new HashMap<T, Component>();

    public int guiWidth = 80;
    public int guiHeight = 20;
    public Component guiCategory = Component.translatable("gui.cshacks.categories.misc");

    public void init() {
        HackGlobal.registerHack(this);
        if (!GuiGlobal.categoryRegistered(this.guiCategory)) GuiGlobal.registerCategory(this.guiCategory);
        GuiGlobal.registerCategoryModMapping(this.guiCategory, this);
    }
    public void tick() {}
    public void setState(T newState) {
        state = newState;
    }

    public void onConfigButtonClicked() {

    }

    public Component getStateMessage() {
        return stateMessages.get(state);
    }
}
