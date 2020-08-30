package model.data_structures;

public class LinkedList< T extends Comparable< T > > implements IDataStructure< T > 
{
	/**
	 * First element of Linked List
	 */
	private Node < T > header;
	private int actSize;

	public LinkedList ( )
	{
		header = null;
	}

	public LinkedList( T element )
	{
		header = new Node<>( element );
		actSize = 1;
	}

	public int actSize() 
	{
		return actSize;
	}

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

	public T removeFirst() throws ElementNotFoundException 
	{
		if( isEmpty( ) )
			throw new ElementNotFoundException( "La lista esta vacia" );
		T removed = header.getElement( );
		header = header.getNext( );
		actSize--;
		return removed;
	}

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

	public T firstElement() throws ElementNotFoundException 
	{
		if( isEmpty( ) )
			throw new ElementNotFoundException( "La lista esta vacia" );
		return header.getElement( );
	}

	public T lastElement() throws ElementNotFoundException 
	{
		return null;
	}

	public T getElementPos(int i) throws ElementNotFoundException, InvalidIndexException 
	{
		return null;
	}

	public T getElement(T dato) throws ElementNotFoundException 
	{
		return null;
	}

	public boolean isEmpty() 
	{
		return actSize == 0;
	}

	public int isPresent(T element) throws ElementNotFoundException 
	{
		return 0;
	}

	public void exchange(int pos1, int pos2) throws ElementNotFoundException, InvalidIndexException 
	{

	}

	public void changeInfo(int pos, T elem) throws ElementNotFoundException, InvalidIndexException 
	{

	}

}
