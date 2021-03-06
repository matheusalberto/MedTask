package shm.com.br.medtask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.VideoView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus Alberto on 17/07/2017.
 */

public class CadastroCasoActivity extends AppCompatActivity{

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_VIDEO_CAPTURE = 2;
    private List<Bitmap> ImageBitmap = new ArrayList<>();
    private List<Integer> VideoBitmap = new ArrayList<>();
    private List<Uri> VideoList = new ArrayList<>();
    GridView GridViewImagens;
    VideoView mVideoView; Uri mVideoUri;
    GridView GridViewVideos ;
    CameraAdapter adapter;
    VideoAdapter adapterVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_caso);

        EditText EditTextNome = (EditText)findViewById(R.id.EditTextNome);
        EditText EditTextDescricao = (EditText)findViewById(R.id.EditTextDescricao);
        GridViewImagens = (GridView)findViewById(R.id.GridViewImagens);

        GridViewImagens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);

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

        GridViewVideos = (GridView)findViewById(R.id.gridVideos);
        GridViewVideos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(VideoList.get(position), "video/*");
                startActivity(intent);
            }
        });

        Button btnAssinatura = (Button) findViewById(R.id.btn_coletar_assinatura);
        btnAssinatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroCasoActivity.this, AssinaturaActivity.class);
                startActivity(intent);
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

        Button BtnAnexarVideo = (Button) findViewById(R.id.btn_anexar_video);
        BtnAnexarVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i, REQUEST_VIDEO_CAPTURE);
            }
        });

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_turmas);
        myToolbar.setTitle("MedTask");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.setSubtitle("Cadastro de caso");
        myToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);

        Button enviar_caso = (Button) findViewById(R.id.btn_salvar_caso);
        enviar_caso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            mVideoUri = data.getData();
            VideoList.add(mVideoUri);
            VideoBitmap.add(R.drawable.video);
            adapterVideo = new VideoAdapter(CadastroCasoActivity.this, VideoBitmap);
            GridViewVideos.setAdapter(adapterVideo);
        }
    }

}
