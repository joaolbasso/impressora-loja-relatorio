package Controller.Helper;

import Model.TableModelVendas;
import View.RelatorioImpressao;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class HelperRelatorioImpressao {

    private final RelatorioImpressao view;

    public HelperRelatorioImpressao(RelatorioImpressao view) {
        this.view = view;
    }
    
    public void preencherTabela(ArrayList<TableModelVendas> tabelaVenda) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblVendas().getModel();
        tableModel.setNumRows(0);
        
        for (TableModelVendas venda : tabelaVenda) {
            tableModel.addRow(new Object[] {
                venda.getDataVenda(),
                venda.getQuantidade_folhas(),
                venda.getTipo_material(),
                venda.getValor_total()
                            }
            );
        }  
    }

    public String obterAtributoOrdenacao() {
        int atributoInteiro = view.getCmbAtributo().getSelectedIndex();
        String atributo;
        switch (atributoInteiro) {
            case 0:
                atributo = "v.data_venda";
                return atributo;
            case 1:
                atributo = "v.quantidade_folhas";
                return atributo;
            case 2:
                atributo = "ti.tipo_material";
                return atributo;
            case 3:
                atributo = "v.valor_total";
                return atributo;  
            default:
                throw new AssertionError();
        }
    }

    public void preencherValorTotal(Float valorTotal) {
        this.view.getLblValorTotal().setText("R$" + valorTotal.toString());
    }
    }

