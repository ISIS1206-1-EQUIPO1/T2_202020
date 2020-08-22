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
	 * @throws ElementoNoExisteException si el elemento a agregar es null o la lista no esta inicializada.
	 */
	public void addFirst( T element ) throws ElementoNoExisteException;

	/**
	 * Agrega el elemento de forma compacta al final de la lista.
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element. Elemento a agregar.
	 * @throws ElementoNoExisteException si el elemento a agregar es null o la lista no esta inicializada.
	 */
	public void addLast( T element ) throws ElementoNoExisteException;

	/**
	 * Agregar un dato de forma compacta en la posicion que ingresa por parámetro 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element. Elemento a agregar.
	 * @param pos. Posicion donde se debe agregar el elemento. pos >= 1
	 * @throws IndiceInvalidoException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementoNoExisteException si el elemento a agregar es null o la lista no esta inicializada.
	 */
	public void insertElement( T element, int pos ) throws ElementoNoExisteException, IndiceInvalidoException;

	/**
	 * Elimina el primer dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @return el elemento eliminado.
	 * @throws ElementoNoExisteException si no hay elementos en el arreglo o no está inicializado.
	 */
	T removeFirst( ) throws ElementoNoExisteException;

	/**
	 * Elimina el ultimo dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @return el elemento eliminado.
	 * @throws ElementoNoExisteException si no hay elementos en el arreglo o no está inicializado.
	 */
	T removeLast( ) throws ElementoNoExisteException;
	
	/**
	 * Elimina el elemento con la posicion que ingresa por parametro.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param pos. La posicion del elemento que se quiere eliminar. pos >= 1
	 * @return el elemento eliminado.
	 * @throws IndiceInvalidoException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementoNoExisteException si no hay elementos en el arreglo o no está inicializado.
	 */
	T deleteElementPos( int pos ) throws ElementoNoExisteException, IndiceInvalidoException;

	/**
	 * Eliminar un dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param element. Elemento de eliminacion en el arreglo
	 * @return el elemento eliminado
	 * @throws ElementoNoExisteException si el elemento a eliminar es inválido, no está en el arreglo, no hay elementos en el arreglo o no esta inicializado
	 */
	T deleteElement( T element ) throws ElementoNoExisteException;
	
	/**
	 * Retorna el primer elemento del arreglo.
	 * @return primer elemento del arreglo.
	 * @throws ElementoNoExisteException si no hay elementos en el arreglo o no está inicializado.
	 */
	T firstElement( ) throws ElementoNoExisteException;
	
	/**
	 * Retorna el ultimo elemento del arreglo.
	 * @return ultimo elemento del arreglo.
	 * @throws ElementoNoExisteException si no hay elementos en el arreglo o no está inicializado.
	 */
	T lastElement( ) throws ElementoNoExisteException;

	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 * @throws IndiceInvalidoException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementoNoExisteException si no hay elementos en el arreglo o no está inicializado.
	 */
	T getElementPos( int i ) throws ElementoNoExisteException, IndiceInvalidoException;
	
	/**
	 * Buscar un dato en el arreglo.
	 * @param dato Objeto de busqueda en el arreglo
	 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
	 * @throws ElementoNoExisteException si el elemento a buscado es inválido, no está en el arreglo, no hay elementos en el arreglo o no esta inicializado
	 */
	T getElement(T dato) throws ElementoNoExisteException;
	
	/**
	 * Retorna si el arreglo tiene o no elementos.
	 * @return true si no hay elementos en el arreglo, false de lo contrario.
	 */
	boolean isEmpty( );
	
	/**
	 * Retorna la posicion del elemento que ingresa por parametros.
	 * @param element el elemento a analizar.
	 * @return posicion del elemento.
	 * @throws ElementoNoExisteException si el elemento a buscado es inválido, no está en el arreglo, no hay elementos en el arreglo o no esta inicializado
	 */
	public int isPresent( T element ) throws ElementoNoExisteException;
	
	/**
	 * Intercambia la informacion de los elementos en dos posiciones validas
	 * @param pos1 la posicion del elemento 1.
	 * @param pos2 la posicion del elemento 2.
	 * @throws IndiceInvalidoException si alguno de los indices no está entre 1 y el numero de elementos del arreglo o los indices son iguales.
	 * @throws ElementoNoExisteException si no hay al menos dos elementos en el arreglo o no esta inicializado
	 */
	public void exchange( int pos1, int pos2 ) throws ElementoNoExisteException, IndiceInvalidoException;
	
	/**
	 * Actualiza la informacion en una posicion valida.
	 * @param pos. La posicion donde se quiere actualizar la informacion.
	 * @param elem. El elemento que se quiere insertar.
	 * @throws IndiceInvalidoException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementoNoExisteException si el elemento a ingresar es inválido o la lista esta vacia o sin inicializar.
	 */
	public void changeInfo( int pos, T elem ) throws ElementoNoExisteException, IndiceInvalidoException;
}
