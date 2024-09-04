/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionFicheros;

/**
 *
 * @author rosendo
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
 
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
 
/**
 * A custom editor for cells in the Destino column.
 * @author www.codejava.net
 *
 */
public class DestinoCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener {
 
    private Destino destino;
    private LinkedList<File> listaDirectorios;
     
    public DestinoCellEditor(LinkedList<File> listaDirectorios) {
        this.listaDirectorios = listaDirectorios;
    }
     
    @Override
    public Object getCellEditorValue() {
        return this.destino;
    }
 
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
       
        if (value instanceof Destino) {
            this.destino = (Destino) value;
            System.out.println("Pasando por destino");
        }
         
        JComboBox<Destino> comboDestino = new JComboBox<Destino>();
         
        for (int i = 0; i< listaDirectorios.size();i++)
        {
            comboDestino.addItem(new Destino(listaDirectorios.get(i)));
        }
        
        comboDestino.setSelectedItem(destino);
        comboDestino.addActionListener(this);
         
        if (isSelected) {
            comboDestino.setBackground(table.getSelectionBackground());
        } else {
            comboDestino.setBackground(table.getSelectionForeground());
        }
         
        return comboDestino;
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox<Destino> comboDestino = (JComboBox<Destino>) event.getSource();
        this.destino = (Destino) comboDestino.getSelectedItem();
    }
 
}
