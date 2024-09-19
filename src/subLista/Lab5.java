/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subLista;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author megus
 */

//CONSULTAS SOBRE UNA SUBLISTA.

public class Lab5 {
    
//1. generarElem(L1, n, a, b) : Procedimiento que genera n elementos
//    aleatorios en la Lista L1, con valores enteros entre a y b inclusive.
    public static void generarElem(LinkedList<Integer> L1, int n, int a, int b) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            L1.add(rand.nextInt(b - a + 1) + a);
        }
    }
    
//2. encontrarSubListas(L1, L2) : Procedimiento que encuentra todas las subListas de L1 en L2.
    public static void encontrarSubListas(LinkedList<Integer> L1, LinkedList<Integer> L2) {
        boolean found = false;
        for (int i = 0; i < L1.size(); i++) {
            for (int j = i + 1; j <= L1.size(); j++) {
                LinkedList<Integer> subLista = new LinkedList<>(L1.subList(i, j));
                if (containsSubList(L2, subLista)) {
                    System.out.println("Sublista encontrada: " + subLista);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No se encontraron sublistas de L1 en L2.");
        }
    }
    
    // Método auxiliar para verificar si L2 contiene la sublista
    private static boolean containsSubList(LinkedList<Integer> L2, LinkedList<Integer> subLista) {
        for (int i = 0; i <= L2.size() - subLista.size(); i++) {
            if (L2.subList(i, i + subLista.size()).equals(subLista)) {
                return true;
            }
        }
        return false;
    }
    
    public static void mostrarSubListas(LinkedList<Integer> L1){
        for (int i = 0; i < L1.size(); i++) {
            for (int j = i+1; j <= L1.size(); j++) {
                System.out.println(L1.subList(i, j));
            }
        }
    }
        
//3. mostrarIguales(L2) : Procedimiento que muestra todas las subListas con iguales elementos.
    public static void mostrarIguales(LinkedList<Integer> L2) {
        boolean found = false;
        for (int i = 0; i < L2.size(); i++) {
            for (int j = i + 1; j <= L2.size(); j++) {
                LinkedList<Integer> subLista = new LinkedList<>(L2.subList(i, j));
                if (todosIguales(subLista)) {
                    System.out.println("Sublista con elementos iguales: " + subLista);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No se encontraron sublistas con elementos iguales.");
        }
    }

    // Método auxiliar para verificar si todos los elementos de una lista son iguales
    private static boolean todosIguales(LinkedList<Integer> lista) {
        if (lista.isEmpty()) return false;
        int primerElemento = lista.getFirst();
        for (int elemento : lista) {
            if (elemento != primerElemento) {
                return false;
            }
        }
        return true;
    }
    
    
//4. mostrarDif(L2) : Procedimiento que muestra todas las subListas con elementos todos diferentes.
    public static void mostrarDif(List<List<Integer>> L2) {
        for (List<Integer> subLista : L2) {
            Set<Integer> uniqueElements = new HashSet<>(subLista);
            if (uniqueElements.size() == subLista.size()) {
                System.out.println(subLista);
            }
        }
    }
    
//5. mostrarAsc(L2) : Procedimiento que muestra todas las subListas con 
//    la secuencia de elementos ordenados de menor a mayor.
     public static void mostrarAsc(LinkedList<LinkedList<Integer>> subListas) {
        boolean sublistasAscendentes = false;

        System.out.println("Sublistas con elementos en orden ascendente:");

        for (LinkedList<Integer> subLista : subListas) {
            if (esAscendente(subLista)) {
                System.out.println(subLista);
                sublistasAscendentes = true;
            }
        }

        // Si no se encontró ninguna sublista con elementos ascendentes
        if (!sublistasAscendentes) {
            System.out.println("No se encontraron sublistas en orden ascendente.");
        }
    }

    // Método que verifica si una sublista está en orden ascendente
    private static boolean esAscendente(LinkedList<Integer> subLista) {
        for (int i = 0; i < subLista.size() - 1; i++) {
            if (subLista.get(i) > subLista.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
     
//6. mostrarDes(L2) : Procedimiento que muestra todas las subListas
//    con la secuencia de elementos ordenados de mayor a menor.
      private static boolean esDescendente(LinkedList<Integer> subLista) {
        for (int i = 0; i < subLista.size() - 1; i++) {
            if (subLista.get(i) < subLista.get(i + 1)) {  // Cambiamos la condición para mayor a menor
                return false;
            }
        }
        return true;
    }
      
    public static void mostrarDes(LinkedList<LinkedList<Integer>> subListas) {
        boolean sublistasDescendentes = false;

        System.out.println("Sublistas con elementos en orden descendente:");

        for (LinkedList<Integer> subLista : subListas) {
            if (esDescendente(subLista)) {
                System.out.println(subLista);
                sublistasDescendentes = true;
            }
        }

        // Si no se encontró ninguna sublista con elementos descendentes
        if (!sublistasDescendentes) {
            System.out.println("No se encontraron sublistas en orden descendente.");
        }
    }  
    
//7. mostrarLong(L2, k) : Procedimiento que muestra todas las subListas de longitud k.
     public static void mostrarLong(LinkedList<LinkedList<Integer>> subListas, int k) {
        boolean sublistasDeLongitudK = false;

        System.out.println("Sublistas de longitud " + k + ":");

        for (LinkedList<Integer> subLista : subListas) {
            if (subLista.size() == k) {
                System.out.println(subLista);
                sublistasDeLongitudK = true;
            }
        }

        // Si no se encontró ninguna sublista de longitud k
        if (!sublistasDeLongitudK) {
            System.out.println("No se encontraron sublistas de longitud " + k + ".");
        }
    }

     
//8. mostrarPositivos(L2) : Procedimiento que muestra todas las 
//    subListas dónde sus elementos son todos positivos.
   public static void mostrarPositivos(LinkedList<LinkedList<Integer>> L2) {
        for (LinkedList<Integer> subLista : L2) {
            if (subLista.stream().allMatch(x -> x > 0)) {
                System.out.println(subLista);
            }
        }
    }
//9. mostrarNegativos(L2) : Procedimiento que muestra todas las 
//    subListas dónde sus elementos son todos negativos.
  public static void mostrarNegativos(LinkedList<LinkedList<Integer>> L2) {
        for (List<Integer> subLista : L2) {
            if (subLista.stream().allMatch(x -> x < 0)) {
                System.out.println(subLista);
            }
        }
    }
//10. mostrarPosNeg(L2): Procedimiento que muestra todas las subListas 
//    dónde sus elementos están formados por elementos positivos y elementos negativos.
  public static void mostrarPosNeg(LinkedList<LinkedList<Integer>>L2) {
        for (List<Integer> subLista : L2) {
            boolean hasPos = subLista.stream().anyMatch(x -> x > 0);
            boolean hasNeg = subLista.stream().anyMatch(x -> x < 0);
            if (hasPos && hasNeg) {
                System.out.println(subLista);
            }
        }
    }
//11. mejorSuma(L2): Procedimiento que muestra las subListas de L2, 
//    que tengan la mayor suma de sus elementos. Asumir que los elementos 
//            de las subListas son enteros positivos y negativos.
    public static int suma(LinkedList<Integer> lista) {
        int result = 0;
        for (int num : lista) {
            result += num;
        }
        return result;
    }

    // Método que muestra las sublistas con la mayor suma de sus elementos
    public static void mejorSuma(LinkedList<LinkedList<Integer>> L2) {
        int maxSum = Integer.MIN_VALUE;  // Inicializar con el valor más pequeño posible
        LinkedList<LinkedList<Integer>> subListasConMaxSuma = new LinkedList<>();

        // Primero, encontrar la mayor suma
        for (LinkedList<Integer> subLista : L2) {
            int currentSum = suma(subLista);
            if (currentSum > maxSum) {
                maxSum = currentSum;  // Actualizar la mayor suma encontrada
                subListasConMaxSuma.clear();  // Limpiar la lista de sublistas con la mayor suma
                subListasConMaxSuma.add(subLista);
            } else if (currentSum == maxSum) {
                subListasConMaxSuma.add(subLista);  // Agregar a la lista si la suma es igual a la mayor suma
            }
        }

        // Mostrar las sublistas con la mayor suma
        if (subListasConMaxSuma.isEmpty()) {
            System.out.println("No se encontraron sublistas.");
        } else {
            System.out.println("Sublistas con la mayor suma (" + maxSum + "):");
            for (LinkedList<Integer> subLista : subListasConMaxSuma) {
                System.out.println(subLista);
            }
        }
    }

    
    public static void main(String[] args){
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();
        LinkedList<LinkedList<Integer>> L3 = new LinkedList<>();
        int n = 5;
        int a = 1;
        int b = 5;
        
        L1.add(1);
        L1.add(2);
        L1.add(3);
        L1.add(4);
        
//        L2.add(1);
//        L2.add(2);
        L2.add(3);
        L2.add(4);
        L2.add(5);
        L2.add(6);
    
//        generarElem(L1, 2, 1, 20);
//        System.out.println("Lista generada: " + L1);
        System.out.println("L1 "+L1);
        System.out.println("L3 "+L2);
        mostrarSubListas(L1);    
        
//        generarElem(L1, 5, a, b);  // L1: Sublistas a buscar
//        generarElem(L2, 10, a, b);  // L2: Lista más grande en la que buscar

        System.out.println("Lista L1: " + L1);
        System.out.println("Lista L2: " + L2);

        // Buscar todas las sublistas de L1 en L2
//        encontrarSubListas(L1, L2);
        System.out.println("-----------------------------------------");      
        System.out.println("Lista original: " + L1);
        System.out.println("Lista original: " + L2);
        L3.add(L1);
        L3.add(L2);
        System.out.println("Lista original: " + L3);        
        // Mostrar sublistas con elementos iguales
        mostrarIguales(L1);
        System.out.println("Lista original: " + L3);
        mostrarAsc(L3);
        mostrarDes(L3);
        mostrarLong(L3, 2);
        System.out.println("------mostrarPositivos---");
        mostrarPositivos(L3);
        System.out.println("------mostrarNegativos---");
        mostrarNegativos(L3);
        System.out.println("------mostrarPosNeg---");
        mostrarPosNeg(L3);
        System.out.println("------mejorSuma---");
        mejorSuma(L3);
    }
}
