package shm.com.br.medtask;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
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

public class TurmasAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> values;
    private List<String> listAnos;
    private int resourceId;

    public TurmasAdapter(Context c, List<String> v, List<String> a, int res){
        super(c, -1, v);
        context = c;
        values = v;
        listAnos = a;
        resourceId = res;
    }

    public void addTurma(String nome, String ano){
        values.add(nome);
        listAnos.add(ano);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(R.layout.linha_turma, parent, false);
        TextView textView1 = rowView.findViewById(R.id.firstLine);
        TextView textView2 =  rowView.findViewById(R.id.secondLine);
        ImageView imageView = rowView.findViewById(R.id.icon);
        textView1.setText(values.get(position));
        textView2.setText(listAnos.get(position));
        // change the icon for Windows and iPhone
        imageView.setImageResource(resourceId);
        return rowView;
    }


}