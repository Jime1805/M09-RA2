import java.util.Random;

public class Home extends Thread{
    private BanyUnisex bany;
    private Random random;

    public Home(String nom, BanyUnisex bany){
        super(nom);
        this.bany = bany;
        random = new Random();
    }

    @Override
    public void run(){
        System.out.println(getName() + " vol entrar al bany");

        bany.entraHome();

        try {
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bany.surtHome();

        System.out.println(getName() + " ha acabat d'usar el bany");
    }
}