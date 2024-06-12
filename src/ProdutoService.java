import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoService {
    
    public static void inserir(Produto produto) {
        try(Connection conn = App.getConexao()) {
            String sql = "INSERT INTO produto (id,nome,qtde,dtValidade,valor) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, produto.getId());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getQtde());
            ps.setDate(4, produto.getDtValidade());
            ps.setDouble(5, produto.getValor());
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("PRODUTO INSERIDO!");
            }
        } catch(SQLException ex) {
            System.err.println("PRODUTO NÃO INSERIDO!");
            ex.printStackTrace();
        }
    }

}
