package shm.com.br.medtask;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus Alberto on 17/07/2017.
 */

public class CadastroTarefaActivity extends AppCompatActivity{

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private List<Bitmap> ImageBitmap = new ArrayList<>();
    GridView GridViewImagens;
    ImageAdapter adapter;

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
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(i, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageBitmap.add(imageBitmap);
           // adapter = new ImageAdapter(CadastroTarefaActivity.this, null, ImageBitmap);
            //GridViewImagens.setAdapter(adapter);
            //GridViewImagens.invalidate();
        }
    }

}