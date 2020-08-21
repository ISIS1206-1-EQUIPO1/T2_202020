package model.data_structures;

public interface IArregloDinamico< T extends Comparable< T > > 
{
	/**
	 * Retornar el numero de elementos maximo en el arreglo
	 * @return numero de espacios en memoria del arreglo
	 */
	int maxSize( );

	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return numero de elementos presentes en el arreglo (posiciones no-null)
	 */
	int actSize( );

	/**
	 * Agrega el elemento de forma compacta al principio de la lista.
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element. Elemento a agregar
	 */
	public void addFirst( T element );

	/**
	 * Agrega el elemento de forma compacta al final de la lista.
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element. Elemento a agregar.
	 */
	public void addLast( T element );

	/**
	 * Agregar un dato de forma compacta en la posicion que ingresa por parámetro 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element. Elemento a agregar.
	 * @param pos. Posicion donde se debe agregar el elemento. pos >= 1
	 */
	public void insertElement( T element, int pos );

	/**
	 * Elimina el primer dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @return el elemento eliminado.
	 */
	T removeFirst( );

	/**
	 * Elimina el ultimo dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @return el elemento eliminado.
	 */
	T removeLast( );
	
	/**
	 * Elimina el elemento con la posicion que ingresa por parametro.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param pos. La posicion del elemento que se quiere eliminar. pos >= 1
	 * @return el elemento eliminado.
	 */
	T deleteElementPos( int pos );

	/**
	 * Eliminar un dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param element. Elemento de eliminacion en el arreglo
	 * @return el elemento eliminado
	 */
	T deleteElement( T element );
	
	/**
	 * Retorna el primer elemento del arreglo.
	 * @return primer elemento del arreglo.
	 */
	T firstElement( );
	
	/**
	 * Retorna el ultimo elemento del arreglo.
	 * @return ultimo elemento del arreglo.
	 */
	T lastElement( );

	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */
	T getElementPos( int i );
	
	/**
	 * Buscar un dato en el arreglo.
	 * @param dato Objeto de busqueda en el arreglo
	 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
	 */
	T getElement(T dato);
	
	/**
	 * Retorna si el arreglo tiene o no elementos.
	 * @return true si no hay elementos en el arreglo, false de lo contrario.
	 */
	boolean isEmpty( );
	
	/**
	 * Retorna la posicion del elemento que ingresa por parametros.
	 * @param element el elemento a analizar.
	 * @return posicion del elemento.
	 */
	public int isPresent( T element );
	
	/**
	 * Intercambia la informacion de los elementos en dos posiciones validas
	 * @param pos1 la posicion del elemento 1.
	 * @param pos2 la posicion del elemento 2.
	 */
	public void exchange( int pos1, int pos2 );
	
	/**
	 * Actualiza la informacion en una posicion valida.
	 * @param pos. La posicion donde se quiere actualizar la informacion.
	 * @param elem. El elemento que se quiere insertar.
	 */
	public void changeInfo( int pos, T elem );
}
