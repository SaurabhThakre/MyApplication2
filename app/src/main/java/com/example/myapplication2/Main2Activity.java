package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    String[] string1 ={"absolutely","beaming","calm","dazzling ","earnest","fabulous","generous","happy","idea","jovial","kind","laugh ",
            "marvelous","natural","one","positive","quality","ready","safe","terrific ","unleashed","valued","warm","xmas","yes","zeal"};
    AutoCompleteTextView ac,ac1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ac = findViewById(R.id.actv);
        ac1 = findViewById(R.id.actv1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,string1);
        ac.setThreshold(1);
        ac.setAdapter(adapter);
        ac1.setThreshold(1);
        ac1.setAdapter(adapter);
    }

    public void goToActivity3(View v){
        Intent intent = new Intent (this, Main3Activity.class);
        startActivity(intent);
    }

    public void goToActivity11(View v){

        Intent intent = new Intent (this, MainActivity.class);
        intent.putExtra("username",ac.getText().toString());
        intent.putExtra("password",ac1.getText().toString());
        startActivity(intent);

    }

}
