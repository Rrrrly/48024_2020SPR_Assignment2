package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Library;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

//done

public class AdminController extends Controller<Library> {
    @FXML private Button removePatronBtn;
    @FXML private Button addBookBtn;
    @FXML private Button removeBookBtn;
    @FXML private Button exitAdminBtn;
    
    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {

    }
    
    //Exit btn is pressed
    @FXML public void handleExit() { stage.close(); }
    
    // Code below hasn't //
    
    //Remove Book btn is pressed
    @FXML public void handleRemoveBook (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/removeBook.fxml", "Remove Book", new Stage());
    }
    
    //Add book btn is pressed
    @FXML public void handleAddBook (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/addBook.fxml", "Add Book", new Stage());
    }
    
    //Remove Patron btn is pressed
    @FXML public void handleRemovePatron (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/removePatron.fxml", "Remove Patron", new Stage());
    }
    
    //Add Patron btn is pressed
    @FXML public void handleAddPatron (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/addPatron.fxml", "Add Patron", new Stage());
    }
    
   

}
