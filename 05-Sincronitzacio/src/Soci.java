import java.util.Random;

public class Soci extends Thread{
    private Compte compte;
    private float aportacio = 10f;
    private final int esperaMax = 100;
    private Random random;
    private final int maxAnys = 10;
    
    public Soci(){
        compte = Compte.getInstancia();
        random = new Random();
    }

    public Compte getCompte(){
        return compte;
    }
    
    @Override
    public void run(){
        int mesos = maxAnys * 12;
        for(int mes = 0; mes < mesos; mes++){

            synchronized(compte){
                if (mes%2==0) {
                    compte.setSaldo(compte.getSaldo() + aportacio);
                }
                else{
                    compte.setSaldo(compte.getSaldo() - aportacio);
                }
            }
        }

        try {
            Thread.sleep(random.nextInt(esperaMax));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
