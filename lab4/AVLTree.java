import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class AVLTree {
    //No modificar
    private Node root;

    //No modificar
    public static class Node{
        String key;
        LinkedList videos;
        int height;
        Node left;
        Node right;

        Node(String key, LinkedList videos){
            this.key = key;
            this.videos = videos;
        }
    }
    //Constructor para TEST 1
    //No modificar
    AVLTree(){}

    //Constructor para TEST 2
    //No modificar
    AVLTree(String file){
        String string;

        Hashtable<String, LinkedList> channels = new Hashtable<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file));){
            br.readLine();
            while((string = br.readLine()) != null){
                boolean inQuotes = false;
                int start = 0;
                ArrayList<String> newLines = new ArrayList<>();
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == '\"') {
                        inQuotes = !inQuotes;
                    } else if (string.charAt(i) == ',' && !inQuotes) {
                        newLines.add(string.substring(start, i));
                        start = i + 1;
                    }
                }
                newLines.add(string.substring(start));
                Video newVideo = arrayToVideo(newLines);
                String key = newVideo.getChannelTitle(); //la llave es el nombre del canal
                if(channels.get(key) == null){
                    LinkedList linkedList = new LinkedList();
                    linkedList.insertAtEnd(newVideo);
                    channels.put(key, linkedList); //mete el tirulo del canal y la lista de videos
                }
                else {
                    channels.get(key).insertAtEnd(newVideo);
                }
            }
            Enumeration<String> keys = channels.keys();
            //se agregan datos agrupados del hash al árbol
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                insert(root, key,channels.get(key));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //No modificar
    public Node getRoot(){return root;}

    //No modificar
    long isNumericLong(String s){
        long d = 0;
        try {
            d = Long.parseLong(s);
        }
        catch (NumberFormatException ignored){}
        return d;
    }

    //No modificar
    int isNumericInt(String s){
        int i = 0;
        try {
            i = Integer.parseInt(s);
        }
        catch (NumberFormatException ignored){}
        return i;
    }
    //No modificar
    Video arrayToVideo(ArrayList<String> array){
        if(array.get(5).equals("")){
            array.set(5,"0");
        }
        if(array.get(6).equals("")){
            array.set(6,"0");
        }

        long viewCount = isNumericLong(array.get(5));
        int likeCount = isNumericInt(array.get(6));
        int commentCount = isNumericInt(array.get(7));

        float popularity = 0F;
        if( viewCount != 0) { popularity = Float.parseFloat(array.get(5)) / Float.parseFloat(array.get(6)); }
        Video v = new Video(array.get(0),
                array.get(1),
                array.get(2),
                array.get(3),
                array.get(4),
                viewCount,
                likeCount,
                commentCount,
                popularity);
        return v;
    }

    //Depurar
    void insert(Node nodo, String key, LinkedList videos){
       root = insertNode(nodo, key, videos);
    }
    //Depurar
    Node insertNode(Node node, String key, LinkedList videos){
        if(node == null){
            return new Node(key, videos);
        } //bien


        if(key.compareTo(node.key) < 0){
            node.left = insertNode(node.left, key, videos);
        }else if (key.compareTo(node.key) > 0) {
            node.right = insertNode(node.right,key, videos);
        }
        else {
            throw new RuntimeException("Duplicate key!");
        }
        return balance(node);
    }
    //Depurar // listo en teoria
    Node balance(Node node){
        updateHeight(node);
        if (getBalance(node) < -1){
            if(height(node.left.left) < height(node.left.right)){
                //System.out.printf(node.left.key + " is rotated left and ");
                node.left = rotateLeft(node.left);

            }
            //System.out.println(node.key + " is rotated right" );
            node = rotateRight(node);
        }
        else if(getBalance(node) > 1){
            if(height(node.right.right) < height(node.right.left)){
                //System.out.print(node.right.key + " is rotated right and ");
                node.right = rotateRight(node.right);
            }
            //System.out.println(node.key +" is rotated left");
            node = rotateLeft(node);
        }
        return node;
    }
    //Depurar
    //aca aes arreglar el tema de rotar /// listo
    Node rotateRight(Node n1) {
        Node n2 = n1.left;
        Node n3 = n2.right;
        n2.right = n1;
        n1.left = n3;
        updateHeight(n1);
        updateHeight(n2);
        return n2;
    }

    //Depurar
    //same shit /// listo
    Node rotateLeft(Node n1) {
        Node n2 = n1.right;
        Node n3 = n2.left;
        n2.left = n1;
        n1.right = n3;
        updateHeight(n1);
        updateHeight(n2);
        return n2;
    }


    //Implementar
    Node find(Node nodo, String key){
        //hay que buscar en el arbol dada la llave
        if (nodo == null || nodo.key.equals(key)){
            return nodo;
        }
        if (key.compareTo(nodo.key) < 0){
            return find(nodo.left, key);
        }else  if(key.compareTo(nodo.key) > 0){
            return find(nodo.right, key);
        }
        return nodo;
    }
    //retorna la linked list
    LinkedList findA(Node nodo, String key){
        //hay que buscar en el arbol dada la llave
        if (nodo == null){
            return null;
        }else if(nodo.key.equals(key)){
            return nodo.videos;
        }
        if (key.compareTo(nodo.key) < 0){
            return findA(nodo.left, key);
        }else  if(key.compareTo(nodo.key) > 0){
            return findA(nodo.right, key);
        }
        return nodo.videos;
    }

    //Implementar
    //Node find(Node node, String key){
    //    return node;
    //}


// Implementar
void delete(String key) {
    root = deleteNodo(root, key);
}

// Implementar
Node deleteNodo(Node node, String key) {
    if (node == null) {
        return null;
    }

    if (key.compareTo(node.key) < 0) {
        node.left = deleteNodo(node.left, key);
    } else if (key.compareTo(node.key) > 0) {
        node.right = deleteNodo(node.right, key);
    } else {
        if (node.left == null || node.right == null) {
            Node aux = null;
            if(node.left != null){
                aux = node.left;
            }else{
                aux = node.right;
            }
            if (aux == null) {
                return null; 
            } else {
                return aux; 
            }
        }
        Node temp = EncontrarHijo(node.right);
        node.key = temp.key;
        node.videos = temp.videos;
        node.right = deleteNodo(node.right, temp.key);
    }
    updateHeight(node);
    return balance(node);
}

Node EncontrarHijo(Node node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}
    //No modificar
    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    //No modificar
    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    //No modificar
    private int getBalance(Node node){
        return (node == null) ? 0 :  height(node.right) - height(node.left);
    }

    //No modificar
    void preOrder(Node node) {
        if (node != null) {
            System.out.println("Channel Title: " + node.key + "| Height: " + node.height + "| root: " + node.videos.begin().getVideoTitle());
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    //No modificar
    void inOrderInv(Node node) {
        if (node != null) {
            inOrderInv(node.right);
            System.out.println("Channel Title: " + node.key + "| Height: " + node.height + "| root: " + node.videos.begin().getVideoTitle());
            inOrderInv(node.left);
        }
    }

    public static void main(String[] args) {
        /*
        //------------------------------------------------------------------------------
        TEST 1: Prueba sin datos de CSV.
        Ejemplo de salida de esta prueba en la sección 4.3 del enunciado
        //------------------------------------------------------------------------------ */
        ArrayList<Video> videos = new ArrayList<>();
        
        videos.add(new Video("1","video 1", "1","J", "12-12-1221",131, 323, 323,22f));
        videos.add(new Video("2","video 2", "1","J", "12-12-1221",131, 323, 323,12f));
        videos.add(new Video("3","video 3", "1","J", "12-12-1221",131, 323, 323,13f));
        videos.add(new Video("4","video 4", "1","D", "12-12-1221",131, 323, 323,14f));
        videos.add(new Video("5","video 5", "1","D", "12-12-1221",131, 323, 323,15f));
        videos.add(new Video("6","video 6", "1","K", "12-12-1221",131, 323, 323,16f));
        videos.add(new Video("7","video 7", "1","H", "12-12-1221",131, 323, 323,17f));
        videos.add(new Video("8","video 8", "1","H", "12-12-1221",131, 323, 323,18f));
        videos.add(new Video("9","vídeo 9", "1","F", "12-12-1221",131, 323, 323,19f));

        Hashtable<String, LinkedList> channels = new Hashtable<>();
        for (Video v : videos) {
            String key = v.getChannelTitle();
            if(channels.get(key) == null){
                LinkedList platform = new LinkedList();
                platform.insertAtEnd(v);
                channels.put(key,platform);
            }
            else {
                channels.get(key).insertAtEnd(v);
            }
        }
        
        AVLTree tree = new AVLTree();
        
        Enumeration<String> keys = channels.keys();
        System.out.println("Datos de prueba:");
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            tree.insert(tree.root, key,channels.get(key));
        }
        System.out.println("Árbol inicial:");
        tree.preOrder(tree.root);

        LinkedList videoList = new LinkedList();
        videoList.insertAtEnd(new Video("10","video 10", "1","A", "12-12-1221",131, 323, 323,19f));
        tree.insert(tree.root, "A" , videoList);

        System.out.println("Luego de insertar nodo A:");
        tree.preOrder(tree.root);

        System.out.println("Luego de eliminar nodo F:");
        tree.delete("F");
        tree.preOrder(tree.root);

        Node result = tree.find(tree.root, "A");
        System.out.println("Resultado de búsqueda: " + result.key + " primer vídeo: " + result.videos.begin().getVideoTitle());
        result = tree.find(tree.root, "Z");
        System.out.println("Resultado de búsqueda: " + result);


        /*
        //------------------------------------------------------------------------------
        //TEST2: constructor de AVLTree con base en un archivo .CSV
        // Descomentar solo después de depurar e implementar métodos del AVL
        //------------------------------------------------------------------------------
        String file = "YoutubeDTSV2.csv";
        AVLTree tree = new AVLTree(file);
        tree.preOrder(tree.root);
        System.out.println("Resultado de la busqueda: ");
        Node result = tree.find("twenty one pilots");
        result.videos.recursivePrint(result.videos.begin());
        tree.delete("notFoundVideo");*/
    }
}
