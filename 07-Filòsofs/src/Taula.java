public class Taula {
    
    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs){

        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++){
            forquilles[i] = new Forquilla(i);
        }

        for(int i = 0; i < numFilosofs; i++){
            filosofs[i] = new Filosof("fil " + i);

            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs];

            filosofs[i].setForquilles(esquerra, dreta);
        }
    }

    public void cridarATaula(){
        for(Filosof f : filosofs){
            f.start();
        }
    }

    public void showTaula(){
        for(Filosof f: filosofs){
            System.out.println("Comensal: " + f.getName() + " esq: " + f.getEsquerra().getNumero() + " dret: " + f.getDreta().getNumero());
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        
        taula.showTaula();
        System.out.println("---------------------------");
        taula.cridarATaula();
    }
}
