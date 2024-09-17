/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mochila;

import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author megus
 */

//Se tiene n-objetos con pesos p1, p2, . . ., pN. Se tiene también una mochila
//que puede transportar como máximo MAX, de peso. Encontrar todas
//la combinaciones de objetos posibles que se pueden transportar en la mochila.

//Ingresar los pesos de objetos en una Lista de Enteros L1 y mostrando la 
//combinación de objetos  en una Lista de Enteros L2 que representa la mochila,
//encontrar las cobinaciones de objetos en L2, utilizando un algoritmo de la 
//forma de llamada recursiva dentro de un ciclo.

//Para cada uno de los siguientes problemas, además mostrar la cantidad de soluciones posibles.
public class Lab2 {
    
    public static int cantidad=0;
    public static int cantidadMObjeto1=0;
    public static int cantidadMObjeto2=0;
    
    public static int suma(LinkedList<Integer> L1){
        int result = 0;
        for(int i=0; i < L1.size(); i++){
            result = result + L1.get(i);
        }
        return result;        
    } 
    
    public static void mochila( LinkedList<Integer> L1, 
                                LinkedList<Integer> L2, int max, int i){
        int sum = suma(L2);
        if(sum > max) return;
        System.out.println(L2);
        int k = i;
        while(k < L1.size()){
            L2.add(L1.get(k));
            mochila(L1, L2, max, k + 1);
            L2.removeLast();
            k = k + 1;
        }
    }
    
//  1  Encontrar todas las combinaciones de pesos de objetos
//     que se pueden transportar en la mochila y la cantidad de soluciones posibles.
     // Método que encuentra todas las combinaciones válidas y cuenta la cantidad
    public static void mochilaYCantidad(LinkedList<Integer> L1, 
                                        LinkedList<Integer> L2, int max, int i){        
        int sum = suma(L2);
        if(sum > max) return;  // Si la suma excede el peso máximo, terminar        
        System.out.println(L2);  // Imprimir la combinación válida
        cantidad++;  // Incrementar el contador de soluciones        
        int k = i;
        while(k < L1.size()){
            L2.add(L1.get(k));  // Añadir el siguiente objeto
            mochilaYCantidad(L1, L2, max, k + 1);  // Llamar recursivamente a mochilaYCantidad
            L2.removeLast();  // Remover el objeto
            k++;
        }
    }
    
//    Encontrar todas las combinaciones de pesos diferentes
//    que se pueden transportar en la mochila. 
//    (Se asume que existen objetos con pesos iguales)
    public static void mochilaDiferentes(LinkedList<Integer> L1, 
                                         LinkedList<Integer> L2, int max, int i) {
        int sum = suma(L2);
        if (sum > max) return;
        if (sum <= max && !L2.isEmpty()) {
            System.out.println(L2);
        }
        for (int k = i; k < L1.size(); k++) {
            if (!L2.contains(L1.get(k))) {
                L2.add(L1.get(k));
                mochilaDiferentes(L1, L2, max, k + 1);
                L2.removeLast();
            }
        }
    }
    
//    Encontrar todas las combinaciones de pesos entre los pesos
//    a y b inclusive que se pueden transportar en la mochila.
    public static void mochilaAyB(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i, int a, int b) {
        int sum = suma(L2);
        if (sum > max) return;  // Si la suma excede el peso máximo, detener        
        System.out.println(L2);// Si es una combinación válida (suma <= max), imprimir y contar             
        for (int k = i; k < L1.size(); k++) {
            int pesoActual = L1.get(k);            
            if (pesoActual >= a && pesoActual <= b) {// Solo considerar el peso si está en el rango [a, b]
                L2.add(pesoActual);  // Añadir el objeto a la combinación actual
                mochilaAyB(L1, L2, max, k + 1, a, b);  // Llamada recursiva
                L2.removeLast();  // Remover el último objeto después de explorar la combinación
            }
            
        }
    }
    
    public static void mochilaDiferente2(LinkedList<Integer> L1,
                                LinkedList<Integer> L2, int max, int i, HashSet<Integer> set) {
        int sum = suma(L2);
        if (sum > max) return;  // Si la suma excede el peso máximo, detener
        
        // Si es una combinación válida (suma <= max), imprimir y contar
        System.out.println(L2);
        cantidad++;

        int k = i;
        while (k < L1.size()) {
            int pesoActual = L1.get(k);
            // Solo añadir el peso si no está ya en la combinación actual
            if (!set.contains(pesoActual)) {
                L2.add(pesoActual);
                set.add(pesoActual);  // Marcar el peso como añadido
                mochilaDiferente2(L1, L2, max, k + 1, set);
                L2.removeLast();  // Remover el último objeto
                set.remove(pesoActual);  // Eliminar del set al retroceder en la recursión
            }
            k++;
        }
    }
    
//    Encontrar las combinaciones de m-objetos (m <= n), que se pueden transportar en la mochila.
      public static void mochila1( LinkedList<Integer> L1, LinkedList<Integer> L2,
                                  int max, int i, int m, int numObjetos) {
        int sum = suma(L2);
        
        // Si la suma excede la capacidad de la mochila o ya hay más de m objetos, detener
        if(sum > max || numObjetos > m) return;
        
        // Si la suma es válida y tenemos al menos 1 objeto, imprimir la combinación
        if(sum <= max && !L2.isEmpty()) {
            System.out.println(L2);
            cantidadMObjeto1++;
        }

        // Explorar combinaciones recursivamente
        for(int k = i; k < L1.size(); k++) {
            L2.add(L1.get(k));  // Añadir el objeto a la lista
            mochila1(L1, L2, max, k + 1, m, numObjetos + 1);  // Recursión
            L2.removeLast();  // Retroceder eliminando el último objeto
        }
    }
      
//    public static void mochila2(LinkedList<Integer> L1, LinkedList<Integer> L2,
//                               int max, int m, int i) {
//        int sum = suma(L2);
//        // Si la combinación es del tamaño correcto y no excede el peso máximo, imprimirla
//        if (L2.size() == m) {
//            if (sum <= max) {
//                System.out.println(L2);
//                cantidadMObjeto2++;
//            }
//            return;
//        }
//        // Si ya no hay más elementos para procesar o la suma actual excede el máximo permitido, regresar
//        if (i >= L1.size() || L2.size() > m || sum > max) {
//            return;
//        }
//        // Incluir el elemento actual en la combinación
//        L2.add(L1.get(i));
//        mochila2(L1, L2, max, m, i + 1);
//        // Excluir el elemento actual y avanzar al siguiente
//        L2.removeLast();
//        mochila2(L1, L2, max, m, i + 1);
//    }
//    
    public static void main(String[] args){
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();
        int max = 10;
        L1.add(3);        
        L1.add(6);  //  fuera del rango [a, b], y no se considerará
        L1.add(9);
        L1.add(3);
        System.out.println("-----------------mochila-------------");        
        mochila(L1, L2, max, 0);
        System.out.println("-----------------mochilaYCantidad-------------");        
        mochilaYCantidad(L1, L2, max, 0);
        cantidad--;
        System.out.println("Cantidad de combinaciones posibles: " + cantidad);  
//        ------------------------------------------------------
        System.out.println("---------mochilaDiferentes-------------");
        HashSet<Integer> set = new HashSet<>();//Usado para evitar pesos repetidos en una combinación
        int a = 2;     
        int b = 5;         
//        L1.add(3);        
//        L1.add(6);  //  fuera del rango [a, b], y no se considerará
//        L1.add(9);  //  fuera del rango [a, b], y no se considerará
        mochilaDiferentes(L1, L2, max, 0);               
//        System.out.println("----------------- Mochila con pesos diferentes -------------");
//        mochilaDiferente2(L1, L2, max, 0, set);  // Llamar al método para encontrar combinaciones
        System.out.println("---------mochilaAyB-------------");
        mochilaAyB(L1, L2, max, 0, a, b);
        System.out.println("-----------mochilaMObjecto----------");
        int m = 3;  // Máximo número de objetos a incluir en cada combinación           
        System.out.println("Combinaciones de " + m + " objetos o menos que se pueden transportar:");
        mochila1(L1, L2, max, 0, m, 0);
        System.out.println("Cantidad de combinaciones posibles: " + cantidadMObjeto1);
        System.out.println("----------------------------");
//        mochila2(L1, L2, max, m, 0);
//        System.out.println("Cantidad de combinaciones posibles: " + cantidadMObjeto2);
    }
}
