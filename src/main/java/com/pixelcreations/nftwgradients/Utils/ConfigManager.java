package com.pixelcreations.nftwgradients.Utils;

import com.pixelcreations.nftwgradients.NFTWGradients;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private static FileConfiguration config;

    public static void setupConfig(NFTWGradients nftwGradients){
        ConfigManager.config = nftwGradients.getConfig();
        nftwGradients.saveDefaultConfig();
    }

    // Messages from config
    public static String getNoPermissionMessage(){
        return config.getString("NoPermissionMessage");
    }
    public static String getReloadMessage(){
        return config.getString("ReloadMessage");
    }

    // Storage settings from config

    public static String getStorageType() {
        if (!config.getString("Storage.Type").isEmpty() && config.getString("Storage.Type").equalsIgnoreCase("mysql")) {
            return "MySQL";
        } else {
            return "YAML";
        }
    }

//    public static boolean getStorageString() {
//        System.out.println(config.getString("Storage.Type"));
//        if (!config.getString("Storage.Type").isEmpty()) {
//            System.out.println("Storage type is not empty");
//        } else {
//            System.out.println("Storage type is empty");
//        }
//        if (config.getString("Storage.Type").equalsIgnoreCase("mysql")) {
//            System.out.println("Storage type is MySQL");
//        }
//        else {
//            System.out.println("Storage type is YAML");
//        }
//        return false;
//    }
    public static String getHost() {
        return config.getString("Storage.Host");
    }
    public static int getPort() {
        return config.getInt("Storage.Port");
    }
    public static String getDatabase() {
        return config.getString("Storage.Database");
    }
    public static String getUser() {
        return config.getString("Storage.User");
    }
    public static String getPass() {
        return config.getString("Storage.Password");
    }

    

}
