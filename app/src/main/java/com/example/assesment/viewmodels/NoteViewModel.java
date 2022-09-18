package com.example.assesment.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.assesment.models.Note;
import com.example.assesment.models.NoteRepository;

import java.util.List;

//FAILED TO IMPLEMENT HE VIEW MODEEL, WAS NOT ABLE TO CREATE AN INSANCE OF THE VIEWMODEL CLASS IN THE ACTIVITY,
//SO I HAD TO SKIP THIS VIEWMODEL PART IN CASE TO MAKE THE APP WORK

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);


        repository= new NoteRepository(application);
        allNotes = repository.getAllNotes();

    }

    public void insert(Note note){
        repository.insert(note);
    }

    public void update(Note note){
        repository.update(note);
    }

    public void delete(Note note){
        repository.delete(note);
    }

    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}
