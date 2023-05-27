
package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOGenerica {
    
    
    public void gravar(Object objeto) throws SQLException;
    public void inserir(Object objeto) throws SQLException;
    public void alterar(Object objeto) throws SQLException;
    public Object consultar(int codigo) throws SQLException;
    public List<Object> listar() throws SQLException;
    public void excluir(int codigo) throws SQLException;
    //declarar métodos.
}
