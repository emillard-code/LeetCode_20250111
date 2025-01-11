package com.project;

import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeSolutionTest {

    @Test
    public void canConstructTest() {

        assertTrue(LeetCodeSolution.canConstruct("annabelle", 2));
        assertFalse(LeetCodeSolution.canConstruct("leetcode", 3));
        assertTrue(LeetCodeSolution.canConstruct("true", 4));

    }

}
