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
import java.util.ArrayList;
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
import com.opencsv.exceptions.CsvValidationException;

import model.data_structures.DynamicArray;
import model.data_structures.ElementNotFoundException;
import model.data_structures.IDataStructure;
import model.data_structures.InvalidIndexException;
import model.data_structures.LinkedList;
import model.data_structures.ShellSort;
import model.data_structures.ShellSortException;
import view.View;
/**
 * Definicion del modelo del mundo
 *
 */
public class Model
{
	/**
	 * Atributos del modelo del mundo
	 */

	private LinkedList<Movie> linkedList;

	private DynamicArray<Movie> dynamicArray;

	private ShellSort shellSort;

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
	public void dataLoad( int dataStructure ) throws DataLoadException
	{
		try
		{
			IDataStructure d = null;
			if( dataStructure == 1 )
				d = new LinkedList<Movie>( );
			else
				d = new DynamicArray<Movie>( 2000 );
			CSVParser parser = new CSVParserBuilder().withSeparator(';').build( );
			CSVReader readerDetails = new CSVReaderBuilder( new FileReader( "./data/SmallMoviesDetailsCleaned.csv" )).withCSVParser( parser ).withSkipLines( 1 ).build( );
			CSVReader readerCasting = new CSVReaderBuilder( new FileReader( "./data/MoviesCastingRaw-small.csv" )).withCSVParser( parser ).withSkipLines( 1 ).build( );
			String[ ] nextLineDetails;
			String[ ] nextLineCasting;
			while( ( nextLineDetails = readerDetails.readNext( ) ) != null &&  ( nextLineCasting = readerCasting.readNext( ) ) != null )
			{
				Movie m = new Movie( nextLineDetails[ 0 ], nextLineDetails[ 1 ], nextLineDetails[ 2 ], nextLineDetails[ 3 ], nextLineDetails[ 4 ], nextLineDetails[ 5 ], nextLineDetails[ 6 ], nextLineDetails[ 7 ], nextLineDetails[ 8 ], nextLineDetails[ 9 ], nextLineDetails[ 10 ], nextLineDetails[ 11 ], nextLineDetails[ 12 ], nextLineDetails[ 13 ], nextLineDetails[ 14 ], nextLineDetails[ 15 ], nextLineDetails[ 16 ], nextLineDetails[ 17 ], nextLineDetails[ 18 ], nextLineDetails[ 19 ], nextLineDetails[ 20 ], nextLineDetails[ 21 ], nextLineCasting[ 1 ], nextLineCasting[ 2 ], nextLineCasting[ 3 ], nextLineCasting[ 4 ], nextLineCasting[ 5 ], nextLineCasting[ 6 ], nextLineCasting[ 7 ], nextLineCasting[ 8 ], nextLineCasting[ 9 ], nextLineCasting[ 10 ], nextLineCasting[ 11 ], nextLineCasting[ 12 ], nextLineCasting[ 13 ], nextLineCasting[ 14 ], nextLineCasting[ 15 ], nextLineCasting[ 16 ], nextLineCasting[ 17 ], nextLineCasting[ 18 ] );
				d.addLast( m );
			}
			if( dataStructure == 1 )
				linkedList = ( LinkedList ) d;
			else if( dataStructure == 2 )
				dynamicArray = ( DynamicArray ) d;
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

	public LinkedList<Movie> getLinkedList( ) 
	{
		return linkedList;
	}

	public DynamicArray<Movie> getDynamicArray( ) 
	{
		return dynamicArray;
	}

	public ShellSort getShellSort( ) 
	{
		return shellSort;
	}

	public void shellSortPopularity( ) throws ShellSortException
	{
		if( linkedList != null )
			shellSort.sort( linkedList );
		else if( dynamicArray != null )
			shellSort.sort( dynamicArray );
		else
			throw new ShellSortException( "No hay ninguna estructura de datos inicializada ni cargada." );
	}
}
