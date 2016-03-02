package com.pichangetheworld.programmingchallenges.problems.stringreversal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pichangetheworld.programmingchallenges.R;

import java.security.SecureRandom;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Base Activity class
 */
public class StringReversalProblemFragment extends Fragment {
    @Bind(R.id.problem_string)
    TextView problemStringView;
    @Bind(R.id.result_string)
    TextView resultStringView;

    @OnClick(R.id.reset)
    void reset() {
        problemStringView.setText("");
        resultStringView.setText("");

        String str = generateRandomString(5);
        problemStringView.setText(str);
    }

    @OnClick(R.id.calculate)
    void calculate() {

    }

    public static Fragment getInstance() {
        return new StringReversalProblemFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.problem_string_reversal, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

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
}
