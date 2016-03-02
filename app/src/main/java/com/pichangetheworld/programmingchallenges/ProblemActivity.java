package com.pichangetheworld.programmingchallenges;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Base Activity class
 */
public class ProblemActivity extends AppCompatActivity {
    @Bind(R.id.list_a)
    ListView listViewA;
    @Bind(R.id.list_b)
    ListView listViewB;

    @Bind(R.id.result_list)
    ListView resultListView;

    @OnClick(R.id.reset)
    void reset() {
        listA.clear();
        listB.clear();
        resultList.clear();

        for (int i = 0; i < 5; ++i) {
            String str = generateRandomString(5);
            listB.add(str);

            if (rnd.nextBoolean()) {
                listA.add(str);
            }
        }
        adapterA.notifyDataSetChanged();
        adapterB.notifyDataSetChanged();
        resultAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.calculate)
    void calculateDiff() {
        resultList.clear();
        resultList.addAll(new DiffFinder().findDiff(listA, listB));
        resultAdapter.notifyDataSetChanged();
    }

    List<String> listA = new ArrayList<>();
    List<String> listB = new ArrayList<>();
    List<String> resultList = new ArrayList<>();
    RandomAdapter adapterA;
    RandomAdapter adapterB;
    RandomAdapter resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_inclusive_lists);

        ButterKnife.bind(this);

        adapterA = new RandomAdapter(this, listA);
        adapterB = new RandomAdapter(this, listB);
        resultAdapter = new RandomAdapter(this, resultList);

        listViewA.setAdapter(adapterA);
        listViewB.setAdapter(adapterB);
        resultListView.setAdapter(resultAdapter);

        reset();
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
        public RandomAdapter(Context context, List<String> stringList) {
            super(context, android.R.layout.simple_list_item_1, stringList);
        }
    }
}
