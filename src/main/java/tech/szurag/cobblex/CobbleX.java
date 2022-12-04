package tech.szurag.cobblex;

import org.bukkit.Bukkit;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import tech.szurag.cobblex.commands.CobbleXCommand;
import tech.szurag.cobblex.listeners.CobbleXUsage;
import tech.szurag.cobblex.tabcompleter.CobbleXTabCompleter;

public final class CobbleX extends JavaPlugin implements TabCompleter {

    @Override
    public void onEnable() {

        getCommand("cobblex").setExecutor(new CobbleXCommand());
        getCommand("cobblex").setTabCompleter(new CobbleXTabCompleter());
        getServer().getPluginManager().registerEvents(new CobbleXUsage(), this);

    }


}