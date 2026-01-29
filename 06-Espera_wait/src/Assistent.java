import java.util.Random;

public class Assistent extends Thread{
    private final Esdeveniment esdeveniment;
    private final Random random;

    public Assistent(String nom, Esdeveniment esdeveniment){
        super(nom);
        this.esdeveniment = esdeveniment;
        random = new Random();
    }

    @Override
    public void run(){
        while (true) {
            if (random.nextInt(100) < 30) {
                esdeveniment.ferReserva(this);
            }
            else{
                esdeveniment.cancelaReserva(this);
            }

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (Exception e) {
                break;
            }
        }
    }    
}
