import java.util.Random;

public class matVectorConcurrente implements Runnable{
    static int n = 30000;
    int inicio, fin;
    static int [][] matriz = new int[n][n];
    static int [] vectorOut = new int[n];
    static int [] vectorIn = new int[n];

    public matVectorConcurrente(int inicio, int fin) {this.inicio = inicio; this.fin = fin;}

    public void run () {
        for (int i = inicio; i < fin; i++) {
            int aux = 0;
            for (int j = 0; j < n; j++){
                aux  += matriz[i][j] * vectorIn[j];
            }
            vectorOut[i] = aux;
        }
    }

    public static void main (String[] args) throws InterruptedException {
        Random generador = new Random();
        int numHebras = 8;
        Thread[] hebras = new Thread[numHebras];
        int nuevoInicioHebra = 0;
        int tamHebras = n / numHebras;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                matriz[i][j] = generador.nextInt(100);
            }
            vectorIn[i] = generador.nextInt(100);
        }
        for (int i = 0; i < numHebras; i++) {
            if (i == numHebras - 1){
                hebras[i] = new Thread(new matVectorConcurrente(nuevoInicioHebra, n - 1));
            }
            else {
                hebras[i] = new Thread(new matVectorConcurrente(nuevoInicioHebra, nuevoInicioHebra + tamHebras - 1));
                nuevoInicioHebra += tamHebras;
            }
        }

        long tiempoIni = System.nanoTime();
        for (int i = 0; i < numHebras; i++) {
            hebras[i].start();
        }
        for (int i = 0; i < numHebras; i++) {
            hebras[i].join();
        }
        long tiempoFin = (System.nanoTime() - tiempoIni) / (long) Math.pow(10, 6);

        System.out.println(tiempoFin + " milisegundos");
    }
}
