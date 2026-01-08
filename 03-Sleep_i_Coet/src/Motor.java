import java.util.Random;

public class Motor extends Thread{
    private int motor; // El motor amb el que estem tractant
    private int potenciaActual = 0;
    private int potenciaObjectiu;
    private boolean arrencat = false; // Determina si esta arrencat o no (per no confondre amb l'estat inicial quan la potencia es 0)
    private Random segon = new Random(); // Per crear l'interval entre 1s - 2s
    
    public Motor(int motor){
        this.motor = motor;
    }

    public void sePotenciaObjectiu(int potenciaObjectiu){
        this.potenciaObjectiu = potenciaObjectiu;
    }

    public void setArrencat(boolean arrencat){
        this.arrencat = arrencat;
    }

    @Override
    public void run(){
        while (true) {
            if(potenciaActual < potenciaObjectiu){ // cas en el que incrementa el motor.
                potenciaActual++;
                System.out.println("Motor " + motor + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
            }
            else if(potenciaActual > potenciaObjectiu){ // cas en el que decrementa el motor.
                potenciaActual--;
                System.out.println("Motor " + motor + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
            }
            else{   // cas en el que arriba el motor a l'objectiu, si és 0 s'apaga.
                System.out.println("Motor " + motor + ": FerRes. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                if (potenciaObjectiu == 0 && arrencat == true) {
                    break;
                }
            }
            try {
                Thread.sleep(1000 + segon.nextInt(1000));   // Implementar aleatoriament 1s - 2s
            } catch (Exception e) {
                e.printStackTrace();
            }  
        }
    }
}
