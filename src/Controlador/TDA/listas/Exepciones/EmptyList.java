package Controlador.Tda.listas.Exepciones;

/**
 *
 * @author Elias
 */
public class EmptyList extends Exception{
    
    public EmptyList(){
        
    }
    
    public EmptyList(String msg) {
        super(msg);
    }
}
