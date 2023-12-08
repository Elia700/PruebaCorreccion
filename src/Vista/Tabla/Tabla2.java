package Vista.Tabla;

import Controlador.TDA.ListaDinamica.DynamicList;
import Controlador.Tda.listas.Exepciones.EmptyList;
import Modelo.Tramite;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Elias
 */
public class Tabla2 extends AbstractTableModel {

    private DynamicList<Tramite> personasTabla;

    public DynamicList<Tramite> getPersonasTabla() {
        return personasTabla;
    }

    public void setPersonasTabla(DynamicList<Tramite> personasTabla) {
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
            Tramite p = personasTabla.getInfo(Fila);
            
            switch (Columna) {
                case 0:
                    return (p != null) ? Fila+1: "";
                case 1:
                    return (p != null) ? p.getNombre() : "";
                case 2:
                    return (p != null) ? p.getTiempo(): "";
                
                default:
                    return null;
            }
        } 
        catch (EmptyList | IndexOutOfBoundsException ex) {
            
        }
        return personasTabla;
    }


    @Override
    public String getColumnName(int columna) {
        switch (columna) {
            case 0:
                return "Id persona";
            case 1:
                return "Nombre";
            case 2:
                return "Tiempo";
            
            default:
                return null;
        }
    }
    
    public int sumarColumna(int columna) {
        int suma = 0;

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

        return suma;
    }
}
