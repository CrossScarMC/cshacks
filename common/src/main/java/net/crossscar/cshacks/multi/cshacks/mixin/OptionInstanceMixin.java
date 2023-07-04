package net.crossscar.cshacks.multi.cshacks.mixin;

import net.crossscar.cshacks.multi.cshacks.interfaces.CSOptionInstance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Consumer;

@Mixin(OptionInstance.class)
public class OptionInstanceMixin<T> implements CSOptionInstance<T> {
    @Shadow
    T value;

    @Shadow
    @Final
    private Consumer<T> onValueUpdate;
    @Override
    public void forceSetValue(T newValue) {
        if (!Minecraft.getInstance().isRunning()) {
            this.value = newValue;
            return;
        }

        if (!this.value.equals(newValue)) {
            this.value = newValue;
            this.onValueUpdate.accept(this.value);
        }
    }
}
