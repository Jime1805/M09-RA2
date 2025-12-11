public class PrincipalDiferents {
    public static void main(String[] args) {
        
        Fil pepe = new Fil("Pepe", 9, true, 0, Thread.MIN_PRIORITY);
        Fil juan = new Fil("Juan", 9, true, 0, Thread.MAX_PRIORITY);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}
