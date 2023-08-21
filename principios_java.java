import java.util.Scanner; //esta libreria ingresar datos desde la consola

public class principios_java{
    public static void main(String[] args){
        /* 
        //tipos de datos primitivos 
        int entero = 12; //32 bits
        long largo = 123453; //64 bits
        short corto = 23; //16 
        byte bite = 127; //8 bits

        //decimales
        double decimalLargo = 12.12;
        float decimalCorto = 12.23f; //se pone la f al final para especificar que es un float

        char caracter = 'h';

        //tipos de datos no primitivos (estos tipos de datos tienen metodos al poner un punto despues de ellos)
        Integer enteroNoPrimitivo = 12; 
        String cadena = "Hola Que Tal";

        //mostrar en consola
        System.out.println("la cadena es: " + cadena); //el ln es para un salto de linea (un endl de  c++)

        //recibir desde consola
        int variable, x;
        Scanner entrada = new Scanner(System.in); //esto inicializa el objeto entrada
        variable = entrada.nextInt(); //nextTipodedato (para los enteros y decimales)

        String cadena2;
        Scanner entradaS = new Scanner(System.in);
        cadena2 = entradaS.next(); //con esto se registra solo la primera palabra
        cadena2 = entradaS.nextLine(); //con esto lee la cadena entera, sin importar los espacios
        System.out.println(cadena2);

        char caracter2;
        Scanner entradaC = new Scanner(System.in);
        caracter2 = entradaC.next().charAt(0); //REGISTRA SOLO LA PRIMERA LETRA (como un arreglo)
        */

        //Ejercicio 1: programa que sume 3 notas y calcule el promedio
        //float n1, n2, n3, promedio;
        //Scanner ent = new Scanner(System.in);
        //System.out.print("ingrese sus 3 notas: ");
        //n1 = ent.nextFloat();
        //n2 = ent.nextFloat();
        //n3 = ent.nextFloat();
        //promedio = (n1+n2+n3)/3;
        //System.out.println("su promedio es: " + promedio);

        //Ejercicio 2: programa que muestre el salario de un empleadoa partir de sus horas semanales trabajadas y su salario por hora
        //Scanner entrada = new Scanner(System.in);
        //short HS;
        //int SH, S;
        //System.out.println("ingrese cuantas horas semanales trabaja.");
        //HS = entrada.nextShort();
        //System.out.println("ingrese salario por hora.");
        //SH = entrada.nextInt();
        //S = (HS*SH)*4;
        //System.out.println("su salario es: " + S);

        //condicional switch
        /*int var = 65;
        switch(var){
            case 32:
            System.out.println("la variable vale 32");
            break;
            case 1:
            System.out.println("la variable vale 1");
            break;
            case 4:
            System.out.println("la variable vale 4");
            break;
            case 98:
            System.out.println("la variable vale 98");
            break;
            case 2:
            System.out.println("la variable vale 2");
            break;
            default:
            System.out.println("no es ninguno");
            break;
        }
    }*/

    //arreglos
    //la unica diferencia con c++ es que para inicializarlo se usa como objeto puntero:
    int[] arreglo = new int[5];
    //tipodearreglo[] nombre = new tipodearreglo[dimension];
    //se trabaja de la misma manera:
    arreglo[0] = 5;
    //arreglo = {5,3,2};
    }
}