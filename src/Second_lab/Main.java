package com.example.note_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

<<<<<<< HEAD
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //stage.initStyle(StageStyle.UNDECORATED);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Notes");
        stage.setScene(scene);
        stage.show();
=======
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    static ArrayList<Note> main_list_of_notes=new ArrayList<>();
    private double xoffset;
    private double yoffset;
    static public Stage main_stage;
    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED);
        main_stage=stage ;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("notes.txt")))
        {
            main_list_of_notes=((ArrayList<Note>)ois.readObject());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());




        stage.setTitle("Notes");
        stage.setScene(scene);
        stage.show();


>>>>>>> b7d5192d83c9b671ebeaa5a23c51de5b61137a49
    }

    public static void main(String[] args) {
        launch();
    }
}