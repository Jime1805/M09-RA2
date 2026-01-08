public class Coet{
    private Motor[] motors = new Motor[4];

    public Coet(){
        for(int i = 0; i < motors.length; i++){
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p){
        if (p < 0 || p > 10) {
            System.out.println("Error: Potència fora de rang");
            return;
        }
        System.out.println("Passant a potència " + p);

        for(Motor motor: motors){
            motor.sePotenciaObjectiu(p);
            motor.setArrencat(true);
        }
    }

    public void arranca(){
        for(Motor motor: motors){
            motor.start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        int p = -1;

        while (p!=0){
            String entrada = System.console().readLine();
            p = Integer.parseInt(entrada);
            coet.passaAPotencia(p);
        }
    }
}
