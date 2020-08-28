package controller;

import java.util.Scanner;

import model.data_structures.ElementNotFoundException;
import model.data_structures.InvalidIndexException;
import model.logic.DataLoadException;
import model.logic.Model;
import view.View;

public class Controller 
{

	/* Instancia del Modelo*/
	private Model model;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View( );
		model = new Model( );
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
					model = new Model( capacidad );
					view.printMessage("Arreglo Dinamico creado");
					view.printMessage("Numero actual de elementos " + model.actSize( ) + "\n---------");
					model.dataLoad( );
					view.printMessage("Carga de peliculas exitosa" + "\n---------");	
					view.printMessage("Primera pelicula importada: " + "\nID: " + model.getFirstMovie( ).getId( ) + "\nTitle: " + model.getFirstMovie( ).getTitle( )  + "\nDirector: " + model.getFirstMovie( ).getDirectorName( )  + "\nPopularity: " + model.getFirstMovie( ).getPopularity( ) + "\n---------");
					view.printMessage("Ultima pelicula importada: " + "\nID: " + model.getLastMovie( ).getId( ) + "\nTitle: " + model.getLastMovie( ).getTitle( ) + "\nDirector: " + model.getLastMovie( ).getDirectorName( ) + "\nPopularity: " + model.getLastMovie( ).getPopularity( ) + "\n---------");
					view.printMessage("Numero de peliculas encontradas en las fuentes: " + model.actSize( ) + "\n---------" );
				}
				catch( InvalidIndexException IIE )
				{
					view.printMessage( IIE.getMessage( ) );
				}
				catch( DataLoadException CCE )
				{
					view.printMessage( CCE.getMessage( ) );
				}
				catch( ElementNotFoundException ENEE )
				{
					view.printMessage( ENEE.getMessage( ) );
				}
				break;
			case 2:
				view.printMessage("--------- \nEncontrar Buenas Peliculas de un Director \nDar nombre del Director, cambie los espacios por rayas al piso '_': ");
				String nombreDirectorOriginal = lector.next( );
				try
				{
					model.buenasPeliculasDirector( nombreDirectorOriginal.replace('_', ' '), view );
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
