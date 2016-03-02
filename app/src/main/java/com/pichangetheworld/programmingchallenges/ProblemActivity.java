package com.pichangetheworld.programmingchallenges;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Base Activity class
 */
public class ProblemActivity extends AppCompatActivity {
    private static final String EXTRA_PROBLEM_ENUM = "problemEnum";

    @Bind(android.R.id.content)
    FrameLayout contentView;

    Problem problem;

    public static Intent createIntent(Context context, Problem problem) {
        Intent intent = new Intent(context, ProblemActivity.class);
        intent.putExtra(EXTRA_PROBLEM_ENUM, problem);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        problem = (Problem) getIntent().getSerializableExtra(EXTRA_PROBLEM_ENUM);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(problem.getTitle());
        }

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, problem.getFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_help:
                Snackbar.make(contentView, problem.getDescription(), Snackbar.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
