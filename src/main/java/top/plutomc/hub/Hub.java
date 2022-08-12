package top.plutomc.hub;

import org.bukkit.plugin.java.JavaPlugin;

public final class Hub extends JavaPlugin {

    private static JavaPlugin instance;

    public static JavaPlugin instance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
