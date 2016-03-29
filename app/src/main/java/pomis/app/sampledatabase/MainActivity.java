package pomis.app.sampledatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private MyDBHelper db;
    private SQLiteDatabase connection;
    private String noteText;
    private ArrayList<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatabase();
        initButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        readNotes();
    }

    private void initButton() {
        try {
            (findViewById(R.id.b_send)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    noteText = ((EditText) findViewById(R.id.et_note_text)).getText().toString();
                    connection.execSQL("insert into Notes(NoteText, Date) values('" + noteText + "', datetime())");
                    readNotes();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initDatabase() {
        db = new MyDBHelper(this, "myDataBase", null, 1);
        connection = db.getWritableDatabase();
    }


    void readNotes(){
        noteList = new ArrayList<>();
        Cursor cursor = connection.rawQuery("select * from Notes", null);
        while (cursor.moveToNext()){
            String noteText = cursor.getString(0);
            String date = cursor.getString(2);
            noteList.add(new Note(noteText, date));
        }
        cursor.close();
        ListView listView = ((ListView)findViewById(R.id.lv_notes));

        NoteAdapter noteAdapter = new NoteAdapter(this, R.layout.item_note, noteList);
        listView.setAdapter(noteAdapter);
    }
}


