package Controller;

import Controller.Helper.HelperRelatorioImpressao;
import DAO.Conexao;
import DAO.VendaDAO;
import Model.TableModelVendas;
import View.RelatorioImpressao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerRelatorioImpressao {
    private final RelatorioImpressao view;
    private final HelperRelatorioImpressao helper;

    public ControllerRelatorioImpressao(RelatorioImpressao view) {
        this.view = view;
        this.helper = new HelperRelatorioImpressao(view);
    }

    public void atualizaTabelaVenda() throws SQLException {
        Connection connection = new Conexao().getConnection();
        VendaDAO vendaDAO = new VendaDAO(connection);
        String atributo = this.helper.obterAtributoOrdenacao();
        
        ArrayList<TableModelVendas> tabalaVenda = vendaDAO.selectTableVenda(atributo);
        this.helper.preencherTabela(tabalaVenda);
    }
    
    public void atualizaValorTotal() throws SQLException {
        Connection connection = new Conexao().getConnection();
        VendaDAO vendaDAO = new VendaDAO(connection);
        
        float valorTotal = vendaDAO.selectValorTotal();
        this.helper.preencherValorTotal(valorTotal);
    }

    
    
}
