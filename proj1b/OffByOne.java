public class OffByOne implements CharacterComparator {


    /** This function should implement CharacterComparator
     * such that equalChars returns true for characters that are different by exactly one. */
    @Override
    public boolean equalChars(char x, char y) {
        int subtract = Math.abs(x - y);
        return (subtract == 1);
    }
}
