package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

//done

public class AddPatronController extends Controller<Library> {
    public final Library getLibrary() { return model; }
    
    @FXML private TextField patronIDTxt;
    @FXML private TextField patronNameTxt;
    @FXML private Button addPatronBtn;
    @FXML private Text feedbackTxt;
    
    //ID and Name -getter and setter
    private int getPatronID() { return Integer.parseInt(patronIDTxt.getText()); }
    private void setID(int id) { patronIDTxt.setText("" + id); }
    
    private String getPatronName() { return patronNameTxt.getText(); }
    private void setName(String name) { patronNameTxt.setText(name); }
    
    @FXML private void initialize() {
    
    }
    
    //Add Patron btn
    @FXML private void handleAddPatron(ActionEvent event) throws Exception{
        Library library = getLibrary();
        try {
            //check if patron exist and if it is null input
            if(library.getPatron(getPatronID()) == null 
                    && !patronIDTxt.getText().trim().isEmpty() 
                    && !patronNameTxt.getText().trim().isEmpty()) {
            library.addPatron(getPatronID(), getPatronName()); //take user input
            feedbackTxt.setText("Patron added.");
            } else if (library.getPatron(getPatronID()) != null 
                    && !patronNameTxt.getText().trim().isEmpty()) 
                    //same id and no empty textfield
            {
                feedbackTxt.setText("Patron already exists!");
            } else {
                feedbackTxt.setText("Invalid input.");
            }
        } catch (Exception e) {
            //non int input, both textfield are empty
            feedbackTxt.setText("Invalid input."); //catch if ID input is not integer
        } 
    }
    
    //Close btn is pressed
    @FXML private void handleClose(ActionEvent e) throws Exception {
        stage.close();
    }

}
