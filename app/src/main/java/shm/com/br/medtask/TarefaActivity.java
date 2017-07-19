package shm.com.br.medtask;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

/**
 * Created by Matheus Alberto on 17/07/2017.
 */

public class TarefaActivity extends AppCompatActivity {

    int[] imageId = {
            R.drawable.queimadura1,
            R.drawable.queimadura2,
            R.drawable.queimadura3,
            R.drawable.queimadura4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        ImageAdapter adapter = new ImageAdapter(TarefaActivity.this, imageId, null);
        GridView GridViewImagens = (GridView)findViewById(R.id.GridViewImagens);
        GridViewImagens.setAdapter(adapter);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_turmas);
        myToolbar.setTitle("MedTask");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.setSubtitle("Tarefa");
        myToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
    }

}
