package net.crossscar.cshacks.multi.cshacks.gui;

import net.crossscar.cshacks.multi.cshacks.hacks.Hack;
import net.crossscar.cshacks.multi.cshacks.hacks.HackGlobal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;

public class HacksScreen extends Screen {
    public Screen previousScreen;
    public ArrayList<Button> hackConfigButtons = new ArrayList<>();
    public HacksScreen(Screen previous) {
        super(Component.translatable("gui.cshacks"));
        this.previousScreen = previous;
    }

    protected void init() {
        for (Hack<?> hackInstance : HackGlobal.hacks.values()) {
            GuiGlobal.categoryButtonOffsets.put(hackInstance.guiCategory, GuiGlobal.buttonOffset);
        }
        for (Hack<?> hackInstance : HackGlobal.hacks.values()) {
            Button hackConfigButton = Button.builder(hackInstance.getStateMessage(), (button) -> {
                hackInstance.onConfigButtonClicked();
                assert this.minecraft != null;
                this.minecraft.setScreen(new HacksScreen(this.previousScreen));
            }).bounds(GuiGlobal.categoryButtonOffsets.get(hackInstance.guiCategory), GuiGlobal.margin * (GuiGlobal.getCategories().indexOf(GuiGlobal.categoryHackMap.get(hackInstance)) + 1) + GuiGlobal.getCategories().indexOf(GuiGlobal.categoryHackMap.get(hackInstance)) * 20, hackInstance.guiWidth, hackInstance.guiHeight).build();

            this.hackConfigButtons.add(hackConfigButton);
            this.addRenderableWidget(hackConfigButton);

            GuiGlobal.categoryButtonOffsets.put(hackInstance.guiCategory, GuiGlobal.categoryButtonOffsets.get(hackInstance.guiCategory) + GuiGlobal.margin + hackInstance.guiWidth);
        }

        this.addRenderableWidget(Button.builder(Component.translatable("gui.cshacks.back"), (p_96788_) -> this.onClose()).bounds(this.width - (60 + GuiGlobal.margin), GuiGlobal.margin, 60, 20).build());

        int categoryOffset = GuiGlobal.margin;
        for (Component category : GuiGlobal.getCategories()) {
            // (font, category, GuiGlobal.margin, categoryOffset, 0xffffff);

            this.addRenderableWidget(new StringWidget(0, categoryOffset, GuiGlobal.margin + GuiGlobal.buttonOffset,20, category, font));
            categoryOffset += GuiGlobal.margin + 20;
        }
    }

    public void render(GuiGraphics p_96249_, int p_96250_, int p_96251_, float p_96252_) {
        this.renderBackground(p_96249_);
        super.render(p_96249_, p_96250_, p_96251_, p_96252_);
    }

    @Override
    public void onClose() {
        Minecraft.getInstance().setScreen(this.previousScreen);
    }
}
