package br.com.loja.model;

import java.sql.Connection;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        DBFunctions db = new DBFunctions();
        Connection conn = db.connect_to_db("crudDB", "postgres", "admin");
        //db.createTables(conn, "clientes");
        db.insertRow(conn, "clientes", "Pedro", "pedrosilva@gmail.com", new Date());
    }
}
