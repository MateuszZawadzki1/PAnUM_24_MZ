package com.example.cafeapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cafeapp.Drink;
import com.example.cafeapp.R;

public class SnackActivity extends Activity {
    public static final String EXTRA_SNACKID = "snackId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);
        int snackId = (Integer)getIntent().getExtras().get(EXTRA_SNACKID);
        Snack snack = Snack.snacks[snackId];
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(snack.getName());
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(snack.getDescription());
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(snack.getImageResourceId());
        photo.setContentDescription(snack.getName());
    }
}