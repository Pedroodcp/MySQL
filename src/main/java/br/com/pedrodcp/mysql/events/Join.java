package br.com.pedrodcp.mysql.events;

import br.com.pedrodcp.mysql.entity.SQLManager;
import br.com.pedrodcp.mysql.entity.OBJ;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void Join(PlayerJoinEvent e) {
        if (SQLManager.getPlayer(e.getPlayer()) == null)
            OBJ.players.add(new OBJ(e.getPlayer().getName(), 0, "Sim"));
    }

}
