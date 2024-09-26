package prueba;

import java.util.LinkedList;
import java.util.Random;

public class Matriz {
    private  int maxFil; 
    private  int maxCol; 
    private  int cantFil; 
    private  int cantCol; 
    private  int[][] elem;
    private LinkedList<Matriz> lista;
 
    // Constructor 
    public Matriz(int filas, int columnas) { 
        this.maxFil = filas; 
        this.maxCol = columnas; 
        this.cantFil = filas; 
        this.cantCol = columnas; 
        this.elem = new int[filas][columnas]; 
        this.lista = new LinkedList<>();
    }
    
    //Constructor copia
    public Matriz(Matriz M1) {
        this.cantFil = M1.cantFil;
        this.cantCol = M1.cantCol;
        this.maxCol = M1.maxCol;
        this.maxFil = M1.maxFil;
        this.lista = new LinkedList<>();
        this.elem = new int[M1.cantFil][M1.cantCol];
        for (int i = 0; i < M1.cantFil; i++) {
            for (int j = 0; j < M1.cantCol; j++) {
                this.elem[i][j] = M1.elem[i][j];
            }
        }
    }
    
    @Override 
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < cantFil; i++) { 
            for (int j = 0; j < cantCol; j++) { 
                sb.append(elem[i][j]).append(" "); 
            } 
            sb.append("\n"); 
        } 
        return sb.toString(); 
    }
    
    public void encontrarSubMatr() {
        for (int i = 0; i <= cantFil - 1; i++) {
            for (int j = 0; j <= cantCol - 1; j++) {
                for (int subFil = 1; subFil <= cantFil - i; subFil++) {
                    for (int subCol = 1; subCol <= cantCol - j; subCol++) {
                        Matriz subM = new Matriz(subFil, subCol);
                        for (int x = 0; x < subFil; x++) {
                            for (int y = 0; y < subCol; y++) {
                                subM.elem[x][y] = elem[i + x][j + y];
                            }
                        }
                        subM.cantFil = subFil;
                        subM.cantCol = subCol;                        
                        this.lista.add(subM);    
//                        System.out.println(subM);
                    }
                }
            }
        }
    }
    
    public Matriz subMatrix(int y1, int y2, int x1, int x2) {
        Matriz M2 = new Matriz(y2-y1+1, x2-x1+1);
        for (int i = 0; i < M2.cantFil; i++) {
            for (int j = 0; j < M2.cantCol; j++) {
                M2.elem[i][j] = elem[y1+i][x1+j];
            }
        }
        return M2;
    } 
    
    public void mostrarSubMat() {
        for (int i1 = 0; i1 < cantFil; i1++){
            for (int i2 = i1; i2 < cantFil; i2++){
                for (int j1 = 0; j1 < cantCol; j1++){
                    for (int j2 = j1; j2 < cantCol; j2++){
                        System.out.println(subMatrix(i1, i2, j1, j2));
                    }
                }
            }
        }
    }
    
    public void mostrarMatrices() {
        for (Matriz matriz : this.lista) {
            System.out.println(matriz.toString());
        }
    }
    
    //POSIBLEMENTO ESTE NO
//    public void mostrarSubMat(int n, int m) {
//        if (n > cantFil || m > cantCol) {
//            System.out.println("Las dimensiones de la submatriz exceden las dimensiones de la matriz principal.");
//            return;
//        }
//        for (int i = 0; i <= cantFil - n; i++) {
//            for (int j = 0; j <= cantCol - m; j++) {
//                Matriz subM = new Matriz(n, m);
//                for (int x = 0; x < n; x++) {
//                    for (int y = 0; y < m; y++) {
//                        subM.elem[x][y] = elem[i + x][j + y];
//                    }
//                }
//                subM.cantFil = n;
//                subM.cantCol = m;
//                System.out.println(subM);
//            }
//        }
//    }
    public void eliminarFil(int k){ 
        for (int i = k + 1; i < this.cantFil; i++) { 
            for (int j = 0; j < this.cantCol; j++) { 
                this.elem[i - 1][j] = this.elem[i][j];
            } 
        } 
        this.cantFil--; 
    }
    
    public void eliminarCol(int k){ 
        for (int i = 0; i < this.cantFil; i++) { 
            for (int j = k + 1; j < this.cantCol; j++) { 
                this.elem[i][j - 1] = this.elem[i][j];                
            }             
        } 
        this.cantCol--; 
    }
    
    public void generarElem(int a, int b) { 
        Random rand = new Random(); 
        for (int i = 0; i < cantFil; i++) { 
            for (int j = 0; j < cantCol; j++) { 
                elem[i][j] = rand.nextInt(b - a + 1) + a; 
            } 
        } 
    }
    
    public static int det(Matriz M){ 
        if (M.cantFil == 1) { 
            return M.elem[0][0];              
        } 
        int i, j, sum; 
        i = 0; j = 0; sum = 0; 
        while(i < M.cantFil){ 
            sum = sum + (signo(i, j) * M.elem[i][j] * det(M.menor(i, j))); 
            i = i + 1; 
        } 
        return sum;          
    }
    
    public Matriz menor(int i, int j){ 
        Matriz M1 = new Matriz(this); 
        M1.eliminarFil(i); 
        M1.eliminarCol(j); 
        return M1; 
    } 
    
     public static int signo(int i, int j){ 
        int k = i + j; 
        return k%2 == 0 ? 1: -1;       
    } 
     
//    public static int signo2(int i, int j){ 
//        int k = i + j;
//        if (k % 2 == 0) { 
//            return 1;              
//        }else{ 
//            return -1; 
//        }          
//    } 
     
    public static void main(String[] args) {
        Matriz M1 = new Matriz(4, 4);
        Matriz M2 = new Matriz(2, 2);
        LinkedList<Matriz> L1 = new LinkedList<>();
        M1.generarElem(0, 5);
        M2.generarElem(-10, 10);        

        System.out.println("Matriz M1:");
        System.out.println(M1.toString());
//        System.out.println(M1.subMatrix(0, 0, 0, 0));
        System.out.println("Submatriz de M1");
        M1.mostrarSubMat();
//        System.out.println("Matriz M2:");
//        System.out.println(M2);      
        
//        LinkedList<Matriz> listaMatrices = new LinkedList<>();
//        listaMatrices.add(M1);
//        listaMatrices.add(M2);
//        
//        System.out.println(listaMatrices);
//        System.out.println("Submatrices de M1:");
//        M1.encontrarSubMatr();
////        System.out.println(M1.lista);    
//        M1.mostrarMatrices();
//        
//        System.out.println("Submatrices 2x2 de M1:");
////        M1.mostrarSubMat(2, 2);
//        
//        System.out.println();
//        Matriz matriz = new Matriz(2, 2);
//        matriz.generarElem(1, 9);
//        System.out.println(matriz);
//        System.out.println(matriz.menor(0, 1));
//        System.out.println(matriz.det(matriz));
    }
}
