package com.unrealdinnerbone.reloadannouncer.client.mixin;

import com.unrealdinnerbone.reloadannouncer.ReloadAnnouncer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class ReloadCommandMixin {
    @Shadow private PlayerManager playerManager;

    @Inject(method = "reload", at = @At(value = "HEAD", target = "Lnet/minecraft/server/PlayerManager;saveAllPlayerData()V"))
    private void onRegisterStart(CallbackInfo info) {
        ReloadAnnouncer.onReloadStart(playerManager);
    }

    @Inject(method = "reload", at = @At(value = "RETURN", target = "Lnet/minecraft/server/PlayerManager;onDataPacksReloaded()V"))
    private void onRegisterEnd(CallbackInfo info) {
        ReloadAnnouncer.onReloadStop(playerManager);
    }
}


