package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
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
			throw new IndiceInvalidoException( "El tamano del arreglo debe ser mayor a 0" );
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

	public void addFirst(T element) 
	{
		if ( actSize == maxSize )
			increaseSize( );
		T [ ] copia = (T[]) new Object[ maxSize ];
		copia[ 0 ] = element;
		for( int i = 0; i < actSize; i++ )
			copia[ i + 1 ] = elements[ i ];
		actSize++;
	}

	public void addLast( T dato )
	{
		if ( actSize == maxSize )
			increaseSize( );
		elements[ actSize ] = dato;
		actSize++;
	}

	public void insertElement(T element, int pos) 
	{
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

	public T removeFirst() 
	{
		T eliminado = elements[ 0 ];
		T [ ] copia = (T[]) new Object[ maxSize ];
		for( int i = 1; i < actSize; i++ )
			copia[ i - 1 ] = elements[ i ];
		elements = copia;
		actSize--;
		return eliminado;
	}

	public T removeLast() 
	{
		T eliminado = elements[ actSize - 1  ];
		T [ ] copia = (T[]) new Object[ maxSize ];
		for( int i = 0; i < actSize - 1 ; i++ )
			copia[ i ] = elements[ i ];
		elements = copia;
		actSize--;
		return eliminado;
	}

	public T deleteElement( T dato ) 
	{
		T eliminado = null;
		T [ ] copia = ( T[ ] ) new Object[ maxSize ];
		for( int i = 0, j = 0; i < actSize; i++ )
		{
			if( elements[ i ].compareTo( dato ) == 0 )
				eliminado = elements[ i ]; 
			else
				copia[ j++ ] = elements[ i ];
		}
		elements = copia;
		actSize--;
		return eliminado;
	}

	public T deleteElementPos(int pos) 
	{
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

	public T firstElement() 
	{
		return elements[ 0 ];
	}

	public T lastElement() 
	{
		return elements[ actSize - 1 ];
	}

	public T getElementPos( int i ) 
	{
		return elements != null && i >= 1 && i <= maxSize ? elements[ i - 1 ] : null;
	}

	public T getElement( T dato )
	{
		T element = null;
		for(int i = 0; i < actSize && element == null; i++)
		{
			if( elements[ i ].compareTo( dato ) == 0 )
				element = dato;
		}
		return element;
	}

	public boolean isEmpty() 
	{
		return actSize == 0;
	}

	public int isPresent(T element) 
	{
		int pos = -1;
		for( int i = 0; i < actSize && pos == -1; i++ )
		{
			if( elements[ i ].compareTo( element ) == 0 )
				pos = i + 1 ;
		}
		return pos;
	}

	public void exchange(int pos1, int pos2) 
	{
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

	public void changeInfo(int pos, T elem) 
	{
		elements[ pos - 1 ] = elem;
	}
}

