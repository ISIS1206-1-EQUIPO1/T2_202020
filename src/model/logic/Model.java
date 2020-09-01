package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import model.data_structures.DynamicArray;
import model.data_structures.ElementNotFoundException;
import model.data_structures.IDataStructure;
import model.data_structures.InvalidIndexException;
import model.data_structures.LinkedList;
import model.data_structures.ShellSort;
import model.data_structures.ShellSortException;
/**
 * Definicion del modelo del mundo
 *
 */
public class Model
{
	/**
	 * Atributos del modelo del mundo
	 */
	private IDataStructure<Movie> dataStructure;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 * @throws DataLoadException 
	 * @throws IOException 
	 */
	public Model( )
	{

	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Model( int size )
	{

	}

	/**
	 * Carga los datos desde los archivos .csv que se encuentran en la carpeta data del proyecto
	 * @throws DataLoadException si hay problemas al cargar los datos.
	 */
	public void dataLoad( int intDataStructure ) throws DataLoadException
	{
		try
		{
			if( intDataStructure == 1 )
				dataStructure = new LinkedList<Movie>( );
			else
				dataStructure = new DynamicArray<Movie>( 2000 );
			
			CSVParser parser = new CSVParserBuilder().withSeparator(';').build( );
			CSVReader readerDetails = new CSVReaderBuilder( new FileReader( "./data/SmallMoviesDetailsCleaned.csv" )).withCSVParser( parser ).withSkipLines( 1 ).build( );
			CSVReader readerCasting = new CSVReaderBuilder( new FileReader( "./data/MoviesCastingRaw-small.csv" )).withCSVParser( parser ).withSkipLines( 1 ).build( );
			String[ ] nextLineDetails;
			String[ ] nextLineCasting;
			while( ( nextLineDetails = readerDetails.readNext( ) ) != null &&  ( nextLineCasting = readerCasting.readNext( ) ) != null )
			{
				Movie m = new Movie( nextLineDetails[ 0 ], nextLineDetails[ 1 ], nextLineDetails[ 2 ], nextLineDetails[ 3 ], nextLineDetails[ 4 ], nextLineDetails[ 5 ], nextLineDetails[ 6 ], nextLineDetails[ 7 ], nextLineDetails[ 8 ], nextLineDetails[ 9 ], nextLineDetails[ 10 ], nextLineDetails[ 11 ], nextLineDetails[ 12 ], nextLineDetails[ 13 ], nextLineDetails[ 14 ], nextLineDetails[ 15 ], nextLineDetails[ 16 ], nextLineDetails[ 17 ], nextLineDetails[ 18 ], nextLineDetails[ 19 ], nextLineDetails[ 20 ], nextLineDetails[ 21 ], nextLineCasting[ 1 ], nextLineCasting[ 2 ], nextLineCasting[ 3 ], nextLineCasting[ 4 ], nextLineCasting[ 5 ], nextLineCasting[ 6 ], nextLineCasting[ 7 ], nextLineCasting[ 8 ], nextLineCasting[ 9 ], nextLineCasting[ 10 ], nextLineCasting[ 11 ], nextLineCasting[ 12 ], nextLineCasting[ 13 ], nextLineCasting[ 14 ], nextLineCasting[ 15 ], nextLineCasting[ 16 ], nextLineCasting[ 17 ], nextLineCasting[ 18 ] );
				dataStructure.addLast( m );
			}
		}
		catch( FileNotFoundException FNFE )
		{
			throw new DataLoadException( "No se encontro el archivo .csv para cargar los datos." );
		}
		catch (ElementNotFoundException e) 
		{
			throw new DataLoadException( "Error al agregar elementos a la estructura de datos." );
		}
		catch (CsvValidationException e) 
		{
			throw new DataLoadException( "Error al leer el .csv" );
		} 
		catch (IOException e) 
		{
			throw new DataLoadException( "Error al leer el .csv" );
		} 
		catch (InvalidIndexException e) 
		{
			// Shouldn't get here
			e.printStackTrace();
		}
	}
	
	/**
	 * Retorna la estructura de datos de tipo IDataStructure que este inicializada actualmente, si no hay ninguna retorna null;
	 * @return dataStructure.
	 */
	public IDataStructure<Movie> getDataStructure( )
	{
		return dataStructure;
	}

	/**
	 * Ordena la estructura de datos que se encuentra inicializada actualmente.
	 * @throws ShellSortException si no hay ninguna estructura de datos inicializada para ordenar.
	 */
	public void shellSortVoteAverage( ) throws ShellSortException
	{
		if( dataStructure == null )
			throw new ShellSortException( "No hay ninguna estructura de datos inicializada ni cargada." );
		ShellSort.sort( dataStructure );
	}
}
