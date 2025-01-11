package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void constructKPalindromeStringsTest() {

        assertTrue(LeetCodeAttempt.constructKPalindromeStrings("annabelle", 2));
        assertFalse(LeetCodeAttempt.constructKPalindromeStrings("leetcode", 3));
        assertTrue(LeetCodeAttempt.constructKPalindromeStrings("true", 4));

    }

}
