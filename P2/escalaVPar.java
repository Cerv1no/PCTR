import java.util.Arrays;
/**
 * Esta clase realiza el escalado de un vector de forma paralela
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class escalaVPar extends Thread{

    static int n = 3 * (int)Math.pow(10,6);
    double escalar = 2;
    static double[] vector = new double[n];
    int inicio, fin;

    /**
     * Metodo constructor parametrizado
     * @param inicio indice de inicio
     * @param fin indice del final
     */
    public escalaVPar(int inicio, int fin) {this.inicio = inicio; this.fin = fin;}

    /**
     * Metodo de la hebra que escala el rango del vector asignado
     */
    public void run () {
        for (int i = inicio; i <= fin; i++) {
            vector[i]*= escalar;
        }
    }
    public static void main (String[] args) throws InterruptedException {

        for (int i = 0; i < vector.length; i++) {
            vector[i] = Math.random() * 10;
        }
        //System.out.println(Arrays.toString(vector));


        escalaVPar hebra1 = new escalaVPar(0, vector.length/8 - 1);
        escalaVPar hebra2 = new escalaVPar(vector.length/8, vector.length/6*2 - 1);
        escalaVPar hebra3 = new escalaVPar(vector.length/8 * 2, vector.length/6 * 3 - 1);
        escalaVPar hebra4 = new escalaVPar(vector.length/8 * 3, vector.length/6 * 4 - 1);
        escalaVPar hebra5 = new escalaVPar(vector.length/8 * 4, vector.length/6 * 5 - 1);
        escalaVPar hebra6 = new escalaVPar(vector.length/8 * 5, vector.length/8 * 6 - 1);
        escalaVPar hebra7 = new escalaVPar(vector.length/8 * 6, vector.length/8 * 7- 1);
        escalaVPar hebra8 = new escalaVPar(vector.length/8 * 7, vector.length/8 - 1);

        hebra1.start();
        hebra2.start();
        hebra3.start();
        hebra4.start();
        hebra5.start();
        hebra6.start();
        hebra7.start();
        hebra8.start();
        

        hebra1.join();
        hebra2.join();
        hebra3.join();
        hebra4.join();
        hebra5.join();
        hebra6.join();
        hebra7.join();
        hebra8.join();


        //System.out.println(Arrays.toString(vector));
    }

}
