package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import model.*;

//done

public class ShowAvailableBooksController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    
    @FXML public void initialize() {

    }
    
    @FXML private void handleClose() {
        stage.close();
    } 

}
