package br.com.pedrodcp.mysql.commands;

import br.com.pedrodcp.mysql.entity.PlayerManager;
import br.com.pedrodcp.mysql.entity.PlayerOBJ;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class teste implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("teste")) {
            PlayerOBJ playerAccount = PlayerManager.getPlayer(p.getName());
            playerAccount.setNumber(playerAccount.getNumber() + 1);
            if (playerAccount.getNumber() >= 1) {
                playerAccount.setTexto("Não");
            }
            p.sendMessage("§aComandos executados: §f" + playerAccount.getNumber());
            p.sendMessage("§aZero: §7" + playerAccount.getTexto());
        }
        return false;
    }
}
