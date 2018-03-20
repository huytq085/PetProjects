package com.tranquanghuy.petprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class NotesEditorActivity extends AppCompatActivity {
    private EditText editText;
    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_editor);
        setControl();

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);
        if (noteId != -1) {
            editText.setText(AppNotes.notes.get(noteId));
        } else {
            AppNotes.notes.add("");
            noteId = AppNotes.notes.size() - 1;
            AppNotes.arrayAdapter.notifyDataSetChanged();
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                AppNotes.notes.set(noteId, String.valueOf(charSequence));
                AppNotes.arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void setControl() {
        editText = findViewById(R.id.editText);
    }
}
