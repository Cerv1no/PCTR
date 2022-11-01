/**
 * Esta clase contiene los metodos y atributos de tareaRunnable
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class tareaRunnable implements Runnable{
    private critica c;
    private int tipoTarea;

    /**
     * Método constructor parametrizado
     * @param c objeto de tipo critica
     * @param tipoTarea entero para elegir decremento o incremento
     */
    public tareaRunnable(critica c, int tipoTarea) {this.c = c; this.tipoTarea = tipoTarea;}

    /**
     * Metodo de la hebra que realiza 10000 de llamadas a incrementos o decrementos
     */
    public void run () {
        switch (tipoTarea) {
            case 0 : for (int i = 0; i < 1000000; i++) c.inc(); break;
            case 1 : for (int i = 0; i < 1000000; i++) c.dec(); break;
        }
    }
}
