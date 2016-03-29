package pomis.app.sampledatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by romanismagilov on 29.03.16.
 */
public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE `Notes` (\n" +
                "\t`NoteText`\tTEXT,\n" +
                "\t`NID`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`Date`\tDateTime\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
