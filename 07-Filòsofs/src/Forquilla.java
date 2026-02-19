public class Forquilla{

    private int numero;
    private boolean enUs;

    public Forquilla(int numero) {
        this.numero = numero;
        this.enUs = false;
    }

    public synchronized void agafar() throws InterruptedException{
        while (enUs) {
            wait();
        }
        enUs = true;
    }

    public synchronized void deixar(){
        enUs = false;
        notify();
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEnUs() {
        return enUs;
    }

}