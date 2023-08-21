import java.io.*;
import java.util.*;
    
class jugador{
        String nombre;
        int poder;
        
        jugador(String n, int p){
            this.nombre = n;
            this.poder = p;
        }
        
        public int getpoder(){
            return this.poder;
        }
        
        public String getnombr(){
            return this.nombre;
        }
         
        public void gettodo(){
            System.out.println(this.nombre + " " + this.poder);
        }
    }

class ordenamiento implements Comparator<jugador> {
    public int compare(jugador a, jugador b)
    {
        return a.getpoder() - b.getpoder();
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inl = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        int o = 0;
        String t = "";
        ArrayList<jugador> arr = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            t = inl.next();
            jugador x = new jugador(t , o);
            
            arr.add(x);
        }
        
        Collections.sort(arr, new ordenamiento());
        for(int i = 0; i < n; i++){
            arr.get(i).gettodo();
            }
        }
    }
