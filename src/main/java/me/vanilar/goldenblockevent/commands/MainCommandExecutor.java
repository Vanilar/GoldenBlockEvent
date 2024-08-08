package me.vanilar.goldenblockevent.commands;

import me.vanilar.goldenblockevent.GoldenBlockEvent;
import me.vanilar.goldenblockevent.messages.MessageString;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MainCommandExecutor implements CommandExecutor {

    private GoldenBlockEvent plugin;

    public MainCommandExecutor(GoldenBlockEvent plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 0) {
            commandSender.sendMessage(
                    this.plugin.getMessages().getMessage(MessageString.ON_USE_MAIN_COMMAND_MESSAGE)
            );
        }
        if(commandSender instanceof Player) {

            Player player = (Player) commandSender;
        }
        return true;
    }
}
