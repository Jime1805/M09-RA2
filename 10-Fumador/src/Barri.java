public class Barri {
    
    private Estanc estanc;
    private Fumador[] fumadors;
    
    public Barri() {
        estanc = new Estanc();
        fumadors = new Fumador[3];

        for (int i = 0; i < fumadors.length; i++){
            fumadors[i] = new Fumador(estanc, i);
        }
    }

    public void iniciar() throws InterruptedException{

        estanc.start();
        
        for(Fumador f: fumadors){
            f.start();
        }

        for(Fumador f: fumadors){
            f.join();
        }

        estanc.tancarEstanc();
    }

    public static void main(String[] args) throws InterruptedException {
        Barri barri = new Barri();
        
        barri.iniciar();
    }

}
