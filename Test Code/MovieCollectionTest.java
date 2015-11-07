package ch.uzh.se15.visualizer;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import ch.uzh.se15.filmvisualizer.client.Movie;
import ch.uzh.se15.filmvisualizer.client.MovieCollection;

/**
 * Unit tests for the {@link MovieCollection} class.
 */
public class MovieCollectionTest {
	private MovieCollection testMc;
	private Movie testMovie;
	
	@Before
	public void setup() {
		testMc = new MovieCollection();
		
		ArrayList<String> genreList = new ArrayList<String>();
		genreList.add("Horror");
		testMovie = new Movie("Pontypool", 2009, 93, "Canada", genreList, "English");
	}
	
	@Test
	public void testGetMovieArrayList() {
		assertTrue(testMc.getMovieArrayList() instanceof ArrayList<?>);
	}
	
	@Test
	public void testPopulate() {
		assertTrue(testMc.getMovieArrayList().get(0).getTitle().equals("Casablanca"));
		assertTrue(testMc.getMovieArrayList().get(24).getLanguage().equals("French"));
	}
	
	@Test
	public void testGetMovieCollectionSize() {
		assertTrue(testMc.getMovieArrayList().size() == testMc.getMovieCollectionSize());
	}

	@Test
	public void testAddMovie() {
		testMc.addMovie(testMovie);
		int testMovieLocation = testMc.getMovieArrayList().indexOf(testMovie);
		assertTrue(testMc.getMovieArrayList().get(testMovieLocation).getTitle().equals("Pontypool"));
	}
	
	@Test
	public void testRemoveMovie() {
		testMc.removeMovie(testMovie);
		assertFalse(testMc.getMovieArrayList().contains(testMovie));
	}
	
}