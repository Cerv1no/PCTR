import java.util.Random;
/**
 * Esta clase realiza la multiplicación de matriz vector de forma secuencial y mide el tiempo en ms
 * @author Álvaro Álvarez Cerviño
 * @version 02/11/22
 */
public class matVector {
    public static void main (String[] args) {
        int n = 30000;
        int [][] matriz = new int[n][n];
        int [] vectorOut = new int[n];
        int [] vectorIn = new int[n];

        Random generador = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                matriz[i][j] = generador.nextInt(100);
            }
            vectorIn[i] = generador.nextInt(100);
        }

        long tiempoIni = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int aux = 0;
            for (int j = 0; j < n; j++){
               aux  += matriz[i][j] * vectorIn[j];
            }
            vectorOut[i] = aux;
        }
        long tiempoFin = (System.nanoTime() - tiempoIni) / (long) Math.pow(10, 6);
        System.out.println(tiempoFin + " milisegundos");
    }
}
