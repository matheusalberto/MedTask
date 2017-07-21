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

public class TurmaActivity extends AppCompatActivity {
    private AlertDialog dialogAddTurma;
    private Button botaoDialog;
    private EditText edtNomeTurma;
    private EditText edtAnoTurma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turma);

        ListView mListaAlunos = (ListView) findViewById(R.id.list_alunos);

        String[] values = new String[] { "Aluno 1", "Aluno 2", "Aluno 3",
                "Aluno 4", "Aluno 5", "Aluno 6", "Aluno 7", "Aluno 8",
                "Aluno 9", "Aluno 10", "Aluno 11", "Aluno 12", "Aluno 13", "Aluno 14"};

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
        myToolbar.setSubtitle("Turma N");
        myToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);


        final TurmasAdapter mAdapterAlunos = new TurmasAdapter(getBaseContext(), listNome, listaAnos, R.drawable.ic_pessoa);
        mListaAlunos.setAdapter(mAdapterAlunos);
        mListaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });

        List<String> listaCasos = new ArrayList<>();
        listaCasos.add("Caso 1");
        listaCasos.add("Caso 2");
        listaCasos.add("Caso 3");
        listaCasos.add("Caso 4");
        listaCasos.add("Caso 5");
        listaCasos.add("Caso 6");

        List<String> listaDesc = new ArrayList<>();
        listaDesc.add("O paciente chegou com ...");
        listaDesc.add("Neste caso, o paciente ...");
        listaDesc.add("Um caso grave ocorreu ...");
        listaDesc.add("O paciente teve fratura ...");
        listaDesc.add("Houve um acidente de carr ...");
        listaDesc.add("Neste caso, o paciente ...");


        ListView listViewCasos = (ListView) findViewById(R.id.list_casos);


        final TurmasAdapter mAdapterCasos = new TurmasAdapter(getBaseContext(), listaCasos, listaDesc, R.drawable.ic_caso);
        listViewCasos.setAdapter(mAdapterCasos);
        listViewCasos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });


        View inflatedView = getLayoutInflater().inflate(R.layout.dialog_escolha_casos, null);
        dialogAddTurma = new AlertDialog.Builder(TurmaActivity.this)
                .setView(inflatedView)
                .create();
        edtAnoTurma = inflatedView.findViewById(R.id.edt_ano_turma);
        edtNomeTurma = inflatedView.findViewById(R.id.edt_nome_turma);
        botaoDialog = inflatedView.findViewById(R.id.btn_confirmar);
        botaoDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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