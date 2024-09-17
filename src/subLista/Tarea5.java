/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subLista;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author megus
 */
public class Tarea5 {
//1. generarElem(L1, n, a, b) : Procedimiento que genera n elementos
//        aleatorios en la Lista L1, con valores enteros entre a y b inclusive.
    public static void generarElem(LinkedList<Integer> L1, int n, int a, int b) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            L1.add(rand.nextInt(b - a + 1) + a);
        }
    }
    
//2. encontrarSubListas(L1, L2) : Procedimiento que encuentra todas las subListas de L1 en L2.
    public static void encontrarSubListas(LinkedList<Integer> L1, LinkedList<Integer> L2, LinkedList<LinkedList<Integer>> result) {
        for (int i = 0; i <= L2.size() - L1.size(); i++) {
            LinkedList<Integer> sublist = new LinkedList<>();
            boolean match = true;
            for (int j = 0; j < L1.size(); j++) {
                if (!L2.get(i + j).equals(L1.get(j))) {
                    match = false;
                    break;
                }
                sublist.add(L2.get(i + j));
            }
            if (match) {
                result.add(sublist);
            }
        }
    }

    // Método para mostrar el contenido de una lista de listas
    public static void mostrarSubListas(LinkedList<LinkedList<Integer>> result) {
        if (result.isEmpty()) {
            System.out.println("No se encontraron sublistas.");
        } else {
            System.out.println("Sublistas encontradas:");
            for (LinkedList<Integer> sublist : result) {
                System.out.println(sublist);
            }
        }
    }
    
//3. mostrarIguales(L2) : Procedimiento que muestra todas las subListas con iguales elementos.
    public static boolean todosIguales(LinkedList<Integer> lista) {
        if (lista.isEmpty()) {
            return false;
        }

        int primerElemento = lista.get(0);  // Obtener el primer elemento de la sublista
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i) != primerElemento) {
                return false;  // Si algún elemento es diferente, no son todos iguales
            }
        }
        return true;  // Todos los elementos son iguales
    }

    // Método que muestra todas las sublistas con elementos iguales
    public static void mostrarIguales(LinkedList<LinkedList<Integer>> L2) {
        boolean found = false;
        System.out.println("Sublistas con todos los elementos iguales:");

        for (LinkedList<Integer> subLista : L2) {
            if (todosIguales(subLista)) {
                System.out.println(subLista);  // Mostrar la sublista si todos sus elementos son iguales
                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontraron sublistas con todos los elementos iguales.");
        }
    }
    
//4. mostrarDif(L2) : Procedimiento que muestra todas las subListas con elementos todos diferentes.
    public static boolean todosDiferentes(LinkedList<Integer> lista) {
        HashSet<Integer> set = new HashSet<>();  // Usamos un conjunto para verificar duplicados

        for (int elemento : lista) {
            if (set.contains(elemento)) {
                return false;  // Si el elemento ya está en el conjunto, no son todos diferentes
            }
            set.add(elemento);  // Agregar el elemento al conjunto
        }
        return true;  // Todos los elementos son diferentes
    }

    // Método que muestra todas las sublistas con elementos diferentes
    public static void mostrarDif(LinkedList<LinkedList<Integer>> L2) {
        boolean found = false;
        System.out.println("Sublistas con todos los elementos diferentes:");

        for (LinkedList<Integer> subLista : L2) {
            if (todosDiferentes(subLista)) {
                System.out.println(subLista);  // Mostrar la sublista si todos sus elementos son diferentes
                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontraron sublistas con todos los elementos diferentes.");
        }
    }
    
//5. mostrarAsc(L2) : Procedimiento que muestra todas las subListas 
//        con la secuencia de elementos ordenados de menor a mayor.
    // Método que verifica si los elementos de la sublista están en orden ascendente
    public static boolean estaOrdenadaAsc(LinkedList<Integer> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            if (lista.get(i) > lista.get(i + 1)) {
                return false;  // Si algún elemento es mayor que el siguiente, no está en orden ascendente
            }
        }
        return true;  // Si todos los elementos cumplen la condición, están en orden ascendente
    }

    // Método que muestra todas las sublistas que están en orden ascendente
    public static void mostrarAsc(LinkedList<LinkedList<Integer>> L2) {
        boolean found = false;
        System.out.println("Sublistas en orden ascendente:");

        for (LinkedList<Integer> subLista : L2) {
            if (estaOrdenadaAsc(subLista)) {
                System.out.println(subLista);  // Mostrar la sublista si está en orden ascendente
                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontraron sublistas en orden ascendente.");
        }
    }
    
//6. mostrarDes(L2) : Procedimiento que muestra todas las subListas 
//        con la secuencia de elementos ordenados de mayor a menor.

//7. mostrarLong(L2, k) : Procedimiento que muestra todas las subListas de longitud k.

//8. mostrarPositivos(L2) : Procedimiento que muestra todas las subListas
//        dónde sus elementos son todos positivos.

//9. mostrarNegativos(L2) : Procedimiento que muestra todas las subListas
//        dónde sus elementos son todos negativos.

//10. mostrarPosNeg(L2): Procedimiento que muestra todas las subListas
//        dónde sus elementos están formados por elementos positivos y elementos negativos.

//11. mejorSuma(L2): Procedimiento que muestra las subListas de L2, que
//        tengan la mayor suma de sus elementos. Asumir que los elementos
//        de las subListas son enteros positivos y negativos.

//12. Adicionar al menos 5 funciones y/o procedimientos adicionales interesantes.
    public static void main(String[] args) {
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();
        LinkedList<LinkedList<Integer>> L3 = new LinkedList<>();
        int n = 5;
        int a = 1;
        int b = 5;
//        generarElem(L1, n, a, b);

        // Agregar algunos elementos a L1
        L1.add(3);
        L1.add(6);

        // Generar una lista L2 con algunos elementos
        L2.add(1);
        L2.add(3);
        L2.add(6);
        L2.add(3);
        L2.add(6);
        L2.add(9);
        
         // Agregar algunas sublistas a L2
        LinkedList<Integer> subLista1 = new LinkedList<>();
        subLista1.add(3);
        subLista1.add(3);
        subLista1.add(3);

        LinkedList<Integer> subLista2 = new LinkedList<>();
        subLista2.add(1);
        subLista2.add(9);
        subLista2.add(6);

        LinkedList<Integer> subLista3 = new LinkedList<>();
        subLista3.add(2);
        subLista3.add(2);

        // Agregar las sublistas a L2
        L3.add(subLista1);
        L3.add(subLista2);
        L3.add(subLista3);
//        System.out.println(L1);
//        System.out.println(L2);
        System.out.println(subLista1);
        System.out.println(subLista2);
        System.out.println(subLista3);
        // Llamar a mostrarIguales para mostrar las sublistas con elementos iguales
        mostrarIguales(L3);
        mostrarDif(L3);
        mostrarAsc(L3);
        // Llamar a encontrarSubListas para buscar las sublistas de L1 en L2
//        encontrarSubListas(L1, L2, L3);

        // Mostrar las sublistas encontradas
//        mostrarSubListas(L3);      
        
    }
}
