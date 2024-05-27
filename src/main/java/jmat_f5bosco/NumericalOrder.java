package jmat_f5bosco;

import java.util.Scanner;

public class NumericalOrder {
   
    public static void main(String[] args) {
    
       System.out.println("Hello, welcome to Numerical Order Show! ;)");

        try (Scanner scanner = new Scanner(System.in)) {
            // Solicitar al usuario el número de elementos en la lista
            System.out.println("Ingrese el número de elementos en la lista:");
            int n = scanner.nextInt();
            int[] array = new int[n]; // Crear un array de longitud n

            // Solicitar al usuario que ingrese los elementos de la lista
            System.out.println("Ingrese los elementos de la lista:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            // Bubble Sort
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

            // Mostrar la lista ordenada
            System.out.println("Lista ordenada:");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }

        System.out.println();

    }
}
