package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {

    String year;
    TextView years;
    String firstname;
    TextView firstnames;
    String lastname;
    TextView lastnames;
    ImageView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        years = findViewById(R.id.year);
        firstnames = findViewById(R.id.firstname);
        lastnames = findViewById(R.id.data);
        image1 = findViewById(R.id.id_image_user);


        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b != null) {

            year = (String) b.get("year");
            years.setText(year);
            firstname = (String) b.get("firstname");
            firstnames.setText(firstname);
            lastname = (String) b.get("lastname");
            lastnames.setText(lastname);
        }

        Button bacbBtn =(Button) findViewById(R.id.backuserbtn);
        bacbBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(UserDetailActivity.this, UserActivity.class);
                startActivity(i);
            }
        });

        Button btnUsers =(Button) findViewById(R.id.postbtn);
        btnUsers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(UserDetailActivity.this, MainActivity.class);
                startActivity(i);
            }
        });



    }
}