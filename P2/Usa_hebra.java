/**
 * Esta clase lanza dos hilos que incrementarán y decrementarán una variable compartida
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class Usa_hebra {
    public static void main (String[] args) throws InterruptedException {
        hebra hebra1 = new hebra(1000000, 0);
        hebra hebra2 = new hebra(1000000, 1);

        hebra1.start();
        hebra2.start();
        hebra1.join();
        hebra2.join();

        System.out.println ( hebra.nDato() ) ;
    }
}
