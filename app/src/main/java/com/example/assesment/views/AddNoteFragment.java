package com.example.assesment.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assesment.models.Note;
import com.example.assesment.models.NoteRepository;
import com.example.assesment.R;


public class AddNoteFragment extends Fragment {

    private EditText etTitle;
    private EditText etDescription;
    private Button btnSaveNote;

    private NoteRepository repository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        repository= new NoteRepository(getActivity().getApplication());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_add_note, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etTitle = view.findViewById(R.id.etTitle);
        etDescription = view.findViewById(R.id.etDescription);
        btnSaveNote = view.findViewById(R.id.btnSave);

        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveNote();
            }
        });
    }


    private void saveNote() {

        String title = etTitle.getText().toString();
        String description = etDescription.getText().toString();

        if(title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(getActivity(), "Please insert a title & description", Toast.LENGTH_SHORT).show();
        }

        Note note = new Note(title, description);
        repository.insert(note);

        Toast.makeText(getActivity(), "Note saved", Toast.LENGTH_SHORT).show();

        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.mainContainer,new HomeFragment());
        fr.commit();


    }


}