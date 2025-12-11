public class Fil extends Thread{

    private int iteracions;
    private boolean ferFeina;
    private int delay;

    public Fil(String nom, int iteracions, boolean ferFeina, int delay, int priority) {
        super(nom);
        this.iteracions = iteracions;
        this.ferFeina = ferFeina;
        this.delay = delay;
        this.setPriority(priority);
    }

    @Override
    public void run(){
        for (int i = 0; i <= iteracions; i++){
            if (ferFeina) {
                for(int j = 0; j < 1000; j++){ // bucle per fer temps
                    
                }
            }

            System.out.println(getName() + " " + i);
            
            if(delay>0){
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                }
            }
        }

        System.out.println("Acaba el fil " + getName());
    }
}
