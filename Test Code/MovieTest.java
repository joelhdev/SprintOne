package com.google.gwt.sample.stockwatcher;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import ch.uzh.se15.filmvisualizer.client.Movie;


/**
 * Unit tests for the {@link Movie} class.
 */
public class MovieTest {
	Movie testMovie;

	@Before
	public void setUp() {
		ArrayList<String> genreList = new ArrayList<String>();
		genreList.add("Action");
		genreList.add("Sci-Fi");
		testMovie = new Movie("The Matrix", 1999, 136, "USA", genreList, "English");
	}
	
	@Test
	public void testConstructorWithParameters() {
		assertTrue(testMovie.getTitle().equals("The Matrix"));
		assertTrue(testMovie.getYear().equals(1999));
		assertTrue(testMovie.getLength().equals(136));
		assertTrue(testMovie.getCountry().equals("USA"));
		assertTrue(testMovie.getGenre().get(0).equals("Action"));
		assertTrue(testMovie.getGenre().get(1).equals("Sci-Fi"));
		assertTrue(testMovie.getLanguage().equals("English"));
	}

	@Test
	public void testGetTitle() {
		assertTrue(testMovie.getTitle().equals("The Matrix"));
	}
	
	@Test
	public void testSetTitle() {
		testMovie.setTitle("The Matrix Reloaded");
		assertTrue(testMovie.getTitle().equals("The Matrix Reloaded"));
	}
	
	@Test
	public void testGetYear() {
		assertTrue(testMovie.getYear().equals(1999));
	}
	
	@Test
	public void testSetYear() {
		testMovie.setYear(2000);
		assertTrue(testMovie.getYear().equals(2000));
	}
	
	@Test
	public void testGetLength() {
		assertTrue(testMovie.getLength().equals(136));
	}
	
	@Test
	public void testSetLength() {
		testMovie.setLength(150);
		assertTrue(testMovie.getLength().equals(150));
	}
	
	@Test
	public void testGetCountry() {
		assertTrue(testMovie.getCountry().equals("USA"));
	}
	
	@Test
	public void testSetCountry() {
		testMovie.setCountry("Russia");
		assertTrue(testMovie.getCountry().equals("Russia"));
	}
	
	@Test
	public void testGetGenre() {
		assertTrue(testMovie.getGenre().get(0).equals("Action"));
		assertTrue(testMovie.getGenre().get(1).equals("Sci-Fi"));
	}
	
	@Test
	public void testSetGenre() {
		ArrayList<String> genreList = new ArrayList<String>();
		genreList.add("Romance");
		testMovie.setGenre(genreList);
		assertTrue(testMovie.getGenre().get(0).equals("Romance"));
	}
	
	@Test
	public void testGetLanguage() {
		assertTrue(testMovie.getLanguage().equals("English"));
	}
	
	@Test
	public void testSetLanguage() {
		testMovie.setLanguage("Russian");
		assertTrue(testMovie.getLanguage().equals("Russian"));
	}
}
