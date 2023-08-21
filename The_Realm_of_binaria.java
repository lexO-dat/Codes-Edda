import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class The_Realm_of_binaria {

    static int sumaMatriz(int[][] x, int C, int F){
        int suma = 0;
        for(int i = 0; i < F; i++){
            for(int j = 0; j < C; j++){
                suma += x[i][j] * Math.pow(2, (C - j - 1));
            }
        }
        return suma;
    }

    static boolean concec(int[][] x, int columna, int filas){
        for(int i = 1; i < filas - 1; i++){
            int ant = x[i - 1][columna] - x[i][columna];
            int sig = x[i + 1][columna] - x[i][columna];
            if(ant == 0 || sig == 0){
                return true;
            }
        }
        return false;
    }
    
    //cuenta la cantidad de 1 que hay en una columna
    static int unosYceros(int[][] x, int columna, int ctFilas){
        int suma = 0;
        for(int j = 0; j < ctFilas; j++){
            if(x[j][columna] == 1){
                suma += 1;
            }
        }
        return suma;
    }

    //conteo de ceros y unos en las filas 
    static int cerosYunos(int[][] x, int fila, int ctColumnas){
        int suma = 0;
        for(int i = 0; i < ctColumnas; i++){
            if(x[fila][i] == 1){
                suma += 1;
            }
        }
        return suma;
    }
    
    static void Swap(int[][] x, int columna, int filas){
            for(int i = 0; i < filas; i++){
                if(x[i][columna] == 1){
                    x[i][columna] = 0;
                }else{
                    x[i][columna] = 1;
                }
            }
        }
    
    static void SwapF(int[][] x, int fila, int columnas){
            for(int i = 0; i < columnas; i++){
                if(x[fila][i] == 1){
                    x[fila][i] = 0;
                }else{
                    x[fila][i] = 1;
                }
            }
        }

    
    public static void main(String[] args) {
    Scanner in = new Scanner (System.in);
    int N = in.nextInt();
    int M = in.nextInt();
        
    int[][] matriz = new int[N][M];
    
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            matriz[i][j] = in.nextInt();
        }
    }

    float temp1 = 0;
    float temp2 = 0;
        
    //cambio de columnas
    int[] ctUnos = new int[M];
        
    temp2 = N/2;
    if(temp2 % 2 != 0 && N != 2){
        temp2  += 0.5f;
    }
    int suma = 0;
    for(int p = 0; p < M; p++){
        temp1 = unosYceros(matriz, p, N);

        if(temp1 < temp2){
            Swap(matriz, p, N);
            suma++;
        }
    }
    //si en todas las columnas hay mas 1 que 0: 
    if(suma == 0){
        for(int p = 0; p < M; p++){
            if(concec(matriz, p, N) == true){
                Swap(matriz, p, N);
            }
        }
    }
        
    //cambio de filas
    int[] Unosct = new int[N];
    
    temp2 = M/2;
    if(temp2 % 2 != 0 && M != 2){
        temp2 += 0.5f;
    }
    //System.out.println(temp2);
    for(int p = 0; p < N; p++){
        temp1 = cerosYunos(matriz, p, M);

        if(temp1 < temp2){
            SwapF(matriz, p, M);
        }
    }
    System.out.print(sumaMatriz(matriz, M, N));   
    }

}