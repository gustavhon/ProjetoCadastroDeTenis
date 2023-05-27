package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    public static Connection abrirConexao() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Conectando ao banco de dados...");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aplicacao_tenis",
                    "postgres", "123");
            System.out.println("Conexao estabelecida com sucesso!");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar com o banco de dados: " + ex.getMessage());
            throw new SQLException("Erro de conexao com o banco de dados", ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados nao encontrado: " + ex.getMessage());
            throw new ClassNotFoundException("Driver do banco de dados nao encontrado", ex);
        }
    }

    private static void encerrar(Connection conexao, PreparedStatement stmt, ResultSet rs) throws SQLException {
        try {
            if (conexao != null) {
                System.out.println("Fechando a conexao...");
                conexao.close();
                System.out.println("Conexao fechada com sucesso!");
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao encerrar a conexão: " + ex.getMessage());
            throw new SQLException("Erro ao encerrar conexão com o banco de dados", ex);
        }
    }

    public static void encerrarConexao(Connection conexao, PreparedStatement stmt) throws SQLException {
        encerrar(conexao, stmt, null);
    }

    public static void encerrarConexao(Connection conexao, PreparedStatement stmt, ResultSet rs)
        throws SQLException {
        encerrar(conexao, stmt, rs);
    }
}
