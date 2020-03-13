package pt.ulisboa.tecnico.cmov.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReadNoteActivity extends AppCompatActivity {

    private GlobalClass globalClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);

        this.globalClass = (GlobalClass) getApplicationContext();
        Note note = this.globalClass.getNote(this.globalClass.getOpen());

        TextView title = (TextView) findViewById(R.id.title_text_view);
        title.setText(note.getTitle());

        TextView content = (TextView) findViewById(R.id.content_text_view);
        content.setText(note.getContent());

    }
}
