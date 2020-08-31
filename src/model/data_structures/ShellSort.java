package model.data_structures;

public class ShellSort 
{
	public static void sort( IDataStructure a )
	{
		int N = a.actSize( );
		int h = 1;
		while ( h < N/3 )
			h = 3*h + 1;
		while( h >= 1 )
		{
			for( int i = h; i < N; i++ )
			{
				for( int j = i; j >= h && less( a.getElementPos( j + 1 ), a.getElementPos( j - h + 1 ) ); j -= h )
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
		a.exchange( i + 1, j + 1 );
	}
}
