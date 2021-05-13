package controller;

import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;

//done

public class CatalogueController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    @FXML
    public void initialize() {

    }
    
    @FXML public void handleExit (ActionEvent e) throws Exception {
        stage.close();
    }
    
    @FXML public void handlePlaceHold (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/placeHold.fxml", "Place a Hold", new Stage());
    }
    @FXML public void handleReturn (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/return.fxml", "Return a Book", new Stage());
    }  
    
    @FXML public void handleBorrow (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/borrow.fxml", "Borrow a Book", new Stage());
    }
    
    @FXML public void handlByAuthor (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showBooksByAuthor.fxml", "Browse by Author", new Stage());
    }
        
    @FXML public void handleByGenre (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showBooksByGenre.fxml", "Browse by Genre", new Stage());
    }
    
    @FXML public void handleAvaBook (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showAvailableBooks.fxml", "Available Books", new Stage());
    }
    
    @FXML public void handleShowAllBook (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showAllBooks.fxml", "Complete Catalogue", new Stage());
    }
}
