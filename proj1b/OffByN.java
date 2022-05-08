public class OffByN implements CharacterComparator {
    private int N;


    @Override
    public boolean equalChars(char x, char y) {

        if ((inUpperAlphabet(x) && inUpperAlphabet(y)) ||
            (inLowerAlphabet(x) && inLowerAlphabet(y))) {
            int subtract = Math.abs(x - y);
            return (subtract == N);
        } else {
            return false;
        }
    }

    /** Judge if a given char in A-Z*/
    private boolean inUpperAlphabet(char c) {
        if (64 < c && c < 91) {
            return true;
        } else {
            return false;
        }
    }
    /** Judge if a given char in a-z*/
    private boolean inLowerAlphabet(char c) {
        if (96 < c && c < 123) {
            return true;
        } else {
            return false;
        }
    }

    public OffByN(int n) {
        N = n;
    }
}
