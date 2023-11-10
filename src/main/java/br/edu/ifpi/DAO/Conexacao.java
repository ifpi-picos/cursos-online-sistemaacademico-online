package br.edu.ifpi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexacao {
    // private static final Connection Drive = null;

    public static void main(String[] args) {
        try {
            Connection conexacao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemaacademico", "postgres", "adm05");
            if (conexacao != null){
                System.out.println("Banco de dados conectado");
                Statement stm = conexacao.createStatement();
                consultaDados(stm);
            }else{
                System.out.println("Falha na conexação");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    static void consultaDados(Statement stm){
        String sql = "select ID, NOME from cursos";
        try{ 
        ResultSet result =  stm.executeQuery(sql);
        while (result.next()){
            System.out.println("id" + result.getInt("ID")+ " Nome: " + result.getString("NOME"));
        }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
