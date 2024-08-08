package me.vanilar.goldenblockevent.listeners;

import me.vanilar.goldenblockevent.GoldenBlockEvent;
import org.bukkit.event.Listener;

public class MinecraftListener implements Listener {

    private GoldenBlockEvent plugin;

    public MinecraftListener(GoldenBlockEvent plugin) {
        this.plugin = plugin;
    }
}
