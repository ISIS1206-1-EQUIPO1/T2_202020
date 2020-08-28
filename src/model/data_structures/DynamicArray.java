package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Generica Arreglo Dinamico.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
@SuppressWarnings("unchecked")
public class DynamicArray< T extends Comparable< T > > implements IDataStructure< T > 
{
	/**
	 * Capacidad maxima del arreglo (Empieza desde 1)
	 */
	private int maxSize;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int actSize;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T[ ] elements;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public DynamicArray( int max ) throws InvalidIndexException
	{
		if( max <= 0 )
			throw new InvalidIndexException( "El tamano ingresado es invalido, se espera un valor positivo" );
		// Crea el arreglo con el tamaNo que entra por parámetro
		elements = (T[ ]) new Comparable[ max ];
		// Asignacion a los atributos
		maxSize = max;
		actSize = 0;
	}

	/**
	 * Retornar el numero de elementos maximo en el arreglo
	 * @return numero de espacios en memoria del arreglo
	 */
	public int maxSize( ) 
	{
		return maxSize;
	}

	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return numero de elementos presentes en el arreglo (posiciones no-null)
	 */
	public int actSize( ) 
	{
		return actSize;
	}

	/**
	 * Duplica el tamano del arreglo dinamico cuando este esta lleno
	 */
	public void increaseSize( )
	{
		maxSize = 2 * maxSize;
		T [ ] copia =  elements;
		elements = (T[]) new Comparable[ maxSize ];
		for ( int i = 0; i < actSize; i++)
			elements[i] = copia[i];
		System.out.println("Arreglo lleno: " + actSize + " - Arreglo duplicado: " + maxSize);
	}

	/**
	 * Agrega el elemento de forma compacta al principio de la lista.
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element. Elemento a agregar
	 * @throws ElementNotFoundException si el elemento a agregar es null o la lista no esta inicializada.
	 */
	public void addFirst(T element) throws ElementNotFoundException 
	{
		if( element == null || elements == null )
			throw new ElementNotFoundException( "El elemento a agregar es null o la lista no está inicializada" );
		if ( actSize == maxSize )
			increaseSize( );
		T [ ] copia = (T[]) new Comparable[ maxSize ];
		copia[ 0 ] = element;
		for( int i = 0; i < actSize; i++ )
			copia[ i + 1 ] = elements[ i ];
		actSize++;
	}

	/**
	 * Agrega el elemento de forma compacta al final de la lista.
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element. Elemento a agregar.
	 * @throws ElementNotFoundException si el elemento a agregar es null o la lista no esta inicializada.
	 */
	public void addLast( T element ) throws ElementNotFoundException
	{
		if( element == null || elements == null )
			throw new ElementNotFoundException( "El elemento a agregar es null o la lista no está inicializada" );
		if ( actSize == maxSize )
			increaseSize( );
		elements[ actSize ] = element;
		actSize++;
	}

	/**
	 * Agregar un dato de forma compacta en la posicion que ingresa por parámetro 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element. Elemento a agregar.
	 * @param pos. Posicion donde se debe agregar el elemento. pos >= 1
	 * @throws InvalidIndexException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementNotFoundException si el elemento a agregar es null o la lista no esta inicializada.
	 */
	public void insertElement(T element, int pos) throws ElementNotFoundException, InvalidIndexException
	{
		if( element == null || elements == null )
			throw new ElementNotFoundException( "El elemento a agregar es null o el arreglo no esta inicializado" );
		if( pos < 1 || pos > actSize )
			throw new InvalidIndexException( "Se esperaba un numero entre 1 y el numero de elementos del arreglo" );
		if ( actSize == maxSize )
			increaseSize( );
		T [ ] copia = (T[]) new Comparable[ maxSize ];
		for( int i = 0, j = 0; i < actSize; i++ )
		{
			if( i == pos - 1 )
				copia[ j++ ] = element;
			copia[ j++ ] = elements[ i ];
		}
		elements = copia;
		actSize++;
	}

	/**
	 * Elimina el primer dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @return el elemento eliminado.
	 * @throws ElementNotFoundException si no hay elementos en el arreglo o no está inicializado.
	 */
	public T removeFirst() throws ElementNotFoundException
	{
		if( elements == null || isEmpty( ) )
			throw new ElementNotFoundException( "No hay elementos en el arreglo o no esta inicializado" );
		T eliminado = elements[ 0 ];
		T [ ] copia = (T[]) new Comparable[ maxSize ];
		for( int i = 1; i < actSize; i++ )
			copia[ i - 1 ] = elements[ i ];
		elements = copia;
		actSize--;
		return eliminado;
	}


	/**
	 * Elimina el ultimo dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @return el elemento eliminado.
	 * @throws ElementNotFoundException si no hay elementos en el arreglo o no está inicializado.
	 */
	public T removeLast() throws ElementNotFoundException 
	{
		if( elements == null || isEmpty( ) )
			throw new ElementNotFoundException( "No hay elementos en el arreglo o no esta inicializado" );
		T eliminado = elements[ actSize - 1  ];
		T [ ] copia = (T[]) new Comparable[ maxSize ];
		for( int i = 0; i < actSize - 1 ; i++ )
			copia[ i ] = elements[ i ];
		elements = copia;
		actSize--;
		return eliminado;
	}

	/**
	 * Eliminar un dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param element. Elemento de eliminacion en el arreglo
	 * @return el elemento eliminado
	 * @throws ElementNotFoundException si el elemento a eliminar es inválido, no está en el arreglo, no hay elementos en el arreglo o no esta inicializado
	 */
	public T deleteElement( T element ) throws ElementNotFoundException 
	{
		if( element == null || elements == null || isEmpty( ) )
			throw new ElementNotFoundException( "El elemento a eliminar es invalido, no hay elementos en el arreglo o no esta inicializado" );
		T eliminado = null;
		T [ ] copia = ( T[ ] ) new Comparable[ maxSize ];
		for( int i = 0, j = 0; i < actSize; i++ )
		{
			if( elements[ i ].compareTo( element ) == 0 )
				eliminado = elements[ i ]; 
			else
				copia[ j++ ] = elements[ i ];
		}
		if( eliminado == null )
			throw new ElementNotFoundException( "El elemento a eliminar no esta en el arreglo" );
		elements = copia;
		actSize--;
		return eliminado;
	}

	/**
	 * Elimina el elemento con la posicion que ingresa por parametro.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param pos. La posicion del elemento que se quiere eliminar. pos >= 1
	 * @return el elemento eliminado.
	 * @throws InvalidIndexException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementNotFoundException si no hay elementos en el arreglo o no está inicializado.
	 */
	public T deleteElementPos(int pos) throws ElementNotFoundException, InvalidIndexException 
	{
		if( elements == null || isEmpty( ) )
			throw new ElementNotFoundException( "El elemento a agregar es null o el arreglo no esta inicializado" );
		if( pos < 1 || pos > actSize )
			throw new InvalidIndexException( "Se esperaba un numero entre 1 y el numero de elementos del arreglo" );
		T eliminado = null;
		T [ ] copia = ( T[ ] ) new Comparable[ maxSize ];
		for( int i = 0, j = 0; i < actSize; i++ )
		{
			if( i == pos - 1 )
				eliminado = elements[ i ]; 
			else
				copia[ j++ ] = elements[ i ];
		}
		elements = copia;
		actSize--;
		return eliminado;
	}

	/**
	 * Retorna el primer elemento del arreglo.
	 * @return primer elemento del arreglo.
	 * @throws ElementNotFoundException si no hay elementos en el arreglo o no está inicializado.
	 */
	public T firstElement() throws ElementNotFoundException 
	{
		if( elements == null || isEmpty( ) )
			throw new ElementNotFoundException( "No hay elementos en el arreglo o no esta inicializado" );
		return elements[ 0 ];
	}

	/**
	 * Retorna el ultimo elemento del arreglo.
	 * @return ultimo elemento del arreglo.
	 * @throws ElementNotFoundException si no hay elementos en el arreglo o no está inicializado.
	 */
	public T lastElement() throws ElementNotFoundException 
	{
		if( elements == null || isEmpty( ) )
			throw new ElementNotFoundException( "No hay elementos en el arreglo o no esta inicializado" );
		return elements[ actSize - 1 ];
	}

	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 * @throws InvalidIndexException si la posición es menor a 1 o mayor al tamaño del arreglo.
	 * @throws ElementNotFoundException si no hay elementos en el arreglo o no está inicializado.
	 */
	public T getElementPos( int pos ) throws ElementNotFoundException, InvalidIndexException
	{
		if( elements == null || isEmpty( ) )
			throw new ElementNotFoundException( "No hay elementos en el arreglo o no esta inicializado" );
		if( pos < 1 || pos > actSize )
			throw new InvalidIndexException( "Se esperaba un numero entre 1 y el numero de elementos del arreglo" );
		return elements[ pos - 1 ];
	}

	/**
	 * Buscar un dato en el arreglo.
	 * @param dato Objeto de busqueda en el arreglo
	 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
	 * @throws ElementNotFoundException si el elemento a buscado es inválido, no está en el arreglo, no hay elementos en el arreglo o no esta inicializado
	 */
	public T getElement( T dato ) throws ElementNotFoundException
	{
		if( dato == null || elements == null || isEmpty( ) )
			throw new ElementNotFoundException( "El buscado es invalido, no hay elementos en el arreglo o no esta inicializado" );
		T element = null;
		for(int i = 0; i < actSize && element == null; i++)
		{
			if( elements[ i ].compareTo( dato ) == 0 )
				element = dato;
		}
		if( element == null )
			throw new ElementNotFoundException( "El elemento buscado no esta en el arreglo" );
		return element;
	}

	/**
	 * Retorna si el arreglo tiene o no elementos.
	 * @return true si no hay elementos en el arreglo, false de lo contrario.
	 */
	public boolean isEmpty() 
	{
		return actSize == 0;
	}

	/**
	 * Retorna la posicion del elemento que ingresa por parametros.
	 * @param element el elemento a analizar.
	 * @return posicion del elemento.
	 * @throws ElementNotFoundException si el elemento a buscado es inválido, no está en el arreglo, no hay elementos en el arreglo o no esta inicializado
	 */
	public int isPresent(T element) throws ElementNotFoundException 
	{
		if( element == null || elements == null || isEmpty( ) )
			throw new ElementNotFoundException( "El buscado es invalido, no hay elementos en el arreglo o no esta inicializado" );
		int pos = -1;
		for( int i = 0; i < actSize && pos == -1; i++ )
		{
			if( elements[ i ].compareTo( element ) == 0 )
				pos = i + 1 ;
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
		if( elements == null || maxSize < 2 )
			throw new ElementNotFoundException( "No hay al menos dos elementos en el arreglo o no esta inicializado" );
		if( pos1 < 1 || pos1 > actSize || pos2 < 1 || pos2 > actSize || pos1 == pos2 )
			throw new InvalidIndexException( "Alguno de los indices no está entre 1 y el numero de elementos del arreglo o los indices son iguales" );
		T [ ] copia = ( T[ ] ) new Comparable[ maxSize ];
		for( int i = 0; i < actSize ; i++ )
		{
			if( i == pos1 - 1 )
				copia[ i ] = elements[ pos2 - 1 ];
			else if( i == pos2 - 1 )
				copia[ i ] = elements[ pos1 - 1 ];
			else
				copia[ i ] = elements[ i ];
		}
		elements = copia;
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
		if( elem == null || elements == null || isEmpty( ) )
			throw new ElementNotFoundException( "El elemento a ingresar es invalido, la lista esta vacia o sin inicializar" );
		if( pos < 1 || pos > actSize )
			throw new InvalidIndexException( "Se esperaba un numero entre 1 y el numero de elementos del arreglo" );
		elements[ pos - 1 ] = elem;
	}
}

