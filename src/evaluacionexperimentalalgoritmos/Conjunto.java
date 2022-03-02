/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacionexperimentalalgoritmos;

/**
 *
 * @author jstca
 */
public class Conjunto 
{
    private Bag<Object> bolsa;
    //add, remove, in, size, isEmpty
    //Hash del equipo
    private int n;
    
    //Se declara el conjunto vacío
    public Conjunto()
    {    
       bolsa = null;
       n = 0;
    }
    /*
    //Constructor con bolsa hecha
    public Conjunto(Bag<Object> list)
    {
        this.bolsa = list;
        n = list.size();
    }
    */
    
    /*
    Añade un nuevo elemento de cualquier tipo despues de verificar que no este en la lista
    */
    public void Add(Object elemento)
    {
        //Verificar que no este el elemento
        if(!In(elemento)){
            bolsa.add(elemento);
            n++;
        }
    }
    /*
    Remueve el elemento que le indiquemos
    Se le pasa el elemento que queremos eliminar
    Al final la bolsa resultante es inversa a la original sin el elemnto
    En caso de no encontrarlo entonces no hace nada
    */
    public void Remove(Object elemento)
    {
        Bag<Object> bolsaAux = null; //Almacena elementos que vamos sacando
        if(In(elemento)){
            for(int i = 0; i<=n ; i++)
            {
                Object valor = bolsa.remove();
                //Comparar elementos, si no es igual entonces no se guarda
                if (elemento != valor) bolsaAux.add(valor);
            }
            bolsa = bolsaAux;
            n--;
        }
        
    }
    
    /*Ver si un elemento esta en el conjunto
    si el retorno es False entonces no lo encontro
    La lista resultante queda al reves de como ingreso
    */
    
    public Boolean In(Object elemento)
    {
        Bag<Object> bolsaAux = null; //Almacena elementos que vamos sacando
        Boolean existe = false;
        
        //Vamos sacando elementos
        for(int i = 0; i<n ; i++)
        {
            Object valor = bolsa.remove();
            //Comparar elementos
            if (elemento == valor) existe=true;
            bolsaAux.add(valor);
        }
        bolsa = bolsaAux;
        return existe;
    }
    //Saber el tamaño del conjunto
    public int Size(){
        return n;
    }
    //Saber si el conjunto esta vacio
    public Boolean isEmpty(){
        return bolsa == null;
    }
       
}
