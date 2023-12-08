package Controlador.Dao;

import Controlador.Tda.listas.Exepciones.UbicacionInvalida;
import Controlador.TDA.ListaDinamica.DynamicList;
import Controlador.TDA.ListaDinamica.Nodo;
import com.thoughtworks.xstream.XStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Elias
 * @param <T>
 */
public class DaoImplement<T> implements DaoInterface<T>{
    private Class<T> clazz;
    private XStream conection;
    private String URL;
    
    public DaoImplement(Class<T> clazz) {
        this.clazz = clazz;
        conection = Bridge.getConection();
        URL = Bridge.URL + clazz.getSimpleName() + ".json";
    }
    
    @Override
    public Boolean Persist(T dato) {
        DynamicList<T> ld = all();
        ld.Agregar(dato);
        
        try {
            conection.toXML(ld,new FileWriter(URL));
            return true;
        } 
        catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public Boolean Merge(T data, Integer indice) {
        DynamicList<T> ListaModificar = all();

        if (indice >= 0 && indice < ListaModificar.getLength()) {
            try {
                ListaModificar.modificarPosicion(data, indice);
            } 
            catch (UbicacionInvalida ex) {
            }
            try {
                conection.toXML(ListaModificar, new FileWriter(URL));
                return true;
            } 
            catch (Exception e) {
                return false;
            }
        } 
        else {
            return false;
        }
    }

    @Override
    public DynamicList<T> all() {
        DynamicList<T> dl = new DynamicList<>();
        try {
            dl = (DynamicList<T>)conection.fromXML(new FileReader(URL));
        } 
        catch (Exception e) {
            
        }
        return dl;
    }

    @Override
    public T get(Integer id) {
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public Boolean Eliminar(Integer index) {
        DynamicList<T> listaActualizada = all();

        try {
            listaActualizada.eliminar(index);
            conection.toXML(listaActualizada, new FileWriter(URL));
            return true;
        } 
        catch (Exception e) {
            return false;
        }
    }
}
