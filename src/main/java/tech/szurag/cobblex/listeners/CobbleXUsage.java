package tech.szurag.cobblex.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import tech.szurag.cobblex.utils.CobbleXBlock;
import tech.szurag.cobblex.utils.CountItems;
import tech.szurag.cobblex.utils.RandomItem;

import static tech.szurag.cobblex.utils.CountItems.CountAmountItem;
import static tech.szurag.cobblex.utils.RandomItem.GetRandomItem;

public class CobbleXUsage implements Listener {
    @EventHandler
    public void onCobbleXUsage(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Inventory inventory = player.getInventory();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();
        int amount = mainHandItem.getAmount();
        if (amount <= 0) return;

        //Da sie pewnie to zrobic lepiej :(

        if (mainHandItem.equals(CobbleXBlock.CobbleX(amount))) {
            Location location = player.getLocation();
            ItemStack item = GetRandomItem();


            mainHandItem.setAmount(amount - 1);


            player.getWorld().dropItem(location, item);
//            inventory.addItem(item);
            player.sendMessage("§8[§aCobbleX§8] " + ChatColor.AQUA + "Otrzymujesz: " + item.getAmount() + " " + item.getType());
            player.playSound(location, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

            event.setCancelled(true);
        }
    }
}
