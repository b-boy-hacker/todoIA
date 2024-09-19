/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumandosYFactores;

import java.util.LinkedList;

/**
 *
 * @author megus
 */

// LAB-1. SUMANDOS DE UN ENTERO
public class Lab1 {
    
    public static int suma(LinkedList<Integer> L1){
        int result = 0;
        for(Integer elemento: L1){
            result = result + elemento;
        }
        return result;
    }  
    
//    1 Encontrar los sumandos de n.
    public static void sumandos(LinkedList<Integer> L1, int n, int i){
        int sum = suma(L1);
        if(sum > n) return ;
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
    
//    2 Encontrar los sumandos iguales, tal que la suma sea n..
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
    
//   3 Encontrar los sumandos diferentes, tal que la suma sea n.
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
      
//    4 Encontrar los factores de n.
    public static void encontrarFactores( int n){
        LinkedList<Integer> factores = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                factores.add(i); // Añadir el divisor a la lista
            }
        }
        System.out.println("Factores de " + n + ": " + factores);
    }

    public static void factores(LinkedList<Integer> L1, int n, int i){
        int sum = suma(L1);
        if(sum > n) return ;
        if(sum == n){
            System.out.println(L1);
            return;
        }         
        for(int k = i; k <= n; k++){
            if(n % k == 0){  // Si k es divisor de n
                L1.add(k);    // Añadir el divisor k a la lista
//                System.out.println(L1);  // Mostrar la lista de factores actual
                factores(L1, n, k);  // Seguir buscando divisores para el cociente
                L1.removeLast();   // Eliminar el último elemento después de procesarlo
            }           
        }
    }
    public static int producto(LinkedList<Integer> L1){
        int c=1;
        int i=0;
        while(i<L1.size()){
            c = c*L1.get(i);
            i++;
        }
        return c;
        
    }
    
    public static void Factores2(LinkedList<Integer> L1,int n,int i){
        int prod = producto(L1);
        
        if(prod > n || L1.size()>n) return ;
        if(prod == n){
            System.out.println(L1);
            return;
        }   
        int k = i;
        while(k<=n){
            L1.add(k);
            Factores2(L1,n,k);
            L1.removeLast();
            k++;      
        }
        
    }
    
    
    public static void main(String[] args){
        LinkedList<Integer> L1 = new LinkedList<>();
        int n = 4;
       
        System.out.println("-----------factores------------");
        Factores2(L1, n, 1);
        encontrarFactores(n);
    }
}
