public class tryThree extends Thread{
    private int tipoHilo;
    private static volatile int nVueltas = 10000;
    private static volatile int n = 0;
    private static volatile boolean wantp = false;
    private static volatile boolean wantq = false;

    public tryThree(int tipoHilo) { this.tipoHilo=tipoHilo; }

    public void run () {
        switch (tipoHilo) {
            case 1:
                for (int i = 0; i < nVueltas; i++) {
                    wantp = true;
                    while (wantq);
                    n++;
                    wantp = true;
                }
                break;
            case 2:
                for (int i = 0; i < nVueltas; i++) {
                    wantq = true;
                    while (wantp);
                    n--;
                    wantq = true;
                }
                break;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        tryThree h1 = new tryThree(1);
        tryThree h2 = new tryThree(2);
        h1.start(); h2.start();
        h1.join(); h2.join();
        System.out.println(n);
    }
}
