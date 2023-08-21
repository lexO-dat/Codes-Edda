import java.util.*;

public class ejercicio2 {
    
    static void invertir(Stack<Integer> pila, int a){
        Queue<Integer> cola = new LinkedList<>();
        int inicio = 0;
        while (inicio < a) {
            cola.add(pila.peek());
            pila.pop();
            inicio++;
        }
        while(!cola.isEmpty()){
            pila.push(cola.peek());
            cola.poll();
        }
    }

    public static void orden(Stack<Integer> pila, int x){
        Stack<Integer> pilaaux = new Stack<Integer>();
        if(x <= 1){
            return;
        }
        int mayor = 0; int pos = 1;
        //se itera buscando el mayor hasta el size (que por recursividad va restando 1)
        //Seria como la especie de bloqueo de la barra que vaya quedando abajo.
        for(int i = 1; i <= x; i ++){
            if(pila.peek() > mayor){
                mayor = pila.peek();
                pos = i;
            }
            pilaaux.push(pila.peek());
            pila.pop();
        }
        //devuelve la pila como estaba
        while(!pilaaux.isEmpty()){
            pila.push(pilaaux.peek());
            pilaaux.pop();
        }
        //si el mayor no esta en la casilla 1 (ya que no tendria sentido invertir)
        //invierte hasta la posicion en la que este el mayor
        if(pos != 1){
            invertir(pila, pos);
        }
        //invierte la pila completa hasta el bloqueo
        invertir(pila, x);
        //recurre la funcion para ir aumentando el bloqueo (bloquear los ya movidos abajo)
        orden(pila, x - 1);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stack<Integer> pila = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            pila.push(x);
        }
        int tamanio = pila.size();
        orden(pila, tamanio);
        while(!pila.isEmpty()){
            System.out.print(pila.peek() + " ");
            pila.pop();
        }
    }
}
