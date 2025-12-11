public class PrincipalEstricte {
    public static void main(String[] args) {

        Fil juan = new Fil("Juan", 9, false, 1, Thread.NORM_PRIORITY);
        Fil pepe = new Fil("Pepe", 9, false, 1, Thread.NORM_PRIORITY);

        juan.start();
        pepe.start();

        System.out.println("Acaba thread main");
    }
}
