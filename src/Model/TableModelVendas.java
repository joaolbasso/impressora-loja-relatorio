package Model;

/*Essa classe foi criada com atributos para preencher a tabela do RelatorioVendas, pois a SQL que era executado tinha INNER JOIN entre duas tables, então essa classe e seus atributos
se encaixam perfeitamente na JTable*/

public class TableModelVendas {
    private String dataVenda;
    private int quantidade_folhas;
    private String tipo_material;
    private float valor_total;

    public TableModelVendas(String dataVenda, int quantidade_folhas, String tipo_material, float valor_total) {
        this.dataVenda = dataVenda;
        this.quantidade_folhas = quantidade_folhas;
        this.tipo_material = tipo_material;
        this.valor_total = valor_total;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getQuantidade_folhas() {
        return quantidade_folhas;
    }

    public void setQuantidade_folhas(int quantidade_folhas) {
        this.quantidade_folhas = quantidade_folhas;
    }

    public String getTipo_material() {
        return tipo_material;
    }

    public void setTipo_material(String tipo_material) {
        this.tipo_material = tipo_material;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }
    
    
}
