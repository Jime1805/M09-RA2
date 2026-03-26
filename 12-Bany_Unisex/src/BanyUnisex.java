import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {
    public static final int BANY_BUIT = 0;
    public static final int BANY_AMB_HOMES = 1;
    public static final int BANY_AMB_DONES = 2;

    public static final int CAPACITAT_MAX = 3;

    private int estatActual;
    private int ocupants;

    private Semaphore capacitat = new Semaphore(CAPACITAT_MAX, true);

    private ReentrantLock lockEstat = new ReentrantLock(true);

    public BanyUnisex(){
        estatActual = BANY_BUIT;
        ocupants = 0;
    }

    public void entraHome(){
        boolean entrat = false;
        while (!entrat) {
            lockEstat.lock();

            try {

                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_HOMES) {
                    if (capacitat.tryAcquire()) {
                        ocupants ++;
                        estatActual = BANY_AMB_HOMES;

                        System.out.println("Home entra al bany. Ocupants: " + ocupants);

                        entrat = true;
                    }
                }
            } finally {
                lockEstat.unlock();
            }

            if (!entrat) {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void surtHome(){
        lockEstat.lock();

        try {
            ocupants --;
            capacitat.release();

            System.out.println("Home surt del bany. Ocupants " + ocupants);

            if (ocupants == 0) {
                estatActual = BANY_BUIT;
                System.out.println("El bany està buit");
            }
        } finally{
            lockEstat.unlock();
        }

    }

    public void entraDona(){
        boolean entrat = false;
        while (!entrat) {
            lockEstat.lock();

            try {

                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_DONES) {
                    if (capacitat.tryAcquire()) {
                        ocupants ++;
                        estatActual = BANY_AMB_DONES;

                        System.out.println("Dona entra al bany. Ocupants: " + ocupants);

                        entrat = true;
                    }
                }
            } finally {
                lockEstat.unlock();
            }

            if (!entrat) {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void surtDona(){
        lockEstat.lock();

        try {
            ocupants --;
            capacitat.release();

            System.out.println("Dona surt del bany. Ocupants " + ocupants);

            if (ocupants == 0) {
                estatActual = BANY_BUIT;
                System.out.println("El bany està buit");
            }
        } finally{
            lockEstat.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BanyUnisex bany = new BanyUnisex();
        Home[] homes = new Home[5];
        Dona[] dones = new Dona[5];

        for(int i = 0; i < 5; i++){
            homes[i] = new Home("Home-" + i, bany);
        }

        for(int i = 0; i < 5; i++){
            dones[i] = new Dona("Dona-" + i, bany);
        }

        for(Home h: homes){
            h.start();
        }

        for(Dona h: dones){
            h.start();
        }
    }
}
