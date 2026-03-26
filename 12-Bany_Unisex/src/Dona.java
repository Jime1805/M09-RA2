import java.util.Random;

public class Dona extends Thread{
    private BanyUnisex bany;
    private Random random;

    public Dona(String nom, BanyUnisex bany){
        super(nom);
        this.bany = bany;
        random = new Random();
    }

    @Override
    public void run(){
        System.out.println(getName() + " vol entrar al bany");

        bany.entraDona();

        try {
            Thread.sleep(random.nextInt(2000) + 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bany.surtDona();

        System.out.println(getName() + " ha acabat d'usar el bany");
    }
}
