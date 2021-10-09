package br.com.pedrodcp.mysql.connection;

import br.com.pedrodcp.mysql.connection.model.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL implements Model {

    private String host, user, password, database;
    private int port;

    public MySQL(String host, int port, String user, String password, String database) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s?autoReconnect=true", host, port, database), user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
