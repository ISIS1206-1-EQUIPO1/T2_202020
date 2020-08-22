package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
@SuppressWarnings("unchecked")
public class ArregloDinamico< T extends Comparable< T > > implements IArregloDinamico< T > 
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
	private T elements[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max ) throws IndiceInvalidoException
	{
		if( max <= 0 )
			throw new IndiceInvalidoException( "El tamano ingresado es invalido, se espera un valor positivo" );
		// Crea el arreglo con el tamaNo que entra por parámetro
		elements = (T[]) new Object[max];
		// Asignacion a los atributos
		maxSize = max;
		actSize = 0;
	}

	public int maxSize( ) 
	{
		return maxSize;
	}

	public int actSize( ) 
	{
		return actSize;
	}

	public void increaseSize( )
	{
		maxSize = 2 * maxSize;
		T [ ] copia =  elements;
		elements = (T[]) new Object[ maxSize ];
		for ( int i = 0; i < actSize; i++)
			elements[i] = copia[i];
		System.out.println("Arreglo lleno: " + actSize + " - Arreglo duplicado: " + maxSize);
	}

	public void addFirst(T element) throws ElementoNoExisteException 
	{
		if( element == null || elements == null )
			throw new ElementoNoExisteException( "El elemento a agregar es null o la lista no está inicializada" );
		if ( actSize == maxSize )
			increaseSize( );
		T [ ] copia = (T[]) new Object[ maxSize ];
		copia[ 0 ] = element;
		for( int i = 0; i < actSize; i++ )
			copia[ i + 1 ] = elements[ i ];
		actSize++;
	}

	public void addLast( T element ) throws ElementoNoExisteException
	{
		if( element == null || elements == null )
			throw new ElementoNoExisteException( "El elemento a agregar es null o la lista no está inicializada" );
		if ( actSize == maxSize )
			increaseSize( );
		elements[ actSize ] = element;
		actSize++;
	}

	public void insertElement(T element, int pos) throws ElementoNoExisteException, IndiceInvalidoException
	{
		if( element == null || elements == null )
			throw new ElementoNoExisteException( "El elemento a agregar es null o el arreglo no esta inicializado" );
		if( pos < 1 || pos > actSize )
			throw new IndiceInvalidoException( "Se esperaba un numero entre 1 y el numero de elementos del arreglo" );
		if ( actSize == maxSize )
			increaseSize( );
		T [ ] copia = (T[]) new Object[ maxSize ];
		for( int i = 0, j = 0; i < actSize; i++ )
		{
			if( i == pos - 1 )
				copia[ j++ ] = element;
			copia[ j++ ] = elements[ i ];
		}
		elements = copia;
		actSize++;
	}

	public T removeFirst() throws ElementoNoExisteException
	{
		if( elements == null || isEmpty( ) )
			throw new ElementoNoExisteException( "No hay elementos en el arreglo o no esta inicializado" );
		T eliminado = elements[ 0 ];
		T [ ] copia = (T[]) new Object[ maxSize ];
		for( int i = 1; i < actSize; i++ )
			copia[ i - 1 ] = elements[ i ];
		elements = copia;
		actSize--;
		return eliminado;
	}

	public T removeLast() throws ElementoNoExisteException 
	{
		if( elements == null || isEmpty( ) )
			throw new ElementoNoExisteException( "No hay elementos en el arreglo o no esta inicializado" );
		T eliminado = elements[ actSize - 1  ];
		T [ ] copia = (T[]) new Object[ maxSize ];
		for( int i = 0; i < actSize - 1 ; i++ )
			copia[ i ] = elements[ i ];
		elements = copia;
		actSize--;
		return eliminado;
	}

	public T deleteElement( T element ) throws ElementoNoExisteException 
	{
		if( element == null || elements == null || isEmpty( ) )
			throw new ElementoNoExisteException( "El elemento a eliminar es invalido, no hay elementos en el arreglo o no esta inicializado" );
		T eliminado = null;
		T [ ] copia = ( T[ ] ) new Object[ maxSize ];
		for( int i = 0, j = 0; i < actSize; i++ )
		{
			if( elements[ i ].compareTo( element ) == 0 )
				eliminado = elements[ i ]; 
			else
				copia[ j++ ] = elements[ i ];
		}
		if( eliminado == null )
			throw new ElementoNoExisteException( "El elemento a eliminar no esta en el arreglo" );
		elements = copia;
		actSize--;
		return eliminado;
	}

	public T deleteElementPos(int pos) throws ElementoNoExisteException, IndiceInvalidoException 
	{
		if( elements == null || isEmpty( ) )
			throw new ElementoNoExisteException( "El elemento a agregar es null o el arreglo no esta inicializado" );
		if( pos < 1 || pos > actSize )
			throw new IndiceInvalidoException( "Se esperaba un numero entre 1 y el numero de elementos del arreglo" );
		T eliminado = null;
		T [ ] copia = ( T[ ] ) new Object[ maxSize ];
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

	public T firstElement() throws ElementoNoExisteException 
	{
		if( elements == null || isEmpty( ) )
			throw new ElementoNoExisteException( "No hay elementos en el arreglo o no esta inicializado" );
		return elements[ 0 ];
	}

	public T lastElement() throws ElementoNoExisteException 
	{
		if( elements == null || isEmpty( ) )
			throw new ElementoNoExisteException( "No hay elementos en el arreglo o no esta inicializado" );
		return elements[ actSize - 1 ];
	}

	public T getElementPos( int pos ) throws ElementoNoExisteException, IndiceInvalidoException
	{
		if( elements == null || isEmpty( ) )
			throw new ElementoNoExisteException( "No hay elementos en el arreglo o no esta inicializado" );
		if( pos < 1 || pos > actSize )
			throw new IndiceInvalidoException( "Se esperaba un numero entre 1 y el numero de elementos del arreglo" );
		return elements[ pos - 1 ];
	}

	public T getElement( T dato ) throws ElementoNoExisteException
	{
		if( dato == null || elements == null || isEmpty( ) )
			throw new ElementoNoExisteException( "El buscado es invalido, no hay elementos en el arreglo o no esta inicializado" );
		T element = null;
		for(int i = 0; i < actSize && element == null; i++)
		{
			if( elements[ i ].compareTo( dato ) == 0 )
				element = dato;
		}
		if( element == null )
			throw new ElementoNoExisteException( "El elemento buscado no esta en el arreglo" );
		return element;
	}

	public boolean isEmpty() 
	{
		return actSize == 0;
	}

	public int isPresent(T element) throws ElementoNoExisteException 
	{
		if( element == null || elements == null || isEmpty( ) )
			throw new ElementoNoExisteException( "El buscado es invalido, no hay elementos en el arreglo o no esta inicializado" );
		int pos = -1;
		for( int i = 0; i < actSize && pos == -1; i++ )
		{
			if( elements[ i ].compareTo( element ) == 0 )
				pos = i + 1 ;
		}
		return pos;
	}

	public void exchange(int pos1, int pos2) throws ElementoNoExisteException, IndiceInvalidoException
	{
		if( elements == null || maxSize < 2 )
			throw new ElementoNoExisteException( "No hay al menos dos elementos en el arreglo o no esta inicializado" );
		if( pos1 < 1 || pos1 > actSize || pos2 < 1 || pos2 > actSize || pos1 == pos2 )
			throw new IndiceInvalidoException( "Alguno de los indices no está entre 1 y el numero de elementos del arreglo o los indices son iguales" );
		T [ ] copia = ( T[ ] ) new Object[ maxSize ];
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

	public void changeInfo(int pos, T elem) throws ElementoNoExisteException, IndiceInvalidoException 
	{
		if( elem == null || elements == null || isEmpty( ) )
			throw new ElementoNoExisteException( "El elemento a ingresar es invalido, la lista esta vacia o sin inicializar" );
		if( pos < 1 || pos > actSize )
			throw new IndiceInvalidoException( "Se esperaba un numero entre 1 y el numero de elementos del arreglo" );
		elements[ pos - 1 ] = elem;
	}
}

