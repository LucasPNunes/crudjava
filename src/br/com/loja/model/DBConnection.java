package br.com.loja.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public Connection connect_to_db(){
        String user = "postgres";
        String dbname = "crudDB";
        String pass = "admin";

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
}
