/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combinacionesYPermutaciones;

import java.util.LinkedList;

/**
 *
 * @author megus
 */

//Revisar problemas en la Web cualesquiera, sobre permutaciones y combinaciones. 
//Adaptar esos problemas a los Algoritmos de:

public class Lab4 {
//      Combinaciones de n elementos tomados de r en r. Sin Repetición.
    public static void combiSR(LinkedList<Integer> L1,
                            LinkedList<Integer> L2,int r, int i ){
        if(L2.size()==r){
            System.out.println(L2);            
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
//      Combinaciones de n elementos tomados de r en r. Con Repetición.
    public static void combiCR(LinkedList<Integer> L1,
                            LinkedList<Integer> L2,int r, int i ){
        if(L2.size()==r){
            System.out.println(L2);            
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
    
//      Permutaciones de n elementos tomados de r en r. Sin Repetición.
    public static void permutSR(LinkedList<Integer> L1,
                                LinkedList<Integer> L2, int r, int i) {
        if (L2.size() == r) {
            System.out.println(L2);            
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
    
//      Permutaciones de n elementos tomados de r en r. Con Repetición.
    public static void permutCR(LinkedList<Integer> L1,
                                LinkedList<Integer> L2, int r, int i) {
        if (L2.size() == r) {
            System.out.println(L2);            
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
    
    public static void main(String[] args){
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();
        L1.add(1); // los pesos de los objetos aquí
        L1.add(2);
        L1.add(3);
//        L1.add(4);
//        L1.add(5);     
        int r = 2;    
        int i = 0;
        System.out.println("---------combiSR-------------");
        combiSR(L1, L2, r, i);
        System.out.println("---------combiCR-------------");
        combiCR(L1, L2, r, i);
        System.out.println("---------permutSR-------------");
        permutSR(L1, L2, r, i);        
        System.out.println("---------permutCR-------------");
        permutCR(L1, L2, r, i);
    }
}
