package shm.com.br.medtask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus Alberto on 17/07/2017.
 */

public class CadastroCasoActivity extends AppCompatActivity{

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private List<Bitmap> ImageBitmap = new ArrayList<>();
    GridView GridViewImagens;
    CameraAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_tarefa);

        EditText EditTextNome = (EditText)findViewById(R.id.EditTextNome);
        EditText EditTextDescricao = (EditText)findViewById(R.id.EditTextDescricao);
        GridViewImagens = (GridView)findViewById(R.id.GridViewImagens);

        GridViewImagens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                // passing array index
                i.putExtra("id", position);
                i.putExtra("tipo", "Bitmap");

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                ImageBitmap.get(position).compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                i.putExtra("imagem",ImageBitmap.get(position));

                startActivity(i);
            }
        });

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

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_turmas);
        myToolbar.setTitle("MedTask");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.setSubtitle("Cadastro de tarefa");
        myToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageBitmap.add(imageBitmap);
            adapter = new CameraAdapter(CadastroCasoActivity.this, ImageBitmap);
            GridViewImagens.setAdapter(adapter);
        }
    }

}
