package com.pixelcreations.nftwgradients.Utils;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PlaceholderManager extends PlaceholderExpansion {

    @Override
    public String getIdentifier() {
        return "nft";
    }

    @Override
    public String getAuthor() {
        return "NekrosBurek";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    Maps maps = new Maps();


    @Override
    public String onPlaceholderRequest(Player player, String params) {
        if (player == null) {
            return "";
        }
        if (params.equalsIgnoreCase("name")) {
            return String.valueOf(maps.getGradientMap(player.getUniqueId().toString()));
        }

        return "";
    }
}
