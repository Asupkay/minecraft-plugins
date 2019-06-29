package com.obscurityGames.roleplayChat;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.configuration.file.FileConfiguration;

public class ChatListener implements Listener {
    private Main plugin;
    private FileConfiguration config; 

    //Get the plugin instance and pull the configuration from that
    public ChatListener(Main instance) {
        plugin = instance;        
        config = plugin.getConfig();
    }

    //Handles when there is a chat event
    @EventHandler
    public void LocalChat(AsyncPlayerChatEvent e) {
        //Get the variables from the config
        int range = Integer.parseInt(config.getString("localRange"));
        String noOneAroundMessage = config.getString("noOneIsAroundMessage");
        noOneAroundMessage = ChatColor.translateAlternateColorCodes('&', noOneAroundMessage);

        //Clear the previous recipients of the message
        e.getRecipients().clear();

        //Loop over the online players and if they are within range add them to the recipients
        Player originalPlayer = e.getPlayer();
        Location originalLocation = originalPlayer.getLocation();
        Player[] onlinePlayers = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        for(Player player: onlinePlayers) {
            if(player.getLocation().distance(originalLocation) <= range) {
                e.getRecipients().add(player);
            }
        }

        //If the only recipient is himself tell him he's alone
        if(e.getRecipients().size() == 1) {
            originalPlayer.sendMessage(noOneAroundMessage);
        }
    }
}
