public class PalindromeChecker {

    // Private field to store the string
    private String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Public method to check palindrome
    public boolean checkPalindrome() {

        // Normalize string (optional: ignore spaces & case)
        String normalized = text.replaceAll("\\s+", "").toLowerCase();

        // Use two-pointer technique
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // Optional: setter method to update text
    public void setText(String text) {
        this.text = text;
    }

    // Optional: getter method
    public String getText() {
        return text;
    }

    // Main method for demonstration
    public static void main(String[] args) {

        PalindromeChecker checker = new PalindromeChecker("Able was I ere I saw Elba");

        if (checker.checkPalindrome()) {
            System.out.println("\"" + checker.getText() + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + checker.getText() + "\" is NOT a Palindrome.");
        }
    }
}