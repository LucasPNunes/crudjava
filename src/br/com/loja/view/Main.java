package br.com.loja.view;

import java.util.Date;

import br.com.loja.dao.ClientesDAO;
import br.com.loja.model.Clientes;

public class Main {
    public static void main(String[] args){
        Clientes c1 = new Clientes();
        c1.setNome("Clara");
        c1.setEmail("clara@email.com");
        c1.setDataCadastro(new Date());

        Clientes c2 = new Clientes();
        c2.setNome("Clara Dias");
        c2.setEmail("clara@email.com");
        c2.setDataCadastro(new Date());
        c2.setId(1);

        String nomeTabela = "clientes";

        ClientesDAO clientesdao = new ClientesDAO();
        clientesdao.createTables(nomeTabela);
        clientesdao.insertRow(nomeTabela, c1);
        clientesdao.readData(nomeTabela);
        clientesdao.updateName(nomeTabela, c2);
        clientesdao.readData(nomeTabela);
        clientesdao.deleteById(nomeTabela, c2);
    }
}
