/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;

        Palindrome palindrome = new Palindrome();

        // Find out what N are there the most palindromes in English?
        int mostPalindrome = -1;
        int N = -1;
        String longestWord = "";
        int longestWordSize = 0;
        for (int i = 0; i <= 26; i++) {
            In in = new In("../library-sp18/data/words.txt");
            CharacterComparator offByi= new OffByN(i);
            int currentPalindrome = 0;
            while (!in.isEmpty()) {
                String word = in.readString();
                Deque<Character> c = palindrome.wordToDeque(word);
                if (word.length() >= minLength && palindrome.isPalindrome(word, offByi)) {
                    //System.out.println(word);
                    currentPalindrome += 1;
                    if (c.size() > longestWordSize) {
                        longestWordSize = c.size();
                        longestWord = word;
                    }
                }
            }
            if (currentPalindrome > mostPalindrome) {
                mostPalindrome = currentPalindrome;
                N = i;

            }
        }
        System.out.println(N + " has most palindrome: " + mostPalindrome);
        System.out.println(longestWord + " is longest palindrome with size: " + longestWordSize);
    }
}
