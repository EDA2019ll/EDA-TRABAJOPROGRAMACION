package LISTAS.calculadora;

public class TDAPila {
    public int TAM=100;
    private String[] arreglo;
    private int pos;

    public TDAPila(){
        arreglo = new String[TAM];
        pos = -1;
    }
    
    public TDAPila(int n){
        arreglo = new String[n];
        pos = -1;
        TAM = n;
    }
    
    public boolean esVacia(){
        boolean estado = false;
        if (pos == -1)
            estado = true;
        return estado;
    }
    
    public boolean estaLlena(){
        boolean estado = false;
        if (pos == TAM-1)
            estado = true;
        return estado;
    }
    
    public void apilar(String item){
        if (!estaLlena()){
            pos++;
            arreglo[pos] = item;
        }else{
            System.out.println("Pila Llena!!");
        }
    }
    
    public String desapilar(){
        String elementoSacado = arreglo[pos];
        pos--;
        return elementoSacado;
    }
    
    public String cima(){
        return arreglo[pos];
    }
}
