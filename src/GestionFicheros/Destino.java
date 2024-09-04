/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionFicheros;

import java.io.File;

/**
 *
 * @author rosendo
 */
public class Destino 
{
    private File fichero;
    
    public Destino(File fichero)
    {
        this.fichero = fichero;
    }

    public File getFichero() {
        return fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    @Override
    public String toString() {
        return fichero.getName();
    }
    
    
}
