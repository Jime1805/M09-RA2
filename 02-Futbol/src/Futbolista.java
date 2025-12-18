public class Futbolista extends Thread{
    private int ngols;
    private int ntirades;

    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;
    
    public Futbolista(String nom){
        super(nom);
        ngols = 0;
        ntirades = 0;
    }

    public int getNgols(){
        return ngols;
    }

    public int getNtirades(){
        return ntirades;
    }

    @Override
    public void run(){
        for (int i = 0; i < NUM_TIRADES; i++){
            ntirades++;
            if(Math.random() < PROBABILITAT){
                ngols++;
            }
        }
    }

    public static void main(String[] args) {
        String [] noms = {
            "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo",
            "Lewan", "Belli", "Arnau", "Aspas", "Messi", "Mbapé"
        };

        Futbolista[] futbolistas = new Futbolista[NUM_JUGADORS];

        System.out.println("Inici dels xuts");

        for (int i = 0; i < futbolistas.length; i++){
            futbolistas[i] = new Futbolista(noms[i]);
        }

        for (Futbolista f: futbolistas){
            f.start();
        }

        for (Futbolista f: futbolistas){
            try {
                f.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fi dels xuts");
        System.out.println("--- Estadistiques:");

        for (Futbolista f: futbolistas){
            System.out.println(f.getName() + " -> " + f.getNgols() + " gols");
        }
    }
}