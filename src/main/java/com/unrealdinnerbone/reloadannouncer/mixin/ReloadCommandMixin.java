package com.unrealdinnerbone.reloadannouncer.mixin;

import com.unrealdinnerbone.reloadannouncer.MessageUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class ReloadCommandMixin
{
    @Shadow private PlayerManager playerManager;

    @Shadow public abstract void log(String string_1);

    @Inject(method = "reload", at = @At("HEAD"))
    private void onRegisterStart(CallbackInfo info) {
        MessageUtils.sendAllPlayersMessage(playerManager, "reloadannouncer.datapacks.reloadedStart");
    }

    @Inject(method = "reload", at = @At("RETURN"))
    private void onRegisterEnd(CallbackInfo info) {
        MessageUtils.sendAllPlayersMessage(playerManager, "reloadannouncer.datapacks.reloadedEnd");
    }

    @Inject(method = "reloadDataPacks(Lnet/minecraft/world/level/LevelProperties;)V", at = @At(value = "INVOKE", target = "Ljava/util/Iterator;hasNext()Z"))
    private void onStufF(CallbackInfo callbackInfo) {

    }

}
