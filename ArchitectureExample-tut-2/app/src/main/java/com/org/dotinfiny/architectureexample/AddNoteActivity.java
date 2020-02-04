package com.org.dotinfiny.architectureexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.org.dotinfiny.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESC = "com.org.dotinfiny.architectureexample.EXTRA_DESC";
    public static final String EXTRA_PRIORITY = "com.org.dotinfiny.architectureexample.EXTRA_PRIORITY";
    private EditText etTextTitle, etTextDesc;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        etTextTitle = (EditText) findViewById(R.id.edit_text_title);
        etTextDesc = (EditText) findViewById(R.id.edit_text_description);
        numberPicker = (NumberPicker) findViewById(R.id.number_picker_priority);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

    private void saveNote() {
        String title = etTextTitle.getText().toString();
        String desc = etTextDesc.getText().toString();
        int priority = numberPicker.getValue();

        if (title.trim().isEmpty() || desc.trim().isEmpty()) {
            Toast.makeText(this, "Please Insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }
//        Toast.makeText(this, "Saved Note", Toast.LENGTH_SHORT).show();

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESC, desc);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
