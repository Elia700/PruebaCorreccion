
package Vista.Tabla;

import Controlador.TDA.ListaDinamica.DynamicList;
import Controlador.Tda.listas.Exepciones.EmptyList;
import Modelo.Tramite;
import Modelo.SimulacionT;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Elias
 */
public class TablaSimulacion extends AbstractTableModel {

    private DynamicList<SimulacionT> personasTabla;

    public DynamicList<SimulacionT> getPersonasTabla() {
        return personasTabla;
    }

    public void setPersonasTabla(DynamicList<SimulacionT> personasTabla) {
        this.personasTabla = personasTabla;
    }
    
    @Override
    public int getRowCount() {
        return personasTabla.getLength();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            SimulacionT p = personasTabla.getInfo(Fila);
            
            switch (Columna) {
                case 0:
                    return (p != null) ? Fila+1: "";
                case 1:
                    return (p != null) ? p.getNumPersonas(): "";
                case 2:
                    return (p != null) ? p.getTotal(): "";
                
                default:
                    return null;
            }
        } 
        catch (EmptyList | IndexOutOfBoundsException ex) {
            
        }
        return personasTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id persona";
            case 1:
                return "Numero Personas";
            case 2:
                return "Tiempo";
            
            default:
                return null;
        }
    }
    
    public int sumarColumna(int columna) {
        double suma = 0.0;

        for (int fila = 0; fila < getRowCount(); fila++) {
            try {
                Object valor = getValueAt(fila, columna);

                if (valor instanceof Number) {
                    suma += ((Number) valor).doubleValue();
                }
            } 
            catch (Exception e) {
            }
        }

        return (int) suma;
    }
}
