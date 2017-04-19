package com.example.tobias.stories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class WordsActivity extends AppCompatActivity {

        Story story;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_words);

            Intent i = getIntent();
            int num = i.getIntExtra("num", 0);
            String madlibFile = getMadlib(num);

            InputStream readFile = null;
            AssetManager assetmanager = getAssets();

            try {
                readFile = assetmanager.open(madlibFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            story = new Story(readFile);
            EditText inputWord = (EditText) findViewById(R.id.inputWord);
            inputWord.setHint(story.getNextPlaceholder());

            TextView remaining = (TextView) findViewById(R.id.wordsView);
            remaining.setText(Integer.toString(story.getPlaceholderRemainingCount())+" word(s) left");
        }

    public void onClick(View view) {
        EditText inputWord = (EditText) findViewById(R.id.inputWord);
        story.fillInPlaceholder(inputWord.getText().toString());

        TextView remaining = (TextView) findViewById(R.id.wordsView);
        remaining.setText(Integer.toString(story.getPlaceholderRemainingCount())+" word(s) left");

        if (story.getPlaceholderRemainingCount() != 0) {
            inputWord.setText("");
            inputWord.setHint(story.getNextPlaceholder());
        } else {
            Intent storyIntent = new Intent(this, StoryActivity.class);
            String finalMadlib = story.toString();
            storyIntent.putExtra("madlib", finalMadlib);
            startActivity(storyIntent);
            finish();
        }
    }

    private String getMadlib(int num) {
        String madlibFile = "madlib0_simple.txt";
        switch(num) {
            case 1:
                madlibFile = "madlib1_tarzan.txt";
                return madlibFile;
            case 2:
                madlibFile = "madlib2_university.txt";
                return madlibFile;
            case 3:
                madlibFile = "madlib3_clothes.txt";
                return madlibFile;
            case 4:
                madlibFile = "madlib4_dance.txt";
                return madlibFile;
        }
        return madlibFile;
    }
}