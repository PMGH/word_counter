package com.example.peter.wordcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static android.R.attr.key;
import static com.example.peter.wordcounter.R.id.phrase;
import static com.example.peter.wordcounter.R.id.wordOccurrences;

public class MainActivity extends AppCompatActivity {

    private EditText phraseEditText;
    private Button showWordCountButton;
    private TextView wordCountTextView;
    private TextView wordOccurrencesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phraseEditText = (EditText) findViewById(phrase);
        showWordCountButton = (Button) findViewById(R.id.showWordCountBtn);
        wordCountTextView = (TextView) findViewById(R.id.wordCount);
        wordOccurrencesTextView = (TextView) findViewById(wordOccurrences);
    }

    public void showWordCountOnClick(View button){
        Phrase phrase = new Phrase(phraseEditText.getText().toString());

        // total word count
        int wordCount = phrase.getWordCount();
        String wordCountStr = Integer.toString(wordCount);
        wordCountTextView.setText("Total Words:  " + wordCountStr);

        // word count for each word in phrase (excludes special characters)
        Set wordOccurrencesSet = phrase.getWordsHashAsSet();
        wordOccurrencesTextView.setText("Word Occurrences:\n" + wordOccurrencesSet);
    }
}
