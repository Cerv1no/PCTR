/**
 * Esta clase contiene los metodos y atributos de cuentaCorriente
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class cuentaCorriente {
    int numCuenta;
    double saldo;

    /**
     * Método constructor parametrizado
     * @param numCuenta identificador de la cuenta
     * @param saldo dinero que contiene la cuenta
     */
    public cuentaCorriente(int numCuenta, double saldo) {this.numCuenta = numCuenta; this.saldo = saldo;}

    /**
     * Método que devuelve el dinero que contiene la cuenta
     * @return devuelve el dinero que contiene la cuenta
     */
    public double saldo() {return saldo;}

    /**
     * Método para ingresar dinero en la cuenta
     * @param dinero dinero que contiene la cuenta
     */
    public void deposito (double dinero) {saldo += dinero;}

    /**
     * Método para retirar dinero en la cuenta
     * @param dinero dinero que contiene la cuenta
     */
    public void reintegro (double dinero) {saldo -= dinero;}
}
