import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class algPeterson implements Runnable{
    private int tipoHilo;
    private static volatile int nVueltas = 10000;
    private static volatile int n = 0;
    private static volatile boolean wantp = false;
    private static volatile boolean wantq = false;

    private static volatile int last = 1;

    public algPeterson(int tipoHilo) { this.tipoHilo=tipoHilo; }

    public void run () {
        switch (tipoHilo) {
            case 1:
                for (int i = 0; i < nVueltas; i++) {
                    wantp = true;
                    last = 1;
                    while (wantq && last == 1);//se queda infinito en este bucle

                    n++;
                    wantp = false;
                }
                break;
            case 2:
                for (int i = 0; i < nVueltas; i++) {
                    wantq = true;
                    last = 2;
                    while (wantp && last == 2);
                     // se queda infinito en este bucle

                    n--;
                    wantq = false;
                }
                break;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //comprobamos el resultado para 1000 iteraciones
        for (int i = 0; i < 1000; i++) {
            ExecutorService ejecutor = Executors.newFixedThreadPool(100);
            ejecutor.execute(new algPeterson(1));
            ejecutor.execute(new algPeterson(2));
            ejecutor.shutdown();
            while (!ejecutor.isTerminated()) ;
            System.out.println(n);
        }
    }
}