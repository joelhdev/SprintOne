package ch.uzh.se15.filmvisualizer.client;

import com.google.gwt.user.client.ui.Widget;

/** The Interface Visualizer implements the class of all visualizer, 
 * which make the graphical representation of data in MovieCollection
 * @author 	Joel Hillard
 * @history 2015-11-03 JH First version
 * 			2015-11-05 DK Review results corrected
 * 			2015-11-08 JH Further improvements
 * @version 2015-11-08 JH 1.1
 * @responsibilities
 */
public interface Visualizer {
	
	
	
	/**Creates a Widget with the corresponding visualization of Data
	 * @pre-
	 * @post-
	 * @param-
	 * @return Widget The visualized MovieCollection (in corresponding form )
	 */
	public Widget createVisualization();
	
}
