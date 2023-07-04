package net.crossscar.cshacks.multi.cshacks.mixin;

import net.crossscar.cshacks.multi.cshacks.hacks.HackGlobal;
import net.crossscar.cshacks.multi.cshacks.hacks.XrayHack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class BlockMixin extends BlockBehaviour implements ItemLike {
    public BlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(at = @At("HEAD"), method = {
            "shouldRenderFace"
    }, cancellable = true)
    private static void shouldRenderFace(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction, BlockPos blockPos2, CallbackInfoReturnable<Boolean> cir) {
        if (((XrayHack)HackGlobal.getHack(XrayHack.class)).state)
            cir.setReturnValue(((XrayHack)HackGlobal.getHack(XrayHack.class)).visibleBlocks.contains(blockState.getBlock()));
    }
}
