package net.crossscar.cshacks.multi.cshacks.hacks;

import net.crossscar.cshacks.multi.cshacks.gui.HacksScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;

public class XrayHack extends TogglableHack {
    public ArrayList<Block> visibleBlocks = new ArrayList<>();
    public Boolean previousFullBrightState;

    public void init() {
        this.stateMessageBase = Component.translatable("gui.cshacks.hacks.xray");
        this.guiCategory = Component.translatable("gui.cshacks.categories.render");

        this.state = false;

        super.init();
        this.initBlocks();
    }

    public void initBlocks() {
        visibleBlocks.add(Blocks.DIAMOND_BLOCK);
        visibleBlocks.add(Blocks.GOLD_BLOCK);
        visibleBlocks.add(Blocks.IRON_BLOCK);
        visibleBlocks.add(Blocks.LAPIS_BLOCK);
        visibleBlocks.add(Blocks.EMERALD_BLOCK);
        visibleBlocks.add(Blocks.COAL_BLOCK);
        visibleBlocks.add(Blocks.DIAMOND_ORE);
        visibleBlocks.add(Blocks.GOLD_ORE);
        visibleBlocks.add(Blocks.IRON_ORE);
        visibleBlocks.add(Blocks.LAPIS_ORE);
        visibleBlocks.add(Blocks.EMERALD_ORE);
        visibleBlocks.add(Blocks.COAL_ORE);
        visibleBlocks.add(Blocks.DEEPSLATE_DIAMOND_ORE);
        visibleBlocks.add(Blocks.DEEPSLATE_GOLD_ORE);
        visibleBlocks.add(Blocks.DEEPSLATE_IRON_ORE);
        visibleBlocks.add(Blocks.DEEPSLATE_LAPIS_ORE);
        visibleBlocks.add(Blocks.DEEPSLATE_EMERALD_ORE);
        visibleBlocks.add(Blocks.DEEPSLATE_COAL_ORE);

        // Raw
        visibleBlocks.add(Blocks.RAW_COPPER_BLOCK);
        visibleBlocks.add(Blocks.RAW_IRON_BLOCK);
        visibleBlocks.add(Blocks.RAW_GOLD_BLOCK);

        // Copper
        visibleBlocks.add(Blocks.COPPER_ORE);
        visibleBlocks.add(Blocks.DEEPSLATE_COPPER_ORE);
    }

    public void tick() {
        if (this.state && !((FullBrightHack)HackGlobal.getHack(FullBrightHack.class)).state) {
            ((FullBrightHack)HackGlobal.getHack(FullBrightHack.class)).setState(true);
            if (this.minecraft.screen instanceof HacksScreen) this.minecraft.setScreen(new HacksScreen(((HacksScreen) this.minecraft.screen).previousScreen));
        }
    }

    public void onEnable() {
        this.previousFullBrightState = ((FullBrightHack)HackGlobal.getHack(FullBrightHack.class)).state;
    }

    public void onDisable() {
        ((FullBrightHack)HackGlobal.getHack(FullBrightHack.class)).state = this.previousFullBrightState;
    }

    public void onChange() {
        this.minecraft.levelRenderer.allChanged();
    }
}
