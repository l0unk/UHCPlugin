package me.lounk.uhc.utilities;

import me.lounk.uhc.Main;
import me.lounk.uhc.commands.CommandUHC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandManager implements CommandExecutor {
    private static ArrayList<Subcommand> commands = new ArrayList<>();
    private Main plugin = Main.getInstance();

    public void setup() {
        plugin.getCommand(Commands.main).setExecutor(this);
        this.commands.add(new CommandUHC());
    }

    public static ArrayList<Subcommand> getCommands() {
        return commands;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase(Commands.main)) {
            if (args.length == 0) {
                Message.cmdF(sender, "help message for main command u fucked up prob");
                return true;
            }

            Subcommand target = this.get(args[0]);
            if (target == null) {
                Message.cmdF(sender, "This subcommand was not found");
                return true;
            }
            ArrayList<String> arguments = new ArrayList<String>();
            arguments.addAll(Arrays.asList(args));
            arguments.remove(0);
            target.onCommand(sender, args);
        }
        return true;
    }

    private Subcommand get(String name) {
        Iterator<Subcommand> subcommandsi = commands.iterator();

        while (subcommandsi.hasNext()) {
            Subcommand subcommand = subcommandsi.next();

            if (subcommand.name().equalsIgnoreCase(name)) {
                return subcommand;
            }

            String[] aliases;
            int length = (aliases = subcommand.aliases()).length;
            for (int i = 0; i < length; ++i) {
                String alias = aliases[i];
                if (name.equalsIgnoreCase(alias)) {
                    return subcommand;
                }
            }
        }
        return null;
    }

}

