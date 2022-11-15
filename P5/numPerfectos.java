/**
 * Esta clase implementa la busqueda de numeros perfectos dentro de un rango dado de forma secuencial
 * @author Álvaro Álvarez Cerviño
 * @version 15/11/22
 */
public class numPerfectos {
    public static void main(String[] args) {
        int rango = Integer.parseInt(args[0]);
        int totalPerfectos = 0;
        int sumDivisores = 0;

        long tiempoIni = System.nanoTime();
        for (int i = 2; i <= rango; i++) {
            sumDivisores = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sumDivisores += j;
                }
            }
            if (sumDivisores == i) {
                
                totalPerfectos++;
            }
        }
        long tiempoFin = (System.nanoTime() - tiempoIni) / (long) Math.pow(10, 6);
        System.out.println("Número de perfectos: " + totalPerfectos);
        System.out.println(tiempoFin + " milisegundos");
    }
}
