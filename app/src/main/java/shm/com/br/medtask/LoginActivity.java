package shm.com.br.medtask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText EditTextLogin = (EditText)findViewById(R.id.EditTextLogin);
        EditText EditTextSenha = (EditText)findViewById(R.id.EditTextLogin);
        Button ButtonLogar = (Button)findViewById(R.id.ButtonLogar);

        ButtonLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CasosActivity.class);
                startActivity(intent);
            }
        });

    }
}
