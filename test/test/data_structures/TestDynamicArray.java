package test.data_structures;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.DynamicArray;
import model.data_structures.ElementNotFoundException;
import model.data_structures.InvalidIndexException;

/**
 * Clase de prueba para la clase ArregloDinamico
 */
public class TestDynamicArray
{
	private DynamicArray <String>arreglo;
	private static int TAMANO=5;

	@Before
	public void setUp1()
	{
		try 
		{
			arreglo = new DynamicArray <String>(TAMANO);
			arreglo.addLast( "hola" );
			arreglo.addLast( "como" );
			arreglo.addLast( "vas" );
		}
		catch (InvalidIndexException e) 
		{
			e.printStackTrace();
		}
		catch( ElementNotFoundException ENEE )
		{

		}
	}

	@Test
	public void testArregloDinamico( ) 
	{
		// TODO
		try
		{
			arreglo = new DynamicArray <String>( -20 );
			fail( );
		}
		catch( InvalidIndexException e )
		{
			// Exito
		}
	}

	public void testIncreaseSize( )
	{
		setUp1( );
		arreglo.increaseSize( );
		assertTrue( "Se esperaba que el arreglo duplicara su tamano", 10 == arreglo.maxSize( ));
	}

	@Test
	public void testAddFirst( )
	{
		setUp1(  );
		String s;
		try {
			arreglo.addFirst( "Javier" );
			s = ( String ) arreglo.getElementPos( 1 );
			assertTrue( s.equals("Javier"));
		}
		catch( Exception e )
		{
			fail( );
		}
	}
	
	@Test
	public void testAddLast( )
	{
		setUp1(  );
		String s;
		try {
			s = ( String ) arreglo.getElementPos( 3 );
			assertTrue( s.equals("vas"));
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			fail();
		} catch (InvalidIndexException e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testInsertElement( )
	{
		setUp1( );
		try
		{
			arreglo.insertElement( "pruebaInsertar", 2);
			String s = arreglo.getElementPos( 2 );
			assertTrue( s.equals("pruebaInsertar"));
		}
		catch( Exception e )
		{
			fail( );
		}
	}

	@Test
	public void testRemoveFirst( )
	{
		setUp1( );
		try
		{
			arreglo.removeFirst( );
			String s = arreglo.getElementPos( 1 );
			assertTrue( s.equals("como"));
		}
		catch( Exception e )
		{
			fail( );
		}
	}

	@Test
	public void testRemoveLast( )
	{
		setUp1( );
		try
		{
			arreglo.removeLast( );
			assertTrue( arreglo.getElementPos( 3 ) == null  );
			fail( );
		}
		catch( Exception e )
		{

		}
	}

	@Test
	public void testDeleteElement( )
	{
		setUp1( );
		try
		{
			arreglo.deleteElement( "como" );
			String s = arreglo.getElementPos( 2 );
			assertTrue( s.equals("vas"));
		}
		catch( Exception e )
		{
			fail( );
		}
	}

	@Test
	public void testDeleteElementPos( )
	{
		setUp1( );
		try
		{
			arreglo.deleteElementPos( 2 );
			String s = arreglo.getElementPos( 2 );
			assertTrue( s.equals("vas"));
		}
		catch( Exception e )
		{
			fail( );
		}
	}

	@Test
	public void testFirstElement( )
	{
		setUp1( );
		try
		{
			String s = arreglo.firstElement( );
			assertTrue( s.equals("hola") ); 
		}
		catch( Exception e )
		{
			fail( );
		}
	}

	@Test
	public void testLastElement( )
	{
		setUp1( );
		try
		{
			String s = arreglo.lastElement( );
			assertTrue( s.equals("vas") ); 
		}
		catch( Exception e )
		{
			fail( );
		}
	}
}
