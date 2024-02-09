package DAO;

import Model.TableModelVendas;
import Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendaDAO {
    private final Connection connection;

    public VendaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Venda venda) throws SQLException {
        String sql = "insert into venda(quantidade_folhas,id_tipo_impressao,valor_total) values (?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1,venda.getQuantidade_folhas());
        statement.setInt(2, venda.getId_tipo_impressao());
        statement.setFloat(3, venda.getValor_total());
        
        statement.execute();
  
    }
    
    public ArrayList<TableModelVendas> selectTableVenda(String atributo) throws SQLException {
        ArrayList<TableModelVendas> tableVendas = new ArrayList<>();
        String sql = "select v.data_venda, v.quantidade_folhas, ti.tipo_material, v.valor_total from venda v INNER JOIN tipo_impressao ti ON (ti.id_tipo_impressao = v.id_tipo_impressao) ORDER BY ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, atributo);
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()) {
            String data = resultSet.getString("data_venda");
            int quantidade_folhas = resultSet.getInt("quantidade_folhas");
            String tipo_material = resultSet.getString("tipo_material");
            float valor_total = resultSet.getFloat("valor_total");
            
            TableModelVendas itemTableVenda = new TableModelVendas(data, quantidade_folhas, tipo_material, valor_total);
            tableVendas.add(itemTableVenda);
        }
  
        return tableVendas;
    }
    
    public float selectValorTotal() throws SQLException {
        float valorTotal = 0;
        String sql= "select sum(valor_total) from venda";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.execute();
        
        ResultSet rs = statement.getResultSet();
        
        while(rs.next()) {
            valorTotal = rs.getFloat("sum");
        }
        return valorTotal;
    }
    
    /* 
    SELECT QUE UNE TAL PAPEL RESPECTIVO COM QUANTIDADE TOTAL
        select ti.tipo_material, sum(v.quantidade_folhas), sum(v.valor_total) from
        Tipo_impressao ti
        INNER JOIN Venda v ON (ti.id_tipo_impressao = v.id_tipo_impressao)
        GROUP BY ti.tipo_material;

        select sum(valor_total) from Venda;
    */
    
    
    /*COMANDO PARA PASSAR PARA A TABELA RELATORIO SQL
        select v.data_venda, v.quantidade_folhas, ti.tipo_material, v.valor_total from venda v INNER JOIN tipo_impressao ti ON (ti.id_tipo_impressao = v.id_tipo_impressao) ORDER BY ti.tipo_material
    */
    
    
     
}
