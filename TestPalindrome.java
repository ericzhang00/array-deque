import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("11"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("yes"));
        assertFalse(palindrome.isPalindrome("racecar "));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertFalse(palindrome.isPalindrome("aaaaaab"));
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("aabb", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("ab", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("cob", cc));
        assertFalse(palindrome.isPalindrome("cob ", cc));
        assertFalse(palindrome.isPalindrome("noon", cc));
        assertFalse(palindrome.isPalindrome("yes", cc));
        assertFalse(palindrome.isPalindrome("Racecar", cc));
        assertFalse(palindrome.isPalindrome("AaAA", cc));
        assertFalse(palindrome.isPalindrome("AA", cc));
        cc = new OffByN(2);
        assertTrue(palindrome.isPalindrome("aacc", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertFalse(palindrome.isPalindrome("aabb", cc));
        assertFalse(palindrome.isPalindrome("aa", cc));
    }
}
