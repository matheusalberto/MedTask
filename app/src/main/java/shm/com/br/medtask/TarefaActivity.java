package shm.com.br.medtask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus Alberto on 17/07/2017.
 */

public class TarefaActivity extends AppCompatActivity {

    int[] imageId = {
            R.drawable.queimadura1,
            R.drawable.queimadura1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        ImageAdapter adapter = new ImageAdapter(TarefaActivity.this, imageId);
        GridView GridViewImagens = (GridView)findViewById(R.id.GridViewImagens);
        GridViewImagens.setAdapter(adapter);
    }

}
