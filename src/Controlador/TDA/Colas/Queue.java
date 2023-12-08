package Controlador.Tda.Colas;

import Controlador.TDA.ListaDinamica.DynamicList;
import Controlador.Tda.Pilas.Excepcion.FullStackException;
import Controlador.Tda.listas.Exepciones.EmptyList;
/**
 *
 * @author Elias
 */
class Queue<E> extends DynamicList<E>{
    private Integer punta;

    public Queue(Integer Punta) {
        
        this.punta = Punta;
    }
    
    public Boolean isFull(){
        return getLength().intValue() >= punta.intValue();
    }
    
    public void queue(E info) throws EmptyList, FullStackException{
        if(isFull()){
            throw new FullStackException("Cola llena");
//            error
        }
        else{
            Agregar(info);
        }
    }
    
    public E dequeue() throws EmptyList{
        E info = extractFirst();        
        return info;
    }
}
