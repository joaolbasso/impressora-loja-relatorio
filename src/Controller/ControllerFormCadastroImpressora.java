package Controller;


import Controller.Helper.HelperFormCadastroImpressora;
import DAO.Conexao;
import DAO.TipoImpressaoDAO;
import DAO.VendaDAO;
import Model.TipoImpressao;
import Model.Venda;
import View.FormCadastroImpressao;
import View.RelatorioImpressao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerFormCadastroImpressora {
    private final FormCadastroImpressao view;
    private final HelperFormCadastroImpressora helper;

    public ControllerFormCadastroImpressora(FormCadastroImpressao view) {
        this.view = view;
        this.helper = new HelperFormCadastroImpressora(view);
    }

    public void registrarVenda() throws SQLException {
        Venda vendaTela = this.helper.obterInformacoesTela();
        Connection conexao = new Conexao().getConnection();
        VendaDAO vendaDAO = new VendaDAO(conexao);
        
        vendaDAO.insert(vendaTela);
        
        JOptionPane.showMessageDialog(view, "Venda registrada com sucesso!");
        limparTela();
    }
    
    public void atualizaTipoImpressao() throws SQLException {
        Connection conexao = new Conexao().getConnection();
        TipoImpressaoDAO tipoImpressaoDAO = new TipoImpressaoDAO(conexao);
        
        ArrayList<TipoImpressao> tiposDeImpressao = tipoImpressaoDAO.selectAll();
        this.helper.preencherTipoImpressao(tiposDeImpressao);
    }

    public void atualizaValor() {
        TipoImpressao tipoImpressao = this.helper.obterTipoImpressao();
        int qtde_folhas = this.helper.obterQuantidadeFolhas();
        
        float valorCalculado = tipoImpressao.getValor_unidade() * qtde_folhas;
        
        this.helper.setarValor(valorCalculado);
    }

    public void limparTela() {
        this.helper.limparTela();
    }
    
    public void entrarTelaRelatorio() throws SQLException {
        RelatorioImpressao telaImpressao = new RelatorioImpressao();
        telaImpressao.setVisible(true);
    }
    

    
    
    
    
    
    
}
