package model.logic;

import java.util.Date;

public class Movie
{
	
	private int id;
	private int budget;
	private String genres;
	private String imdbID;
	private String originalLanguage;
	private String originalTitle;
	private String overview;
	private double popularity;
	private String productionCompanies;
	private String productionCountries;
	private Date releaseDate;
	private int renevue;
	private int runtime; 
	private String spokenLanguages;
	private String status;
	private String tagline;
	private String title;
	private double voteAverage;
	private double voteCount;
	private int productionCompaniesNumber;
	private int productionCountriesNumber;
	private int spokenLanguagesNumber;
//	private String actor1Name;
//	private int actor1Gender;
//	private String actor2Name;
//	private int actor2Gender;
//	private String actor3Name;
//	private int actor3Gender;
//	private String actor4Name;
//	private int actor4Gender;
//	private String actor5Name;
//	private int actor5Gender;
//	private int actorNumber;
//	private String directorName;
//	private int directorGender;
//	private int directorNumber;
//	private String producerName;
//	private int producerNumber;
//	private String screenplayName;
//	private String editorName;
	
	public Movie( int id, int budget, String genres, String imdbID, String originalLanguage, String originalTitle, String overview, double popularity, String productionCompanies, String productionCountries, Date releaseDate, int renevue, int runtime, String spokenLanguages, String status, String tagline, String title, double voteAverage, double voteCount, int productionCompaniesNumber, int productionCountriesNumber, int spokenLanguagesNumber /*, String actor1Name, int actor1Gender, String actor2Name, int actor2Gender, String actor3Name, int actor3Gender, String actor4Name, int actor4Gender, String actor5Name, int actor5Gender, int actorNumber, String directorName, int directorGender, int directorNumber, String producerName, int producerNumber, String screenplayName, String editorName */)
	{
		this.id = id;
		this.budget = budget;
		this.genres = genres;
		this.imdbID = imdbID;
		this.originalLanguage = originalLanguage;
		this.originalTitle = originalTitle;
		this.overview = overview;
		this.popularity = popularity;


		this.runtime = runtime;
		this.spokenLanguages = spokenLanguages;
		this.status = status;
		this.tagline = tagline;
		this.title = title;
		this.voteAverage = voteAverage;
		this.voteCount = voteCount;
		this.productionCompaniesNumber = productionCompaniesNumber;
		this.productionCountriesNumber = productionCountriesNumber;
		this.spokenLanguagesNumber = spokenLanguagesNumber;
//		this.actor1Name = actor1Name;
//		this.actor1Gender = actor1Gender;
//		this.actor2Name = actor2Name;
//		this.actor2Gender = actor2Gender;
//		this.actor3Name = actor3Name;
//		this.actor3Gender = actor3Gender;
//		this.actor4Name = actor4Name;
//		this.actor4Gender = actor4Gender;
//		this.actor5Name = actor5Name;
//		this.actor5Gender = actor5Gender;
//		this.actorNumber = actorNumber;
//		this.directorName = directorName;
//		this.directorGender = directorGender;
//		this.directorNumber = directorNumber;
//		this.producerName = producerName;
//		this.producerNumber = producerNumber;
//		this.screenplayName = screenplayName;
//		this.editorName = editorName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the budget
	 */
	public int getBudget() {
		return budget;
	}

	/**
	 * @return the genres
	 */
	public String getGenres() {
		return genres;
	}

	/**
	 * @return the imdbID
	 */
	public String getImdbID() {
		return imdbID;
	}

	/**
	 * @return the originalLanguage
	 */
	public String getOriginalLanguage() {
		return originalLanguage;
	}

	/**
	 * @return the originalTitle
	 */
	public String getOriginalTitle() {
		return originalTitle;
	}

	/**
	 * @return the overview
	 */
	public String getOverview() {
		return overview;
	}

	/**
	 * @return the popularity
	 */
	public double getPopularity() {
		return popularity;
	}

	/**
	 * @return the productionCompanies
	 */
	public String getProductionCompanies() {
		return productionCompanies;
	}

	/**
	 * @return the productionCountries
	 */
	public String getProductionCountries() {
		return productionCountries;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @return the renevue
	 */
	public int getRenevue() {
		return renevue;
	}

	/**
	 * @return the runtime
	 */
	public int getRuntime() {
		return runtime;
	}

	/**
	 * @return the spokenLanguages
	 */
	public String getSpokenLanguages() {
		return spokenLanguages;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the tagline
	 */
	public String getTagline() {
		return tagline;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the voteAverage
	 */
	public double getVoteAverage() {
		return voteAverage;
	}

	/**
	 * @return the voteCount
	 */
	public double getVoteCount() {
		return voteCount;
	}

	/**
	 * @return the productionCompaniesNumber
	 */
	public int getProductionCompaniesNumber() {
		return productionCompaniesNumber;
	}

	/**
	 * @return the productionCountriesNumber
	 */
	public int getProductionCountriesNumber() {
		return productionCountriesNumber;
	}

	/**
	 * @return the spokenLanguagesNumber
	 */
	public int getSpokenLanguagesNumber() {
		return spokenLanguagesNumber;
	}

//	/**
//	 * @return the actor1Name
//	 */
//	public String getActor1Name() {
//		return actor1Name;
//	}
//
//	/**
//	 * @return the actor1Gender
//	 */
//	public int getActor1Gender() {
//		return actor1Gender;
//	}
//
//	/**
//	 * @return the actor2Name
//	 */
//	public String getActor2Name() {
//		return actor2Name;
//	}
//
//	/**
//	 * @return the actor2Gender
//	 */
//	public int getActor2Gender() {
//		return actor2Gender;
//	}
//
//	/**
//	 * @return the actor3Name
//	 */
//	public String getActor3Name() {
//		return actor3Name;
//	}
//
//	/**
//	 * @return the actor3Gender
//	 */
//	public int getActor3Gender() {
//		return actor3Gender;
//	}
//
//	/**
//	 * @return the actor4Name
//	 */
//	public String getActor4Name() {
//		return actor4Name;
//	}
//
//	/**
//	 * @return the actor4Gender
//	 */
//	public int getActor4Gender() {
//		return actor4Gender;
//	}
//
//	/**
//	 * @return the actor5Name
//	 */
//	public String getActor5Name() {
//		return actor5Name;
//	}
//
//	/**
//	 * @return the actor5Gender
//	 */
//	public int getActor5Gender() {
//		return actor5Gender;
//	}
//
//	/**
//	 * @return the actorNumber
//	 */
//	public int getActorNumber() {
//		return actorNumber;
//	}
//
//	/**
//	 * @return the directorName
//	 */
//	public String getDirectorName() {
//		return directorName;
//	}
//
//	/**
//	 * @return the directorGender
//	 */
//	public int getDirectorGender() {
//		return directorGender;
//	}
//
//	/**
//	 * @return the directorNumber
//	 */
//	public int getDirectorNumber() {
//		return directorNumber;
//	}
//
//	/**
//	 * @return the producerName
//	 */
//	public String getProducerName() {
//		return producerName;
//	}
//
//	/**
//	 * @return the producerNumber
//	 */
//	public int getProducerNumber() {
//		return producerNumber;
//	}
//
//	/**
//	 * @return the screenplayName
//	 */
//	public String getScreenplayName() {
//		return screenplayName;
//	}
//
//	/**
//	 * @return the editorName
//	 */
//	public String getEditorName() {
//		return editorName;
//	}
}
