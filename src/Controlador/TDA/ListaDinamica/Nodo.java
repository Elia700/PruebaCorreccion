package Controlador.TDA.ListaDinamica;

/**
 *
 * @author Elias
 * @param <E>
 */
public class Nodo<E> {

    private E info;
    private Nodo<E> Next;

    public Nodo(E info) {
        this.info = info;
        Next = null;

    }

    public Nodo(E info, Nodo<E> siguiente) {
        this.info = info;
        this.Next = siguiente;

    }

    public Nodo() {
        Next = null;
        info = null;

    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Nodo<E> getNext() {
        return Next;
    }

    public void setNext(Nodo<E> siguiente) {
        this.Next = siguiente;
    }
    
    public String toString() {
        if (info != null) {
            return info.toString();
        } 
        else {
            return null;
        }
    }
}
