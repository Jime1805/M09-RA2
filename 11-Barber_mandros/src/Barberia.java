import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread {
    private Queue<Client> salaEspera;
    int maxCadires;
    Object condBarber;

    public static Barberia instancia;

    public Barberia(int cadires){
        this.maxCadires = cadires;
        this.salaEspera = new LinkedList<>();
        this.condBarber = new Object();
        instancia = this;
    }

    public synchronized Client seguentClient(){
        if (salaEspera.isEmpty()) {
            return null;
        }
        return salaEspera.poll();
    }

    public void entrarClient(Client c){
        synchronized(this){
            if (salaEspera.size() < maxCadires) {
                salaEspera.add(c);
                System.out.println("Client " + c.getNom() + " en espera");
                
                synchronized(condBarber){
                    condBarber.notify();
                }
            }
            else{
                System.out.println("No queden cadires, " + c.getNom() + " se'n va");
            }
        }
    }

    @Override
    public void run(){
        try {
            
            for(int i = 1; i <= 10; i++){
                entrarClient(new Client(i));
                Thread.sleep(500);
            }

            Thread.sleep(10000);

            for(int i = 11; i <= 20; i++){
                entrarClient(new Client(i));
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Barberia barberia = new Barberia(3);
        Barber barber = new Barber("Pepe");

        barber.start();
        barberia.start();
    }
}
