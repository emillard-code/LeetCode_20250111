package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(constructKPalindromeStrings("annabelle", 2));
        System.out.println(constructKPalindromeStrings("leetcode", 3));
        System.out.println(constructKPalindromeStrings("true", 4));

    }

    public static boolean constructKPalindromeStrings(String s, int k) {

        int singles = 0;
        int doubles = 0;

        StringBuilder sBuilder = new StringBuilder(s);

        for (int i = 0; i < sBuilder.length(); i++) {

            String currentChar = String.valueOf(sBuilder.charAt(i));
            sBuilder.deleteCharAt(0);

            if (sBuilder.indexOf(currentChar) == -1) {
                singles++;
            } else {
                sBuilder.deleteCharAt(sBuilder.indexOf(currentChar));
                doubles++;
            }

            i--;

        }

        if (singles > k) { return false; }
        if (singles == k) { return true; }
        if ((singles + doubles) >= k) { return true; }

        return false;

    }

}
