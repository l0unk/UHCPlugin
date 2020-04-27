package me.lounk.uhc.utilities;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Settings {
    private static File file;

    private static FileConfiguration customFile;


    public static void setup(){
        File datafolder = Bukkit.getServer().getPluginManager().getPlugin("UHC").getDataFolder();
        if(!datafolder.exists()) {
            datafolder.mkdir();
        }
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("UHC").getDataFolder(), "settings.yml");
        if (!file.exists()){

            try{
                file.createNewFile();

            }catch (IOException e){
                Message.consoleF("Cannot create settings.yml");
                e.printStackTrace();
            }

        }

        customFile = YamlConfiguration.loadConfiguration(file);

    }



    public static FileConfiguration load(){
        return customFile;
    }



    public static void save(){

        try{
            customFile.save(file);
        }catch (IOException e){
            Message.consoleF("Could not save settings.yml");
        }

    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
