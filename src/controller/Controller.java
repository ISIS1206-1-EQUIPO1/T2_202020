package controller;

import java.util.Scanner;

import model.data_structures.ElementNotFoundException;
import model.data_structures.InvalidIndexException;
import model.data_structures.ShellSortException;
import model.logic.DataLoadException;
import model.logic.Model;
import model.logic.Movie;
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
				view.printMessage("--------- \nCargar Datos a una Lista Encadenada. \n");
				try
				{
					StopWatchNano timerNano = new StopWatchNano( );
					model.dataLoad( 1 );
					double time = timerNano.elapsedTime( );
					view.printMessage("Lista Enlazada creada.");
					view.printMessage("Numero actual de elementos " + model.getDataStructure( ).actSize( ) + "\n---------");
					view.printMessage("Carga de peliculas exitosa." + "\n---------");	
					Movie firstMovie = model.getDataStructure( ).firstElement( );
					Movie lastMovie = model.getDataStructure( ).lastElement( );
					view.printMessage("Primera pelicula importada: " + "\nID: " + firstMovie.getId( ) + "\nTitle: " + firstMovie.getTitle( ) + "\nDirector: " + firstMovie.getDirectorName( )  + "\nPopularity: " + firstMovie.getPopularity( ) + "\n---------");
					view.printMessage("Ultima pelicula importada: " + "\nID: " + lastMovie.getId( ) + "\nTitle: " + lastMovie.getTitle( ) + "\nDirector: " + lastMovie.getDirectorName( )  + "\nPopularity: " + lastMovie.getPopularity( ) + "\n---------");
					view.printMessage("Numero de peliculas encontradas en las fuentes: " + model.getDataStructure( ).actSize( )  + "\n---------" );
					view.printMessage("Tiempo de ejecucion en segundos de la carga en Lista Enlazada: " + time + "\n---------" );
				}
				catch( DataLoadException DLe )
				{
					view.printMessage( DLe.getMessage( ) );
				} 
				catch ( ElementNotFoundException ENFe ) 
				{
					view.printMessage( ENFe.getMessage( ) );
				}
				finally
				{
					view.printMessage("\n---------");
				}
				break;
			case 2:
				view.printMessage("--------- \nCargar Datos a un Arreglo Dinamico. \n");
				try
				{
					StopWatchNano timerNano = new StopWatchNano( );
					model.dataLoad( 2 );
					double time = timerNano.elapsedTime( );
					view.printMessage("Arreglo Dinamico creado.");
					view.printMessage("Numero actual de elementos " + model.getDataStructure( ).actSize( ) + "\n---------");
					view.printMessage("Carga de peliculas exitosa." + "\n---------");	
					Movie firstMovie = model.getDataStructure( ).firstElement( );
					Movie lastMovie = model.getDataStructure( ).lastElement( );
					view.printMessage("Primera pelicula importada: " + "\nID: " + firstMovie.getId( ) + "\nTitle: " + firstMovie.getTitle( ) + "\nDirector: " + firstMovie.getDirectorName( )  + "\nPopularity: " + firstMovie.getPopularity( ) + "\n---------");
					view.printMessage("Ultima pelicula importada: " + "\nID: " + lastMovie.getId( ) + "\nTitle: " + lastMovie.getTitle( ) + "\nDirector: " + lastMovie.getDirectorName( )  + "\nPopularity: " + lastMovie.getPopularity( ) + "\n---------");
					view.printMessage("Numero de peliculas encontradas en las fuentes: " + model.getDataStructure( ).actSize( ) + "\n---------" );
					view.printMessage("Tiempo de ejecucion en segundos de la carga en Arreglo Dinamico: " + time + "\n---------" );
				}
				catch( DataLoadException DLe )
				{
					view.printMessage( DLe.getMessage( ) );
				} 
				catch ( ElementNotFoundException ENFe ) 
				{
					view.printMessage( ENFe.getMessage( ) );
				}
				finally
				{
					view.printMessage("\n---------");
				}
				break;
			case 3:
				view.printMessage("--------- \nEncontrar las 20 peliculas con peor promedio de votacion. \n");
				try
				{
					StopWatchNano timerNano = new StopWatchNano( );
					model.shellSortVoteAverage( );
					double time = timerNano.elapsedTime( );
					for( int i = 1, j = 1; i <= model.getDataStructure( ).actSize( ) && j <= 20; i++ )
					{
						Movie actMovie = model.getDataStructure( ).getElementPos( i );
						if( actMovie.getVoteCount( ) > 0 )
						{
							view.printMessage( j + ". " + "ID: " + actMovie.getId( ) + " - Vote average: " + actMovie.getVoteAverage( ) + " - Title: " + actMovie.getTitle( ) + " - Genres: " + actMovie.getGenres( ) );
							j++;
						}
					}
					view.printMessage("\n---------\nTiempo de ejecucion en segundos del ordenamiento: " + time + "\n---------" );
				}
				catch( ShellSortException SSe )
				{
					view.printMessage( SSe.getMessage() );
				}
				catch( InvalidIndexException | ElementNotFoundException e )
				{
					view.printMessage( e.getMessage( ) );
				}
				finally
				{
					view.printMessage("\n---------");
				}
				break;
			case 4: 
				view.printMessage("--------- \n ¡Hasta pronto! \n---------"); 
				lector.close();
				fin = true;
				break;	
			default: 
				view.printMessage("--------- \n ¡Opcion Invalida! \n---------");
				break;
			}
		}
	}
}
