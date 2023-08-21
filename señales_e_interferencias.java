//Lucas Abello
//21450324-7
//HR: lucas_abello

import java.util.*;

public class señales_e_interferencias {

    public static int maxsuma(int[] x) {
        return maxsumar(x, 0, x.length - 1);
        
    }

    private static int maxsumar(int[] x, int inicio, int fin) {
        
        if (inicio == fin) {
            return x[inicio];
        }

        int medio = (inicio + fin) / 2;

        int izq = maxsumar(x, inicio, medio);
        int der = maxsumar(x, medio + 1, fin);
        //caso que contempla ambos sub arreglos generados 
        int med = maxsumamedia(x, inicio, medio, fin);
        return Math.max(Math.max(izq, der), med);
    }

    private static int maxsumamedia(int[] x, int inicio, int medio, int fin){
        
        int izq = 0;
        int der = 0;
        int suma = 0;

        for (int i = medio; i >= inicio; i--) {
            suma += x[i];
            izq = Math.max(izq, suma);
        }

        suma = 0;
        for (int i = medio + 1; i <= fin; i++) {
            suma += x[i];
            der = Math.max(der, suma);
        }

        return izq + der;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        
        System.out.println(maxsuma(arr));
    }
}
