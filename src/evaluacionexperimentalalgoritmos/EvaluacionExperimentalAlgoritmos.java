/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evaluacionexperimentalalgoritmos;
import edu.princeton.cs.algs4.*;
import java.util.Random;
/**
 *
 * @author Julian Esteban Gomez Lopez - Julian Styven Colorado Agudelo
 */
public class EvaluacionExperimentalAlgoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Solicitar los ids de los equipos para luego calcular el hash
        StdOut.println("Ingrese el primer ID");
        String id1 = StdIn.readLine();
        StdOut.println("Ingrese el Segundo ID");
        String id2 = StdIn.readLine();
        
        int hash = ((id1+id2).hashCode())%4; //Hash del equipo % 4
        StdOut.println("El resultante del hash, modulo 4 es: " + hash);
        
        //Crear los conjuntos para realizar la operacion
        Conjunto conjunto1 = new Conjunto();
        Conjunto conjunto2 = new Conjunto();
        Conjunto result = new Conjunto();
       
        //Segun el resutlado del hash % 4 se ejecuta una u otra operacion
        switch(hash){
        case 0: result = Union(conjunto1, conjunto2);
                StdOut.println("La operacion escogida es union");
        break;
        case 1: result = Intersection(conjunto1, conjunto2);
                StdOut.println("La operacion escogida es Interseccion");
        break;
        case 2: result = Difference(conjunto1, conjunto2);
                StdOut.println("La operacion escogida es Diferencia");
        break;
        case 3: result = CarteesianProduct(conjunto1, conjunto2);
                StdOut.println("La operacion escogida es Producto Cartesiano");
        break;
        
        default: result = null;
        }
        
        
        //Se pregunta al usuario sobre qué desea hacer con el tamaño de los Conjuntos
        StdOut.println("Ingrese el tamaño que desea para los conjuntos: ");
        int n = StdIn.readInt();
        String respuesta = StdIn.readLine().toUpperCase();
        
        do{
            
            StdOut.println("El tiempo que se usó para realizar todas las uniones es de: " + Prueba(n));
            StdOut.println("Se analizo un conjunto con "+ n +" elementos");
            StdOut.println("Introduzca cualquier cosa para duplicar\no introduzca N para detener");
            
            //En caso de que quiera duplicar el tamaño, lo realiza
            respuesta = StdIn.readLine().toUpperCase();
            
            n = n*2;
        }while(!respuesta.equals("N"));

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
    
    public static long Prueba(int n)
    {
        //Crear 3 conjuntos
        Conjunto conjunto1 = new Conjunto();
        Conjunto conjunto2 = new Conjunto();
        Conjunto result = new Conjunto();
        
        Random varRandom = new Random();
        
        //Se crea un ciclo que llena dos conjuntos creados con números aleatorios 
        //importados desde la librería de java
        for(int i = 0; i<n ; i++ )
        {
            conjunto1.Add(varRandom.nextInt(1,501));
            conjunto2.Add(varRandom.nextInt(1,501));
        }
        //Se inicia el contador de cuando tiempo tarda toda la prueba
        long tiempoInicioPrueba = System.currentTimeMillis();
        
        //Se realiza la prueba la cantidad de veces solicitada para medir el tiempo de esta
        for(int j = 1; j < 21; j++){
            long tiempoPrueba = System.currentTimeMillis();
            result = Union(conjunto1, conjunto2);
            //Se compara el tiempo que tarda en hacer cada prueba y se retorna lo que tarda cada prueba
            StdOut.println("La union numero " + j + " tardo: " + (System.currentTimeMillis()-tiempoPrueba));
        }
        return (System.currentTimeMillis()-tiempoInicioPrueba);
    }
}
