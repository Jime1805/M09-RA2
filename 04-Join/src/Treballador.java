import java.util.Random;

public class Treballador extends Thread{
    private float souAnualBrut;
    private int edatIniciTreball;
    private int edatFiTreball;
    private int edatActual;
    private float cobrat;
    private Random random;
    
    public Treballador(String nom, float souAnualBrut, int edatIniciTreball, int edatFiTreball) {
        super(nom);
        this.souAnualBrut = souAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 0;
        this.cobrat = 0.0f;
        this.random = new Random();
    }

    public float getCobrat(){
        return cobrat;
    }

    public int getEdatActual(){
        return edatActual;
    }

    public void cobra(){
        cobrat += souAnualBrut/12.0f;
    }

    public void pagaImpostos(){
        cobrat -= (souAnualBrut / 12.0f)*0.24f;
    }

    @Override
    public void run(){
        while (edatActual < edatFiTreball) {
            if(edatActual >= edatIniciTreball){
                for(int i = 0; i < 12; i++){
                    cobra();
                    pagaImpostos();

                    try {
                        Thread.sleep(random.nextInt(10));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            edatActual ++;
        }
    }
}