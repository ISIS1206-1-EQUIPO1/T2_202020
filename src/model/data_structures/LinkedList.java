package model.data_structures;

public class LinkedList< T extends Comparable< T > > implements IDataStructure< T > 
{
	/**
	 * First element of Linked List
	 */
	private Node < T > header;
	private int actSize;
	
	public LinkedList( )
	{
		header = new Node<>( null, null );
		actSize = 0;
	}
	
	public int actSize() 
	{
		return actSize;
	}

	public void addFirst(T element) throws ElementNotFoundException 
	{
		
	}

	public void addLast(T element) throws ElementNotFoundException 
	{
		
	}

	public void insertElement(T element, int pos) throws ElementNotFoundException, InvalidIndexException 
	{
		
	}

	public T removeFirst() throws ElementNotFoundException 
	{
		return null;
	}

	public T removeLast() throws ElementNotFoundException 
	{
		return null;
	}

	public T deleteElementPos(int pos) throws ElementNotFoundException, InvalidIndexException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public T deleteElement(T element) throws ElementNotFoundException 
	{
		return null;
	}

	public T firstElement() throws ElementNotFoundException 
	{
		return null;
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
		return false;
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
