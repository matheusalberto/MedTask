package shm.com.br.medtask;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by mateushideaki on 7/17/17.
 */

public class AssinaturaActivity extends AppCompatActivity  {

    private Button btn_salvar;
    private Button btn_limpar;
    private DrawingView mDrawingView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assinatura);

        mDrawingView = new DrawingView(getBaseContext());

        LinearLayout layoutAssinatura = (LinearLayout) findViewById(R.id.assinatura_layout);
        layoutAssinatura.addView(mDrawingView);

        btn_limpar = (Button) findViewById(R.id.btn_limpar);
        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawingView.clear();
            }
        });

        btn_salvar = (Button) findViewById(R.id.btn_salvar);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_turmas);
        myToolbar.setTitle("MedTask");
        myToolbar.setTitleTextColor(Color.WHITE);
        myToolbar.setSubtitle("Assinatura");
        myToolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);

    }



}
