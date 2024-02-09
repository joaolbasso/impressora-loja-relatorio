package DAO;

import Model.TipoImpressao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoImpressaoDAO {
    private Connection connection;

    public TipoImpressaoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public ArrayList<TipoImpressao> selectAll() throws SQLException {
        String sql = "select * from tipo_impressao";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ArrayList<TipoImpressao> listaTipoImpressao = new ArrayList<TipoImpressao>();
        
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id_tipo_impressao"));
            String tipo_impressao = resultSet.getString("tipo_material");
            float valor_unidade = Float.parseFloat(resultSet.getString("valor_unidade"));
            
            TipoImpressao tipoImp = new TipoImpressao(id, tipo_impressao, valor_unidade);
            listaTipoImpressao.add(tipoImp);
            
        }
        return listaTipoImpressao;
        
    }
    
    
}
