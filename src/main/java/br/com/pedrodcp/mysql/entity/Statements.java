package br.com.pedrodcp.mysql.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.pedrodcp.mysql.Main.*;

public class Statements {

    private static Connection connection;

    private static void openConnection() {
        connection = model.getConnection();
    }

    public static void Initialize() {
        try {
            openConnection();
            PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS config (nickname varchar(16), number int, zero Text)");
            ps.executeUpdate();
            ps.close();
            loadPlayers();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loadPlayers() {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM config");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) OBJ.players.add(new OBJ(rs.getString("nickname"), rs.getInt("number"), rs.getString("zero")));
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean exists(String playerName) {
        boolean exists = false;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT nickname FROM config WHERE nickname=?");
            ps.setString(1, playerName.toLowerCase());
            ResultSet rs = ps.executeQuery();
            exists = rs.next();
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public static void savePlayers() {
        try {
            openConnection();
            PreparedStatement prepareStatement = connection.prepareStatement("UPDATE config SET number=?, zero=? WHERE nickname=?");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO config (nickname, number, zero) VALUES (?, ?, ?)");
            for (OBJ playerAccount : OBJ.players) {
                if (exists(playerAccount.getPlayerName())) {
                    prepareStatement.setString(3, playerAccount.getPlayerName().toLowerCase());
                    prepareStatement.setInt(1, playerAccount.getNumber());
                    prepareStatement.setString(2, playerAccount.getTexto());
                    prepareStatement.executeUpdate();

                } else {
                    ps.setString(1, playerAccount.getPlayerName().toLowerCase());
                    ps.setInt(2, playerAccount.getNumber());
                    ps.setString(3, playerAccount.getTexto());
                    ps.executeUpdate();
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
