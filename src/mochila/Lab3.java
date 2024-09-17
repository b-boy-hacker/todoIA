/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mochila;

import java.util.LinkedList;

/**
 *
 * @author megus
 */

// LAB-3. MOCHILA, LISTAS DE LISTAS.

public class Lab3 {

//    mochila(L1, L2, L3, max, i) : Procedimiento que encuentra en la lista
//    de listas L3, todas las listas soluciones de L2 que contienen pesos
//    totales menores o iguales a max, obtenidas del conjuntos
//    de pesos de L1, desde la posición i.
    public static int suma(LinkedList<Integer>L1){
        int result = 0;
        for (int i = 0; i < L1.size(); i++) {
            result = result+L1.get(i);
        }
        return result;
    }
    
    public static void mochila(LinkedList<Integer> L1, LinkedList<Integer> L2,
                               LinkedList<LinkedList<Integer>>L3, int Max, int i){
        int sum = suma(L2);
        if(sum > Max) return;
        L3.add(new LinkedList(L2));
        int k = i;
        while( k < L1.size()){
            L2.add(L1.get(k));
            mochila(L1, L2, L3, Max, k+1);
            L2.removeLast();
            k = k+1;
        }
    }    
      
//      Consulta 1:
//      mostrarCantidad(L3, k) : Procedimiento que muestra todas 
//      listas de longitud-k, de la lista de listas L3.
    public static void mostrar(LinkedList<LinkedList<Integer>> L3, int n){
       for (int i = 0; i < L3.size(); i++) {
           if(L3.get(i).size() == n){
               System.out.println(L3.get(i));
           }
       }
    }
    
//    Implementar al menos 5 consultas adicionales cualesquiera interesantes.
    
    //CONSULTA 1: ELEMENTOS PARES
    public static void elementosPares(LinkedList<LinkedList<Integer>> L3){
        for (int i = 0; i < L3.size(); i++) {
            if(L3.get(i).size() % 2 == 0) System.out.println(L3.get(i));
        }
    }           
    
   //CONSULTA 2: ELEMENTOS IMPARES
    public static void elementosImpares(LinkedList<LinkedList<Integer>> L3){
       for (int i = 0; i < L3.size(); i++) {
           if(L3.get(i).size() % 2 == 1){
               System.out.println(L3.get(i));
           }
       }
    }
   
   //CONSULTA 3: SUMA MAYOR AL ELEMENTO 
    public static void mayorAlResto(LinkedList<LinkedList<Integer>> L3, int max){
       for (int i = 0; i < L3.size(); i++) {
           if(suma(L3.get(i)) == max){
               System.out.println(L3.get(i));
           }
       }
    }
   
   //CONSULTA 4:  
    public static void mayorLongitud(LinkedList<LinkedList<Integer>> L3){
        int a = L3.get(0).size();
        int b = 0;
        for (int i = 1; i < L3.size(); i++) {
           b=L3.get(i).size();
           if(b>a){
               a = b;               
           }
        }
        System.out.println("La lista de mayor longitud es: "+a);
    }

    //CONSULTA 5:  
    public static void elementosPrimos(LinkedList<LinkedList<Integer>> L3, int umbral){
        for (int i = 0; i < L3.size(); i++) {
            if(primo(suma(L3.get(i)))){
                System.out.println(L3.get(i) + "nro primo "+ suma(L3.get(i)));
            }
        }
    }
    
    public static boolean primo(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
            }
        return true;
    }
    
    public static void main(String[] args){
        Lab3 lista = new Lab3();
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();
        LinkedList<LinkedList<Integer>> L3 = new LinkedList<>();
        L1.add(3);
        L1.add(6);
        L1.add(9);        
//        L1.add(4);
        int max = 10;
        int i = 0;
        System.out.println("-----mochila---------");
//        System.out.println(lista.suma(L1));
        mochila(L1, L2, L3, max, 0);
        System.out.println(L3);
        System.out.println("-------mostrar-----------");
        mostrar(L3, 2);
        System.out.println("--------elementosPares--------------");
        elementosPares(L3);
        System.out.println("--------elementosImpares--------------");
        elementosImpares(L3);
        System.out.println("--------mayorAlResto--------------");
        mayorAlResto(L3, max);
        System.out.println("--------mayorLongitud--------------");
        mayorLongitud(L3);
        System.out.println("--------elementosPrimos--------------");
        elementosPrimos(L3, max);
    }
}
