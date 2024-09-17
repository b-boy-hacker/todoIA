/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package submatricesYDeterminantes;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author megus
 */

//El algoritmo para encontrar el determinando de una matriz de n x n, 
//utiliza la estructura de código de llamada recursiva dentro de un ciclo:

public class Tarea7Matriz {
//1. Definir una representación de clase Matriz, con atributos de:
//elem[][], cantFil, cantCol, maxFil, maxCol, . . . 
//Implementar constructor copia y otros métodos estándares para manipular una matriz.
    private int maxFil; 
    private int maxCol; 
    private int cantFil; 
    private int cantCol; 
    private int[][] elem; 
 
    // Constructor 
    public Tarea7Matriz(int filas, int columnas) { 
        this.maxFil = filas; 
        this.maxCol = columnas; 
        this.cantFil = filas; 
        this.cantCol = columnas; 
        this.elem = new int[filas][columnas]; 
    }
    
    //Constructor copia
    public Tarea7Matriz(Tarea7Matriz M1) {
        this.cantFil = M1.cantFil;
        this.cantCol = M1.cantCol;
        this.maxCol = M1.maxCol;
        this.maxFil = M1.maxFil;

        this.elem = new int[M1.cantFil][M1.cantCol];

        for (int i = 0; i < M1.cantFil; i++) {
            for (int j = 0; j < M1.cantCol; j++) {
                this.elem[i][j] = M1.elem[i][j];
            }
        }
    }
    
    
     
//2. M1.toString() : Método standard que devuelve en cadena, los elementos de la matriz M1.
    @Override 
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < cantFil; i++) { 
            for (int j = 0; j < cantCol; j++) { 
                sb.append(elem[i][j]).append(" "); 
            } 
            sb.append("\n"); 
        } 
        return sb.toString(); 
    }
    
//3. M1.eliminarFil(k) : Método que elimina la fila k, de la matriz M1.
//        Se deben desplazar las filas posteriores a la fila k,para cubrir
//        las filas eliminadas y decrementar la cantidad de filas.
    public void eliminarFil(int k){ 
        for (int i = k + 1; i < this.cantFil; i++) { 
            for (int j = 0; j < this.cantCol; j++) { 
                this.elem[i - 1][j] = this.elem[i][j]; 
                 
            } 
             
        } 
        this.cantFil--; 
    }
    
//4. M1.eliminarCol(k):  Método que elimina la columna k, de la matriz M1.
//        Se deben desplazar las columnas posteriores a la columna k, 
//        para cubrir las columnas eliminadas y decrementar la cantidad de columnas.
    public void eliminarCol(int k){ 
        for (int i = 0; i < this.cantFil; i++) { 
            for (int j = k + 1; j < this.cantCol; j++) { 
                this.elem[i][j - 1] = this.elem[i][j]; 
                 
            } 
             
        } 
        this.cantCol--; 
    }
    
//5. M1.generarRandom(a, b) : Método que genera n x m elementos
//        aleatorios entre a y b, inclusive en la matriz M1.
    public void generarElem(int a, int b) { 
        Random rand = new Random(); 
        for (int i = 0; i < cantFil; i++) { 
            for (int j = 0; j < cantCol; j++) { 
                elem[i][j] = rand.nextInt(b - a + 1) + a; 
            } 
        } 
    }
    
//6. det(M1) : Función que devuelve la determinando de la matriz cuadrada M1,
//    de elementos enteros.
    public static int det(Tarea7Matriz M){ 
        if (M.cantFil == 1) { 
            return M.elem[0][0];              
        } 
        int i, j, sum; 
        i = 0; j = 0; sum = 0; 
        while(i < M.cantFil){ 
            sum = sum + (signo(i, j) * M.elem[i][j] * det(M.menor(i, j))); 
            i = i + 1; 
        } 
        return sum; 
         
    }
    
     public static int signo(int i, int j){ 
        int k = i + j; 
        if (k % 2 == 0) { 
            return 1;              
        }else{ 
            return -1; 
        }          
    } 
     
    public Tarea7Matriz menor(int i, int j){ 
        Tarea7Matriz M1 = new Tarea7Matriz(this); 
        M1.eliminarFil(i); 
        M1.eliminarCol(j); 
        return M1; 
    } 
    
//7. encontrarMenores(M1, L1) : Procedimiento que encuentra en la Lista de Matrices L1,
//        todas las matrices menores derivados de la matriz M1.
    public void encontrarMenores(Tarea7Matriz M1, LinkedList<Tarea7Matriz> L1) {
        // Recorremos todas las posibles combinaciones de fila y columna
        for (int i = 0; i < M1.cantFil; i++) {
            for (int j = 0; j < M1.cantCol; j++) {
                // Generamos la matriz menor eliminando la fila i y columna j
                Tarea7Matriz menor = M1.menor(i, j);
                // Añadimos la matriz menor a la lista L1
                L1.add(menor);
            }
        }
    }
    
//8. consulta(L1): Hacer algunas  consultas interesantes a la Lista de Matrices Menores,
//        encontrados previamente en L1.
    // Método para encontrar la matriz con el determinante mayor en una lista de matrices menores
    // Método para encontrar la matriz con el determinante mayor en una lista de matrices menores
    public static Tarea7Matriz matrizDeterminanteMayor(LinkedList<Tarea7Matriz> L1) {
        Tarea7Matriz maxMatriz = null;  // Almacenará la matriz con el determinante mayor
        int maxDet = Integer.MIN_VALUE;  // Inicializamos con el menor valor posible
        for (Tarea7Matriz m : L1) {
            int det = Tarea7Matriz.det(m);  // Calculamos el determinante de la matriz actual
            if (det > maxDet) {
                maxDet = det;  // Actualizamos si encontramos un determinante mayor
                maxMatriz = m;  // Guardamos la matriz que tiene el mayor determinante
            }
        }
        return maxMatriz;  // Devolvemos la matriz con el determinante mayor
    } 
    
//9. matricesComues(L1, L2, L3) : Procedimiento que encuentra en L3, 
//    las matrices comunes de L1 y L2.
//L1 = Lista de subMatrices de M1.
//L2 = Lista de matrices menores de M1.
    // Método para obtener una submatriz desde (filaInicio, colInicio) hasta (filaFin, colFin)
    public Tarea7Matriz submatriz(int filaInicio, int colInicio, int filaFin, int colFin) {
        Tarea7Matriz sub = new Tarea7Matriz(filaFin - filaInicio + 1, colFin - colInicio + 1);
        for (int i = filaInicio; i <= filaFin; i++) {
            for (int j = colInicio; j <= colFin; j++) {
                sub.elem[i - filaInicio][j - colInicio] = this.elem[i][j];
            }
        }
        return sub;
    }
    
    // Método para generar todas las submatrices y añadirlas a L1
    
    public void generarSubmatrices(LinkedList<Tarea7Matriz> L1) {
        for (int filaInicio = 0; filaInicio < cantFil; filaInicio++) {
            for (int colInicio = 0; colInicio < cantCol; colInicio++) {
                for (int filaFin = filaInicio; filaFin < cantFil; filaFin++) {
                    for (int colFin = colInicio; colFin < cantCol; colFin++) {
                        L1.add(submatriz(filaInicio, colInicio, filaFin, colFin));
                    }
                }
            }
        }
    }
    
    // Método para comparar si dos matrices son iguales
    public static boolean sonIguales(Tarea7Matriz m1, Tarea7Matriz m2) {
        if (m1.cantFil != m2.cantFil || m1.cantCol != m2.cantCol) {
            return false;
        }
        for (int i = 0; i < m1.cantFil; i++) {
            for (int j = 0; j < m1.cantCol; j++) {
                if (m1.elem[i][j] != m2.elem[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Procedimiento que encuentra las matrices comunes entre L1 y L2 y las añade a L3
    public static void matricesComunes(LinkedList<Tarea7Matriz> L1,
            LinkedList<Tarea7Matriz> L2, LinkedList<Tarea7Matriz> L3) {
        for (Tarea7Matriz submatriz : L1) {
            for (Tarea7Matriz menor : L2) {
                if (sonIguales(submatriz, menor)) {
                    L3.add(submatriz);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Tarea7Matriz matriz = new Tarea7Matriz(4, 4);
        LinkedList<Tarea7Matriz> L1 = new LinkedList<>();
        LinkedList<Tarea7Matriz> L2 = new LinkedList<>();
        LinkedList<Tarea7Matriz> L3 = new LinkedList<>();
        matriz.generarElem(1, 5);
        System.out.println(matriz.toString());
//        System.out.println(matriz.det(matriz));
//        matriz.encontrarMenores(matriz, L1);
//        for (Tarea7Matriz menor : L1) {
//            System.out.println(menor);
//        }
        
        // Encontrar la matriz con el determinante mayor
//        Tarea7Matriz matrizConDetMayor = Tarea7Matriz.matrizDeterminanteMayor(L1);

        // Imprimir la matriz con el determinante mayor
        System.out.println("La matriz con el determinante mayor es:");
//        System.out.println(matrizConDetMayor);
        
        // Encontrar las matrices comunes entre L1 y L2
        Tarea7Matriz.matricesComunes(L1, L2, L3);

        // Imprimir las matrices comunes
        System.out.println("Matrices comunes:");
        for (Tarea7Matriz m : L3) {
            System.out.println(m);
        }
        
//        matriz.eliminarFil(0);        
//        System.out.println(matriz.toString());

    }
}
