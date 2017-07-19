package shm.com.br.medtask;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class TurmasActivity extends AppCompatActivity {
    private AlertDialog dialogAddTurma;
    private Button botaoDialog;
    private EditText edtNomeTurma;
    private EditText edtAnoTurma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_turmas);

        ListView mListView = (ListView) findViewById(R.id.list_turmas);

        String[] values = new String[] { "Turma 1", "Turma 2", "Turma 3",
                "Turma 4", "Turma 5", "Turma 6", "Turma 7", "Turma 8",
                "Turma 9", "Turma 10", "Turma 11", "Turma 12", "Turma 13", "Turma 14"};

        final ArrayList<String> listNome = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            listNome.add(values[i]);
        }

        final List<String> listaAnos = new ArrayList<>();
        listaAnos.add("1o Ano");
        listaAnos.add("1o Ano");
        listaAnos.add("1o Ano");
        listaAnos.add("2o Ano");
        listaAnos.add("2o Ano");
        listaAnos.add("2o Ano");
        listaAnos.add("2o Ano");
        listaAnos.add("3o Ano");
        listaAnos.add("3o Ano");
        listaAnos.add("4o Ano");
        listaAnos.add("5o Ano");
        listaAnos.add("5o Ano");
        listaAnos.add("5o Ano");
        listaAnos.add("5o Ano");

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_turmas);
        myToolbar.setTitle("MedTask");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.setSubtitle("Turmas cadastradas");
        myToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);


        final TurmasAdapter mAdapter = new TurmasAdapter(getBaseContext(), listNome, listaAnos);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });


        View inflatedView = getLayoutInflater().inflate(R.layout.dialog_nova_turma, null);
        dialogAddTurma = new AlertDialog.Builder(TurmasActivity.this)
                .setView(inflatedView)
                .create();
        edtAnoTurma = inflatedView.findViewById(R.id.edt_ano_turma);
        edtNomeTurma = inflatedView.findViewById(R.id.edt_nome_turma);
        botaoDialog = inflatedView.findViewById(R.id.btn_confirmar);
        botaoDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.addTurma(edtNomeTurma.getText().toString(), edtAnoTurma.getText().toString());
                mAdapter.notifyDataSetChanged();
                dialogAddTurma.dismiss();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogAddTurma.show();
            }
        });
    }


}