/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mochila;

import java.util.LinkedList;
import static mochila.Tarea3_A.mochila;
import static mochila.Tarea3_A.mostrar;

/**
 *
 * @author megus
 */

//B. Con la misma lógica del Problema de la Mochila, 
//los objetos tienen dos valores: peso y color.
//En esta caso, las listas contienen objetos con dos valores. Implementar:

public class Tarea3_B {
    
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
    
//Encontrar todas las combinaciones de pesos de objetos que se pueden
//    transportar en la mochila del mismo color.
    private static boolean tienenMismoColor(LinkedList<LinkedList<Object>> lista) { 
        if (lista.isEmpty()) return true; 
        String color = (String) lista.get(0).get(1); 
        for (LinkedList<Object> item : lista) { 
            if (!color.equals(item.get(1))) return false; 
        } 
        return true; 
    } 
    
    public static void mochilaMismoColor(LinkedList<LinkedList<Object>> listadelistas, 
                                        LinkedList<LinkedList<Object>> L2, int max, int i) { 
        int sum = sumaListas(L2); 
        if (sum > max) return; 

        if (sum <= max && tienenMismoColor(L2)) { 
            System.out.println(L2); 
        } 

        for (int k = i; k < listadelistas.size(); k++) { 
            L2.add(listadelistas.get(k)); 
            mochilaMismoColor(listadelistas, L2, max, k + 1); 
            L2.remove(L2.size() - 1); // Remove last item 
        } 
    }
    
//Encontrar todas las combinaciones de pesos de objetos que se pueden transportar en la mochila
//            , todos de colores diferentes.
    private static boolean tienenColoresDiferentes(LinkedList<LinkedList<Object>> lista) { 
        LinkedList<String> colores = new LinkedList<>(); 
        for (LinkedList<Object> item : lista) { 
            String color = (String) item.get(1); 
            if (colores.contains(color)) return false; 
            colores.add(color); 
        } 
        return true; 
    } 
    
     public static void mochilaDiferentesColores(LinkedList<LinkedList<Object>> listadelistas, 
                                    LinkedList<LinkedList<Object>> L2, int max, int i) { 
        int sum = sumaListas(L2); 
        if (sum > max) return; 
         
        if (sum <= max && tienenColoresDiferentes(L2)) { 
            System.out.println(L2); 
        } 
         
        for (int k = i; k < listadelistas.size(); k++) { 
            L2.add(listadelistas.get(k)); 
            mochilaDiferentesColores(listadelistas, L2, max, k + 1); 
            L2.remove(L2.size() - 1); // Remove last item 
        } 
    }
     
//Encontrar todas las combinaciones de pesos de objetos que se pueden transportar en la mochila,
//                    que sean del mismo peso y el mismo color.
    private static boolean tienenMismoPesoYColor(LinkedList<LinkedList<Object>> lista) { 
        if (lista.isEmpty()) return true; 
        Integer peso = (Integer) lista.get(0).get(0); 
        String color = (String) lista.get(0).get(1); 
        for (LinkedList<Object> item : lista) { 
            if (!peso.equals(item.get(0)) || !color.equals(item.get(1))) return false; 
        } 
        return true; 
    } 
    
    public static void mochilaMismoPesoYColor(LinkedList<LinkedList<Object>> listadelistas, 
                                    LinkedList<LinkedList<Object>> L2, int max, int i) { 
        int sum = sumaListas(L2); 
        if (sum > max) return; 
         
        if (sum <= max && tienenMismoPesoYColor(L2)) { 
            System.out.println(L2); 
        } 
         
        for (int k = i; k < listadelistas.size(); k++) { 
            L2.add(listadelistas.get(k)); 
            mochilaMismoPesoYColor(listadelistas, L2, max, k + 1); 
            L2.remove(L2.size() - 1); // Remove last item 
        } 
    }    
    
//Encontrar todas las combinaciones de pesos de objetos que se pueden transportar en la mochila 
//                            que sean de pesos diferentes y colores diferentes.
    private static boolean tienenPesosYColoresDiferentes(LinkedList<LinkedList<Object>> lista) { 
        LinkedList<Integer> pesos = new LinkedList<>(); 
        LinkedList<String> colores = new LinkedList<>(); 
        for (LinkedList<Object> item : lista) { 
            Integer peso = (Integer) item.get(0); 
            String color = (String) item.get(1); 
            if (pesos.contains(peso) || colores.contains(color)) return false; 
            pesos.add(peso); 
            colores.add(color); 
        } 
        return true; 
    }
    
     public static void mochilaPesosYColoresDiferentes(LinkedList<LinkedList<Object>> 
                                                    listadelistas, LinkedList<LinkedList<Object>> L2,
                                                    int max, int i) { 
        int sum = sumaListas(L2); 
        if (sum > max) return; 
         
        if (sum <= max && tienenPesosYColoresDiferentes(L2)) { 
            System.out.println(L2); 
        } 
         
        for (int k = i; k < listadelistas.size(); k++) { 
            L2.add(listadelistas.get(k)); 
            mochilaPesosYColoresDiferentes(listadelistas, L2, max, k + 1); 
            L2.remove(L2.size() - 1); // Remove last item 
        } 
    }   
     
    public static void mochilaListas(LinkedList<LinkedList<Object>> listadelistas, 
                                              LinkedList<LinkedList<Object>> L2, int max, int i) { 
        int sum = sumaListas(L2); 
        if (sum > max) return; 
        if (sum <= max) { 
            System.out.println(L2); 
        } 
        for (int k = i; k < listadelistas.size(); k++) { 
            L2.add(listadelistas.get(k)); 
            mochilaListas(listadelistas, L2, max, k + 1); 
            L2.removeLast(); 
        } 
    }
    
    private static int sumaListas(LinkedList<LinkedList<Object>> listadelistas) { 
        int s = 0; 
        for (LinkedList<Object> lista : listadelistas) { 
            if (lista.size() > 0 && lista.get(0) instanceof Integer) { 
                s += (Integer) lista.get(0); 
            } 
        } 
        return s; 
    } 
//Implementar las consultas anteriores, utilizando una Lista de Listas y plantear
//                            consultas adicionales interesantes.
    
    public static void main(String[] args){
        LinkedList<Integer> L5 = new LinkedList<>();  
        LinkedList<Integer> L6 = new LinkedList<>();
        LinkedList<LinkedList<Integer>> L7 = new LinkedList<>();

        
        // Agregar elementos a L1
        L5.add(3);
        L5.add(6);
        L5.add(9);        

        int max = 10;
        int i = 0;
        int a = 3;     // Límite inferior del rango
        int b = 6;     // Límite superior del rango

        // Llamada al método mochila
        System.out.println("-----mochila---------");
        mochila(L5, L6, L7, max, i);
        System.out.println(L7);

        // Mostrar las combinaciones de tamaño 2 generadas por mochila
        System.out.println("-------mostrar-----------");
        mostrar(L7, 2);         
        
        LinkedList<LinkedList<Object>> listadelistas = new LinkedList<>();
        
        // Crear una lista interna que almacena Object
        LinkedList<Object> objeto1 = new LinkedList<>();
        objeto1.add(5);         
        objeto1.add("Rojo");      

        // Crear otra lista interna
        LinkedList<Object> objeto2 = new LinkedList<>();
        objeto2.add(1);       
        objeto2.add("Azul");  
        
        LinkedList<Object> objeto3 = new LinkedList<>();
        objeto3.add(2);       
        objeto3.add("Naranja"); 
        
        LinkedList<Object> objeto4 = new LinkedList<>();
        objeto4.add(5);       
        objeto4.add("Rojo");  
        
        LinkedList<Object> objeto5 = new LinkedList<>();
        objeto5.add(10);       
        objeto5.add("Azul"); 
        
        LinkedList<Object> objeto6 = new LinkedList<>();
        objeto6.add(12);       
        objeto6.add("Azul"); 
        
        listadelistas.add(objeto1);
        listadelistas.add(objeto2);
        listadelistas.add(objeto3);
        listadelistas.add(objeto4);
        listadelistas.add(objeto5);
        listadelistas.add(objeto6);
        
        int minimoObjetos = 2;
        System.out.println(listadelistas);
        System.out.println("----------mochilaListas---------"+"max "+max);
        
        LinkedList<LinkedList<Object>> L2 = new LinkedList<>();
        mochilaListas(listadelistas,L2,max,1);
        System.out.println("----------mochilaMismoColor---------"+"max "+max);
        mochilaMismoColor(listadelistas, L2, max, 1);        
         System.out.println("----------mochilaDiferentesColores---------"+"max "+max);
        mochilaDiferentesColores(listadelistas, L2, max, 1);
         System.out.println("----------mochilaMismoPesoYColor---------"+"max "+max);
        mochilaMismoPesoYColor(listadelistas, L2, max, 1);
         System.out.println("----------mochilaPesosYColoresDiferentes---------"+"max "+max); 
         mochilaPesosYColoresDiferentes(listadelistas, L2, max, 1);        
        
    }
}
