package model.data_structures;

@SuppressWarnings("serial")
/**
 * Se arroja esta excepcion si el elemento que se intenta acceder no existe
 */
public class ElementNotFoundException extends Exception 
{
	public ElementNotFoundException( String pMsg )
	{
		super( pMsg );
	}
}
