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
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("horse"));

        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("bbb"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
    }

    @Test
    public void testIsPalindromeRecursive() {
        assertFalse(palindrome.isPalindromeRecursive("cat"));
        assertFalse(palindrome.isPalindromeRecursive("horse"));

        assertTrue(palindrome.isPalindromeRecursive("a"));
        assertTrue(palindrome.isPalindromeRecursive("bbb"));
        assertTrue(palindrome.isPalindromeRecursive(""));
        assertTrue(palindrome.isPalindromeRecursive("racecar"));
        assertTrue(palindrome.isPalindromeRecursive("noon"));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("", cc));

        assertFalse(palindrome.isPalindrome("abz", cc));
        assertFalse(palindrome.isPalindrome("horse", cc));
        assertFalse(palindrome.isPalindrome("aaa", cc));
    }
}
