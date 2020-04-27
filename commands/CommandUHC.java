package me.lounk.uhc.commands;

import me.lounk.uhc.utilities.Commands;
import me.lounk.uhc.utilities.Message;
import me.lounk.uhc.utilities.Subcommand;
import org.bukkit.command.CommandSender;

public class CommandUHC extends Subcommand {
    private String info = "";
    private String[] aliases = new String[]{"s"};

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        Message.cmdS(sender, "HEYYYY!!!!");
    }

    @Override
    public String name() {
        return Commands.start;
    }

    @Override
    public String info() {
        return info;
    }

    @Override
    public String[] aliases() {
        return aliases;
    }
}
