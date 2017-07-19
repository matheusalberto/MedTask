package shm.com.br.medtask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class ListaCasosActivity extends AppCompatActivity {

    static final String[] IdCasos = new String[] {
            "Caso 1", "Caso 2", "Caso 3", "Caso 4", "Caso 5" };

    static final String[] DescCasos = new String[] {
            "Queimadura 1º grau", "Queimadura 2º grau", "Queimadura 3º grau", "Náuseas",
            "Fratura Exposta na perna direita" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_casos);

        ListView listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, DescCasos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaCasosActivity.this, TarefaActivity.class);
                startActivity(intent);
            }
        });
    }

}
