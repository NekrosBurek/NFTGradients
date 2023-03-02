package com.pixelcreations.nftwgradients;

import co.aikar.commands.PaperCommandManager;
import com.pixelcreations.nftwgradients.Commands.AdminCommands;
import com.pixelcreations.nftwgradients.Commands.PlayerCommands;
import com.pixelcreations.nftwgradients.Events.onJoinChecker;
import com.pixelcreations.nftwgradients.Storage.MySQL;
import com.pixelcreations.nftwgradients.Utils.ConfigManager;
import com.pixelcreations.nftwgradients.Utils.PlaceholderManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class NFTWGradients extends JavaPlugin {

    private static MySQL mySQL;
    public static MySQL getDatabaseConnection() {
        return mySQL;
    }

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);
        if (ConfigManager.getStorageType().equalsIgnoreCase("mysql")) {
            mySQL = new MySQL();
            try {
                mySQL.connect();
                System.out.println(ChatColor.GREEN + "Connected to database");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("MySQL is not enabled, using YAML instead.");
        }

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceholderManager().register();
        }
        else {
            System.out.println("PlaceholderAPI not found, placeholders will not work.");
        }
        registerCommands();
        registerEvents();

    }

    public void registerCommands() {
        System.out.println("Registering commands...");
        PaperCommandManager manager = new PaperCommandManager(this);
        manager.enableUnstableAPI("help");
        manager.registerCommand(new AdminCommands());
        manager.registerCommand(new PlayerCommands());
        System.out.println("Commands registered!");
    }

    public void registerEvents() {
        System.out.println("Registering events...");
        getServer().getPluginManager().registerEvents(new onJoinChecker(), this);
        System.out.println("Registered events!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
