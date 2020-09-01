package model.data_structures;
import model.logic.Movie;

public class ShellSort 
{
	public static void sort( IDataStructure a ) throws ShellSortException
	{
		int N = a.actSize( );
		int h = 1;
		while ( h < N/3 )
			h = 3*h + 1;
		while( h >= 1 )
		{
			for( int i = h; i < N; i++ )
			{
					try 
					{
						for( int j = i; j >= h && less( a.getElementPos( j + 1 ), a.getElementPos( j - h + 1 ) ); j -= h )
							exch( a, j + 1, j - h + 1);
					}
					catch (ElementNotFoundException | InvalidIndexException e ) 
					{
						throw new ShellSortException( "Error al acceder a elementos para realizar el ordenamiento" );
					}
			}
			h = h / 3;
		}
	}
	
	private static boolean less( Comparable v, Comparable w )
	{
		Movie m1 = ( Movie ) v;
		Movie m2 = ( Movie ) w;
		return m1.compareToVoteAverage( m2 ) < 0;
	}
	
	private static void exch( IDataStructure a, int i, int j ) throws ShellSortException
	{
		try 
		{
			a.exchange( i , j  );
		}
		catch ( ElementNotFoundException | InvalidIndexException e ) 
		{
			throw new ShellSortException( "Error intercambiar elementos al realizar el ordenamiento" );
		}
	}
}
