package controller;

import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

//done

public class ReturnController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    
    @FXML private TextField idTf;
    @FXML private Button selectPatronBtn;
    @FXML private ListView<Book> booksLv;
    @FXML private Button returnSelectBookBtn;
    
    private int getID() { return Integer.parseInt(idTf.getText()); }
    private void setID(int id) { idTf.setText("" + id); }
    
    @FXML private void initialize() {
//        idTf.textProperty().addListener( (observable, oldID, newID) -> 
//            selectPatronBtn.setDisable(newID == null));
        
//        idTf.textProperty().addListener( (observable, oldID, newID) -> 
//            selectPatronBtn.setDisable(!newID.matches("[0123456789]+")));

        //button disable = true if text field is null
        idTf.textProperty().addListener( (observable, oldID, newID) -> 
                selectPatronBtn.setDisable(newID.length() < 1));
        
        
        booksLv.getSelectionModel().selectedItemProperty().addListener(
            (observer, oldBook, newBook) -> 
                returnSelectBookBtn.setDisable(newBook == null));
    }
    
    private Book getSelectedBook() {
        return booksLv.getSelectionModel().getSelectedItem();
    }
    
    //Return btn is pressed
    // remove book from currently borrowed
    @FXML private void handleReturn (ActionEvent event) {
        Library library = getLibrary();
        Book book = getSelectedBook();
        Patron patron = library.getCatalogue().getPatron(getID());;
        
        //return book to shelf
        library.getCatalogue().returnBookFromPatron(book, patron);
    }
    
    //Select Patron btn is pressed
    @FXML private void handleSelectPatron (ActionEvent event) {
        Library library = getLibrary();
//        Patron patron = library.getPatrons().currentlyBorrowedOP;
        //Correct ID input, then show borrowed book
        if (library.getPatron(getID()) != null) {
            booksLv.setItems(library.getPatron(getID()).currentlyBorrowed());
        } else {
            System.out.println("No patron found.");
        }
    }
    
    @FXML private void handleClose() {
        stage.close();
    } 

}
