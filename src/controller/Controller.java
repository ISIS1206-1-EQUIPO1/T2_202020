package controller;

import java.util.Scanner;

import model.data_structures.ElementNotFoundException;
import model.data_structures.InvalidIndexException;
import model.data_structures.ShellSortException;
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
				view.printMessage("--------- \nCargar Datos a una Lista Encadenada. \n");
				try
				{
					model.dataLoad( 1 );
					view.printMessage("Lista Enlazada creada.");
					view.printMessage("Numero actual de elementos " + model.getLinkedList( ).actSize( ) + "\n---------");
					view.printMessage("Carga de peliculas exitosa." + "\n---------");	
					view.printMessage("Primera pelicula importada: " + "\nID: " + model.getLinkedList( ).firstElement( ).getId( ) + "\nTitle: " + model.getLinkedList( ).firstElement( ).getTitle( )  + "\nDirector: " + model.getLinkedList( ).firstElement( ).getDirectorName( )  + "\nPopularity: " + model.getLinkedList( ).firstElement( ).getPopularity( ) + "\n---------");
					view.printMessage("Ultima pelicula importada: " + "\nID: " + model.getLinkedList( ).lastElement( ).getId( ) + "\nTitle: " + model.getLinkedList( ).lastElement( ).getTitle( )  + "\nDirector: " + model.getLinkedList( ).lastElement( ).getDirectorName( )  + "\nPopularity: " + model.getLinkedList( ).lastElement( ).getPopularity( ) + "\n---------");
					view.printMessage("Numero de peliculas encontradas en las fuentes: " + model.getLinkedList( ).actSize( ) + "\n---------" );
				}
				catch( DataLoadException DLe )
				{
					view.printMessage( DLe.getMessage( ) );
				} 
				catch ( ElementNotFoundException ENFe ) 
				{
					view.printMessage( ENFe.getMessage( ) );
				}
				break;
			case 2:
				view.printMessage("--------- \nCargar Datos a un Arreglo Dinamico. \n");
				try
				{
					model.dataLoad( 2 );
					view.printMessage("Arreglo Dinamico creado.");
					view.printMessage("Numero actual de elementos " + model.getDynamicArray( ).actSize( ) + "\n---------");
					view.printMessage("Carga de peliculas exitosa" + "\n---------");	
					view.printMessage("Primera pelicula importada: " + "\nID: " + model.getDynamicArray( ).firstElement( ).getId( ) + "\nTitle: " + model.getDynamicArray( ).firstElement( ).getTitle( )  + "\nDirector: " + model.getDynamicArray( ).firstElement( ).getDirectorName( )  + "\nPopularity: " + model.getDynamicArray( ).firstElement( ).getPopularity( ) + "\n---------");
					view.printMessage("Ultima pelicula importada: " + "\nID: " + model.getDynamicArray( ).lastElement( ).getId( ) + "\nTitle: " + model.getDynamicArray( ).lastElement( ).getTitle( )  + "\nDirector: " + model.getDynamicArray( ).lastElement( ).getDirectorName( )  + "\nPopularity: " + model.getDynamicArray( ).lastElement( ).getPopularity( ) + "\n---------");
					view.printMessage("Numero de peliculas encontradas en las fuentes: " + model.getDynamicArray( ).actSize( ) + "\n---------" );
				}
				catch( DataLoadException DLe )
				{
					view.printMessage( DLe.getMessage( ) );
				} 
				catch ( ElementNotFoundException ENFe ) 
				{
					view.printMessage( ENFe.getMessage( ) );
				}
				break;
			case 3:
				view.printMessage("--------- \nEncontrar las 20 peliculas con peor promedio de votacion. \n");
				try
				{
					model.shellSortPopularity( );
					if( model.getLinkedList( ) != null )
					{
						for (int i = 1; i <= 20 ; i++ ) 
						{
							view.printMessage( i + ". " + "ID: " + model.getLinkedList( ).getElementPos( i ).getId( ) + " - Vote average: " + model.getLinkedList( ).getElementPos( i ).getVoteAverage( ) + " - Title: " + model.getLinkedList( ).getElementPos( i ).getTitle( ) + " - Genres: " + model.getLinkedList( ).getElementPos( i ).getGenres( ) );
						}
					}
					else
						for (int i = 1; i <= 20 ; i++ ) 
						{
							view.printMessage( i + ". " + "ID: " + model.getDynamicArray( ).getElementPos( i ).getId( ) + " - Vote average: " + model.getDynamicArray( ).getElementPos( i ).getVoteAverage( ) + " - Title: " + model.getDynamicArray( ).getElementPos( i ).getTitle( ) + " - Genres: " + model.getDynamicArray( ).getElementPos( i ).getGenres( ) );
						}
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
