package com.pichangetheworld.programmingchallenges.problems.inclusivelists;

import java.util.List;

/**
 * Interface
 */
public interface DiffFinderInterface {
    // Returns a list of strings that are present in listB but not in listViewA
    List<String> findDiff(List<String> listA, List<String> listB);
}
