/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evaluacionexperimentalalgoritmos;
import edu.princeton.cs.algs4.*;
/**
 *
 * @author jstca
 */
public class EvaluacionExperimentalAlgoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Solicitar los ids de los equipos para luego calcular el hash
        String id1 = StdIn.readLine();
        String id2 = StdIn.readLine();
        
        int hash = ((id1+id2).hashCode())%4; //Hash del equipo % 4
        StdOut.println(hash);
        
        //Crear 3 conjuntos
        Conjunto conjunto1 = new Conjunto();
        Conjunto conjunto2 = new Conjunto();
        Conjunto result = new Conjunto();
       
        //Segun el resutlado del hash % 4 se ejecuta una u otra operacion
        switch(hash){
        case 0: result = Union(conjunto1, conjunto2);
        break;
        case 1: result = Intersection(conjunto1, conjunto2);
        break;
        case 2: result = Difference(conjunto1, conjunto2);
        break;
        case 3: result = CarteesianProduct(conjunto1, conjunto2);
        break;
        
        default: result = null;
        }
        
        
    }
    
    /*
    Union entre conjuntos
    */
    public static Conjunto Union(Conjunto grupo1, Conjunto grupo2){
        Conjunto resultado = grupo1; //Se empieza asi para luego ir añadiendo los elementos del otro conjunto
        
        int nGrupo2 = grupo2.Size();
        //Se recorre el segundo conjunto y se van sacando sus elementos para pasarlos al resultado
        for(int i = 0; i<nGrupo2;i++){
            resultado.Add(grupo2.Remove());
        }
        return resultado;
    }
    /*
    Interseccion entre conjuntos
    */
    public static Conjunto Intersection(Conjunto grupo1, Conjunto grupo2){
        Conjunto resultado = new Conjunto(); //Aqui se guardan los objetos en comun
        int Size = grupo1.Size();
        
        //Se recorre uno de los conjuntos y si cada elemento se consulta si esta en el otro conjunto, si lo encuentra entonces lo añade al conjunto resultado
        for(int i=0; i<Size;i++){ 
            Object element = grupo1.Remove();
            if(grupo2.In(element)) resultado.Add(element);
        }
        return resultado;
    }
    
    public static Conjunto Difference(Conjunto grupo1, Conjunto grupo2){
        Conjunto resultado = new Conjunto();//Aqui se guardan los objetos que esten en el primero y no esten en el segundo
        int Size = grupo1.Size();
        
        //Se recorre el primer conjunto y cada elemento se busca que no este en el segundo para añadirlo al resultado
        for(int i=0; i<Size;i++){
            Object element = grupo1.Remove();
            if(!grupo2.In(element)) resultado.Add(element);
        }
        return resultado;  
    }
    
    public static Conjunto CarteesianProduct(Conjunto grupo1, Conjunto grupo2){
        Conjunto resultado = new Conjunto();
        //Profe, no se que es el producto cartesiano entre conjuntos, y lo busque y no lo entendi :'c
        
        return resultado; //Es solo para que no de error
    }
    
}
