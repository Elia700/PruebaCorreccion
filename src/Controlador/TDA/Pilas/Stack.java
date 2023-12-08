package Controlador.Tda.Pilas;

import Controlador.TDA.ListaDinamica.DynamicList;
import Controlador.Tda.Pilas.Excepcion.FullStackException;
import Controlador.Tda.listas.Exepciones.EmptyList;
/**
 *
 * @author Elias
 */
class Stack<E> extends DynamicList<E>{
    private Integer capacidadMaxima;

    public Stack(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    public Boolean isFull(){
        return getLength().intValue() >= capacidadMaxima.intValue();
    }
    
    public void push(E info) throws EmptyList, FullStackException{
        if(isFull()){
            throw new FullStackException("Pila llena");
        }
        else{
            Agregar(info, 0);
        }
    }
    
    public E pop() throws EmptyList{
        E info = extractFirst();        
        return info;
    }
}
