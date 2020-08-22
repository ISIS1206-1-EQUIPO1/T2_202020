package model.logic;

import model.data_structures.ArregloDinamico;
import model.data_structures.ElementoNoExisteException;
import model.data_structures.IArregloDinamico;
import model.data_structures.IndiceInvalidoException;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo < T extends Comparable< T > >
{
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico<T> datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		try 
		{
			datos = new ArregloDinamico<T>(7);
		} 
		catch (IndiceInvalidoException e) 
		{
			// No deberia pasar por acá
		}
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo( int capacidad ) throws IndiceInvalidoException
	{
		datos = new ArregloDinamico<T>(capacidad);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int actSize()
	{
		return datos.actSize();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void addFirst( T element ) throws ElementoNoExisteException
	{	
		datos.addFirst( element );
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public T getElement( T element ) throws ElementoNoExisteException
	{
		return datos.getElement( element );
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public T deleteElement( T element ) throws ElementoNoExisteException
	{
		return datos.deleteElement( element );
	}


}
