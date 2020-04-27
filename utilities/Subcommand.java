package me.lounk.uhc.utilities;

import org.bukkit.command.CommandSender;

public abstract class Subcommand {
    public Subcommand() {
    }
    public abstract void onCommand(CommandSender sender, String[] args);
    public abstract String name();
    public abstract String info();
    public abstract String[] aliases();
}
