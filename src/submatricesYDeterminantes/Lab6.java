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
//Crean una estructura de class Lab6, con atributos: maxFil, maxCol,
//        cantFil, cantCol, elem[][]. Implementar métodos constructores,
//        toString() de una matriz y los siguientes métodos:
    
public class Lab6 {
    
    private int maxFil; 
    private int maxCol; 
    private int cantFil; 
    private int cantCol; 
    private int[][] elem; 
    private LinkedList<Lab6> subMatricesEncontradas;
    
    public Lab6(int filas, int columnas) { 
        this.maxFil = filas; 
        this.maxCol = columnas; 
        this.cantFil = filas; 
        this.cantCol = columnas; 
        this.elem = new int[filas][columnas]; 
        this.subMatricesEncontradas = new LinkedList<>();
    }
    
    public Lab6(int maxFil, int maxCol, int[][] elementos) {
        this.maxFil = maxFil;
        this.maxCol = maxCol;
        this.cantFil = maxFil;
        this.cantCol = maxCol;
        this.elem = new int[maxFil][maxCol];
        this.subMatricesEncontradas = new LinkedList<>();
        // Copiar los elementos pasados al constructor
        for (int i = 0; i < maxFil; i++) {
            for (int j = 0; j < maxCol; j++) {
                this.elem[i][j] = elementos[i][j];
            }
        }
    }
    
    //Constructor copia
    public Lab6(Lab6 M1) {
        this.cantFil = M1.cantFil;
        this.cantCol = M1.cantCol;
        this.maxCol = M1.maxCol;
        this.maxFil = M1.maxFil;

        this.elem = new int[M1.cantFil][M1.cantCol];
        this.subMatricesEncontradas = new LinkedList<>();
        for (int i = 0; i < M1.cantFil; i++) {
            for (int j = 0; j < M1.cantCol; j++) {
                this.elem[i][j] = M1.elem[i][j];
            }
        }
    }
    
//1. M1.toString() : Método que devuelve una cadena de caracteres
//        que representa los elementos de la matriz. .
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
    
//2. M1.generarElem(a, b) : Método que genera elementos enteros
//        entre a y b inclusive en la matriz M1. La  cantidad de
//        elementos generados es igual a la dimensión interna de la matriz.
    public void generarElem(int a, int b) { 
        Random rand = new Random(); 
        for (int i = 0; i < cantFil; i++) { 
            for (int j = 0; j < cantCol; j++) { 
                elem[i][j] = rand.nextInt(b - a + 1) + a; 
            } 
        } 
    }
    
//3. encontrarSubMatr(M1, L1) : Procedimiento que encuentra todas
//        las subMatrices de la matriz M1, en la Lista de Matrices L1.
     // Método para verificar si `subMat` es una submatriz de `M1`
   public void encontrarSubLab6(LinkedList<Lab6> L1) {
        subMatricesEncontradas.clear(); // Limpiar la lista antes de encontrar nuevas submatrices

        for (Lab6 matriz : L1) {
            if (esSubmatriz(matriz)) {
                subMatricesEncontradas.add(matriz);
            }
        }
    }

    // Método privado para verificar si `subMat` es una submatriz de la matriz actual
    private boolean esSubmatriz(Lab6 subMat) {
        if (subMat.cantFil > this.cantFil || subMat.cantCol > this.cantCol) {
            return false; // La submatriz no puede ser más grande que la matriz principal
        }
        
        for (int i = 0; i <= this.cantFil - subMat.cantFil; i++) {
            for (int j = 0; j <= this.cantCol - subMat.cantCol; j++) {
                if (esIgual(subMat, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método privado para verificar si una submatriz empieza en la posición (startRow, startCol)
    private boolean esIgual(Lab6 subMat, int startRow, int startCol) {
        for (int i = 0; i < subMat.cantFil; i++) {
            for (int j = 0; j < subMat.cantCol; j++) {
                if (this.elem[startRow + i][startCol + j] != subMat.elem[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Getter para obtener las submatrices encontradas
    public LinkedList<Lab6> getSubMatricesEncontradas() {
        return subMatricesEncontradas;
    }
//4. M1.mostrarSubMat() : Método que nuestra todas las submatrices de la matriz M1.
    public void mostrarSubMat() {
        if (subMatricesEncontradas.isEmpty()) {
            System.out.println("No se encontraron submatrices.");
        } else {
            System.out.println("Submatrices encontradas:");
            for (Lab6 subMatriz : subMatricesEncontradas) {
                System.out.println(subMatriz);
                System.out.println(); // Línea en blanco entre matrices
            }
        }
    }
//5. M1.mostrarSubMat(n, m) : Método que nuestra todas las submatrices
//        de n-filas y m-columnas de la matriz M1.
     public void mostrarSubMat(int n, int m) {
        if (n > this.cantFil || m > this.cantCol) {
            System.out.println("Las dimensiones de la submatriz son mayores que las dimensiones de la matriz principal.");
            return;
        }

        boolean encontrado = false;

        for (int i = 0; i <= this.cantFil - n; i++) {
            for (int j = 0; j <= this.cantCol - m; j++) {
                Lab6 subMatriz = obtenerSubmatriz(i, j, n, m);
                if (subMatriz != null) {
                    System.out.println("Submatriz en posición (" + i + ", " + j + "):");
                    System.out.println(subMatriz);
                    System.out.println(); // Línea en blanco entre matrices
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron submatrices de tamaño " + n + " x " + m + ".");
        }
    }
     
    private Lab6 obtenerSubmatriz(int startRow, int startCol, int n, int m) {
        int[][] subElem = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                subElem[i][j] = this.elem[startRow + i][startCol + j];
            }
        }
        return new Lab6(n, m, subElem);
    }

    public static void main(String[] args) {
        Lab6 matriz = new Lab6(4, 4);
        LinkedList<Lab6> L1 = new LinkedList<>();
        LinkedList<Lab6> L2 = new LinkedList<>();
        LinkedList<Lab6> L3 = new LinkedList<>();
//        matriz.generarElem(1, 5);
        
        int[][] datosMatriz1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        int[][] datosMatriz2 = {
            {6, 7},
            {10, 11}
        };
        
        int[][] datosMatriz3 = {
            {2, 3},
            {6, 7}
        };
        
        int[][] datosMatriz4 = {
            {3, 2},
            {5, 6}
        };
        
        // Crear instancias de Lab6
        Lab6 matrizPrincipal = new Lab6(3, 4, datosMatriz1);
        Lab6 subMatriz1  = new Lab6(2, 2, datosMatriz2);
        Lab6 subMatriz2  = new Lab6(2, 2, datosMatriz3);
        Lab6 subMatriz3  = new Lab6(2, 2, datosMatriz4);
        
        System.out.println(matrizPrincipal);
        System.out.println(subMatriz1);
        System.out.println(subMatriz2);
        System.out.println(subMatriz3);      
        
        // Crear lista de matrices
        LinkedList<Lab6> listaDeMatrices = new LinkedList<>();
         listaDeMatrices.add(subMatriz1);
        listaDeMatrices.add(subMatriz2);
        listaDeMatrices.add(subMatriz3);

        // Encontrar submatrices
        matrizPrincipal.encontrarSubLab6(listaDeMatrices);

        // Mostrar submatrices encontradas
        System.out.println("Submatrices encontradas:");
        for (Lab6 matrices : matrizPrincipal.getSubMatricesEncontradas()) {
            System.out.println(matrices);
        }
        
        // Mostrar submatrices encontradas
        matrizPrincipal.mostrarSubMat();
        
        matrizPrincipal.mostrarSubMat(2, 2);
        
    }
}
