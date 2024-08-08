package me.vanilar.goldenblockevent.messages;

import me.vanilar.goldenblockevent.GoldenBlockEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Messages {

    private GoldenBlockEvent plugin;
    private HashMap<MessageString, String> messages;
    private File configFile;
    private YamlConfiguration config;


    public Messages(GoldenBlockEvent plugin) {
        this.plugin = plugin;
        this.messages = new HashMap<>();
        this.loadMessagesConfig();
        this.loadMessagesStrings();
    }

    private void loadMessagesStrings() {
        for(MessageString messageString : MessageString.values()) {
            String message = this.config.getString("messages."+messageString.name(), "[NAME "+messageString.name()+" WAS NOT FOUND]");
            this.messages.put(messageString, message);
        }
    }

    private void loadMessagesConfig() {
        this.configFile = new File(this.plugin.getDataFolder(), "messages.yml");
        if(this.configFile.exists()) {
            this.plugin.saveResource("messages.yml", false);
        }
        this.config = YamlConfiguration.loadConfiguration(this.configFile);
    }

    public String getMessage(MessageString messageString) {
        if(this.messages.containsKey(messageString)) {
            return this.messages.getOrDefault(messageString, "[NAME "+messageString.name()+" WAS NOT FOUND]");
        }
        return "MESSAGE WAS NOT FOUND";
    }
}
