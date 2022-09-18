package com.example.assesment.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.assesment.models.Note;

import java.util.List;

//A simple java interface that will handle all crud operation for our note table

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table")//this will return all the notes that we can disply in the recycler view
    LiveData<List<Note>> getAllNotes();


}
