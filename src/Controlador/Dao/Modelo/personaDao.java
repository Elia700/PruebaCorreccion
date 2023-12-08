package Controlador.Dao.Modelo;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.ListaDinamica.DynamicList;
import Modelo.Tramite;
import java.util.Random;

/**
 *
 * @author Elias
 */
public class personaDao extends DaoImplement<Tramite>{
    private DynamicList<Tramite> ListPersonas = new DynamicList<>();
    private Tramite persona;
    
    public personaDao(){
        super (Tramite.class);
    }
    
    public DynamicList<Tramite> getListPersonas() {
        ListPersonas = all();
        return ListPersonas;
    }

    public void setListPersonas(DynamicList<Tramite> ListPersonas) {
        this.ListPersonas = ListPersonas;
    }

    public Tramite getPersona() {
        if(persona == null){
            persona = new Tramite();
        }
        return persona;
    }

    public void setPersona(Tramite persona) {
        this.persona = persona;
    }
    
    public Boolean Persist(){
        persona.setIdPersona(all().getLength()+1);
        return Persist(persona);
    }
    
}
