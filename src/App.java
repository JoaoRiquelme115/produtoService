import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public static Connection getConexao() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/bancoteste";
            String username = "root";
            String password = "root";
            conexao = DriverManager.getConnection(url,username,password);
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println("NÃO FOI POSÍVEL CRIAR UMA CONEXÃO COM O BD!");
            e.printStackTrace();
        }
        return conexao;
    }
}
