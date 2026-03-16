import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeCheckerApp {

    // 1. Two-pointer method
    public static boolean twoPointer(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start++) != normalized.charAt(end--)) return false;
        }
        return true;
    }

    // 2. Stack method
    public static boolean stackMethod(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray())
            if (ch != stack.pop()) return false;
        return true;
    }

    // 3. Deque method
    public static boolean dequeMethod(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // 4. Recursive method
    public static boolean recursiveMethod(String text, int start, int end) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        if (start >= end) return true;
        if (normalized.charAt(start) != normalized.charAt(end)) return false;
        return recursiveMethod(normalized, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String testString = "Able was I ere I saw Elba";

        // Two-pointer
        long start = System.nanoTime();
        boolean result1 = twoPointer(testString);
        long duration1 = System.nanoTime() - start;

        // Stack
        start = System.nanoTime();
        boolean result2 = stackMethod(testString);
        long duration2 = System.nanoTime() - start;

        // Deque
        start = System.nanoTime();
        boolean result3 = dequeMethod(testString);
        long duration3 = System.nanoTime() - start;

        // Recursive
        start = System.nanoTime();
        boolean result4 = recursiveMethod(testString, 0, testString.replaceAll("\\s+", "").length() - 1);
        long duration4 = System.nanoTime() - start;

        // Display results
        System.out.println("Palindrome Check Results for: \"" + testString + "\"\n");

        System.out.printf("Two-Pointer: %s (Time: %d ns)\n", result1 ? "Palindrome" : "Not Palindrome", duration1);
        System.out.printf("Stack      : %s (Time: %d ns)\n", result2 ? "Palindrome" : "Not Palindrome", duration2);
        System.out.printf("Deque      : %s (Time: %d ns)\n", result3 ? "Palindrome" : "Not Palindrome", duration3);
        System.out.printf("Recursive  : %s (Time: %d ns)\n", result4 ? "Palindrome" : "Not Palindrome", duration4);
    }
}