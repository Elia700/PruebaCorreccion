package Modelo;

import Controlador.TDA.ListaDinamica.DynamicList;
import Controlador.Tda.Colas.QueueUltimate;

/**
 *
 * @author Elias
 */
public class SimulacionT {
    private Integer idSimulacion;
    private Integer NumPersonas;
    private Integer Total;
    private Tramite persona;
    private DynamicList<QueueUltimate<Tramite>> ventanilla = new DynamicList<>();
    

    
    
    public Integer getIdSimulacion() {
        return idSimulacion;
    }

    public void setIdSimulacion(Integer idSimulacion) {
        this.idSimulacion = idSimulacion;
    }

    public Integer getNumPersonas() {
        return NumPersonas;
    }

    public void setNumPersonas(Integer NumPersonas) {
        this.NumPersonas = NumPersonas;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer Total) {
        this.Total = Total;
    }

    public Tramite getPersona() {
        return persona;
    }

    public void setPersona(Tramite persona) {
        this.persona = persona;
    }
    
    public SimulacionT() {
        
    }

    public SimulacionT(Integer idSimulacion, Integer NumPersonas, Integer Total, Tramite persona) {
        this.idSimulacion = idSimulacion;
        this.NumPersonas = NumPersonas;
        this.Total = Total;
        this.persona = persona;
    }
    
}

