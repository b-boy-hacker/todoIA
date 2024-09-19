package prueba;

import java.util.LinkedList;

public class prueba {
    
    public static int suma(LinkedList<Integer>L1){
        int s = 0;
        for(Integer e: L1){
            s =s+e;
        }
        return s;
    }
    
    public static void sumandos(LinkedList<Integer>L1, int n, int i){
        int sum = suma(L1);
        if(sum > n) return;
        if(sum == n){
            System.out.println(L1);
            return;
        }
        for (int j = i; j < n; j++) {
            L1.add(j);
            sumandos(L1, n,j);
            L1.removeLast();
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
    
    public static void factores(LinkedList<Integer> L1,int n,int i){
        int prod = producto(L1);
        
        if(prod > n || L1.size()>n) return ;
        if(prod == n){
            System.out.println(L1);
            return;
        }   
        int k = i;
        while(k<=n){
            L1.add(k);
            factores(L1,n,k);
            L1.removeLast();
            k++;      
        }
        
    }
    
    public static void mochila(LinkedList<Integer>L1, LinkedList<Integer>L2, int max, int i){
        int sum = suma(L2);
        if(sum > max) return;
        System.out.println(L2);
        for (int j = i; j < L1.size(); j++) {
            L2.add(L1.get(j));
            mochila(L1, L2, max, j+1);
            L2.removeLast();
        }
    
    }
    
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
    
    
    public static void main(String[] args) {       
        LinkedList<Integer>L1 = new LinkedList<>();        
        int n = 12;
        System.out.println("-------------sumandos------------------");
        sumandos(L1, n, 1);
        System.out.println("-------------factores------------------");
        factores(L1, n, 1);
        System.out.println("-------------mochila-------------------");
        LinkedList<Integer>L2 = new LinkedList<>();
        L1.add(3);
        L1.add(6);
        L1.add(9);
        int max = 10;
        int i=0;
        mochila(L1, L2, max, i);       
        System.out.println("---------combiSR-------------");
        int r = 2;   
        combiSR(L1, L2, r, i);
        System.out.println("---------combiCR-------------");
        combiCR(L1, L2, r, i);
        System.out.println("---------permutSR-------------");
        permutSR(L1, L2, r, i);        
        System.out.println("---------permutCR-------------");
        permutCR(L1, L2, r, i);        
    }
    
}
