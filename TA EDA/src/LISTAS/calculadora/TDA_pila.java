package LISTAS.calculadora;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class TDA_pila {
    public int MAX_ELEMENTOS = 100; 
    private int cima; 
    private char[] arregloPila;
    
    public TDA_pila() {
        cima = -1;
        arregloPila = new char [MAX_ELEMENTOS];  
    }
    
     public TDA_pila(int n) {
        arregloPila = new char[n];
        cima = -1;
        MAX_ELEMENTOS = n;
    }
    
    public void apilar(char operador) {  
        if (!pilaLlena()) 
        {
            cima++;    
            arregloPila[cima]= operador;           
        }
        else   
            JOptionPane.showMessageDialog(null, "Se alcanzo el maximo de componentes");   
    } 
    public char desapilar() { 
        if (!esVacia()) 
        {
            char operadorSacado = arregloPila[cima];
            cima--;
            return operadorSacado;
        } 
        else { 
            return ' '; 
            }     
    }         
    public boolean esVacia() { 
        if (cima == -1)
        {
            return true; 
        }
        else{
            return false;  
            } 
 
    } 
    public boolean pilaLlena() { 
        if (cima +1 ==MAX_ELEMENTOS)
            return true; 
        else 
            return false;
    }     
    
   
    public char Cima(){
        return arregloPila [cima];
    }
    

}