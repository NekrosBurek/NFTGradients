package com.pixelcreations.nftwgradients.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.pixelcreations.nftwgradients.NFTWGradients;
import com.pixelcreations.nftwgradients.Storage.Query;
import com.pixelcreations.nftwgradients.Utils.Maps;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


@CommandAlias("admin")
public class AdminCommands extends BaseCommand {

    NFTWGradients nftwGradients = NFTWGradients.getPlugin(NFTWGradients.class);
    static Maps maps = new Maps();
    static Query query = new Query();

    @Default
    @CatchUnknown
    @CommandPermission("nftwgradients.admin")
    @Description("Reloads configuration files")

    public void onDefault(CommandSender sender, String[] args) {
        if (args.length < 1) {
            sender.sendMessage("...");
        } else if (args[0].equalsIgnoreCase("reload")) {
            nftwGradients.reloadConfig();
            sender.sendMessage("Reloaded configuration files");
        } else if (args[0].equalsIgnoreCase("clear")) {
            if (args.length < 2) {
                sender.sendMessage("Please specify a player");
            } else {
                clearGradient(sender, args[1]);
            }
        }
        else if (args[0].equalsIgnoreCase("set")) {
            if (args.length < 3) {
                sender.sendMessage("Please specify a player and a gradient");
            } else {
                Player player = Bukkit.getServer().getPlayer(args[1]);
                if (player != null) {
                    player.setDisplayName(ChatColor.RED + args[2]);
                }
                else {
                    sender.sendMessage("Player is not online");
                }
            }
        }
        else {
            sender.sendMessage("...");
        }
    }
    public void clearGradient(CommandSender sender, String player) {

        System.out.println("UUID PLAYERA PRE INICIJALIZACIJE");
        String uuid = Bukkit.getServer().getOfflinePlayer(player).getUniqueId().toString();

        if (nftwGradients.getDatabaseConnection().isConnected()) {
            if(uuid != null){
                query.clearGradient(uuid.toString());
            }
            else {
                sender.sendMessage("Player is not online");
            }

        }
        else {
            // Clear gradient from YAML
        }
        maps.updateMap(uuid, null);
    }



}
