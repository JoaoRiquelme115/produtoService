import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Produto p = new Produto();
        p.setId((long) 16);
        p.setNome("café");
        p.setQtde(45);
        p.setValor(8.50);

        // Testando inserir produto
        ProdutoService.inserir(p);
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
