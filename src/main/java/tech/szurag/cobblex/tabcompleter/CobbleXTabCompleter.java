package tech.szurag.cobblex.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import tech.szurag.cobblex.CobbleX;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.bukkit.Bukkit.getServer;

public class CobbleXTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("cobblex"))
        {

            List<String> argList = new ArrayList<>();

            if (args.length == 1 && sender.hasPermission("szurag.cobblex.give"))
            {
                argList.add("give");

                return argList.stream().filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
            }

            if (args.length == 2)
            {
                for (Player p : getServer().getOnlinePlayers()) {
                    argList.add(p.getName());
                }

                return argList;
            }

            if (args.length == 3)
            {
                argList.add("ilość");
                return argList;
            }

            return argList; // returns an empty list

        }

        return null; // default return
    }
}
