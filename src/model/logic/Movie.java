package model.logic;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

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
	private int revenue;
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
	private String actor1Name;
	private int actor1Gender;
	private String actor2Name;
	private int actor2Gender;
	private String actor3Name;
	private int actor3Gender;
	private String actor4Name;
	private int actor4Gender;
	private String actor5Name;
	private int actor5Gender;
	private int actorNumber;
	private String directorName;
	private int directorGender;
	private int directorNumber;
	private String producerName;
	private int producerNumber;
	private String screenplayName;
	private String editorName;
	
	public Movie( int id, int budget, String genres, String imdbID, String originalLanguage, String originalTitle, String overview, double popularity, String productionCompanies, String productionCountries, Date releaseDate, int revenue, int runtime, String spokenLanguages, String status, String tagline, String title, double voteAverage, double voteCount, int productionCompaniesNumber, int productionCountriesNumber, int spokenLanguagesNumber, String actor1Name, int actor1Gender, String actor2Name, int actor2Gender, String actor3Name, int actor3Gender, String actor4Name, int actor4Gender, String actor5Name, int actor5Gender, int actorNumber, String directorName, int directorGender, int directorNumber, String producerName, int producerNumber, String screenplayName, String editorName )
	{
		this.id = id;
		this.budget = budget;
		this.genres = genres;
		this.imdbID = imdbID;
		this.originalLanguage = originalLanguage;
		this.originalTitle = originalTitle;
		this.overview = overview;
		this.popularity = popularity;
		this.productionCompanies = productionCompanies;
		this.productionCountries = productionCountries;
		this.releaseDate = releaseDate;
		this.revenue = revenue;
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
		this.actor1Name = actor1Name;
		this.actor1Gender = actor1Gender;
		this.actor2Name = actor2Name;
		this.actor2Gender = actor2Gender;
		this.actor3Name = actor3Name;
		this.actor3Gender = actor3Gender;
		this.actor4Name = actor4Name;
		this.actor4Gender = actor4Gender;
		this.actor5Name = actor5Name;
		this.actor5Gender = actor5Gender;
		this.actorNumber = actorNumber;
		this.directorName = directorName;
		this.directorGender = directorGender;
		this.directorNumber = directorNumber;
		this.producerName = producerName;
		this.producerNumber = producerNumber;
		this.screenplayName = screenplayName;
		this.editorName = editorName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the budget
	 */
	public int getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(int budget) {
		this.budget = budget;
	}

	/**
	 * @return the genres
	 */
	public String getGenres() {
		return genres;
	}

	/**
	 * @param genres the genres to set
	 */
	public void setGenres(String genres) {
		this.genres = genres;
	}

	/**
	 * @return the imdbID
	 */
	public String getImdbID() {
		return imdbID;
	}

	/**
	 * @param imdbID the imdbID to set
	 */
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	/**
	 * @return the originalLanguage
	 */
	public String getOriginalLanguage() {
		return originalLanguage;
	}

	/**
	 * @param originalLanguage the originalLanguage to set
	 */
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	/**
	 * @return the originalTitle
	 */
	public String getOriginalTitle() {
		return originalTitle;
	}

	/**
	 * @param originalTitle the originalTitle to set
	 */
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	/**
	 * @return the overview
	 */
	public String getOverview() {
		return overview;
	}

	/**
	 * @param overview the overview to set
	 */
	public void setOverview(String overview) {
		this.overview = overview;
	}

	/**
	 * @return the popularity
	 */
	public double getPopularity() {
		return popularity;
	}

	/**
	 * @param popularity the popularity to set
	 */
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	/**
	 * @return the productionCompanies
	 */
	public String getProductionCompanies() {
		return productionCompanies;
	}

	/**
	 * @param productionCompanies the productionCompanies to set
	 */
	public void setProductionCompanies(String productionCompanies) {
		this.productionCompanies = productionCompanies;
	}

	/**
	 * @return the productionCountries
	 */
	public String getProductionCountries() {
		return productionCountries;
	}

	/**
	 * @param productionCountries the productionCountries to set
	 */
	public void setProductionCountries(String productionCountries) {
		this.productionCountries = productionCountries;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the renevue
	 */
	public int getRevenue() {
		return revenue;
	}

	/**
	 * @param renevue the renevue to set
	 */
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	/**
	 * @return the runtime
	 */
	public int getRuntime() {
		return runtime;
	}

	/**
	 * @param runtime the runtime to set
	 */
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	/**
	 * @return the spokenLanguages
	 */
	public String getSpokenLanguages() {
		return spokenLanguages;
	}

	/**
	 * @param spokenLanguages the spokenLanguages to set
	 */
	public void setSpokenLanguages(String spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the tagline
	 */
	public String getTagline() {
		return tagline;
	}

	/**
	 * @param tagline the tagline to set
	 */
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the voteAverage
	 */
	public double getVoteAverage() {
		return voteAverage;
	}

	/**
	 * @param voteAverage the voteAverage to set
	 */
	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	/**
	 * @return the voteCount
	 */
	public double getVoteCount() {
		return voteCount;
	}

	/**
	 * @param voteCount the voteCount to set
	 */
	public void setVoteCount(double voteCount) {
		this.voteCount = voteCount;
	}

	/**
	 * @return the productionCompaniesNumber
	 */
	public int getProductionCompaniesNumber() {
		return productionCompaniesNumber;
	}

	/**
	 * @param productionCompaniesNumber the productionCompaniesNumber to set
	 */
	public void setProductionCompaniesNumber(int productionCompaniesNumber) {
		this.productionCompaniesNumber = productionCompaniesNumber;
	}

	/**
	 * @return the productionCountriesNumber
	 */
	public int getProductionCountriesNumber() {
		return productionCountriesNumber;
	}

	/**
	 * @param productionCountriesNumber the productionCountriesNumber to set
	 */
	public void setProductionCountriesNumber(int productionCountriesNumber) {
		this.productionCountriesNumber = productionCountriesNumber;
	}

	/**
	 * @return the spokenLanguagesNumber
	 */
	public int getSpokenLanguagesNumber() {
		return spokenLanguagesNumber;
	}

	/**
	 * @param spokenLanguagesNumber the spokenLanguagesNumber to set
	 */
	public void setSpokenLanguagesNumber(int spokenLanguagesNumber) {
		this.spokenLanguagesNumber = spokenLanguagesNumber;
	}

	/**
	 * @return the actor1Name
	 */
	public String getActor1Name() {
		return actor1Name;
	}

	/**
	 * @param actor1Name the actor1Name to set
	 */
	public void setActor1Name(String actor1Name) {
		this.actor1Name = actor1Name;
	}

	/**
	 * @return the actor1Gender
	 */
	public int getActor1Gender() {
		return actor1Gender;
	}

	/**
	 * @param actor1Gender the actor1Gender to set
	 */
	public void setActor1Gender(int actor1Gender) {
		this.actor1Gender = actor1Gender;
	}

	/**
	 * @return the actor2Name
	 */
	public String getActor2Name() {
		return actor2Name;
	}

	/**
	 * @param actor2Name the actor2Name to set
	 */
	public void setActor2Name(String actor2Name) {
		this.actor2Name = actor2Name;
	}

	/**
	 * @return the actor2Gender
	 */
	public int getActor2Gender() {
		return actor2Gender;
	}

	/**
	 * @param actor2Gender the actor2Gender to set
	 */
	public void setActor2Gender(int actor2Gender) {
		this.actor2Gender = actor2Gender;
	}

	/**
	 * @return the actor3Name
	 */
	public String getActor3Name() {
		return actor3Name;
	}

	/**
	 * @param actor3Name the actor3Name to set
	 */
	public void setActor3Name(String actor3Name) {
		this.actor3Name = actor3Name;
	}

	/**
	 * @return the actor3Gender
	 */
	public int getActor3Gender() {
		return actor3Gender;
	}

	/**
	 * @param actor3Gender the actor3Gender to set
	 */
	public void setActor3Gender(int actor3Gender) {
		this.actor3Gender = actor3Gender;
	}

	/**
	 * @return the actor4Name
	 */
	public String getActor4Name() {
		return actor4Name;
	}

	/**
	 * @param actor4Name the actor4Name to set
	 */
	public void setActor4Name(String actor4Name) {
		this.actor4Name = actor4Name;
	}

	/**
	 * @return the actor4Gender
	 */
	public int getActor4Gender() {
		return actor4Gender;
	}

	/**
	 * @param actor4Gender the actor4Gender to set
	 */
	public void setActor4Gender(int actor4Gender) {
		this.actor4Gender = actor4Gender;
	}

	/**
	 * @return the actor5Name
	 */
	public String getActor5Name() {
		return actor5Name;
	}

	/**
	 * @param actor5Name the actor5Name to set
	 */
	public void setActor5Name(String actor5Name) {
		this.actor5Name = actor5Name;
	}

	/**
	 * @return the actor5Gender
	 */
	public int getActor5Gender() {
		return actor5Gender;
	}

	/**
	 * @param actor5Gender the actor5Gender to set
	 */
	public void setActor5Gender(int actor5Gender) {
		this.actor5Gender = actor5Gender;
	}

	/**
	 * @return the actorNumber
	 */
	public int getActorNumber() {
		return actorNumber;
	}

	/**
	 * @param actorNumber the actorNumber to set
	 */
	public void setActorNumber(int actorNumber) {
		this.actorNumber = actorNumber;
	}

	/**
	 * @return the directorName
	 */
	public String getDirectorName() {
		return directorName;
	}

	/**
	 * @param directorName the directorName to set
	 */
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	/**
	 * @return the directorGender
	 */
	public int getDirectorGender() {
		return directorGender;
	}

	/**
	 * @param directorGender the directorGender to set
	 */
	public void setDirectorGender(int directorGender) {
		this.directorGender = directorGender;
	}

	/**
	 * @return the directorNumber
	 */
	public int getDirectorNumber() {
		return directorNumber;
	}

	/**
	 * @param directorNumber the directorNumber to set
	 */
	public void setDirectorNumber(int directorNumber) {
		this.directorNumber = directorNumber;
	}

	/**
	 * @return the producerName
	 */
	public String getProducerName() {
		return producerName;
	}

	/**
	 * @param producerName the producerName to set
	 */
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	/**
	 * @return the producerNumber
	 */
	public int getProducerNumber() {
		return producerNumber;
	}

	/**
	 * @param producerNumber the producerNumber to set
	 */
	public void setProducerNumber(int producerNumber) {
		this.producerNumber = producerNumber;
	}

	/**
	 * @return the screenplayName
	 */
	public String getScreenplayName() {
		return screenplayName;
	}

	/**
	 * @param screenplayName the screenplayName to set
	 */
	public void setScreenplayName(String screenplayName) {
		this.screenplayName = screenplayName;
	}

	/**
	 * @return the editorName
	 */
	public String getEditorName() {
		return editorName;
	}

	/**
	 * @param editorName the editorName to set
	 */
	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}
}
