package com.pixelcreations.nftwgradients.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Array;

public class ConfigItem implements Comparable<ConfigItem> {

    String name;
    String lore;
    String item;
    double priority;
    String permission;

    ConfigItem(String name, String lore, String item, double priority, String permission) {
        this.name = name;
        this.lore = lore;
        this.item = item;
        this.priority = priority;
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }


    public ItemStack toItemStack() {
        ItemStack itemStack = new ItemStack(Material.valueOf(String.valueOf(item)));
        return itemStack;
    }


    @Override
    public int compareTo(@NotNull ConfigItem o) {
        return 0;
    }
}
