package com.pichangetheworld.programmingchallenges;

import android.support.v4.app.Fragment;

/**
 * Enumeration of all the problems
 *
 */
public enum Problem {
    INCLUSIVE_LISTS;

    public int getTitle() {
        switch (this) {
            case INCLUSIVE_LISTS:
                return R.string.problem_inclusive_lists;
            default:
                return R.string.default_problem;
        }
    }

    public int getDescription() {
        switch (this) {
            case INCLUSIVE_LISTS:
                return R.string.problem_inclusive_lists_desc;
            default:
                return 0;
        }
    }

    public Fragment getFragment() {
        switch (this) {
            case INCLUSIVE_LISTS:
                return InclusiveListsProblemFragment.getInstance();
            default:
                return null;
        }
    }
}
