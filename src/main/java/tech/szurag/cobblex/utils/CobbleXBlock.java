package tech.szurag.cobblex.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CobbleXBlock {
    public static ItemStack CobbleX(int amount) {
        ItemStack cobble = new ItemStack(Material.MOSSY_COBBLESTONE);
        cobble.setAmount(amount);

        ItemMeta meta = cobble.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "Pradawny CobbleX od najstarszego rodu Saginów");
        meta.setLore(lore);
        meta.setDisplayName(ChatColor.GREEN + "COBBLEX");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);

        cobble.setItemMeta(meta);

        return cobble;
    }
}
