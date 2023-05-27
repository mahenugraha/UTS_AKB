/**
 *
 * Nama : Mahendra Nugraha
 * Nim : 10120015
 * Kelas : IF 1
 * Email : mahenugrahaa
 *
 */

package com.uts.mahendranugraha_10120015;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText u_note_title, u_note_category, u_note_description;
    Button update_btn, back_btn;
    String id, title, category, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        u_note_title = findViewById(R.id.u_note_title);
        u_note_category = findViewById(R.id.u_note_category);
        u_note_description = findViewById(R.id.u_note_description);
        update_btn = findViewById(R.id.u_save_btn);
        back_btn = findViewById(R.id.u_back_btn);
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHelper db = new MyDBHelper(UpdateActivity.this);
                NoteModel notes = new NoteModel();
                notes.id = Integer.valueOf(id);
                notes.title = String.valueOf(u_note_title.getText());
                notes.description = String.valueOf(u_note_description.getText());
                notes.category = String.valueOf(u_note_category.getText());
                db.updateNote(notes);
                Toast.makeText(UpdateActivity.this, "Update data success", Toast.LENGTH_SHORT).show();
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        getAndSetIntentData();
    }

    public void getAndSetIntentData() {
        if(getIntent().hasExtra("id")) {
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            category = getIntent().getStringExtra("category");
            description = getIntent().getStringExtra("description");
            // Set data
            u_note_title.setText(title);
            u_note_category.setText(category);
            u_note_description.setText(description);
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}