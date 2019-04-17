package com.unrealdinnerbone.reloadannouncer;

import net.minecraft.server.PlayerManager;
import net.minecraft.text.ChatMessageType;
import net.minecraft.text.TranslatableTextComponent;

public class MessageUtils
{
    public static void sendAllPlayersMessage(PlayerManager playerManager, String key) {
        playerManager.getPlayerList().forEach(serverPlayerEntity -> serverPlayerEntity.sendChatMessage(new TranslatableTextComponent(key), ChatMessageType.CHAT));
    }

}
