
package model;

public class Marca {
    private int codigoMarca;
    private String nomeMarca;

    public Marca() {
    }

    public Marca(int codigoMarca, String nomeMarca) {
        this.codigoMarca = codigoMarca;
        this.nomeMarca = nomeMarca;
    }

    public int getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(int codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
}