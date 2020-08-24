package controller;

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

//	public void run() 
//	{
//		Scanner lector = new Scanner(System.in);
//		boolean fin = false;
//		Integer dato;
//		// TODO OJO, no se debe inicializar así / JAVIER RAMIREZ / 21-08-2020
//		Integer respuesta = 0;
//
//		while( !fin )
//		{
//			view.printMenu();
//
//			int option = lector.nextInt();
//			switch(option){
//			case 1:
//				view.printMessage("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
//				int capacidad = lector.nextInt();
//				try
//				{
//					modelo = new Modelo(capacidad);
//					view.printMessage("Arreglo Dinamico creado");
//					view.printMessage("Numero actual de elementos " + modelo.actSize( ) + "\n---------");	
//				}
//				catch( IndiceInvalidoException IIE )
//				{
//					view.printMessage( IIE.getMessage( ) );
//				}
//				break;
//
//			case 2:
//				view.printMessage("--------- \nDar cadena (simple) a ingresar: ");
//				dato = lector.nextInt();
//				try 
//				{
//					modelo.addFirst( dato );
//				} 
//				catch (ElementoNoExisteException ENEE) 
//				{
//					ENEE.printStackTrace();
//				}
//				view.printMessage("Dato agregado");
//				view.printMessage("Numero actual de elementos " + modelo.actSize( ) + "\n---------");						
//				break;
//
//			case 3:
//				view.printMessage("--------- \nDar cadena (simple) a buscar: ");
//				dato = lector.nextInt();
//				try
//				{
//					respuesta = ( Integer ) modelo.getElement(dato);
//				}
//				catch( ElementoNoExisteException ENEE )
//				{
//					ENEE.printStackTrace( );
//				}
//				if ( respuesta != null)
//				{
//					view.printMessage("Dato encontrado: "+ respuesta);
//				}
//				else
//				{
//					view.printMessage("Dato NO encontrado");
//				}
//				view.printMessage("Numero actual de elementos " + modelo.actSize( ) + "\n---------");						
//				break;
//
//			case 4:
//				view.printMessage("--------- \nDar cadena (simple) a eliminar: ");
//				dato = lector.nextInt();
//				try 
//				{
//					respuesta = ( Integer ) modelo.deleteElement(dato);
//				}
//				catch (ElementoNoExisteException ENEE) 
//				{
//					ENEE.printStackTrace();
//				}
//				if ( respuesta != null)
//				{
//					view.printMessage("Dato eliminado "+ respuesta);
//				}
//				else
//				{
//					view.printMessage("Dato NO eliminado");							
//				}
//				view.printMessage("Numero actual de elementos " + modelo.actSize() + "\n---------");						
//				break;
//
//			case 5: 
//				view.printMessage("--------- \nContenido del Arreglo: ");
//				view.printModelo(modelo);
//				view.printMessage("Numero actual de elementos " + modelo.actSize( ) + "\n---------");						
//				break;	
//
//			case 6: 
//				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
//				lector.close();
//				fin = true;
//				break;	
//
//			default: 
//				view.printMessage("--------- \n Opcion Invalida !! \n---------");
//				break;
//			}
//		}
//
//	}	
}
