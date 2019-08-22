package com.unrealdinnerbone.reloadannouncer.toast;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.text.LiteralText;

public class ReloadToast extends SystemToast {

    private static final ToastManager TOAST_MANAGER = MinecraftClient.getInstance().getToastManager();

    private ReloadToast(String title, String subTitle) {
        super(Type.TUTORIAL_HINT, new LiteralText(title), new LiteralText(subTitle));
    }

    public static void sendToast(String title, String subTitle) {
        ToastManager toastManager = MinecraftClient.getInstance().getToastManager();
        ReloadToast reloadToast = new ReloadToast(title, subTitle);
        toastManager.add(reloadToast);
    }
}
