package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostDetailActivity extends AppCompatActivity {
    String content;
    TextView cont;
    String title;
    TextView title1;
    String data;
    TextView data1;
    String image;
    ImageView image1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_post_detail);
        cont = findViewById(R.id.content);
        title1 = findViewById(R.id.title);
        data1 = findViewById(R.id.data);
        image1 = findViewById(R.id.id_image);


        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b != null) {

            content = (String) b.get("content");
            cont.setText(content);
            title = (String) b.get("title");
            title1.setText(title);
            data = (String) b.get("data");
            data1.setText(data);
        }


    }
}