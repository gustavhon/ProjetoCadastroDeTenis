package dao;

import dao.DAOGenerica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Marca;
import utils.Conexao;

public class MarcaDAO implements DAOGenerica{
    
    private Connection conexao;
    public MarcaDAO() throws SQLException, ClassNotFoundException{
        this.conexao = new Conexao().abrirConexao(); 
   }

    @Override
    public void gravar(Object objeto) throws SQLException {
        
        Marca marca = (Marca) objeto;
        
        if(marca.getCodigoMarca() == 0){
            this.inserir(marca);
        }else{
            this.alterar(marca);
        }
    }

    @Override
    public void inserir(Object objeto) throws SQLException {
        Marca marca = (Marca) objeto;
        String sql = "insert into marca values (default, ?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, marca.getNomeMarca());
            stmt.execute();
        }
        catch (SQLException ex) {
            throw new SQLException("Erro ao inserir marca!");
        }
        finally{
            new Conexao().encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public void alterar(Object objeto) throws SQLException {
        Marca marca = (Marca) objeto;
        String sql = "update marca set nomemarca = ?" + " where codigomarca = ?";
        
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, marca.getNomeMarca());
            stmt.setInt(2, marca.getCodigoMarca());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao alterar marca!");
        }finally{
            new Conexao().encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
       
        String sql = "select * from marca where codigomarca = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Marca marca = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while(rs.next()){
                marca = new Marca(
                        rs.getInt("codigomarca"),
                        rs.getString("nomemarca"));
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao consultar marca!");
        }finally{
            new Conexao().encerrarConexao(conexao, stmt, rs);
        }
        
        return marca;
        
    }

    @Override
    public List<Object> listar() throws SQLException {
        
        
        String sql = "select * from marca";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Marca marca = new Marca(
                        rs.getInt("codigomarca"),
                        rs.getString("nomemarca"));
                lista.add(marca);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar marca!");
        }finally{
            new Conexao().encerrarConexao(conexao, stmt, rs);
        }
        
        return lista;
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        
        String sql = "delete from marca" + " where codigomarca = ?";
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        }catch (SQLException ex) {
            throw new SQLException("Erro ao excluir marca!");
        }finally{
            new Conexao().encerrarConexao(conexao, stmt);
        }
    }
    
   
}
