package com.example.dell.navigationdrawer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class gallery extends AppCompatActivity {

    //the images to display
    Integer[] imageIDs = {
            R.drawable.bg,
            R.drawable.feedback,
            R.drawable.login,
            R.drawable.logonss,
            R.drawable.profile,
            R.drawable.login_image,
            R.drawable.register
    };
    ImageView imageView;
    GridView androidGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //androidGridView = (GridView) findViewById(R.id.listView);
        androidGridView.setAdapter(new ImageAdapterGridView(this));

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent,
                View v, int position, long id) {
            Toast.makeText(getBaseContext(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();
        }
    });

}

public class ImageAdapterGridView extends BaseAdapter {
    private Context mContext;

    public ImageAdapterGridView(Context c) {
        mContext = c;
    }

    public int getCount() {
        return imageIDs.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView mImageView;

        if (convertView == null) {
            mImageView = new ImageView(mContext);
            mImageView.setLayoutParams(new GridView.LayoutParams(130, 130));
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setPadding(16, 16, 16, 16);
        } else {
            mImageView = (ImageView) convertView;
        }
        mImageView.setImageResource(imageIDs[position]);
        return mImageView;
    }
}
}