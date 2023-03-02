package com.pixelcreations.nftwgradients.Utils;

import com.pixelcreations.nftwgradients.NFTWGradients;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class GUI {

    NFTWGradients nftwGradients = NFTWGradients.getPlugin(NFTWGradients.class);
    FileConfiguration config = nftwGradients.getConfig();

    public void openGUI(Player player) {
        List<ConfigItem> items = new ArrayList<>();
        for (String gradients : config.getKeys(false)) {
            ConfigurationSection section = config.getConfigurationSection("Gradients");
            ConfigItem item = new ConfigItem(section.getString("name"), section.getString("lore"), section.getString("item"), section.getDouble("priority"), section.getString("permission"));
            items.add(item);
        }

        Collections.sort(items);


        Inventory gui = Bukkit.createInventory(null, 27, "Config Items");

        int slot = 0;
        for (ConfigItem item : items) {
            if (item.getPermission() == null || player.hasPermission(item.getPermission())) {
                // Player has permission for this item, add it to the next available slot
                ItemMeta meta = item.toItemStack().getItemMeta();
                meta.setDisplayName(item.name);
                item.toItemStack().setItemMeta(meta);
                gui.setItem(slot, item.toItemStack());
                slot++;
            } else {
                // Player does not have permission for this item, add a placeholder item to the end of the GUI
                ItemStack placeholder = new ItemStack(Material.BARRIER);
                ItemMeta meta = placeholder.getItemMeta();
                meta.setDisplayName(ChatColor.RED + "You do not have permission to view this item");
                placeholder.setItemMeta(meta);
                gui.setItem(gui.getSize() - 1, placeholder);
            }
        }
        player.openInventory(gui);
    }


}
