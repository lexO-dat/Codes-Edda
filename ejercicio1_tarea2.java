import java.util.Scanner;
import java.util.Stack;

public class ejercicio1 {
    public static void main(String[] args) {
        
        Stack<Integer> pila = new Stack<>();
        
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        int[] arr = new int[n];
        
        int altura; int ancho;
        int areamaxima = 0;
        
        //se rellena el arreglo de alturas
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        
        
        for (int i = 0; i <= n; i++) {
            
            if(i == n){
                altura = 0;
            }else{
                altura = arr[i];
            }
            
            //se verifica la altura maxima y se agrega la posicion a la pila
            if (pila.isEmpty() || altura >= arr[pila.peek()]) {
                pila.push(i);
            } else {
                //el tope sera la ultima posicion agregada a la pila
                int top = pila.pop();
                
                //se determina el ancho segun la posicion en la que este el top de altura
                if(pila.isEmpty() == true){
                    ancho = i;
                }else{
                    ancho = i - pila.peek() - 1;
                }
                
                int area = arr[top] * ancho;
                
                if(areamaxima < area){
                    areamaxima = area;
                }
                
                i--;
            }
        }
        
        System.out.println(areamaxima);
    }
}

