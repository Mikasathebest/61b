public class Palindrome {

    /** Given a String, wordToDeque should return a Deque
     * where the characters appear in the same order as in the String.
     * For example, if the word is “persiflage”,
     * then the returned Deque should have ‘p’ at the front, followed by ‘e’,
     * and so forth.*/
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    /** The isPalindrome method should return true if the given word is a palindrome,
     * and false otherwise.*/
    public boolean isPalindrome(String word) {
        Deque<Character> w = wordToDeque(word);
        if (w.size() < 2) {
            return true;
        }
        while (w.size() >= 2) {
            if (w.removeFirst() != w.removeLast()) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }


    public boolean isPalindromeRecursive(String word) {
        Deque<Character> w = wordToDeque(word);
        return isPalindromeHelper(w);
    }

    private boolean isPalindromeHelper(Deque<Character> w) {
        if (w.size() < 2) {
            return true;
        }
        if (w.removeLast() == w.removeFirst()) {
            return isPalindromeHelper(w);
        } else {
            return false;
        }
    }

}
