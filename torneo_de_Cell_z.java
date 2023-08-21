import java.util.*;

public class torneo_de_Cell_z{

    static class Node {
        String nombre;
        int poder;
        Node left;
        Node right;

        public Node(String nombre, int poder) {
            this.nombre = nombre;
            this.poder = poder;
        }
    }
    //truco
    /*llave valor
     poder nombre
     */
    static class BST {
        Node root;
        Node aux;

        public void insert(String nombre, int poder) {
            root = insertRec(root, nombre, poder);
        }

        private Node insertRec(Node root, String nombre, int poder) {
            if (root == null) {
                return new Node(nombre, poder);
            }

            if (poder < root.poder) {
                root.left = insertRec(root.left, nombre, poder);
            } else if (poder > root.poder) {
                root.right = insertRec(root.right, nombre, poder);
            }

            return root;
        }    
    }
    
    static Node padreComun(Node raiz, Node p, Node q) {
            if(raiz==null) return null;
            if(raiz==p || raiz==q) return raiz;
 
            Node l = padreComun(raiz.left, p, q);
            Node r = padreComun(raiz.right, p, q);
 
                if( l!=null && r!=null){
                    return raiz;
                }else if(l==null&&r==null){
                    return null;
                }else{
                    if(l == null){
                        return r;
                    }else{
                        return l;
                    }
            }
    }
    
    static Node buscarNombre(Node nodo, String nombre) {
    if (nodo == null) {
        return null;
    }
    if (nodo.nombre.equals(nombre)) {
        return nodo;
    }
    Node encontradoIzq = buscarNombre(nodo.left, nombre);
    if (encontradoIzq != null) {
        return encontradoIzq;
    }
    return buscarNombre(nodo.right, nombre);
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        BST arbol = new BST();
        
        for(int i = 0; i < n; i++){
            String nombre = in.next();
            int poder = in.nextInt();
            arbol.insert(nombre, poder);
        }
        String jugador1 = in.next();
        String jugador2 = in.next();

        Node part1 = buscarNombre(arbol.root, jugador1);
        Node part2 = buscarNombre(arbol.root, jugador2);
        
        Node mayor = padreComun(arbol.root, part1, part2);
        
        System.out.println(mayor.nombre);
        }
    
}