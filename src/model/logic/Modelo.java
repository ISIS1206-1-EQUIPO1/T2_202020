package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import model.data_structures.ArregloDinamico;
import model.data_structures.ElementoNoExisteException;
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
	 */
	public Modelo()
	{
		try
		{
			System.out.println("Entré");
			// CSVReader readerDetails = new CSVReader( new FileReader( "./data/SmallMoviesDetailsCleaned.csv" ) );
			// CSVReader readerCasting = new CSVReader( new FileReader( "./data/MoviesCastingRaw-small.csv" ) );
			Reader reader = Files.newBufferedReader( Paths.get( "./data/SmallMoviesDetailsCleaned.csv" ));
			ColumnPositionMappingStrategy<Movie> strategy = new ColumnPositionMappingStrategy< Movie > ( );
			strategy.setType( Movie.class );
			String[ ] memberFieldsToBindTo = {"id", "budget", "genres", "imdbID", "originalLanguage", "originalTitle", "overview", "popularity", "productionCompanies", "productionCountries", "releaseDate", "renevue", "runtime", "spokenLanguage", "status", "tagline", "title", "voteAverage", "voteCount", "productionCompaniesNumber", "productionCountriesNumber", "spokenLanguagesNumber" };
			strategy.setColumnMapping( memberFieldsToBindTo );
			CsvToBean<Movie> csvToBean = new CsvToBeanBuilder(reader).withMappingStrategy( strategy ).withSkipLines( 1 ).withIgnoreLeadingWhiteSpace( true ).build( );
			Iterator< Movie > movieIterator = csvToBean.iterator( );
			while( movieIterator.hasNext( ) )
			{
				Movie movie = movieIterator.next( );
				System.out.println("id : " + movie.getId( ) );
                System.out.println("Budget : " + movie.getBudget( ) );
                System.out.println("Genres : " + movie.getGenres( ) );
                System.out.println("---------------------------");
			}
		}
		catch( IOException IOE )
		{
			IOE.printStackTrace( );
		}
//		try 
//		{
//			datos = new ArregloDinamico(7);
//		} 
//		catch (IndiceInvalidoException e) 
//		{
//			// No deberia pasar por acá
//		}
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
