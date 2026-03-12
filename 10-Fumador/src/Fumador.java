import java.util.Random;

public class Fumador extends Thread{
    private Estanc estanc;
    private int id;

    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;

    private int fumades = 0;
    
    private Random random;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
        random = new Random();
    }

    public void fuma(){
        if (tabac != null && paper != null && llumi != null) {
            System.out.println("Fumador " + id + " fumant");
            try {
                Thread.sleep(random.nextInt(500)+500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            tabac = null;
            paper = null;
            llumi = null;

            fumades++;

            System.out.println("Fumador " + id + " ha fumat " + fumades + " vegades");
        }
    }

    public void compraTabac() throws InterruptedException{
        System.out.println("FUmador " + id + " comprant tabac");
        tabac = estanc.venTabac();
    }

    public void compraPaper() throws InterruptedException{
        System.out.println("FUmador " + id + " comprant paper");
        paper = estanc.venPaper();
    }

    public void compraLlumi() throws InterruptedException{
        System.out.println("FUmador " + id + " comprant llumí");
        llumi = estanc.venLlumi();
    }

    @Override
    public void run(){
        try {
            while (fumades < 3) {
                compraTabac();
                compraPaper();
                compraLlumi();

                fuma();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
