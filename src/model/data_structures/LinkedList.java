package model.data_structures;

/**
 * Clase que representa una estructura de dados de tipo lista enlazada.
 */
public class LinkedList< T extends Comparable< T > > implements IDataStructure< T > 
{
	private Node < T > header;
	private int actSize;

	/**
	 * Crea una nueva lista encadenada sin ningun elemento
	 */
	public LinkedList ( )
	{
		header = null;
	}

	/**
	 * Crea una nueva lista enlazada con un elemento que entra por parámetro como cabeza.
	 * @param element. Elemento que será la cabeza de la lista.
	 */
	public LinkedList( T element )
	{
		header = new Node<>( element );
		actSize = 1;
	}

	/**
	 * Retornar el numero de elementos presentes en la lista enlazada.
	 * @return numero de elementos presentes en la lista enlazada.
	 */
	public int actSize() 
	{
		return actSize;
	}

	/**
	 * Agrega el elemento al principio de la lista.
	 * @param element. Elemento a agregar
	 * @throws ElementNotFoundException si el elemento a agregar es null.
	 */
	public void addFirst(T element) throws ElementNotFoundException 
	{
		if( element == null )
			throw new ElementNotFoundException( "El elemento a ingresar es null." );
		Node <T> newHeader = new Node <T> ( element );
		if( header == null )
			header = newHeader;
		else
		{
			newHeader.setNext( header );
			header = newHeader;
		}
		actSize++;
	}

	/**
	 * Agrega el elemento al final de la lista.
	 * @param element. Elemento a agregar
	 * @throws ElementNotFoundException si el elemento a agregar es null.
	 */
	public void addLast(T element) throws ElementNotFoundException 
	{
		if( element == null )
			throw new ElementNotFoundException( "El elemento a ingresar es null." );
		Node <T> newNode = new Node <T> ( element );
		if( header == null )
			header = newNode;
		else
		{
			Node <T> actual = header;
			while( actual.getNext( ) != null )
				actual = actual.getNext( );
			actual.setNext( newNode );
		}
		actSize++;
	}

	/**
	 * Agregar un dato en la posicion que ingresa por parámetro 
	 * @param element. Elemento a agregar.
	 * @param pos. Posicion donde se debe agregar el elemento. pos >= 1
	 * @throws InvalidIndexException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementNotFoundException si el elemento a agregar es null.
	 */
	public void insertElement(T element, int pos) throws ElementNotFoundException, InvalidIndexException 
	{
		if( element == null )
			throw new ElementNotFoundException( "El elemento a ingresar es null." );
		if( pos < 1 || pos > actSize )
			throw new InvalidIndexException( "El indice debe estar entre 1 y el tamanio del arreglo." );
		Node <T> newNode = new Node <T> ( element );
		if( pos == 1 || header == null )
			addFirst( element );
		else
		{
			Node <T> actual = header;
			for (int i = 1; i < pos - 1; i++) 
				actual = actual.getNext( );
			newNode.setNext( actual.getNext( ) );
			actual.setNext( newNode );
		}
		actSize++;
	}

	/**
	 * Elimina el primer dato de la lista.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @return el elemento eliminado.
	 * @throws ElementNotFoundException si no hay elementos en la lista.
	 */
	public T removeFirst() throws ElementNotFoundException 
	{
		if( isEmpty( ) )
			throw new ElementNotFoundException( "La lista esta vacia" );
		T removed = header.getElement( );
		header = header.getNext( );
		actSize--;
		return removed;
	}

	/**
	 * Elimina el ultimo dato de la lista.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @return el elemento eliminado.
	 * @throws ElementNotFoundException si no hay elementos en la lista.
	 */
	public T removeLast() throws ElementNotFoundException 
	{
		if( isEmpty( ) )
			throw new ElementNotFoundException( "La lista esta vacia" );
		T removed = header.getElement( );
		if( actSize == 1 )
			header = null;
		else
		{
			Node <T> actual = header;
			while( actual.getNext( ).getNext( ) != null )
				actual = actual.getNext( );
			removed = actual.getNext( ).getElement( );
			actual.setNext( null );
		}
		actSize--;
		return removed;
	}

	/**
	 * Elimina el elemento con la posicion que ingresa por parametro.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param pos. La posicion del elemento que se quiere eliminar. pos >= 1
	 * @return el elemento eliminado.
	 * @throws InvalidIndexException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementNotFoundException si no hay elementos en el arreglo.
	 */
	public T deleteElementPos(int pos) throws ElementNotFoundException, InvalidIndexException 
	{
		if( pos < 1 || pos > actSize )
			throw new InvalidIndexException( "El indice debe estar entre 1 y el tamanio del arreglo." );
		T removed = header.getElement( );
		if( pos == 1 || header == null )
			removeFirst( );
		else
		{
			Node <T> actual = header;
			for (int i = 1; i < pos - 1; i++) 
				actual = actual.getNext( );
			removed = actual.getNext( ).getElement( );
			actual.setNext( actual.getNext( ).getNext( ) );
		}
		actSize--;
		return removed;
	}

	/**
	 * Eliminar un dato que ingresa por parámetro de la lista encadenada.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param element. Elemento de eliminacion en el arreglo
	 * @return el elemento eliminado
	 * @throws ElementNotFoundException si el elemento a eliminar es inválido, no está en el arreglo, no hay elementos en el arreglo.
	 */
	public T deleteElement(T element) throws ElementNotFoundException 
	{
		if( element == null )
			throw new ElementNotFoundException( "El elemento a eliminar no puede ser null" );
		T removed = null;
		if( actSize == 1 )
		{
			if( header.getElement( ).compareTo( element ) == 0 )
				removed = removeFirst( );
			else
				throw new ElementNotFoundException( "El elemento buscado no esta en la lista" );
		}
		else
		{
			Node <T> actual = header;
			while( actual.getNext( ).getElement( ).compareTo( element ) != 0 )
				actual = actual.getNext( );
			if( actual.getNext( ) != null )
			{
				removed = actual.getNext( ).getElement( );
				actual.setNext( actual.getNext( ).getNext( ) );
				actSize--;
			}
			else
				throw new ElementNotFoundException( "El elemento buscado no esta en la lista" );
		}
		return removed;
	}

	/**
	 * Retorna el primer elemento de la lista.
	 * @return primer elemento de la lista.
	 * @throws ElementNotFoundException si no hay elementos en el arreglo o no está inicializado.
	 */
	public T firstElement() throws ElementNotFoundException 
	{
		if( isEmpty( ) )
			throw new ElementNotFoundException( "La lista esta vacia" );
		return header.getElement( );
	}

	/**
	 * Retorna el ultimo elemento de la lista.
	 * @return ultimo elemento de la lista.
	 * @throws ElementNotFoundException si no hay elementos en la lista.
	 */
	public T lastElement() throws ElementNotFoundException 
	{
		if(actSize == 0)
			throw new ElementNotFoundException("La lista esta vac�a");
		else if(actSize == 1)
			return header.getElement();
		else
		{
			Node <T> actual = header;
			while(actual.getNext( ) != null)
				actual = actual.getNext( );
			return actual.getElement( );
		}
	}

	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta.
	 * @throws InvalidIndexException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementNotFoundException si no hay elementos en el arreglo.
	 */
	public T getElementPos(int i) throws InvalidIndexException, ElementNotFoundException 
	{
		if( isEmpty( ) )
			throw new ElementNotFoundException( "La lista esta vacia." );
		if( i <  1 || i > actSize)
			throw new InvalidIndexException("El indice solicitado no se encuentra disponible la lista actual");
		Node <T> actual = header;
		for( int j = 1; j < i; j++)
			actual = actual.getNext();
		return actual.getElement();
	}

	/**
	 * Buscar un dato en el arreglo.
	 * @param dato Objeto de busqueda en el arreglo
	 * @return elemento encontrado en el arreglo (si existe).
	 * @throws ElementNotFoundException si el elemento a buscado es inválido, no está en el arreglo, no hay elementos en el arreglo,
	 */
	public T getElement(T dato) throws ElementNotFoundException 
	{
		if( dato == null || isEmpty( ) )
			throw new ElementNotFoundException( "El elemento buscado no puede ser null o la lista esta vacia" );
		T get = null;
		Node <T> actual = header;
		while( actual != null )
		{
			if( actual.getElement( ).compareTo( dato ) == 0 )
				get = actual.getElement( );
			actual = actual.getNext( );
		}
		if( get == null )
			throw new ElementNotFoundException( "El elemento buscado no esta en el arreglo" );
		return get;
	}

	/**
	 * Retorna si la lista tiene o no elementos.
	 * @return true si no hay elementos en el arreglo, false de lo contrario.
	 */
	public boolean isEmpty() 
	{
		return actSize == 0;
	}

	/**
	 * Retorna la posicion del elemento que ingresa por parametro.
	 * @param element el elemento a analizar.
	 * @return posicion del elemento.
	 * @throws ElementNotFoundException si el elemento a buscado es inválido, no está en la lista, no hay elementos en el arreglo o no esta inicializado
	 */
	public int isPresent(T element) throws ElementNotFoundException 
	{
		int pos = -1;
		boolean get = false;
		Node <T> actual = header;
		for(int i = 1; i < actSize && !get; i++)
		{
			if(actual.getElement().compareTo(element) == 0)
			{
				pos = i;
				get = true;
			}
			actual = actual.getNext( );
		}
		return pos;
	}

	/**
	 * Intercambia la informacion de los elementos en dos posiciones validas
	 * @param pos1 la posicion del elemento 1.
	 * @param pos2 la posicion del elemento 2.
	 * @throws InvalidIndexException si alguno de los indices no está entre 1 y el numero de elementos del arreglo o los indices son iguales.
	 * @throws ElementNotFoundException si no hay al menos dos elementos en el arreglo o no esta inicializado
	 */
	public void exchange(int pos1, int pos2) throws ElementNotFoundException, InvalidIndexException 
	{
		if( pos1 < 1 || pos1 > actSize || pos2 < 1 || pos2 > actSize)
			throw new InvalidIndexException( "El indice debe estar entre 1 y el tamanio del arreglo." );

		Node<T> nodo1 = null;
		Node<T> nodo2 = null; 
		Node <T> actual = header;
		for (int i = 1; i <= actSize; i++) 
		{
			if(i == pos1)
				nodo1 = actual;
			if(i==pos2)
				nodo2 = actual;
			actual = actual.getNext();
		}
		if(nodo1 == null || nodo2 == null)
		{
			throw new ElementNotFoundException ( "No existen elementos en las posiciones indicadas" );
		}
		else
		{
			T element = nodo1.getElement();
			nodo1.setElement(nodo2.getElement());
			nodo2.setElement(element);
		}
	}

	/**
	 * Actualiza la informacion en una posicion valida.
	 * @param pos. La posicion donde se quiere actualizar la informacion.
	 * @param elem. El elemento que se quiere insertar.
	 * @throws InvalidIndexException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementNotFoundException si el elemento a ingresar es inválido o la lista esta vacia o sin inicializar.
	 */
	public void changeInfo(int pos, T elem) throws ElementNotFoundException, InvalidIndexException 
	{
		if( pos < 1 || pos > actSize)
			throw new InvalidIndexException( "El indice debe estar entre 1 y el tamanio del arreglo." );
		if( elem == null )
			throw new ElementNotFoundException( "El elemento con el cual remplazar no puede ser null" );
		Node <T> actual = header;
		for( int j = 1; j < pos; j++ )
			actual = actual.getNext( );
		actual.setElement( elem );
	}
}
