package model.data_structures;

@SuppressWarnings("serial")
/**
 * Esta excepcion se arroja si hay problema con el ordenamiento por ShellSort.
 */
public class ShellSortException extends Exception 
{
	public ShellSortException( String pMsg )
	{
		super( pMsg );
	}
}
