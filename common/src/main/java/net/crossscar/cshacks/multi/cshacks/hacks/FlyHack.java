package net.crossscar.cshacks.multi.cshacks.hacks;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
public class FlyHack extends TogglableHack {
    public int flyTick;

    public void init() {
        this.stateMessageBase = Component.translatable("gui.cshacks.hacks.fly");
        this.guiCategory = Component.translatable("gui.cshacks.categories.move");

        this.state = false;
        this.flyTick = 0;

        super.init();
    }

    public void tick() {
        Player player = this.minecraft.player;

        if (player != null && this.state && !player.isCreative()) {
            player.getAbilities().flying = true;

            if (this.flyTick == 40) {
                player.moveTo(player.getX() + player.getDeltaMovement().x, player.getY() - 0.04, player.getZ() + player.getDeltaMovement().z);
            } else if (this.flyTick == 41) {
                player.moveTo(player.getX() + player.getDeltaMovement().x, player.getY() + 0.04, player.getZ() + player.getDeltaMovement().z);
            } else if (this.flyTick > 80) {
                this.flyTick = 0;
            }

            this.flyTick++;
        }
    }

    public void onDisable() {
        if (this.minecraft.player != null && !this.minecraft.player.isCreative())
            this.minecraft.player.getAbilities().flying = false;
    }
}
