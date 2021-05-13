package controller;

import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class PlaceHoldController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    
    @FXML private TextField idTf;
    @FXML private Button selectPatronBtn;
    @FXML private ListView<Book> booksLv;
    @FXML private Button holdSelectBookBtn;
    @FXML private Text msgTxt;
    
    private int getID() { return Integer.parseInt(idTf.getText()); }
    private void setID(int id) { idTf.setText("" + id); }
    
    @FXML private void initialize() {
        booksLv.setItems(getLibrary().getCatalogue().getAllBooks());
        /* idTf.textProperty().addListener( (observable, oldID, newID) -> 
            selectPatronBtn.setDisable(!newID.matches("[0123456789]+")));
            //set disable false when the condition is true*/
        
//        idTf.textProperty().addListener( (observable, oldID, newID) -> 
//                selectPatronBtn.setDisable(newID == null));
        
        //button disable = true if text field is null
        idTf.textProperty().addListener( (observable, oldID, newID) -> 
                selectPatronBtn.setDisable(newID.length() < 1));
        
        booksLv.getSelectionModel().selectedItemProperty().addListener(
            (observer, oldBook, newBook) -> 
                holdSelectBookBtn.setDisable(newBook == null));
    }
    
    private Book getSelectedBook() {
        return booksLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void handleSelect(ActionEvent evenet) {
        Library library = getLibrary();
        //Correct ID input, then show Books on shelf
        if (library.getPatron(getID()) != null) {
            msgTxt.setText("");
        } else {
            msgTxt.setText("No Patron selected");
//            holdSelectBookBtn.setDisable(true);
        }
        
    }
    
    @FXML private void handleHold(ActionEvent event) {
        Library library = getLibrary();
        Book book = getSelectedBook();
        Patron patron = library.getCatalogue().getPatron(getID());
        
        //Patron is holding a book
        if (book.isHeldBy(patron)) {
            msgTxt.setText(patron.getName() + " has already place a hold on " + book.getTitle());
        } else if (!book.isHeldBy(patron)) {
            book.addHold(patron);
            msgTxt.setText("Hold placed on " + book.getTitle() +
                    " for " + patron.getName() );
        } else {
            msgTxt.setText("No Patron selected");
        }
    }
    
    
    @FXML private void handleClose() {
        stage.close();
    } 

}
