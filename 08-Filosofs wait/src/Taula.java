public class Taula {
    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs){

        forquilles = new Forquilla[numFilosofs];
        for(int i = 0; i < numFilosofs; i++){
            forquilles[i] = new Forquilla(i, Forquilla.LLIURE);
        }

        filosofs = new Filosof[numFilosofs];
        for(int i = 0; i < numFilosofs; i++){
            filosofs[i] = new Filosof("fill " + i);

            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs];

            filosofs[i].setForquilles(esquerra, dreta);
        }
    }

    public void cridarATaula(){
        for(Filosof f: filosofs){
            f.start();
        }
    }

    public void showTaula(){
        for(Filosof f: filosofs){
            System.out.println("Comensal: " + f.getName() + 
                                " esq: " + f.getEsquerra().getNumero() +
                                " dret: " + f.getDreta().getNumero() +
                                " propietari esq: " + f.getEsquerra().getPropietari() +
                                " propietari dret: " + f.getDreta().getPropietari()   
                            );
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        System.out.println("----------------------");
        taula.cridarATaula();
    }
}
