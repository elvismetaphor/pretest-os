package me.elvismetaphor.question;

import java.util.HashSet;
import java.util.Set;

public class SubsetChecker {

    public boolean isSubset(char[] first, char[] second) {
        Set<Character> set = generateCharacterSet(first);
        return containsAll(set, second);
    }

    private Set<Character> generateCharacterSet(char[] chars) {
        Set<Character> result = new HashSet();
        for (char c : chars) {
            result.add(c);
        }

        return result;
    }

    private boolean containsAll(Set<Character> set, char[] targets) {
        for (char target : targets) {
            if (!set.contains(target)) return false;
        }

        return true;
    }
}
