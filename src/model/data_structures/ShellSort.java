package model.data_structures;

public class ShellSort 
{
	public static void sort( IDataStructure a ) throws ElementNotFoundException, InvalidIndexException
	{
		int N = a.actSize( );
		int h = 1;
		while ( h < N/3 )
			h = 3*h + 1;
		while( h >= 1 )
		{
			for( int i = h; i < N; i++ )
			{
				for( int j = i; j >= h && less( a.getElementPos( j ), a.getElementPos( j - h ) ); j -= h )
					exch( a, j, j - h );
			}
			h = h / 3;
		}
	}
	
	private static boolean less( Comparable v, Comparable w )
	{
		return v.compareTo( w ) < 0;
	}
	
	private static void exch( IDataStructure a, int i, int j )
	{
		try {
			a.exchange( i , j  );
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidIndexException e) {
			e.printStackTrace();
		}
	}
}
