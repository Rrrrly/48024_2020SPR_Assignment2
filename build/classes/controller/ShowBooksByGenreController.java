package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.*;
//done

public class ShowBooksByGenreController extends Controller<Library>{
    public final Library getLibrary() { return model; }
    
    @FXML private ListView<Genre> genresLv;
    @FXML private ListView<Book> displayLv;
    
    private Genre getSelectedGenre() {
        return genresLv.getSelectionModel().getSelectedItem();
    }
    
    //Display btn is pressed
    @FXML private void handleDisplay(ActionEvent e) {
        Genre genre = getSelectedGenre();
        //linkinga listView to model
        displayLv.setItems(getLibrary().getCatalogue().getBooksInGenre(genre)); 
    }
    @FXML private void handleClose() {
        stage.close();
    } 
}
