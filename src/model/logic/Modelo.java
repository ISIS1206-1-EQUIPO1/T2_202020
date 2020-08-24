package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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
	public Modelo()
	{
//				try
//				{
//					System.out.println("Entré");
//					// CSVReader readerDetails = new CSVReader( new FileReader( "./data/SmallMoviesDetailsCleaned.csv" ) );
//					// CSVReader readerCasting = new CSVReader( new FileReader( "./data/MoviesCastingRaw-small.csv" ) );
//					Reader reader = new FileReader( "./data/SmallMoviesDetailsCleaned.csv" );
//					ColumnPositionMappingStrategy<Movie> strategy = new ColumnPositionMappingStrategy< Movie > ( );
//					System.out.println("Hola");
//					strategy.setType( Movie.class );
//					String[ ] colummns = {"id", "budget", "genres", "imdbID", "originalLanguage", "originalTitle", "overview", "popularity", "productionCompanies", "productionCountries", "releaseDate", "renevue", "runtime", "spokenLanguages", "status", "tagline", "title", "voteAverage", "voteCount", "productionCompaniesNumber", "productionCountriesNumber", "spokenLanguagesNumber" };
//					strategy.setColumnMapping( colummns );
//					CsvToBean<Movie> csvToBean = new CsvToBeanBuilder(reader).withMappingStrategy( strategy ).withSkipLines( 1 ).build( );
//					Iterator< Movie > movieIterator = csvToBean.iterator( );
//					while( movieIterator.hasNext( ) )
//					{
//						Movie movie = movieIterator.next( );
//						System.out.println("id : " + movie.getId( ) );
//		                System.out.println("Budget : " + movie.getBudget( ) );
//		                System.out.println("Genres : " + movie.getGenres( ) );
//		                System.out.println("---------------------------");
//					}
//				}
//				catch( IOException IOE )
//				{
//					IOE.printStackTrace( );
//				}
		//		try 
		//		{
		//			datos = new ArregloDinamico(7);
		//		} 
		//		catch (IndiceInvalidoException e) 
		//		{
		//			// No deberia pasar por acá
		//		}
		//		
		//		CsvToBeanBuilder<Movie> beanBuilder = new CsvToBeanBuilder<Movie>( new InputStreamReader( new FileInputStream( "./data/SmallMoviesDetailsCleaned.csv" ) ) );
		//		beanBuilder.withType( Movie.class );
		//		beanBuilder.build().parse().forEach(e -> log.error(e.toString()));

		//		Map<String, String> columnMapping = new HashMap<String, String>();
		//		columnMapping.put("id", "id");
		//		columnMapping.put("budget", "budget");
		//		columnMapping.put("budget", "budget");

		//		final ColumnPositionMappingStrategy<Movie> strategy = new ColumnPositionMappingStrategy<Movie>();
		//		strategy.setType(Movie.class);
		//		strategy.setColumnMapping( new String[ ] {"id", "budget", "genres", "imdbID", "originalLanguage", "originalTitle", "overview", "popularity", "productionCompanies", "productionCountries", "releaseDate", "renevue", "runtime", "spokenLanguages", "status", "tagline", "title", "voteAverage", "voteCount", "productionCompaniesNumber", "productionCountriesNumber", "spokenLanguagesNumber" } );
		//		final CsvToBean<Movie> csvToBean = new CsvToBean<Movie>( ); 
		//		final List<Movie> list;
		//		try( final Reader reader = new FileReader( "./data/SmallMoviesDetailsCleaned.csv" ) )
		//		{
		//			list = csvToBean.parse( strategy, reader );
		//		}
		//		CSVReader reader = new CSVReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("test.csv")));
		//		list = csvToBean.parse(strategy, reader);

				try 
				{
					List<Movie> beans = new CsvToBeanBuilder( new FileReader( "./data/SmallMoviesDetailsCleaned.csv") ).withType( Movie.class ).withSeparator(';').build( ).parse( );
				}
				catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("hola");

		//		CSVReader reader = new CSVReader(new FileReader( "./data/SmallMoviesDetailsCleaned.csv" ) );
		//		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		//	    strat.setType(Movie.class);
		//	    String[] columns = new String[] { "id", "budget", "genres", "imdbID", "originalLanguage", "originalTitle", "overview", "popularity", "productionCompanies", "productionCountries", "releaseDate", "renevue", "runtime", "spokenLanguages", "status", "tagline", "title", "voteAverage", "voteCount", "productionCompaniesNumber", "productionCountriesNumber", "spokenLanguagesNumber" };
		//	    strat.setColumnMapping(columns);
		//
		//	    CsvToBean csv = new CsvToBean();

		//		try
		//		{
		//			CSVReader readerDetails = new CSVReader(new FileReader( "./data/SmallMoviesDetailsCleaned.csv" ) );
		//			CSVReader readerCasting = new CSVReader(new FileReader( "./data/SmallMoviesDetailsCleaned.csv" ) );
		//			String[ ] nextLineDetails;
		//			while( ( nextLineDetails = readerDetails.readNext( ) ) != null )
		//			{
		//				System.out.println( nextLineDetails[0] );
		//			}
		//		}
		//		catch( IOException IOE )
		//		{
		//
		//		}
		//		catch( CsvValidationException CSVVE )
		//		{
		//			
		//		}

//		try ( Reader reader = Files.newBufferedReader(Paths.get("./data/SmallMoviesDetailsCleaned.csv"));) 
//		{
//			final ColumnPositionMappingStrategy<Movie> strategy = new ColumnPositionMappingStrategy<Movie>();
//					strategy.setType(Movie.class);
//					strategy.setColumnMapping( new String[ ] {"id", "budget", "genres", "imdbID", "originalLanguage", "originalTitle", "overview", "popularity", "productionCompanies", "productionCountries", "releaseDate", "renevue", "runtime", "spokenLanguages", "status", "tagline", "title", "voteAverage", "voteCount", "productionCompaniesNumber", "productionCountriesNumber", "spokenLanguagesNumber" } );
//			CsvToBean<Movie> csvToBean = new CsvToBeanBuilder(reader).withType( Movie.class ).build();
//
//			Iterator<Movie> csvUserIterator = csvToBean.iterator();
//
//			while (csvUserIterator.hasNext()) 
//			{
//				Movie movie = csvUserIterator.next( );
//				System.out.println("id : " + movie.getId( ) );
//				System.out.println("Budget : " + movie.getBudget( ) );
//				System.out.println("Genres : " + movie.getGenres( ) );
//				System.out.println("---------------------------");
//			}
//		}
//		catch( IOException IOE )
//		{
//			IOE.printStackTrace();
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
