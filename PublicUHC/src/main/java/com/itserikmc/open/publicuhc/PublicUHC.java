package com.itserikmc.open.publicuhc;

/*
 *
 * This project is under the licenses and terms stated at
 * https://raw.githubusercontent.com/ItsErikMC/public-uhc/master/LICENSE.md
 *
 */

import com.itserikmc.open.publicuhc.command.CommandModule;
import com.itserikmc.open.publicuhc.store.FileStore;
import com.itserikmc.open.publicuhc.store.Store;
import com.itserikmc.open.publicuhc.util.UtilMessages;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;

public final class PublicUHC extends JavaPlugin {

    private static PublicUHC instance;

    private File configFile;
    private Store store = new FileStore();
    private ArrayList<Module> modules = new ArrayList<>();

    public YamlConfiguration lang;

    public static PublicUHC getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveResource("config.yml", false);
            saveResource("lang.yml", true);
        }
        lang = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "lang.yml"));

//        if (getConfig().getString("store.type").equalsIgnoreCase("file"))
//            store = new FileStore();
//        if (getConfig().getString("store.type").equalsIgnoreCase("sql"))
//            store = new SQLStore();
        store.Enable();
        UtilMessages.log(Level.INFO, "Store started as FileStore");

        modules.add(new CommandModule());
        
        modules.forEach(module -> {
            module.Enable();
            UtilMessages.log(Level.INFO, "Module " + module.name + " Enabled.");
        });
    }

    @Override
    public void onDisable() {
        instance = null;
        modules.forEach(module -> {
            module.Disable();
            UtilMessages.log(Level.INFO, "Module " + module.name + " Disabled.");
        });

        store.Disable();
    }
}
