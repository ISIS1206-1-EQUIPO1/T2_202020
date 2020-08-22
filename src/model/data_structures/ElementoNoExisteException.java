package model.data_structures;

@SuppressWarnings("serial")
public class ElementoNoExisteException extends Exception 
{
	public ElementoNoExisteException( String pMsg )
	{
		super( pMsg );
	}
}
