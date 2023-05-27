package model;
public class Tenis {
    public Tenis() {
    }
    private int codigoTenis;
    private String nomeTenis;
    private Marca marcaTenis;

    public Tenis(int codTenis, String nomeTenis, Marca marca) {
        this.codigoTenis = codTenis;
        this.nomeTenis = nomeTenis;
        this.marcaTenis = marca;
    }

    public int getCodigoTenis() {
        return codigoTenis;
    }

    public void setCodigoTenis(int codigoTenis) {
        this.codigoTenis = codigoTenis;
    }

    public String getNomeTenis() {
        return nomeTenis;
    }

    public void setNomeTenis(String nomeTenis) {
        this.nomeTenis = nomeTenis;
    }

    public Marca getMarca() {
        return marcaTenis;
    }

    public void setMarca(Marca marca) {
        this.marcaTenis = marca;
    }
}
