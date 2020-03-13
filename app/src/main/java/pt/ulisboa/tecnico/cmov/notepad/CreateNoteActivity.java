package pt.ulisboa.tecnico.cmov.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        Button cancel_button = (Button) findViewById(R.id.cancel_button);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button ok_button = (Button) findViewById(R.id.ok_button);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText title_edit_text = (EditText) findViewById(R.id.title_edit_text);
                EditText content_edit_text = (EditText) findViewById(R.id.content_edit_text);

                GlobalClass global_class = (GlobalClass) getApplicationContext();
                global_class.addNote(title_edit_text.getText().toString(), content_edit_text.getText().toString());

                finish();
            }
        });
    }
}
