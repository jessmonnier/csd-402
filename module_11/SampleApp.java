/* 
 * Jess Monnier
 * CSD-402 Module 11
 * 11 May 2025
 * This is a sample JavaFX application to show the functionality of
 * JavaFX ScrollPane and Accordion
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class SampleApp extends Application {
	@Override
	public void start(Stage stage) {
        
        // Create a reusable block of text to add as content to the panes in our app
        String loremIpsum = """
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi erat nibh, suscipit a \
turpis a, consequat consectetur tellus. Etiam viverra lorem lacus, at suscipit turpis \
luctus vitae. Curabitur eget tortor euismod, tristique arcu at, malesuada ex. Aenean \
venenatis mauris quis orci aliquet, ut imperdiet mauris commodo. Aliquam sed elit \
eleifend, tristique libero quis, tristique turpis. Fusce diam massa, viverra non enim \
eget, tristique venenatis metus. Nulla accumsan justo ac ligula iaculis euismod. \
Aenean at orci lacinia, varius odio at, laoreet felis.

Nam felis tortor, vestibulum ut lacus a, porta commodo arcu. Pellentesque iaculis nulla \
at eleifend lacinia. Quisque molestie, massa dignissim varius suscipit, odio nulla \
hendrerit felis, ac dapibus ipsum felis scelerisque leo. Aenean vitae purus elementum, \
aliquam purus nec, vulputate metus. Praesent non augue eros. Praesent sit amet massa \
ultricies, congue ex eu, mattis nibh. Maecenas tincidunt, justo vel consectetur \
sollicitudin, ex tellus hendrerit elit, non pulvinar elit nibh a enim. Vivamus fermentum \
consequat sodales. Vivamus eu laoreet enim.

Donec ultricies dapibus mauris sed sollicitudin. Cras iaculis leo consequat odio euismod, \
quis aliquet nisl dignissim. Proin eu sodales felis. Nam neque arcu, rutrum vitae metus \
et, cursus finibus ligula. Sed auctor posuere tincidunt. Fusce pellentesque nulla eros, \
at finibus leo tempor a. Sed sed ante erat. Suspendisse ut elit ac est viverra accumsan \
non eu velit. Etiam consectetur metus sed massa porttitor, eu ornare erat porta. In risus \
metus, semper ac posuere ut, tincidunt non magna. Pellentesque gravida neque in augue \
lobortis placerat. Donec at porta tellus, eget fringilla mi. Etiam quis felis a diam \
convallis rutrum bibendum nec sem. Suspendisse sollicitudin porttitor tellus, sed molestie \
purus blandit ac. Aliquam egestas pretium sagittis.
""";

		// Create default text labels to use in our TitledPanes
		Label textOne = new Label(loremIpsum);
		textOne.setPadding(new Insets(5));
		Label textTwo = new Label(loremIpsum);
		textTwo.setPadding(new Insets(5));
		Label textThree = new Label(loremIpsum);
		textThree.setPadding(new Insets(5));
        
        // Create the first titled pane section for our accordion
        TitledPane paneOne = new TitledPane();
        paneOne.setText("First Section");
        paneOne.setContent(textOne);
		
		// Create the second titled pane section for our accordion
        TitledPane paneTwo = new TitledPane();
        paneTwo.setText("Second Section");
        paneTwo.setContent(textTwo);
		
		// Create the third titled pane section for our accordion
        TitledPane paneThree = new TitledPane();
        paneThree.setText("Third Section");
        paneThree.setContent(textThree);
		
		// Create the the accordion and scrollpane elements
		Accordion accordion = new Accordion();
		ScrollPane scroll = new ScrollPane();
		
		// Add content to the accordion, set the first panel to be expanded initially, 
		accordion.getPanes().addAll(paneOne, paneTwo, paneThree);
		accordion.setExpandedPane(paneOne);

		// ensure auto-resizing with window width
		accordion.minWidthProperty().bind(scroll.viewportBoundsProperty().map(bounds -> bounds.getWidth()));
		accordion.maxWidthProperty().bind(scroll.viewportBoundsProperty().map(bounds -> bounds.getWidth()));

		// wrap the Label text within each TitledPane
		textOne.setWrapText(true);
		textTwo.setWrapText(true);
		textThree.setWrapText(true);

		// ensure auto-resizing with window width, subtract 10 to account for padding
		textOne.prefWidthProperty().bind(paneOne.widthProperty().subtract(10));
		textTwo.prefWidthProperty().bind(paneTwo.widthProperty().subtract(10));
		textThree.prefWidthProperty().bind(paneThree.widthProperty().subtract(10));
		
		// Create the scrollpane to house the accordion
		scroll.setContent(accordion);
		scroll.setPadding(new Insets(10));
		
		// Scene and Stage to finalize
		Scene scene = new Scene(scroll, 500, 500);
		stage.setTitle("Sample JavaFX Application");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
   }
   
	public static void main(String[] args) {
		launch(args);
	}
}