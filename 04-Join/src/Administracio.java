public class Administracio {
    private static final int numPoblacioActiva = 50;
    private Treballador[] poblacioActiva;

    public Administracio(){
        poblacioActiva = new Treballador[numPoblacioActiva];
        for (int persona = 0; persona < 50; persona++){
            poblacioActiva[persona] = new Treballador(
                "Ciutadà " + persona, 25000.00f, 20, 65 
            );
        }
    }

    public void executar(){
        for(Treballador t: poblacioActiva){
            t.start();
        }

        for(Treballador t: poblacioActiva){
            try {
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (Treballador t: poblacioActiva){
            System.out.println(
                t.getName() + " -> edat: " + t.getEdatActual() + " / total: " + t.getCobrat()
            );
        }
    }

    public static void main(String[] args) {
        Administracio admin = new Administracio();
        admin.executar();
    }
}
