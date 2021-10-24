package com.example.note_system;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Controller {

    public int number_of_note_for_showing;
    final String path = "notes.txt";
    private boolean in_main_list;
    @FXML
    private VBox VBoxAddNote;

    @FXML
    private VBox VBoxviewAllNode;

    @FXML
    private Button buttonAction;

    @FXML
    private Button buttonAddFileNote;

    @FXML
    private Button buttonAddNote;

    @FXML
    private Button buttonAddTextNote;

    @FXML
    private Button buttonArchivePane;

    @FXML
    private Button buttonArchive;

    @FXML
    private Button button_to_main;

    @FXML
    private Button button_go_to_archive;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonViewAllNote;

    @FXML
    private Button buttonViewTableOfNotes;

    @FXML
    private ImageView button_left;

    @FXML
    private Button button_push;

    @FXML
    private ImageView button_right;

    @FXML
    private VBox listOfTables;

    @FXML
    private Pane pane_adding_note;

    @FXML
    private Pane pane_view_node;

    @FXML
    private TextArea text_mrssage;

    @FXML
    private TextArea text_mrssage1;
    @FXML
    void initialize() {
        assert VBoxAddNote != null : "fx:id=\"VBoxAddNote\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert VBoxviewAllNode != null : "fx:id=\"VBoxviewAllNode\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonViewAllNote != null : "fx:id=\"buttonViewAllNote\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonAddFileNote != null : "fx:id=\"buttonAddFileNote\" was not injected: check your FXML file 'hello-view.fxml'.";
     //   assert buttonAddFileNote1 != null : "fx:id=\"buttonAddFileNote1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonAddNote != null : "fx:id=\"buttonAddNote\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert buttonAddTextNote != null : "fx:id=\"buttonAddTextNote\" was not injected: check your FXML file 'hello-view.fxml'.";
      //  assert buttonAddTextNote1 != null : "fx:id=\"buttonAddTextNote1\" was not injected: check your FXML file 'hello-view.fxml'.";
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
        buttonAction.setOnMouseEntered(event -> {
            text_mrssage1.setEditable(false);
            VBoxviewAllNode.setVisible(true);

        });
        VBoxviewAllNode.setOnMouseExited(event->{
            VBoxviewAllNode.setVisible(false);
        });
        buttonAction.setOnMouseExited(event -> {
            if (event.getSceneX() > buttonAction.getTranslateX()+buttonAction.getWidth()){
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

        button_go_to_archive.setOnAction(event->{
            text_mrssage1.setText("");

            pane_adding_note.setVisible(false);
            pane_view_node.setVisible(true);
            buttonArchive.setVisible(false);
            button_to_main.setVisible(true);
            in_main_list=false;
            number_of_note_for_showing=find_first_note_for_showing(in_main_list);
            if(number_of_note_for_showing==-1){
                text_mrssage1.setText("");
            }else{
                text_mrssage1.setText(Main.main_list_of_notes.get(number_of_note_for_showing).get_message());
            }
        });

        buttonAddTextNote.setOnAction(event->{
            pane_adding_note.setVisible(true);
            pane_view_node.setVisible(false);
        });

        buttonViewAllNote.setOnAction(event->{
            pane_adding_note.setVisible(false);
            pane_view_node.setVisible(true);
            buttonArchive.setVisible(false);
            button_to_main.setVisible(false);
            in_main_list=true;
            int index = find_first_note_for_showing(in_main_list);
            if (index != -1){
                text_mrssage1.setText(Main.main_list_of_notes.get(index).get_message());
            }

        });
        buttonArchivePane.setOnAction(event->{
            pane_adding_note.setVisible(false);
            pane_view_node.setVisible(true);
            buttonArchive.setVisible(true);
            button_to_main.setVisible(false);
            in_main_list=true;
            number_of_note_for_showing=find_first_note_for_showing(in_main_list);
            if(number_of_note_for_showing==-1){
                text_mrssage1.setText("");
            }else{
                text_mrssage1.setText(Main.main_list_of_notes.get(number_of_note_for_showing).get_message());
            }
        });


        button_push.setOnAction(event->{
            if (text_mrssage.getText().trim().length()!=0) {
                 Main.main_list_of_notes.add(new Note(text_mrssage.getText()));
            }
            text_mrssage.setText("");
        });
        button_right.setOnMouseClicked(event->{
            number_of_note_for_showing=find_right_note_for_showing(in_main_list);
            if (number_of_note_for_showing != -1){
                text_mrssage1.setText(Main.main_list_of_notes.get(number_of_note_for_showing).get_message());
            }
        });
        button_left.setOnMouseClicked(event->{
            number_of_note_for_showing=find_left_note_for_showing(in_main_list);
            if (number_of_note_for_showing != -1){
                text_mrssage1.setText(Main.main_list_of_notes.get(number_of_note_for_showing).get_message());
            }
        });

        button_to_main.setOnAction(event->{
            if (number_of_note_for_showing != -1){
                Main.main_list_of_notes.get(number_of_note_for_showing).transport_to_main_list();
            }
            int index = find_first_note_for_showing(in_main_list);
            if (index != -1){
                text_mrssage1.setText(Main.main_list_of_notes.get(index).get_message());
            }else{
                text_mrssage1.setText("");
            }
        });
        buttonArchive.setOnAction(event->{
            if (number_of_note_for_showing != -1){
                Main.main_list_of_notes.get(number_of_note_for_showing).transport_to_archive();
            }
            int index = find_first_note_for_showing(in_main_list);
            if (index != -1){
                text_mrssage1.setText(Main.main_list_of_notes.get(index).get_message());
            }else{
                text_mrssage1.setText("");
            }
        });
        buttonExit.setOnAction(event->{
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
            {
                oos.writeObject(Main.main_list_of_notes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        });
    }

    int find_first_note_for_showing(boolean main_list){

        for (int i=0; i<Main.main_list_of_notes.size(); i++){
            if (Main.main_list_of_notes.get(i).get_in_main_list()==main_list){
                number_of_note_for_showing=i;
                return number_of_note_for_showing;
            }
        }
        return -1;
    }
    int find_right_note_for_showing(boolean main_list){
        if (number_of_note_for_showing==-1){
             return -1;
        }
        for (int i=number_of_note_for_showing+1; i<Main.main_list_of_notes.size(); i++){
            if (Main.main_list_of_notes.get(i).get_in_main_list()==main_list){
                number_of_note_for_showing=i;
                return number_of_note_for_showing;
            }
        }
        return number_of_note_for_showing;
    }
    int find_left_note_for_showing(boolean main_list){
        if (number_of_note_for_showing==-1){
            return -1;
        }
        for (int i=number_of_note_for_showing-1; i>=0; i--){
            if (Main.main_list_of_notes.get(i).get_in_main_list()==main_list){
                number_of_note_for_showing=i;
                return number_of_note_for_showing;
            }
        }
        return number_of_note_for_showing;
    }
}

