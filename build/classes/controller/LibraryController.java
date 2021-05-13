package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import model.*;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

//done

public class LibraryController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    
    @FXML public Button exploreCatBtn;
    @FXML public Button patronRecordBtn;
    @FXML public Button favBookBtn;
    @FXML public Button adminModeBtn; 
    
    @FXML
    public void initialize() {

    }
    
    //Exit btn is pressed
    @FXML public void handleExit() { 
        System.exit(0); //to close all windows
        //stage.close(); //to close the current window
    }

    //AdminMode btn is pressed
    @FXML public void handleAdminMode (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/admin.fxml", "Administration Menu", new Stage());
    }
    
    //FavouritesBooks btn is pressed
    @FXML public void handleFavBooks (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/favourites.fxml", "Favourites", new Stage());
    } 
    
    //Patron record btn is pressed
    @FXML public void handlePatronBtn (ActionEvent e) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/record.fxml", "Patron Reocrd", new Stage());
    }
    
    //Explore Catalogue is pressed
    @FXML public void handleExploreCatalogue(ActionEvent e) throws Exception {
	ViewLoader.showStage(getLibrary(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }

}
