package com.obscurityGames.roleplayChat;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void LocalChat(AsyncPlayerChatEvent e) {
        System.out.println(e.getMessage());
        e.getRecipients().clear();
        int range = 15;
        Player originalPlayer = e.getPlayer();
        Location originalLocation = originalPlayer.getLocation();
        Player[] players = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        for(Player player: players) {
            if(player.getLocation().distance(originalLocation) <= range) {
                e.getRecipients().add(player);
            }
        }

        System.out.println(e.getRecipients().toString());
        if(e.getRecipients().size() == 1) {
            originalPlayer.sendMessage("No one is around");
        }
    }
}
