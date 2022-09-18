package com.example.assesment.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//A simple java class that represent a table in the database, here we created a table, declared fields name our table will have


@Entity(tableName = "note_table")
public class Note {

    //primary key to identify each entry uniquely
    @PrimaryKey(autoGenerate = true)
    private int id;

    //variables for the fields of out note_table
    private String title;
    private String description;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
