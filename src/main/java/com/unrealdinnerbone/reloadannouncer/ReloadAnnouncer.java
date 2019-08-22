package com.unrealdinnerbone.reloadannouncer;

import com.unrealdinnerbone.reloadannouncer.toast.ReloadToast;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.SharedConstants;
import net.minecraft.server.PlayerManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReloadAnnouncer implements ClientModInitializer {

    public final static Logger LOGGER = LogManager.getLogger();

    private static long lastStartTime = 0;
    public static void onReloadStart(PlayerManager playerManager) {
        ReloadToast.sendToast("Reloading!", "");
        lastStartTime = System.currentTimeMillis();
    }

    public static void onReloadStop(PlayerManager playerManager) {
        ReloadToast.sendToast("Reloaded!", "Reloaded in " + ((System.currentTimeMillis() - lastStartTime) / 1000) + "s") ;
    }

    @Override
    public void onInitializeClient() {
        LOGGER.info("[Reload Announcer Client] Loading!");
        SharedConstants.isDevelopment = true;
    }
}
