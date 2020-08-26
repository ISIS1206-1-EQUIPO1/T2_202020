package model.data_structures;

@SuppressWarnings("serial")
/**
 * Esta excepción se arroja si se intenta crear estructuras con tamanos 0 o negativos o al intentar acceder a posiciones fuera de la estructura de datos.
 */
public class IndiceInvalidoException extends Exception 
{
	public IndiceInvalidoException( String pMsg )
	{
		super( pMsg );
	}
}
