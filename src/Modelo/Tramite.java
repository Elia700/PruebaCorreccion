package Modelo;

/**
 *
 * @author Elias
 */
public class Tramite {
    private Integer idTramite;
    private String Nombre;
    private Integer Tiempo;

    
    
    public Integer getIdPersona() {
        return idTramite;
    }

    public void setIdPersona(Integer idPersona) {
        this.idTramite = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getTiempo() {
        return Tiempo;
    }

    public void setTiempo(Integer Tiempo) {
        this.Tiempo = Tiempo;
    }
    
    public Tramite() {
        
    }

    public Tramite(Integer idPersona, String Nombre, Integer Tiempo) {
        this.idTramite = idPersona;
        this.Nombre = Nombre;
        this.Tiempo = Tiempo;
    }

    @Override
    public String toString() {
        return "idPersona=" + idTramite + ", Nombre=" + Nombre + ", Tiempo=" + Tiempo + "\n";
    }
    
}
