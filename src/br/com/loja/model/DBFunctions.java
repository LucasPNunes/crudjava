package br.com.loja.model;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;


public class DBFunctions {
    public Connection connect_to_db(String dbname, String user, String pass){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+ dbname,user,pass);
            if(conn != null){
                System.out.println("Connected");
            }else{
                System.out.println("Connection failed");
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }
    public void createTables(Connection conn, String nomeTabela){
        Statement statement;
        try {
            String query = "CREATE TABLE " + nomeTabela + "(id_cliente SERIAL, nome VARCHAR(50), email VARCHAR(50), data_cadastro DATE, PRIMARY KEY(id_cliente));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRow(Connection conn, String nomeTabela, String nome, String email, Date data_cadastro){
        Statement statement;
        try{
            String query = String.format("INSERT INTO %s(nome, email, data_cadastro) VALUES('%s','%s','%s');", nomeTabela, nome, email, data_cadastro);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
