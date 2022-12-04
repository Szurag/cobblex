package tech.szurag.cobblex.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;


public class RandomItem {
    public static ItemStack GetRandomItem() {

        RandomCollection<String> rc = new RandomCollection<>();

        rc
                .add(0.5, "golden_apple")
                .add(1, "tnt")
                .add(3, "diament")
                .add(5, "perla")
                .add(5, "bookshelf")
                .add(6, "emerald")
                .add(8, "gold")
                .add(10, "iron")
                .add(10, "apple")
                .add(20, "stone")
                .add(20, "dirt")
                .add(11.5, "oak_log");

        switch (rc.next()) {
            case "golden_apple":
                return new ItemStack(Material.GOLDEN_APPLE, (int)(Math.random() * 3 + 1));

            case "tnt":
                return new ItemStack(Material.TNT, (int)(Math.random() * 5 + 1));

            case "diament":
                return new ItemStack(Material.DIAMOND, (int)(Math.random() * 4 + 1));

            case "perla":
                return new ItemStack(Material.ENDER_PEARL, (int)(Math.random() * 3 + 1));

            case "emerald":
                return new ItemStack(Material.EMERALD, (int)(Math.random() * 4 + 1));

            case "gold":
                return new ItemStack(Material.GOLD_INGOT, (int)(Math.random() * 10 + 1));

            case "iron":
                return new ItemStack(Material.IRON_INGOT, (int)(Math.random() * 12 + 1));

            case "apple":
                return new ItemStack(Material.APPLE, (int)(Math.random() * 6 + 1));

            case "bookshelf":
                return new ItemStack(Material.BOOKSHELF, (int)(Math.random() * 5 + 1));

            case "stone":
                return new ItemStack(Material.STONE, (int)(Math.random() * 16 + 49));

            case "dirt":
                return new ItemStack(Material.DIRT, (int)(Math.random() * 16 + 49));

            case "oak_log":
                return new ItemStack(Material.OAK_LOG, (int)(Math.random() * 8 + 17));
        }

        return new ItemStack(Material.ENCHANTING_TABLE);
    }
}
