package com.pichangetheworld.programmingchallenges;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.security.SecureRandom;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Base Activity class
 */
public class ProblemActivity extends AppCompatActivity {
    @Bind(R.id.list_a)
    ListView listA;
    @Bind(R.id.list_b)
    ListView listB;

    @Bind(R.id.result_list)
    ListView resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_inclusive_lists);

        ButterKnife.bind(this);

        RandomAdapter adapterA = new RandomAdapter(this);
        RandomAdapter adapterB = new RandomAdapter(this);
        RandomAdapter resultAdapter = new RandomAdapter(this);

        listA.setAdapter(adapterA);
        listB.setAdapter(adapterB);
        resultList.setAdapter(resultAdapter);

        for (int i = 0; i < 5; ++i) {
            String str = generateRandomString(5);
            adapterB.add(str);

            if (rnd.nextBoolean()) {
                adapterA.add(str);
            }
        }
        adapterA.notifyDataSetChanged();
        adapterB.notifyDataSetChanged();
    }

    private static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    private String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();

    }

    private static class RandomAdapter extends ArrayAdapter<String> {
        public RandomAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_1);
        }
    }
}
