package Model;
public class TipoImpressao {
    private int id;
    private String tipo_material;
    private float valor_unidade;

    public TipoImpressao(int id, String tipo_material, float valor_unidade) {
        this.id = id;
        this.tipo_material = tipo_material;
        this.valor_unidade = valor_unidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_material() {
        return tipo_material;
    }

    public void setTipo_material(String tipo_material) {
        this.tipo_material = tipo_material;
    }

    public float getValor_unidade() {
        return valor_unidade;
    }

    public void setValor_unidade(float valor_unidade) {
        this.valor_unidade = valor_unidade;
    }
    
    @Override
    public String toString() {
        return getTipo_material();
    }
    
    
}
