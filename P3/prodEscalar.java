public class prodEscalar {
    public static void main (String[] args) {
        int [] vector1 = new int[(int) Math.pow(10,6)];
        int [] vector2 = new int[(int) Math.pow(10,6)];
        int resultado = 0;

        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = (int) (Math.random() * 10);
            vector2[i] = (int) (Math.random() * 10);
        }

        long tiempoIni = System.nanoTime();
        for (int i = 0; i < vector1.length; i++) {
            resultado += (vector1[i] * vector2[i]);
        }
        long tiempoFin = (System.nanoTime() - tiempoIni) / (long) Math.pow(10, 6);
        System.out.println(tiempoFin + " milisegundos");
        System.out.println("El resultado es: "+ resultado);
    }
}
