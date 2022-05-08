public class OffByOne implements CharacterComparator {


    /** This function should implement CharacterComparator
     * such that equalChars returns true for characters that are different by exactly one. */
    @Override
    public boolean equalChars(char x, char y) {
        if ((64 < x && x < 91) || (96 < x && x < 122)) {
            if ((64 < y && y < 91) || (96 < y && y < 122)) {
                int subtract = Math.abs(x - y);
                return (subtract == 1);
            }
        }
        return false;
    }
}
