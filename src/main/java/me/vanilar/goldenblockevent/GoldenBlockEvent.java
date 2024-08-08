package me.vanilar.goldenblockevent;

import me.vanilar.goldenblockevent.commands.MainCommandExecutor;
import me.vanilar.goldenblockevent.listeners.MinecraftListener;
import me.vanilar.goldenblockevent.messages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GoldenBlockEvent extends JavaPlugin {

    private MinecraftListener minecraftListener;
    private MainCommandExecutor mainCommandExecutor;
    private Messages messages;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.loadConfigs();
        this.minecraftListener = new MinecraftListener(this);
        this.mainCommandExecutor = new MainCommandExecutor(this);
        this.messages = new Messages(this);

        Bukkit.getPluginManager().registerEvents(this.minecraftListener, this);
        Objects.requireNonNull(this.getCommand("goldenblockevent")).setExecutor(this.mainCommandExecutor);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadConfigs() {
        this.saveDefaultConfig();
    }

    public Messages getMessages() {
        return this.messages;
    }
}
