package com.pichangetheworld.programmingchallenges;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Base Activity class
 */
public class ProblemActivity extends AppCompatActivity {
    private static final String EXTRA_PROBLEM_ENUM = "problemEnum";

    public static Intent createIntent(Context context, Problem problem) {
        Intent intent = new Intent(context, ProblemActivity.class);
        intent.putExtra(EXTRA_PROBLEM_ENUM, problem);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Problem problem = (Problem) getIntent().getSerializableExtra(EXTRA_PROBLEM_ENUM);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, problem.getFragment())
                .commit();
    }
}
