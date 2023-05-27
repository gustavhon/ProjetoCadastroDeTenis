package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;
import utils.Conexao;

public class UsuarioDAO {
    
    private Connection conexao;
    
    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        System.out.println("Iniciando a conexão...");
        this.conexao = Conexao.abrirConexao();
        System.out.println("Conexão estabelecida.");
    }
    
    public Usuario logarUsuario(String nomeUsuario, String senhaUsuario, String perfilUsuario) throws SQLException {
        String sql = "select * from usuario where nomeUsuario = ? and senhaUsuario = ? and perfilUsuario = ? and statusUsuario = true";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            System.out.println("Preparando a consulta SQL...");
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeUsuario);
            stmt.setString(2, senhaUsuario);
            stmt.setString(3, perfilUsuario);
            System.out.println("Executando a consulta SQL...");
            rs = stmt.executeQuery();
            System.out.println("Processando os resultados...");
            while(rs.next()) {
                System.out.println("Usuário encontrado...");
                usuario = new Usuario(
                        rs.getInt("codigoUsuario"),
                        rs.getString("nomeUsuario"),
                        rs.getString("senhaUsuario"),
                        rs.getString("perfilUsuario"),
                        rs.getBoolean("statusUsuario")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar usuário: " + ex.getMessage());
            throw new SQLException("Erro ao buscar usuário", ex);
        } finally {
            System.out.println("Encerrando a conexão...");
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return usuario;
    }
}
