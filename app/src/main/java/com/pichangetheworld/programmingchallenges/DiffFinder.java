package com.pichangetheworld.programmingchallenges;

import java.util.List;

/**
 * For bon to implement
 */
public class DiffFinder implements DiffFinderInterface {
    /*
     * Returns a list of strings that are present in listB but not in listA
     *
     * e.g. If ListA = {"one", "three"}, ListB = {"one", "two", "three", "four", "five"}
     *      --> return {"two", "four", "five"}
     *
     * e.g. If ListA = {"ken", "nanri"}, ListB = {"bon", "ken", "nanri", "okada", "ryu"}
     *      --> return {"bon", "okada", "ryu"}
     *
     * e.g. If ListA = {"aaa"}, ListB = {"aaa"}
     *      --> return {} <- empty list
     *
     * e.g. If ListA = {}, ListB = {"one", "two", "three", "four", "five"}
     *      --> return {"one", "two", "three", "four", "five"}
     */
    @Override
    public List<String> findDiff(List<String> listA, List<String> listB) {
        // TODO implement this

        for (int i = 0; i < listA.size(); i++) {
            String aItem = listA.get(i);

            for (int j = 0; j < listB.size(); j++) {
                String bItem = listB.get(j);

                if (aItem.equals(bItem)) {
                    listB.remove(j);
                }
            }
        }

        return listB;
    }
}
