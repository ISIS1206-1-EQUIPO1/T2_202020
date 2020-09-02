package model.data_structures;

/**
 * Clase que se encarga del ordenamiento de una estructura de datos tipo IDataStructure.
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ShellSort 
{
	/**
	 * Metodo que ordena una estructura de datos de tipo IDataStructure
	 * @param IDataStructure dataStructure. La estructura de datos que se quiere ordenar.
	 * @throws ShellSortException. Si existe algun error al ordenar, intercambiar datos o acceder a posiciones del arreglo.
	 */
	public static void sort( IDataStructure dataStructure ) throws ShellSortException
	{
		int N = dataStructure.actSize( );
		int h = 1;
		while ( h < N/3 )
			h = 3*h + 1;
		while( h >= 1 )
		{
			for( int i = h; i < N; i++ )
			{
				try 
				{
					for( int j = i; j >= h && less( dataStructure.getElementPos( j + 1 ), dataStructure.getElementPos( j - h + 1 ) ); j -= h )
						exch( dataStructure, j + 1, j - h + 1);
				}
				catch (ElementNotFoundException | InvalidIndexException e ) 
				{
					throw new ShellSortException( "Error al acceder a elementos para realizar el ordenamiento" );
				}
			}
			h = h / 3;
		}
	}

	/**
	 * Retorna true si v es menor que w, false de lo contrario
	 * @param v primer elemento a comparar.
	 * @param w segundo elemento a comparar.
	 * @return True si v<w, false de lo contrario.
	 */
	private static boolean less( Comparable v, Comparable w )
	{
		return v.compareTo( w ) < 0;
	}

	/**
	 * Intercambia dos elementos de la estructura de datos
	 * @param dataStructure. La estructura de datos a ordenar.
	 * @param i. La posicion del primer elemento a intercambiar.
	 * @param j. La posicion del segundo elemento a intercambiar.
	 * @throws ShellSortException. Si hay problemas al intercambiar elementos.
	 */
	private static void exch( IDataStructure dataStructure, int i, int j ) throws ShellSortException
	{
		try 
		{
			dataStructure.exchange( i , j );
		}
		catch ( ElementNotFoundException | InvalidIndexException e ) 
		{
			throw new ShellSortException( "Error intercambiar elementos al realizar el ordenamiento" );
		}
	}
}
