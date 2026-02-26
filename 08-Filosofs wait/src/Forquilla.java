public class Forquilla {
    public static final int LLIURE = -1;

    private int numero;
    private int propietari;
    
    public Forquilla(int numero, int propietari) {
        this.numero = numero;
        this.propietari = propietari;
    }

    public int getNumero() {
        return numero;
    }

    public int getPropietari() {
        return propietari;
    }

    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }
}
