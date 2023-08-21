
//HR: lucas_abello

import java.util.*;

public class embeces_la_vida {

    public static void voltear(ArrayList<Integer> arr, int i, int j) {
        while (i < j) {
            int aux = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, aux);
            i++;
            j--;
        }
    }

    public static int coste(ArrayList<Integer> arr) {
        int n = arr.size();
        int suma = 0;

        for (int i = 0; i < n; i++) {
            
            int menor = arr.get(i);
            int posmenor = i;

            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) < menor) {
                    menor = arr.get(j);
                    posmenor = j;
                }
            }

            //condicion de sumatoria del coste 
            suma += (posmenor - i + 1);
            voltear(arr, i, posmenor);
        }

        return suma;
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }

        System.out.println(coste(arr) - 1);
    }
}
