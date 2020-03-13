package pt.ulisboa.tecnico.cmov.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListNotesActivity extends AppCompatActivity {

    private ArrayList<String> titles;
    private ArrayAdapter<String> notes_array_adapter;
    private GlobalClass globalClass;
    private int note_number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.globalClass = (GlobalClass) getApplicationContext();
        this.titles = this.globalClass.getTitles();

        this.notes_array_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
        ListView notes_list_view = (ListView) findViewById(R.id.note_list);
        notes_list_view.setAdapter(this.notes_array_adapter);

        notes_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListNotesActivity.this, ReadNoteActivity.class);
                globalClass.setOpen(position);
                startActivity(intent);
            }
        });

        Button button = (Button) findViewById(R.id.new_note_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListNotesActivity.this, CreateNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (this.note_number != titles.size()) {
            notes_array_adapter.notifyDataSetChanged();
        }

    }
}
