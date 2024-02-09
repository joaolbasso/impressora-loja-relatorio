package Model;

import DAO.Conexao;
import DAO.VendaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class teste {
    public static void main(String[] args) throws SQLException {
        Date dataSistema = new Date();
        System.out.println(dataSistema);
        
        Connection connection = new Conexao().getConnection();
        VendaDAO vendaDAO = new VendaDAO(connection);
        
        float selectValorTotal = vendaDAO.selectValorTotal();
        System.out.println(selectValorTotal);
        
    }
}
