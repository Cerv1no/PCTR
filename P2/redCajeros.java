/**
 * Esta clase lanza 2 hebras con objeto compartido y realizan incrementos o decrementos en una de sus variables
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class redCajeros {
    public static void main (String[] args) throws InterruptedException {
        cuentaCorriente cuenta = new cuentaCorriente(1, 0);
        cajero c1 = new cajero(cuenta, 0);
        cajero c2 = new cajero(cuenta, 1);

        Thread hebra1 = new Thread(c1);
        Thread hebra2 = new Thread(c2);

        hebra1.start();
        hebra2.start();
        hebra1.join();
        hebra2.join();

        System.out.println(cuenta.saldo());
    }
}
