import java.io.*;
import java.util.*;

public class jardin_virtual {

    static class Node{
        int dato;
        Node izq, der;
        
        Node(int dato){
            this.dato = dato;
            this.izq = this.der = null;
        }
    }
    
    static class BST{
        
        Node root;
        
        BST(){
            this.root = null;
        }
        
        void insert(int data) {
            root = insertNode(root, data);
        }
        
        Node insertNode(Node node, int data) {
            if (node == null) {
                node = new Node(data);
                return node;
            }
            if (data < node.dato)
              node.izq = insertNode(node.izq, data);
            else if (data > node.dato)
                node.der = insertNode(node.der, data);
            return node;
        }
        void preOrder(Node nodo){
            if(nodo != null){
                System.out.print(nodo.dato + " ");
                preOrder(nodo.izq);
                preOrder(nodo.der);
            }
        }   
        Node getRoot(){
            return root;
        }   
    } 
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        int n = in.nextInt();
        
        BST arbol = new BST();
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i = 0; i < n; i++){
            arr1[i] = in.nextInt();
        }
        
        for(int i = 0; i < n; i++){
            arr2[i] = in.nextInt();
        }
        
    
        for(int i = n - 1; i >= 0; i--){
            arbol.insert(arr2[i]);
        }
               
        arbol.preOrder(arbol.getRoot());
    }
}