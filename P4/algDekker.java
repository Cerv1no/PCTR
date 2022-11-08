public class algDekker extends Thread{
    private int tipoHilo;
    private static volatile int nVueltas = 10000;
    private static volatile int n = 0;
    private static volatile boolean wantp = false;
    private static volatile boolean wantq = false;

    private static volatile int turn = 1;

    public algDekker(int tipoHilo) { this.tipoHilo=tipoHilo; }

    public void run () {
        switch (tipoHilo) {
            case 1:
                for (int i = 0; i < nVueltas; i++) {
                    wantp = true;
                    while (wantq) {
                        if (turn == 2) {
                            wantp = false;
                            while (turn != 1);
                            wantp = true;
                        }
                    }
                    n++;
                    turn = 2;
                    wantp = false;
                }
                break;
            case 2:
                for (int i = 0; i < nVueltas; i++) {
                    wantq = true;
                    while (wantp){
                        if (turn == 1) {
                            wantq = false;
                            while (turn != 2);
                            wantq = true;
                        }
                    }
                    n--;
                    turn = 1;
                    wantq = false;
                }
                break;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //comprobamos el resultado para 1000 iteraciones
        for (int i = 0; i < 1000; i++){
            algDekker h1 = new algDekker(1);
            algDekker h2 = new algDekker(2);
            h1.start(); h2.start();
            h1.join(); h2.join();
            System.out.println(n);
        }
    }
}
