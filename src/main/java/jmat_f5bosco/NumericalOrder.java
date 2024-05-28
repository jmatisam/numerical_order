package jmat_f5bosco;

public class NumericalOrder {
    public static void bubbleSort(int[] array) {
        int aux;
        boolean cambio;

        do {
            cambio = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    // Intercambiar los elementos
                    aux = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = aux;
                    cambio = true;
                }
            }
        } while (cambio);
    }
}
