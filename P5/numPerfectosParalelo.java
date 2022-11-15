import java.util.ArrayList;
import java.util.concurrent.*;
/**
 * Esta clase implementa la busqueda de numeros perfectos dentro de un rango dado de forma paralela
 * @author Álvaro Álvarez Cerviño
 * @version 15/11/22
 */
public class numPerfectosParalelo implements Callable{
    private final int linf;
    private final int lsup;
    private long total = 0;

    /**
     * Método constructor parametrizado
     * @param linf índice de inicio
     * @param lsup índice de final
     */
    public numPerfectosParalelo (int linf, int lsup) {this.linf = linf; this.lsup = lsup;}

    /**
     * Método de la hebra que realiza la busqueda de numeros perfectos dentro del rango asignado
     */
    public Long call() {
        for (int i = linf; i <= lsup; i++) {
            int sumDivisores = 0;
            for (int j = 1; j < i; j++) {
                if ((i % j) == 0) {
                    sumDivisores += j;
                }
            }
            if (sumDivisores == i) {
                total++;
            }
        }
        return total;
    }

    public static void main (String[] args) throws Exception{

        int rango = Integer.parseInt(args[0]);
        int nHilos = 12;
        int linf = 2;
        int tamHilos = rango / nHilos;
        int lsup = tamHilos;

        long totalPerfectos = 0;
        //lista donde se guardan los resultados parciales
        ArrayList<Future<Long>> contParciales = new ArrayList<>();
        long tiempoIni = System.nanoTime();
        //Creamos el pool de hilos con capacidad de nHilos
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
            nHilos,
            nHilos,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>()); 
        for (int i = 0; i < nHilos; i++) {
            if (i == nHilos - 1){
                //Ejecutamos la tarea con rango dado y añadimos el resultado a la lista de parciales
                contParciales.add(pool.submit(new numPerfectosParalelo(linf, rango)));
            }
            else {
                contParciales.add(pool.submit(new numPerfectosParalelo(linf, lsup)));
                linf = lsup + 1;
                lsup += tamHilos;
            }
        }

        //Recogemos los resultados parciales y los sumamos
        for(Future<Long> iterador:contParciales)
            try{
                totalPerfectos +=  iterador.get();
            }catch (CancellationException | ExecutionException | InterruptedException e){}

        long tiempoFin = (System.nanoTime() - tiempoIni) / (long) Math.pow(10, 6);
        pool.shutdown();
        System.out.println("Número de perfectos: " + totalPerfectos);
        System.out.println(tiempoFin + " milisegundos");
    }
    
}
