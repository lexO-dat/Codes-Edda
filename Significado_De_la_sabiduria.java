import java.util.*;
public class Significado_De_la_sabiduria{
    public static void main(String[] args) {
        //problema greedy
        int k, n;
        
        Scanner in = new Scanner (System.in);
        n = in.nextInt();
        k = in.nextInt();
        int[] lista = new int[n];
        for(int i = 0; i < n; i++){
            lista[i] = in.nextInt();
        }
        Arrays.sort(lista);
        int menor = lista[k - 1] - lista[0];
        for(int i = 0; i < n; i++){

            if(i + (k - 1) > (n - 1)){
                continue;
            }else
            if(menor > lista[i + (k - 1)] - lista[i]){
                menor = lista[i + (k - 1)] - lista[i];
            }
        }
        System.out.print(menor);
    }
}
