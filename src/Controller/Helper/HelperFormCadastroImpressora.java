package Controller.Helper;

import Model.TipoImpressao;
import Model.Venda;
import View.FormCadastroImpressao;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class HelperFormCadastroImpressora {
    private final FormCadastroImpressao view;

    public HelperFormCadastroImpressora(FormCadastroImpressao view) {
        this.view = view;
    }

    public void preencherTipoImpressao(ArrayList<TipoImpressao> tiposDeImpressao) {
        DefaultComboBoxModel comboBox = (DefaultComboBoxModel) view.getCmbbxTipoImpressao().getModel();
        
        for (TipoImpressao tipoImpressao : tiposDeImpressao) {
            comboBox.addElement(tipoImpressao);
        }
        
    }
    
    public int obterQuantidadeFolhas() {
        return (int) view.getSpnrQtdeFolhas().getValue();
    }
    
    public TipoImpressao obterTipoImpressao() {
        return (TipoImpressao) view.getCmbbxTipoImpressao().getSelectedItem();
    }
    
    public Venda obterInformacoesTela() {
        int quantidade_folhas = (int) view.getSpnrQtdeFolhas().getValue();
        TipoImpressao objetoTelaTipoImpressao = (TipoImpressao) view.getCmbbxTipoImpressao().getSelectedItem();
        int id_tipo_impressao = objetoTelaTipoImpressao.getId();
        float valor_total = Float.parseFloat(view.getTxtfldValor().getText());
        
        Venda vendaTela = new Venda(quantidade_folhas, id_tipo_impressao, valor_total);
        return vendaTela;
    }

    public void setarValor(float valorCalculado) {
        view.getTxtfldValor().setText(valorCalculado+"");
    }

    public void limparTela() {
        view.getSpnrQtdeFolhas().setValue(0);
        view.getCmbbxTipoImpressao().setSelectedIndex(0);
        view.getTxtfldValor().setText("0.0");
    }
    
   
    
    
}
