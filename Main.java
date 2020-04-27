package me.lounk.uhc;

import me.lounk.uhc.utilities.CommandManager;
import me.lounk.uhc.utilities.Settings;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        setup();
        setupConfig();
        setupCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }

    private void setup() {
        setInstance(this);
    }

    public void setupConfig() {
        Settings.setup();
        Settings.load().options().copyDefaults(true);
        Settings.load().addDefault("plugin.prefix","&e[!]");
        Settings.save();
    }

    public void setupCommands() {
        CommandManager commandManager = new CommandManager();
        commandManager.setup();
    }

    public void setInstance(Main instance) {
        this.instance = instance;
    }

}
