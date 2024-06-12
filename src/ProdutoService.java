import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoService {
    
    public static void inserir(Produto produto) {
        try(Connection conn = App.getConexao()) {
            String sql = "INSERT INTO produto (id,nome,qtde,valor) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, produto.getId());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getQtde());
            ps.setDouble(4, produto.getValor());
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("PRODUTO INSERIDO!");
            }
        } catch(SQLException ex) {
            System.err.println("PRODUTO NÃO INSERIDO!");
            ex.printStackTrace();
        }
    }

    public static void atualizar(Produto produto, Long id) {
        try(Connection conn = App.getConexao()) {
            String sql = "UPDATE produto SET nome = ?, qtde = ?, valor = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getQtde());
            ps.setDouble(3, produto.getValor());
            ps.setLong(4, id);
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("PRODUTO ATUALIZADO!");
            }
        } catch(SQLException ex) {
            System.err.println("PRODUTO NÃO ATUALIZADO!");
            ex.printStackTrace();
        }
    }

}
