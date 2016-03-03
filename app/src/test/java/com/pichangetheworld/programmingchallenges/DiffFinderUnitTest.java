package com.pichangetheworld.programmingchallenges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class DiffFinderUnitTest {

    /*
     * DiffFinder:
     *
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

    DiffFinder diffFinder = new DiffFinder();

    @Test
    public void caseA_isCorrect() throws Exception {
        List<String> result = diffFinder.findDiff(
                Arrays.asList("one", "three"),
                Arrays.asList("one", "two", "three", "four", "five"));
        assertArrayEquals(result.toArray(), new String[]{"two", "four", "five"});
    }

    @Test
    public void caseB_isCorrect() throws Exception {
        List<String> result = diffFinder.findDiff(
                Arrays.asList("ken", "nanri"),
                Arrays.asList("bon", "ken", "nanri", "okada", "ryu"));
        assertArrayEquals(result.toArray(), new String[]{"bon", "okada", "ryu"});
    }

    @Test
    public void equalListAAndB() throws Exception {
        List<String> result = diffFinder.findDiff(
                Collections.singletonList("aaa"),
                Collections.singletonList("aaa"));
        assertTrue(result.isEmpty());
    }

    @Test
    public void emptyListA() throws Exception {
        List<String> result = diffFinder.findDiff(
                new ArrayList<String>(),
                Arrays.asList("one", "two", "three", "four", "five"));
        assertArrayEquals(result.toArray(), new String[]{"one", "two", "three", "four", "five"});
    }

    @Test
    public void duplicateTest() throws Exception {
        List<String> result = diffFinder.findDiff(
                Collections.singletonList("aaa"),
                Arrays.asList("aa", "aaa", "aaa", "aaa", "aaaa"));
        assertArrayEquals(result.toArray(), new String[]{"aa", "aaaa"});
    }
}