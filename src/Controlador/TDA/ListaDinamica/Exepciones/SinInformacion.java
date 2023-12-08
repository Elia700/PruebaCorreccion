package Controlador.TDA.ListaDinamica.Exepciones;

/**
 *
 * @author Elias
 */
public class SinInformacion extends Exception{
    
    public SinInformacion(){
        
    }
    
    public SinInformacion(String msg) {
        super(msg);
    }
}

