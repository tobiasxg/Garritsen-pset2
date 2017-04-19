package com.example.tobias.stories;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class IntroActivity extends AppCompatActivity {

    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        }

    public void start(View view) {
        Intent i = new Intent(this, WordsActivity.class);
        input = (EditText) findViewById(R.id.inputNum);
        String storyString = input.getText().toString();
        int storyNum = 0;
        try {
            storyNum = Integer.parseInt(storyString);
        }
        catch (NumberFormatException ex ){
        }
        i.putExtra("num", storyNum);
        startActivity(i);
        finish();
    }
}