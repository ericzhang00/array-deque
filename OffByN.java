public class OffByN implements CharacterComparator {
    private int difference;
    public OffByN(int N) {
        this.difference = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return x - this.difference == y || y - this.difference == x;
    }
}
