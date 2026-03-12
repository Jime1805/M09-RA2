import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread{
    private List<Tabac> tabacs;
    private List<Paper> papers;
    private List<Llumi> llumins;

    private boolean obert = true; 
    private Random random;

    public Estanc(){
        tabacs = new LinkedList<>();
        papers = new LinkedList<>();
        llumins = new LinkedList<>();

        random = new Random();
    }

    public synchronized void addTabac() {
        tabacs.add(new Tabac());
        System.out.println("Afegint tabac");
        notifyAll();
    }

    public synchronized void addPaper(){
        papers.add(new Paper());
        System.out.println("Afegint paper");
        notifyAll();
    }

    public synchronized void addLlumi(){
        llumins.add(new Llumi());
        System.out.println("Afegint llumí");
        notifyAll();
    }

    public synchronized Tabac venTabac() throws InterruptedException{
        while (tabacs.isEmpty()) {
            wait();
        }
        return tabacs.remove(0);
    }

    public synchronized Paper venPaper() throws InterruptedException{
        while (papers.isEmpty()) {
            wait();
        }
        return papers.remove(0);
    }

    public synchronized Llumi venLlumi() throws InterruptedException{
        while (llumins.isEmpty()) {
            wait();
        }
        return llumins.remove(0);
    }

    public void nouSubministrament(){
        int rand = random.nextInt(3);
        if (rand == 0) {
            addTabac();
        }
        else if (rand == 1) {
            addPaper();
        }
        else{
            addLlumi();
        }
    }

    public void tancarEstanc(){
        obert = false;
    }

    @Override
    public void run(){
        System.out.println("Estanc obert");

        while (obert) {
            nouSubministrament();
            
            try {
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Estanc tancat");
    }
}
