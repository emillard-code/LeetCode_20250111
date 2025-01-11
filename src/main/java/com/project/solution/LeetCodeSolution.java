package com.project.solution;

public class LeetCodeSolution {

    public static void main(String[] args) {

        System.out.println(canConstruct("annabelle", 2));
        System.out.println(canConstruct("leetcode", 3));
        System.out.println(canConstruct("true", 4));

    }

    public static boolean canConstruct(String s, int k) {

        // Handle edge cases
        if (s.length() < k) return false;
        if (s.length() == k) return true;

        // Initialize frequency array and oddCount
        int[] freq = new int[26];
        int oddCount = 0;

        // Increment the value of the index corresponding to the current character
        for (char chr : s.toCharArray()) { freq[chr - 'a']++; }

        // Count the number of characters that appear an odd number of times in s
        for (int count : freq) {
            if (count % 2 == 1) { oddCount++; }
        }

        // Return if the number of odd frequencies is less than or equal to k
        return oddCount <= k;

    }

}
