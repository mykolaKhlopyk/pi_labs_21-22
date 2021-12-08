package com.example.note_system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox VBoxAddNote;

    @FXML
    private VBox VBoxviewAllNode;

    @FXML
    private Button buttonViewAllNote;

    @FXML
    private Button buttonAddFileNote;

    @FXML
    private Button buttonAddFileNote1;

    @FXML
    private Button buttonAddNote;

    @FXML
    private Button buttonAddTextNote;

    @FXML
    private Button buttonAddTextNote1;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonViewTableOfNotes;

    @FXML
    private VBox listOfTables;

    @FXML
    void initialize() {
        assert VBoxAddNote != null : "fx:id=\"VBoxAddNote\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert VBoxviewAllNode != null : "fx:id=\"VBoxviewAllNode\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonViewAllNote != null : "fx:id=\"buttonViewAllNote\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonAddFileNote != null : "fx:id=\"buttonAddFileNote\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonAddFileNote1 != null : "fx:id=\"buttonAddFileNote1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonAddNote != null : "fx:id=\"buttonAddNote\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonAddTextNote != null : "fx:id=\"buttonAddTextNote\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonAddTextNote1 != null : "fx:id=\"buttonAddTextNote1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonExit != null : "fx:id=\"buttonExit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonViewTableOfNotes != null : "fx:id=\"buttonViewTableOfNotes\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert listOfTables != null : "fx:id=\"listOfTables\" was not injected: check your FXML file 'hello-view.fxml'.";

        buttonAddNote.setOnMouseEntered(event -> {
            VBoxAddNote.setVisible(true);

        });
        VBoxAddNote.setOnMouseExited(event->{
            VBoxAddNote.setVisible(false);
        });
        buttonAddNote.setOnMouseExited(event -> {
            if (event.getSceneX() > buttonAddNote.getTranslateX()+buttonAddNote.getWidth()){
                return;
            }
            VBoxAddNote.setVisible(false);
        });
        buttonViewAllNote.setOnMouseEntered(event -> {
            VBoxviewAllNode.setVisible(true);

        });
        VBoxviewAllNode.setOnMouseExited(event->{
            VBoxviewAllNode.setVisible(false);
        });
        buttonViewAllNote.setOnMouseExited(event -> {
            if (event.getSceneX() > buttonViewAllNote.getTranslateX()+buttonViewAllNote.getWidth()){
                return;
            }
            VBoxviewAllNode.setVisible(false);
        });
        buttonViewTableOfNotes.setOnMouseEntered(event -> {
            listOfTables.setVisible(true);

        });
        listOfTables.setOnMouseExited(event->{
            listOfTables.setVisible(false);
        });
        buttonViewTableOfNotes.setOnMouseExited(event -> {
            if (event.getSceneX() > buttonViewTableOfNotes.getTranslateX()+buttonViewTableOfNotes.getWidth()){
                return;
            }
            listOfTables.setVisible(false);
        });

        buttonExit.setOnAction(event->{
            System.exit(0);
        });
    }

}
