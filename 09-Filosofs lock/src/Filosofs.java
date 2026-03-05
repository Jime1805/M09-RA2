import java.util.Random;

public class Filosofs extends Thread{
    
    private long iniciGana;
    private long fiGana;
    private long gana;

    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;

    private Random rand;

    public Filosofs(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta){
        super(nom);
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.rand = new Random();
    }

    public void agafarForquilles(){
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    public void agafarForquillaEsquerra(){
        forquillaEsquerra.agafar();
    }

    public void agafarForquillaDreta(){
        forquillaDreta.agafar();
    }

    public void deixarForquilles(){
        deixarForquillaDreta();
        deixarForquillaEsquerra();
        System.out.println(getName() + " deixa les forquilles");
    }

    public void deixarForquillaEsquerra(){
        forquillaEsquerra.deixar();
    }

    public void deixarForquillaDreta(){
        forquillaDreta.deixar();
    }

    public void pensar(){
        try {
            iniciGana = System.currentTimeMillis();
            System.out.println(getName() + " esta pensant");
            Thread.sleep(rand.nextInt(1000) + 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calcularGana(){
        fiGana = System.currentTimeMillis();
        gana = (fiGana - iniciGana)/1000;
    }

    public void resetGana(){
        iniciGana = System.currentTimeMillis();
        fiGana = 0;
    }

    public void menjar(){
        try {
            agafarForquilles();

            System.out.println(getName() + " te forquilles esq ("
                            + forquillaEsquerra.getNum() + ") dreta (" 
                            + forquillaDreta.getNum() + ")" );

            calcularGana();

            System.out.println(getName() + " menja amb gana " + gana);

            Thread.sleep(rand.nextInt(1000) + 1000);

            System.out.println(getName() + " ha acabat de menjar");

            resetGana();

            deixarForquilles();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while (true) {
            pensar();
            menjar();
        }
    }
}
