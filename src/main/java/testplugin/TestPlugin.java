package testplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import testplugin.commands.CommandListener;
import testplugin.listeners.CommandPreprocessor;

/**
 * Created by Aashish on 2/26/2016.
 */
public class TestPlugin extends JavaPlugin {
    private FileConfiguration config;

    @Override
    public void reloadConfig() {
        super.reloadConfig();

        config = getConfig();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        config = getConfig();

        this.getServer().getPluginManager().registerEvents(new CommandPreprocessor(this), this);
        getCommand("alias").setExecutor(new CommandListener(this));
    }

    public FileConfiguration getConfiguration() {
        return config;
    }
}
