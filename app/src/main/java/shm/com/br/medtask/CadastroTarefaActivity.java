package shm.com.br.medtask;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by Matheus Alberto on 17/07/2017.
 */

public class CadastroTarefaActivity extends AppCompatActivity{

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Bitmap[] ImageBitmap = new Bitmap[100]; int idx = 0;
    GridView GridViewImagens; ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_tarefa);

        EditText EditTextNome = (EditText)findViewById(R.id.EditTextNome);
        EditText EditTextDescricao = (EditText)findViewById(R.id.EditTextDescricao);
        GridViewImagens = (GridView)findViewById(R.id.GridViewImagens);

        Button BtnAnexarFoto = (Button) findViewById(R.id.BtnAnexarFoto);
        BtnAnexarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File picsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File imageFile = new File(picsDir, "foto.jpg");
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));
                startActivity(i);
            }
        });

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_turmas);
        myToolbar.setTitle("MedTask");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.setSubtitle("Cadastro de tarefa");
        myToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
    }
}
