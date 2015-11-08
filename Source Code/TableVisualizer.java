package ch.uzh.se15.filmvisualizer.client;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.table.Table;
import com.googlecode.gwt.charts.client.table.TableOptions;
import com.googlecode.gwt.charts.client.table.TablePage;


/** The Class TableVisualizer represents the content of the movie Collection in form of a table.
 * @author 	Joel Hillard
 * @history 2015-11-03 JH First version
 * 			2015-11-05 DK Review results corrected
 * 			2015-11-08 JH Further improvements
 * @version 2015-11-08 JH 1.1
 * @responsibilities-
 */
public class TableVisualizer implements Visualizer{
	
	private Table table;
	private FocusPanel focusPanel;
	private MovieCollection mc;

	
	
	/**Changes the MovieCollection to be visualized
	 * @pre-
	 * @post-
	 * @param mc New Collection of movies that should be visualized
	 * @return-
	 */
	public TableVisualizer(MovieCollection mc) {
		this.mc = mc;
	}

	
	
	/** Creates a Widget, where the Table will be drawn, and calls the draw() method to visualize the table.
	 * @pre-
	 * @post-
	 * @param-
	 * @return Widget The visualized MovieCollection (table)
	 */
	public Widget createVisualization() {
		focusPanel = new FocusPanel();
		
		ChartLoader chartLoader = new ChartLoader(ChartPackage.TABLE);
		chartLoader.loadApi(new Runnable() {

			@Override
			public void run() {
				
				// Create visualization and add to return Panel
				table = new Table();
				focusPanel.setWidget(table);
				draw();
			}
		});
		
		return focusPanel;
	}

	
	
	/** Using the GWT-functionality, first a DataTable will be created, which then will be drawn.  
	 * @pre-
	 * @post-
	 * @param-
	 * @return-
	 */
	private void draw() {
		
		// Create DataTable
		DataTable dataTable = DataTable.create();
		dataTable.addColumn(ColumnType.STRING, "Title");
		dataTable.addColumn(ColumnType.NUMBER, "Year");
		dataTable.addColumn(ColumnType.NUMBER, "Length");
		dataTable.addColumn(ColumnType.STRING, "Country");
		dataTable.addColumn(ColumnType.STRING, "Genre");
		dataTable.addColumn(ColumnType.STRING, "Language");

		// Populate DataTable
		ArrayList<Movie> movieList = mc.getMovieArrayList();
		
		dataTable.addRows(movieList.size());
		
		int i = 0;
		for (Movie m : movieList) {
			dataTable.setValue(i, 0, m.getTitle());
			dataTable.setValue(i, 1, m.getYear());
			dataTable.setValue(i, 2, m.getLength());
			dataTable.setValue(i, 3, m.getCountry());
			dataTable.setValue(i, 4, m.getGenre().toString());
			dataTable.setValue(i, 5, m.getLanguage());
			i++;
		}

		// Table options
		TableOptions options = TableOptions.create();
		options.setAlternatingRowStyle(true);
		options.setPage(TablePage.ENABLE);
		options.setPageSize(100);	// Limit the number of displayed movies to 100.

		// Draw visualization
		table.draw(dataTable, options);
	}
}