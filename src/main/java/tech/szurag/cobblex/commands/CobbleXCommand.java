package tech.szurag.cobblex.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import tech.szurag.cobblex.utils.CobbleXBlock;

import static tech.szurag.cobblex.utils.CountItems.CountAmountItem;

public class CobbleXCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("give") && player.hasPermission("szurag.cobblex.give")) {

                    Player p;
                    if (args.length > 1)
                        p = Bukkit.getPlayer(args[1]);
                    else
                        p = player;

                    if (p == null) {
                        player.sendMessage(ChatColor.RED + "Nie znaleziono gracza!");
                        return true;
                    }

                    int amount;
                    if (args.length > 2) {
                        if (args[2].matches("^[0-9]*$")) {
                            amount = Integer.parseInt(args[2]);
                        } else {
                            ((Player) sender).sendMessage("§8[§aCobbleX§8] " + ChatColor.RED + "Wprowadziłxś coś co nie przypomina mi liczby.");
                            return true;
                        }
                    }
                    else amount = 1;

                    if (p.getInventory().firstEmpty() == -1) {
                        ((Player) sender).sendMessage("§8[§aCobbleX§8] " + ChatColor.RED + "Gracz: " + p.getDisplayName() + " nie otrzymał CobbleX (Brak miejsca w ekwipunku).");
                    } else {
                        p.getInventory().addItem(CobbleXBlock.CobbleX(amount));
                        p.sendMessage("§8[§aCobbleX§8] " + ChatColor.AQUA + "Otrzymałeś " + amount + " sztuk CobbleX");
                    }
                    return true;
                }
            }

            if (player.hasPermission("szurag.cobblex.cxusage")) {
                Inventory inventory = player.getInventory();
                int amountOfCobblestone = CountAmountItem(inventory, Material.COBBLESTONE);

                if (amountOfCobblestone == 576) {

                    inventory.removeItem(new ItemStack(Material.COBBLESTONE, 576));
                    inventory.addItem(CobbleXBlock.CobbleX(1));

                } else {
                    player.sendMessage("§8[§aCobbleX§8] " + ChatColor.RED + "Brakuje Ci " + (576 - amountOfCobblestone) + " cobblestone");
                }
            } else {
                player.sendMessage("§8[§aCobbleX§8] " + ChatColor.RED + "Brakuje Ci uprawnień do użycia tej komendy");
            }
        } else {
            Bukkit.getLogger().warning("Nie jesteś graczem. Nie możesz użyć tej komendy");
        }

        return true;

    }
}
