package shm.com.br.medtask;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateushideaki on 7/18/17.
 */

public class CasosAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> values;
    private List<String> descs;

    public CasosAdapter(Context c, List<String> v, List<String> a){
        super(c, -1, v);
        context = c;
        values = v;
        descs = a;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(R.layout.casos_item, parent, false);
        TextView textView1 = rowView.findViewById(R.id.firstLine);
        TextView textView2 =  rowView.findViewById(R.id.secondLine);
        ImageView imageView = rowView.findViewById(R.id.icon);
        textView1.setText(values.get(position));
        textView2.setText(descs.get(position));
        // change the icon for Windows and iPhone

        return rowView;
    }


}