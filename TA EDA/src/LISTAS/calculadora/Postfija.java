
package LISTAS.calculadora;


import java.text.DecimalFormat;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class Postfija {
    
    private String cadInfija;
    private String cadPostFija;
    private TDACola PostfijaAux;

    public Postfija(String cadInfija) {
        this.cadInfija = cadInfija;
        this.cadPostFija = "";
        PostfijaAux = new TDACola(30);
    }

    public String getCadInfija() {
        return cadInfija;
    }

    public void setCadInfija(String cadInfija) {
        this.cadInfija = cadInfija;
    }

    public String getCadPostFija() {
        return cadPostFija;
    }

    public void setCadPostFija(String cadPostFija) {
        this.cadPostFija = cadPostFija;
    }

    public TDACola getPostfijaAux() {
        return PostfijaAux;
    }

    public void setPostfijaAux(TDACola PostfijaAux) {
        this.PostfijaAux = PostfijaAux;
    }

   
    
    
   public int darPrioridad(String s){
        int prio=0;
         
        switch(s){
            case "^":prio=5;break;
            case "*":case "/": prio=4;break;
            case "+":case "-":prio=3;
        }
        return prio;
   }
        
     
   public  void traducirAPosFija() {
        TDAPila pila = new TDAPila(30);
        TDACola expresion = new TDACola(30);

        int i = 0;
        String cadena = cadInfija;
        String simbolo;
        StringTokenizer token = new StringTokenizer(cadInfija, " ^+*-/()", true);
        while (token.hasMoreTokens()) {
            String t = token.nextToken();
            expresion.encolar(t);
        }

    
        while (!expresion.colaVacia()) {
            simbolo = expresion.desencolar();

            if (simbolo.equals("(")) {
                pila.apilar(simbolo);
            } else if (simbolo.equals(")")) {
                while (pila.esVacia() == false && !pila.cima().equals("(")) {
                    String aux = pila.desapilar();
                    cadPostFija += aux;
                    PostfijaAux.encolar(aux);
                }
                if (pila.esVacia() == false && pila.cima().equals("(")) {
                    String c = pila.desapilar(); //eliminamos el parentesis izquierdo 
                }

            } else if (simbolo.equals("^") == false && simbolo.equals("*") == false
                    && simbolo.equals("/") == false && simbolo.equals("+") == false
                    && simbolo.equals("-") == false) {

                cadPostFija += simbolo;
                PostfijaAux.encolar(simbolo);//concatemos un operando               
            } else {
                while (pila.esVacia() == false && pila.cima().equals("(")==false
                        && darPrioridad(simbolo) <= darPrioridad(pila.cima())) {
                    String aux = pila.desapilar();
                    cadPostFija += aux;
                    PostfijaAux.encolar(aux);
                }
                pila.apilar(simbolo);
            }
            i++;
        }
        while (pila.esVacia() == false) {
            String aux = pila.desapilar();
            cadPostFija += aux;
            PostfijaAux.encolar(aux);
        }
 
    }
    
    
      
      public  Object resolver(String cadPostFija){
        String simbolo;
        int i =0;
        String oper1, oper2;
        double resultado =0;
        TDAPila p = new TDAPila(200); //se usa esta pila definida en String
        while(!PostfijaAux.colaVacia()){
             simbolo=PostfijaAux.desencolar();

            
            if(simbolo.equals("^")==false && simbolo.equals("*")==false && 
               simbolo.equals("/")==false &&simbolo.equals("+")==false && 
               simbolo.equals("-")==false){
                p.apilar(String.valueOf(simbolo));
            }else{
                switch(simbolo){
                        case"+":
                           oper1 =  p.desapilar();
                           oper2 =  p.desapilar();
                           resultado = Float.parseFloat(oper1)  + Float.parseFloat(oper2);
                           p.apilar(String.valueOf(resultado));
                           break;
                        case "-":
                          oper1 =  p.desapilar();
                           oper2 =  p.desapilar();
                           resultado = Float.parseFloat(oper2)  - Float.parseFloat(oper1);
                           p.apilar(String.valueOf(resultado));
                            break;
                        case "*":
                             oper1 =  p.desapilar();
                           oper2 =  p.desapilar();
                           resultado = Float.parseFloat(oper1)  * Float.parseFloat(oper2);
                           p.apilar(String.valueOf(resultado));
                            break;
                        case "/":
                            oper1 =  p.desapilar();
                           oper2 =  p.desapilar();
                           resultado = Double.parseDouble(oper2)  / Double.parseDouble(oper1);
                           /* DecimalFormat f = new DecimalFormat("##.000000000000");*/
                           p.apilar(String.valueOf(String.valueOf(resultado)));
                            break;
                        case "^":
                           oper1 =  p.desapilar();
                           oper2 =  p.desapilar(); 
                           resultado = Math.pow(Float.parseFloat(oper2),  Float.parseFloat(oper1));
                           p.apilar(String.valueOf(resultado));
                            
                    }
                }
            i++;
            }
            
            return p.desapilar() ;
            
        }
    
}
  
     








  
    
 