package Controlador.TDA.ListaDinamica;

import Controlador.Tda.listas.Exepciones.EmptyList;
import Controlador.Tda.listas.Exepciones.UbicacionInvalida;

/**
 *
 * @author Elias
 * @param <E>
 */
public class DynamicList<E> {

    private Nodo<E> principio;
    private Nodo<E> fin;
    private Integer Length;

    public DynamicList() {
        principio = null;
        fin = null;
        Length = 0;
    }
    
    public Boolean EstaVacio(){
        return(principio == null || Length == 0 );
    }
    
    public void AgregarPrincipio(E info){
        Nodo<E> Ayuda ;
        if(EstaVacio()){
            Ayuda = new Nodo<>(info);
            principio = Ayuda;
            fin = Ayuda;
            Length++;
        }
        else{
            Nodo<E> PrincipioAyuda = principio;
            Ayuda = new Nodo<>(info, PrincipioAyuda);
            principio = Ayuda;
            Length++;
        }
    }
    
    public void AgregarFinal(E info){
        Nodo<E> Ayuda;
        if(EstaVacio()){
            AgregarPrincipio(info);

        }
        else{
            Ayuda = new Nodo<>(info, null);
            fin.setNext(Ayuda);
            fin = Ayuda;
            Length++;
        }
    }
    
    public void Agregar(E info){
        AgregarFinal(info);
    }
    
    private E getPrimero() throws EmptyList{
        if(EstaVacio()){
            throw new EmptyList("La lista esta vacia");
    }
        return principio.getInfo();
    }
    
    
    private E getFinal() throws EmptyList{
        if(EstaVacio()){
            throw new EmptyList("La lista esta vacia");
        }
        return fin.getInfo();
    }
    
    public E getInfo(Integer indice)throws EmptyList, IndexOutOfBoundsException{
        return getNodo(indice).getInfo();
    }
    
    private Nodo<E> getNodo(Integer indice)throws EmptyList, IndexOutOfBoundsException{
        if(EstaVacio()){
            throw new EmptyList("La lista esta vacia");
        }
        else if(indice < 0 || indice.intValue() == Length){
            throw new IndexOutOfBoundsException("Fuera de nodo");
        }
        else if(indice == 0){
            return principio;
        }
        else if(indice == (Length -1)){
            return fin;
        }
        else{
            Nodo<E> Buscar = principio;
            int contador =0;
            while(contador < indice){
                contador++;
                Buscar = Buscar.getNext();
            }
            return Buscar;
        }
    }
       
    public void Agregar (E info, Integer indice)throws EmptyList{
        if(EstaVacio() || indice == 0){
            AgregarPrincipio(info);
        }
        else if(indice.intValue() == Length){
            AgregarFinal(info);
        }
        else{
            Nodo<E> BuscarPrevio = getNodo(indice - 1);
            Nodo<E> Buscar= getNodo(indice);
            Nodo<E> Ayuda = new Nodo<>(info, Buscar);
            BuscarPrevio.setNext(Ayuda);
            Length++;
        }
    }
    
    public void modificarPosicion(E dato, Integer pos) throws UbicacionInvalida{
        if(EstaVacio()){
            Agregar(dato);
        }
        else if(pos>=0 && pos < Length){
            if(pos == 0){
                principio.setInfo(dato);
            } 
            else{
    
                Nodo<E> aux = principio;
    
                for (int i = 0; i < pos; i++ ){
                    aux = aux.getNext();
                }
                aux.setInfo(dato);
            }
        }
        else{
            throw new UbicacionInvalida();
        }
    }
    
    public DynamicList<E> obtenerLista() {
        DynamicList<E> lista = new DynamicList<>();
        Nodo<E> actual = principio;

        while (actual != null) {
            lista.AgregarFinal(actual.getInfo());
            actual = actual.getNext();
        }

        return lista;
    }
    
    public Object[] CovertirEnArreglo() {
        Object[] Arreglos = new Object[Length];
        Nodo<E> actual = principio;

        for (int i = 0; i < Length; i++) {
            Arreglos[i] = actual.getInfo();
            actual = actual.getNext();
        }

        return Arreglos;
    }
    
    public E extractFirst() throws EmptyList{
        if(EstaVacio()){
            throw new EmptyList("Lista vacia");
        }
        else{
            E element = principio.getInfo();
            Nodo<E> help = principio.getNext();
            principio = null;
            principio = help;
            if(Length ==1)
                fin = null;
            Length--;
            return element;
        }
    }
    
    public E extractLast() throws EmptyList{
        if(EstaVacio()){
            throw new EmptyList("Lista vacia");
        }
        else{
            E element = fin.getInfo();
            Nodo<E> help = getNodo(Length-2);
            if(help == null){
                fin =null;
                if(Length == 2){
                    fin = principio;
                }
                else{
                    principio = null;
                }
            }
            else{
               fin = null;
               fin = help;
               fin.setNext(null);
            }
            Length--;
            return element;
        }
    }
    
    public E extract(Integer indice) throws EmptyList{
        if(EstaVacio()){
            throw new EmptyList("La lista esta vacia");
        }
        else if(indice < 0 || indice.intValue() == Length){
            throw new IndexOutOfBoundsException("Fuera de nodo");
        }
        else if(indice == 0){
            return extractFirst();
        }
        else if(indice == (Length -1)){
            return extractLast();
        }
        else{
            Nodo<E> nodo_previo = getNodo(indice-1);
            Nodo<E> nodo_actual = getNodo(indice);
            E info = nodo_actual.getInfo();
            Nodo<E> help_next = nodo_actual.getNext();
            nodo_actual = null;
            nodo_previo.setNext(help_next);
            Length--;
            return info;
        }
    }
    
    public E eliminar(Integer pos) throws EmptyList, IndexOutOfBoundsException {
        if (!EstaVacio()) {
            E dato = null;
            if (pos >= 0 && pos < Length) {
                if (pos == 0) {
                    dato = principio.getInfo();
                    principio = principio.getNext();
                    Length--;
                } 
                else {
                    Nodo<E> aux = principio;
                    
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getNext();
                    }
                    
                    dato = aux.getInfo();
                    Nodo<E> proximo = aux.getNext();
                    aux.setNext(proximo.getNext());
                    Length--;
                }
            } 
            else {
                throw new IndexOutOfBoundsException();
            }
            return dato;
        } 
        else {
            throw new EmptyList();
        }
    }
    
    
    public DynamicList<E> toList(E[] m){
        reset();
        for(int i = 0; i < m.length; i++){
            this.Agregar(m[i]);
        }
        return this;
    }
    
    public void reset() {
        principio = null;
        fin = null;
        Length = 0;
    }

    @Override
    public String toString() {
        StringBuilder StringB = new StringBuilder("listar datos \n");
        try {
            EstaVacio();
            
            Nodo<E> ayuda = principio;
            
            while(ayuda != null){
                StringB.append(ayuda.getInfo().toString());
                ayuda = ayuda.getNext();
            }
        } 
        catch (Exception e) {
            StringB.append(e.getMessage());
        }
        return StringB.toString();
    }

    public Nodo<E> getPrincipio() {
        return principio;
    }

    public void setPrincipio(Nodo<E> principio) {
        this.principio = principio;
    }

    public Nodo<E> getFin() {
        return fin;
    }

    public void setFin(Nodo<E> fin) {
        this.fin = fin;
    }

    public Integer getLength() {
        return Length;
    }

    public void setLength(Integer Length) {
        this.Length = Length;
    }

}
