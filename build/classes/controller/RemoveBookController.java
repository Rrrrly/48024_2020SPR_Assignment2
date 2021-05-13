package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

//done
public class RemoveBookController extends Controller<Library>{
    public final Library getLibrary() { return model; }
    
    @FXML private ListView<Book> booksLv;
    
    private Book getSelectedBook() {
        return booksLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void handleRemoveBook(ActionEvent e) throws Exception {
        Book book = getSelectedBook();
        getLibrary().getCatalogue().removeBook(book);
    }
    
    //Close btn is pressed
    @FXML private void handleClose (ActionEvent e) throws Exception {
        stage.close();
    }

}
