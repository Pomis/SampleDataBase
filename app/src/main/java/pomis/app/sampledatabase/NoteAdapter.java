package pomis.app.sampledatabase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by romanismagilov on 29.03.16.
 */
public class NoteAdapter extends ArrayAdapter {
    Activity context;
    ArrayList<Note> noteList;

    public NoteAdapter(Context context, int resource, ArrayList<Note> notes) {
        super(context, resource, notes);
        this.context = (Activity) context;
        noteList = notes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        rowView = inflater.inflate(R.layout.item_note, null);
        ((TextView) rowView.findViewById(R.id.tv_title)).setText(noteList.get(position).value);
        ((TextView) rowView.findViewById(R.id.tv_date)).setText(noteList.get(position).date);

        return rowView;
    }
}
