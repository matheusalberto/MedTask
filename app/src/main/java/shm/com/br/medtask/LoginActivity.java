package shm.com.br.medtask;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText EditTextLogin = (EditText)findViewById(R.id.EditTextLogin);
        EditText EditTextSenha = (EditText)findViewById(R.id.EditTextLogin);
        Button ButtonLogar = (Button)findViewById(R.id.ButtonLogar);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_turmas);
        myToolbar.setTitle("MedTask");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.setSubtitle("SHM 2017");
        myToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);

        ButtonLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = EditTextLogin.getText().toString();
                Intent intent = new Intent(LoginActivity.this, TurmaActivity.class);
                switch (login){
                    case "Professor":
                        intent = new Intent(LoginActivity.this, TurmasActivity.class);
                        intent.putExtra("TipoConta", "Professor");
                        break;
                    case "Aluno":
                        intent = new Intent(LoginActivity.this, ListaCasosActivity.class);
                        intent.putExtra("TipoConta", "Aluno");
                        break;
                    case "Medico":
                        intent = new Intent(LoginActivity.this, ListaCasosActivity.class);
                        intent.putExtra("TipoConta", "Medico");
                        break;
                    default:
                        Toast.makeText(getBaseContext(),"Login ou senha incorretos.", Toast.LENGTH_SHORT).show();
                        return;
                }
                startActivity(intent);
            }
        });

    }
}
