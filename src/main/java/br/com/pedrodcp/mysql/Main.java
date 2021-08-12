package br.com.pedrodcp.mysql;

import br.com.pedrodcp.mysql.commands.teste;
import br.com.pedrodcp.mysql.events.Join;
import br.com.pedrodcp.mysql.connection.model.Model;
import br.com.pedrodcp.mysql.entity.Statements;
import br.com.pedrodcp.mysql.connection.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Model model;
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        model = new MySQL(getConfig().getString("MYSQL.host"), getConfig().getInt("MYSQL.port"), getConfig().getString("MYSQL.user"), getConfig().getString("MYSQL.password"), getConfig().getString("MYSQL.database"));
        Statements.Initialize();
        loadCommands();
        loadConfig();
        loadEvents();
        Bukkit.getConsoleSender().sendMessage("§a[MySQL] Plugin carregado com sucesso.");
    }

    @Override
    public void onDisable() {
        Statements.savePlayers();
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("§c[MySQL] Plugin desativado.");
    }

    public void loadCommands() {
        getCommand("teste").setExecutor(new teste());
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public void loadEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Join(), this);
    }

    public static Main getInstance() {
        return instance;
    }
}
