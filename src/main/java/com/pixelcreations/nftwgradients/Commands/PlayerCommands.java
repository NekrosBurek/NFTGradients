package com.pixelcreations.nftwgradients.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.pixelcreations.nftwgradients.Utils.GUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("gradients")
public class PlayerCommands extends BaseCommand {
    @Default
    @CatchUnknown
    @CommandPermission("nftwgradients.player")

    public void onDefault(CommandSender sender, String[] args) {
        GUI gui = new GUI();
        gui.openGUI((Player) sender);
    }
}
