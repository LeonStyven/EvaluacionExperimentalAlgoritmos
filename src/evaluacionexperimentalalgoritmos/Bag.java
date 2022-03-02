/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacionexperimentalalgoritmos;
import edu.princeton.cs.algs4.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author jstca
 */
//Definir la bolsa e implementar el iterador
public class Bag<Item> implements Iterable<Item> {
    
    
    private Node<Item> primero;
    private int n;
    
    @Override
    public Iterator<Item> iterator(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Definicion de nodo
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
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
    public void add(Item item){ //Recibe el nuevo item
        Node<Item> oldfirst = primero; //Guarda la posicion del antiguo primero
        primero = new Node<Item>();
        primero.item = item; //Asigna el item como nuevo primero
        primero.next=oldfirst; //Se asigna al nuevo, el antiguo primero como siguiente
        n++; //Incrementa el taaño de la lista
    }
    
    public Item remove(){
        if(primero==null) return null;
        Item item = primero.item;
        primero = primero.next;
        n--;
        return item;
    }
    
    //Definicion del iterador
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> primero) {
            current = primero;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }
        //No esta implementado el remover
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
    
}
