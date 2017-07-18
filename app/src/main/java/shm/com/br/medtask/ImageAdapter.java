package shm.com.br.medtask;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{

    private Context mContext;

    private final int[] Imageid;
    private final Bitmap[] ImageBitmap;

    public ImageAdapter(Context c, int[] Imageid, Bitmap[] imageBitmap) {
        mContext = c;
        this.Imageid = Imageid;
        this.ImageBitmap = imageBitmap;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item, null);
            ImageView imageView = (ImageView)grid.findViewById(R.id.gridItem);

            if(Imageid != null){
                imageView.setImageResource(Imageid[i]);
            } else if(ImageBitmap != null){
                imageView.setImageBitmap(ImageBitmap[i]);
            }
        } else {
            grid = (View) view;
        }
        return grid;
    }
}
