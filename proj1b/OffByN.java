public class OffByN implements CharacterComparator {
    private int N;


    @Override
    public boolean equalChars(char x, char y) {
        int subtract = Math.abs(x - y);
        return (subtract == N);
    }

    public OffByN(int n) {
        N = n;
    }
}
