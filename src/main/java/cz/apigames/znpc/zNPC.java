package cz.apigames.znpc;

import org.bukkit.plugin.java.JavaPlugin;

public final class zNPC extends JavaPlugin {

    private static zNPC instance;

    @Override
    public void onEnable() {
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static zNPC getInstance() {
        return instance;
    }

}
