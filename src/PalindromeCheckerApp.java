import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String text);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        for (char ch : text.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : text.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String text) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context class
class PalindromeCheckerContext {

    private PalindromeStrategy strategy;

    // Inject strategy dynamically
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String text) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.checkPalindrome(text);
    }
}

// Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String text = "radar";

        PalindromeCheckerContext context = new PalindromeCheckerContext();

        // Use Stack strategy
        context.setStrategy(new StackStrategy());
        System.out.println("Stack Strategy: " + (context.executeStrategy(text) ? "Palindrome" : "Not Palindrome"));

        // Use Deque strategy
        context.setStrategy(new DequeStrategy());
        System.out.println("Deque Strategy: " + (context.executeStrategy(text) ? "Palindrome" : "Not Palindrome"));
    }
}