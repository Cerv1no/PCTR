/**
 * Esta clase lanza dos hilos que incrementarán y decrementarán una variable de un objeto compartido
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class Usa_tareaRunnable {
    public static void main (String[] args) throws InterruptedException {
        critica c = new critica();
        tareaRunnable tarea1 = new tareaRunnable(c, 0);
        tareaRunnable tarea2 = new tareaRunnable(c, 1);

        Thread hebra1 = new Thread(tarea1);
        Thread hebra2 = new Thread(tarea2);

        hebra1.start();
        hebra2.start();
        hebra1.join();
        hebra2.join();

        System.out.println ( c.vDato() ) ;
    }
}
