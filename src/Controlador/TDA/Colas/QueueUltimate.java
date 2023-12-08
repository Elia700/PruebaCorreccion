package Controlador.Tda.Colas;

import Controlador.Tda.Pilas.Excepcion.FullStackException;
import Controlador.Tda.listas.Exepciones.EmptyList;

/**
 *
 * @author Elias
 */
public class QueueUltimate<E> {
    private Queue<E> tail;

    public QueueUltimate(Integer legngt) {
        this.tail = new Queue<>(legngt);
    }
    
    public void queue(E info) throws EmptyList, FullStackException{
        tail.queue(info);
    }
    
    public E dequeue() throws EmptyList{
        return tail.dequeue();
    }
    
    public Integer length(){
        return tail.getLength();
    }
    
    public Boolean isfull(){
        return tail.isFull();
    }
    
    public void print(){
        System.out.println("Queue");
        System.out.println(tail.toString());
        System.out.println("");
    }
    
    public E getDatos(Integer pos) throws EmptyList {
        return tail.getInfo(pos);
    }
}
