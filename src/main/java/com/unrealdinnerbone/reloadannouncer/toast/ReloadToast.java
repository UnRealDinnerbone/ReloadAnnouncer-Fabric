package com.unrealdinnerbone.reloadannouncer.toast;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.text.StringTextComponent;

public class ReloadToast extends SystemToast {


    private ReloadToast(String title, String subTitle) {
        super(Type.TUTORIAL_HINT, new StringTextComponent(title), new StringTextComponent(subTitle));
    }

    public static void sendToat(String title, String subTitle) {
        ToastManager toastManager = MinecraftClient.getInstance().getToastManager();
        ReloadToast reloadToast = new ReloadToast(title, subTitle);
        toastManager.add(reloadToast);
    }
}
