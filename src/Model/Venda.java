package Model;

public class Venda {
    private int id_venda;
    private int quantidade_folhas;
    private int id_tipo_impressao;
    private float valor_total;

    public Venda(int quantidade_folhas, int id_tipo_impressao, float valor_total) {
        this.quantidade_folhas = quantidade_folhas;
        this.id_tipo_impressao = id_tipo_impressao;
        this.valor_total = valor_total;
    }
    
    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getQuantidade_folhas() {
        return quantidade_folhas;
    }
    
    public void setQuantidade_folhas(int quantidade_folhas) {
        this.quantidade_folhas = quantidade_folhas;
    }

    public int getId_tipo_impressao() {
        return id_tipo_impressao;
    }

    public void setId_tipo_impressao(int id_tipo_impressao) {
        this.id_tipo_impressao = id_tipo_impressao;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    @Override
    public String toString() {
        return "Venda{" + "id_venda=" + id_venda + ", quantidade_folhas=" + quantidade_folhas + ", id_tipo_impressao=" + id_tipo_impressao + ", valor_total=" + valor_total + '}';
    }
     
}
