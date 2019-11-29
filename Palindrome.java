public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque result = new ArrayDeque();
        for (int index = 0; index < word.length(); index = index + 1) {
            result.addLast(word.charAt(index));
        }
        return result;
    }

    private String dequeToWord(Deque d) {
        String word2 = "";
        while (!d.isEmpty()) {
            word2 = word2 + d.removeFirst();
        }
        return word2;
    }

    public boolean isPalindrome(String word) {
        Deque newWord = wordToDeque(word);
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        if (newWord.removeFirst() == newWord.removeLast()) {
            return isPalindrome(dequeToWord(newWord));
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque newWord = wordToDeque(word);
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        if (cc.equalChars(word.charAt(0), word.charAt(word.length() - 1))) {
            newWord.removeFirst();
            newWord.removeLast();
            return isPalindrome(dequeToWord(newWord), cc);
        }
        return false;
    }
}
