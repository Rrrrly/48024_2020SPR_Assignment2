package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.*;

//done

public class AddBookController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    
    @FXML private TextField titleTxt;
    @FXML private TextField authorTxt;
    @FXML private TextField genreTxt;
    @FXML private Text feedbackTxt;
    
    private String getTitle() { return titleTxt.getText(); }
    private void setTitle(String title) { titleTxt.setText(title);}
    private String getAuthor() { return authorTxt.getText(); }
    private void setAuthor(String author) { authorTxt.setText(author);}
    private String getGenre() { return genreTxt.getText(); }
    private void setGenre(String genre) { genreTxt.setText(genre);}
    
    @FXML private void initialize() {}
    
    
    //Add Book btn
    @FXML private void handleAddBook(ActionEvent event) {
        //if book is not exist and textfields are not null
        if (!getLibrary().getCatalogue().hasBook(getTitle(), getAuthor()) 
            && !titleTxt.getText().trim().isEmpty()
            && !authorTxt.getText().trim().isEmpty()
            && !genreTxt.getText().trim().isEmpty()) {
            
            getLibrary().getCatalogue().addBook(getTitle(), getAuthor(), getGenre());
            feedbackTxt.setText("Book added to Catalogue.");
        } else if (getLibrary().getCatalogue().hasBook(getTitle(), getAuthor())
                && !authorTxt.getText().trim().isEmpty()
                && !genreTxt.getText().trim().isEmpty()){
            //duplicate book and author and genre textfield aren't empty
            //The book is already in the Catalogue.
            feedbackTxt.setText("The book is already in the Catalogue.");
        } else {
          //invalid input, e.g. empty textfield
          feedbackTxt.setText("Invalid input.");
        }
    }
    
    //close window
    @FXML private void handleClose(ActionEvent e) throws Exception {
        stage.close();
    }
    

}
