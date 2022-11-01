/**
 * Esta clase contiene los metodos y atributos de cajero
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class cajero implements Runnable{

    cuentaCorriente cuenta;
    int tipoOperacion;

    /**
     * Metodo constructor parametrizado
     * @param cuenta objeto tipo cuentaCorriente
     * @param opcion entero para elegir deposito o reintegro
     */
    public cajero(cuentaCorriente cuenta, int opcion) {this.cuenta = cuenta; this.tipoOperacion = opcion;}

    /**
     * Metodo de la hebra que realiza 10000 llamadas a deposito o reintegro
     */
    public void run() {
        switch (tipoOperacion) {
            case 0 : for (int i = 0; i < 10000; i++) cuenta.deposito(1); break;
            case 1 : for (int i = 0; i < 10000; i++) cuenta.reintegro(1); break;
        }
    }

}
