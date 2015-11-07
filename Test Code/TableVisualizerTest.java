package ch.uzh.se15.visualizer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.Widget;

import ch.uzh.se15.filmvisualizer.client.TableVisualizer;
import ch.uzh.se15.filmvisualizer.client.MovieCollection;

/**
 * Unit tests for the {@link TableVisualizer} class.
 */
public class TableVisualizerTest extends GWTTestCase{
	private TableVisualizer testTable;

	/**
	 * must refer to a valid module that sources this class.
	 */
	public String getModuleName() {
		return "ch.uzh.se15.filmvisualizer.client.TableVisualizer";
	}

//	@Before
//	public void setUp() {
//		MovieCollection testMc = new MovieCollection();
//		testTable = new TableVisualizer(testMc);
//	}

	
	@Test
	public void createVisualization() {
		TableVisualizer testTable = GWT.create(TableVisualizer.class);
		Widget testWidget = testTable.createVisualization();
		assertTrue(testWidget instanceof Widget);
	}
	
	@Test
	public void draw() {
		// The correctness of the displayed table can only be determined by the user. 
		// This will be tested in the Systemtest.
	}
}
