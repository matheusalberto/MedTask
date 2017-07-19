package shm.com.br.medtask;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CasosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_casos);

        String[] IdCasos = new String[] {
                "Caso 1", "Caso 2", "Caso 3", "Caso 4", "Caso 5" };

        final ArrayList<String> listIds = new ArrayList<String>();
        for (int i = 0; i < IdCasos.length; ++i) {
            listIds.add(IdCasos[i]);
        }

        String[] DescCasos = new String[] {
                "Queimadura 1º grau", "Queimadura 2º grau", "Queimadura 3º grau", "Náuseas",
                "Fratura Exposta na perna direita" };

        final ArrayList<String> listDescs = new ArrayList<String>();
        for (int i = 0; i < DescCasos.length; ++i) {
            listDescs.add(DescCasos[i]);
        }

        ListView mListView = (ListView) findViewById(R.id.list_casos);
        final CasosAdapter mAdapter = new CasosAdapter(getBaseContext(), listIds, listDescs);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent intent = new Intent(CasosActivity.this, TarefaActivity.class);
                //startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CasosActivity.this, CadastroCasoActivity.class);
                startActivity(intent);
            }
        });
    }

}
