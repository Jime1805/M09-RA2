import java.util.Random;

public class Filosof extends Thread {

    private Forquilla esquerra;
    private Forquilla dreta;
    private int gana;
    private Random random;

    public Filosof(String nom){
        super(nom);
        gana = 0;
        random = new Random();
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

    private void pensar() throws InterruptedException{
        System.out.println("Filòsof: " + getName() + " pensant");
        pausaRandom(1000, 2000);
    }

    private void menjar(){
        System.out.println("Filòsof: " + getName() + " menja");
        pausaRandom(1000, 2000);
        System.out.println("Filòsof: " + getName()+ " ha acabat de menjar");
        gana = 0;
    }

    private void pausaRandom(int min, int max){
        try {
            Thread.sleep(random.nextInt(max - min +1) + min);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while (true) {
            try {
                pensar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean haMenjat = false;

            while (!haMenjat) {
                if (esquerra.agafar()) {
                    System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra " + esquerra.getNumero());
                    
                    if (dreta.agafar()) {
                        System.out.println("Filòsof: " + getName() +  " agafa la forquilla dreta " + dreta.getNumero());
                        menjar();
                        dreta.deixar();
                        esquerra.deixar();
                        haMenjat = true;
                    }
                    else{
                        System.out.println("Filòsof: " + getName() + " deixa l'esquerra (" + esquerra.getNumero() + ") i espera (dreta ocupada)");
                        esquerra.deixar();
                        gana++;
                        System.out.println("Filòsof: " + getName() + " gana=" + gana);
                        pausaRandom(500, 1000);
                    }

                }
                else{
                    pausaRandom(500, 1000);
                }
            }
        }
    }
}
