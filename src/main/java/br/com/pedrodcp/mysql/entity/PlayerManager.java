package br.com.pedrodcp.mysql.entity;

import org.bukkit.entity.Player;

public class PlayerManager {

    public static PlayerOBJ getPlayer(Player player) {
        return getPlayer(player.getName());
    }

    public static PlayerOBJ getPlayer(String player) {
        for (PlayerOBJ playerAccount : PlayerOBJ.players)
            if (playerAccount.getPlayerName().equalsIgnoreCase(player.toLowerCase())) return playerAccount;
        return null;
    }

    public static boolean setNumber(String player, int number) {
        PlayerOBJ playerAccount = getPlayer(player);
        if (playerAccount == null) return false;
        playerAccount.setNumber(number);
        return true;
    }

    public static boolean getNumber(String player, int number) {
        PlayerOBJ playerAccount = getPlayer(player);
        return playerAccount != null && playerAccount.getNumber() == number;
    }

    public static boolean setTexto(String player, String texto) {
        PlayerOBJ playerAccount = getPlayer(player);
        if (playerAccount == null) return false;
        playerAccount.setTexto(texto);
        return true;
    }

    public static boolean getTexto(String player, String texto) {
        PlayerOBJ playerAccount = getPlayer(player);
        return playerAccount != null && playerAccount.getTexto() == texto;
    }

    //

    public static boolean setNumber(Player player, int number) {
        return getNumber(player.getName(), number);
    }

    public static boolean getNumber(Player player, int number) {
        return getNumber(player.getName(), number);
    }

    //

    public static boolean setTexto(Player player, String texto) {
        return getTexto(player.getName(), texto);
    }

    public static boolean getTexto(Player player, String texto) {
        return getTexto(player.getName(), texto);
    }

}
