import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Produto p = new Produto();
        p.setId((long) 17);
        p.setNome("bolacha");
        p.setQtde(77);
        p.setValor(4.50);

        // Testando inserir produto
        // ProdutoService.inserir(p);

        // Testando atualizar produto
        ProdutoService.atualizar(p,(long)17);
    }

    public static Connection getConexao() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://200.128.9.179:3306/demojpa";
            String username = "remoto";
            String password = "remoto";
            conexao = DriverManager.getConnection(url,username,password);
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println("NÃO FOI POSÍVEL CRIAR UMA CONEXÃO COM O BD!");
            e.printStackTrace();
        }
        return conexao;
    }
}
