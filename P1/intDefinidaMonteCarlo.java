import java.util.Scanner ;

import static java.lang.Math.sin;

public class intDefinidaMonteCarlo {

   public static void main(String[] args) {
       int n;
       //recogemos numero de puntos > 0
       do {
           System.out.print("Numero de puntos: ");
           Scanner s = new Scanner(System.in);
           n = s.nextInt();
       } while (n < 0);

       int exitos1 = 0;
       int exitos2 = 0;

       //calculamos la integral aproximada de ambas funciones
       for(int i = 0 ; i< n; i++) {
           double coord_x = Math.random();
           double coord_y = Math.random();

           if (coord_y <= sin(coord_x)) {
               exitos1++;
           }
           if (coord_y <= coord_x) {
               exitos2++;
           }
       }

       System.out.println("Integral aproximada f(x) = sin: " + (double)exitos1/n);
       System.out.println("Integral aproximada f(x) = x: " + (double)exitos2/n);
   }
}
