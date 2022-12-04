package tech.szurag.cobblex.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CountItems {

    public static int CountAmountItem (Inventory inventory, Material material) {

        int amount = 0;
        for (ItemStack item : inventory.getContents()) {
            if (item == null) continue;
            if (item.getType() == material) {
                amount += item.getAmount();
            }
        }

        return amount;
    }

}
