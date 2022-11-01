import java.util.Vector;

import static java.lang.Math.pow;
/**
 * Esta clase realiza el escalado de un vector
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class escalaVector {
    public static void main(String[] args) {
        int n = 3 * (int)Math.pow(10,6);
        double escalar = 2;
        double[] vector = new double[n];
        for (int i = 0; i < n; i++) {
            vector[i] = Math.random() * 10;
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i]*= escalar;
        }
    }
}
