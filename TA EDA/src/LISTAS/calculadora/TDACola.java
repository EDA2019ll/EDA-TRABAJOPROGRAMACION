package LISTAS.calculadora;

public class TDACola {
    private String[] C; // Cola representada con Arreglos
    private int frente;
    private int ultimo;
    
    
    // Crear una Cola
    public TDACola(int longitud){
        this.frente = -1;
        this.ultimo = -1;
        this.C = new String[longitud];
    }
    
    // Operacion de la cola vacia
    public boolean colaVacia(){
        boolean estado = false;
        if (frente == -1 && ultimo==-1){
            estado = true;
        }
        return estado;
    }
    // Operacion cola llena
    public boolean colaLlena(){
        boolean estado = false;
        int TAM = C.length-1;
        if ((frente == 0 && ultimo == TAM) || (frente==ultimo+1)){
            estado = true;
        }
        return estado;
    }
    // Encolar un elemento a la cola
    public void encolar(String item){
        int TAM = C.length-1;
        if (colaLlena()==false){
            if (colaVacia()==true){
                frente = 0;
                ultimo = 0;
            }else{
                if (ultimo==TAM){
                    ultimo = 0;
                }else{
                    ultimo = ultimo+1;
                }
            }
            C[ultimo] = item;
        }
    }
    // Desencolar un elemento de la cola
    public String desencolar(){
        int TAM = C.length-1;
        String elementoSacado = C[frente];
        if (frente==ultimo){
            frente = -1;
            ultimo = -1;
        }else{
            if (frente == TAM) {// El frente apunta a la ultima posicion de la cola
                frente = 0;
            }else{
                frente = frente+1;
            }
        }
        return elementoSacado;
    }
}
