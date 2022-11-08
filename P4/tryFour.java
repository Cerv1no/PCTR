public class tryFour extends Thread{
    private int tipoHilo;
    private static volatile int nVueltas = 10000;
    private static volatile int n = 0;
    private static volatile boolean wantp = false;
    private static volatile boolean wantq = false;

    public tryFour(int tipoHilo) { this.tipoHilo=tipoHilo; }

    public void run () {
        switch (tipoHilo) {
            case 1:
                for (int i = 0; i < nVueltas; i++) {
                    wantp = true;
                    while (wantq) {
                        wantp = false;
                        wantp = true;
                    }
                    n++;
                    wantp = false;
                }
                break;
            case 2:
                for (int i = 0; i < nVueltas; i++) {
                    wantq = true;
                    while (wantp){
                        wantq = false;
                        wantq = true;
                    }
                    n--;
                    wantq = false;
                }
                break;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //comprobamos el resultado para 1000 iteraciones
        for (int i = 0; i < 1000; i++){
            tryFour h1 = new tryFour(1);
            tryFour h2 = new tryFour(2);
            h1.start(); h2.start();
            h1.join(); h2.join();
            System.out.println(n);
        }
    }
}
