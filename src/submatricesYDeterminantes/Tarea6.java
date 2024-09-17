/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package submatricesYDeterminantes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author megus
 */

//Crear una estructura de class Matriz, con atributos:
//        maxFil, maxCol, cantFil, cantCol, elem[][]. 
//        Implementar métodos constructores, toString() de una matriz y los siguientes métodos:

public class Tarea6 {
    private int maxFil;
    private int maxCol;
    private int cantFil;
    private int cantCol;
    private int[][] elem;

    // Atributo para almacenar submatrices encontradas
    private LinkedList<Tarea6> subMatricesEncontradas;

    // Constructor
    public Tarea6(int maxFil, int maxCol) {
        this.maxFil = maxFil;
        this.maxCol = maxCol;
        this.cantFil = 0;
        this.cantCol = 0;
        this.elem = new int[maxFil][maxCol];
        this.subMatricesEncontradas = new LinkedList<>();
    }
    
//1. M1.toString() : Método que devuelve una cadena de caracteres
//        que representa los elementos de la matriz.
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
        for (int i = 0; i < maxFil; i++) {
            for (int j = 0; j < maxCol; j++) {
                elem[i][j] = rand.nextInt(b - a + 1) + a;
            }
        }
        this.cantFil = maxFil;
        this.cantCol = maxCol;
    }
    
//3. encontrarSubMatr(M1, L1) : Procedimiento que encuentra todas
//        las subMatrices de la matriz M1, en la Lista de Matrices L1.
     public void encontrarSubMatr(LinkedList<Tarea6> L1) {
        subMatricesEncontradas.clear(); // Limpiar la lista antes de añadir nuevas submatrices
        for (Tarea6 M2 : L1) {
            if (esSubMatriz(this, M2)) {
                subMatricesEncontradas.add(M2);
            }
        }
    }

    // Método auxiliar para verificar si M2 es submatriz de M1
    private static boolean esSubMatriz(Tarea6 M1, Tarea6 M2) {
        if (M2.cantFil > M1.cantFil || M2.cantCol > M1.cantCol) {
            return false;
        }

        for (int i = 0; i <= M1.cantFil - M2.cantFil; i++) {
            for (int j = 0; j <= M1.cantCol - M2.cantCol; j++) {
                if (esIgualSubmatriz(M1, M2, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método auxiliar para verificar si M2 es igual a una submatriz de M1 en la posición (startFil, startCol)
    private static boolean esIgualSubmatriz(Tarea6 M1, Tarea6 M2, int startFil, int startCol) {
        for (int i = 0; i < M2.cantFil; i++) {
            for (int j = 0; j < M2.cantCol; j++) {
                if (M1.elem[startFil + i][startCol + j] != M2.elem[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

//4. M1.mostrarSubMat() : Método que nuestra todas las submatrices de la matriz M1.
    public void mostrarSubMat() {
        for (int i = 0; i <= cantFil - 1; i++) {
            for (int j = 0; j <= cantCol - 1; j++) {
                for (int subFil = 1; subFil <= cantFil - i; subFil++) {
                    for (int subCol = 1; subCol <= cantCol - j; subCol++) {
                        Tarea6 subM = new Tarea6(subFil, subCol);
                        for (int x = 0; x < subFil; x++) {
                            for (int y = 0; y < subCol; y++) {
                                subM.elem[x][y] = elem[i + x][j + y];
                            }
                        }
                        subM.cantFil = subFil;
                        subM.cantCol = subCol;
                        System.out.println(subM);
                    }
                }
            }
        }
    }
    
    public LinkedList<Tarea6> getSubMatricesEncontradas() {
        return subMatricesEncontradas;
    }
    
//5. M1.mostrarSubMat(n, m) : Método que nuestra todas las submatrices
//        de n-filas y m-columnas de la matriz M1.
    public void mostrarSubMat(int n, int m) {
        if (n > cantFil || m > cantCol) {
            System.out.println("Las dimensiones de la submatriz exceden las dimensiones de la matriz principal.");
            return;
        }
        for (int i = 0; i <= cantFil - n; i++) {
            for (int j = 0; j <= cantCol - m; j++) {
                Tarea6 subM = new Tarea6(n, m);
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        subM.elem[x][y] = elem[i + x][j + y];
                    }
                }
                subM.cantFil = n;
                subM.cantCol = m;
                System.out.println(subM);
            }
        }
    }
    
//6. mostrarFila(L1) : Procedimiento que muestra las matrices fila de la Lista de Matrices L1
     public static void mostrarFila(LinkedList<Tarea6> L1) {
        for (Tarea6 M : L1) {
            if (M.cantFil == 1) {
                System.out.println(M);
            }
        }
    }
     
//7. mostrarColumna(L1) : Procedimiento que muestra las matrices columna de la Lista de Matrices L1.
    public static void mostrarColumna(LinkedList<Tarea6> L1) {
        for (Tarea6 M : L1) {
            if (M.cantCol == 1) {
                System.out.println(M);
            }
        }
    }
     
//8. mostrarIguales(L1) : Procedimiento que muestra las matrices
//        de la Lista de matrices L1,  dónde todos los elementos son iguales.
    public static void mostrarIguales(LinkedList<Tarea6> L1) {
        for (Tarea6 M : L1) {
            if (todosElementosIguales(M)) {
                System.out.println(M);
            }
        }
    }
    
    private static boolean todosElementosIguales(Tarea6 M) {
        int valor = M.elem[0][0];
        for (int i = 0; i < M.cantFil; i++) {
            for (int j = 0; j < M.cantCol; j++) {
                if (M.elem[i][j] != valor) {
                    return false;
                }
            }
        }
        return true;
    }
//9. mostrarDiferentes(L1) : Procedimiento que muestra las matrices
//        de la Lista de matrices L1,  dónde todos los elementos son diferentes.
    public static void mostrarDiferentes(LinkedList<Tarea6> L1) {
        for (Tarea6 M : L1) {
            if (todosElementosDiferentes(M)) {
                System.out.println(M);
            }
        }
    }
    
    private static boolean todosElementosDiferentes(Tarea6 M) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < M.cantFil; i++) {
            for (int j = 0; j < M.cantCol; j++) {
                if (seen.contains(M.elem[i][j])) {
                    return false; // Encontrado un elemento repetido
                }
                seen.add(M.elem[i][j]);
            }
        }
        return true; // Todos los elementos son diferentes
    }
    
//10. mostrarPositivos(L1) : Procedimiento que muestra las matrices
//        de la Lista de matrices L1,  dónde todos los elementos son positivos.
    public static void mostrarPositivos(LinkedList<Tarea6> L1) {
        for (Tarea6 M : L1) {
            if (todosElementosPositivos(M)) {
                System.out.println(M);
            }
        }
    }
    
    private static boolean todosElementosPositivos(Tarea6 M) {
        for (int i = 0; i < M.cantFil; i++) {
            for (int j = 0; j < M.cantCol; j++) {
                if (M.elem[i][j] <= 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
//11. mostrarNegativos(L1) : Procedimiento que muestra las matrices
//        de la Lista de matrices L1,  dónde todos los elementos son negativos.
    public static void mostrarNegativos(LinkedList<Tarea6> L1) {
        for (Tarea6 M : L1) {
            if (todosElementosNegativos(M)) {
                System.out.println(M);
            }
        }
    }
    
    private static boolean todosElementosNegativos(Tarea6 M) {
        for (int i = 0; i < M.cantFil; i++) {
            for (int j = 0; j < M.cantCol; j++) {
                if (M.elem[i][j] >= 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
//12. moyorSuma(L1) : Procedimiento que muestra las matrices de la
//        Lista de matrices L1, que tengan la mayor suma de entre todas las matrices. Asumir, que los elementos pueden ser elementos positivos y negativos.
      public static void mayorSuma(LinkedList<Tarea6>  L1) {
        Tarea6 mayor = null;
        int sumaMaxima = Integer.MIN_VALUE;
        for (Tarea6 M : L1) {
            int suma = sumaElementos(M);
            if (suma > sumaMaxima) {
                sumaMaxima = suma;
                mayor = M;
            }
        }
        if (mayor != null) {
            System.out.println("Matriz con la mayor suma:");
            System.out.println(mayor);
        }
    }
      
//13. menorSuma(L1) : Procedimiento que muestra las matrices de la
//        Lista de matrices L1, que tengan la menor suma de entre 
//        todas las matrices. Asumir, que los elementos pueden ser elementos positivos y negativos.
      public static void menorSuma(LinkedList<Tarea6> L1) {
        Tarea6 menor = null;
        int sumaMinima = Integer.MAX_VALUE;
        for (Tarea6 M : L1) {
            int suma = sumaElementos(M);
            if (suma < sumaMinima) {
                sumaMinima = suma;
                menor = M;
            }
        }
        if (menor != null) {
            System.out.println("Matriz con la menor suma:");
            System.out.println(menor);
        }
    }
      
    private static int sumaElementos(Tarea6 M) {
        int suma = 0;
        for (int i = 0; i < M.cantFil; i++) {
            for (int j = 0; j < M.cantCol; j++) {
                suma += M.elem[i][j];
            }
        }
        return suma;
    }
    
//14. Incluir al menos 5 consultas cualesquiera interesantes . . 
    public static void main(String[] args) {
        // Crear algunas matrices de ejemplo
        Tarea6 M1 = new Tarea6(4, 4);
        Tarea6 M2 = new Tarea6(2, 2);
        Tarea6 M3 = new Tarea6(3, 3);
        Tarea6 M4 = new Tarea6(1, 1);
        Tarea6 M5 = new Tarea6(3, 3);

        // Generar elementos aleatorios en las matrices
        M1.generarElem(-5, 5);
        M2.generarElem(-10, 10);
        M3.generarElem(1, 20);
        M4.generarElem(-3, -1);
        M5.generarElem(-5, 5);

        // Mostrar matrices
        System.out.println("Matriz M1:");
        System.out.println(M1);
        System.out.println("Matriz M2:");
        System.out.println(M2);
        System.out.println("Matriz M3:");
        System.out.println(M3);
        System.out.println("Matriz M4:");
        System.out.println(M4);
        System.out.println("Matriz M5:");
        System.out.println(M5);

        // Crear una lista de matrices para pruebas
        LinkedList<Tarea6> listaMatrices = new LinkedList<>();
        listaMatrices.add(M1);
        listaMatrices.add(M2);
        listaMatrices.add(M3);
        listaMatrices.add(M4);
        listaMatrices.add(M5);

        // Probar métodos

        // Mostrar todas las submatrices de M1
        System.out.println("Submatrices de M1:");
        M1.mostrarSubMat();

        // Mostrar todas las submatrices de dimensiones 2x2 de M1
        System.out.println("Submatrices 2x2 de M1:");
        M1.mostrarSubMat(2, 2);

        // Encontrar submatrices de M1 en la lista de matrices
        M1.encontrarSubMatr(listaMatrices);
        System.out.println("Submatrices encontradas en la lista:");
        for (Tarea6 subMatriz : M1.getSubMatricesEncontradas()) {
            System.out.println(subMatriz);
        }

        // Mostrar matrices fila
        System.out.println("Matrices fila:");
        mostrarFila(listaMatrices);

        // Mostrar matrices columna
        System.out.println("Matrices columna:");
        mostrarColumna(listaMatrices);

        // Mostrar matrices con todos los elementos iguales
        System.out.println("Matrices con todos los elementos iguales:");
        mostrarIguales(listaMatrices);

        // Mostrar matrices con todos los elementos diferentes
        System.out.println("Matrices con todos los elementos diferentes:");
        mostrarDiferentes(listaMatrices);

        // Mostrar matrices con todos los elementos positivos
        System.out.println("Matrices con todos los elementos positivos:");
        mostrarPositivos(listaMatrices);

        // Mostrar matrices con todos los elementos negativos
        System.out.println("Matrices con todos los elementos negativos:");
        mostrarNegativos(listaMatrices);

        // Mostrar la matriz con la mayor suma
        System.out.println("Matriz con la mayor suma:");
        mayorSuma(listaMatrices);

        // Mostrar la matriz con la menor suma
        System.out.println("Matriz con la menor suma:");
        menorSuma(listaMatrices);
    }
}
