/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionFicheros;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author rosendo
 */
public class ModTablaArchivos extends AbstractTableModel
{
    private String[] columna = {"Archivos"};
    LinkedList<File> listaArchivos = new LinkedList<File>();
    
    public ModTablaArchivos()
    {
        
    }
    
    public File ficSeleccion(int reg)
    {
        return listaArchivos.get(reg);
    }
    
    public File movSeleccion(int reg)
    {
        File fichero = listaArchivos.get(reg);
        listaArchivos.remove(reg);
        return fichero;
    }
    
    public void agreFichero(File fichero)
    {
        listaArchivos.add(fichero);
    }
    
    public ModTablaArchivos(LinkedList<File> listaArchivos)
    {
        this.listaArchivos = listaArchivos;
    }
    
    public void recarTabla(LinkedList<File> listaArchivos)
    {
       this.listaArchivos = listaArchivos;
    }
    
    @Override
    public int getRowCount() 
    {
        return listaArchivos.size();
    }

    @Override
    public int getColumnCount()
    {
        return columna.length;
    }

    @Override
    public String getColumnName(int columnIndex) 
    {
        return columna[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        return listaArchivos.get(rowIndex).getName();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
