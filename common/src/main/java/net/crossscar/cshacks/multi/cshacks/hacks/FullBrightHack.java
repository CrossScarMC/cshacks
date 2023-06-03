package net.crossscar.cshacks.multi.cshacks.hacks;

import net.crossscar.cshacks.multi.cshacks.interfaces.CSOptionInstance;
import net.minecraft.network.chat.Component;

public class FullBrightHack extends TogglableHack {

    public void init() {
        this.stateMessageBase = Component.translatable("gui.cshacks.hacks.bright");
        this.guiCategory = Component.translatable("gui.cshacks.categories.render");
        this.guiWidth = 100;

        this.state = false;

        super.init();
    }

    public void onEnable() {
        ((CSOptionInstance<Double>)(Object)this.minecraft.options.gamma()).forceSetValue(10000.0);
    }

    public void onDisable() {
        ((CSOptionInstance<Double>)(Object)this.minecraft.options.gamma()).forceSetValue(1.0);
    }
}
