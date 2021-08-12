package br.com.pedrodcp.mysql.events;

import br.com.pedrodcp.mysql.entity.PlayerManager;
import br.com.pedrodcp.mysql.entity.PlayerOBJ;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void Join(PlayerJoinEvent e) {
        if (PlayerManager.getPlayer(e.getPlayer()) == null)
            PlayerOBJ.players.add(new PlayerOBJ(e.getPlayer().getName(), 0, "Sim"));
    }

}
