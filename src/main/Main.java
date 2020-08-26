package main;
import controller.Controller;
import model.logic.Modelo;

public class Main 
{

	/**
	 * Ejecuta el programa
	 * @param args parametreos de ejecucion
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		Modelo modelo = new Modelo( );
		Controller controler = new Controller( );
		controler.run( );
	}
}