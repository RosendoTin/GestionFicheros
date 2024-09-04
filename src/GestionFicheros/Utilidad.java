package GestionFicheros;

import java.io.File;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

import javax.swing.JFileChooser;

public class Utilidad 
{
	
// Obtencióon de Fichero por explorador	
	public static File obtenerFile()
	{
		File directorio = null;
		
		JFileChooser localizador = new JFileChooser();  // Localizador de ficheros.
		
		localizador.setFileSelectionMode(JFileChooser.FILES_ONLY); // Deja seleccionar solamente los ficheros
		
		int seleccion = localizador.showOpenDialog(localizador); // Abre el dialogo e inica cual es la seleccion
		
		if (seleccion == JFileChooser.APPROVE_OPTION)
		{
			directorio = localizador.getSelectedFile();
			return directorio;
		}
		
		return null;
	}


//Abrimos un JFileChooser para obtener un directorio
	public static File obtenerDirectorio()
	{
		File directorio = null;
	
		JFileChooser localizador = new JFileChooser();  // Localizador de ficheros.
	
		localizador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Deja seleccionar solamente los ficheros
	
		int seleccion = localizador.showOpenDialog(localizador); // Abre el dialogo e inica cual es la seleccion
	
		if (seleccion == JFileChooser.APPROVE_OPTION)
		{
			directorio = localizador.getSelectedFile();
			return directorio;
		}
	
		return null;
	}
	// Obtenemos una lista de ficheros que tenemos dentro de los directorios
	public LinkedList<File> obtenerFicheroDeDirectorio(File directorio)
	{
			
		LinkedList<File> listaDirectorio = new LinkedList<File>();
			
		LinkedList<File> listaFicheros = new LinkedList<File>();
			
		listaDirectorio.add(directorio);
			
		for (int i = 0; i < listaDirectorio.size();i++)
		{
			File direcOrigen = listaDirectorio.get(i);
			
			File[] listaRegistro = direcOrigen.listFiles();
			for (int z=0;z<listaRegistro.length;z++)
			{
				if (listaRegistro[z].isDirectory())
				{
					listaDirectorio.add(listaRegistro[z]);
				} else {
					listaFicheros.add(listaRegistro[z]);
				}
			}
		}
		return listaFicheros;
	}

	// Obtenemos una LinKedList de ficheros dentro de un directorio(revisa los directorios internos, de extesiones determinadas
	public static LinkedList<File> obtenerFicheroDeDirectorio(File directorio,String[] tablaExtension)
	{
			
		LinkedList<File> listaDirectorio = new LinkedList<File>();
			
		LinkedList<File> listaFicheros = new LinkedList<File>();
			
		listaDirectorio.add(directorio);
			
		for (int i = 0; i < listaDirectorio.size();i++)
		{
			File direcOrigen = listaDirectorio.get(i);
			
			File[] listaRegistro = direcOrigen.listFiles();
			for (int z=0;z<listaRegistro.length;z++)
			{
				if (listaRegistro[z].isDirectory())
				{
					listaDirectorio.add(listaRegistro[z]);
				} else {
				
					int index = listaRegistro[z].getName().lastIndexOf('.'); // posicion donde comienza la extension
					String extension = listaRegistro[z].getName().substring(index + 1);
       			            boolean extenCorrecta = false;
			            for (int h = 0; h<tablaExtension.length;h++)
			            {
			            	if (tablaExtension[h].toLowerCase().equals(extension.toLowerCase())) // Lo ponemos todo en minusculas
			            	{
			            		extenCorrecta = true;
			            	}
			            }
			            if (extenCorrecta)
			            {
			            	listaFicheros.add(listaRegistro[z]);
			            }	
					}
				}
			}
			return listaFicheros;
		}
                
    	// Obtenemos una lista de ficheros que tenemos dentro de los directorios
	public static LinkedList<File> obtFicheroDeDirectorio(File directorio)
	{
		LinkedList<File> listaDirectorio = new LinkedList<File>();
			
		LinkedList<File> listaFicheros = new LinkedList<File>();
			
		listaDirectorio.add(directorio);
			
		for (int i = 0; i < listaDirectorio.size();i++)
		{
        		File direcOrigen = listaDirectorio.get(i);
				
        		File[] listaRegistro = direcOrigen.listFiles();
			for (int z=0;z<listaRegistro.length;z++)
			{
				if (listaRegistro[z].isDirectory())
				{
					listaDirectorio.add(listaRegistro[z]);
				} else {
					listaFicheros.add(listaRegistro[z]);
				}
			}
		}
		return listaFicheros;
	}
        
        public static LinkedList<File> obtDirectoriosDeDirectorio(File directorio)
	{
		LinkedList<File> listaDirectorio = new LinkedList<File>();
			
		listaDirectorio.add(directorio);
			
		for (int i = 0; i < listaDirectorio.size();i++)
		{
        		File direcOrigen = listaDirectorio.get(i);
				
        		File[] listaRegistro = direcOrigen.listFiles();
                        
			for (int z=0;z<listaRegistro.length;z++)
			{
				if (listaRegistro[z].isDirectory())
				{
					listaDirectorio.add(listaRegistro[z]);
				}
			}
		}
		return listaDirectorio;
	}

}		

