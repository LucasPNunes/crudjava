package br.com.loja.dao;

import br.com.loja.model.DBConnection;

import java.rmi.server.ExportException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import br.com.loja.model.Clientes;

public class ClientesDAO {
    private final DBConnection db;

    public ClientesDAO(){
        this.db = new DBConnection();
    }

    public void createTables(String nomeTabela){
        Connection conn = null;
        Statement statement;
        try {
            conn = db.connect_to_db();
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
        Connection conn = null;
        Statement statement;
        try{
            conn = db.connect_to_db();
            String query = String.format("INSERT INTO %s(nome, email, data_cadastro) VALUES('%s','%s','%s');", nomeTabela, c.getNome(), c.getEmail(), new Date (c.getDataCadastro().getTime()));
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void readData(String nomeTabela){
        Connection conn = null;
        Statement statement;
        ResultSet rs = null;
        try{
            conn = db.connect_to_db();
            String query = String.format("select * from %s", nomeTabela);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("id_cliente"));
                System.out.println(rs.getString("nome"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getDate("data_cadastro"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateName(String nomeTabela, Clientes c){
        Connection conn = null;
        Statement statement;
        try {
            conn = db.connect_to_db();
            String query = String.format("UPDATE %s SET nome ='%s', email ='%s', data_cadastro ='%s' WHERE id_cliente ='%s'",
                    nomeTabela,
                    c.getNome(),
                    c.getEmail(),
                    new Date (c.getDataCadastro().getTime()),
                    c.getId());
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void deleteById(String nomeTabela, Clientes c){
        Connection conn = null;
        Statement statement;
        try{
            conn = db.connect_to_db();
            String query = String.format("DELETE FROM %s WHERE id_cliente='%s'", nomeTabela, c.getId());
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
