package model.logic;

@SuppressWarnings("serial")
/**
 * Se arroja esta excepcion si hay problemas al cargar los datos del archivo .csv.
 */
public class DataLoadException extends Exception 
{
	public DataLoadException( String pMsg )
	{
		super( pMsg );
	}
}
