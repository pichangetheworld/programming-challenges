package com.pichangetheworld.programmingchallenges;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Base Activity class
 */
public class ProblemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, InclusiveListsProblemFragment.getInstance())
                .commit();
    }
}
