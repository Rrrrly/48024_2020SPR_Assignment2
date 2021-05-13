package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.*;

//done

public class FavouritesController extends Controller<Library>{
    public final Library getLibrary() { return model; }
    
    @FXML private TextField idTf;
    @FXML private Button showBtn;
    @FXML private ListView<Book> booksLv;
    @FXML private Text msgTxt;
    
    private int getID() { return Integer.parseInt(idTf.getText()); }
    private void setID(int id) { idTf.setText("" + id); }
    
    @FXML private void initialize() {
//        idTf.textProperty().addListener( (observable, oldID, newID) -> 
//            showBtn.setDisable(!newID.matches("[0123456789]+")));
            //set disable false when the condition is true
            
//        idTf.textProperty().addListener( (observable, oldID, newID) -> 
//                showBtn.setDisable(newID == null));
        
        //button disable = true if text field is null
        idTf.textProperty().addListener( (observable, oldID, newID) -> 
                showBtn.setDisable(newID.length() < 1));
            
//        if (idTf.getText().isEmpty()) { msgTxt.setText("No Patron Selected"); }
        msgTxt.setText("No Patron Selected");
        
    }
    
    @FXML private void handleShow(ActionEvent e) {
        Library library = getLibrary();
        //Correct ID input, then show record
        if (library.getPatron(getID()) != null) {
            msgTxt.setText(""+ library.getPatron(getID()).getName() + "'s favourite books:");
            booksLv.setItems(library.getPatron(getID()).favourites());
        } else {
            msgTxt.setText("No Patron Found");
        }
    }
    
    @FXML private void handleClose (ActionEvent e) throws Exception {
        stage.close();
    }

}
