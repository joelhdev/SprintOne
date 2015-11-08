package ch.uzh.se15.filmvisualizer.client;

import java.util.ArrayList;

/**The Class Movie saves the information about each particular film.
 * @author 	Joel Hillard
 * @history 2015-11-03 JH First version
 * 			2015-11-05 DK Review results corrected
 * 			2015-11-08 JH Further improvements
 * @version 2015-11-08 JH 1.1
 * @responsibilities -
 */

public class Movie {
	
	private String title;
	private Integer year;
	private Integer length;
	private String country;
	private ArrayList<String> genre;
	private String language;

	
	
	/**Default Constructor.
	 * @pre-
	 * @post-
	 * @param-
	 * @return Movie object with default values
	 */
	public Movie() {
	}

	
	
	/**Creates a new Movie instance, and sets the with the parameters.
	 * @pre-
	 * @post construction is succeed
	 * @param title The Title of the movie
	 * @param year  The Year of the movie
	 * @param length The Length of the movie (in minutes)
	 * @param country The Production country of the movie
	 * @param genre An Array with the genres of the movie
	 * @param language The language of the movie
	 * @return Movie object with the values from the parameters
	 */
	public Movie(String title, Integer year, Integer length, String country, ArrayList<String> genre, String language) {
		this.title = title;
		this.year = year;
		this.length = length;
		this.country = country;
		this.genre = genre;
		this.language = language;
	}

	
	
	/** Gets the Title of the movie
	 * @pre- 
	 * @post-
	 * @param-
	 * @return String Title of the movie
	 */
	public String getTitle() {
		return title;
	}

	
	
	/** Changes the title of the movie
	 * @pre-
	 * @post-
	 * @param title  New value of the movie.
	 * @return-
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	/** Gets the Year of the movie
	 * @pre- 
	 * @post-
	 * @param-
	 * @return Integer Year of the production of movie
	 */
	public Integer getYear() {
		return year;
	}

	
	
	/** Changes the Year of the movie
	 * @pre-
	 * @post-
	 * @param year  New year value of the movie.
	 * @return-
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	
	
	/** Gets the Length of the movie
	 * @pre- 
	 * @post-
	 * @param-
	 * @return Integer Length of the movie
	 */
	public Integer getLength() {
		return length;
	}

	
	
	/** Changes the Length of the movie
	 * @pre-
	 * @post-
	 * @param length  New length value of the movie.
	 * @return-
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	
	
	/** Gets the Country of the production of movie
	 * @pre- 
	 * @post-
	 * @param-
	 * @return String country of the production 
	 */
	public String getCountry() {
		return country;
	}

	
	
	/** Changes the Country of the production of movie
	 * @pre-
	 * @post-
	 * @param country  New value production country of the movie.
	 * @return-
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	
	
	/** Gets the array with all genres of the movie
	 * @pre- 
	 * @post-
	 * @param-
	 * @return Arraylist Genres of the production 
	 */
	public ArrayList<String> getGenre() {
		return genre;
	}

	
	
	/** Changes the genres of the movie
	 * @pre-
	 * @post-
	 * @param genre  New genres values of the movie.
	 * @return-
	 */
	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}

	
	
	/** Gets the language of the movie
	 * @pre- 
	 * @post-
	 * @param-
	 * @return String language of the movie
	 */
	public String getLanguage() {
		return language;
	}

	
	
	/** Changes the language of the movie
	 * @pre-
	 * @post-
	 * @param language  New value  of the movie's language.
	 * @return-
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
