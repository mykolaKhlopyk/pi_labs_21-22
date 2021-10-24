package com.example.note_system;


import java.io.Serializable;

public class Note implements Serializable {
    private boolean in_main_list;//1 - yes,  0 - in archive
    private String message;
    Note(){
        this.message = "";
    }

    Note(String message){
        this.in_main_list=true;
        this.message = message;
    }
    public boolean get_in_main_list(){
        return this.in_main_list;
    }
    public String get_message(){
        return this.message;
    }
    public void transport_to_main_list(){
        this.in_main_list=true;
    }
    public void transport_to_archive(){
        this.in_main_list=false;
    }
    public void set_message(String message){
        this.message=message;
    }
}
