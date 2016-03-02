package com.pichangetheworld.programmingchallenges;

import android.support.v4.app.Fragment;

/**
 * Enumeration of all the problems
 *
 */
public enum Problem {
    INCLUSIVE_LISTS;

    public String getTitle() {
        switch (this) {
            case INCLUSIVE_LISTS:
                return "Inclusive Lists";
            default:
                return "Default Problem";
        }
    }

    public String getDescription() {
        switch (this) {
            case INCLUSIVE_LISTS:
                return "Goal: Given two lists ListA and ListB, return the set of elements in ListB not in ListA";
            default:
                return "";
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
