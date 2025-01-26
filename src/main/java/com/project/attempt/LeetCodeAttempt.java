package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(constructKPalindromeStrings("annabelle", 2));
        System.out.println(constructKPalindromeStrings("leetcode", 3));
        System.out.println(constructKPalindromeStrings("true", 4));

    }

    // This method will return k palindromes that can be created from string s.
    public static boolean constructKPalindromeStrings(String s, int k) {

        // We'll count how many characters come by themselves and how many characters come in pairs
        // later. This is important for palindromes. In cases where there are 3 or more of the same
        // character in the string, we will put as many of them as possible together as pairs, and if
        // any is still left then count that one as a single character on its own. In other words, an
        // even number of the same characters will all count towards int doubles, and an odd number of
        // the same characters will mean that one of those characters will count towards int singles
        // while the rest are counted towards int doubles.
        int singles = 0;
        int doubles = 0;

        StringBuilder sBuilder = new StringBuilder(s);

        // We will loop through every character in the string. We will test whether each
        // character is on its own in the string, or if there is more than one of that character.
        for (int i = 0; i < sBuilder.length(); i++) {

            // To test whether a character is on its own or part of a pair, we delete the current
            // character from the StringBuilder then check to see any more of the same character
            // is still left in the StringBuilder or not. If not, the character is on its own and
            // int singles is incremented. If another identical character can be found in the
            // StringBuilder still, then the current character is part of a pair, and we increment
            // int doubles. This is set up in such a way such that if there is 3 or more of the same
            // character in string s, and there's an odd number of them, 1 will inevitably be left
            // on its own and be counted towards int singles. This is intentional and desired behavior.
            String currentChar = String.valueOf(sBuilder.charAt(i));
            sBuilder.deleteCharAt(0);

            if (sBuilder.indexOf(currentChar) == -1) {
                singles++;
            } else {
                sBuilder.deleteCharAt(sBuilder.indexOf(currentChar));
                doubles++;
            }

            // Since we deleted a character, we decrement i to account for that fact.
            i--;

        }

        // If there are more single characters than the value of k, then it is impossible to construct
        // k number of palindromes. The reason for this is that a palindrome must be the same going
        // forwards and backwards. In other words, the same characters must exist on both sides of a
        // palindrome. The -only- time a 'unique' character can exist inside a palindrome is if there
        // is an odd number of characters and the 'unique' character is exactly in the middle, so that
        // it is the same whether you read it forwards or backwards. With this logic in mind, we can
        // only afford to insert one 'unique' character into each possible palindrome. If we want to
        // construct k number of palindromes, and we have to use all characters in the string to do so,
        // then this becomes impossible when the number of unique characters exceed k. We have nowhere
        // to put the single/unique characters after having used up the first k amount of them.
        if (singles > k) { return false; }

        // If the amount of single/unique characters equal *exactly* k, then we can confidently return
        // true. This is because each unique character can either be placed on its own ("Q" is
        // technically a palindrome for example), or can be placed in the middle of a pair of identical
        // characters. Since every other character will come in pairs, we can easily place them in any
        // of the palindromes and there will be no issue, as all of them can be tacked on to the front
        // and back of a palindrome string while still keeping it a palindrome.
        if (singles == k) { return true; }

        // If there are less single/unique characters than k, then the combined value of int singles
        // and int doubles must be equal to or surpass k for the method to return true. The reason for
        // this is that each single/unique character can be its own palindrome string, and each pair of
        // characters can also be its own palindrome string, and these hypothetical palindromes are
        // actually the absolute most "cost-efficient" and minimal way of forming them from string s. As
        // such, to reach k number of palindrome strings (from string s), int singles + int doubles at
        // the very least must equal k so that the bare minimum palindromes can be formed from them to
        // add up to a k amount of them. Anything less and we will not be able to form k palindromes.
        if ((singles + doubles) >= k) { return true; }

        // If none of the true conditions were met, we ultimately return false at this point.
        return false;

    }

}
