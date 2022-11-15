import java.util.Random;
/**
 * Esta clase implementa el algoritmo de resaltado de imagen de forma secuencial
 * @author Álvaro Álvarez Cerviño
 * @version 15/11/22
 */
public class resImagen {
    public static void main (String[] args) {

        int n = 30000;
        int[][] matriz = new int[n][n];
        int [][] outMatriz = new int[n][n];

        Random generador = new Random();
        //Rellenamos la matriz con numeros aleatorios de 0 al 255
        for (int i = 0; i < n; i++) {
            for (int j = 0; i < n; i ++) {
                matriz[i][j] = generador.nextInt(256);
            }
        }
        long tiempoIni = System.nanoTime();
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++){
                //ecuacion resaltado
                outMatriz[i][j] = (4 * matriz[i][j] - matriz[i + 1][j] - matriz[i][j + 1] - matriz[i - 1][j] - matriz[i][j - 1]) / 8;
            }
        }
        long tiempoFin = (System.nanoTime() - tiempoIni) / (long) Math.pow(10, 6);
        System.out.println(tiempoFin + " milisegundos");
    }
}
