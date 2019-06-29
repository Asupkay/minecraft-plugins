package com.obscurityGames.roleplayChat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void AsyncChatEvent(AsyncPlayerChatEvent e) {
        System.out.println(e.getMessage());
    }
}
