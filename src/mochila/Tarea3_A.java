/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mochila;

import java.util.LinkedList;
import static mochila.Lab3.mochila;
import static mochila.Lab3.mostrar;

/**
 *
 * @author megus
 */
    
//II. EL PROBLEMA DE LA MOCHILA DE CAPACIDAD MAX

//A. Implementar los siguientes problemas: ingresando los pesos 
//de objetos en una Lista de Enteros L1 y mostrando la combinación
//de objetos  en una Lista de Enteros L2 y utilizando un algoritmo
//de la forma de llamada recursiva dentro de un ciclo.


public class Tarea3_A {
    

    public static int suma(LinkedList<Integer>L1){
        int result = 0;
        for (int i = 0; i < L1.size(); i++) {
            result = result+L1.get(i);
        }
        return result;
    }
    
    public static void mostrar(LinkedList<LinkedList<Integer>> L3, int n){
       for (int i = 0; i < L3.size(); i++) {
           if(L3.get(i).size() == n){
               System.out.println(L3.get(i));
           }
       }
    }
    
    //Encontrar todas las combinaciones de pesos de objetos que se pueden transportar en la mochila.
    public static void mochila(LinkedList<Integer> L1, LinkedList<Integer> L2,
                               LinkedList<LinkedList<Integer>>L3, int Max, int i){
        int sum = suma(L2);
        if(sum > Max) return;
        L3.add(new LinkedList<>(L2));
        int k = i;
        while( k < L1.size()){
            L2.add(L1.get(k));
            mochila(L1, L2, L3, Max, k+1);
            L2.removeLast();
            k = k+1;
        }
    }   
    
//Encontrar todas las combinaciones de pesos diferentes que se pueden transportar en la mochila.
    public static void mochilaDiferentes(LinkedList<Integer> L1, LinkedList<Integer> L2,
                                     LinkedList<LinkedList<Integer>> L3, int Max, int i) {
        int sum = suma(L2);  // Calcular la suma de los elementos en la lista actual L2
        if (sum > Max) return;  // Si la suma supera el peso máximo, detener

        L3.add(new LinkedList<>(L2));  // Añadir la combinación actual a L3

        int k = i;
        while (k < L1.size()) {
            // Verificar si el elemento L1.get(k) no está ya en L2
            if (!L2.contains(L1.get(k))) {
                L2.add(L1.get(k));  // Añadir el elemento L1.get(k) a L2
                mochilaDiferentes(L1, L2, L3, Max, k + 1);  // Llamada recursiva para generar más combinaciones
                L2.removeLast();  // Eliminar el último elemento después de la llamada recursiva
            }
            k = k + 1;  // Avanzar en el índice
        }
    }
    
    public static void mochilaIguales(LinkedList<Integer> L1, LinkedList<Integer> L2,
                                  LinkedList<LinkedList<Integer>> L3, int Max, int i) {
        int sum = suma(L2);  // Calcular la suma de los elementos en la lista actual L2
        if (sum > Max) return;  // Si la suma supera el peso máximo, detener

        L3.add(new LinkedList<>(L2));  // Añadir la combinación actual a L3

        int k = i;
        while (k < L1.size()) {
            // Verificar si la lista L2 está vacía o si el último elemento añadido es igual a L1.get(k)
            if (L2.isEmpty() || L2.getLast().equals(L1.get(k))) {
                L2.add(L1.get(k));  // Añadir el elemento L1.get(k) a L2
                mochilaIguales(L1, L2, L3, Max, k + 1);  // Llamada recursiva para generar más combinaciones
                L2.removeLast();  // Eliminar el último elemento después de la llamada recursiva
            }
            k = k + 1;  // Avanzar en el índice
        }
    }


    
//Encontrar todas las combinaciones de pesos entre a y b inclusive
//    que se pueden transportar en la mochila.
    public static void mochilaEntreAB(LinkedList<Integer> L1, LinkedList<Integer> L2,
                                  LinkedList<LinkedList<Integer>> L3, int Max, int i, int a, int b) {
        int sum = suma(L2);  // Calcular la suma de los elementos en la lista actual L2
        if (sum > Max) return;  // Si la suma supera el peso máximo, detener

        // Añadir la combinación actual a L3 si la suma está entre a y b
        if (sum >= a && sum <= b) {
            L3.add(new LinkedList<>(L2));
        }

        int k = i;
        while (k < L1.size()) {
            L2.add(L1.get(k));  // Añadir el elemento L1.get(k) a L2
            mochilaEntreAB(L1, L2, L3, Max, k + 1, a, b);  // Llamada recursiva para generar más combinaciones
            L2.removeLast();  // Eliminar el último elemento después de la llamada recursiva
            k = k + 1;  // Avanzar en el índice
        }
    }

//Encontrar las combinaciones de objetos de mayor cantidad de objetos que se pueden transportar.
    public static void encontrarMaxObjetos(LinkedList<Integer> L1, int Max) {
        LinkedList<LinkedList<Integer>> L3 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();

        // Encuentra todas las combinaciones posibles
        mochila(L1, L2, L3, Max, 0);

        // Encontrar la combinación con la mayor cantidad de objetos
        LinkedList<Integer> maxCombination = null;
        int maxSize = 0;

        for (LinkedList<Integer> combination : L3) {
            if (suma(combination) <= Max && combination.size() > maxSize) {
                maxSize = combination.size();
                maxCombination = combination;
            }
        }

        // Mostrar la combinación con la mayor cantidad de objetos
        if (maxCombination != null) {
            System.out.println("Combinación con la mayor cantidad de objetos: " + maxCombination);
        } else {
            System.out.println("No se encontraron combinaciones válidas.");
        }
    }

//Encontrar las mejores combinaciones que se pueden transportar en la mochila.
//    (Las más próximas a la capacidad de la mochila)
    public static void encontrarMejoresCombinaciones(LinkedList<Integer> L1, int Max) {
        LinkedList<LinkedList<Integer>> L3 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();

        // Encuentra todas las combinaciones posibles
        mochila(L1, L2, L3, Max, 0);

        // Encontrar las combinaciones con el peso total más cercano al máximo
        LinkedList<LinkedList<Integer>> mejoresCombinaciones = new LinkedList<>();
        int mejorPeso = 0;

        for (LinkedList<Integer> combination : L3) {
            int peso = suma(combination);
            if (peso <= Max && peso > mejorPeso) {
                mejorPeso = peso;
                mejoresCombinaciones.clear();  // Limpiar combinaciones previas
                mejoresCombinaciones.add(new LinkedList<>(combination));
            } else if (peso == mejorPeso) {
                mejoresCombinaciones.add(new LinkedList<>(combination));
            }
        }

        // Mostrar las mejores combinaciones
        if (!mejoresCombinaciones.isEmpty()) {
            System.out.println("Mejores combinaciones con peso total más cercano al máximo (" + Max + "):");
            for (LinkedList<Integer> combination : mejoresCombinaciones) {
                System.out.println(combination);
            }
        } else {
            System.out.println("No se encontraron combinaciones válidas.");
        }
    }
    
//Implementar las consultas anteriores, utilizando una Lista de Listas y 
//    plantear consultas adicionales interesantes..
    
    public static void main(String[] args) {
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();
        LinkedList<LinkedList<Integer>> L3 = new LinkedList<>();

        // Agregar elementos a L1
//        L1.add(3);
        L1.add(3);
        L1.add(6);
        L1.add(9);        

        int max = 10;
        int i = 0;
        int a = 3;     // Límite inferior del rango
        int b = 6;     // Límite superior del rango

        // Llamada al método mochila
        System.out.println("-----mochila---------");
        mochila(L1, L2, L3, max, 0);
        System.out.println(L3);

        // Mostrar las combinaciones de tamaño 2 generadas por mochila
        System.out.println("-------mostrar-----------");
        mostrar(L3, 2);

        // Limpiar L2 y L3 antes de llamar a mochilaDiferentes
        L2.clear();
        L3.clear();

        // Llamada al método mochilaDiferentes
        System.out.println("-------mochilaDiferentes--------");
        mochilaDiferentes(L1, L2, L3, max, i);
        System.out.println(L3);

        // Limpiar L2 y L3 antes de llamar a mochilaIguales
        L2.clear();
        L3.clear();

        // Llamada al método mochilaIguales
        System.out.println("-------mochilaIguales--------");
        mochilaIguales(L1, L2, L3, max, i);
        System.out.println(L3);

        // Limpiar L2 y L3 antes de llamar a mochilaEntreAB
        L2.clear();
        L3.clear();

        // Llamada al método mochilaEntreAB
        System.out.println("-----mochilaEntreAB---------"+a+"---"+b);
        mochilaEntreAB(L1, L2, L3, max, 0, a, b);
        System.out.println(L3);
        System.out.println("-----Encontrar combinación con la mayor cantidad de objetos---------");
        L2.clear();
        L3.clear();
        encontrarMaxObjetos(L1, max);
        System.out.println("-----Encontrar las mejores combinaciones---------");
        encontrarMejoresCombinaciones(L1, max);
        
    }


}
