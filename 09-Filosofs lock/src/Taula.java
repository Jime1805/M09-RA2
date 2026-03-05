public class Taula {
    public Filosofs[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs){
        filosofs = new Filosofs[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for(int i = 0; i < numFilosofs; i++){
            forquilles[i] = new Forquilla(i);
        }

        for(int j = 0; j < numFilosofs; j++){
            Forquilla esquerra = forquilles[j];
            Forquilla dreta = forquilles[(1 + j)%numFilosofs];

            filosofs[j] = new Filosofs("Fil " + j, esquerra, dreta);
        }
    }

    public void showTaula(){
        for(int i = 0; i < filosofs.length; i++){
            int esquerre = i;
            int dreta = (i + 1)%filosofs.length;

            System.out.println("Comensal: Fil" + i
                            + "esq: " + esquerre
                            + "dreta: " + dreta);
        }
    }

    public void cridarATaula(){
        for(Filosofs f: filosofs){
            f.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}
