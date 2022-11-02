import java.util.Arrays;
/**
 * Esta clase realiza el producto escalar de dos vectores de forma paralela y mide el tiempo en ms
 * @author Álvaro Álvarez Cerviño
 * @version 02/11/22
 */
public class prodEscalarParalelo extends Thread{
    int id, inicio, fin;
    static int[] vector1 = new int[(int)Math.pow(10, 6)];
    static int[] vector2 = new int[(int)Math.pow(10, 6)];
    static int[] productoParcial;

    /**
     * Método constructor parametrizado
     * @param idHebra identificador de la hebra
     * @param inicio índice de inicio
     * @param fin índice de final
     */
    public prodEscalarParalelo(int idHebra, int inicio, int fin)
    {
        this.id = idHebra;
        this.inicio = inicio;
        this.fin = fin;
    }

    /**
     * Método de la hebra que realiza el producto escalar del rango dado
     */
    public void run () {
        for (int i = inicio; i <= fin; i++) {
            productoParcial[id] += (vector1[i] * vector2[i]);
        }
    }

    public static void main (String[] args) throws InterruptedException {
        int numHebras = 2;
        productoParcial = new int[numHebras];
        prodEscalarParalelo[] hebras = new prodEscalarParalelo[numHebras];
        int tamHebras = vector2.length / numHebras;
        int nuevoInicioHebra = 0;
        int resultado = 0;

        Arrays.fill(productoParcial, 0);

        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = (int) (Math.random() * 10);
            vector2[i] = (int) (Math.random() * 10);
        }

        for (int i = 0; i < numHebras; i++) {
            if (i == numHebras - 1){
                hebras[i] = new prodEscalarParalelo(i, nuevoInicioHebra, vector1.length - 1);
            }
            else {
                hebras[i] = new prodEscalarParalelo(i, nuevoInicioHebra, nuevoInicioHebra + tamHebras - 1);
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
        for (int i = 0; i < productoParcial.length; i++) {
            resultado += productoParcial[i];
        }

        System.out.println(tiempoFin + " milisegundos");
        System.out.println("El resultado es: "+ resultado);

    }
}
