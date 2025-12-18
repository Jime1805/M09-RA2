public class MainDemoFil {
    public static void main(String[] args) {
        Thread filActual = Thread.currentThread();
        System.out.println("MainDemoFil.main:");
        System.out.println("Prioritat -> " + filActual.getPriority() + ", " + filActual.getName());
        System.out.println("toString() -> " + filActual.toString());
    }
}
