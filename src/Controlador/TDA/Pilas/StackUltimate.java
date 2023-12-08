package Controlador.Tda.Pilas;

import Controlador.Tda.Pilas.Excepcion.FullStackException;
import Controlador.Tda.listas.Exepciones.EmptyList;

/**
 *
 * @author Elias
 */
public class StackUltimate<E> {
    private Stack<E> stack;

    public StackUltimate(Integer legngt) {
        this.stack = new Stack<>(legngt);
    }
    
    public void push(E info) throws EmptyList, FullStackException{
        stack.push(info);
    }
    
    public E pop() throws EmptyList{
        return stack.pop();
    }
    
    public Integer length(){
        return stack.getLength();
    }
    
    public Boolean isfull(){
        return stack.isFull();
    }
    
    public void print(){
        System.out.println("Stack");
        System.out.println(stack.toString());
        System.out.println("");
    }
}
