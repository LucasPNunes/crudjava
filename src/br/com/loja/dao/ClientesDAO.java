package br.com.loja.dao;

import br.com.loja.model.DBConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import br.com.loja.model.Clientes;

public class ClientesDAO {
    private final DBConnection db;

    public ClientesDAO(){
        this.db = new DBConnection();
    }

    public void createTables(String nomeTabela){
        Connection conn = db.connect_to_db();
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

    public void insertRow(String nomeTabela, Clientes c){
        Connection conn = db.connect_to_db();
        Statement statement;
        try{
            String query = String.format("INSERT INTO %s(nome, email, data_cadastro) VALUES('%s','%s','%s');", nomeTabela, c.getNome(), c.getEmail(), c.getDataCadastro());
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
