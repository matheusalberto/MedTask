package shm.com.br.medtask;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaCasosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_casos);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_turmas);
        myToolbar.setTitle("MedTask");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.setSubtitle("Lista de casos");
        myToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);

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

        final String tipoConta = getIntent().getStringExtra("TipoConta");

        ListView mListView = (ListView) findViewById(R.id.list_casos);
        final CasosAdapter mAdapter = new CasosAdapter(getBaseContext(), listIds, listDescs);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(tipoConta.equalsIgnoreCase("Professor"))
                {
                    Intent intent = new Intent(ListaCasosActivity.this, CadastroCasoActivity.class);
                    startActivity(intent);
                    return;
                }
                Intent intent = new Intent(ListaCasosActivity.this, CasoActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if(tipoConta.equals("Aluno"))
            fab.setVisibility(View.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCasosActivity.this, CadastroCasoActivity.class);
                startActivity(intent);
            }
        });
    }

}
