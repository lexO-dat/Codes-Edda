import java.io.*;
import java.util.*;

public class ejercicio3 {
    
public static void fusionar (Queue<Integer> cola1, Queue<Integer> cola2, Queue<Integer> colaaux){
    
      while(cola1.isEmpty() != true && cola2.isEmpty() != true){
        if(cola1.peek() > cola2.peek()){
            colaaux.add(cola2.peek());
            cola2.poll();
        }else{
            colaaux.add(cola1.peek());
            cola1.poll();
            }  
        }
    
     if(cola1.isEmpty() == false){
        while(cola1.isEmpty() != true){
            colaaux.add(cola1.peek());
            cola1.poll();
        }
    }else{
        while(cola2.isEmpty() != true){
            colaaux.add(cola2.peek());
            cola2.poll();
        }
        
    }
}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Queue<Integer> cola1 = new LinkedList<>();
        Queue<Integer> colaaux = new LinkedList<>();
        for(int i = 0; i < N; i++){
            cola1.add(in.nextInt());
        }
        N = in.nextInt();
        Queue<Integer> cola2 = new LinkedList<>();
        
        for(int i = 0; i < N; i++){
            cola2.add(in.nextInt());
        }
        
        fusionar(cola1, cola2, colaaux);
    
        while(colaaux.isEmpty() != true){
        System.out.print(colaaux.peek() + " ");
        colaaux.poll();
        }
    }
}