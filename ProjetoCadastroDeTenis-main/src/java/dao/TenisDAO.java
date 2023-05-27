package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tenis;
import model.Marca;
import utils.Conexao;

public class TenisDAO implements DAOGenerica{
    
    private Connection conexao;
    public TenisDAO() throws SQLException, ClassNotFoundException{
        this.conexao = new Conexao().abrirConexao(); 
   }

    @Override
    public void gravar(Object objeto) throws SQLException {
        
        Tenis tenis = (Tenis) objeto;
        
        if(tenis.getCodigoTenis() == 0){
            this.inserir(tenis);
        }else{
            this.alterar(tenis);
        }
    }

    @Override
    public void inserir(Object objeto) throws SQLException {
        Tenis tenis = (Tenis) objeto;
        String sql = "insert into tenis values (default, ?, ?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tenis.getNomeTenis());
            stmt.setInt(2, tenis.getMarca().getCodigoMarca());
            stmt.execute();
        }
        catch (SQLException ex) {
            throw new SQLException("Erro ao inserir tênis");
        }
        finally{
            new Conexao().encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public void alterar(Object objeto) throws SQLException {
        Tenis tenis = (Tenis) objeto;
        String sql = "update tenis set nometenis = ?, codigomarca = ?" + " where codigotenis = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tenis.getNomeTenis());
            stmt.setInt(2, tenis.getMarca().getCodigoMarca());
            stmt.setInt(3, tenis.getCodigoTenis());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao alterar tênis");
        }finally{
            new Conexao().encerrarConexao(conexao, stmt);
        }
    }

    @Override
    public Object consultar(int codigo) throws SQLException {
        String sql = "select * from tenis b inner join marca m "
                + "on b.codigomarca = m.codigomarca where codigotenis = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tenis tenis = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            while(rs.next()){
                tenis = new Tenis(
                        rs.getInt("codigotenis"),
                        rs.getString("nometenis"),
                        (Marca) new MarcaDAO().consultar(rs.getInt("codigomarca"))
                );
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao consultar tênis");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TenisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            new Conexao().encerrarConexao(conexao, stmt, rs);
        }
        
        return tenis;
        
    }

    @Override
    public List<Object> listar() throws SQLException {
        
        
        String sql = "select * from tenis";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Tenis tenis = new Tenis(
                        rs.getInt("codigotenis"),
                        rs.getString("nometenis"),
                        (Marca) new MarcaDAO().consultar(rs.getInt("codigomarca")));
                lista.add(tenis);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar tênis");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TenisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            new Conexao().encerrarConexao(conexao, stmt, rs);
        }
        
        return lista;
    }

    @Override
    public void excluir(int codigo) throws SQLException {
        
        String sql = "delete from tenis"
                + " where codigotenis = ?";
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
        }catch (SQLException ex) {
            throw new SQLException("Erro ao excluir tênis");
        }finally{
            new Conexao().encerrarConexao(conexao, stmt);
        }
    }
    
   
}
