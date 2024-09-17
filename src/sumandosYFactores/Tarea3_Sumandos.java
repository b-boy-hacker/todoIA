/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumandosYFactores;

import java.util.LinkedList;
import static sumandosYFactores.Lab1.suma;

/**
 *
 * @author megus
 */

//I. PROBLEMA DE LOS SUMANDOS DE UN ENTERO

public class Tarea3_Sumandos {
    
    public static int suma(LinkedList<Integer> L1){
        int s = 0;
        for(Integer elemento: L1){
            s += elemento;
        }
        return s;
    }
//      Encontrar los sumandos posibles en una Lista.
    public static void sumandos(LinkedList<Integer> L1, int n, int i){
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
//      Encontrar todos los sumandos posibles diferentes en una Lista.
    public static void sumandosDiferentes(LinkedList<Integer> L1, int n, int i){
        int sum = suma(L1);
        if(sum > n) return ;
        if(sum == n){
            System.out.println(L1);
            return;
        }         
        for(int k = i; k <= n; k++){
            if(! L1.contains(k)){
                L1.add(k);
                sumandosDiferentes(L1, n, k);
                L1.removeLast();   
            }            
        }
    }
    
//      Encontrar todos los sumandos posibles iguales en una Lista.
    public static void sumandosIguales(LinkedList<Integer> L1, int n, int i){              
        int sum = suma(L1);
        if(sum > n) return;
        if(sum == n){           
            System.out.println(L1);
            return;
        }  
        for(int k = i; k <= n; k++){
            if (L1.isEmpty() || L1.getLast() == k) {
                L1.add(k);
                sumandosIguales(L1, n, k);
                L1.removeLast();
            }                 
        } 
    }
    
//      Encontrar todos los sumandos primos posibles en una Lista.
    
//      Encontrar todos los sumandos entre a y b inclusive en una Lista.
    //2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89 y 97.
     public static boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
     
    public static void sumandosPrimos(LinkedList<Integer> L1, int n, int i) {
        int sum = L1.stream().mapToInt(Integer::intValue).sum();
        if (sum > n) return;
        if (sum == n) {
            System.out.println(L1);
            return;
        }
        for (int k = i; k <= n; k++) {
            if (esPrimo(k)) {
                L1.add(k);
                sumandosPrimos(L1, n, k + 1);
                L1.removeLast();
            }
        }
    }
    
//      Implementar las consultas anteriores, utilizando una Lista de
//      Listas y plantear consultas adicionales
    
    public static void main(String[] args){
        LinkedList<Integer> L1 = new LinkedList<>();        
        int n = 5;
        int i = 1;
        System.out.println("Numero "+n);
        sumandos(L1, n, i);
        System.out.println("------sumandosDiferentes----------");
        sumandosDiferentes(L1, n, i);
        System.out.println("-----sumandosPrimos-----");
        sumandosPrimos(L1, n, i);
        
    }
}
