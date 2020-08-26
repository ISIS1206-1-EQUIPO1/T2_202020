package controller;

import java.util.Scanner;

import model.data_structures.ElementoNoExisteException;
import model.data_structures.IndiceInvalidoException;
import model.logic.CargaDatosException;
import model.logic.Modelo;
import view.View;

public class Controller 
{

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View( );
		modelo = new Modelo( );
	}

	/**
	 * Metodo que maneja las entradas del usuario en la aplicacion, conecta al usuario con la logica de la aplicacion
	 */
	public void run() 
	{
		Scanner lector = new Scanner( System.in );
		boolean fin = false;
		while( !fin )
		{
			view.printMenu( );

			int opcion = lector.nextInt( );
			switch( opcion )
			{
			case 1:
				view.printMessage("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
				int capacidad = lector.nextInt();
				try
				{
					modelo = new Modelo( capacidad );
					view.printMessage("Arreglo Dinamico creado");
					view.printMessage("Numero actual de elementos " + modelo.actSize( ) + "\n---------");
					modelo.cargaDatos( );
					view.printMessage("Carga de peliculas exitosa" + "\n---------");	
					view.printMessage("Primera pelicula importada: " + "\nID: " + modelo.getFirstMovie( ).getId( ) + "\nTitle: " + modelo.getFirstMovie( ).getTitle( )  + "\nDirector: " + modelo.getFirstMovie( ).getDirectorName( )  + "\nPopularity: " + modelo.getFirstMovie( ).getPopularity( ) + "\n---------");
					view.printMessage("Ultima pelicula importada: " + "\nID: " + modelo.getLastMovie( ).getId( ) + "\nTitle: " + modelo.getLastMovie( ).getTitle( ) + "\nDirector: " + modelo.getLastMovie( ).getDirectorName( ) + "\nPopularity: " + modelo.getLastMovie( ).getPopularity( ) + "\n---------");
					view.printMessage("Numero de peliculas encontradas en las fuentes: " + modelo.actSize( ) + "\n---------" );
				}
				catch( IndiceInvalidoException IIE )
				{
					view.printMessage( IIE.getMessage( ) );
				}
				catch( CargaDatosException CCE )
				{
					view.printMessage( CCE.getMessage( ) );
				}
				catch( ElementoNoExisteException ENEE )
				{
					view.printMessage( ENEE.getMessage( ) );
				}
				break;
			case 2:
				view.printMessage("--------- \nEncontrar Buenas Peliculas de un Director \nDar nombre del Director, cambie los espacios por rayas al piso '_': ");
				String nombreDirectorOriginal = lector.next( );
				try
				{
					modelo.buenasPeliculasDirector( nombreDirectorOriginal.replace('_', ' '), view );
				}
				catch( Exception e )
				{
					view.printMessage( e.getMessage( ) );
				}
				break;
			case 3: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}
	}
}
