import java.util.Random;

public class DormAleatori extends Thread{
    private long instantCreacio;
    private Random random;

    public DormAleatori(String nom){
        super(nom);
        this.instantCreacio = System.currentTimeMillis();
        this.random = new Random();
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++){
            int interval = random.nextInt(1000);
            long tempsFinal = System.currentTimeMillis() - instantCreacio;

            System.out.println(getName() + " ( " + i +" ) a dormir  " + interval + "ms total  " + tempsFinal + "ms");
            
            try {
                Thread.sleep(interval);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("Fi del main");
    }
}