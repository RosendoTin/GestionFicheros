/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionFicheros;

import java.io.File;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author rosendo
 */
public class ModTablaDestino extends AbstractTableModel
{
    private String[] columna = {"Archivo","Directorio Destino"};
    
    private Class[] clasColumna = {String.class,Destino.class};
    
    private ArrayList<Fila> listaFilas = new ArrayList<Fila>();
    
    public ModTablaDestino()
    {
        
    }
    
    public File ficSeleccion(int reg)
    {
        return listaFilas.get(reg).getArchivo();
    }
    
    public File movSeleccion(int reg)
    {
        File fichero = listaFilas .get(reg).getArchivo();
        listaFilas.remove(reg);
        return fichero;
    }
    
    public void agreFichero(File fichero)
    {
        listaFilas.add(new Fila(fichero));
    }
    
    
    @Override
    public int getRowCount() 
    {
        return listaFilas.size();
    }

    @Override
    public int getColumnCount() 
    {
        return columna.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        
        switch (columnIndex) 
        {
            case 0:
                return listaFilas.get(rowIndex).getArchivo().getName();
            case 1:
                return listaFilas.get(rowIndex).getDestino().toString();
            default: 
                return null;
            }
    }

    @Override
    public String getColumnName(int columnIndex) 
    {
        return columna[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) 
    {
        return clasColumna[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) 
    {
        return true;
    }

/*    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/    
}

