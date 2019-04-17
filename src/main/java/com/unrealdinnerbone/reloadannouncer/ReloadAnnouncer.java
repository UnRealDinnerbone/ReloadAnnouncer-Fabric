package com.unrealdinnerbone.reloadannouncer;

import com.unrealdinnerbone.reloadannouncer.toast.ReloadToast;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.server.PlayerManager;

public class ReloadAnnouncer implements ClientModInitializer{

    private static long lastStartTime = 0;

    public static void onReloadStart(PlayerManager playerManager) {
        ReloadToast.sendToat("Reloading!", "");
        lastStartTime = System.currentTimeMillis();
//        MessageUtils.sendAllPlayersMessage(playerManager, "reloadannouncer.datapacks.reloadedStart");
    }

    public static void onReloadStop(PlayerManager playerManager) {
        ReloadToast.sendToat("Reloaded!", "Reloaded in " + ((System.currentTimeMillis() - lastStartTime) / 1000) + "s") ;
//        MessageUtils.sendAllPlayersMessage(playerManager, "reloadannouncer.datapacks.reloadedEnd");
    }


    @Override
    public void onInitializeClient() {
        System.out.println("Loading Reload Announcer Client!");
    }
}
