public class Compte{
    private static Compte instancia;
    private float saldo;

    private Compte(){
        saldo = 0;
    }

    public static synchronized Compte getInstancia(){
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}