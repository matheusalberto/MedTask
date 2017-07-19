package shm.com.br.medtask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Matheus Alberto on 18/07/2017.
 */

public class FullImageActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        String tipo = i.getExtras().getString("tipo");

        if(tipo.equals("Bitmap")){
            Bitmap bitmap = (Bitmap) i.getParcelableExtra("imagem");
            imageView.setImageBitmap(bitmap);

        } else if(tipo.equals("Drawable")){
            ImageAdapter imageAdapter = new ImageAdapter(this);
            imageView.setImageResource(imageAdapter.mThumbIds[position]);
        }
    }

}
