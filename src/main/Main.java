package main;
import controller.Controller;
import model.logic.DataLoadException;
import model.logic.Model;

public class Main 
{

	/**
	 * Ejecuta el programa
	 * @param args parametreos de ejecucion
	 * @throws DataLoadException 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws DataLoadException 
	{
		Model model = new Model( );
		Controller controler = new Controller( );
		controler.run( );
	}
}