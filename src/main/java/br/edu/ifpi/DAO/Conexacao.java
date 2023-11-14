package br.edu.ifpi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexacao {
    // private static final Connection Drive = null;

    public static Connection getConexao() {
        Connection conexacao = null;
        try {
            conexacao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemaacademico", "postgres",
                    "adm05");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conexacao;
    }
}
