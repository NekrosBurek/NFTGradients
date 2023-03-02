package com.pixelcreations.nftwgradients.Events;

import com.pixelcreations.nftwgradients.NFTWGradients;
import com.pixelcreations.nftwgradients.Storage.Query;
import com.pixelcreations.nftwgradients.Utils.Maps;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class onJoinChecker implements Listener {

    Query query = new Query();
    Maps maps = new Maps();

    NFTWGradients nftwGradients;

    @EventHandler
    public void onJoinChecker(PlayerJoinEvent event) {
        String uuid = event.getPlayer().getUniqueId().toString();
        if (nftwGradients.getDatabaseConnection().isConnected()) {
            if (maps.getGradientMap(uuid) == null) {
                String gradient = query.checkGradient(uuid);
                maps.updateMap(uuid, gradient);
            }
            else {
                maps.updateMap(uuid, maps.getGradientMap(uuid));
            }
        }
        else {
            // Check and update values from YAML
        }

    }
}
