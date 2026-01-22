public class Associacio {
    public final int numSocis = 1000;
    private Soci[] socis;

    public Associacio(){
        socis = new Soci[numSocis];
    }

    public void iniciaCompteTempsSocis(){
        for (int i = 0; i < numSocis; i++){
            socis[i] = new Soci();
            socis[i].start();
        }
    }

    public void esperaPeriodeSocis(){
        for(int i = 0; i < numSocis; i++){
            try {
                socis[i].join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes(){
        System.out.println("Saldo final de compte: " + Compte.getInstancia().getSaldo());
    }

    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }

}