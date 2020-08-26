package model.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import model.data_structures.ArregloDinamico;
import model.data_structures.ElementoNoExisteException;
import model.data_structures.IArregloDinamico;
import model.data_structures.IndiceInvalidoException;
import view.View;
/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo
{
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 * @throws IOException 
	 */
	public Modelo( )
	{
		try
		{
			datos = new ArregloDinamico ( 5 );
		}
		catch( IndiceInvalidoException IIE )
		{
			// No deberia pasar por aca
			System.out.println( "IIE" );
			IIE.printStackTrace();
		}
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo( int capacidad ) throws IndiceInvalidoException
	{
		datos = new ArregloDinamico(capacidad);
	}

	/**
	 * Carga los datos desde los archivos .csv que se encuentran en la carpeta data del proyecto
	 * @throws CargaDatosException si hay problemas al cargar los datos.
	 */
	public void cargaDatos( ) throws CargaDatosException
	{
		try
		{
			Scanner scannerDetails = new Scanner( new File( "./data/SmallMoviesDetailsCleaned.csv" ) );
			Scanner scannerCasting = new Scanner( new File( "./data/MoviesCastingRaw-small.csv" ) );
			scannerDetails.useDelimiter( "\n" );
			scannerCasting.useDelimiter( "\n" );
			scannerDetails.next( );
			scannerCasting.next( );
			while( scannerDetails.hasNext( ) && scannerCasting.hasNext( ) )
			{
				String[ ] details = scannerDetails.next( ).split( ";" );
				int i = 0;
				int k = 0;
				if( details[ 0 ].equals( "1701" ) || details[ 0 ].equals( "1904" ) )
				{
					details[ 15 ] += ";" + details[ 16 ];
					k++;
				}
				else
				{
					if( details.length > 22 )
					{
						int puntoComa = details.length - 22;
						for (int j = 7; j < puntoComa + 7; j++)
						{
							details[ 6 ] += ";" + details[ j ];
						}
						i = puntoComa;
					}
				}
				String[ ] casting = scannerCasting.next( ).split( ";" );
				int budget = 0;
				if( !details[ 1 ].equals("") )
					budget = Integer.parseInt( details[ 1 ] );
				double popularity = 0;
				if( details[ 7 + i ].contains("E") )
					popularity = Double.valueOf( details[ 7 + i  ].replace( ',', '.' ) );
				else if( !details[ 7 + i ].equals( "" ) )
					popularity = Double.parseDouble( details[ 7 + i ] );
				Date date = null;
				SimpleDateFormat sdtn = new SimpleDateFormat( "dd/MM/yyyy" );
				SimpleDateFormat sdta = new SimpleDateFormat( "yyyy-MM-dd" );
				if( details[ 10 + i ].equals( sdtn ) )
					date = sdtn.parse( details[ 10 ] );
				else if( details[ 10 + i ].equals( sdta ) )
					date = sdta.parse( details[ 10 + i ] );
				Movie m = new Movie( Integer.parseInt( details[ 0 ] ), budget, details[ 2 ], details[ 3 ], details[ 4 ], details[ 5 ], details[ 6 ], popularity, details[ 8 + i ], details[ 9 + i ], date, Integer.parseInt( details[ 11 + i ] ), Integer.parseInt( details[ 12 + i ] ), details[ 13 + i ], details[ 14 + i ], details[ 15 + i ], details[ 16 + i + k ], Double.parseDouble( details[ 17 + i + k ] ), Integer.parseInt( details[ 18 + i + k ] ), Integer.parseInt( details[ 19 + i + k ] ), Integer.parseInt( details[ 20 + i + k ] ), Integer.parseInt( details[ 21 + i + k ] ), casting[ 1 ], Integer.parseInt( casting[ 2 ] ), casting[ 3 ], Integer.parseInt( casting[ 4 ] ), casting[ 5 ], Integer.parseInt( casting[ 6 ] ), casting[ 7 ], Integer.parseInt( casting[ 8 ] ), casting[ 9 ], Integer.parseInt( casting[ 10 ] ), Integer.parseInt( casting[ 11 ] ), casting[ 12 ], Integer.parseInt( casting[ 13 ] ), Integer.parseInt( casting[ 14 ] ), casting[ 15 ], Integer.parseInt( casting[ 16 ] ), casting[ 17 ], casting[ 18 ] );
				datos.addLast( m );
			}
		}
		catch( FileNotFoundException FNFE )
		{
			throw new CargaDatosException( "No se encontro el archivo .csv para cargar los datos." );
		}
		catch( ParseException PE )
		{
			throw new CargaDatosException( "Error al convertir el String de fecha en formato Date." );
		} 
		catch (ElementoNoExisteException e) 
		{
			throw new CargaDatosException( "Error al agregar elementos al Arreglo Dinamico." );
		}
	}

	/**
	 * Imprime en consola las buenas peliculas de un director, y estadisticas adicionales de esta
	 * @param director el director del cual se quieren consultar peliculas
	 * @param v instancia de la clase View, que permite escribir y leer de consola.
	 * @throws Exception si El nombre del director es invalido, el director no existe o no tiene peliculas buenas.
	 */
	public void buenasPeliculasDirector( String director, View v ) throws Exception
	{
		v.printMessage( "\n---------" );
		if( director == null || director.equals("") )
			throw new Exception( "El nombre del director debe ser diferente a null o vacío" );
		int peliculasDirector = 0;
		int peliculasBuenasDirector = 0;
		double sumaPuntajes = 0;
		for( int i = 1; i <= datos.actSize( ); i++ )
		{
			Movie m = ( Movie ) datos.getElementPos( i );
			if( m.getDirectorName( ).equals( director ) )
			{
				peliculasDirector++;
				if( m.getPopularity( ) >= 6 )
				{
					peliculasBuenasDirector++;
					sumaPuntajes += m.getPopularity( );
					v.printMessage( "Pelicula buena #" + peliculasBuenasDirector + " del director: " + director);
					v.printMessage( "ID: " + m.getId( ) + "\nTitle: " + m.getTitle( ) + "\nPopularity: " + m.getPopularity( ) + " \nGenre: " + m.getGenres( ) + "\nActor 1: " + m.getActor1Name( ) + "\nActor 2: " + m.getActor2Name( ) + "\nActor 3: " + m.getActor3Name( ) + "\nActor 4: " + m.getActor4Name( ) + "\nActor 5: " + m.getActor5Name( ) + "\n---------" );
				}
			}
		}
		v.printMessage( "\nBusqueda de peliculas del director terminada. \n" );
		if( peliculasDirector == 0 )
			throw new Exception( "No se encontro ninguna pelicula del director con nombre: " + director + ". \nRevise la ortografia y recuerde que es case y symbol sensitive." + ".\n---------");
		if( peliculasDirector > 0 && peliculasBuenasDirector == 0 )
			throw new Exception( "Se encontraron " + peliculasDirector + " peliculas del director " + director + " pero ninguna con popularity >= 6." + "\n---------");
		v.printMessage( "El número de peliculas buenas del director " + director + " es " + peliculasBuenasDirector + ".");
		v.printMessage( "El promedio de popularity de las peliculas buenas del director " + director + " es " + sumaPuntajes/peliculasBuenasDirector + ".\n---------");
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int actSize()
	{
		return datos.actSize();
	}

	/**
	 * Retorna la primera pelicula del ArregloDinamico.
	 * @return la primera pelicula del arreglo dinamico.
	 * @throws ElementoNoExisteException si la lista esta vacia.
	 */
	public Movie getFirstMovie( ) throws ElementoNoExisteException
	{
		return (Movie) datos.firstElement( );
	}

	/**
	 * Retorna la ultima pelicula del ArregloDinamico.
	 * @return la ultima pelicula del arreglo dinamico.
	 * @throws ElementoNoExisteException  si la lista esta vacia.
	 */
	public Movie getLastMovie( ) throws ElementoNoExisteException
	{
		return (Movie) datos.lastElement( );
	}
}
