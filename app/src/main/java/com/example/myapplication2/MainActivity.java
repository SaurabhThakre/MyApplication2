package com.example.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

import androidx.constraintlayout.widget.ConstraintLayout;


public class MainActivity extends Activity {

    String msg = "Android : ";
    EditText et1;
    ToggleButton tb;
    ConstraintLayout cl;
    Button but2,btn;
    Spinner spinner;
    public static int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event");

        spinner = findViewById(R.id.days);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.days_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        et1  = findViewById(R.id.et);
        btn = findViewById(R.id.cancel);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the first EditText empty
                et1.setText("");
            }
        });

        cl = findViewById(R.id.activity1);
        tb = findViewById(R.id.toggle);
        but2 = findViewById(R.id.button2);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked)
                {
                    et1.setBackgroundColor(Color.parseColor("#121212"));
                    et1.setTextColor(Color.parseColor("#ffffff"));
                    cl.setBackgroundColor(Color.parseColor("#1F1B24"));
                    tb.setBackgroundColor(Color.parseColor("#BB86FC"));
                    but2.setBackgroundColor(Color.parseColor("#BB86FC"));
                    btn.setBackgroundColor(Color.parseColor("#BB86FC"));
                    tb.setTextColor(Color.parseColor("#000000"));
                    but2.setTextColor(Color.parseColor("#000000"));
                    btn.setTextColor(Color.parseColor("#000000"));
                    spinner.setBackgroundColor(Color.parseColor("#03DAC5"));
                    // Status Bar Color
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#BB86FC"));
                }
                else
                {
                    et1.setBackgroundColor(Color.parseColor("#ffffff"));
                    et1.setTextColor(Color.parseColor("#000000"));
                    cl.setBackgroundColor(Color.parseColor("#BBDEFB"));
                    tb.setBackgroundColor(Color.parseColor("#00897B"));
                    but2.setBackgroundColor(Color.parseColor("#00897B"));
                    btn.setBackgroundColor(Color.parseColor("#00897B"));
                    tb.setTextColor(Color.parseColor("#ffffff"));
                    but2.setTextColor(Color.parseColor("#ffffff"));
                    btn.setTextColor(Color.parseColor("#ffffff"));
                    spinner.setBackgroundColor(Color.parseColor("#ffffff"));
                    // Status Bar Color
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#00897B"));
                }
            }
        });

        Intent startingIntent = getIntent();
        String t1 = startingIntent.getStringExtra("username");
        String t2 = startingIntent.getStringExtra("password");
        et1.setText(t1);
        et1.setText("Username: " + et1.getText() + "\n" + "Password: " +  t2);
        if(x == 0)
        et1.setText("");

    }


    public void goToActivity2(View v){
        Intent intent = new Intent(this, Main2Activity.class);
        x = 1;
        startActivity(intent);
    }

    public void goToApp(View v){
        Intent YouTube = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
        startActivity(YouTube);
    }

    public void editText1(View v){

        et1.setText("");
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }
}
