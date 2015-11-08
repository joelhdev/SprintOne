package ch.uzh.se15.filmvisualizer.client;

import java.util.Iterator;
import java.util.TreeSet;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * The class GWTModuleLoader builds all the filters and buttons for the GUI.
 * It adds all the created widgets to the rootPanel.
 * @author
 * @history
 * @version
 * @responsibilities
 */
public class GWTModuleLoader implements EntryPoint {

	private MovieCollection mc;
	private TreeSet<String> countrySet;
	private TreeSet<String> genreSet;
	private TreeSet<String> languageSet;
	private VerticalPanel mainVerPanel;
	private boolean isVisualized = false;
	final int bottomWidgetIndex = 3;


	
	/**
	 *Entry point method. Calls the methodes that build the GUI.
	 *@pre-
	 *@post-
	 */
	public void onModuleLoad() {
		buildCollection();
		buildGUI();
	}


	
	/**
	*Creates a new movie collection and the TreeSets countrySet, genreSet and languageSet.
	*Populates the TreeSets.
	*@pre-
	*@post-
	*/
	private void buildCollection() {
		
		mc = new MovieCollection(); // Create a new movie collection, which will populate it with locally created Movies

		// Add countries to set (no duplicates allowed)
		countrySet = new TreeSet<String>();
		for (Movie m : mc.getMovieArrayList()) {
			countrySet.add(m.getCountry());
		}
		
		// Add genres to set (no duplicates allowed)
		genreSet = new TreeSet<String>();
		for (Movie m : mc.getMovieArrayList()) {
			for (String s : m.getGenre()) {
				genreSet.add(s);
			}
		}
		
		// Add languages to set (no duplicates allowed)
		languageSet = new TreeSet<String>();
		for (Movie m : mc.getMovieArrayList()) {
			languageSet.add(m.getLanguage());
		}
	}


	
	/**
	 * Creates the main vertical panel for de GUI. 
	 * Adds the headerimage and all other panels to the main panel.
	 * @pre-
	 * @post-
	 */
	private void buildGUI() {
		
		mainVerPanel = new VerticalPanel();	// Create new main vertical panel to which all other panels shall be added

		// Add header image
		Image image = new Image();
		image.setUrl("/images/header4.png");
		mainVerPanel.add(image);

		// Add horizontal panels to main vertical panel
		constructButtonPanel();
		constructFilterPanel();

		// Vertical Panel Settings
		mainVerPanel.setSpacing(25);

		// Insert the main vertical panel into a scroll panel to allow for scrolling
		ScrollPanel sp = new ScrollPanel();
		sp.add(mainVerPanel);

		// Add main vertical panel inside scroll panel to root panel
		RootLayoutPanel.get().add(sp);
	}


	
/**
	 * Create the button panel and the buttons Visualize in Table, World Map, Length Histogram, Country Bar Graph.
	 * Sets all buttons except the Visualize inTable button as disabled.
	 * Adds all buttons to the button panel.
	 * @pre-
	 * @post-
	 */
	private void constructButtonPanel() {	    
		// Table visualization button
		Button tableButton = new Button("Visualize in Table", new ClickHandler() {
			public void onClick(ClickEvent event) {
				visualizeInTable();
			}
		});
		tableButton.setStyleName("blueButton");

		
		// World map visualization button
		Button worldMapButton = new Button("World Map", new ClickHandler() {
			public void onClick(ClickEvent event) {
				// Call method to visualize world map
			}
		});
		worldMapButton.setStyleName("greenButton");

		
		// Length histogram visualization button
		Button histogramButton = new Button("Length Histogram", new ClickHandler() {
			public void onClick(ClickEvent event) {
				// Call method to visualize histogram
			}
		});
		histogramButton.setStyleName("purpleButton");

		
		// Bar graph visualization button
		Button barGraphButton = new Button("Country Bar Graph", new ClickHandler() {
			public void onClick(ClickEvent event) {
				// Call function to visualize bar graph
			}
		});
		barGraphButton.setStyleName("purpleButton");


		// Add all buttons to a horizontal panel
		HorizontalPanel horButtonPanel = new HorizontalPanel();

		horButtonPanel.add(tableButton);
		horButtonPanel.add(worldMapButton);
		horButtonPanel.add(barGraphButton);
		horButtonPanel.add(histogramButton);

		// Add horizontal panel with all button to main vertical panel
		mainVerPanel.add(horButtonPanel);  
	}

	
	
	/**
	 * Creates a filter panel and the filters for country, genre, language, movielenght and year of the movie publication.
	 * Creates also a reset button.
	 * Adds all the filters and the reset button to the panel.
	 * @pre-
	 * @post-
	 */
	private void constructFilterPanel() {

		// Creates the country box
		final ListBox countryBox = new ListBox() {
			// Override is necessary for proper later retrieval of the ListBox's selected index
			@Override
			public void setSelectedIndex(int index) {
				super.setSelectedIndex(index);
			}
		};

		// Populate country ListBox using the country set
		countryBox.addItem("Country");
		Iterator<String> countryIterator = countrySet.iterator();
		while(countryIterator.hasNext()) {
			countryBox.addItem(countryIterator.next());
		}

		countryBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				// React to user's country choice
			}
		});
		countryBox.setVisibleItemCount(1);


		// Creates the genre box
		final ListBox genreBox = new ListBox() {
			@Override
			public void setSelectedIndex(int index) {
				super.setSelectedIndex(index);
			}
		};

		// Populate genre ListBox using the genre set
		genreBox.addItem("Genre");
		Iterator<String> genreIterator = genreSet.iterator();
		while(genreIterator.hasNext()) {
			genreBox.addItem(genreIterator.next());
		}

		genreBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				// React to user's genre choice
			}
		});
		genreBox.setVisibleItemCount(1);


		// Creates the language box
		final ListBox languageBox = new ListBox() {
			@Override
			public void setSelectedIndex(int index) {
				super.setSelectedIndex(index);
			}
		};

		// Populate language ListBox using the language set
		languageBox.addItem("Language");
		Iterator<String> languageIterator = languageSet.iterator();
		while(languageIterator.hasNext()) {
			languageBox.addItem(languageIterator.next());
		}

		languageBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				// React to user's language choice
			}
		});
		languageBox.setVisibleItemCount(1);


		// Creates the length range boxes
		HorizontalPanel horLengthRangePanel = new HorizontalPanel();

		Label lengthLabel = new Label("Length:");

		// Creates the from length box
		final ListBox fromLength = new ListBox() {
			@Override
			public void setSelectedIndex(int index) {
				super.setSelectedIndex(index);
			}
		};
		fromLength.addItem("From");
		for (int i=0; i<50; i++) {
			int j = i*10;
			fromLength.addItem(Integer.toString(j) + " min");
		}
		// Currently, there exist only 9 feature films longer than 500 minutes, 
		// so this seemed to be a reasonable limit in the ListBox selection 
		fromLength.addItem("500+ min");
		fromLength.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				// React to user's length choice
			}
		});
		fromLength.setVisibleItemCount(1);

		// Creates the to length box
		final ListBox toLength = new ListBox() {
			@Override
			public void setSelectedIndex(int index) {
				super.setSelectedIndex(index);
			}
		};
		toLength.addItem("To");
		for (int i=0; i<50; i++) {
			int j = i*10;
			toLength.addItem(Integer.toString(j) + " min");
		}
		toLength.addItem("500+ min");
		toLength.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				// React to user's length choice
			}
		});
		toLength.setVisibleItemCount(1);

		// Adds all the boxes to the panel
		VerticalPanel verLengthListBoxes = new VerticalPanel();	    
		horLengthRangePanel.add(lengthLabel);
		verLengthListBoxes.add(fromLength);
		verLengthListBoxes.add(toLength);
		horLengthRangePanel.add(verLengthListBoxes);


		// Creates the year range boxes; these will eventually be replaced with an interactive slider
		HorizontalPanel horYearRangePanel = new HorizontalPanel();

		Label yearLabel = new Label("Year:");

		// Creates the from year box
		final ListBox fromYear = new ListBox() {
			@Override
			public void setSelectedIndex(int index) {
				super.setSelectedIndex(index);
			}
		};   
		fromYear.addItem("From");
		// The first film ever made was in 1888. We assume our application will have a life-span of
		// ten years, and thus, 2025 is the current upper year limit. This could easily be changed
		// by the IT-specialist
		for (int i=2025; i>1887; i--) {
			fromYear.addItem(Integer.toString(i));
		}
		fromYear.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				// React to user's year choice
			}
		});
		fromYear.setVisibleItemCount(1);

		// Creates the to year box
		final ListBox toYear = new ListBox() {
			@Override
			public void setSelectedIndex(int index) {
				super.setSelectedIndex(index);
			}
		};
		toYear.addItem("To");
		for (int i=2025; i>1887; i--) {
			toYear.addItem(Integer.toString(i));
		}

		toYear.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				// React to user's year choice
			}
		});
		toYear.setVisibleItemCount(1);

		// Constructs the year panel out of label and ListBoxes
		VerticalPanel verYearListBoxes = new VerticalPanel();
		horYearRangePanel.add(yearLabel);
		horYearRangePanel.add(verYearListBoxes);
		verYearListBoxes.add(fromYear);
		verYearListBoxes.add(toYear);


		// Reset all choices made by user
		Button resetFieldsButton = new Button("Reset Filters", new ClickHandler() {
			public void onClick(ClickEvent event) {
				// Set all ListBoxes back to their default value
				countryBox.setItemSelected(0, true);
				genreBox.setItemSelected(0, true);
				languageBox.setItemSelected(0, true);
				fromYear.setItemSelected(0, true);
				toYear.setItemSelected(0, true);
				fromLength.setItemSelected(0, true);
				toLength.setItemSelected(0, true);
			}
		});
		resetFieldsButton.setStyleName("yellowResetButton");


		// Add all ListBoxes to a horizontal panel
		HorizontalPanel horFilterPanel = new HorizontalPanel();

		horFilterPanel.add(countryBox);
		horFilterPanel.add(genreBox);
		horFilterPanel.add(languageBox);
		horFilterPanel.add(horYearRangePanel);
		horFilterPanel.add(horLengthRangePanel);
		horFilterPanel.add(resetFieldsButton);


		// Add the horizontal ListBox panel to the main vertical panel
		mainVerPanel.add(horFilterPanel);
	}


	
	/**
	 * Remove current visualization from the vertical Panel
	 * @pre-
	 * @post-
	 */
	private void removeOldPanels() {
		if (isVisualized) {
			// Remove graphic
			mainVerPanel.remove(bottomWidgetIndex);
		}
		isVisualized = false;
	}

	
	
	/**
	 * Removes the old Panel and creates a new Tablevisualization.
	 * @pre-
	 * @post-
	 */  
	private void visualizeInTable() {
		removeOldPanels();
		TableVisualizer table = new TableVisualizer(mc);
		mainVerPanel.add(table.createVisualization());
		isVisualized = true;
	}

}

