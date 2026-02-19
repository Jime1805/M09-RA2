import java.util.Random;

public class Filosof extends Thread {

    private Forquilla esquerra;
    private Forquilla dreta;
    private int gana;
    private Random random;

    public Filosof(String nom){
        super(nom);
        random = new Random();
    }

    public void passarGana(){
        gana++;
        System.out.println("Filosof: fil" + getName() + "gana = " + gana);
    }

    public void setForquilles(Forquilla esquerra, Forquilla dreta){
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pausaRandom() throws InterruptedException{
        Thread.sleep(random.nextInt(1000) + 2000);
    }

    private void menjar() throws InterruptedException{
        System.out.println(getName() + " está comiendo");
        pausaRandom();
        gana = 0;
    }

    private void pensar() throws InterruptedException{
        System.out.println(getName() + " está pensando");
        pausaRandom();
    }

    @Override
    public void run(){
        try {
            while (true) {
                pensar();
                passarGana();
                synchronized(esquerra){
                    synchronized(dreta){
                        menjar();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
