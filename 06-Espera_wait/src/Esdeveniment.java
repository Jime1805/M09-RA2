import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private int placesDisponibles;
    private final List<Assistent> assistents;
    
    public Esdeveniment(int placesDisponibles) {
        this.placesDisponibles = placesDisponibles;
        this.assistents = new ArrayList<>();
    }

    public synchronized void ferReserva(Assistent a){
        try {
            while (placesDisponibles == 0) {
                wait();
            }
            if (!assistents.contains(a)) {
                assistents.add(a);
                placesDisponibles--;
                System.out.println(a.getName() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void cancelaReserva(Assistent a){
        if (assistents.contains(a)) {
            assistents.remove(a);
            placesDisponibles++;
            System.out.println(a.getName() + " ha cancel·lat una reserva. Places disponibles " + placesDisponibles);
            notifyAll();
        }
        else{
            System.out.println(a.getName() + " no ha pogut cancel·lar una reserva inexistent. PLaces disponibles " + placesDisponibles);
        }
    }
}
