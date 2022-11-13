import java.util.Random;
/**
 * Esta clase realiza la multiplicación matriz vector de forma concurrente mediante la división de nube de datos
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class prodMatricesParalelo implements Runnable{
    static int n = 30000;
    int linf, lsup;
    int [][] matriz1 = new int[n][n];
    int [][] matriz2 = new int[n][n];
    int [][] outMatriz = new int[n][n];

    /**
     * Método constructor parametrizado
     * @param linf índice de inicio
     * @param lsup índice de final
     */
    public prodMatricesParalelo(int linf, int lsup) {this.linf = linf; this.lsup = lsup;}

    /**
     * Método de la hebra que realiza la múltiplicación matriz/vector del rango asignado
     */
    public void run () {
        for (int i = linf; i < lsup; i++) {
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++) {
                    outMatriz[i][j]  += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
    }

    public static void main (String[] args) throws InterruptedException {
        Random generador = new Random();
        int nHilos = Runtime.getRuntime().availableProcessors();
        int nuevoInicioHebra = 0;
        int tamHilos = n / nHilos;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                matriz1[i][j] = generador.nextInt(100);
                matriz2[i][j] = generador.nextInt(100);
                outMatriz[i][j] = 0;
            }
        }

        long tiempoIni = System.nanoTime();
        ExecutorService pool = Executors.newFixedThreadPool(nHilos);
        for (int i = 0; i < nHilos; i++){
            if (i == nHilos - 1) {
                pool.execute(new prodMatricesParalelo(linf, n));
            }
            else{
                pool.execute(new prodMatricesParalelo(linf, n));
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
