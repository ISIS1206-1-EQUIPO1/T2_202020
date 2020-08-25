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
import model.data_structures.IArregloDinamico;
import model.data_structures.IndiceInvalidoException;
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
			datos = new ArregloDinamico( 5 );
			cargaDatos( );
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	
	}

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
				{
					System.out.println(details[7 + i]);
					popularity = Double.parseDouble( details[ 7 + i ] );
				}
				Date date = null;
				SimpleDateFormat sdtn = new SimpleDateFormat( "dd/MM/yyyy" );
				SimpleDateFormat sdta = new SimpleDateFormat( "yyyy-MM-dd" );
				if( details[ 10 + i ].equals( sdtn ) )
					date = sdtn.parse( details[ 10 ] );
				else if( details[ 10 + i ].equals( sdta ) )
					date = sdta.parse( details[ 10 + i ] );
				Movie m = new Movie( Integer.parseInt( details[ 0 ] ), budget, details[ 2 ], details[ 3 ], details[ 4 ], details[ 5 ], details[ 6 ], popularity, details[ 8 + i ], details[ 9 + i ], date, Integer.parseInt( details[ 11 + i ] ), Integer.parseInt( details[ 12 + i ] ), details[ 13 + i ], details[ 14 + i ], details[ 15 + i ], details[ 16 + i + k ], Double.parseDouble( details[ 17 + i + k ] ), Integer.parseInt( details[ 18 + i + k ] ), Integer.parseInt( details[ 19 + i + k ] ), Integer.parseInt( details[ 20 + i + k ] ), Integer.parseInt( details[ 21 + i + k ] ), casting[ 1 ], Integer.parseInt( casting[ 2 ] ), casting[ 3 ], Integer.parseInt( casting[ 4 ] ), casting[ 5 ], Integer.parseInt( casting[ 6 ] ), casting[ 7 ], Integer.parseInt( casting[ 8 ] ), casting[ 9 ], Integer.parseInt( casting[ 10 ] ), Integer.parseInt( casting[ 11 ] ), casting[ 12 ], Integer.parseInt( casting[ 13 ] ), Integer.parseInt( casting[ 14 ] ), casting[ 15 ], Integer.parseInt( casting[ 16 ] ), casting[ 17 ], casting[ 18 ] );
				// datos.addLast( m );
				System.out.println( m );
			}
		}
		catch( FileNotFoundException FNFE )
		{
			throw new CargaDatosException( "No se encontró el archivo .csv para cargar los datos." );
		}
		catch( ParseException PE )
		{
			throw new CargaDatosException( "Error al convertir el String de fecha en formato Date." );
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
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int actSize()
	{
		return datos.actSize();
	}

	//	/**
	//	 * Requerimiento de agregar dato
	//	 * @param dato
	//	 */
	//	public void addFirst( T element ) throws ElementoNoExisteException
	//	{	
	//		datos.addFirst( element );
	//	}
	//	
	//	/**
	//	 * Requerimiento buscar dato
	//	 * @param dato Dato a buscar
	//	 * @return dato encontrado
	//	 */
	//	public T getElement( T element ) throws ElementoNoExisteException
	//	{
	//		return datos.getElement( element );
	//	}
	//	
	//	/**
	//	 * Requerimiento eliminar dato
	//	 * @param dato Dato a eliminar
	//	 * @return dato eliminado
	//	 */
	//	public T deleteElement( T element ) throws ElementoNoExisteException
	//	{
	//		return datos.deleteElement( element );
	//	}


}
