package com.example.tobias.stories;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent i = getIntent();
        String createdStory = i.getStringExtra("madlib");
//        Bundle extras = getIntent().getExtras();
//        String createdStory = extras.getString("madlib");
        TextView showStory = (TextView) findViewById(R.id.story);
        // displays the user's story
        showStory.setText(createdStory);
    }

    public void replay(View view) {
        Intent replayIntent = new Intent(this, IntroActivity.class);
        startActivity(replayIntent);
        finish();
    }
}