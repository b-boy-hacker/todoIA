/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combinacionesYPermutaciones;

import static combinacionesYPermutaciones.Lab4.combiCR;
import static combinacionesYPermutaciones.Lab4.combiSR;
import static combinacionesYPermutaciones.Lab4.permutCR;
import static combinacionesYPermutaciones.Lab4.permutSR;
import java.util.LinkedList;

/**
 *
 * @author megus
 */

//Revisar la web, libros, revistas, publicaciones y otros, 
//buscar problemas de aplicaciones, propuestos sobre Combinaciones
//y Permutaciones con y sin repeticiones de elementos, mostrar 
//los resultados posibles y la cantidad de resultados. Aplicar 
//los algoritmos de combiSR(), combiCR(), permutSR(), permutCR()
//o modificarlos para dar solución a los problemas propuestos en
//esas fuentes de información. Aplicar al menos 2 problemas cualesquiera
//para cada Algoritmo., utilizar también de ser necesarios,  listas que
//contienen objetos cadenas, objetos que contiene varios atributos, etc. Citar Fuentes.

public class Tarea4 {
    static int contarCSR = 0;
    static int contarCCR = 0;
    static int contarPSR = 0;
    static int contarPCR = 0;
    
    public static void combiSR(LinkedList<Integer> L1,
                            LinkedList<Integer> L2,int r, int i ){
        if(L2.size()==r){
            System.out.println(L2);
            contarCSR++;
            return;
        }
        int k = i;
        while(k < L1.size()){
            L2.add(L1.get(k));
            combiSR(L1,L2,r,k+1);
            L2.removeLast();
            k = k+1;
        }
    }
    
    public static void combiCR(LinkedList<Integer> L1,
                            LinkedList<Integer> L2,int r, int i ){
        if(L2.size()==r){            
            System.out.println(L2);
            contarCCR++;
            return;
        }
        int k = i;
        while(k < L1.size()){
            L2.add(L1.get(k));
            combiCR(L1,L2,r,k);
            L2.removeLast();
            k = k+1;
        }
    }
    
     public static void permutCR(LinkedList<Integer> L1,
                                LinkedList<Integer> L2, int r, int i) {
        if (L2.size() == r) {
            System.out.println(L2);
            contarPCR++;
            return;

        }
        int k = 0;
        while (k < L1.size()) {
            L2.add(L1.get(k));
            permutCR(L1, L2, r, k + 1);
            L2.removeLast();
            k += 1;

        }
    }

    public static void permutSR(LinkedList<Integer> L1,
                                LinkedList<Integer> L2, int r, int i) {
        if (L2.size() == r) {
            System.out.println(L2);
            contarPSR++;
            return;

        }
        int k = 0;
        while (k < L1.size()) {
            if (!L2.contains(L1.get(k))) {
                L2.add(L1.get(k));
                permutSR(L1, L2, r, k + 1);
                L2.removeLast();
            }
            k += 1;

        }
    }
     
    public static void main(String[] args){
        LinkedList<Integer> L1 = new LinkedList<>();
        L1.add(1); // los pesos de los objetos aquí
        L1.add(2);
        L1.add(3);
//        L1.add(4);
//        L1.add(5);        
        LinkedList<Integer> L2 = new LinkedList<>();
        int r = 2; 
        
       int i = 0;
        System.out.println("---------combiSR-------------"+contarCSR);
        combiSR(L1, L2, r, i);
        System.out.println("---------total-------------"+contarCSR);
        System.out.println("---------combiCR-------------"+contarCCR);
        combiCR(L1, L2, r, i);
        System.out.println("---------total-------------"+contarCCR);
        System.out.println("---------permutSR-------------"+contarPSR);
        permutSR(L1, L2, r, i);
        System.out.println("---------total-------------"+contarPSR);        
        System.out.println("---------permutCR-------------"+contarPCR);
        permutCR(L1, L2, r, i);
        System.out.println("---------total-------------"+contarPCR);
    }
    
   
}
