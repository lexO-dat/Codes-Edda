import java.util.*;

public class tarea1_ejercicio2{
    static void imprimir(int[] arr, int inicio, int fin){
        if(fin == 0){ //caso base, si no hay espacios a mover retorna y se acaba.
            return;
        }

        System.out.print(arr[inicio] + " "); //imprime la casilla en la que esta actual.

        if (inicio == arr.length - 1){ //si esta en la ultima casilla:
            imprimir(arr, 0, fin - 1); //ingresa la funcion nuevamente con el inicio 3en la casilla 0.
        }else{
            imprimir(arr, inicio + 1, fin - 1); // si no, ingresa a la funcion el inicio + 1 (pasar a la siguiente casilla).
            //y el fin -a para ir restando la cantidad de casillas ya mostradas.
        }     
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); int m = in.nextInt(); int s = in.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = in.nextInt();
        }

        imprimir(arr, m, s);
        
    }
}