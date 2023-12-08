package Controlador.Dao.Modelo;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.DynamicList;
import Modelo.SimulacionT;

/**
 *
 * @author Elias
 */
public class simulacionDao extends DaoImplement<SimulacionT>{
    private DynamicList<SimulacionT> ListSimulacion = new DynamicList<>();
    private SimulacionT simulacionT;
    
    public simulacionDao(){
        super (SimulacionT.class);
    }
    
    public DynamicList<SimulacionT> getListSimulacion() {
        ListSimulacion = all();
        return ListSimulacion;
    }

    public void setListSimulacion(DynamicList<SimulacionT> ListSimulacion) {
        this.ListSimulacion = ListSimulacion;
    }

    public SimulacionT getSimulacion() {
        if(simulacionT == null){
            simulacionT = new SimulacionT();
        }
        return simulacionT;
    }

    public void setSimulacion(SimulacionT simulacion) {
        this.simulacionT = simulacion;
    }

    public Boolean Persist() {
        simulacionT.setIdSimulacion(all().getLength() + 1);
        return Persist(simulacionT);
    }
}
