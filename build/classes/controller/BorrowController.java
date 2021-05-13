package controller;

import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

//done

public class BorrowController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    
    @FXML private TextField idTf;
    @FXML private Button selectPatronBtn;
    @FXML private ListView<Book> booksLv;
    @FXML private Button borrowSelectBookBtn;
    
    private int getID() { return Integer.parseInt(idTf.getText()); }
    private void setID(int id) { idTf.setText("" + id); }
    /*
    "[0123456789]+" //match one or more
    
    */
    
    
    @FXML private void initialize() {
        //idTf.textProperty().addListener( (observable, oldID, newID) -> 
        //    selectPatronBtn.setDisable(!newID.matches("[0123456789]+")));
        //set disable false when the condition is true
        
        //idTf.textProperty().addListener( (observable, oldID, newID) -> 
//            selectPatronBtn.setDisable(newID == null));
        
        //button disable = true if text field is null
        idTf.textProperty().addListener( (observable, oldID, newID) -> 
                selectPatronBtn.setDisable(newID.length() < 1));
        
        booksLv.getSelectionModel().selectedItemProperty().addListener(
            (observer, oldBook, newBook) -> 
                borrowSelectBookBtn.setDisable(newBook == null));
    }
    
    private Book getSelectedBook() {
        return booksLv.getSelectionModel().getSelectedItem();
    }
    
    //Boroow btn is pressed
    @FXML private void handleBorrow(ActionEvent event) {
        Library library = getLibrary();
        Book book = getSelectedBook();
        Patron patron = library.getCatalogue().getPatron(getID());
        //add book to history
        library.getCatalogue().loanBookToPatron(book, patron);
        book.removeHold(patron);
        booksLv.setItems(library.getCatalogue().getBorrowableBooks(patron)); //update the list
    }

    //Select Patron btn is pressed
    @FXML private void handleSelectPatron(ActionEvent event) {
        Library library = getLibrary();
        Patron patron = library.getPatron(getID()); 
        
        //Correct ID input, then show Books on shelf
        if (library.getPatron(getID()) != null) {
            booksLv.setItems(library.getCatalogue().getBorrowableBooks(patron));   
        } else {
            System.out.println("No patron found.");
        }
    }
    
    @FXML private void handleClose() {
        stage.close();
    } 
}
