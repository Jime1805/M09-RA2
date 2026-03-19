import java.util.Random;

public class Barber extends Thread{
    private String nom;
    private Random random;

    public Barber(String nom){
        this.nom = nom;
        random = new Random();
    }

    @Override
    public void run(){
        while (true) {
            Client c = Barberia.instancia.seguentClient();

            if (c != null) {
                System.out.println("Li toca al client " + c.getNom());
                c.tallarseElCabell();

                try {
                    Thread.sleep(900 + random.nextInt(100));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                synchronized(Barberia.instancia.condBarber){
                    try {
                        System.out.println("Ningú en espera");
                        System.out.println("Barber " + nom + " dormint");
                        Barberia.instancia.condBarber.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
