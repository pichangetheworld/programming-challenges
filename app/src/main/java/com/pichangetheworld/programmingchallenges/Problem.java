package com.pichangetheworld.programmingchallenges;

import android.support.v4.app.Fragment;

import com.pichangetheworld.programmingchallenges.problems.inclusivelists.InclusiveListsProblemFragment;
import com.pichangetheworld.programmingchallenges.problems.stringreversal.StringReversalProblemFragment;

/**
 * Enumeration of all the problems
 *
 */
public enum Problem {
    INCLUSIVE_LISTS,
    STRING_REVERSAL;

    public int getTitle() {
        switch (this) {
            case INCLUSIVE_LISTS:
                return R.string.problem_inclusive_lists;
            case STRING_REVERSAL:
                return R.string.problem_string_reversal;
            default:
                return R.string.default_problem;
        }
    }

    public int getDescription() {
        switch (this) {
            case INCLUSIVE_LISTS:
                return R.string.problem_inclusive_lists_desc;
            case STRING_REVERSAL:
                return R.string.problem_string_reversal_desc;
            default:
                return 0;
        }
    }

    public Fragment getFragment() {
        switch (this) {
            case INCLUSIVE_LISTS:
                return InclusiveListsProblemFragment.getInstance();
            case STRING_REVERSAL:
                return StringReversalProblemFragment.getInstance();
            default:
                return null;
        }
    }
}
