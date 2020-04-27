package me.lounk.uhc.commands;

import me.lounk.uhc.utilities.Commands;
import me.lounk.uhc.utilities.Message;
import me.lounk.uhc.utilities.Settings;
import me.lounk.uhc.utilities.Subcommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CommandUHC extends Subcommand {
    private String info = "";
    private String[] aliases = new String[]{"s"};

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        Message.cmdS(sender, "HEYYYY!!!!");
        playerScatter();
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


    public void playerScatter() {
        List<Location> spawns = new ArrayList<>();
        for(Player player : Bukkit.getOnlinePlayers()) {
            boolean spawned = false;
            Location spawn = null;
            int i = 0;
            while(!spawned) {
                spawned = true;
                if(i == 500) {
                    Message.consoleF("Couldn't scatter player");
                    break;
                }
                spawn = scatterPlayer(player);
                if(spawn == null) {
                    Message.consoleF("Something went wrong, couldn't scatter " + player.getName());
                    spawned = false;
                }
                for(Location distance : spawns) {
                    if(distance.distance(spawn) < 200) {
                        spawned = false;
                    }
                }
            }
            player.teleport(spawn);
            spawns.add(spawn);
        }


    }


    public Location scatterPlayer(Player player) {
        int x = ThreadLocalRandom.current().nextInt(-1000, 1000 + 1);
        int z = ThreadLocalRandom.current().nextInt(-1000, 1000 + 1);
        World world = Bukkit.getWorld(Settings.load().getString("uhc.worldname"));
        Location spawn = null;
        int i = 0;
        for(int y = 40; y < world.getMaxHeight(); ++y) {
            if(world.getBlockAt(x, y, z).getType() == Material.AIR || world.getBlockAt(x, y, z).getType() == Material.CAVE_AIR) {
                ++i;
            } else {
                i = 0;
            }
            if(i == 2) {
                spawn = world.getBlockAt(x, y - 1, z).getLocation();
                break;
            }
        }
        return spawn;
    }
}
