import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    
    public static void inserir(Produto produto) throws SQLException {
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

    public static void atualizar(Produto produto, Long id) throws SQLException {
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

    public static void deletar(Produto produto) throws SQLException {
        try(Connection conn = App.getConexao()) {
            String sql = "DELETE FROM produto WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, produto.getId());
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("PRODUTO DELETADO!");
            }
        } catch(SQLException ex) {
            System.err.println("PRODUTO NÃO DELETADO!");
            ex.printStackTrace();
        }
    }
    
    public static List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try(Connection conn = App.getConexao()) {
            String sql = "SELECT * FROM produto";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setQtde(rs.getInt("qtde"));
                p.setValor(rs.getDouble("valor"));
                produtos.add(p);
            }
        } catch(SQLException ex) {
            System.err.println("NÃO FOI POSSÍVEL LISTAR OS PRODUTOS!");
            ex.printStackTrace();
        }
        return produtos;
    }
    
    public static List<Produto> listarPorNome(String nome) {
        List<Produto> produtos = new ArrayList<>();
        try(Connection conn = App.getConexao()) {
            String sql = "SELECT * FROM produto WHERE nome = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,nome);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setQtde(rs.getInt("qtde"));
                p.setValor(rs.getDouble("valor"));
                produtos.add(p);
            }
        } catch(SQLException ex) {
            System.err.println("NÃO FOI POSSÍVEL LISTAR OS PRODUTOS PELO NOME!");
            ex.printStackTrace();
        }
        return produtos;
    }

}
