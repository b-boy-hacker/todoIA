/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumandosYFactores;

import java.util.LinkedList;
import static sumandosYFactores.Lab1.sumandosIguales;

/**
 *
 * @author megus
 */

// Dado un entero N, encontrar todos los factores posibles, enteros positivos de N.

public class Tarea3_Factores {

    public static int suma(LinkedList<Integer>L1){
        int sum = 0;
        for(Integer elemendo: L1){
            sum = sum + elemendo; 
        }
        return sum;
    }
    
    public static void sumandos(LinkedList<Integer>L1, int n, int i){
        int sum = suma(L1);
        if(sum > n) return;
        if(sum == n){
            System.out.println(L1);
            return;
        }
        int k = i;
        while(k <= n){            
            L1.add(k);
            sumandos(L1, n, k);
            L1.removeLast();
            k = k+1;
        }
    }    
    
    //      Encontrar los factores posibles en una Lista.
    public static void factores(LinkedList<Integer>L1, int n, int i){
        int sum = suma(L1);
        if(sum > n) return;
        if(sum == n){
            System.out.println(L1);
            return;
        }
        int k = i;
        while(k <= n){
            if(n % k == 0){
                L1.add(k);
                factores(L1, n, k);
                L1.removeLast();
            }
            k = k+1;
        }
    }    
    
//      Encontrar todos los factores posibles diferentes en una Lista.
    public static void factoresDirefentes(LinkedList<Integer>L1, int n, int i){
        int sum = suma(L1);
        if(sum > n) return;
        if(sum == n){
            System.out.println(L1);
            return;
        }
        int k = i;
        while(k <= n){
            if(n % k >= 1){
                L1.add(k);
                factoresDirefentes(L1, n, k);
                L1.removeLast();
            }
            k = k+1;
        }
    }    
    
//      Encontrar todos los factores posibles iguales en una Lista.
    public static void factoresIguales(LinkedList<Integer>L1, int n, int i){
        int sum = suma(L1);
        if(sum > n) return;
        if(sum == n){
            System.out.println(L1);
            return;
        }
        int k = i;
        while(k <= n){
            if(n % k == 0){
                if (L1.isEmpty() || L1.getLast() == k) {
                    L1.add(k);
                    factoresIguales(L1, n, k);
                    L1.removeLast();
                }                
            }
            k = k+1;
        }
    }      
     
//      Encontrar todos los factores primos posibles en una Lista.
    //2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89 y 97.
     public static boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
     
    public static void factoresPrimos(LinkedList<Integer> L1, int n, int i) {
        int sum = L1.stream().mapToInt(Integer::intValue).sum();
        if (sum > n) return;
        if (sum == n) {
            System.out.println(L1);
            return;
        }
        for (int k = i; k <= n; k++) {
            if(n % k >= 0){
                if (esPrimo(k)) {
                    L1.add(k);
                    factoresPrimos(L1, n, k + 1);
                    L1.removeLast();
                }
            }
        }
    }
    
//      Encontrar todos los factores entre a y b inclusive en una Lista.
    public static void factoresAyB(LinkedList<Integer> L1, int n, int i, 
                                    int a, int b) {
//        int sum = L1.stream().mapToInt(Integer::intValue).sum();
        int sum = suma(L1);
        if (sum > n) return;
        if (sum == n) {
            System.out.println(L1);
            return;
        }
        for (int k = i; k <= n; k++) {
            // Verificar si k es un divisor de n y si está entre a y b
            if (k >= a && k <= b && n % k == 0) {
                L1.add(k);  // Agregar k a la lista si cumple las condiciones
                factoresAyB(L1, n, k, a, b);  // Llamada recursiva para continuar
                L1.removeLast();  // Remover el último elemento para retroceder en la búsqueda
            }
        }
    }
    
//      Implementar las consultas anteriores, utilizando una Lista
//      de Listas y plantear consultas adicionales interesantes.
    
    public static void main(String[] args){
        LinkedList<Integer> L1 = new LinkedList<>();           
        int n = 4;
        int i = 1;
        int a = 1; 
        int b = 2;        
        sumandos(L1, n, i);
        System.out.println("------factores--------"+n);
        factores(L1, n, i);              
        System.out.println("----factoresDirefentes-----"); 
        factoresDirefentes(L1, n, i);
        System.out.println("----FactoresIguales-----");
        factoresIguales(L1, n, i);
        System.out.println("---------factoresPrimos--------------");
        factoresPrimos(L1, n, i);
        System.out.println("--------factoresAyB---------"+a+" "+b);
        factoresAyB(L1, n, i, a, b);
    }
}
