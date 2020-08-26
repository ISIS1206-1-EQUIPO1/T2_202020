package model.logic;

@SuppressWarnings("serial")
/**
 * Se arroja esta excepcion si hay problemas al cargar los datos del archivo .csv.
 */
public class CargaDatosException extends Exception 
{
	public CargaDatosException( String pMsg )
	{
		super( pMsg );
	}
}
