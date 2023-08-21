import java.util.*;

static class Nodo{
    int valor;
    Nodo siguiente;

    Nodo(){
        this.valor = 0;
        this.siguiente = null;
    }

    Nodo(int v){
        this.valor = v;
    }
}

static class listaenlazada{

    listaenlazada(){};

    Nodo cabezera = new Nodo();

    void insertar(Nodo a){
        if(cabezera.siguiente == null){
            cabezera = a;
        }else{
            Nodo aux = cabezera;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }

            aux.siguiente = a;
        }
    }

    void imprimir(){
        Nodo aux = cabezera;
        while(aux.siguiente != null){
            System.out.print(aux.valor + "->");
        }
    }
}
public class repaso{

    public static void main (String[] args){
        //System.out.println("Hello World");
        Nodo a = new Nodo(23);
        Nodo b = new Nodo(21);
        Nodo c = new Nodo(1);
        Nodo d = new Nodo(12);
        Nodo e = new Nodo(9);
        Nodo f = new Nodo(3);
        Nodo g = new Nodo(41);

        listaenlazada lista = new listaenlazada();

        lista.insertar(a);
        lista.insertar(b);
        lista.insertar(c);
        lista.insertar(d);
        lista.insertar(e);
        lista.insertar(f);
        lista.insertar(g);

        lista.imprimir();




    }
}