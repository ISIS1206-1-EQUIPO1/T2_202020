package controller;

/**
 * Clase encargada de contabilizar el tiempo de ejecucion
 */
public class StopWatchNano
{
	/**
	 * Constante que indica el tiempo en el que se inicia.
	 */
	private final long start;
	
	/**
	 * Metodo constructor de la clase.
	 * Inicializa la constante start, como el tiempo actual (cuando se llama el metodo)
	 */
	public StopWatchNano( )
	{
		start = System.nanoTime( );
	}
	
	/**
	 * Retorna en segundos el tiempo transcurrido entre el inicio y el tiempo actual.
	 * @return tiempo transcurrido.
	 */
	public double elapsedTime( )
	{
		long now = System.nanoTime( );
		return ( now - start ) / 1.0E9;
	}
}
