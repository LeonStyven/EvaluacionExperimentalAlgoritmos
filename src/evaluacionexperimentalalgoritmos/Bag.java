/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacionexperimentalalgoritmos;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author Julian Esteban Gomez Lopez - Julian Styven Colorado Agudelo
 */
//Definir la bolsa e implementar el iterador
public class Bag<Object> implements Iterable<Object> {
    
    
    private Node<Object> primero;
    private int n;
    
    @Override
    public Iterator<Object> iterator(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Definicion de nodo
    private static class Node<Object> {
        private Object item;
        private Node<Object> next;
    }
    
    //Constructor de la bolsa
    public Bag(){
        primero = null;
        n = 0;
    }
    
    //Saber si la bolsa esta vacia
    public boolean isEmpty(){
        return primero == null;
    }
    
    //Saber el tamaño de la bolsa(Cuantos elementos tiene)
    public int size(){
        return n;
    }
    
    //Anadir un nuevo item a la bolsa
    public void add(Object object){ //Recibe el nuevo item
        Node<Object> oldfirst = primero; //Guarda la posicion del antiguo primero
        primero = new Node<Object>();
        primero.item = object; //Asigna el item como nuevo primero
        primero.next=oldfirst; //Se asigna al nuevo, el antiguo primero como siguiente
        n++; //Incrementa el taaño de la lista
    }
    
    public Object remove(){
        if(primero==null) return null;
        Object object = primero.item;
        primero = primero.next;
        n--;
        return object;
    }
    
    //Definicion del iterador
    private class LinkedIterator implements Iterator<Object> {
        private Node<Object> current;

        public LinkedIterator(Node<Object> primero) {
            current = primero;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }
        //No esta implementado el remover
        
        public Object next() {
            if (!hasNext()) throw new NoSuchElementException();
            Object object = current.item;
            current = current.next; 
            return object;
        }
    }
    
    
}
