/**
 * Esta clase lanza dos hebras que realizan operaciones en una variable compartida
 * @author Álvaro Álvarez Cerviño
 * @version 2222.0
 */
public class concursoLambda{
    static int compartida = 0;
    public static void main (String[] args) throws Exception{
        Runnable r1 = () -> {
            for(int i = 0; i < 10000; ++i){
                compartida++;
            }
        };
        Runnable r2 = () -> {
            for(int i = 0; i < 10000; ++i){
                compartida--;
            }
        };

        Thread hebra1 = new Thread(r1);
        Thread hebra2 = new Thread(r2);

        hebra1.start();
        hebra2.start();
        hebra1.join();
        hebra2.join();

        System.out.println(compartida);
    }
}