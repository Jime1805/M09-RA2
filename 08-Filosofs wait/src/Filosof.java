import java.util.Random;

public class Filosof extends Thread{

    private Forquilla esquerra;
    private Forquilla dreta;
    private int gana;
    private Random rand;

    public Filosof(String nom){
        super(nom);
        gana = 0;
        rand = new Random();
    }

    public void setForquilles(Forquilla esquerra, Forquilla dreta){
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    public Forquilla getEsquerra() {
        return esquerra;
    }

    public Forquilla getDreta() {
        return dreta;
    }

    private void pausaRandom(int min, int max){
        try {
            Thread.sleep(rand.nextInt(max - min + 1) + min);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pensar(){
        System.out.println("Filòsof: " + getName() + " pensant");
        pausaRandom(1000, 2000);
    }

    private void menjar(){
        System.out.println("Filòsof: " + getName() + " pensant");
        pausaRandom(1000, 2000);
        System.out.println("Filòsof: " + getName() + " ha acabat de menjar");
        gana = 0;
    }

    private int getNumFil(){
        return Integer.parseInt(getName().split(" ")[1]);
    }

    private synchronized void agafarForquilles(){
        while (esquerra.getPropietari() != Forquilla.LLIURE || dreta.getPropietari() != Forquilla.LLIURE) {
            
            try {
                System.out.println("Filòsof: " + getName() + " espera forquilles");
                gana++;
                System.out.println("Filòsof " + getName() + " gana=" + gana);
                wait(500 + rand.nextInt(500));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        esquerra.setPropietari(getNumFil());
        System.out.println("Filòsof " + getName() + " agafa esquerra " + esquerra.getNumero());

        dreta.setPropietari(getNumFil());
        System.out.println("Filòsof " + getName() + " agafa dreta " + dreta.getNumero());
    }

    public synchronized void deixarForquilles(){
        if (esquerra.getPropietari() == getNumFil()) {
            esquerra.setPropietari(Forquilla.LLIURE);
        }

        if (dreta.getPropietari() == getNumFil()) {
            esquerra.setPropietari(Forquilla.LLIURE);
        }

        System.out.println("Filòsof " + getName() + " deixa forquilles");
        notifyAll();
    }

    @Override
    public void run(){
        while (true) {
            pensar();
            agafarForquilles();
            menjar();
            deixarForquilles();
        }
    }

}
