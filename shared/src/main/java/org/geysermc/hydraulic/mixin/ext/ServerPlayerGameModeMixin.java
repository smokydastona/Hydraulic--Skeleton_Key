package org.geysermc.hydraulic.mixin.ext;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.geysermc.hydraulic.HydraulicImpl;
import org.geysermc.hydraulic.compat.CompatibilityRegistry;
import org.geysermc.hydraulic.compat.runtime.BedrockRuntimeActionRouter;
import org.geysermc.hydraulic.compat.runtime.RuntimeTraceId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Routes every server-authoritative block-use interaction through Hydraulic's compiled
 * runtime dispatch table before any vanilla or third-party mod block logic runs. This is
 * the generic interception seam that makes a compiled {@code interaction.block_use.action}
 * fact executable for any block identifier Hydraulic has compiled a plan for, without
 * requiring that mod's block class to call into Hydraulic itself.
 */
@Mixin(ServerPlayerGameMode.class)
public abstract class ServerPlayerGameModeMixin {
    private static final Logger LOGGER = LoggerFactory.getLogger("HydraulicRuntimeActions");

    @Inject(
        method = "useItemOn(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/InteractionResult;",
        at = @At("HEAD"),
        cancellable = true
    )
    private void hydraulic$routeCompiledBlockUseAction(
        ServerPlayer player,
        Level level,
        ItemStack stack,
        InteractionHand hand,
        BlockHitResult hitResult,
        CallbackInfoReturnable<InteractionResult> callback
    ) {
        // Isolated from vanilla/mod interaction dispatch: this seam fires for every block
        // interaction on the server, so a single malformed compiled plan or runtime failure
        // must never prevent normal block interaction from proceeding.
        try {
            CompatibilityRegistry registry = HydraulicImpl.instance().getPackManager().compatibilityRegistry();
            BedrockRuntimeActionRouter.RuntimeActionResult result = BedrockRuntimeActionRouter.executeBlockUse(
                player,
                hitResult.getBlockPos(),
                registry,
                RuntimeTraceId.create()
            );
            if (result.status() == BedrockRuntimeActionRouter.Status.MUTATED) {
                callback.setReturnValue(InteractionResult.SUCCESS_SERVER);
            }
        } catch (Throwable t) {
            LOGGER.warn("Failed to route compiled block-use action for {}, falling back to vanilla interaction", hitResult.getBlockPos(), t);
        }
    }
}

