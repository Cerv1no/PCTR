/**
 * Esta clase contiene los metodos y atributos de hebra
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class hebra extends Thread{
    private int tipoHebra;
    private static int n = 0;
    private int nVueltas;

    /**
     * Método constructor parametrizado
     * @param nVueltas iteraciones que realizara cada hebra
     * @param tipoHebra entero que indica la operacion a realizar por parte de la hebra
     */
    public hebra (int nVueltas, int tipoHebra){this.nVueltas = nVueltas; this.tipoHebra = tipoHebra;}

    /**
     * Metodo de la hebra que realiza nVueltas de incrementos o decrementos a la variable n
     */
    public void run () {
        switch (tipoHebra) {
            case 0 : for (int i = 0; i <nVueltas; i++) n++; break;
            case 1 : for (int i = 0; i <nVueltas; i++) n--; break;
        }
    }

    /**
     * Método para devolver la variable n
     * @return devuelve la variable n
     */
    public static int nDato (){return n;}
}
