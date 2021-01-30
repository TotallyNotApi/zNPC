package cz.apigames.znpc.Utils;

import cz.apigames.znpc.zNPC;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

public class ConfigManager {

    private static zNPC plugin = zNPC.getInstance();
    private static HashMap<String, YamlConfiguration> configs = new HashMap<String, YamlConfiguration>() {
    };

    public static void loadConfig(String configName) {
        File ConfigFile = new File(plugin.getDataFolder(), configName);
        if (!ConfigFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(MessageUtils.colorize("&e[zNPC] &cSoubor " + configName + " nebyl nalezen! Vytvarim novy.."));
            plugin.saveResource(configName, false);
            Bukkit.getConsoleSender().sendMessage(MessageUtils.colorize("&e[zNPC] &aSoubor " + configName + " byl vytvoren!"));
        }
        configs.put(configName, YamlConfiguration.loadConfiguration(ConfigFile));
    }

    public static void reloadConfig(String configName) {
        loadConfig(configName);
    }

    public static YamlConfiguration getConfig(String configName) {
        return configs.get(configName);
    }

}
