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
    
    //Constructor con bolsa hecha
    public Conjunto(Bag<Object> list)
    {
        this.bolsa = list;
        n = list.size();
    }
    
    //Corregir add, verificar No iguales
    public void Add(Object elemento)
    {
        bolsa.add(elemento);
        n++;
    }
    
    public void Remove(Object elemento)
    {
        for(int i = 0; i<=n ; i++)
        {
            
        }
    }
    
    
    public int In(Object elemento)
    {
        Bag<Object> bolsa2;
        int indice = -1;
        for(int i = 0; i<=n ; i++)
        {
            Object valor = bolsa.remove();
            
            
            if (elemento == valor)
            {
                indice++;
                
                
            }
        }
        return indice;
    }
            
    
    
            
}
