package ch.uzh.se15.filmvisualizer.client;

import java.util.ArrayList;


/**The Class MovieCollection  saves the whole collection of Movie-Objects, or the results of filtering.
 * @author 	Joel Hillard
 * @history 2015-11-03 JH First version
 * 			2015-11-05 DK Review results corrected
 * 			2015-11-08 JH Further improvements
 * @version 2015-11-08 JH 1.1
 * @responsibilities-
 */
public class MovieCollection {
	
	private ArrayList<Movie> movies;

	
	
	/**Constructs a new MovieCollection and fills it with new movies through the method papulate().
	 * @pre-
	 * @post MovieCollection.getMovieCollectionSize() = MovieCollection.getMovieCollectionSize() + 25
	 * @param-
	 * @return MovieCollection 
	 */
	public MovieCollection() {
		movies = new ArrayList<Movie>();
		populate();
	}

	
	
	/**Adds a new Movie-Object to the Movie collection .
	 * @pre-
	 * @post (MovieCollection.getMovieCollectionSize() = MovieCollection.getMovieCollectionSize() +1) && (passedMovie is in the MovieCollection)
	 * @param passedMovie Movie to be added to the Movie collection
	 * @return-
	 */
	public void addMovie(Movie passedMovie) {
		movies.add(passedMovie);
	}

	
	
	/**Removes the Movie-Object from the Movie collection 
	 * @pre (MovieCollection.getMovieCollectionSize() > 0) && (passedMovie is in the MovieCollection)
	 * @post (MovieCollection.getMovieCollectionSize() = MovieCollection.getMovieCollectionSize() -1) && (passedMovie is not more in the MovieCollection)
	 * @param passedMovie - The movie to be removed
	 * @return-
	 */
	public void removeMovie(Movie passedMovie) {
		movies.remove(passedMovie);
	}

	
	
	/**Returns the whole collection of Movie-Objects from the Movie collection.
	 * @pre-
	 * @post-
	 * @param-
	 * @return ArrayList<Movie> movies- The whole movies , which are in the MovieCollection.
	 */
	public ArrayList<Movie> getMovieArrayList() {
		return movies;
	}

	
	
	/**Returns the size (as integer) of the Movie Collection (how many Movies are in the collection)
	 * @pre-
	 * @post-
	 * @param-
	 * @return int size The size of the MovieCollection
	 */
	public int getMovieCollectionSize() {
		return movies.size();
	}

	
	
	/**Adds several Films to the Movie collection. Is used at the beginning of the Project to show the functionality to the stakeholders
	 * @pre-
	 * @post MovieCollection.getMovieCollectionSize() =  MovieCollection.getMovieCollectionSize() + 25
	 * @param-
	 * @return-
	 */
	private void populate() {
		ArrayList<String> m1List = new ArrayList<String>();
		m1List.add("Drama");
		m1List.add("Romance");
		m1List.add("War");
		Movie m1 = new Movie();
		m1.setTitle("Casablanca");
		m1.setYear(1942);
		m1.setLength(102);
		m1.setCountry("USA");
		m1.setGenre(m1List);
		m1.setLanguage("English");
		addMovie(m1);
		
		ArrayList<String> m2List = new ArrayList<String>();
		m2List.add("Action");
		m2List.add("Sci-Fi");
		Movie m2 = new Movie("The Matrix", 1999, 136, "USA", m2List, "English");
		addMovie(m2);
		
		ArrayList<String> m3List = new ArrayList<String>();
		m3List.add("Drama");
		Movie m3 = new Movie("Wild Strawberries", 1957, 91, "Sweden", m3List, "Swedish");
		addMovie(m3);
		
		ArrayList<String> m4List = new ArrayList<String>();
		m4List.add("Mystery");
		m4List.add("Sci-Fi");
		Movie m4 = new Movie("2001: A Space Odyssey", 1968, 160, "USA", m4List, "English");
		addMovie(m4);
		
		ArrayList<String> m5List = new ArrayList<String>();
		m5List.add("Crime");
		m5List.add("Drama");
		m5List.add("Thriller");
		Movie m5 = new Movie("The Silence of the Lambs", 1991, 118, "USA", m5List, "English");
		addMovie(m5);
		
		ArrayList<String> m6List = new ArrayList<String>();
		m6List.add("Comedy");
		m6List.add("Drama");
		m6List.add("Romance");
		Movie m6 = new Movie("Chungking Express", 1994, 102, "China", m6List, "Cantonese");
		addMovie(m6);
		
		ArrayList<String> m7List = new ArrayList<String>();
		m7List.add("Drama");
		Movie m7 = new Movie("Bicycle Thieves", 1948, 93, "Italy", m7List, "Italian");
		addMovie(m7);
		
		ArrayList<String> m8List = new ArrayList<String>();
		m8List.add("Drama");
		m8List.add("Romance");
		Movie m8 = new Movie("In the Mood for Love", 2000, 98, "China", m8List, "Cantonese");
		addMovie(m8);
		
		ArrayList<String> m9List = new ArrayList<String>();
		m9List.add("Drama");
		m9List.add("Horror");
		Movie m9 = new Movie("Hour of the Wolf", 1968, 90, "Sweden", m9List, "Swedish");
		addMovie(m9);
		
		ArrayList<String> m10List = new ArrayList<String>();
		m10List.add("Drama");
		Movie m10 = new Movie("The Great Beauty", 2013, 141, "Italy", m10List, "Italian");
		addMovie(m10);
		
		ArrayList<String> dramaList = new ArrayList<String>();
		dramaList.add("Drama");
		ArrayList<String> actionList = new ArrayList<String>();
		actionList.add("Action");
		ArrayList<String> scifiList = new ArrayList<String>();
		scifiList.add("Sci Fi");
		ArrayList<String> thrillerList = new ArrayList<String>();
		thrillerList.add("Thriller");
		ArrayList<String> horrorList = new ArrayList<String>();
		horrorList.add("Horror");
		ArrayList<String> documentaryList = new ArrayList<String>();
		documentaryList.add("Documentary");
		ArrayList<String> comedyList = new ArrayList<String>();
		comedyList.add("Comedy");
		
		Movie m11 = new Movie("The Seventh Seal", 1957, 96, "Sweden", dramaList, "Swedish");
		Movie m12 = new Movie("Fargo", 1996, 98, "USA", dramaList, "English");
		Movie m13 = new Movie("Scream", 1996, 111, "USA", horrorList, "English");
		Movie m14 = new Movie("The Remains of the Day", 1993, 134, "Great Britain", dramaList, "English");
		Movie m15 = new Movie("La Dolce Vita", 1960, 174, "Italy", dramaList, "Italian");
		Movie m16 = new Movie("Lessons of Darkness", 1992, 54, "Great Britain", documentaryList, "English");
		Movie m17 = new Movie("Metropolis", 1927, 153, "Germany", dramaList, "German");
		Movie m18 = new Movie("Onibaba", 1964, 103, "Japan", horrorList, "Japanese");
		Movie m19 = new Movie("3 Idiots", 2009, 170, "India", comedyList, "Hindi");
		Movie m20 = new Movie("Let the Right One In", 2008, 115, "Sweden", horrorList, "Swedish");
		Movie m21 = new Movie("Pan's Labyrinth", 2006, 118, "Spain", dramaList, "Spanish");
		Movie m22 = new Movie("Kung Fu Hustle", 2004, 99, "China", actionList, "Cantonese");
		Movie m23 = new Movie("Grey Gardens", 1975, 94, "USA", documentaryList, "English");
		Movie m24 = new Movie("Suzhou River", 2000, 83, "China", dramaList, "Mandarin");
		Movie m25 = new Movie("High Tension", 2003, 91, "France", horrorList, "French");
		addMovie(m11);
		addMovie(m12);
		addMovie(m13);
		addMovie(m14);
		addMovie(m15);
		addMovie(m16);
		addMovie(m17);
		addMovie(m18);
		addMovie(m19);
		addMovie(m20);
		addMovie(m21);
		addMovie(m22);
		addMovie(m23);
		addMovie(m24);
		addMovie(m25);
	}
}
