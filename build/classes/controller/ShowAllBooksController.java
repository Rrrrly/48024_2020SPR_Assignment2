package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

//done

public class ShowAllBooksController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    
    @FXML private TableView allBooksTv;
        
    @FXML private void handleClose() {
        stage.close();
    } 
    

}
