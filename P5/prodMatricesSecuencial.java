import java.util.Random;
/**
 * Esta clase realiza la multiplicación de matriz vector de forma secuencial y mide el tiempo en ms
 * @author Álvaro Álvarez Cerviño
 * @version 02/11/22
 */
public class prodMatricesSecuencial {
    public static void main (String[] args) {
        int n = 30000;
        int [][] matriz1 = new int[n][n];
        int [][] matriz2 = new int[n][n];
        int [][] outMatriz = new int[n][n];

        Random generador = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                matriz1[i][j] = generador.nextInt(100);
                matriz2[i][j] = generador.nextInt(100);
                outMatriz[i][j] = 0;
            }
        }

        long tiempoIni = System.nanoTime();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++) {
                    outMatriz[i][j]  += matriz1[i][k] * matriz2[k][j];
                } 
            }
        }
        long tiempoFin = (System.nanoTime() - tiempoIni) / (long) Math.pow(10, 6);
        System.out.println(tiempoFin + " milisegundos");
    }
}