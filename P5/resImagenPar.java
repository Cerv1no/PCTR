import java.util.Random;
import java.util.concurrent.*;
/**
 * Esta clase realiza el resaltado de imagen de una matriz de forma paralela
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class resImagenPar implements Runnable{
    static int n = 30000;
    int linf, lsup;
    static int [][] matriz = new int[n][n];
    static int [][] outMatriz = new int[n][n];

    /**
     * Método constructor parametrizado
     * @param linf índice de inicio
     * @param lsup índice de final
     */
    public resImagenPar(int linf, int lsup) {this.linf = linf; this.lsup = lsup;}

    /**
     * Método de la hebra que realiza el resaltado de la matriz del rango asignado
     */
    public void run () {
        for (int i = linf; i < lsup; i++) {
            for (int j = 1; j < n - 1; j++){
                //ecuacion resaltado
                outMatriz[i][j] = (4 * matriz[i][j] - matriz[i + 1][j] - matriz[i][j + 1] - matriz[i - 1][j] - matriz[i][j - 1]) / 8;
            }
        }
    }

    public static void main (String[] args) throws InterruptedException {
        Random generador = new Random();
        int nHilos = 16;
        int tamHilos = n / nHilos;
        int linf = 1;
        int lsup = tamHilos;

        //Rellenamos la matriz con numeros aleatorios de 0 al 255
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                matriz[i][j] = generador.nextInt(256);
            }
        }

        long tiempoIni = System.nanoTime();
        //Creamos el pool de hilos con capacidad de nHilos
        ExecutorService pool = Executors.newFixedThreadPool(nHilos);
        for (int i = 0; i < nHilos; i++){
            if (i == nHilos - 1) {
                //La ultima fila no se modifica para no salirnos del rango de la matriz
                //Ejecutamos la tarea con rango dado
                pool.execute(new resImagenPar(linf, n - 1));
            }
            else{
                pool.execute(new resImagenPar(linf, lsup));
                linf = lsup + 1;
                lsup += tamHilos;
            }
        }

        pool.shutdown();
        while(!pool.isTerminated());
        long tiempoFin = (System.nanoTime() - tiempoIni) / (long) Math.pow(10, 6);

        System.out.println(tiempoFin + " milisegundos");
    }
}
