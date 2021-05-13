package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.*;

//done
public class ShowBooksByAuthorController extends Controller<Library>{
   public final Library getLibrary() { return model; }
    
    @FXML private ListView<Author> authorsLv;
    @FXML private ListView<Book> displayLv;
    
    private Author getSelectedAuthor() {
        return authorsLv.getSelectionModel().getSelectedItem();
    }

    //Display btn is pressed
    @FXML private void handleDisplay(ActionEvent e) {
        Author author = getSelectedAuthor();
        //linkinga listView to model
        displayLv.setItems(getLibrary().getCatalogue().getBooksByAuthor(author)); 
    }
    
    @FXML private void handleClose() {
        stage.close();
    } 

}
