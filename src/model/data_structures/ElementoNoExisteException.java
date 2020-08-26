package model.data_structures;

@SuppressWarnings("serial")
/**
 * Se arroja esta excepcion si el elemento que se intenta acceder no existe
 */
public class ElementoNoExisteException extends Exception 
{
	public ElementoNoExisteException( String pMsg )
	{
		super( pMsg );
	}
}
