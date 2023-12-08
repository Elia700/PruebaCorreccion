package Controlador.Tda.listas.Exepciones;

/**
 *
 * @author Elias
 */
public class UbicacionInvalida extends Exception{
    
    public UbicacionInvalida(String msg){
        super(msg);
        
    }
    
    public UbicacionInvalida(){
        super("La ubicacion dada está fuera del rango");
    }
    
}
