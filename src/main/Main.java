package main;
import controller.Controller;
import model.logic.Model;

public class Main 
{

	/**
	 * Ejecuta el programa
	 * @param args parametreos de ejecucion
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		Model model = new Model( );
		Controller controler = new Controller( );
		controler.run( );
	}
}