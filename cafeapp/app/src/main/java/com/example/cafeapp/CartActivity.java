package com.example.cafeapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CartActivity extends AppCompatActivity {

    private ListView cartListView;
    private ArrayAdapter<CartItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Koszyk");

        cartListView = findViewById(R.id.cart_list);

        adapter = new ArrayAdapter<CartItem>(this, 0, Cart.getItems()) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.cart_item_layout, parent, false);
                }

                CartItem item = getItem(position);
                ImageView imageView = convertView.findViewById(R.id.cart_item_image);
                TextView nameView = convertView.findViewById(R.id.cart_item_name);
                Button removeButton = convertView.findViewById(R.id.remove_button);

                imageView.setImageResource(item.getImageResId());
                nameView.setText(item.getName());

                removeButton.setOnClickListener(v -> {
                    Cart.removeItem(position);
                    adapter.notifyDataSetChanged();
                });

                return convertView;
            }
        };
        cartListView.setAdapter(adapter);

        if (Cart.getItems().isEmpty()) {
            cartListView.setEmptyView(createEmptyView());
        }
    }

    private TextView createEmptyView() {
        TextView emptyView = new TextView(this);
        emptyView.setText("Twój koszyk jest pusty");
        emptyView.setTextSize(20);
        emptyView.setGravity(android.view.Gravity.CENTER);
        emptyView.setLayoutParams(new ListView.LayoutParams(
                ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.MATCH_PARENT));
        ((ViewGroup) cartListView.getParent()).addView(emptyView);
        return emptyView;
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}