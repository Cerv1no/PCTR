import java.util.Scanner;
import static java.lang.Math.cos;
public class NewtonRaphson {

    public static void main (String[] args) {
        int iteraciones, n;
        double aproximacion;
        Scanner s = new Scanner(System.in);;

        //recogemos la funcion a resolver
        do {
            System.out.println("Introduce la opcion correspondiente");
            System.out.println("1. f(x) = cos(x) - x^3 en [0,1]");
            System.out.println("2. f(x) = x^2 - 5 en [2,3]");
            n = s.nextInt();
        } while (n < 1 || n > 2);

        //f(x) = cos(x) - x^3 en [0,1]
        if (n == 1) {
            //recogemos la aproximacion inicial
            do {
                System.out.println("Introduce una aproximacion inicial del rango [0,1]: ");
                aproximacion = s.nextDouble();
            } while (aproximacion < 0 || aproximacion > 1);
            //recogemos el numero de iteraciones
            do {
                System.out.print("Numero de iteraciones: ");
                iteraciones = s.nextInt();
            } while (iteraciones < 0);
            System.out.println("Resultado: " + f1(aproximacion, iteraciones));
        }

        //f(x) = x^2 - 5 en [2,3]
        else {
            //recogemos la aproximacion inicial
            do {
                System.out.println("Introduce una aproximacion inicial del rango [2,3]: ");
                aproximacion = s.nextDouble();
            } while (aproximacion < 2 || aproximacion > 3);
            //recogemos el numero de iteraciones
            do {
                System.out.print("Numero de iteraciones: ");
                iteraciones = s.nextInt();
            } while (iteraciones < 0);
            System.out.println("Resultado: " + f2(aproximacion, iteraciones));
        }
    }

    //funcion que calcula el resultado de la primera funcion
    public static double f1(double aprox, int iteraciones) {
        double xn = aprox;
        for (int i = 0; i < iteraciones; i++) {
            double derivada = - Math.sin(xn) - (3 * Math.pow(xn,2));
            double funcion = Math.cos(xn) - Math.pow(xn,3);
            if ( derivada != 0) {
                double xn1 = xn - funcion / derivada;
                System.out.println("Iteracion: " + i + "Aproximacion: " + xn1);
                xn = xn1;
            }
        }
        return xn;
    }

    //funcion que calcula el resultado de la segunda funcion
    public static double f2(double aprox, int iteraciones) {
        double xn = aprox;
        for (int i = 0; i < iteraciones; i++) {
            double derivada = 2 * xn;
            double funcion = Math.pow(xn,2) - 5;
            if (derivada != 0) {
                double xn1 = (xn - funcion / derivada);
                System.out.println("Iteracion: " + i + " Aproximacion: " + xn1);
                xn = xn1;
            }
        }
        return xn;
    }
}
