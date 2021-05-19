package hust.soict.dsai.javafx;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    private VBox vbox;
    private ToggleGroup bruh;
    private boolean pen = true;
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = null;
    	if (pen) {
    		newCircle = new Circle(event.getX(),
	    			event.getY(), 4, Color.BLACK);
    	}
    	
    	else if (!pen){
	    	newCircle = new Circle(event.getX(),
	    			event.getY(), 4, Color.WHITE);
    	}
    	
    	if (event.getX() > 0 && event.getY() > 0 && event.getX() < drawingAreaPane.getWidth() && event.getY() < drawingAreaPane.getHeight())
    		drawingAreaPane.getChildren().add(newCircle);
    }


    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void pen(ActionEvent event) {
    	pen = true;
    }
    
    @FXML
    void eraser(ActionEvent event) {
    	pen = false;
    }

}
