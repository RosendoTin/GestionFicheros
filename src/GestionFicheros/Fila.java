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
public class Fila 
{
    private File archivo;
    private Destino destino;
    
    public Fila(File archivo)
    {
        this.archivo = archivo;
        destino = new Destino(archivo);
    }

    public File getArchivo() {
        return archivo;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
       
}
