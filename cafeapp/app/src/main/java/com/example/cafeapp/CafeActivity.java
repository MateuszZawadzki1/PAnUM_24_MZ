package com.example.cafeapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cafeapp.R;

public class CafeActivity extends Activity {
    public static final String EXTRA_CAFEID = "cafeId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);
        int cafeId = (Integer)getIntent().getExtras().get(EXTRA_CAFEID);
        Cafe cafe = Cafe.cafes[cafeId];
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(cafe.getName());
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(cafe.getImageResourceId());
        photo.setContentDescription(cafe.getName());
    }
}