package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class RemovePatronController extends Controller<Library>{
    public final Library getLibrary() { return model; }
    
    @FXML private Button removePatronBtn;
    @FXML private ListView<Patron> patronsLv;
    
    //return current selected item
    private Patron getSelectedPatron() {
        return patronsLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML public void handleClose (ActionEvent e) throws Exception {
        stage.close();
    }
    
    //remove selected patron
    @FXML public void handleRemovePatron (ActionEvent e) throws Exception {
        Patron patron = getSelectedPatron();
        getLibrary().removePatron(patron);
    }

}