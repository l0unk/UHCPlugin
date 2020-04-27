package me.lounk.uhc.utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Message {
    static String prefix = ChatColor.getByChar(Settings.load().getString("plugin.prefix").substring(1,2)) + Settings.load().getString("plugin.prefix").substring(2) + " ";
    static ConsoleCommandSender c = Bukkit.getConsoleSender();
    static ChatColor fail = ChatColor.RED;
    static ChatColor success = ChatColor.GREEN;
    static ChatColor info = ChatColor.YELLOW;
    static ChatColor debug = ChatColor.DARK_RED;


    public static void consoleF(String message) {
        c.sendMessage(prefix + fail + message);
    }

    public static void consoleS(String message) {
        c.sendMessage(prefix + success + message);
    }
    public static void consoleI(String message) {
        c.sendMessage(prefix + info + message);
    }
    public static void consoleD(String message) {
        c.sendMessage(prefix + debug + message);
    }

    public static void cmdI(CommandSender p, String message) {
        p.sendMessage(prefix + info + message);
    }
    public static void cmdS(CommandSender p, String message) {
        p.sendMessage(prefix + success + message);
    }
    public static void cmdD(CommandSender p, String message) {
        p.sendMessage(prefix + debug + message);
    }
    public static void cmdF(CommandSender p, String message) {
        p.sendMessage(prefix + fail + message);
    }

    public static void playerI(Player p, String message) {
        p.sendMessage(prefix + info + message);
    }
    public static void playerS(Player p, String message) {
        p.sendMessage(prefix + success + message);
    }
    public static void playerD(Player p, String message) {
        p.sendMessage(prefix + debug + message);
    }
    public static void playerF(Player p, String message) {
        p.sendMessage(prefix + fail + message);
    }

}
